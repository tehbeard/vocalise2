/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tehbeard.vocalise.prompts.action;

import com.google.gson.annotations.Expose;
import com.tehbeard.utils.misc.CallbackMatcher;
import com.tehbeard.vocalise.PromptTag;
import com.tehbeard.vocalise.prompts.BasePrompt;
import java.util.regex.MatchResult;
import org.bukkit.Bukkit;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.entity.Player;

/**
 *
 * @author James
 */
@PromptTag("execute_console")
public class ExecuteConsoleCommandPrompt extends BasePrompt {

    CallbackMatcher matcher = new CallbackMatcher("\\$\\{([A-Za-z0-9_]*)\\}");
    @Expose
    private String command;

    public ExecuteConsoleCommandPrompt() {
        super(false);
    }

    public Prompt acceptInput(final ConversationContext context, String input) {
        String toExec = matcher.replaceMatches(command, new CallbackMatcher.Callback() {
            public String foundMatch(MatchResult mr) {
                Object data = context.getSessionData(mr.group(1));
                if (data == null) {
                    throw new IllegalStateException("Cannot execute command prompt, variable " + mr.group(1) + " is empty");
                }
                return data.toString();
            }
        });
        String player = "";
        if (context.getForWhom() instanceof Player) {
            player = ((Player) context.getForWhom()).getName();
        }
        toExec = toExec.replaceAll("<PLAYER>", player);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), toExec);
        return getPrompt();
    }
}
