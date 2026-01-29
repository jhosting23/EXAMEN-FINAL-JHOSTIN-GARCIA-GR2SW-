package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Infrastructure.gjAppConfig;

public abstract class gjSQLiteDataHelper {
    
    protected static Connection gjGetConnection() throws SQLException {
        try {
            Class.forName(gjAppConfig.gjDRIVER);
            return DriverManager.getConnection(gjAppConfig.gjDB_URL);
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQLite Driver not found", e);
        }
    }
}
