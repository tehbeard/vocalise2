package com.tehbeard.vocalise.prompts.input;

import com.tehbeard.vocalise.PromptTag;
import com.tehbeard.vocalise.PromptUtils.BooleanName;
import com.tehbeard.vocalise.prompts.SessionPrompt;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;


/**
 * Input boolean prompt
 * Configuration format:
 * <code>
 * id: unique id for this prompt
 * type: inpbool
 * variable: where to store value in context
 * next: prompt declaration or string containing prompt id
 * </code>
 * @author James
 *
 */
@PromptTag("input_boolean")
public class InputBooleanPrompt extends SessionPrompt{

    public InputBooleanPrompt(){
        super(true);
    }

    
    public Prompt acceptInput(ConversationContext cc, String string) {
        BooleanName name = BooleanName.valueOf(string.toUpperCase());
        if(name == null){return this;}
        setSessionValue(cc,name.val);
        return getPrompt();
        
    }



 

}
