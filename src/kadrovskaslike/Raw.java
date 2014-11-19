/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadrovskaslike;

import java.io.*;
import java.sql.*;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.driver.*;
   
   public class Raw {
   
      public static void updateRaw(int pk) {
   
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.1.38:1521:ORCL";

            Connection conn =DriverManager.getConnection(url,"kad","kad");
            conn.setAutoCommit(false); 
            
            PreparedStatement ps = conn.prepareStatement
            ( "SELECT dbms_lob.getlength(FOTOGRAFIJA) length, FOTOGRAFIJA,"
              + "BROJ_ISKAZNICE MBROJ,20 SIFPOD "
              + "FROM DJELATNIK ");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                InputStream source = rs.getBinaryStream(2);
                if (source != null){
                    byte[] destArray = new byte[rs.getInt(1)];
                    if (destArray != null){
                        int byteRead = source.read(destArray);               
                        insertTest("sapadmin","omiska",destArray,rs.getString(3),"20");  
                    }
                }
            }
            
        } catch (SQLException |IOException|ClassNotFoundException e2){
          System.out.println(e2.getMessage());  
        }
          
//         Connection conn = new OracleDriver().defaultConnection();
//   
//         PreparedStatement ps = conn.prepareStatement
//            ( "SELECT dbms_lob.getlength(FOTOGRAFIJA) length, FOTOGRAFIJA,BROJ_ISKAZNICE MBROJ,20 SIFPOD "
//            + "FROM t WHERE DJE_PID = ? FOR UPDATE");
//         ps.setInt( 1, pk);
//         ResultSet rs = ps.executeQuery();
//   
//         rs.next();
//         int len = rs.getInt(1);
//         InputStream source = rs.getBinaryStream(2);
//         byte[] destArray = new byte[len];
//         int byteRead = source.read(destArray);
//         
//         Connection conn2 = new OracleDriver().defaultConnection();         
//         
//         ps = conn.prepareStatement("UPDATE Z_TEST2 SET destination = ? WHERE id = ?");
//         ((OraclePreparedStatement) ps).setRAW(1,new oracle.sql.RAW(destArray));
//         ps.setInt(2, pk);
//         ps.execute();
      }
      
      public static void insertTest (String userName,String passWord,byte[] img,String mbroj,String prod){
      
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                String url = "jdbc:oracle:thin:@192.168.1.38:1521:ORCL";

                Connection conn =DriverManager.getConnection(url,userName,passWord);
                conn.setAutoCommit(false);
                
                PreparedStatement ps = conn.prepareStatement
                ("INSERT into Z_TEST2 (MBROJ,SIFPOD) VALUES (?,?)");                
                ps.setString(1, mbroj);
                ps.setString(2, prod);                
                //((OraclePreparedStatement) ps).setRAW(3,new oracle.sql.RAW(img));                
                ps.execute();
                conn.commit();
                
                System.out.println(mbroj);
                PreparedStatement ps2 = conn.prepareStatement
                ("UPDATE Z_TEST2 set IMG = ? where mbroj=?");
                ((OraclePreparedStatement) ps2).setRAW(1,new oracle.sql.RAW(img));
                ps2.setString(2, mbroj);
                ps2.execute();
                
                
                conn.commit();
                
            } catch (SQLException|ClassNotFoundException sqle) {
                System.out.println(sqle.getMessage());          
            }     
      
      
      
      }
      
      
      
   }

