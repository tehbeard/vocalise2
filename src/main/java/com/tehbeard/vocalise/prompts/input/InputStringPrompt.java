package com.tehbeard.vocalise.prompts.input;

import com.tehbeard.vocalise.PromptTag;
import com.tehbeard.vocalise.prompts.SessionPrompt;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

/**
 *
 * @author James
 */
@PromptTag("inpstr")

public class InputStringPrompt extends SessionPrompt{
    
    public InputStringPrompt(){
        super(true);
    }
    

    public Prompt acceptInput(ConversationContext cc, String string) {
        setSessionValue(cc, string);
        return getPrompt();
    }



}
