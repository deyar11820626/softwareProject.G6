/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint2;

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
    private TableColumn<custf, String> t1;
    @FXML
    private TableColumn<custf, String> t2;
    @FXML
    private TableColumn<custf, String> t3;
    @FXML
    private TableColumn<custf, String> t4;
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
             String BID = String.valueOf(rs.getInt("BID")) ;
             String bQuantity = String.valueOf(rs.getInt("bQuantity")) ;
            // String bname = String.valueOf(rs.getInt("bname")) ;
             String ProPrice = String.valueOf(rs.getInt("ProPrice")) ;
          
             
        data.add(new AdminCartController.custf(BID ,rs.getString("Email"),rs.getString("bname"),rs.getString("username"),bQuantity,ProPrice));
       
              }
            table4.getColumns().addAll(t1, t2,t3,t4,t5,t6) ;

           table4.setItems(data);
          
          t1.setCellValueFactory(cellData -> cellData.getValue().c1);
          t2.setCellValueFactory(cellData -> cellData.getValue().c2);
          t3.setCellValueFactory(cellData -> cellData.getValue().c3);
          t4.setCellValueFactory(cellData -> cellData.getValue().c4);
          t5.setCellValueFactory(cellData -> cellData.getValue().c5);
          t6.setCellValueFactory(cellData -> cellData.getValue().c6);
       
         
          
        }
            
            
            
 
         catch (Exception ex) {
              Logger.getLogger(AdminCartController.class.getName()).log(Level.SEVERE, null, ex);
//            Logger.getLogger(showProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
@FXML
    private void delete(ActionEvent event) {
     
         SimpleStringProperty id = table4.getSelectionModel().getSelectedItem().c1;
        //JOptionPane.showMessageDialog(null, id.getValue());
       try{ 
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        String str = "jdbc:oracle:thin:@localhost:1521:xe" ;
        Connection con = DriverManager.getConnection(str ,"c##marah1" , "123456" );
        String str_st = "delete from ShoppingBag where Bid = '"+ id.getValue()+"'"  ;
        PreparedStatement pst = con.prepareStatement(str_st);
        pst.executeUpdate();
        con.setAutoCommit(true);
            //    con.commit();
                  con.close();
       table4.getItems().removeAll(table4.getSelectionModel().getSelectedItem());
          }
           catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex.toString());
         }
      // table4.getItems().removeAll(table4.getSelectionModel().getSelectedItem());

        
    }
    
    
    
      @FXML
    private void back(ActionEvent event) throws IOException {
        Parent tabelViewParent = FXMLLoader.load(getClass().getResource("adminpage.fxml"));
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
        
        
    }
public class custf {

      
        private final SimpleStringProperty c1,c2,c3,c4,c5,c6;
        
         private custf(String v1 , String v2 ,String v3, String v4 , String v5 , String v6 ) {
             
              this.c1 = new SimpleStringProperty(v1);
            this.c2 = new SimpleStringProperty(v2);
            this.c3 = new SimpleStringProperty(v3);
            this.c4 = new SimpleStringProperty(v4);
            this.c5 = new SimpleStringProperty(v5);
            this.c6 = new SimpleStringProperty(v6);
     
             
         }
              public SimpleStringProperty getc1() {
            return c1;
        }

        public SimpleStringProperty getc2() {
            return c2;
        }
         public SimpleStringProperty getc3() {
            return c3;
        }

        public SimpleStringProperty getc4() {
            return c4;
        }

        public SimpleStringProperty getc5() {
            return c5;
        }

        public SimpleStringProperty getc6() {
            return c6;
        }
      
 
    }    
    
}
