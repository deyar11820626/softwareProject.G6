/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwsoft;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marah qubbbaj
 */
public class RebookController implements Initializable {

    @FXML
    private JFXTextField name_move;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void done(ActionEvent event) {
        
        
         try {
         
           DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String str = "jdbc:oracle:thin:@localhost:1521:xe" ;
            Connection con = DriverManager.getConnection(str ,"c##marah1" , "123456" );
           
            Statement stm = con.createStatement();
           String f_n = this.name_move.getText();
          // String user;
        // user = LoginController.static_user_name;
 String str_st = "insert into Reservations (Email,BNAME) values( '"+SigninController.static_start_id+"', '"+f_n+"' )" ;
  name_move.setText("");
                stm.executeUpdate(str_st);
                con.setAutoCommit(false);
                con.commit();
                  con.close();
                  
                 
     } 
     catch (Exception ex) {
           // Logger.getLogger(showProductsController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    }
        @FXML
    void back(ActionEvent event) throws IOException {
            Parent tabelViewParent = FXMLLoader.load(getClass().getResource("Myhome.fxml"));
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
        

    }
}
