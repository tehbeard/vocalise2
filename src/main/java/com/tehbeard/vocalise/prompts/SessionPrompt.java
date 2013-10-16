package com.tehbeard.vocalise.prompts;

import com.google.gson.annotations.Expose;
import org.bukkit.conversations.ConversationContext;

public abstract class SessionPrompt extends BasePrompt{
   
        @Expose
        private String sessionVariable = "";
	
	private boolean blocks = false;
	
	public SessionPrompt(boolean block){
		super(block);
	}

	public boolean blocksForInput(ConversationContext context) {
            return blocks;
	}
        
        public void setSessionValue(ConversationContext context,Object obj){
            context.setSessionData(sessionVariable, obj);
        }
	
}
