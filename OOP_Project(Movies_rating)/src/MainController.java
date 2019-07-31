
package project;

import com.jfoenix.controls.JFXButton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import jxl.Sheet;
import jxl.Workbook;
import jxl.Cell ;
import jxl.read.biff.BiffException;




public class MainController {
    @FXML
    private Label LabelID;
    
   
      @FXML
    private FlowPane container ;

    private List<Label> labels ;
@FXML
private Button loginbtn ;
    @FXML
    private TextField Username;
    @FXML
    private TextField Password;
    @FXML
    private TextField genre;
    @FXML
    private Label name1;
    @FXML
    private Label cast1;
    @FXML
    private Label director1;
    @FXML
    private Label rating1; 
     @FXML
    private Label name2;
    @FXML
    private Label cast2;
    @FXML
    private Label director2;
    @FXML
    private Label rating2; 
    @FXML
    private Label name3;
    @FXML
    private Label cast3;
    @FXML
    private Label director3;
    @FXML
    private Label rating3; 
    @FXML
    private TextField Register1;
    @FXML
    private TextField Register2;
    @FXML
    private Label TryAgain;
    @FXML
    private Label labelregister;
    @FXML
    private Button registerbtn ;
@FXML
    private Button signupbtn ;
@FXML
    private Button login1btn ;
@FXML
    private Button signoutbtn ;

    Stage primaryStage2 = new Stage();
    Stage primaryStage3 = new Stage();
     Stage primaryStage4 = new Stage();
     Stage primaryStage5 = new Stage();
     Stage primaryStage6 = new Stage();
    int j = 0 ;
   public void Login(ActionEvent event)throws Exception{
    File file = new File("C:\\Users\\Muhammad Talha\\Desktop\\Project\\src\\project\\users.txt");
       Scanner scanner = new Scanner(file);
       String id = Username.getText();
       String pass = Password.getText();
       
       int found = 0;
       if(id.length() != 0 && pass.length() != 0){
       while(scanner.hasNext()){
           String line1 = scanner.nextLine().toLowerCase().toString();
                    
                    if(line1.contains(id)  &&  line1.contains(pass) ){
                        LabelID.setText("Login Success");
        
        
        
                    Parent root = FXMLLoader.load(getClass().getResource("firstpage.fxml"));
                    Scene scene = new Scene(root);

                    scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
                    primaryStage2.initStyle(StageStyle.UNDECORATED);

                    primaryStage2.setScene(scene);

                    primaryStage2.show();
                    found++;     
                     Stage loginStage = (Stage)loginbtn.getScene().getWindow();
                   loginStage.close();
                     Stage signupStage = (Stage)registerbtn.getScene().getWindow();
                   signupStage.close();
                   
       }}}
                    if(found==0 ){
                        LabelID.setText("Incorrect user name or Password");
                    }
       }
   
   public void exit (ActionEvent e) throws Exception{
       
       System.exit(1);
   }
        
