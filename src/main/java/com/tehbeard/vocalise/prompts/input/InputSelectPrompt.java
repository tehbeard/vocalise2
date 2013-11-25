package com.tehbeard.vocalise.prompts.input;

import com.google.gson.annotations.Expose;
import com.tehbeard.vocalise.PromptTag;
import com.tehbeard.vocalise.PromptUtils;
import com.tehbeard.vocalise.prompts.SessionPrompt;
import java.util.Set;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

/**
 * Accepts a provided set of data
 *
 * @author James
 */
@PromptTag("input_select")
public class InputSelectPrompt extends SessionPrompt {

    @Expose
    Set<String> options;

    public InputSelectPrompt() {
        super(true);
    }

    @Override
    public String getPromptText(ConversationContext cc) {
        for (String opt : options) {
            cc.getForWhom().sendRawMessage(opt);
        }
        return PromptUtils.format(cc, getRawPromptText());
    }

    public Prompt acceptInput(ConversationContext cc, String string) {
        if (options.contains(string)) {
            setSessionValue(cc, string);
            return getPrompt();
        }
        return this;
    }
}
