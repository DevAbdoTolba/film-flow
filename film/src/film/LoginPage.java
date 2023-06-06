package film;



import film.HomePage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;


public class LoginPage {

        private static final String APP_TITLE = "Login Page";
        private static final String HEADER_STYLE = "-fx-background-color: #191923; -fx-padding: 10px;";
        private static final String LOGIN_BUTTON_STYLE = "-fx-background-color:#4CAF50;";
        private static final String LOGIN_BUTTON_HOVER_STYLE = "-fx-background-color:#388E3C;";
        private static final String USERNAME_LABEL_TEXT = "Username:";
        private static final String PASSWORD_LABEL_TEXT = "Password:";
        private static final String LOGIN_BUTTON_TEXT = "Log In";
        private static final String WELCOME_TEXT = "Login";
        private static final String USERNAME = "username";
        private static final String PASSWORD = "password";
        private static final String LOGIN_SUCCESS_MESSAGE = "Login Successful!";
        private static final String LOGIN_FAILURE_MESSAGE = "Invalid username/password.";
        private static final String FILL_FIELDS_MESSAGE = "Please fill out all fields.";

        
        private String host ;
        private Connection con;
        private Statement stmt;
        private InputStream stream;
        
        private int session = -1;
        
        public Scene createLoginPage() {
                Stage LoginPage = new Stage();
                LoginPage.setTitle(APP_TITLE);

                // Header
                Button logoButton = new Button("Film Flow");
                logoButton.setStyle(
                                "-fx-background-color: #191923; -fx-text-fill: #44cf6c; -fx-padding: 8px 16px; -fx-font-size: 40px; -fx-border-color: #191923; -fx-border-radius: 20;");
               
                logoButton.setOnAction(event -> {
                        HomePage.getPrimaryStage().close();
                        HomePage hp = new HomePage();
                        hp.start(new Stage());
                });
                
                HBox header = new HBox(logoButton);
                header.setStyle(HEADER_STYLE);
                header.setPrefHeight(LoginPage.getHeight() * 0.1);
                header.setPadding(new Insets(10, 0, 0, 20));

                // GridPane layout
                GridPane grid = new GridPane();
                grid.setAlignment(Pos.CENTER);
                grid.setHgap(10);
                grid.setVgap(10);
                grid.setPadding(new Insets(25, 25, 25, 25));

                // Welcome Text with fade-in animation
                Text welcomeText = new Text(WELCOME_TEXT);
                welcomeText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
                welcomeText.setOpacity(0);
                welcomeText.setFill(Color.BLACK);
                Timeline welcomeFadeInTimeline = new Timeline(
                                new KeyFrame(Duration.ZERO, new KeyValue(welcomeText.opacityProperty(), 0)),
                                new KeyFrame(Duration.seconds(1), new KeyValue(welcomeText.opacityProperty(),
                                                1)));
                welcomeFadeInTimeline.play();
                GridPane.setMargin(welcomeText, new Insets(100, 0, 100, 20));
                
                Rectangle loginBoxBack = new Rectangle(500,500);
                loginBoxBack.setFill(Color.rgb(240 , 240, 240));
                DropShadow dropShadow = new DropShadow();
                loginBoxBack.setStroke(Color.rgb(240 , 240, 240));
                loginBoxBack.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
                loginBoxBack.setStrokeWidth(20);
                loginBoxBack.setArcWidth(20);
                loginBoxBack.setArcHeight(20);
                dropShadow.setOffsetY(5);
                dropShadow.setColor(Color.WHITE);
                
                loginBoxBack.setEffect(dropShadow);
                loginBoxBack.setOpacity(.85);
                
                
                grid.add(loginBoxBack, 0, 0, 5 , 5);

                grid.add(welcomeText, 1, 0, 2, 1);

                // Username Label and TextField with fade-in animation
                Label usernameLabel = new Label(USERNAME_LABEL_TEXT);
                usernameLabel.setStyle("-fx-text-fill: #44cf6c;");

                usernameLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                grid.add(usernameLabel, 1, 2);
                TextField usernameTextField = new TextField();
                usernameTextField.setPrefSize(300, 40);
                usernameTextField.setOpacity(0);
                Timeline usernameFadeTimeline = new Timeline(
                                new KeyFrame(Duration.ZERO, new KeyValue(usernameTextField.opacityProperty(),
                                                0)),
                                new KeyFrame(Duration.seconds(1),
                                                new KeyValue(usernameTextField.opacityProperty(), 1)));
                usernameFadeTimeline.play();
                grid.add(usernameTextField, 2, 2);

                // Password Label and PasswordField with fade-in animation
                Label passwordLabel = new Label(PASSWORD_LABEL_TEXT);
                passwordLabel.setStyle("-fx-text-fill: #44cf6c;");

                passwordLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                grid.add(passwordLabel, 1, 3);
                PasswordField passwordField = new PasswordField();
                passwordField.setPrefSize(300, 40);
                passwordField.setOpacity(0);
                Timeline passwordFadeTimeline = new Timeline(
                                new KeyFrame(Duration.ZERO, new KeyValue(passwordField.opacityProperty(),
                                                0)),
                                new KeyFrame(Duration.seconds(1), new KeyValue(passwordField.opacityProperty(), 1)));
                passwordFadeTimeline.play();
                grid.add(passwordField, 2, 3);

                // Login button with color change animation
                Button loginButton = new Button(LOGIN_BUTTON_TEXT);
                loginButton.setPrefSize(100, 40);
                loginButton.setTextFill(Color.BLACK);
                loginButton.setStyle(LOGIN_BUTTON_STYLE);
                Timeline loginColorTimeline = new Timeline(
                                new KeyFrame(Duration.ZERO,
                                                new KeyValue(loginButton.styleProperty(), LOGIN_BUTTON_STYLE)),
                                new KeyFrame(Duration.seconds(0.5),
                                                new KeyValue(loginButton.styleProperty(), LOGIN_BUTTON_HOVER_STYLE)),
                                new KeyFrame(Duration.seconds(1),
                                                new KeyValue(loginButton.styleProperty(), LOGIN_BUTTON_STYLE)));
                loginColorTimeline.setCycleCount(Timeline.INDEFINITE);
                loginColorTimeline.play();
                HBox loginBox = new HBox(10);

                
                loginBox.setAlignment(Pos.BOTTOM_RIGHT);
                loginBox.getChildren().add(loginButton);
                grid.add(loginBox, 2, 4);

                // Login message Text with translate animation
                Text loginMessageText = new Text("");
                loginMessageText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                loginMessageText.setOpacity(0);
                GridPane.setMargin(loginMessageText, new Insets(50, 0, 0, 0));
                grid.add(loginMessageText, 2, 5);
               
                

                Timeline loginMessageTimeline = new Timeline(
                                new KeyFrame(Duration.ZERO, new KeyValue(loginMessageText.opacityProperty(),
                                                0),
                                                new KeyValue(loginMessageText.translateYProperty(), -20)),
                                new KeyFrame(Duration.seconds(1), new KeyValue(loginMessageText.opacityProperty(), 1),
                                                new KeyValue(loginMessageText.translateYProperty(), 0)),
                                new KeyFrame(Duration.seconds(3), new KeyValue(loginMessageText.opacityProperty(), 1)),
                                new KeyFrame(Duration.seconds(4), new KeyValue(loginMessageText.opacityProperty(), 0),
                                                new KeyValue(loginMessageText.translateYProperty(), 20)));
                loginMessageTimeline.setCycleCount(1);

                // Login button action to show login message Text
                loginButton.setOnAction(event -> {
                        boolean success = true;
                        String message = "";

                        // validation logic here
                        
                        
                        if (usernameTextField.getText().isEmpty() ||
                                        passwordField.getText().isEmpty()) {
                                success = false;
                                message = FILL_FIELDS_MESSAGE;
                        } else if (!usernameTextField.getText().equals(USERNAME)
                                        || !passwordField.getText().equals(PASSWORD)) {
                                success = false;
                                message = LOGIN_FAILURE_MESSAGE;
                        }
                        
                             try{
                                this.host = "jdbc:derby://localhost:1527/filmflow";
                                this.con = DriverManager.getConnection(host);

                                this.stmt = con.createStatement();
                                System.out.println("EXCUTING");
                                String SearchAccount = "SELECT * FROM APP.USERS where username = '"+usernameTextField.getText()+"'";
                                ResultSet rs = stmt.executeQuery(SearchAccount);
                                rs.next();
                                if(passwordField.getText().equals(rs.getString("password")))
                                success = true;
                                session = rs.getInt("pos");
                                rs.close();
                                
                            }catch(SQLException er){
                                success = false;
                                message = LOGIN_FAILURE_MESSAGE;
                                System.out.println(er);
                            }

                        if (success) {
                            
                                message = LOGIN_SUCCESS_MESSAGE;
                            
                       
                                loginMessageText.setFill(Color.GREEN);
                                // close the login stage and open the explorer stage
                                HomePage.getPrimaryStage().close();
                                Explorer explorerPage = new Explorer(session);
                                 try{
                                    explorerPage.start(new Stage());
                                } catch( IOException io){
                                    System.out.println(io.getMessage());
                                }
                                

                        } else {
                                loginMessageText.setFill(Color.RED);
                        }

                        loginMessageText.setText(message);
                        loginMessageTimeline.play();
                });

                BorderPane root = new BorderPane(grid, header, null, null, null);
                Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
                double screenWidth = screenBounds.getWidth();
                double screenHeight = screenBounds.getHeight();
                StackPane sp = new StackPane();
                Image i = new Image("https://i.pinimg.com/750x/d9/99/c5/d999c5a76418d5eaa9b8a838f3e13910.jpg");
                ImageView iv = new ImageView(i);
                iv.setFitWidth(screenWidth);
                iv.setFitHeight(screenHeight);

                
                sp.getChildren().add(iv);
                sp.getChildren().add(root);
                
                Scene scene = new Scene(sp, screenWidth, screenHeight);

                // Fade in the UI
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), root);
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.play();

                return scene;
        }
}