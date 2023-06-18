package io.github.romvoid95.scg.bot.edsm.api.v1.system.modal;

import java.util.List;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import io.github.romvoid95.scg.bot.edsm.api.v1.system.modal.adapter.Deserialization;
import io.github.romvoid95.scg.bot.edsm.api.v1.system.modal.body.AtmosphereComposition;
import io.github.romvoid95.scg.bot.edsm.api.v1.system.modal.body.Materials;
import io.github.romvoid95.scg.bot.edsm.api.v1.system.modal.body.Ring;
import io.github.romvoid95.scg.bot.edsm.api.v1.system.modal.body.SolidComposition;
import lombok.Getter;

@Getter
public class Planet extends Body<Planet>
{
    @SerializedName("isLandable")
    private boolean landable;
    private double gravity;
    private double earthMasses;
    private double radius;
    private String volcanismType;
    private String atmosphereType;
    @JsonAdapter(Deserialization.AtmosphereCompositionAdapter.class)
    private AtmosphereComposition atmosphereComposition;
    private SolidComposition solidComposition;
    private String terraformingState;
    @JsonAdapter(Deserialization.MaterialsAdapter.class)
    private Materials materials;
    private String updateTime;
    private List<Ring> rings = null;
    
    @Override
    public Planet get()
    {
        return this;
    }
}
