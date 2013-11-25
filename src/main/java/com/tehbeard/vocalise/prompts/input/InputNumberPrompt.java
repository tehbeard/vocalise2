package com.tehbeard.vocalise.prompts.input;

import com.tehbeard.vocalise.PromptTag;
import com.tehbeard.vocalise.prompts.SessionPrompt;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

@PromptTag("input_number")
/**
 * input number prompt
 * Configuration format:
 * <code>
 * id: unique id for this prompt
 * type: inpnum
 * variable: where to store value in context
 * next: prompt declaration or string containing prompt id
 * </code>

 * @author James
 *
 */
public class InputNumberPrompt extends SessionPrompt {


    
   
    public InputNumberPrompt(){
        super(true);
    }

    public Prompt acceptInput(ConversationContext cc, String string) {
        try{
        Double d = Double.parseDouble(string);
        setSessionValue(cc,d);
        return getPrompt();
        }
        catch(NumberFormatException e){
            cc.getForWhom().sendRawMessage("Invalid number");
            return this;
        }
        
    }


}
