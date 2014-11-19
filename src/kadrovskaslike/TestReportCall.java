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

import java.sql.*;
import java.util.HashMap;

public class TestReportCall {

    
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;         
        try {
            connection = Database.getConnection();
            statement = connection.createStatement();
            HashMap parameterMap = new HashMap();
            parameterMap.put("rtitle", "Korisnici AMOS");//sending the report title as a parameter.
            Report rpt = new Report(parameterMap, connection);
            rpt.setReportName("Pregled_korisnika"); //productlist is the name of my jasper file.
            rpt.callReport();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }        
        
    }
}
