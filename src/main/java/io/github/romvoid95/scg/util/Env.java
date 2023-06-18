package io.github.romvoid95.scg.util;

import java.util.HashMap;
import java.util.Map;

import io.github.cdimascio.dotenv.Dotenv;

public class Env
{
    static final Map<String, Secret> MAP = new HashMap<>();
    
    public Env(Map<String, String> javaArgs)
    {
        Dotenv.load().entries().forEach(e -> {
            MAP.put(e.getKey(), new Secret("Dotenv", e.getValue()));
        });
        javaArgs.entrySet().forEach(e -> {
            MAP.put(e.getKey(), new Secret("Java", e.getValue()));
        });
    }
}
