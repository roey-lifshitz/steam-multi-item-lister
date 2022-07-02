import java.util.ArrayList;

public class LinkGenerator {

    public static final String FULL_URL_PREFIX = "https://steamcommunity.com/market/multisell?appid=%s&contextid=2";
    public static final String SINGLE_ITEM_PREFIX = "&items%5B%5D=";


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
