package io.github.romvoid95.scg.bot.edsm.api.v1.system.modal;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Star extends Body<Star>
{
    @SerializedName("isMainStar")
    private boolean mainStar;
    @SerializedName("isScoopable")
    private boolean scoopable;
    private int age;
    private String luminosity;
    private double absoluteMagnitude;
    private double solarMasses;
    private double solarRadius;
    
    @Override
    public Star get()
    {
        return this;
    }
}
