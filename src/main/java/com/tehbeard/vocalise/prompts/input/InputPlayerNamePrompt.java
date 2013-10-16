package com.tehbeard.vocalise.prompts.input;

import com.tehbeard.vocalise.PromptTag;
import com.tehbeard.vocalise.prompts.SessionPrompt;
import org.bukkit.Bukkit;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

@PromptTag("inpply")
public class InputPlayerNamePrompt extends SessionPrompt {

  
    public InputPlayerNamePrompt(){
        super(true);
    }
    
    public Prompt acceptInput(ConversationContext cc, String string) {
        if(Bukkit.getPlayer(string) == null){cc.getForWhom().sendRawMessage("Player not found");return this;}
        setSessionValue(cc, Bukkit.getPlayer(string));
        return getPrompt();
    }
    
    

}
