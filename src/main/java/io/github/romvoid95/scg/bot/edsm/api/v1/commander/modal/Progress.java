
package io.github.romvoid95.scg.bot.edsm.api.v1.commander.modal;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Progress
{
    @SerializedName("Combat")
    private int combat;

    @SerializedName("Trade")
    private int trade;

    @SerializedName("Explore")
    private int explore;

    @SerializedName("Soldier")
    private int soldier;

    @SerializedName("Exobiologist")
    private int exobiologist;

    @SerializedName("CQC")
    private int cqc;

    @SerializedName("Federation")
    private int federation;

    @SerializedName("Empire")
    private int empire;
}
