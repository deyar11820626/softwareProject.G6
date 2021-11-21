/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwsoft;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import java.io.File;
import java.io.IOException;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import oracle.jdbc.pool.OracleDataSource;



/**
 * FXML Controller class
 *
 * @author user
 */
public class Home_1Controller implements Initializable {

    @FXML
    private TextField text_search;
    @FXML
    private Button button;
    @FXML
    private Circle circle1;
    @FXML
    private Circle circle2;
    @FXML
    private Circle circle3;
    @FXML
    private TextField text_name1;
    @FXML
    private TextField text_name2;
    @FXML
    private TextField text_name3;
    @FXML
    private TextArea area1;
    @FXML
    private TextArea area2;
    @FXML
    private TextArea area3;
    @FXML
    private Circle circle4;
    @FXML
    private Circle circle6;
    @FXML
    private Circle circle5;
    @FXML
    private TextField text_name4;
    @FXML
    private TextField text_name6;
    @FXML
    private TextField text_name5;
    @FXML
    private TextArea area4;
    @FXML
    private TextArea area5;
    @FXML
    private TextArea area6;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
     @FXML
    private Button button44;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void button(ActionEvent event) {
        
              OracleDataSource ods;

        
 


        try {
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            ods.setUser("project");
            ods.setPassword("4124101971");
            Connection con = ods.getConnection();
            Statement stm = con.createStatement();
            String search = text_search.getText();
            ////////////////
            String str_stm = "Select * from books  where Bname='" + search + "' ";
            //  WHERE NAME = 'Hardik';

            ResultSet re = stm.executeQuery(str_stm);

            //   while (re.next()) {
            re.next();
            String name = re.getString("Bname");
            String ath = re.getString("Aname");
            String pic = re.getString("Cover");

            text_name1.setText(name);
            area1.setText(ath);
            circle1.setStroke(Color.SEAGREEN);
            Image im = new Image("photo/" + pic, false);
            circle1.setFill(new ImagePattern(im));
            circle1.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));

            re.next();
            String name2 = re.getString("Bname");
            String ath2 = re.getString("Aname");
            String pic2 = re.getString("Cover");

