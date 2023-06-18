package io.github.romvoid95.scg.database.base;

import java.beans.ConstructorProperties;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Identifier
{
    @JsonProperty("id")
    private final String id;
    
    @JsonCreator
    @ConstructorProperties({"id"})
    public Identifier(@JsonProperty("id") String id)
    {
        this.id = id;
    }
    
    @Nonnull
    public String getId() {
        return this.id;
    }
}
