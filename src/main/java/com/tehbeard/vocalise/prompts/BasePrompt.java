package com.tehbeard.vocalise.prompts;

import com.google.gson.annotations.Expose;
import com.tehbeard.vocalise.PromptUtils;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

public abstract class BasePrompt implements Prompt{
    
        @Expose
        private String promptText = null;
    
        @Expose
	private Prompt nextPrompt = null;
	
	private boolean blocks = false;
	
	public BasePrompt(boolean block){
		this.blocks = block;
	}

        public boolean blocksForInput(ConversationContext context) {
            return blocks;
        }

    public String getPromptText(ConversationContext cc) {
        return PromptUtils.format(cc,promptText);
    }
    
    protected String getRawPromptText(){
        return promptText;
    }
    
    public Prompt getPrompt(){
        return nextPrompt;
    }
       
}
