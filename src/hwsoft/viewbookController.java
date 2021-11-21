/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwsoft;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import oracle.jdbc.pool.OracleDataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class viewbookController implements Initializable {

    @FXML
    private TableView<classprod> table4;
    @FXML
    private TableColumn<classprod, String> t1;
    @FXML
    private TableColumn<classprod, String> t2;
    @FXML
    private TableColumn<classprod, String> t3;
    @FXML
    private TableColumn<classprod, String> t4;
    @FXML
    private TableColumn<classprod, String> t5;
    @FXML
    private TableColumn<classprod, Integer> t6;
    @FXML
    private TableColumn<classprod, Integer> t7;
    @FXML
    private TableColumn<classprod, Integer> t8;
    @FXML
    private TableColumn<classprod, Integer> t9;
    @FXML
    private TableColumn<classprod, String> t10;

    ObservableList<classprod> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            OracleDataSource ods = new OracleDataSource();
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            ods.setUser("project");
            ods.setPassword("4124101971");
            Connection con = ods.getConnection();
            Statement stm = con.createStatement();
            String str_stm = "Select * from books";
            ResultSet re = stm.executeQuery(str_stm);

            while (re.next()) {
              String bname = re.getString("bname");
                System.out.print(bname);
                String aname = re.getString("aname");
                  
                String desc = re.getString("des");
                String typ = re.getString("typ");
            //    String photo_path = "photo/" + re.getString("cover");
           String photo_path=re.getString("cover");
                int hardc = re.getInt("hardc");
                int rate = re.getInt("rate");
                int ph = re.getInt("ph");
                int ps = re.getInt("ps");
                String pdf = re.getString("pdf");

//                ImageView img = new ImageView(new Image(this.getClass().getResource(photo_path).toString(), true));
//                img.setFitHeight(90);
//                img.setFitWidth(90);
                data.add(new classprod(bname, aname, desc, typ,  photo_path, hardc, rate, ph, ps, pdf));

            }
            t1.setCellValueFactory(new PropertyValueFactory<classprod, String>("book"));
            t2.setCellValueFactory(new PropertyValueFactory<classprod, String>("auther"));
            t3.setCellValueFactory(new PropertyValueFactory<classprod, String>("description"));
            t4.setCellValueFactory(new PropertyValueFactory<classprod, String>("type"));
            t5.setCellValueFactory(new PropertyValueFactory<classprod, String>("cover"));
            t6.setCellValueFactory(new PropertyValueFactory<classprod, Integer>("hard"));
            t7.setCellValueFactory(new PropertyValueFactory<classprod, Integer>("Rate"));
            t8.setCellValueFactory(new PropertyValueFactory<classprod, Integer>("Ph"));
            t9.setCellValueFactory(new PropertyValueFactory<classprod, Integer>("Ps"));
            t10.setCellValueFactory(new PropertyValueFactory<classprod, String>("Pdf"));

            table4.setItems(data);

        } catch (Exception ex) {
//            Logger.getLogger(showProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void delete(ActionEvent event) {
     
       
       if (table4.getSelectionModel().getSelectedItem() == null){
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Error Message");
           alert.setHeaderText("Delete Error");
           alert.setContentText("you must selcet a book to delete");
           alert.showAndWait();
       }
       else{
           String idd = table4.getSelectionModel().getSelectedItem().getBook();
           JOptionPane.showMessageDialog(null,idd);
           table4.getItems().removeAll(table4.getSelectionModel().getSelectedItem());
           
           try{
               DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
               String str = "jdbc:oracle:thin:@localhost:1521:orcl";
               Connection con = DriverManager.getConnection(str , "project","4124101971");
               String str_st = "delete from books where bname = '"+ idd + "'"  ;
               PreparedStatement pst = con.prepareStatement(str_st);
               pst.executeUpdate();
           }
           catch(SQLException ex){
                          JOptionPane.showMessageDialog(null,ex.toString());

               
           }
       }

        
        
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
