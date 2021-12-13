/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwsoft;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author user
 */

public class Hwsoft extends Application{

    public void start(Stage primaryStage) throws Exception{
        
  
     
    Parent root = FXMLLoader.load(getClass().getResource("DanaTOP.fxml"));
  primaryStage.setTitle("Bored & Bookless ! ");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

        // TODO code application logic here
    }


    
}
