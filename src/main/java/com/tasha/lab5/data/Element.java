package com.tasha.lab5.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
public class Element implements Comparable<Element> {

    /** JSON to store */
    private JsonObject value;

    public Element(JsonObject value) {
        this.value = value;
    }

    /**
     * This method contains some logic to compare two Elements.
     * This logic always can be replaced with other if needed
     * @param element - element to compare with
     */
    public int compareTo(Element element) {

        Set<Map.Entry<String, JsonElement>> entriesForThisValue = value.entrySet();
        Set<Map.Entry<String, JsonElement>> entriesForThatValue = element.getValue().entrySet();

        if (entriesForThisValue.size() > entriesForThatValue.size()) {
            return 1;
        } else if (entriesForThisValue.size() < entriesForThatValue.size()) {
            return -1;
        } else {
            return 0;
        }

    }
}
