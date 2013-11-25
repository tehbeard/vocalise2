package com.tehbeard.vocalise.prompts.input;

import com.tehbeard.vocalise.PromptTag;
import com.tehbeard.vocalise.prompts.SessionPrompt;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.entity.Player;

@PromptTag("input_this_player")
public class InputThisPlayerPrompt extends SessionPrompt {

    public InputThisPlayerPrompt() {
        super(false);
    }

    public Prompt acceptInput(ConversationContext cc, String plrName) {
        if (cc instanceof Player) {
            setSessionValue(cc,(Player)cc);
        }
        return getPrompt();
    }

}
