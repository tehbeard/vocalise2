/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tehbeard.vocalise;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.regex.Pattern;
import org.bukkit.conversations.Prompt;

/**
 *
 * @author James
 */
public class RegexDeserializer implements JsonDeserializer<Pattern>{

    public Pattern deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        return Pattern.compile(je.getAsString());
    }
    
}
