package com.tehbeard.vocalise.prompts;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

/**
 * Proxies to another prompt, used for non-linear merging branches
 * @author James
 *
 */
public class PromptProxy implements Prompt {
	
	private PromptGraph graph;
	private String toId;
	
	

	public PromptProxy(PromptGraph graph, String toId) {
		this.graph = graph;
		this.toId = toId;
	}

	public Prompt acceptInput(ConversationContext arg0, String arg1) {
		return graph.getById(toId);
	}

	public boolean blocksForInput(ConversationContext arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getPromptText(ConversationContext arg0) {
		return null;
	}

}
