package DataAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DataAccess.gjSQLiteDataHelper;
import DataAccess.DTO.gjExobotDTO;

public class gjExobotDAO extends gjSQLiteDataHelper {

    // Create or Insert a new Exobot record
    public boolean gjCreateExobot(gjExobotDTO gjDto) {
        String gjSql = "INSERT INTO gjExobot (gjIdTipoExobot, gjIdUsuario, gjEntrenado, gjNumeroAccion, gjIdArma) VALUES (?, ?, ?, ?, ?)";
        try (Connection gjConn = gjGetConnection();
             PreparedStatement gjPstmt = gjConn.prepareStatement(gjSql)) {
            
            gjPstmt.setInt(1, gjDto.gjGetIdTipoExobot());
            gjPstmt.setInt(2, gjDto.gjGetIdUsuario());
            gjPstmt.setInt(3, gjDto.gjIsEntrenado() ? 1 : 0);
            gjPstmt.setInt(4, gjDto.gjGetNumeroAccion());
            gjPstmt.setInt(5, gjDto.gjGetIdArma());
            
            return gjPstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error creating Exobot: " + e.getMessage());
            return false;
        }
    }

    // Read/GetAll methods could be added here...
}
