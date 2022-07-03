package com.roey.multilister;

import com.roey.multilister.web.Connection;
import com.roey.multilister.web.RequestType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class LinkGenerator {
    public static final String FULL_URL_PREFIX = "https://steamcommunity.com/market/multisell?appid=%s&contextid=2";
    public static final String SINGLE_ITEM_PREFIX = "&items%5B%5D=";

    private HashMap<String, String> gameIdToNameMap;

    public LinkGenerator() throws MalformedURLException {

        URL allGamesDataURL = new URL("http://api.steampowered.com/ISteamApps/GetAppList/v0002/");
        JSONArray allGamesData = Connection.getResponse(allGamesDataURL, RequestType.GET);

        this.gameIdToNameMap = new HashMap<>();
        allGamesData.forEach(item -> {
            JSONObject game = (JSONObject) item;
            gameIdToNameMap.put((String)game.get("name"), String.valueOf(game.get("appid")));
        });


        gameIdToNameMap.toString();
    }

    private String findGameIDByName(String gameName) {
        return this.gameIdToNameMap.get(gameName);
    }

    private static String formatItemName(String itemName) {
        return itemName;
    }

    public String generate(String gameName, ArrayList<String> itemNames) {
        String gameID = findGameIDByName(gameName);
        StringBuilder url = new StringBuilder(FULL_URL_PREFIX.formatted(gameID));

        itemNames.stream()
                .map(LinkGenerator::formatItemName)
                .map(SINGLE_ITEM_PREFIX::concat)
                .forEach(url::append);

        return url.toString();
    }
}