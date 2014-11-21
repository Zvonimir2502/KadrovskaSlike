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
import java.awt.Container;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
 
public class Report extends JFrame {
 
    HashMap hm = null;
    Connection con = null;
    String reportName;
 
    public Report() {
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 
    }
 
    public Report(HashMap map) {
        this.hm = map;
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 
    }
 
    public Report(HashMap map, Connection con) {
        this.hm = map;
        this.con = con;
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Report Viewer");
 
    }
 
    public void setReportName(String rptName) {
        this.reportName = rptName;
    }
 
    public void callReport() {
        JasperPrint jasperPrint = generateReport();
        JRViewer viewer = new JRViewer(jasperPrint);
        Container c = getContentPane();
        c.add(viewer);
        this.setVisible(true);
    }
 
    public void callConnectionLessReport() {
        JasperPrint jasperPrint = generateEmptyDataSourceReport();
        JRViewer viewer = new JRViewer(jasperPrint);
        Container c = getContentPane();
        c.add(viewer);
        this.setVisible(true);
    }
 
    public void closeReport() {
        //jasperViewer.setVisible(false);
    }
 
    /** this method will call the report from data source*/
    public JasperPrint generateReport() {
        try {
            if (con == null) {
                try {
                    con = Database.getConnection();
 
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            JasperPrint jasperPrint = null;
            if (hm == null) {
                hm = new HashMap();
            }
            try {
                /**You can also test this line if you want to display 
                 * report from any absolute path other than the project root path*/
                
                //JasperDesign jd  = JRXmlLoader.load(getClass().getResource("/rpt/"+reportName+".jrxml").toString());
                //jasperPrint = JasperFillManager.fillReport("F:/testreport/"+reportName+".jasper",hm, con);
                String rptpath = "rpt/";//KadrovskaSlike.class.getResource("rpt").toString()+"/";

                jasperPrint = (JasperPrint) JasperFillManager.fillReport(getClass().getResource(rptpath +reportName + ".jasper").openStream(), hm, con);
                //JasperExportManager.exportReportToPdfFile(jasperPrint,rptpath +reportName + ".pdf" ); 
                
               // jasperPrint = JasperFillManager.fillReport(rptpath +reportName + ".jasper", hm, con);
                JasperViewer.viewReport(jasperPrint, false); 
            } catch (JRException e) {
                e.printStackTrace();
            }
            return jasperPrint;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
 
 
    }
 
    /** call this method when your report has an empty data source*/
    public JasperPrint generateEmptyDataSourceReport() {
        try {
            JasperPrint jasperPrint = null;
            if (hm == null) {
                hm = new HashMap();
            }
            try {
                jasperPrint = JasperFillManager.fillReport(reportName + ".jasper", hm, new JREmptyDataSource());
            } catch (JRException e) {
                e.printStackTrace();
            }
            return jasperPrint;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
 
    }
}
