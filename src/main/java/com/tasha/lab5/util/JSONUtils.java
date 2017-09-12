package com.tasha.lab5.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONUtils {

    public static JsonObject createJSONFromString(String str) {
        JsonParser parser = new JsonParser();
        return parser.parse(str).getAsJsonObject();
    }
}
