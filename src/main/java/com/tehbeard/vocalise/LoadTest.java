package com.tehbeard.vocalise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author James
 */
public class LoadTest {
    public static void main(String[] args) throws FileNotFoundException{
        PromptGraph graph = new PromptGraphBuilder().makeGraph(new FileInputStream(new File("C:\\Users\\James\\Desktop\\test.json")));
        System.out.println("::Loading graph::");
        System.out.println(graph.getInitialPrompt());
    }
}