            text_name2.setText(name2);
            area2.setText(ath2);
            circle2.setStroke(Color.SEAGREEN);
            Image im2 = new Image("photo/" + pic2, false);
            circle2.setFill(new ImagePattern(im2));
            circle2.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));

            re.next();
            String name3 = re.getString("Bname");
            String ath3 = re.getString("Aname");
            String pic3 = re.getString("Cover");

            text_name3.setText(name3);
            area3.setText(ath3);
            circle3.setStroke(Color.SEAGREEN);
            Image im3 = new Image("photo/" + pic3, false);
            circle3.setFill(new ImagePattern(im3));
            circle3.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
            
            
            
             re.next();
            String name4 = re.getString("Bname");
            String ath4 = re.getString("Aname");
            String pic4 = re.getString("Cover");

            text_name4.setText(name4);
            area4.setText(ath4);
            circle4.setStroke(Color.SEAGREEN);
            Image im4 = new Image("photo/" + pic4, false);
            circle4.setFill(new ImagePattern(im4));
            circle4.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));

            re.next();
            String name5 = re.getString("Bname");
            String ath5 = re.getString("Aname");
            String pic5 = re.getString("Cover");

            text_name5.setText(name5);
            area5.setText(ath5);
            circle5.setStroke(Color.SEAGREEN);
            Image im5 = new Image("photo/" + pic5, false);
            circle5.setFill(new ImagePattern(im5));
            circle5.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));

            re.next();
            String name6 = re.getString("Bname");
            String ath6 = re.getString("Aname");
            String pic6 = re.getString("Cover");

            text_name6.setText(name6);
            area6.setText(ath6);
            circle6.setStroke(Color.SEAGREEN);
            Image im6 = new Image("photo/" + pic6, false);
            circle6.setFill(new ImagePattern(im6));
            circle6.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
            
            

        } catch (SQLException ex) {
            Logger.getLogger(Home_1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void button2(ActionEvent event) {
        OracleDataSource ods;

        
 


        try {
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            ods.setUser("project");
            ods.setPassword("4124101971");
            Connection con = ods.getConnection();
            Statement stm = con.createStatement();
            String search = text_search.getText();
            ////////////////
            String str_stm = "Select * from books  where Aname='" + search + "' ";
            //  WHERE NAME = 'Hardik';

            ResultSet re = stm.executeQuery(str_stm);

            //   while (re.next()) {
            re.next();
            String name = re.getString("Bname");
            String ath = re.getString("Aname");
            String pic = re.getString("Cover");

            text_name1.setText(name);
            area1.setText(ath);
            circle1.setStroke(Color.SEAGREEN);
            Image im = new Image("photo/" + pic, false);
            circle1.setFill(new ImagePattern(im));
            circle1.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));

            re.next();
            String name2 = re.getString("Bname");
            String ath2 = re.getString("Aname");
            String pic2 = re.getString("Cover");

            text_name2.setText(name2);
            area2.setText(ath2);
            circle2.setStroke(Color.SEAGREEN);
            Image im2 = new Image("photo/" + pic2, false);
            circle2.setFill(new ImagePattern(im2));
            circle2.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));

            re.next();
            String name3 = re.getString("Bname");
            String ath3 = re.getString("Aname");
            String pic3 = re.getString("Cover");

            text_name3.setText(name3);
            area3.setText(ath3);
            circle3.setStroke(Color.SEAGREEN);
            Image im3 = new Image("photo/" + pic3, false);
            circle3.setFill(new ImagePattern(im3));
            circle3.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
            
            
            
             re.next();
            String name4 = re.getString("Bname");
            String ath4 = re.getString("Aname");
            String pic4 = re.getString("Cover");

            text_name4.setText(name4);
            area4.setText(ath4);
            circle4.setStroke(Color.SEAGREEN);
            Image im4 = new Image("photo/" + pic4, false);
            circle4.setFill(new ImagePattern(im4));
            circle4.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));

            re.next();
            String name5 = re.getString("Bname");
            String ath5 = re.getString("Aname");
            String pic5 = re.getString("Cover");

            text_name5.setText(name5);
            area5.setText(ath5);
            circle5.setStroke(Color.SEAGREEN);
            Image im5 = new Image("photo/" + pic5, false);
            circle5.setFill(new ImagePattern(im5));
            circle5.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));

            re.next();
            String name6 = re.getString("Bname");
            String ath6 = re.getString("Aname");
            String pic6 = re.getString("Cover");

            text_name6.setText(name6);
            area6.setText(ath6);
            circle6.setStroke(Color.SEAGREEN);
            Image im6 = new Image("photo/" + pic6, false);
            circle6.setFill(new ImagePattern(im6));
            circle6.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
            
            

        } catch (SQLException ex) {
            Logger.getLogger(Home_1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void button3(ActionEvent event) {
         OracleDataSource ods;

        
 


        try {
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            ods.setUser("project");
            ods.setPassword("4124101971");
            Connection con = ods.getConnection();
            Statement stm = con.createStatement();
            String search = text_search.getText();
            ////////////////
            String str_stm = "Select * from books  where typ='" + search + "' ";
            //  WHERE NAME = 'Hardik';

            ResultSet re = stm.executeQuery(str_stm);

            //   while (re.next()) {
            re.next();
            String name = re.getString("Bname");
            String ath = re.getString("Aname");
            String pic = re.getString("Cover");

            text_name1.setText(name);
            area1.setText(ath);
            circle1.setStroke(Color.SEAGREEN);
            Image im = new Image("photo/" + pic, false);
            circle1.setFill(new ImagePattern(im));
            circle1.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));

            re.next();
            String name2 = re.getString("Bname");
            String ath2 = re.getString("Aname");
            String pic2 = re.getString("Cover");

            text_name2.setText(name2);
            area2.setText(ath2);
            circle2.setStroke(Color.SEAGREEN);
            Image im2 = new Image("photo/" + pic2, false);
            circle2.setFill(new ImagePattern(im2));
            circle2.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));

            re.next();
            String name3 = re.getString("Bname");
            String ath3 = re.getString("Aname");
            String pic3 = re.getString("Cover");

            text_name3.setText(name3);
            area3.setText(ath3);
            circle3.setStroke(Color.SEAGREEN);
            Image im3 = new Image("photo/" + pic3, false);
            circle3.setFill(new ImagePattern(im3));
            circle3.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
            
            
            
             re.next();
            String name4 = re.getString("Bname");
            String ath4 = re.getString("Aname");
            String pic4 = re.getString("Cover");

            text_name4.setText(name4);
            area4.setText(ath4);
            circle4.setStroke(Color.SEAGREEN);
            Image im4 = new Image("photo/" + pic4, false);
            circle4.setFill(new ImagePattern(im4));
            circle4.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));

            re.next();
            String name5 = re.getString("Bname");
            String ath5 = re.getString("Aname");
            String pic5 = re.getString("Cover");

            text_name5.setText(name5);
            area5.setText(ath5);
            circle5.setStroke(Color.SEAGREEN);
            Image im5 = new Image("photo/" + pic5, false);
            circle5.setFill(new ImagePattern(im5));
            circle5.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));

            re.next();
            String name6 = re.getString("Bname");
            String ath6 = re.getString("Aname");
            String pic6 = re.getString("Cover");

            text_name6.setText(name6);
            area6.setText(ath6);
            circle6.setStroke(Color.SEAGREEN);
            Image im6 = new Image("photo/" + pic6, false);
            circle6.setFill(new ImagePattern(im6));
            circle6.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
            
            

        } catch (SQLException ex) {
            Logger.getLogger(Home_1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML
    void button4(ActionEvent event) throws IOException {
    Parent tabelViewParent = FXMLLoader.load(getClass().getResource("danaTOP.fxml"));
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();

    }
    }
    

