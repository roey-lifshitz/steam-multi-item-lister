package com.roey.multilister;

import netscape.javascript.JSObject;
import org.json.JSONArray;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)  {

        try {
            LinkGenerator linkGenerator = new LinkGenerator();

            ArrayList<String> items = new ArrayList<>();
            items.add("Mann%20Co.%20Supply%20Crate%20Key");
            items.add("Decal%20Tool");
            //440
            String url = linkGenerator.generate("Team Fortress 2", items);

            System.out.println(url);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
