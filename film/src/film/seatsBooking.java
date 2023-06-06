
package film;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class seatsBooking extends Application {
    String MovName ;
    private String host ;
        private Connection con;
        private Statement stmt;
        private InputStream stream;
    public Scene createBookScene(int Rnum){
        String SeatsList[] = new String[60];
        for(int i = 0 ; i < 60 ; i++){
            SeatsList[i] = i+1 + "";
        }
                   
                ComboBox Seats = new ComboBox(FXCollections.observableArrayList(SeatsList));
                Seats.setPrefSize(20, 7);
         Label Room = new Label("Room" + Rnum);
         Room.setStyle("-fx-Font-size : 20");
         Button Book = new Button("Book now");
         Book.setStyle("-fx-background-color: RED");
         Book.setOnMouseEntered(e->{
         Book.setStyle("-fx-background-color: BLUE");
         
         });
         Book.setOnMouseExited(e->{
                  Book.setStyle("-fx-background-color: RED");

         });
         
         
         VBox lay = new VBox(Room,Seats , Book);
         lay.setSpacing(10);
         lay.setAlignment(Pos.CENTER);
         Scene scene = new Scene(lay , 400 , 400);
         return scene;

    } 

    @Override
    public void start(Stage s) throws Exception {
        int Rnum = 0;
         try{
                
                    this.host = "jdbc:derby://localhost:1527/filmflow";
                    this.con = DriverManager.getConnection(host);

                    this.stmt = con.createStatement();

                    String CountSQL = "select * from ROOMS where MOVIE_NAME = MovieName ";
                    ResultSet rs = stmt.executeQuery(CountSQL);
                    int count = 1;
                   rs.next();
                   Rnum= rs.getInt("ROOM_NUM");
                   
                   
                   stmt.close();
                   rs.close();
                   this.stmt = con.createStatement();

                    String CounSQL = "select * from SEATS where MOVIENAME = MovieName AND ROOMNUM = Rnum ";
                    ResultSet rs1 = stmt.executeQuery(CounSQL);
                    rs1.next();
                
                } catch(SQLException er){
                    System.out.println(er);
                }
        
        s.setScene(createBookScene(Rnum));
        
        s.show();
       



    }
    
    public static void main(String args[]){
     launch(args);
    }
    
}
