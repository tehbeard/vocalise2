package com.tehbeard.vocalise;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import org.bukkit.conversations.Prompt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.tehbeard.vocalise.prompts.MsgPrompt;
import com.tehbeard.vocalise.prompts.PromptProxy;
import com.tehbeard.vocalise.prompts.QuickBooleanPrompt;
import com.tehbeard.vocalise.prompts.input.*;
import com.tehbeard.vocalise.prompts.menu.MenuPrompt;
import java.util.regex.Pattern;

/**
 * Constructs prompt graphs
 *
 * @author James
 *
 */
public class PromptGraphBuilder implements JsonDeserializer<Prompt> {

    private Gson gson = new GsonBuilder()
            .registerTypeAdapter(Prompt.class, this)
            .registerTypeAdapter(Pattern.class, new RegexDeserializer())
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    private PromptGraph inProgress;
    private static ClassCatalogue<Prompt> catalogue = new ClassCatalogue<Prompt>();

    public static void addPromptClass(Class<? extends Prompt> clazz) {
        catalogue.addProduct(clazz);
    }

    static {
        addPromptClass(MsgPrompt.class);
        addPromptClass(QuickBooleanPrompt.class);
        addPromptClass(MenuPrompt.class);

        addPromptClass(InputBooleanPrompt.class);
        addPromptClass(InputClearPrompt.class);
        addPromptClass(InputNumberPrompt.class);
        addPromptClass(InputPlayerNamePrompt.class);
        addPromptClass(InputRegexPrompt.class);
        addPromptClass(InputStringPrompt.class);


    }

    public PromptGraph makeGraph(InputStream is) {
        inProgress = new PromptGraph();

        inProgress.setInitialPrompt(gson.fromJson(new InputStreamReader(is), Prompt.class));

        return inProgress;
    }

    /**
     * Deserialize a prompt graph
     *
     * @param ele
     * @param type
     * @param context
     * @return
     * @throws JsonParseException
     */
    public Prompt deserialize(JsonElement ele, Type t,
            JsonDeserializationContext context) throws JsonParseException {
        Prompt p = null;

        JsonObject jsonObject = ele.getAsJsonObject();
        String type = jsonObject.get("_type").getAsString();

        if (ele.isJsonPrimitive()) {
            if (ele.getAsJsonPrimitive().getAsString().equalsIgnoreCase("__exit__")) {
                p = null;
            } else {
                p = new PromptProxy(inProgress, ele.getAsJsonPrimitive().getAsString());
            }
        } else {
            p = context.deserialize(jsonObject.get("data"), catalogue.get(type));
        }
        inProgress.addPromptToGraph(ele.getAsJsonObject().get("_id").getAsString(), p);
        return p;
    }
}
