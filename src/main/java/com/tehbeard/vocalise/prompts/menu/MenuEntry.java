package com.tehbeard.vocalise.prompts.menu;

import com.google.gson.annotations.Expose;
import org.bukkit.conversations.Prompt;

/**
 *
 * @author James
 */
class MenuEntry {
    @Expose
    public String text;
    @Expose
    public Prompt prompt;

    /**
     * @param text
     * @param prompt
     */
    public MenuEntry(String text, Prompt prompt) {
        this.text = text;
        this.prompt = prompt;
    }
    
}
