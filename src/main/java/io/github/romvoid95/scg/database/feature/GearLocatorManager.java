package io.github.romvoid95.scg.database.feature;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.romvoid95.scg.database.ManagedObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GearLocatorManager implements ManagedObject
{
    public static final String DB_TABLE = "gearlocator";
    private List<String> posts;
    private String protectedPostId;
    
    @JsonCreator
    @ConstructorProperties({"protectedPostId", "posts"})
    public GearLocatorManager(String protectedPostId, @JsonProperty("data") List<String> posts)
    {
        this.protectedPostId = protectedPostId;
        this.posts = posts;
    }

    public static GearLocatorManager create()
    {
        return new GearLocatorManager("", new ArrayList<>());
    }

    @Override
    public String getTableName()
    {
        return DB_TABLE;
    }

    @Override
    public String getId()
    {
        return "data";
    }
}
