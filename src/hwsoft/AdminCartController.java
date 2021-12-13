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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class AdminCartController implements Initializable {

    @FXML
    private TableView<custf> table4;
  
    @FXML
    private TableColumn<custf, String> t2;
    @FXML
    private TableColumn<custf, String> t3;
    
    @FXML
    private TableColumn<custf, String> t5;
    @FXML
    private TableColumn<custf, String> t6;
 
  private  Connection cone=null;
    private  PreparedStatement pstt=null;
    private ResultSet rs=null;
    ObservableList <AdminCartController.custf> data =FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {



    DriverManager.registerDriver(new
                oracle.jdbc.driver.OracleDriver());
            Connection cone=DriverManager.getConnection
        ("jdbc:oracle:thin:@localhost:1521:xe","c##marah1","123456");

            PreparedStatement pstt = cone.prepareStatement("Select * from ShoppingBag");
            rs=pstt.executeQuery();  
        
             while(rs.next()){
            // String BID = String.valueOf(rs.getInt("")) ;
             String bQuantity = String.valueOf(rs.getInt("bQuantity")) ;
            // String bname = String.valueOf(rs.getInt("bname")) ;
             String ProPrice = String.valueOf(rs.getInt("ProPrice")) ;
          
             
        data.add(new AdminCartController.custf(rs.getString("Email"),bQuantity,rs.getString("bname"),ProPrice));
       
              }
            table4.getColumns().addAll( t2,t3,t5,t6) ;

           table4.setItems(data);
          
         // t1.setCellValueFactory(cellData -> cellData.getValue().c1);
          t2.setCellValueFactory(cellData -> cellData.getValue().c2);
          t3.setCellValueFactory(cellData -> cellData.getValue().c3);
   
          t5.setCellValueFactory(cellData -> cellData.getValue().c5);
          t6.setCellValueFactory(cellData -> cellData.getValue().c6);
       
         
          
        }
            
            
            
 
         catch (Exception ex) {
              Logger.getLogger(AdminCartController.class.getName()).log(Level.SEVERE, null, ex);
//            Logger.getLogger(showProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    
    
    
      @FXML
    private void back(ActionEvent event) throws IOException {
        Parent tabelViewParent = FXMLLoader.load(getClass().getResource("Adminpage.fxml"));
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
        
        
    }
public class custf {

      
        private final SimpleStringProperty c2,c3,c5,c6;
        
         private custf( String v2 ,String v3, String v5 , String v6 ) {
             
             // this.c1 = new SimpleStringProperty(v1);
            this.c2 = new SimpleStringProperty(v2);
            this.c3 = new SimpleStringProperty(v3);
           // this.c4 = new SimpleStringProperty(v4);
            this.c5 = new SimpleStringProperty(v5);
            this.c6 = new SimpleStringProperty(v6);
     
             
         }


        public SimpleStringProperty getc2() {
            return c2;
        }
         public SimpleStringProperty getc3() {
            return c3;
        }

      //  public SimpleStringProperty getc4() {
       //     return c4;
      //  }

        public SimpleStringProperty getc5() {
            return c5;
        }

        public SimpleStringProperty getc6() {
            return c6;
        }
      
 
    }    
    
}
