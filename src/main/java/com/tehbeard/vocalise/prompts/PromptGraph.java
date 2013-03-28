package com.tehbeard.vocalise.prompts;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.conversations.Prompt;

/**
 * A prompt graph represents a collection of prompts that are inter linked.
 */
public class PromptGraph {
	
	private Map<String,Prompt> promptsById = new HashMap<String, Prompt>();
	
	
	public PromptGraph(){
		
	}

	public void add(String id,Prompt prompt){
		promptsById.put(id,prompt);
	}
	
	public Prompt getById(String id){
		return promptsById.get(id);
	}
}
