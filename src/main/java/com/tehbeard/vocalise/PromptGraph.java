package com.tehbeard.vocalise;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.conversations.Conversable;
import org.bukkit.conversations.Conversation;

import org.bukkit.conversations.Prompt;

/**
 * A prompt graph represents a collection of prompts that are inter linked.
 */
public class PromptGraph {

    private final Map<String, Prompt> promptsById = new HashMap<String, Prompt>();
    private final Prompt initialPrompt;

    public PromptGraph(Prompt initialPrompt) {
        this.initialPrompt = initialPrompt;

    }

    public void addPromptToGraph(String id, Prompt prompt) {
        promptsById.put(id, prompt);
    }

    public Prompt getById(String id) {
        return promptsById.get(id);
    }

    public Prompt getInitialPrompt() {
        return initialPrompt;
    }

}
