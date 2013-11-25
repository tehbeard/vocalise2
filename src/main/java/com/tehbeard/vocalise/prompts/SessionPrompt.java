package com.tehbeard.vocalise.prompts;

import com.google.gson.annotations.Expose;
import org.bukkit.conversations.ConversationContext;

public abstract class SessionPrompt extends BasePrompt{
   
        @Expose
        private String sessionVariable = "";
	

	public SessionPrompt(boolean block){
		super(block);
	}

        
        public void setSessionValue(ConversationContext context,Object obj){
            context.setSessionData(sessionVariable, obj);
        }
        
        public Object getSessionValue(ConversationContext context){
            return context.getSessionData(sessionVariable);
        }
}
