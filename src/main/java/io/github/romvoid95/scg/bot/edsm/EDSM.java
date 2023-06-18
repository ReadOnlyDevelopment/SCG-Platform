package io.github.romvoid95.scg.bot.edsm;

import com.google.gson.JsonSyntaxException;

import io.github.romvoid95.scg.bot.edsm.api.Location;
import io.github.romvoid95.scg.bot.edsm.api.v1.commander.GetRanks;
import io.github.romvoid95.scg.bot.edsm.api.v1.logs.LastKnownPosition;
import io.github.romvoid95.scg.bot.edsm.api.v1.system.GetSystemBodies;
import io.github.romvoid95.scg.bot.edsm.api.v1.systems.SystemInformation;
import io.github.romvoid95.scg.util.GsonUtil;
import io.github.romvoid95.scg.util.OkHttpUtil;
import okhttp3.HttpUrl;

public class EDSM
{
    private static final HttpUrl LOGS_URL_BUILDER = HttpUrl.parse("https://www.edsm.net/api-logs-v1");
    private static final HttpUrl CMDR_URL_BUILDER = HttpUrl.parse("https://www.edsm.net/api-commander-v1");
    private static final HttpUrl SYSTEM_URL_BUILDER = HttpUrl.parse("https://www.edsm.net/api-system-v1");
    private static final HttpUrl SYSTEMS_URL_BUILDER = HttpUrl.parse("https://www.edsm.net/api-v1");
    
    public static Location getCoordinates(String name)
    {
    	Location location = null;
        
        LastKnownPosition pos = getPosition(name, false, true);
        if(pos.getMessageNumber() == 100) {
        	location = new Location(name + " (" + pos.getSystem() + ")", pos.getCoordinates());
        } else {
            SystemInformation sysPos = getSystemInformation(name);
            if(sysPos != null) {
            	location = new Location(sysPos.getName(), sysPos.getCoordinates());
            }
        }
        return location;
    }
    
    public static SystemInformation getSystemInformation(String systemName)
    {
        HttpUrl url = EDSM.SYSTEMS_URL_BUILDER.newBuilder()
           .addPathSegment("system")
           .addEncodedQueryParameter("systemName", systemName)
           .addEncodedQueryParameter("showCoordinates", "1")
           .addEncodedQueryParameter("showId", "1")
           .addEncodedQueryParameter("showPermit", "1")
           .addEncodedQueryParameter("showInformation", "1")
           .addEncodedQueryParameter("showPrimaryStar", "1")
           .build();
        var response = OkHttpUtil.read(url);
        try {
        	return GsonUtil.API_GSON.fromJson(response, SystemInformation.class);
        } catch (JsonSyntaxException e) {
        	return null;
		}
    }
    
    public static GetSystemBodies getSystemBodies(String systemName)
    {
        HttpUrl url = EDSM.SYSTEM_URL_BUILDER.newBuilder()
           .addPathSegment("bodies")
           .addEncodedQueryParameter("systemName", systemName)
           .build();
        var response = OkHttpUtil.read(url);
        return GsonUtil.API_GSON.fromJson(response, GetSystemBodies.class);
    }
    
    public static GetRanks getRanks(String cmdrName)
    {
        HttpUrl url = EDSM.CMDR_URL_BUILDER.newBuilder()
            .addPathSegment("get-ranks")
            .addEncodedQueryParameter("commanderName", cmdrName)
            .build();
        var response = OkHttpUtil.read(url);
        return GsonUtil.API_GSON.fromJson(response, GetRanks.class);
    }
    
    public static LastKnownPosition getPosition(String cmdrName, boolean showId, boolean showCoordinates)
    {
        HttpUrl.Builder urlBuilder = EDSM.LOGS_URL_BUILDER.newBuilder()
            .addPathSegment("get-position")
            .addEncodedQueryParameter("commanderName", cmdrName);
            
        if(showId)
            urlBuilder.addEncodedQueryParameter("showId", "1");
            
        if(showCoordinates)
            urlBuilder.addEncodedQueryParameter("showCoordinates", "1");
            
        var url = urlBuilder.build();
        var response = OkHttpUtil.read(url);
        return GsonUtil.API_GSON.fromJson(response, LastKnownPosition.class);
    }
}
