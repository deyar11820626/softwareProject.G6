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
import java.sql.SQLException;
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

/**
 * FXML Controller class
 *
 * @author Marah qubbbaj
 */
public class AdmintableController implements Initializable {

    @FXML
    private TableView<custa> table1;
    
    @FXML
    private TableColumn<custa,String> c1;
    @FXML
    private TableColumn<custa,String> c2;
@FXML
    private TableColumn<custa,String> c3;

    /**
     * Initializes the controller class.
     */
   private  Connection cone=null;
    private  PreparedStatement pst=null;
    private ResultSet rs=null;
    ObservableList <AdmintableController.custa> data =FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try{
            DriverManager.registerDriver(new
                oracle.jdbc.driver.OracleDriver());
            Connection cone=DriverManager.getConnection
        ("jdbc:oracle:thin:@localhost:1521:xe","c##marah1","123456");

            PreparedStatement pst = cone.prepareStatement("Select * from Reservations");
            rs=pst.executeQuery();
            
              while(rs.next()){
                  
                  
           data.add(new AdmintableController.custa(rs.getString("R_NO"),rs.getString("Email"),rs.getString("BNAME")));
         
              }
           table1.getColumns().addAll(c1,c2,c3) ;

           table1.setItems(data);
        
          c1.setCellValueFactory(cellData -> cellData.getValue().t11);
          c2.setCellValueFactory(cellData -> cellData.getValue().t22);
          c3.setCellValueFactory(cellData -> cellData.getValue().t33);
       
   
        }
              
       catch (SQLException ex) {
            Logger.getLogger(AdmintableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

  
    
    
        public class custa{

      
        private final SimpleStringProperty t11,t22,t33;
        
         private custa(String c1,String c2 ,String c3) {
            
            this.t11 = new SimpleStringProperty(c1);
             this.t22 = new SimpleStringProperty(c2);
              this.t33 = new SimpleStringProperty(c3);
         
           
        }

       public SimpleStringProperty gett11() {
            return t11;
        }
       public SimpleStringProperty gett22() {
            return t22;
        }
       public SimpleStringProperty gett33() {
            return t33;
        }
       

      
    }
        @FXML
    void back(ActionEvent event)throws IOException {
           Parent tabelViewParent = FXMLLoader.load(getClass().getResource("Adminpage.fxml"));
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
        

    }
}
