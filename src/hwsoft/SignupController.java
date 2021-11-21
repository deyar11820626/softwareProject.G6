/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwsoft;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import oracle.jdbc.pool.OracleDataSource;

/**
 * FXML Controller class
 *
 * @author user
 */
public class SignupController implements Initializable {

    @FXML
    private TextField f_name;
    @FXML
    private TextField email;
    @FXML
    private TextField address;
    @FXML
    private TextField phone;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField l_name;
    @FXML
    private Label empty;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void create(ActionEvent event) throws SQLException, IOException {
 OracleDataSource ods;

        try {
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            ods.setUser("project");
            ods.setPassword("4124101971");
            Connection con = ods.getConnection();
            Statement stm = con.createStatement();
            
                String f_n = this.f_name.getText();
                String l_n = this.l_name.getText();
                String email = this.email.getText();
                String password = this.pass.getText();
                String address1 = this.address.getText();
              String number_phone = this.phone.getText();
               
                

                String str_statment = "insert into users values( '" + f_n + "', '" + l_n + "', '" + address1 + "', '" + email + "', '" + number_phone + "', '" + password + "' )" ;
                stm.executeUpdate(str_statment);
    }
        catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }

    }
    @FXML
     void back(ActionEvent event) throws IOException {
         Parent tabelViewParent = FXMLLoader.load(getClass().getResource("signin.fxml"));
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
    }}
    

