package com.kseirru;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kseirru.core.HTTPClient;
import com.kseirru.core.VKApi;
import com.kseirru.errors.VKException;
import com.kseirru.models.VKEventEnum;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws VKException {
        /*
        String token = "vk1.a.UHEU5S-hA_WVuC79C4h1M8HEztEggqPYCLJIKS0voyXfRVlekx1Juv6pAl4SHfMLKnOtAurHd7gMLgiZzpn2ZSIkGAOwUfe7eoYD5W-I0Ay4HKlvpe98iqS59vEsswzdL-HxMAX5MNUXLQhXy9ee11BfrF2FJ1ZbZDnH_tXAQFeRbxTs7dZoZIUcd1Y1Exv-";
        String groupId = "207248247";
        VKApi vkApi = new VKApi(token, groupId);

        vkApi.run();

         */

        System.out.println(VKEventEnum.NewMessageReceivedEvent);

    }
}