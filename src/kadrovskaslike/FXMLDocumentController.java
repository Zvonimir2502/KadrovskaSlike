/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadrovskaslike;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author LozanciZ
 */
public class FXMLDocumentController implements Initializable, ControlledScreen   {
        
    private static ImageView icon = new ImageView();
    ScreensController myController;
    
    @FXML private Label label;
    @FXML private TextField userName;
    @FXML private PasswordField passWord;
    @FXML private Label lblErr;
    @FXML 
    private void handleButtonAction(ActionEvent event) throws Exception {
        System.out.println("Login!");
        lblErr.setText("");
        if (userName.getText().trim().length()==0 || passWord.getText().equals("")){
            lblErr.setVisible(true);
            lblErr.setText("Unesite korisničko ime i lozinku!");

            //Dialog dia = new Dialog("Greška",null,null,null);            
            //dia.showDialog();            
        } else {   
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                //
                // or
                // DriverManager.registerDriver
                //        (new oracle.jdbc.driver.OracleDriver());
                
                String url = "jdbc:oracle:thin:@192.168.1.2:1521:ORCL";
                //               jdbc:oracle:thin:@//host:port/service
                // or
                // String url = "jdbc:oracle:thin:@server.local:1521:prodsid";
                //               jdbc:oracle:thin:@host:port:SID
                //
                //  SID  - System ID of the Oracle server database instance.
                //         By default, Oracle Database 10g Express Edition
                //         creates one database instance called XE.
                //         ex : String url = "jdbc:oracle:thin:@myhost:1521:xe";

                Connection conn =DriverManager.getConnection(url,userName.getText(),passWord.getText());
                conn.setAutoCommit(false);
                System.out.println ("Ok.");
                
                Login login = new Login(url,userName.getText(),passWord.getText());
                
                NewHibernateUtil.SetSessionFactory(url,userName.getText(),passWord.getText());
                
                goToRadnik(event);
            } catch (SQLException sqle) {
                lblErr.setVisible(true);
                lblErr.setText(sqle.getMessage());               
            }                        
        }
                      
    }
    
    @FXML 
    private void goToRadnik(ActionEvent event){ 
     myController.setScreen(KadrovskaSlike.KADROVSKA_SCREEN); 
    }     
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenParent(ScreensController screenParent) {        
        myController = screenParent;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @FXML 
    private void goToMain(ActionEvent event){ 
       myController.setScreen(KadrovskaSlike.MAIN_SCREEN); 
    } 
    
    static class Dialog extends Stage {
            public Dialog( String title, Stage owner, Scene scene, String iconFile ) {
                setTitle( title );
                initStyle( StageStyle.UTILITY );
                initModality( Modality.APPLICATION_MODAL );
                initOwner( owner );
                setResizable( false );
                setScene( scene );
                if (iconFile!=null){
                    icon.setImage( new Image( getClass().getResourceAsStream( iconFile ) ) );
                }
            }
            public void showDialog() {
                sizeToScene();
                centerOnScreen();
                showAndWait();
        }
    }
}
