/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadrovskaslike;

/**
 *
 * @author LozanciZ
 */
import java.sql.Connection;
import java.sql.DriverManager;
 
public class Database {
 
    public static String url = "jdbc:oracle:thin:@192.168.1.26:1521:XE";
    public static String pass = "omiska";
    public static String userName = "sapadmin";    

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url,userName,pass);
            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }
 
    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
}
