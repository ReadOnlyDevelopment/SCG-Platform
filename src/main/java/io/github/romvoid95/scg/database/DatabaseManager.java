package io.github.romvoid95.scg.database;

import static com.rethinkdb.RethinkDB.r;

import com.rethinkdb.net.Connection;

import io.github.romvoid95.scg.database.feature.GearLocatorManager;

public class DatabaseManager
{

    private Connection conn;
    
    public DatabaseManager(Connection connection)
    {
    	this.conn = connection;
    }
    
    public GearLocatorManager getGearLocatorManager()
    {
        GearLocatorManager obj = r.table(GearLocatorManager.DB_TABLE).get("data").runAtom(conn, GearLocatorManager.class);
        return obj == null ? GearLocatorManager.create() : obj;
    }

    public void save( ManagedObject object)
    {
    	r.table(object.getTableName()).insert(object).optArg("conflict", "replace").runNoReply(conn);
    }

    public void saveUpdating( ManagedObject object)
    {
    	r.table(object.getTableName()).insert(object).optArg("conflict", "update").runNoReply(conn);
    }

    public void delete( ManagedObject object)
    {
    	r.table(object.getTableName()).get(object.getId()).delete().runNoReply(conn);
    }
}
