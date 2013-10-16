package com.tehbeard.vocalise.prompts;

import com.google.gson.annotations.Expose;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

import com.tehbeard.vocalise.PromptTag;

/**
 * Concrete version of message prompt
 * @author James
 *
 */
@PromptTag("msg")
public class MsgPrompt extends BasePrompt{

  
    public MsgPrompt(){
    	super(false);
    }

    public Prompt acceptInput(ConversationContext context, String input) {
	return getPrompt();
    }
	
    

}
