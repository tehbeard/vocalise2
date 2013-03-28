package com.tehbeard.vocalise.prompts;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PromptTag {
String value();
}
