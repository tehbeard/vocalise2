package com.tehbeard.vocalise.prompts;



import com.google.gson.annotations.Expose;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.conversations.BooleanPrompt;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

import com.tehbeard.vocalise.PromptTag;
import com.tehbeard.vocalise.PromptUtils;

/**
 * Wraps the abstract Boolean Prompt to provide a simple
 * version for cases where the true/false prompts are static 
 * @author James
 *
 */
@PromptTag("decision_boolean")
public class QuickBooleanPrompt extends BasePrompt {
    
        
        @Expose
	protected Prompt truePrompt;
        @Expose
	protected Prompt falsePrompt;
	
	
	
	
	public QuickBooleanPrompt(){
	    super(true);
	}

    public Prompt acceptInput(ConversationContext cc, String string) {
        PromptUtils.BooleanName name = PromptUtils.BooleanName.valueOf(string.toUpperCase());
        if(name == null){return this;}
        boolean v = name.val;
        return v ? truePrompt : falsePrompt;
    }

}
