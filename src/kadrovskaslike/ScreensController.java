/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadrovskaslike;

import javafx.util.Duration;
import java.util.HashMap;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author LozanciZ
 */
 public class ScreensController extends StackPane {
     
     public Stage stage;
     private HashMap<String, Node> screens = new HashMap<>(); 
    
     public void addScreen(String name, Node screen) { 
           screens.put(name, screen); 
     }      
     
     public boolean loadScreen(String name, String resource) {
         try {
             FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
             Parent loadScreen = (Parent) myLoader.load();
             addScreen(name, loadScreen);
             ControlledScreen myScreenControler = ((ControlledScreen) myLoader.getController());
             myScreenControler.setScreenParent(this);
             
            // Get current screen of the stage      
            ObservableList<Screen> screens = Screen.getScreensForRectangle(new Rectangle2D(stage.getX(), stage.getY(), stage.getWidth(), stage.getHeight()));

            // Change stage properties
            Rectangle2D bounds = screens.get(0).getVisualBounds();
            stage.setX(bounds.getMinX());
            stage.setY(bounds.getMinY());
            stage.setWidth(bounds.getWidth());
            stage.setHeight(bounds.getHeight());               
             
             return true;
         } catch (Exception e) {
             System.out.println(e.getMessage());
             return false;
         }
     }

     public boolean setScreen(final String name) {
            
         if (screens.get(name) != null) { //screen loaded 
             final DoubleProperty opacity = opacityProperty();

             //Is there is more than one screen 
             if (!getChildren().isEmpty()) {

                 Timeline fade = new Timeline(
                         new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                         new KeyFrame(new Duration(1000),
                                 new EventHandler() {
                                     @Override
                                     public void handle(Event event) {

                                         //remove displayed screen 
                                         getChildren().remove(0);
                                         //add new screen 
                                         getChildren().add(0, screens.get(name));
                                         Timeline fadeIn = new Timeline(
                                                 new KeyFrame(Duration.ZERO,
                                                         new KeyValue(opacity, 0.0)),
                                                 new KeyFrame(new Duration(800),
                                                         new KeyValue(opacity, 1.0)));
                                         fadeIn.play();
                                     }
                                 }, new KeyValue(opacity, 0.0)));
                 fade.play();

             } else {
                 //no one else been displayed, then just show 
                 setOpacity(0.0);
                 getChildren().add(screens.get(name));
                 Timeline fadeIn;
                 fadeIn = new Timeline(
                         new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                         new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
                 fadeIn.play();
             }             
             return true;
         } else {
             System.out.println(screens.size()+"screen hasn't been loaded!\n");
             return false;
         }
     }

     public boolean unloadScreen(String name) {
         if (screens.remove(name) == null) {
             System.out.println("Screen didn't exist");
             return false;
         } else {
             return true;
         }
     }

   
}
