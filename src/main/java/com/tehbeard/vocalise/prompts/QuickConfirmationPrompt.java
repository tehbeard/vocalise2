package com.tehbeard.vocalise.prompts;


import org.bukkit.conversations.BooleanPrompt;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

/**
 * Confirmation class for use in commands to ensure they want to do something
 * @author James
 *
 */
public abstract class QuickConfirmationPrompt extends BooleanPrompt{

	protected String txt;
	
	
	public QuickConfirmationPrompt(){
	    this("");
	}
	/**
	 * @param text text prompt to display
	 * @param t prompt to goto if true
	 * @param f prompt to goto if false
	 */
	public QuickConfirmationPrompt(String text) {
		super();
		this.txt = text;

	}

	public final String getPromptText(ConversationContext context) {
		// TODO Auto-generated method stub
		return txt;
	}

	
	@Override
	protected final Prompt acceptValidatedInput(ConversationContext context,
			boolean input) {
	    called(input);
		return null;
	}
	
	public abstract void called(boolean result);

}
