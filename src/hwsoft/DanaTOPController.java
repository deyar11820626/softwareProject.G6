/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwsoft;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;


/**
 * FXML Controller class
 *
 * @author user
 */
public class DanaTOPController implements Initializable {

    @FXML
    private Circle c1;
    @FXML
    private Circle c2;
    @FXML
    private Circle c3;
    @FXML
    private TextField t1;
    @FXML
    private TextField t3;
    @FXML
    private TextField t2;

    /**
     * Initializes the controller class.
     */ @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
             OracleDataSource ods;
        try {
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            ods.setUser("project");
            ods.setPassword("4124101971");
            Connection con = ods.getConnection();
            Statement stm = con.createStatement();
int number = 5;
            ////////////////
          //  String str_stm = "Select * from books  where Aname='" + search + "' ";
             String str_stm = "Select * from books  where rate = " + number ;
            //  WHERE NAME = 'Hardik';

            ResultSet re = stm.executeQuery(str_stm);

            //   while (re.next()) {
            re.next();
            String name = re.getString("Bname");
            String ath = re.getString("Aname");
            String pic = re.getString("Cover");

            t1.setText(name);
            
            c1.setStroke(Color.SEAGREEN);
            Image im = new Image("photo/" + pic, false);
            c1.setFill(new ImagePattern(im));
            c1.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));

            re.next();
            String name2 = re.getString("Bname");
            String ath2 = re.getString("Aname");
            String pic2 = re.getString("Cover");

            t2.setText(name2);
          
            c2.setStroke(Color.SEAGREEN);
            Image im2 = new Image("photo/" + pic2, false);
            c2.setFill(new ImagePattern(im2));
            c2.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));

            re.next();
            String name3 = re.getString("Bname");
            String ath3 = re.getString("Aname");
            String pic3 = re.getString("Cover");

            t3.setText(name3);
         
            c3.setStroke(Color.SEAGREEN);
            Image im3 = new Image("photo/" + pic3, false);
            c3.setFill(new ImagePattern(im3));
            c3.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
            
            
           
            

        } catch (SQLException ex) {
            Logger.getLogger(Home_1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
        

    @FXML
    private void login(ActionEvent event) throws IOException {
          Parent tabelViewParent = FXMLLoader.load(getClass().getResource("signin.fxml"));
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
    }
        @FXML
    private void search(ActionEvent event) throws IOException {
          Parent tabelViewParent = FXMLLoader.load(getClass().getResource("home_1.fxml"));
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
    }
}
