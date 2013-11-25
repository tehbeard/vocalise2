package com.tehbeard.vocalise.prompts.input;

import com.tehbeard.vocalise.PromptTag;
import com.tehbeard.vocalise.prompts.SessionPrompt;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;


@PromptTag("input_clear")
public class InputClearPrompt extends SessionPrompt{
    
    public InputClearPrompt(){
        super(false);
    }

    public Prompt acceptInput(ConversationContext cc, String string) {
        setSessionValue(cc, null);return getPrompt();
    }



}
