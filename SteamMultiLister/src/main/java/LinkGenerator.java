import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class LinkGenerator {

    public static final String FULL_URL_PREFIX = "https://steamcommunity.com/market/multisell?appid=%s&contextid=2";
    public static final String SINGLE_ITEM_PREFIX = "&items%5B%5D=";

    private HashMap<String, Integer> gameIdToNameMap;

    public LinkGenerator() {
        try {
            URL allSteamGamesData = new URL("http://api.steampowered.com/ISteamApps/GetAppList/v0002/");
            HttpURLConnection connection = (HttpURLConnection) allSteamGamesData.openConnection();
            connection.setRequestMethod("GET");

            this.gameIdToNameMap = new HashMap<>();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                gameIdToNameMap.put(inputLine.ge)
            }
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String findGameIDByName(String gameName) {
        return gameName;
    }

    private static String formatItemName(String itemName) {
        return itemName;
    }

    public static String generate(String gameName, ArrayList<String> itemNames) {
        String gameID = findGameIDByName(gameName);
        StringBuilder url = new StringBuilder(FULL_URL_PREFIX.formatted(gameID));

        itemNames.stream()
                .map(LinkGenerator::formatItemName)
                .map(SINGLE_ITEM_PREFIX::concat)
                .forEach(url::append);

        return url.toString();
    }
}
