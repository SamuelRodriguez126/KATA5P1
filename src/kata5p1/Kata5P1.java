package kata5p1;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


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
    
    private static void insert(String email) throws SQLException{
        String sql = "INSERT INTO MAIL(mail) VALUES(?)";
        
        Connection con = Kata5P1.connect();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, email);
        pstmt.executeUpdate();
                
    }
    public static void main(String[] args) throws SQLException, FileNotFoundException {
       
        String fileName = "email.txt";
        
        MailListReader reader = new MailListReader();
        
        List<String> mails = reader.read(fileName);
        
        for (String mail : mails) {
            Kata5P1.insert(mail);
        }
    }
}
