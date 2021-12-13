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
public class NoController implements Initializable {

    @FXML
    private TableView<custff> re;
    @FXML
    private TableColumn<custff , String> ree;

     private  Connection cone=null;
    private  PreparedStatement pstt=null;
    private ResultSet rs=null;
    ObservableList <NoController.custff> data =FXCollections.observableArrayList();
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

            PreparedStatement pstt = cone.prepareStatement("select BNAME from Notifications  where Email ='"+SigninController.static_start_id+"'");
            rs=pstt.executeQuery();
            
              while(rs.next()){
                  
                  
           data.add(new NoController.custff(rs.getString("BNAME")));
         
              }
           re.getColumns().addAll(ree) ;

           re.setItems(data);
        
          ree.setCellValueFactory(cellData -> cellData.getValue().fe_ba);
       
   
        }
              
       catch (SQLException ex) {
            Logger.getLogger(NoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
       @FXML
    void back(ActionEvent event)  throws IOException{
                Parent tabelViewParent = FXMLLoader.load(getClass().getResource("Myhome.fxml"));
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
        

    }
    
    public class custff {

      
        private final SimpleStringProperty fe_ba;
        
         private custff(String chose ) {
            
            this.fe_ba = new SimpleStringProperty(chose);
         
           
        }

public SimpleStringProperty getfe_ba() {
            return fe_ba;
        }
       

      
    }
    
}
