package com.roey.multilister.web;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;


public class Connection {

    private static final int DEFAULT_TIMEOUT = 5000;

    private static String readResponse(HttpURLConnection connection) throws IOException {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        int status = connection.getResponseCode();

        if (status >= 300) {
            inputStreamReader = new InputStreamReader(connection.getErrorStream());
        } else {
            inputStreamReader = new InputStreamReader(connection.getInputStream());
        }

        bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        StringBuilder responseContent = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null) {
            responseContent.append(line);
        }
        responseContent.append("]");
        responseContent.replace(0, 19, "");
        bufferedReader.close();

        return responseContent.toString();
    }

    public static JSONArray getResponse(URL url, RequestType requestType) {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configure request setup
            connection.setRequestMethod(requestType.value);
            connection.setConnectTimeout(DEFAULT_TIMEOUT);
            connection.setReadTimeout(DEFAULT_TIMEOUT);

            String responseContent = readResponse(connection);

            return new JSONArray(responseContent);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
