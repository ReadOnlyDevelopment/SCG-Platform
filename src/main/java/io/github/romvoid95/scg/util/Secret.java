package io.github.romvoid95.scg.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Secret
{
    private String source;
    private String value;
    
    String source()
    {
        return source;
    }
    
    String get()
    {
        return value;
    }
    
    public static String get(String key)
    {
        return Env.MAP.containsKey(key) ? Env.MAP.get(key).get() : "";
    }
}
