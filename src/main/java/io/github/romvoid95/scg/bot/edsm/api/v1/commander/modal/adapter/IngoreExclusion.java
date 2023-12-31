package io.github.romvoid95.scg.bot.edsm.api.v1.commander.modal.adapter;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class IngoreExclusion implements ExclusionStrategy
{

    @Override
    public boolean shouldSkipField(FieldAttributes field)
    {
        return field.getAnnotation(GsonIgnore.class) != null;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz)
    {
        return false;
    }

}
