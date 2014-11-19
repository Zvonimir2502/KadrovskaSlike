/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadrovskaslike;

import javafx.stage.Stage;

/**
 *
 * @author LozanciZ
 */
public class StatDjel {
    
    private static Djelatnik djel;
    private static Stage stage;
    
    public static Djelatnik getStatdjel(){
        return djel;   
    }
    public void setStatdjel(Djelatnik djel){
        this.djel = djel;
    }

    public static Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        StatDjel.stage = stage;
    }
    
}
