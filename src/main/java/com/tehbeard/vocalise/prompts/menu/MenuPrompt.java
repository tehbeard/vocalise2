package com.tehbeard.vocalise.prompts.menu;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

import com.tehbeard.vocalise.PromptTag;
import com.tehbeard.vocalise.prompts.BasePrompt;

/**
 * Implements a text menu prompt for bukkit's conversation API
 * Menu options are added by the addMenuOption(String, Prompt) method
 * These menu's are static, and cannot change
 * @author James
 *
 */
@PromptTag("menu")
public class MenuPrompt implements Prompt{
    
    
        @Expose
	protected String text;
        @Expose
	List<MenuEntry> prompts;
	//Map<String,Prompt> prompts;

	/**
	 * Provide flavour text for the menu
	 * @param text
	 */
	public MenuPrompt(){
		this("Select an option");
	}
	public MenuPrompt(String text) {
		this.text = text;
		prompts = new ArrayList<MenuEntry>();
	}
	/**
	 * Add a menu option
	 * @param name name of option
	 * @param prompt prompt
	 */
	public void addMenuOption(String name,Prompt prompt){
		prompts.add(new MenuEntry(name,prompt));
	}

	public String getPromptText(ConversationContext context) {

		String msg = "";
		int i = 0;
		for(MenuEntry opt : prompts){
			msg +="[" + i++ +"] " + opt.text + "\n";
		}

		return msg + text;
	}


	protected boolean isNumberValid(ConversationContext context, Number input) {
		int i = input.intValue();
		return (i>=0) && (i<prompts.size());
	}

	protected Prompt acceptValidatedInput(ConversationContext context, Number number) {
		return prompts.get(number.intValue()).prompt;
	}


	public Prompt acceptInput(ConversationContext context, String input) {
		Number number = NumberUtils.createNumber(input);
		if(isNumberValid(context,number)){
			return acceptValidatedInput(context, number);
		}
		return this;
	}

    public boolean blocksForInput(ConversationContext cc) {
        return true;
    }



}
