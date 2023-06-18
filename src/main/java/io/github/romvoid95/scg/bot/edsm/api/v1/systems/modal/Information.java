package io.github.romvoid95.scg.bot.edsm.api.v1.systems.modal;

import java.text.DecimalFormat;

import lombok.Getter;

@Getter
public class Information {
	private String allegiance = "None";
	private String government = "None";
	private String faction = "None";
	private String factionState = "None";
	private long population;
	private String security = "Anarchy";
	private String economy = "None";
	
	public String getFormattedPopulation() {
		String unit = "";
		String number = String.valueOf(population);
		if (number.length() >= 10) {
			unit = "Billion";
		} else if (number.length() >= 7) {
			unit = "Million";
		} else if (number.length() >= 4) {
			unit = "Thousand";
		}
		DecimalFormat f = new DecimalFormat("#,###");
		
		return "%s %s".formatted(f.format(population), unit);
	}
}
