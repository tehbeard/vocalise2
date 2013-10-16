package com.tehbeard.vocalise.prompts.input;

import com.google.gson.annotations.Expose;
import com.tehbeard.vocalise.PromptTag;
import java.util.regex.Pattern;



import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.ValidatingPrompt;

@PromptTag("inpregex")
/**
 * Input validated by regex prompt
 * Configuration format:
 * <code>
 * id: unique id for this prompt
 * regex: regex expression to validate against
 * type: inpregex
 * variable: where to store value in context
 * next: prompt declaration or string containing prompt id
 * </code>
 * @author James
 *
 */
public class InputRegexPrompt extends ValidatingPrompt {

    @Expose
    private String text;
    @Expose
    private String sessionVariable;
    @Expose
    private Prompt nextPrompt;
    //TODO - FIX DESERIALIZER
    @Expose
    private Pattern pattern;
    
    public InputRegexPrompt(){
        this("","","");
    }
    
    public InputRegexPrompt(String input,String session,String regex) {
        pattern = Pattern.compile(regex);
        this.sessionVariable = session;
    }

    public void setPrompt(Prompt prompt){
        this.nextPrompt = prompt;
    }
    
    public String getPromptText(ConversationContext context) {
        return text;
    }

    @Override
    protected Prompt acceptValidatedInput(ConversationContext context,
            String input) {
        context.setSessionData(sessionVariable, input);
        return nextPrompt;
    }

    @Override
    protected boolean isInputValid(ConversationContext context, String input) {
        return pattern.matcher(input).matches();
    }

}
