package io.github.romvoid95.scg.database;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface ManagedObject {
    
    String getId();

    @JsonIgnore
    String getTableName();

    @JsonIgnore
    default String getDatabaseId() {
        return getId();
    }
    
    default void delete() {
        Database.manager().delete(this);
    }

    /**
     * Saves an object to the database.
     * This will save the object by REPLACING it, instead of updating.
     * Useful sometimes.
     */
    default void save() {
        Database.manager().save(this);
    }

    /**
     * Saves an object to the database.
     * This will save the object by updating it.
     * Useful sometimes.
     */
    default void saveUpdating() {
        Database.manager().saveUpdating(this);
    }
    
    default void saveUpdateAsync() {
        Database.queue(this::saveUpdating);
    }

    default void deleteAsync() {
        Database.queue(this::delete);
    }

    default void saveAsync() {
        Database.queue(this::save);
    }
}
