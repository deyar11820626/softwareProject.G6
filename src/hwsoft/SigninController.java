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
import javafx.scene.control.Alert;
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

         boolean flag = false ;
        String u = user.getText() ; 
        String p = pass.getText() ;

         try {
        
        OracleDataSource ods = new OracleDataSource() ;
        ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
         ods.setUser("c##marah1");
                  ods.setPassword("123456");
        Connection con = ods.getConnection();
        Statement stm = con.createStatement();

        String str_stm = "Select Email,Pass from Users" ;
        ResultSet re = stm.executeQuery(str_stm) ;
        String in_user = null;
        while(re.next()){
        in_user = re.getString("Email");
        String in_pass = re.getString("pass") ;
        if(u.equals(in_user) && p.equals(in_pass)){
            flag = true ;
            static_start_id = re.getString("Email") ;
        break ;

        }
        }

        if(flag) {
         //  if(6==length(in_user)){
                 Parent tabelViewParent = FXMLLoader.load(getClass().getResource("Myhome.fxml"));
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
     
        }
           else        
        {                                                                             // ***********************       
            Alert alert = new Alert(Alert.AlertType.INFORMATION);                              //*                    //*
        alert.setTitle("Error Message");                                                // Error message ....   *
        alert.setHeaderText("Login error");                                            //*                    //*
        alert.setContentText("Wrong in username or password");                         // ***********************
        alert.showAndWait();        
            user.setText("");
            pass.setText("");   
        }
        } // try 1
           catch (Exception ex) {
          //  Logger.getLogger(showProductsController.class.getName()).log(Level.SEVERE, null, ex);
                               }
    }
    

    @FXML
     private void signup(ActionEvent event) throws IOException {
        Parent tabelViewParent = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
    }
    
         @FXML
    void signadmin(ActionEvent event) throws IOException{
        if (user.getText().equals("Software@najah.edu") && pass.getText().equals("software") ) {
                        Parent tabelViewParent = FXMLLoader.load(getClass().getResource("Adminpage.fxml"));
            Scene tabelViewScene = new Scene(tabelViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tabelViewScene);
            window.show();

        }
        
                               

    }
}
