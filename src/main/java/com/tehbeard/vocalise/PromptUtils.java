package com.tehbeard.vocalise;

import java.util.HashMap;
import java.util.regex.MatchResult;

import org.bukkit.ChatColor;
import org.bukkit.conversations.ConversationContext;

import com.tehbeard.utils.misc.CallbackMatcher;
import com.tehbeard.utils.misc.CallbackMatcher.Callback;

public class PromptUtils {

	
	private static final CallbackMatcher colorMatcher = new CallbackMatcher("\\[([a-zA-Z])\\]");
	
	private static final CallbackMatcher contextMatcher = new CallbackMatcher("\\$\\{([a-zA-Z0-9\\_\\-]*)\\}");
	
	public static String format(final ConversationContext context,String string){
		String s = string;
		s = colorMatcher.replaceMatches(s, new Callback() {
					
					public String foundMatch(MatchResult matchResult) {
						return ChatColor.getByChar(matchResult.group(1)).toString();
					}
				});
		s = contextMatcher.replaceMatches(s, new Callback() {
			
			public String foundMatch(MatchResult matchResult) {
				return context.getSessionData(matchResult.group(1)).toString();
			}
		});
		
		return s;
		
	}
	
        
        public enum BooleanName{
        YES(true),
        TRUE(true),
        Y(true),
        T(true),
        /*---*/
        NO(false),
        FALSE(false),
        N(false),
        F(false);
        
        public final boolean val;
        BooleanName(boolean v){
            val = v;
        }
        
    }
}
