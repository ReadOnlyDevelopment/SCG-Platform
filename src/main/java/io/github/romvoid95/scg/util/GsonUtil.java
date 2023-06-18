package io.github.romvoid95.scg.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.github.romvoid95.scg.bot.edsm.api.v1.commander.modal.adapter.IngoreExclusion;
import io.github.romvoid95.scg.bot.edsm.api.v1.system.modal.Body;
import io.github.romvoid95.scg.bot.edsm.api.v1.system.modal.adapter.Deserialization;
import io.github.romvoid95.scg.bot.edsm.api.v1.system.modal.body.AtmosphereComposition;
import io.github.romvoid95.scg.bot.edsm.api.v1.system.modal.body.Materials;
import io.github.romvoid95.scg.bot.edsm.api.v1.system.modal.body.Parents;

public class GsonUtil
{
    public static final Gson TO_STRING = new GsonBuilder().setPrettyPrinting().create();
    
    public static final Gson API_GSON = new GsonBuilder()
        .setExclusionStrategies(new IngoreExclusion())
        .registerTypeAdapter(Body.class, new Deserialization.BodyAdapter())
        .registerTypeAdapter(Parents.class, new Deserialization.ParentAdapter())
        .registerTypeAdapter(Materials.class, new Deserialization.MaterialsAdapter())
        .registerTypeAdapter(AtmosphereComposition.class, new Deserialization.AtmosphereCompositionAdapter())
        .create();
}
