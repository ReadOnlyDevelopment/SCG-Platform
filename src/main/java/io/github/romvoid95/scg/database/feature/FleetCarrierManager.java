package io.github.romvoid95.scg.database.feature;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.github.romvoid95.scg.database.ManagedObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FleetCarrierManager implements ManagedObject
{
    public static final String DB_TABLE = "carriers";
    
    @Override
    public String getId()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getTableName()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
