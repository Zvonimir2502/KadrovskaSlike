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
public class Login {
    
    public static String url = "jdbc:oracle:thin:@192.168.1.2:1521:ORCL";
    public static String pass = "kad";
    public static String userName = "kad";

    public Login(String url, String pass, String userName) {
        this.url = url;
        this.pass = pass;
        this.userName = userName;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Login.url = url;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        Login.pass = pass;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Login.userName = userName;
    }
    
}
