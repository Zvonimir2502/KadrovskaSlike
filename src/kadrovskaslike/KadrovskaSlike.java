/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadrovskaslike;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author LozanciZ
 */
public class KadrovskaSlike extends Application {
    
    public static final String MAIN_SCREEN = "FXMLDocument";
    public static final String MAIN_SCREEN_FXML = "FXMLDocument.fxml";
    public static final String KADROVSKA_SCREEN = "Radnik";
    public static final String KADROVSKA_SCREEN_FXML= "Radnik.fxml";
    Scene scene;
    
    @Override
    public void start(Stage stage) throws Exception {
        
       ScreensController mainContainer = new ScreensController();
       mainContainer.stage = stage;
       mainContainer.loadScreen(KadrovskaSlike.MAIN_SCREEN,KadrovskaSlike.MAIN_SCREEN_FXML); 
       mainContainer.loadScreen(KadrovskaSlike.KADROVSKA_SCREEN,KadrovskaSlike.KADROVSKA_SCREEN_FXML); 
       
       mainContainer.setScreen(KadrovskaSlike.MAIN_SCREEN); 

       Group root = new Group(); 
       root.getChildren().addAll(mainContainer); 
       scene = new Scene(root); 
       stage.setScene(scene);
       
       // set icon
       stage.getIcons().add(new Image(KadrovskaSlike.class.getResource("img").toString()+"/icon.jpg"));       
       
       
       stage.show();  
     }         

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
