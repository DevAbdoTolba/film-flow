package film;


import film.HomePage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.control.TextField;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Explorer extends Application {
        public static Stage primaryStage;
        // private static final Duration ANIMATION_DURATION = Duration.seconds(0.2);
        // private static final double BUTTON_SCALE_ON_HOVER = 1.1;
        public Payment pr = new Payment();
        
        private int pos;
       
        {
           this.pos = -1;
        }
       
       Explorer(){
        this.pos = -1;
       }
       
       Explorer(int pos){
        this.pos = pos;

       }
        
        private String host ;
        private Connection con;
        private Statement stmt;
        private InputStream stream;
        private int price;
        private int seats;
        
        
        
        @Override
        public void start(Stage primaryStage) throws IOException {
                primaryStage.setTitle("FilmFlow");
                
                Button adminBtn = createButton("Admin");
//                adminBtn.setPadding(new Insets(10));

                // Create BorderPane layout
                BorderPane borderPane = new BorderPane();
                // Create top bar with logo and login/sign up buttons
                BorderPane topBar = new BorderPane();

                topBar.setStyle("-fx-background-color: #191923; -fx-padding: 10px;");
                topBar.setPadding(new Insets(10, 10, 10, 10));

                // Create logo label and add it to logoBox
                Button logoButton = new Button("Film Flow");
                logoButton.setStyle(
                                "-fx-background-color: #191923; -fx-text-fill: #44cf6c; -fx-padding: 8px 16px; -fx-font-size: 40px; -fx-border-color: #191923; -fx-border-radius: 20;");
                topBar.setLeft(logoButton);
                // create taxt label
                VBox tv = new VBox();
                tv.setAlignment(Pos.CENTER);
                Text text = new Text("Welcome to FilmFlow");
                
                
                TextField searchFeild = new TextField();
                searchFeild.setPromptText("Search");
                searchFeild.setMaxSize(700, 10);
                Button searchBtn = createButton("Search");
                Button cancelSearchBtn = createButton("Cancel");

                searchBtn.setPrefWidth(150);
                searchBtn.setMaxWidth(200);
                
                cancelSearchBtn.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-border-radius: 20; -fx-background-color:  red; -fx-text-fill: black; -fx-padding: 8px 16px; -fx-font-size: 16px;");

                
                HBox searchBox = new HBox(searchBtn, cancelSearchBtn);
                searchBox.setAlignment(Pos.CENTER);
                searchBox.setPadding(new Insets(10, 10, 10, 10));
          
                
                text.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
                text.setStyle("-fx-background-color: #191923; -fx-text-fill: green; -fx-font-size: 40px; -fx-border-color: black; -fx-border-radius: 20;");
                text.setFill(Color.WHITE);
                tv.getChildren().addAll(searchFeild,searchBox);
                VBox.setMargin(text, new Insets(20, 20, 20, 450));
                topBar.setCenter(tv);
                
                adminBtn.setOnAction(e ->{
                    Admin adminPage = new Admin();
                    adminPage.start(new Stage());
                });
                
                if(pos == 1)
                {topBar.setRight(adminBtn);
                topBar.setPadding(new Insets(10));
                }

                logoButton.setOnAction(event -> {
                        primaryStage.close();
                        HomePage hp = new HomePage();
                        hp.start(new Stage());
                });

                BorderPane.setAlignment(topBar, Pos.CENTER_LEFT);
                borderPane.setTop(topBar);

                BorderPane root = new BorderPane();
                root.setPadding(new Insets(10));

                GridPane grid = new GridPane();
                grid.setHgap(10);
                grid.setVgap(10);
                


            




                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(grid);
                borderPane.setCenter(scrollPane);
                
                // Create main content area with title, description, and names
                VBox contentVBox = new VBox(20);
                contentVBox.setPadding(new Insets(20));
                contentVBox.setStyle("-fx-padding: 20px 0 0 30%;");

                Label titleLabel = createLabel("FilmFlow", FontWeight.BOLD, 80, Color.web("#191923"));
                contentVBox.getChildren().add(titleLabel);
                Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
                double screenWidth = screenBounds.getWidth();
                double screenHeight = screenBounds.getHeight();

                // ? Create a VBox to hold the Left Side Bar
                VBox navBoxL = new VBox();
                navBoxL.setPadding(new Insets(10));
                navBoxL.setSpacing(10);
                navBoxL.setStyle("-fx-background-color: #fff; -fx-padding: 60px;");

                // Add the buttons to the VBox

                // ? Create a VBox to hold the right Side Bar
                VBox navBoxR = new VBox();
                navBoxR.setPadding(new Insets(10));
                navBoxR.setSpacing(10);
                navBoxR.setStyle("-fx-background-color: #fff; -fx-padding: 60px;");

                // Add the VBox to the left side of the BorderPane
                borderPane.setLeft(navBoxL);
                borderPane.setRight(navBoxR);

                Scene scene = new Scene(borderPane, screenWidth, screenHeight);
                primaryStage.setScene(scene);
                primaryStage.setMaximized(true);
                
                cancelSearchBtn.setOnAction(e->{
                    grid.getChildren().clear();
                    
                    try{
                
                    this.host = "jdbc:derby://localhost:1527/filmflow";
                    this.con = DriverManager.getConnection(host);
                    
                    this.stmt = con.createStatement();
                    
                    String CountSQL = "SELECT * FROM MOVIES ORDER BY M_rate DESC";
                    
                    ResultSet rs = stmt.executeQuery(CountSQL);
                    int j = 1;
                    int i = 1;
                    int count = 1;
                    while(rs.next()){  
                            stream = new FileInputStream(rs.getString("IMAGELINK"));
                            String streamString = rs.getString("IMAGELINK");
                            
                            price = rs.getInt("M_PRICE");
                            seats = rs.getInt("M_SEATS");
                            
                            System.out.println(count);
                              grid.add(createMoviePane(rs.getString("M_NAME"), rs.getString("M_DESC"), stream, streamString, price, seats, rs.getInt("M_RATE")), i, j);
                              if ( i == 4){
                                j++;
                                i = 1;
                              } else{
                              i++;
                              }
                              
                              count++;
                    }
                    rs.close();
                
                } catch(SQLException er){
                    System.out.println(er);
                }   catch (FileNotFoundException ex) {
                        Logger.getLogger(Explorer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                });
                
                try{
                
                    this.host = "jdbc:derby://localhost:1527/filmflow";
                    this.con = DriverManager.getConnection(host);

                    this.stmt = con.createStatement();

                    String CountSQL = "SELECT * FROM MOVIES ORDER BY M_rate DESC";
                    ResultSet rs = stmt.executeQuery(CountSQL);
                    int j = 1;
                    int i = 1;
                    int count = 1;
                    while(rs.next()){  
                            stream = new FileInputStream(rs.getString("IMAGELINK"));
                            String streamString = rs.getString("IMAGELINK");
                            System.out.println(count);
                            
                            price = rs.getInt("M_PRICE");
                            seats = rs.getInt("M_SEATS");

                            
                            grid.add(createMoviePane(rs.getString("M_NAME"), rs.getString("M_DESC"), stream, streamString, price, seats, rs.getInt("M_RATE")), i, j);
                              if ( i == 4){
                                j++;
                                i = 1;
                              } else{
                              i++;
                              }
                              
                              count++;
                    }
                    rs.close();
                
                } catch(SQLException er){
                    System.out.println(er);
                }
                
                 searchBtn.setOnAction( e -> {
                     grid.getChildren().clear();
                    
                    String searchText = searchFeild.getText();
                    
                    
                    
                    this.host = "jdbc:derby://localhost:1527/filmflow";
                    try{
                
                    this.host = "jdbc:derby://localhost:1527/filmflow";
                    this.con = DriverManager.getConnection(host);

                    this.stmt = con.createStatement();

                    String CountSQL = "select * from movies where M_NAME like'%"+searchText+"'" + " OR " + "M_NAME like'"+searchText+"%'" + " OR " + "M_NAME like'%"+searchText+"%'";
                    ResultSet rs = stmt.executeQuery(CountSQL);
                    int j = 1;
                    int i = 1;
                    int count = 1;
                    while(rs.next()){  
                            stream = new FileInputStream(rs.getString("IMAGELINK"));
                            String streamString = rs.getString("IMAGELINK");
                            
                            price = rs.getInt("M_PRICE");
                            
                            seats = rs.getInt("M_SEATS");

                            
                            System.out.println(count);
                                grid.add(createMoviePane(rs.getString("M_NAME"), rs.getString("M_DESC"), stream,streamString, price, seats, rs.getInt("M_RATE")), i, j);
                              if ( i == 4){
                                j++;
                                i = 1;
                              } else{
                              i++;
                              }
                              
                              count++;
                    }
                    rs.close();
                
                } catch(SQLException er){
                    System.out.println(er);
                }   catch (FileNotFoundException ex) {
                        Logger.getLogger(Explorer.class.getName()).log(Level.SEVERE, null, ex);
                    }


                });
         
                primaryStage.show();
        }

        private Button createButton(String text) {
                Button button = new Button(text);
                button.setBorder(new Border(new BorderStroke(Color.web("#44cf6c"),
                                BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY, new BorderWidths(2))));
                // set radius to button
                button.setStyle("-fx-border-color: #44cf6c; -fx-border-width: 2px; -fx-border-radius: 20; -fx-background-color:  #44cf6c; -fx-text-fill: #191923 ; -fx-padding: 8px 16px; -fx-font-size: 16px;");
                HBox.setMargin(button, new Insets(0, 20, 0, 0));
                HBox.setHgrow(button, Priority.ALWAYS);
                return button;
        }

        public BorderPane createMoviePane(String title, String summary, InputStream poster, String posterString, int price, int seats, int rate) {
                BorderPane pane = new BorderPane();
                pane.setPadding(new Insets(10));

                // Create the image view
                Image movieImage = new Image(poster);
                ImageView imageView = new ImageView(movieImage);
                imageView.setFitWidth(370);
                imageView.setFitHeight(500);
                // make the imageView to be in the center
                imageView.setStyle(
                                "-fx-padding: 10px; -fx-alignment: center; -fx-border-color: #191923; -fx-border-width: 2px");

                // Create the label
                Label movieLabel = new Label(title);
                movieLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold;");

                movieLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold;");

                // Create the watch button
                Button watchButton = pos == -1 ? createButton("Watch") : createButton("Info");
                watchButton.setOnAction(e -> {
                        
                        
                        Stage filmStage = new Stage();
                    try {
                        filmStage.setScene(new FilmPage().createScene(title, summary, poster, posterString, price, seats, rate));
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Explorer.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Explorer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        filmStage.setMaximized(true);
                        filmStage.show();
                        
                });
                Button bookButton = createButton("Pay");
                bookButton.setOnAction(e -> {
                          
                    if( !pr.getIsOpen() ) 
                    {
                        pr.setMovie(title);
                        try {
                            pr.start(new Stage());
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Explorer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
   
                });
                
               
                
                HBox twoButtons = (pos == -1) ?   new HBox( watchButton) : new HBox( bookButton, watchButton) ;
                
                Label rateing = new Label("Rating : "+rate + "/5" );
                twoButtons.getChildren().add(rateing);
                
                twoButtons.setSpacing(10);
                twoButtons.setAlignment(Pos.CENTER);
                // Create a VBox to hold the label and button
                VBox vBox = new VBox();
                vBox.setSpacing(10);
                vBox.setAlignment(Pos.CENTER);
                vBox.getChildren().addAll(movieLabel, twoButtons);

                // Add the image view and VBox to the root BorderPane
                pane.setCenter(imageView);
                pane.setBottom(vBox);
                // make border to the pane
                pane.setStyle("-fx-border-color: green; -fx-border-width: 1px; -fx-border-radius: 10; -fx-background-color: white; -fx-text-fill: #44cf6c; -fx-padding: 8px 16px; -fx-font-size: 16px;");

                return pane;
        }

        private Label createLabel(String text, FontWeight fontWeight, double fontSize, Color textColor) {
                Label label = new Label(text);
                label.setFont(Font.font("Helvetica Neue", fontWeight, fontSize));
                label.setTextFill(textColor);
                return label;
        }


}