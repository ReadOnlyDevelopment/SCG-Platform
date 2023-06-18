package io.github.romvoid95.scg.bot.edsm.api.v1.systems.modal;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class PrimaryStar {
	private String type = "None";
	private String name = "None";
	@SerializedName("isScoopable")
	private boolean scoopable;
}
