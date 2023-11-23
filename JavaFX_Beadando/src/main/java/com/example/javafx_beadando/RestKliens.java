package com.example.javafx_beadando;

import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

public class RestKliens {
    static HttpsURLConnection connection;
    static String token = "ac3cfbe3aff6093675c6c8df54b71a5ad482fcf498d66692ab21c7e54af62e12";
    static String url = "https://gorest.co.in/public/v2/users";
    static void seged1() {
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setUseCaches(false);
        connection.setDoOutput(true);
    }

    static void seged2(String params) throws IOException {
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
        wr.write(params);
        wr.close();
        System.out.println(connection.getResponseMessage());
        connection.connect();
    }
    static String seged3(int code) throws IOException {
        int statusCode = connection.getResponseCode();
        System.out.println("statusCode: " + statusCode);
        StringBuffer jsonResponseData = null;
        if (statusCode == code) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            jsonResponseData = new StringBuffer();
            String readLine = null;

            while((readLine = in.readLine()) != null) {
                jsonResponseData.append(readLine);
            }

            in.close();
        } else {
            System.out.println("Hiba!!!");
            return "Hiba!";
        }

        connection.disconnect();
        System.out.println(jsonResponseData.toString());
        return jsonResponseData.toString();
    }

    static RestUser[] GET(String url) throws IOException {
        System.out.println("\nGET...");
        URL usersUrl = new URL(url);
        connection = (HttpsURLConnection) usersUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer " + token);
        int statusCode = connection.getResponseCode();
        System.out.println("statusCode: " + statusCode);
        String data = null;
        RestUser[] userArray = null;
        if (statusCode == HttpsURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer jsonResponseData = new StringBuffer();
            String readLine = in.readLine();

            Gson gson = new Gson();
            userArray = gson.fromJson(readLine, RestUser[].class);
            in.close();
        } else {
            System.out.println("Hiba!!!");
        }
        connection.disconnect();
        return userArray;

    }

    static String POST(RestUser tagok,String url) throws IOException {
        System.out.println("\nPOST...");

        URL usersUrl = new URL(url);
        connection = (HttpsURLConnection) usersUrl.openConnection();
        connection.setRequestMethod("POST");

        seged1();
        String params = tagok.toString();
        seged2(params);

        return seged3(201);
    }

    static String PUT(RestUser tagok,String url) throws IOException {
        System.out.println("\nPUT...");
        URL postUrl = new URL(url);
        connection = (HttpsURLConnection) postUrl.openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Authorization", "Bearer " + token);
        seged1();
        String params = tagok.toString();
        seged2(params);
        return seged3(200);
    }

    static String DELETE(String url) throws IOException {
        System.out.println("\nDELETE...");
        URL postUrl = new URL(url);
        connection = (HttpsURLConnection) postUrl.openConnection();
        connection.setRequestMethod("DELETE");
        seged1();
        return seged3(204);
    }

}
