/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwsoft;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import oracle.jdbc.pool.OracleDataSource;

/**
 * FXML Controller class
 *
 * @author user
 */

public class addbook implements Initializable {

    @FXML
    private JFXButton browse;
    @FXML
    private JFXButton addbook;
    @FXML
    private JFXTextField aname;
    @FXML
    private JFXTextField type;
    @FXML
    private JFXTextField rate;
    @FXML
    private JFXTextField hard;
    @FXML
    private JFXTextField ph;
    @FXML
    private TextArea about;
    @FXML
    private JFXTextField ps;
    @FXML
    private JFXTextField bname;


    @FXML
    private JFXTextField pdf;

    /**
     * Initializes the controller class.
     */
     String photo ;
     String pdff ;

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

          @FXML
    void addphoto(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        fc.setInitialDirectory(new File("C:/"));
        fc.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("png" , "JPEG"));
         photo = selectedFile.getName();
        JOptionPane.showMessageDialog(null, photo);

    }
    
    @FXML
    void addpdf(ActionEvent event) {
           FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        fc.setInitialDirectory(new File("C:/"));
        fc.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("pdf" , "PDF File"));
        pdff = selectedFile.getName();
        JOptionPane.showMessageDialog(null, pdff);  

    }
    @FXML
    private void addbook(ActionEvent event) {
        OracleDataSource ods;

        try {
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            ods.setUser("project");
            ods.setPassword("4124101971");
            Connection con = ods.getConnection();
            Statement stm = con.createStatement();
            
//                String ph = this.photo.getText();
//                String add = this.addbook.getText();
                String name = this.aname.getText();
                String tyype = this.type.getText();
                
             
             
              String about1 = this.about.getText();
             
              String name1 = this.bname.getText();
               
            
           String ps1 = this.ps.getText();
           int ps2=Integer.parseInt(ps1);
           String rate1 = this.rate.getText();
              int rate2=Integer.parseInt(rate1);
            String ph1 = this.ph.getText();
               int ph2=Integer.parseInt(ph1);
            
             String hard1 = this.hard.getText();
            int hard2=Integer.parseInt(hard1);
           

                String str_statment = "insert into books values(  '" + name1 + "', '" + name + "', '" + about1 + "','" + tyype+ "','" + photo + "','" + hard2 + "', '" + rate2 + "', '" +ph2 + "', '" + ps2 + "', '" + pdff + "' )" ;
                stm.executeUpdate(str_statment);
    }
        catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }

    }

    @FXML
    private void go_books(ActionEvent event) throws IOException {
        Parent tabelViewParent = FXMLLoader.load(getClass().getResource("books.fxml"));
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
    }
            @FXML
    private void back(ActionEvent event) throws IOException {
        Parent tabelViewParent = FXMLLoader.load(getClass().getResource("adminpage.fxml"));
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
        
        
    }
    
}
