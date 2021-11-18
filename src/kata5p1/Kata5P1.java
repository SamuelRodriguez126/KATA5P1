package kata5p1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Kata5P1 {

    private static Connection connect() throws SQLException{
        String url = "jdbc:sqlite:KATA5.db";
        
        Connection con = null;
        con = DriverManager.getConnection(url);
        
        return con;
    }
    
    private static void selectAll() throws SQLException{
        String sql = "SELECT * FROM PEOPLE";
        Connection con = Kata5P1.connect();
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while (rs.next()){
            System.out.println(rs.getInt("id") + "\t" +
                               rs.getString("Name") + "\t" +
                               rs.getString("Apellidos") + "\t" +
                               rs.getString("Departamento") + "\t");
        }
    }
    
    private static void createTable() throws SQLException{        
        Connection con = Kata5P1.connect();
        
        String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
                   + " Id integer PRIMARY KEY AUTOINCREMENT,\n"
                   + " Mail text NOT NULL);";
        
        Statement stm = con.createStatement();
        stm.execute(sql);
    }
    
    public static void main(String[] args) throws SQLException {
       
        createTable();
    }
}
