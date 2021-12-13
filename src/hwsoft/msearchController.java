/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwsoft;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.scene.control.TextArea;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import oracle.jdbc.pool.OracleDataSource;



/**
 * FXML Controller class
 *
 * @author user
 */
public class msearchController implements Initializable {


    @FXML
    private TextField text_search;

    @FXML
    private Button button;

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
    private ImageView c1;

    @FXML
    private ImageView c2;

    @FXML
    private ImageView c3;

    @FXML
    private ImageView c4;

    @FXML
    private ImageView c5;

    @FXML
    private ImageView c6;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void button(ActionEvent event)  {
        
              OracleDataSource ods;

        
 


        try {
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("c##marah1");
            ods.setPassword("123456");
            Connection con = ods.getConnection();
            Statement stm = con.createStatement();
            String search = text_search.getText();
            ////////////////
            String str_stm = "Select * from Books  where Bname='" + search + "' ";
            //  WHERE NAME = 'Hardik';

            ResultSet re = stm.executeQuery(str_stm);

            //   while (re.next()) {
            re.next();
            String name = re.getString("Bname");
            String ath = re.getString("Aname");
            String pic = re.getString("Cover");

            text_name1.setText(name);
            area1.setText(ath);
            
             c1.autosize();
    c1.setImage(new Image("photo/"+pic, c1.getFitWidth(), c1.getFitHeight(), true, false)); 
            
            /*
            circle1.setStroke(Color.SEAGREEN);
            Image im = new Image("photo/" + pic, false);
            circle1.setFill(new ImagePattern(im));
            circle1.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
*/
            
            
            
            re.next();
            String name2 = re.getString("Bname");
            String ath2 = re.getString("Aname");
            String pic2 = re.getString("Cover");

            text_name2.setText(name2);
            area2.setText(ath2);
            c2.autosize();
    c2.setImage(new Image("photo/"+pic2, c2.getFitWidth(), c2.getFitHeight(), true, false)); 
            
            
            
            /*
            circle2.setStroke(Color.SEAGREEN);
            Image im2 = new Image("photo/" + pic2, false);
            circle2.setFill(new ImagePattern(im2));
            circle2.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
*/
            re.next();
            String name3 = re.getString("Bname");
            String ath3 = re.getString("Aname");
            String pic3 = re.getString("Cover");

            text_name3.setText(name3);
            area3.setText(ath3);
            c3.autosize();
    c3.setImage(new Image("photo/"+pic3, c3.getFitWidth(), c3.getFitHeight(), true, false)); 
            
            /*
            circle3.setStroke(Color.SEAGREEN);
            Image im3 = new Image("photo/" + pic3, false);
            circle3.setFill(new ImagePattern(im3));
            circle3.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
            */
            
            
             re.next();
            String name4 = re.getString("Bname");
            String ath4 = re.getString("Aname");
            String pic4 = re.getString("Cover");

            text_name4.setText(name4);
            area4.setText(ath4);
            
            c4.autosize();
    c4.setImage(new Image("photo/"+pic4, c4.getFitWidth(), c4.getFitHeight(), true, false)); 
            
            /*
            circle4.setStroke(Color.SEAGREEN);
            Image im4 = new Image("photo/" + pic4, false);
            circle4.setFill(new ImagePattern(im4));
            circle4.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
*/
            re.next();
            String name5 = re.getString("Bname");
            String ath5 = re.getString("Aname");
            String pic5 = re.getString("Cover");

            text_name5.setText(name5);
            area5.setText(ath5);
            c5.autosize();
    c5.setImage(new Image("photo/"+pic5, c5.getFitWidth(), c5.getFitHeight(), true, false)); 
            /*
            circle5.setStroke(Color.SEAGREEN);
            Image im5 = new Image("photo/" + pic5, false);
            circle5.setFill(new ImagePattern(im5));
            circle5.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
*/
            re.next();
            String name6 = re.getString("Bname");
            String ath6 = re.getString("Aname");
            String pic6 = re.getString("Cover");

            text_name6.setText(name6);
            area6.setText(ath6);
            c6.autosize();
    c6.setImage(new Image("photo/"+pic6, c6.getFitWidth(), c6.getFitHeight(), true, false)); 
            
            
            /*
            circle6.setStroke(Color.SEAGREEN);
            Image im6 = new Image("photo/" + pic6, false);
            circle6.setFill(new ImagePattern(im6));
            circle6.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
            */
            

        } catch (SQLException ex) {
            Logger.getLogger(msearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void button2(ActionEvent event) {
        OracleDataSource ods;

        
 


        try {
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("c##marah1");
            ods.setPassword("123456");
            Connection con = ods.getConnection();
            Statement stm = con.createStatement();
            String search = text_search.getText();
            ////////////////
            String str_stm = "Select * from Books  where Aname='" + search + "' ";
            //  WHERE NAME = 'Hardik';

            ResultSet re = stm.executeQuery(str_stm);

            //   while (re.next()) {
            re.next();
            String name = re.getString("Bname");
            String ath = re.getString("Aname");
            String pic = re.getString("Cover");

            text_name1.setText(name);
            area1.setText(ath);
            c1.autosize();
    c1.setImage(new Image("photo/"+pic, c1.getFitWidth(), c1.getFitHeight(), true, false)); 
            /*
            circle1.setStroke(Color.SEAGREEN);
            Image im = new Image("photo/" + pic, false);
            circle1.setFill(new ImagePattern(im));
            circle1.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
*/
            re.next();
            String name2 = re.getString("Bname");
            String ath2 = re.getString("Aname");
            String pic2 = re.getString("Cover");

            text_name2.setText(name2);
            area2.setText(ath2);
            
            
            c2.autosize();
    c2.setImage(new Image("photo/"+pic2, c2.getFitWidth(), c2.getFitHeight(), true, false)); 
            
            /*
            circle2.setStroke(Color.SEAGREEN);
            Image im2 = new Image("photo/" + pic2, false);
            circle2.setFill(new ImagePattern(im2));
            circle2.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
*/
            re.next();
            String name3 = re.getString("Bname");
            String ath3 = re.getString("Aname");
            String pic3 = re.getString("Cover");

            text_name3.setText(name3);
            area3.setText(ath3);
            
            
            c3.autosize();
    c3.setImage(new Image("photo/"+pic3, c3.getFitWidth(), c3.getFitHeight(), true, false)); 
            /*
            
            circle3.setStroke(Color.SEAGREEN);
            Image im3 = new Image("photo/" + pic3, false);
            circle3.setFill(new ImagePattern(im3));
            circle3.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
            
            */
            
             re.next();
            String name4 = re.getString("Bname");
            String ath4 = re.getString("Aname");
            String pic4 = re.getString("Cover");

            text_name4.setText(name4);
            area4.setText(ath4);
            
            c4.autosize();
    c4.setImage(new Image("photo/"+pic4, c4.getFitWidth(), c4.getFitHeight(), true, false)); 
            
            /*
            circle4.setStroke(Color.SEAGREEN);
            Image im4 = new Image("photo/" + pic4, false);
            circle4.setFill(new ImagePattern(im4));
            circle4.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
*/
            re.next();
            String name5 = re.getString("Bname");
            String ath5 = re.getString("Aname");
            String pic5 = re.getString("Cover");

            text_name5.setText(name5);
            area5.setText(ath5);
            
            c5.autosize();
    c5.setImage(new Image("photo/"+pic5, c5.getFitWidth(), c5.getFitHeight(), true, false)); 
            
            
            /*
            
            circle5.setStroke(Color.SEAGREEN);
            Image im5 = new Image("photo/" + pic5, false);
            circle5.setFill(new ImagePattern(im5));
            circle5.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
*/
            re.next();
            String name6 = re.getString("Bname");
            String ath6 = re.getString("Aname");
            String pic6 = re.getString("Cover");

            text_name6.setText(name6);
            area6.setText(ath6);
            
            
            c6.autosize();
    c6.setImage(new Image("photo/"+pic6, c6.getFitWidth(), c6.getFitHeight(), true, false)); 
            /*
            
            circle6.setStroke(Color.SEAGREEN);
            Image im6 = new Image("photo/" + pic6, false);
            circle6.setFill(new ImagePattern(im6));
            circle6.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
            */
            

        } catch (SQLException ex) {
            Logger.getLogger(msearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void button3(ActionEvent event) {
         OracleDataSource ods;

        
 


        try {
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("c##marah1");
            ods.setPassword("123456");
            Connection con = ods.getConnection();
            Statement stm = con.createStatement();
            String search = text_search.getText();
            ////////////////
            String str_stm = "Select * from Books  where Typ='" + search + "' ";
            //  WHERE NAME = 'Hardik';

            ResultSet re = stm.executeQuery(str_stm);

            //   while (re.next()) {
            re.next();
            String name = re.getString("Bname");
            String ath = re.getString("Aname");
            String pic = re.getString("Cover");

            text_name1.setText(name);
            area1.setText(ath);
            
             c1.autosize();
    c1.setImage(new Image("photo/"+pic, c1.getFitWidth(), c1.getFitHeight(), true, false)); 
            /*
            circle1.setStroke(Color.SEAGREEN);
            Image im = new Image("photo/" + pic, false);
            circle1.setFill(new ImagePattern(im));
            circle1.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
*/
            re.next();
            String name2 = re.getString("Bname");
            String ath2 = re.getString("Aname");
            String pic2 = re.getString("Cover");

            text_name2.setText(name2);
            area2.setText(ath2);
            
            c2.autosize();
    c2.setImage(new Image("photo/"+pic2, c2.getFitWidth(), c2.getFitHeight(), true, false)); 
            /*
            circle2.setStroke(Color.SEAGREEN);
            Image im2 = new Image("photo/" + pic2, false);
            circle2.setFill(new ImagePattern(im2));
            circle2.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
*/
            re.next();
            String name3 = re.getString("Bname");
            String ath3 = re.getString("Aname");
            String pic3 = re.getString("Cover");

            text_name3.setText(name3);
            area3.setText(ath3);
            c3.autosize();
    c3.setImage(new Image("photo/"+pic3, c3.getFitWidth(), c3.getFitHeight(), true, false)); 
            /*
            circle3.setStroke(Color.SEAGREEN);
            Image im3 = new Image("photo/" + pic3, false);
            circle3.setFill(new ImagePattern(im3));
            circle3.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
            
            */
            
             re.next();
            String name4 = re.getString("Bname");
            String ath4 = re.getString("Aname");
            String pic4 = re.getString("Cover");

            text_name4.setText(name4);
            area4.setText(ath4);
             c4.autosize();
    c4.setImage(new Image("photo/"+pic4, c4.getFitWidth(), c4.getFitHeight(), true, false)); 
            /*
            circle4.setStroke(Color.SEAGREEN);
            Image im4 = new Image("photo/" + pic4, false);
            circle4.setFill(new ImagePattern(im4));
            circle4.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
*/
            re.next();
            String name5 = re.getString("Bname");
            String ath5 = re.getString("Aname");
            String pic5 = re.getString("Cover");

            text_name5.setText(name5);
            area5.setText(ath5);
             c5.autosize();
    c5.setImage(new Image("photo/"+pic5, c5.getFitWidth(), c5.getFitHeight(), true, false)); 
            /*
            circle5.setStroke(Color.SEAGREEN);
            Image im5 = new Image("photo/" + pic5, false);
            circle5.setFill(new ImagePattern(im5));
            circle5.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
*/
            re.next();
            String name6 = re.getString("Bname");
            String ath6 = re.getString("Aname");
            String pic6 = re.getString("Cover");

            text_name6.setText(name6);
            area6.setText(ath6);
            
             c6.autosize();
    c6.setImage(new Image("photo/"+pic6, c6.getFitWidth(), c6.getFitHeight(), true, false)); 
            /*
            circle6.setStroke(Color.SEAGREEN);
            Image im6 = new Image("photo/" + pic6, false);
            circle6.setFill(new ImagePattern(im6));
            circle6.setEffect((new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN)));
            */
            

        } catch (SQLException ex) {
            Logger.getLogger(msearchController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     @FXML
    void back(ActionEvent event)  throws IOException {
//    void button55(ActionEvent event) throws IOException {
//     Parent tabelViewParent = FXMLLoader.load(getClass().getResource("DanaTOP.fxml"));
//        Scene tabelViewScene = new Scene(tabelViewParent);
//
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(tabelViewScene);
//        window.show();
//
    }
    
//    @FXML
//    void button55(ActionEvent event) throws IOException {
//     Parent tabelViewParent = FXMLLoader.load(getClass().getResource("DanaTOP.fxml"));
//        Scene tabelViewScene = new Scene(tabelViewParent);
//
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(tabelViewScene);
//        window.show();
//
//    }
    
//        @FXML
//    void z1(ActionEvent event)throws IOException {
//         Parent tabelViewParent = FXMLLoader.load(getClass().getResource("DanaTOP.fxml"));
//        Scene tabelViewScene = new Scene(tabelViewParent);
//
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(tabelViewScene);
//        window.show();
//
//    }
    }
    

