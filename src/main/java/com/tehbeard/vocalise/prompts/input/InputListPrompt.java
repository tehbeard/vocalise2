package com.tehbeard.vocalise.prompts.input;

import com.tehbeard.vocalise.PromptTag;
import com.tehbeard.vocalise.PromptUtils;
import com.tehbeard.vocalise.prompts.SessionPrompt;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

/**
 * Accepts a provided set of data
 *
 * @author James
 */
@PromptTag("input_list")
public class InputListPrompt extends SessionPrompt {

    public InputListPrompt() {
        super(true);
    }

    @Override
    public String getPromptText(ConversationContext cc) {
        cc.getForWhom().sendRawMessage("Type /done to end the list");
        return PromptUtils.format(cc, getRawPromptText());
    }

    public Prompt acceptInput(ConversationContext cc, String data) {
        if (!data.equalsIgnoreCase("/done")) {
            if (getSessionValue(cc) == null) {
                setSessionValue(cc, new ArrayList<String>());
            }
            List<String> list = (List<String>) getSessionValue(cc);
            list.add(data);
            return this;
        }
        return getPrompt();
    }
}
