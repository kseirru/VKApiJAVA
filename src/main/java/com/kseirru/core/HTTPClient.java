package com.kseirru.core;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public class HTTPClient {
    private final OkHttpClient httpClient;


    public HTTPClient() {
        this.httpClient = new OkHttpClient();
    }

    public JsonObject sendGetRequest(String URL) {
        Request request = new Request.Builder()
                .url(URL)
                .build();

        try (Response response = this.httpClient.newCall(request).execute()) {
            assert response.body() != null;
            return JsonParser.parseString(response.body().string()).getAsJsonObject();
        } catch (IOException ioException) {
            return null;
        }
    }

    public JsonObject sendGetRequest(String URL, Map<String, Object> data) {
        return this.sendGetRequest(URL + "?" + argsToString(data));
    }

    public static String argsToString(Map<String, Object> data) {
        StringBuilder argsBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            argsBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        return argsBuilder.substring(0, argsBuilder.length() - 1).replace(" ", "%20");
    }
}
