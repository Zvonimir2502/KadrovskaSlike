/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadrovskaslike;

import java.io.InputStream;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author LozanciZ
 */
public class ReportUtil {  
     public static void showReport(InputStream reportStream, HashMap<String, Object> parameters,JRDataSource dataSource) {  
             try {  
                 JasperDesign jd = JRXmlLoader.load(reportStream);  
                 JasperReport jr = JasperCompileManager.compileReport(jd);  
                 JasperPrint jp = JasperFillManager.fillReport(jr, parameters, dataSource);  
                 JasperViewer jv = new JasperViewer(jp);  
                 jv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
                 jv.setVisible(true);  
             } catch (JRException e) {  
                e.printStackTrace();  
             }  
         }  
}  
