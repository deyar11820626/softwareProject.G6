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
import javax.swing.JOptionPane;
import java.io.File; 
import java.sql.Statement;
import oracle.jdbc.pool.OracleDataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
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

/**
 * FXML Controller class
 *
 * @author user
 */
public class viewbookController implements Initializable {

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
    @FXML
    private TableColumn<custf, String> t7;
    @FXML
    private TableColumn<custf, String> t8;
    @FXML
    private TableColumn<custf, String> t9;
    @FXML
    private TableColumn<custf, String> t10;
  @FXML
    private TableColumn<custf, String> t11;
    
    
        private  Connection cone=null;
    private  PreparedStatement pstt=null;
    private ResultSet rs=null;
    ObservableList <viewbookController.custf> data =FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
/*
            OracleDataSource ods = new OracleDataSource();
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("c##marah1");
            ods.setPassword("123456");
            Connection con = ods.getConnection();
            Statement stm = con.createStatement();
            String str_stm = "Select * from Books";
            ResultSet rs = stm.executeQuery(str_stm);
            */


    DriverManager.registerDriver(new
                oracle.jdbc.driver.OracleDriver());
            Connection cone=DriverManager.getConnection
        ("jdbc:oracle:thin:@localhost:1521:xe","c##marah1","123456");

            PreparedStatement pstt = cone.prepareStatement("Select * from Books");
            rs=pstt.executeQuery();  
        
             while(rs.next()){
             String BID = String.valueOf(rs.getInt("Bid")) ;
             String HARDC = String.valueOf(rs.getInt("Hardc")) ;
             String RATE = String.valueOf(rs.getInt("Rate")) ;
             String PH = String.valueOf(rs.getInt("Ph")) ;
             String PS = String.valueOf(rs.getInt("Pc")) ;
             
         data.add(new viewbookController.custf(BID ,rs.getString("Bname"),rs.getString("Aname"),rs.getString("Des"),rs.getString("Typ"),rs.getString("Cover"),rs.getString("Pdf"),HARDC,RATE,PH,PS));
       
              }
            table4.getColumns().addAll(t11,t1, t2,t3,t4,t5,t6,t7,t8,t9,t10) ;

           table4.setItems(data);
          t11.setCellValueFactory(cellData -> cellData.getValue().c1);
          t1.setCellValueFactory(cellData -> cellData.getValue().c2);
          t2.setCellValueFactory(cellData -> cellData.getValue().c3);
          t3.setCellValueFactory(cellData -> cellData.getValue().c4);
          t4.setCellValueFactory(cellData -> cellData.getValue().c5);
          t5.setCellValueFactory(cellData -> cellData.getValue().c6);
          t6.setCellValueFactory(cellData -> cellData.getValue().c7);
          t7.setCellValueFactory(cellData -> cellData.getValue().c8);
          t8.setCellValueFactory(cellData -> cellData.getValue().c9);
          t9.setCellValueFactory(cellData -> cellData.getValue().c10);
          t10.setCellValueFactory(cellData -> cellData.getValue().c11);
          
        }
            
            
            
            
            
/*
            while (re.next()) {
                 int bid = re.getInt("Bid");
              String bname = re.getString("Bname");
                System.out.print(bname);
                String aname = re.getString("Aname");
                  
                String desc = re.getString("Des");
                String typ = re.getString("Typ");
            //    String photo_path = "photo/" + re.getString("cover");
           String photo_path=re.getString("Cover");
           String pdf = re.getString("Pdf");
                int hardc = re.getInt("Hardc");
                int rate = re.getInt("Rate");
                int ph = re.getInt("Ph");
                int ps = re.getInt("Ps");
                
             
//                ImageView img = new ImageView(new Image(this.getClass().getResource(photo_path).toString(), true));
//                img.setFitHeight(90);
//                img.setFitWidth(90);
                data.add(new classprod(bid,bname, aname, desc, typ,  photo_path,pdf, hardc, rate, ph, ps));

            }
             t11.setCellValueFactory(new PropertyValueFactory<classprod,Integer>("Bid"));
            t1.setCellValueFactory(new PropertyValueFactory<classprod, String>("book"));
            t2.setCellValueFactory(new PropertyValueFactory<classprod, String>("auther"));
            t3.setCellValueFactory(new PropertyValueFactory<classprod, String>("description"));
            t4.setCellValueFactory(new PropertyValueFactory<classprod, String>("type"));
            t5.setCellValueFactory(new PropertyValueFactory<classprod, String>("cover"));
            t10.setCellValueFactory(new PropertyValueFactory<classprod, String>("Pdf"));
            t6.setCellValueFactory(new PropertyValueFactory<classprod, Integer>("hard"));
            t7.setCellValueFactory(new PropertyValueFactory<classprod, Integer>("Rate"));
            t8.setCellValueFactory(new PropertyValueFactory<classprod, Integer>("Ph"));
            t9.setCellValueFactory(new PropertyValueFactory<classprod, Integer>("Ps"));
           
            table4.setItems(data);
*/
         catch (Exception ex) {
              Logger.getLogger(viewbookController.class.getName()).log(Level.SEVERE, null, ex);
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
        String str_st = "delete from Books where Bid = '"+ id.getValue()+"'"  ;
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
        Parent tabelViewParent = FXMLLoader.load(getClass().getResource("Adminpage.fxml"));
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
        
        
    }
public class custf {

      
        private final SimpleStringProperty c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11;
        
         private custf(String v1 , String v2 ,String v3, String v4 , String v5 , String v6 ,String v7 , String v8 , String v9 , String v10 , String v11) {
             
              this.c1 = new SimpleStringProperty(v1);
            this.c2 = new SimpleStringProperty(v2);
            this.c3 = new SimpleStringProperty(v3);
            this.c4 = new SimpleStringProperty(v4);
            this.c5 = new SimpleStringProperty(v5);
            this.c6 = new SimpleStringProperty(v6);
            this.c7 = new SimpleStringProperty(v7);
            this.c8 = new SimpleStringProperty(v8);
             this.c9 = new SimpleStringProperty(v9);
              this.c10 = new SimpleStringProperty(v10);
               this.c11 = new SimpleStringProperty(v11);
             
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
       public SimpleStringProperty getc7() {
            return c7;
        }
      public SimpleStringProperty getc8() {
            return c8;
        }
      public SimpleStringProperty getc9() {
            return c9;
        }
      public SimpleStringProperty getc10() {
            return c10;
        }
      public SimpleStringProperty getc11() {
            return c11;
        }
    }
  

}
