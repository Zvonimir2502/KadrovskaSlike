/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadrovskaslike.rpt;
import net.sf.jasperreports.engine.*; 
import net.sf.jasperreports.engine.export.*;
import java.util.*;
/**
 *
 * @author LozanciZ
 */
public class NewClass {
    
    
    public static void main(String[] args) {
        String fileName = "test.jasper";
        String outFileName = "test.pdf";
        HashMap hm = new HashMap();
        try {             // Fill the report using an empty data source             
            JasperPrint print = JasperFillManager.fillReport(fileName, hm, new JREmptyDataSource());               
            // Create a PDF exporter             
            JRExporter exporter = new JRPdfExporter();               
            // Configure the exporter (set output file name and print object)             
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);             
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);               
            // Export the PDF file             
            exporter.exportReport();           
        } catch (JRException e) {             
            e.printStackTrace();             
            System.exit(1);         
        } catch (Exception e) {             
            e.printStackTrace();             
            System.exit(1);         
        }     
    }         

}
    

