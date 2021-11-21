/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwsoft;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author user
 */
public class SigninController implements Initializable {


    public static String static_start_id;////
    @FXML
    private JFXTextField user;
    @FXML
    private JFXPasswordField pass;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
            @FXML
    private void sign(ActionEvent event) throws IOException {
        String id = user.getText();

        if (user.getText().equals("dana@gmail.com")) {
                        Parent tabelViewParent = FXMLLoader.load(getClass().getResource("adminpage.fxml"));
            Scene tabelViewScene = new Scene(tabelViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabelViewScene);
            window.show();

        }
        
        else{ Parent tabelViewParent = FXMLLoader.load(getClass().getResource("danaTOP.fxml"));
            Scene tabelViewScene = new Scene(tabelViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabelViewScene);
        }
    }
    

    @FXML
     private void signup(ActionEvent event) throws IOException {
        Parent tabelViewParent = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
    }
    
}
