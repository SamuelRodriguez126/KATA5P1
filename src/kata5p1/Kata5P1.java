package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Kata5P1 {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:KATA5.db";
        
        Connection con = null;
        con = DriverManager.getConnection(url);
        
        String sql = "SELECT * FROM PEOPLE";
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while (rs.next()){
            System.out.println(rs.getInt("id") + "\t" +
                               rs.getString("Name") + "\t" +
                               rs.getString("Apellidos") + "\t" +
                               rs.getString("Departamento") + "\t");
        }
    }
}
