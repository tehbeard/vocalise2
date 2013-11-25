package com.tehbeard.vocalise.prompts.input;

import com.tehbeard.vocalise.PromptTag;
import com.tehbeard.vocalise.prompts.SessionPrompt;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.entity.Player;

@PromptTag("input_player")
public class InputPlayerPrompt extends SessionPrompt {

    public InputPlayerPrompt() {
        super(true);
    }

    public Prompt acceptInput(ConversationContext cc, String plrName) {
        List<Player> list = Bukkit.matchPlayer(plrName);

        if (list.size() > 1) {
            String l = "";
            for (Player p : list) {
                if(l.length() > 0){ l += ", ";}
                l+= p.getName();
            }
            cc.getForWhom().sendRawMessage("Did you mean? " + l);
            return this;
        }
        else if (list.isEmpty()){
            cc.getForWhom().sendRawMessage("Could not find player");
            return this;
        }
        setSessionValue(cc, Bukkit.getPlayer(plrName));
        return getPrompt();
    }

}
