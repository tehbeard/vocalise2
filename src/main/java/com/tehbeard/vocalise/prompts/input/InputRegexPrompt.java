package com.tehbeard.vocalise.prompts.input;

import com.google.gson.annotations.Expose;
import com.tehbeard.vocalise.PromptTag;
import com.tehbeard.vocalise.prompts.SessionPrompt;
import java.util.regex.Pattern;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

@PromptTag("input_regex")
/**
 * Input validated by regex prompt Configuration format:  <code>
 * id: unique id for this prompt
 * regex: regex expression to validate against
 * type: inpregex
 * variable: where to store value in context
 * next: prompt declaration or string containing prompt id
 * </code>
 *
 * @author James
 *
 */
public class InputRegexPrompt extends SessionPrompt {

    @Expose
    private Pattern pattern;

    public InputRegexPrompt() {
        super(true);
    }

    public Prompt acceptInput(ConversationContext cc, String input) {
        if (pattern.matcher(input).matches()) {
            setSessionValue(cc, input);
            return getPrompt();
        }
        return this;
    }

}
