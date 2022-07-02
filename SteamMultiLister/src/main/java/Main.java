import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();
        items.add("Mann%20Co.%20Supply%20Crate%20Key");
        String url = LinkGenerator.generate("440", items);

        System.out.println(url);
    }
}