   public void signout (ActionEvent event) throws Exception{
       
       
                  showLogin();
       Stage signoutStage = (Stage)signoutbtn.getScene().getWindow();
                   signoutStage.close();
   }
   public void search(ActionEvent event)throws Exception{
         int q = 0;
         int i = 0 ;
         
         String check = ((JFXButton)event.getSource()).getText();
      if(((JFXButton)event.getSource()).getText().equals( "Search")){
            j = 0 ;
       }
       String search = genre.getText().toLowerCase();
     File file = new File("C:\\Users\\Muhammad Talha\\Desktop\\Project\\src\\project\\list.xls");
        Workbook wb = Workbook.getWorkbook(file);
        Sheet s = wb.getSheet(0);
        int row = s.getRows() ;
        int col = s.getColumns() ;
        String cellvalue = "";
        int index = 0 ;
        
       
String[] nameArray = new String [4] ;
String[] directorArray = new String[4];
String[] castArray  = new String[4];
String[] ratingArray = new String[4];

          Cell c2 = null ;
            for( ; j< row; j++){
                Cell c =s.getCell(3, j) ;
                
                   cellvalue = c.getContents();
                   
                   index = cellvalue.toLowerCase().indexOf(search);
                   
                if(index > -1 && search.length()>= 4){
                          
                    
                         c2 = s.getCell(0, j);
                        System.out.println("name :" + c2.getContents()); 
                        nameArray[i] = c2.getContents();
                        Cell c3 = s.getCell(1, j);
                        System.out.println("Director :" + c3.getContents()); 
                        directorArray[i] = c3.getContents();
                        Cell c4 = s.getCell(2, j);
                        System.out.println("Cast :" + c4.getContents());
                        castArray[i] = c4.getContents();
                        Cell c5 = s.getCell(5, j);
                        System.out.println("Rating :" + c5.getContents()); 
                        ratingArray[i] = c5.getContents();
                      
                     
                        i++;
                
            }
     if (i>2)
         break;
            }
            
                        name1.setText(nameArray[0]);
                         director1.setText(directorArray[0]);
                        rating1.setText(ratingArray[0]);
                        cast1.setText( castArray[0]);
                         name2.setText(nameArray[1]);
                        director2.setText(directorArray[1]);
                       rating2.setText(ratingArray[1]);
                       cast2.setText( castArray[1]);
                       name3.setText(nameArray[2]);
                        director3.setText(directorArray[2]);
                       rating3.setText(ratingArray[2]);
                       cast3.setText( castArray[2]);

            
   }
   
        public void seeMore(ActionEvent event) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("firstpage.fxml"));
         Scene scene1 = new Scene(root);
        

       primaryStage2.setScene(scene1);
        primaryStage2.show();
        //search(ActionEvent e);
        }
         public void SignUp9(ActionEvent event) throws Exception{
            Parent root3 = FXMLLoader.load(getClass().getResource("signup.fxml"));
            
            Scene scene2 = new Scene(root3);
             primaryStage3.initStyle(StageStyle.UNDECORATED);
            primaryStage3.setScene(scene2);
            primaryStage3.show();   
             Stage signupStage = (Stage)signupbtn.getScene().getWindow();
                   signupStage.close();
        }
           public void login1(ActionEvent event) throws IOException{
               
                    showLogin();
                    
                     Stage login1Stage = (Stage)login1btn.getScene().getWindow();
                   login1Stage.hide();
                    
        }
        public void reigster(ActionEvent event) throws FileNotFoundException, IOException{
         
            File file = new File("C:\\Users\\Muhammad Talha\\Desktop\\Project\\src\\project\\users.txt");
            Scanner scanner = new Scanner(file);
        
                int found = 0 ;
                String line = Register1.getText()  ;
            //   int linecount = 0 ;
           
                while(scanner.hasNext()){
                    
                     String line1 = scanner.nextLine().toLowerCase().toString();
                    
                    if(line1.contains(line) ){
                       TryAgain.setText("Username already exist ");
                       found++;
                       break;
                      
                    }}
                 if (Register2.getText().length() == 0 ){
                    TryAgain.setText("Please enter the password");
                }
                 if (Register1.getText().length() == 0 ){
                    TryAgain.setText("Please enter the username");
                 }
                
                   if(found == 0 && Register2.getText().length() > 0){         
                         System.out.printf("Does not exist");
                         writefile();
                         TryAgain.setText("You have registered");
                         
                    showLogin();
                  
                   Stage signupStage = (Stage)loginbtn.getScene().getWindow();
                   signupStage.close();
            
                   }
}
            
        public void writefile() throws IOException{
            FileWriter f = new FileWriter("C:\\Users\\Muhammad Talha\\Desktop\\Project\\src\\project\\users.txt",true);
                      Formatter output = new Formatter(f); 
                      output.format("%-10s %-10s %n", Register1.getText() ,Register2.getText());
                      output.flush();
        }
        
         public void showLogin()   {
                try{
                    
                
                    Parent root = FXMLLoader.load(getClass().getResource("latest_login.fxml"));
                    Scene scene = new Scene(root);

                    primaryStage4.setScene(scene);
                    primaryStage4.initStyle(StageStyle.UNDECORATED);
                    
                    primaryStage4.show();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
       }
}
            
          



