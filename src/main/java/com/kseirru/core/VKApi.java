package com.kseirru.core;

import com.google.gson.JsonObject;
import com.kseirru.errors.VKException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class VKApi {
    private final HTTPClient httpClient = new HTTPClient();
    private final String VK_API = "https://api.vk.com/method/";
    private final String API_VERSION = "5.131";
    private final Integer longPollVersion = 3;
    private final String token;
    private String longPollServer;
    private String longPollKey;
    private Long ts;

    public static Logger logger = LoggerFactory.getLogger("VKApi");

    public VKApi(String token) {
        this.token = token;
    }

    private void getLongPollData() throws VKException {
        HashMap<String, Object> args = new HashMap<>();
        args.put("lp_version", this.longPollVersion);
        args.put("access_token", this.token);
        args.put("v", this.API_VERSION);

        JsonObject getLongPollServer = this.httpClient.sendGetRequest(this.VK_API + "messages.getLongPollServer", args);
        try {
            JsonObject data = getLongPollServer.get("response").getAsJsonObject();
            this.longPollServer = "https://" + data.get("server").getAsString();
            this.longPollKey = data.get("key").getAsString();
            this.ts = data.get("ts").getAsLong();
            logger.info("Long poll information received.");
        } catch (NullPointerException e) {
            JsonObject error = getLongPollServer.get("error").getAsJsonObject();
            String errorStringFormat = "Error code: %s. %s";
            String errorString = errorStringFormat.formatted(error.get("error_code").getAsInt(), error.get("error_msg").getAsString());
            logger.error("An error occurred while receiving Long poll information.");
            throw new VKException(errorString);
        }
    }

    private void handleLongPoll() throws VKException {
        try {
            while (true) {
                HashMap<String, Object> args = new HashMap<>();
                args.put("key", this.longPollKey);
                args.put("act", "a_check");
                args.put("ts", this.ts);
                args.put("wait", 25);
                args.put("version", this.longPollVersion);

                JsonObject response = this.httpClient.sendGetRequest(this.longPollServer, args);
                if (response.get("ts").getAsLong() != this.ts) {
                    this.ts = response.get("ts").getAsLong();
                }

            }
        } catch (Exception e) {
            throw new VKException(e.getMessage());
        }
    }

    public void run() throws VKException {
        logger.info("Starting...");
        this.getLongPollData();
        this.handleLongPoll();
    }


}
