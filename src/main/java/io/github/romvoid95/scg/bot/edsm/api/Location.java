package io.github.romvoid95.scg.bot.edsm.api;

import io.github.romvoid95.scg.bot.edsm.api.v1.logs.modal.Coordinates;

public class Location {
	public String name;
	public double x, y, z;
	
	public Location(String name, Coordinates coordinates)
	{
		this.name = name;
        this.x = coordinates.getX();
        this.y = coordinates.getY();
        this.z = coordinates.getZ();
	}
}
