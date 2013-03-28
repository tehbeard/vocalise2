package com.tehbeard.vocalise.prompts;

import java.lang.reflect.Type;

import org.bukkit.conversations.Prompt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Constructs prompt graphs
 * @author James
 *
 */
public class PromptGraphBuilder implements JsonSerializer<Prompt>, JsonDeserializer<Prompt>{

	
	private Gson gson = new GsonBuilder().registerTypeAdapter(Prompt.class, this).create();
	
	private Gson gsonBase = new Gson();

	public Prompt deserialize(JsonElement ele, Type type,
			JsonDeserializationContext context) throws JsonParseException {
		
		if(ele.isJsonPrimitive()){
			return new 
		}
		return null;
	}

	public JsonElement serialize(Prompt prompt, Type type,
			JsonSerializationContext context) {
		// TODO Auto-generated method stub
		return null;
	}
}
