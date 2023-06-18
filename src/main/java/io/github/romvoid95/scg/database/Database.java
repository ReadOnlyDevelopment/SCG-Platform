package io.github.romvoid95.scg.database;

import static com.rethinkdb.RethinkDB.r;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

import com.rethinkdb.net.Connection;

import io.github.romvoid95.scg.util.Factory;
import io.github.romvoid95.scg.util.Secret;

public class Database
{
    static final ScheduledExecutorService service = Factory.newScheduledThreadPool(1, "SCG", true);
    static DatabaseManager manager;
    static Connection connection;
    
    static Connection conn() {
        if (connection == null) {
            synchronized (Database.class) {
                if (connection != null) {
                    return connection;
                }
                //@noformat
                connection = r.connection()
                        .hostname(Secret.get("HOSTNAME"))
                        .port(28015)
                        .db(Secret.get("DATABASE"))
                        .user(Secret.get("USER"), Secret.get("PASSWORD"))
                        .connect();
            }
        }

        return connection;
    }

    static DatabaseManager manager() {
        if (manager == null) {
            manager = new DatabaseManager(conn());
        }

        return manager;
    }
    
    static void queue(Callable<?> action) {
        service.submit(action);
    }

    static void queue(Runnable runnable) {
        service.submit(runnable);
    }
}
