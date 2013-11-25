package com.tehbeard.vocalise;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.conversations.Prompt;

/**
 * A prompt graph represents a collection of prompts that are inter linked.
 */
public class PromptGraph {
	
	private Map<String,Prompt> promptsById = new HashMap<String, Prompt>();
	
	private Prompt initialPrompt;
	
	public void setInitialPrompt(Prompt initialPrompt) {
		this.initialPrompt = initialPrompt;
	}

	public PromptGraph(){
		
	}

	public void addPromptToGraph(String id,Prompt prompt){
		promptsById.put(id,prompt);
	}
	
	public Prompt getById(String id){
		return promptsById.get(id);
	}
}
