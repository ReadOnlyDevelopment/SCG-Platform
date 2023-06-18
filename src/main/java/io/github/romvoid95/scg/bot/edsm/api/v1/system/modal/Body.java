package io.github.romvoid95.scg.bot.edsm.api.v1.system.modal;

import java.util.function.Supplier;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import io.github.romvoid95.scg.bot.edsm.api.v1.system.modal.adapter.Deserialization;
import io.github.romvoid95.scg.bot.edsm.api.v1.system.modal.body.Discovery;
import io.github.romvoid95.scg.bot.edsm.api.v1.system.modal.body.Parents;
import lombok.Getter;

@Getter
public abstract class Body<T extends Body<T>> implements Supplier<T>
{
    private int id;
    private long id64;
    private int bodyId;
    private String name;
    private String type;
    private String subType;
    @JsonAdapter(Deserialization.ParentAdapter.class)
    private Parents parents;
    private Discovery discovery;
    private int distanceToArrival;
    private int surfaceTemperature;
    private double orbitalPeriod;
    private double semiMajorAxis;
    private double orbitalEccentricity;
    private double orbitalInclination;
    private double argOfPeriapsis;
    private double rotationalPeriod;
    @SerializedName("rotationalPeriodTidallyLocked")
    private boolean tidallyLocked;
    private double axialTilt;
}
