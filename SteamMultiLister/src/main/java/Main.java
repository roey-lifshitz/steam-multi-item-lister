import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        LinkGenerator linkGenerator = new LinkGenerator();


        ArrayList<String> items = new ArrayList<>();
        items.add("Mann%20Co.%20Supply%20Crate%20Key");
        items.add("Decal%20Tool");
        String url = LinkGenerator.generate("440", items);

        System.out.println(url);
    }
}
