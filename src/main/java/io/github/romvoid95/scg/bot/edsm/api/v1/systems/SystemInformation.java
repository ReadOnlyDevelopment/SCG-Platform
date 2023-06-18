package io.github.romvoid95.scg.bot.edsm.api.v1.systems;

import com.google.gson.annotations.SerializedName;

import io.github.romvoid95.scg.bot.edsm.api.v1.logs.modal.Coordinates;
import io.github.romvoid95.scg.bot.edsm.api.v1.systems.modal.Information;
import io.github.romvoid95.scg.bot.edsm.api.v1.systems.modal.PrimaryStar;
import lombok.Getter;

@Getter
public class SystemInformation
{
    private String name;
    @SerializedName("coords")
    private Coordinates coordinates;
    private boolean coordsLocked;
    @SerializedName("requirePermit")
    private boolean permitLocked;
    private String permitName;
    private Information information = new Information();
    private PrimaryStar primaryStar = new PrimaryStar();
    
    public boolean hasCoordinates()
    {
    	return this.coordinates != null;
    }
    
    public boolean hasExtraInformation()
    {
    	return this.information.getPopulation() > 0;
    }
}
