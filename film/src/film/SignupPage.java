package film;


import film.HomePage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SignupPage {
    
        private String host ;
        private Connection con;
        private Statement stmt;
        private InputStream stream;

        public Scene createSignUpScene() throws IOException {
                // Create stage and set title
                Stage signUpStage = new Stage();
                signUpStage.setTitle("Sign Up Page");

                // Create UI elements
                Button logoButton = new Button("Film Flow");
                logoButton.setStyle(
                                "-fx-background-color: #191923; -fx-text-fill: #44cf6c; -fx-padding: 8px 16px; -fx-font-size: 40px; -fx-border-color: #191923; -fx-border-radius: 20;");
                logoButton.setOnAction(event -> {
                        HomePage.getPrimaryStage().close();
                        HomePage hp = new HomePage();
                        hp.start(new Stage());
                });

                HBox header = new HBox(logoButton);

                header.setStyle("-fx-background-color: #191923; -fx-padding: 10px;");
                header.setPrefHeight(signUpStage.getHeight() * 0.1);
                header.setPadding(new Insets(10, 0, 0, 20));
                // Create GridPane layout
                GridPane grid = new GridPane();
                grid.setAlignment(Pos.CENTER);
                grid.setHgap(10);
                grid.setVgap(10);
                grid.setPadding(new Insets(25, 25, 25, 25));
                
                                Rectangle SignBoxBack = new Rectangle(500,500);
                SignBoxBack.setFill(Color.rgb(240 , 240, 240));
                DropShadow dropShadow = new DropShadow();
                SignBoxBack.setStroke(Color.rgb(240 , 240, 240));
                SignBoxBack.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
                SignBoxBack.setStrokeWidth(20);
                SignBoxBack.setArcWidth(20);
                SignBoxBack.setArcHeight(20);
                dropShadow.setOffsetY(5);
                dropShadow.setColor(Color.WHITE);
                
                SignBoxBack.setEffect(dropShadow);
                SignBoxBack.setOpacity(.85);

                grid.add(SignBoxBack,0,0,6,6);

                // Add welcome Text with fade-in animation
                Text welcomeText = new Text("Sign Up");
                welcomeText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
                welcomeText.setFill(Color.BLACK);
                Timeline welcomeFadeInTimeline = new Timeline(
                                new KeyFrame(Duration.ZERO, new KeyValue(welcomeText.opacityProperty(), 0)),
                                new KeyFrame(Duration.seconds(1), new KeyValue(welcomeText.opacityProperty(), 1)));
                welcomeFadeInTimeline.play();
                GridPane.setMargin(welcomeText, new Insets(100, 0, 100, 20));
                grid.add(welcomeText, 0, 0, 2, 1);
                

               

                // Add email Label and TextField with zoom-in animation
                Label Username = new Label("Username:");
                Username.setStyle("-fx-text-fill: #44cf6c;");

                Username.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                grid.add(Username, 0, 2);
                TextField UsernameTextField = new TextField();
                UsernameTextField.setPrefSize(300, 40);
                UsernameTextField.setScaleX(0);
                UsernameTextField.setScaleY(0);
                Timeline emailZoomTimeline = new Timeline(
                                new KeyFrame(Duration.ZERO, new KeyValue(UsernameTextField.scaleXProperty(), 0),
                                                new KeyValue(UsernameTextField.scaleYProperty(), 0)),
                                new KeyFrame(Duration.seconds(1), new KeyValue(UsernameTextField.scaleXProperty(), 1),
                                                new KeyValue(UsernameTextField.scaleYProperty(), 1)));
                emailZoomTimeline.play();
                grid.add(UsernameTextField, 1, 2);

                // Add password Label and PasswordField with fade-in animation
                Label passwordLabel = new Label("Password:");
                passwordLabel.setStyle("-fx-text-fill: #44cf6c;");

                passwordLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                grid.add(passwordLabel, 0, 3);
                PasswordField passwordField = new PasswordField();
                passwordField.setPrefSize(300, 40);
                passwordField.setOpacity(0);
                Timeline passwordFadeTimeline = new Timeline(
                                new KeyFrame(Duration.ZERO, new KeyValue(passwordField.opacityProperty(), 0)),
                                new KeyFrame(Duration.seconds(1), new KeyValue(passwordField.opacityProperty(), 1)));
                passwordFadeTimeline.play();
                grid.add(passwordField, 1, 3);

                // Add confirm password Label and PasswordField with zoom-in animation
                Label confirmPasswordLabel = new Label("Confirm Password:");
                confirmPasswordLabel.setStyle("-fx-text-fill: #44cf6c;");

                confirmPasswordLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                grid.add(confirmPasswordLabel, 0, 4);
                PasswordField confirmPasswordField = new PasswordField();
                confirmPasswordField.setPrefSize(300, 40);
                confirmPasswordField.setScaleX(0);
                confirmPasswordField.setScaleY(0);
                Timeline confirmPasswordZoomTimeline = new Timeline(
                                new KeyFrame(Duration.ZERO, new KeyValue(confirmPasswordField.scaleXProperty(), 0),
                                                new KeyValue(confirmPasswordField.scaleYProperty(), 0)),
                                new KeyFrame(Duration.seconds(1),
                                                new KeyValue(confirmPasswordField.scaleXProperty(), 1),
                                                new KeyValue(confirmPasswordField.scaleYProperty(), 1)));
                confirmPasswordZoomTimeline.play();
                grid.add(confirmPasswordField, 1, 4);

                // Add sign up button with color change animation
                Button signUpButton = new Button("Sign Up");
                signUpButton.setPrefSize(100, 40);
                signUpButton.setTextFill(Color.BLACK);
                signUpButton.setStyle("-fx-background-color: #4CAF50;");
                Timeline signUpColorTimeline = new Timeline(
                                new KeyFrame(Duration.ZERO,
                                                new KeyValue(signUpButton.styleProperty(),
                                                                "-fx-background-color: #4CAF50;")),
                                new KeyFrame(Duration.seconds(0.5),
                                                new KeyValue(signUpButton.styleProperty(),
                                                                "-fx-background-color: #388E3C;")),
                                new KeyFrame(Duration.seconds(1), new KeyValue(signUpButton.styleProperty(),
                                                "-fx-background-color: #4CAF50;")));
                signUpColorTimeline.setCycleCount(Timeline.INDEFINITE);
                signUpColorTimeline.play();
                // Add sign up button action

                HBox signUpBox = new HBox(10);
                signUpBox.setAlignment(Pos.BOTTOM_RIGHT);
                signUpBox.getChildren().add(signUpButton);
                grid.add(signUpBox, 1, 5);

                // Add sign up message Text with translate animation
                Text signUpMessageText = new Text("");
                signUpMessageText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                signUpMessageText.setOpacity(0);
                GridPane.setMargin(signUpMessageText, new Insets(50, 0, 0, 0));
                grid.add(signUpMessageText, 1, 5);

                Timeline signUpMessageTimeline = new Timeline(
                                new KeyFrame(Duration.ZERO, new KeyValue(signUpMessageText.opacityProperty(), 0),
                                                new KeyValue(signUpMessageText.translateYProperty(), 0)),
                                new KeyFrame(Duration.seconds(1), new KeyValue(signUpMessageText.opacityProperty(), 1),
                                                new KeyValue(signUpMessageText.translateYProperty(), -50)),
                                new KeyFrame(Duration.seconds(3), new KeyValue(signUpMessageText.opacityProperty(), 0),
                                                new KeyValue(signUpMessageText.translateYProperty(), 0)));
                signUpButton.setOnAction(event -> {
                        boolean success = true;
                        String message = "";

                        // validation logic here
                        if (UsernameTextField.getText().isEmpty()
                                        || passwordField.getText().isEmpty()
                                        || confirmPasswordField.getText().isEmpty()) {
                                success = false;
                                message = "Please fill out all fields.";
                        } else if (!passwordField.getText().equals(confirmPasswordField.getText())) {
                                success = false;
                                message = "Passwords do not match.";
                        }
                        
                    try{
                                this.host = "jdbc:derby://localhost:1527/filmflow";
                                this.con = DriverManager.getConnection(host);

                                this.stmt = con.createStatement();
                                System.out.println("EXCUTING");
                                String CountSQL = "insert into users (username, PASSWORD) VALUES ('"+UsernameTextField.getText()+"','"+passwordField.getText()+"')";
                                stmt.execute(CountSQL);
                                
                                
                                
                                
                                
                            }catch(SQLException er){
                               String sqlErr = (er.getMessage());
                               
                                success = false;
                                message = sqlErr.contains("duplicate") ? "UserName is already used :b" : "Somthing is wrong with the server try again after 3 hours";
                            }
                            
                        if (success) {
                            message = "Sign Up Successful!";
                            signUpMessageText.setFill(Color.GREEN);
                            
                                HomePage.getPrimaryStage().close();
                                Explorer explorerPage = new Explorer();
                                try{
                                    explorerPage.start(new Stage());
                                } catch( IOException io){
                                    System.out.println(io.getMessage());
                                }
                        } else {
                                signUpMessageText.setFill(Color.RED);
                        }

                        signUpMessageText.setText(message);
                        signUpMessageTimeline.play();
                });

                // Create BorderPane layout and add elements
                BorderPane root = new BorderPane();
                root.setTop(header);
                root.setCenter(grid);
                Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
                double screenWidth = screenBounds.getWidth();
                double screenHeight = screenBounds.getHeight();

                StackPane sp = new StackPane();
                Image i = new Image("https://i.pinimg.com/originals/1a/0a/2d/1a0a2d3935b1bd339cd238c08c4584fc.png");
                ImageView iv = new ImageView(i);
                iv.setFitWidth(screenWidth);
                iv.setFitHeight(screenHeight);
                sp.getChildren().add(iv);
                sp.getChildren().add(root);
                Scene scene = new Scene(sp, screenWidth, screenHeight);

                return scene;
        }
        
        
}
