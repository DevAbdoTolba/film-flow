
// import javafx.animation.KeyFrame;
// import javafx.animation.KeyValue;
// import javafx.animation.Timeline;
// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.PasswordField;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.GridPane;
// import javafx.scene.layout.HBox;
// import javafx.scene.paint.Color;
// import javafx.scene.text.Font;
// import javafx.scene.text.FontWeight;
// import javafx.scene.text.Text;
// import javafx.stage.Stage;
// import javafx.util.Duration;

// public class App extends Application {

//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Sign Up Page");
//         // Create UI elements
//         Label titleLabel = new Label("FilmFlow");
//         titleLabel.setFont(new Font("Arial", 30));
//         titleLabel.setTextFill(Color.WHITE);
//         HBox header = new HBox(titleLabel);
//         header.setStyle("-fx-background-color: black;");
//         header.setPrefHeight(primaryStage.getHeight() * 0.1);
//         header.setPadding(new Insets(10, 0, 0, 20));
//         // Create GridPane layout
//         GridPane grid = new GridPane();
//         grid.setAlignment(Pos.CENTER);
//         grid.setHgap(10);
//         grid.setVgap(10);
//         grid.setPadding(new Insets(25, 25, 25, 25));

//         // Add welcome Text with fade-in animation
//         Text welcomeText = new Text("Sign Up");
//         welcomeText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
//         welcomeText.setOpacity(0);
//         Timeline welcomeFadeInTimeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(welcomeText.opacityProperty(), 0)),
//                 new KeyFrame(Duration.seconds(1), new KeyValue(welcomeText.opacityProperty(), 1)));
//         welcomeFadeInTimeline.play();
//         GridPane.setMargin(welcomeText, new Insets(100, 0, 100, 20));
//         grid.add(welcomeText, 1, 0, 2, 1);

//         // Add name Label and TextField with fade-in animation
//         Label nameLabel = new Label("Name:");
//         nameLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//         grid.add(nameLabel, 0, 1);
//         TextField nameTextField = new TextField();
//         nameTextField.setPrefSize(300, 40);
//         nameTextField.setOpacity(0);
//         Timeline nameFadeTimeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(nameTextField.opacityProperty(), 0)),
//                 new KeyFrame(Duration.seconds(1), new KeyValue(nameTextField.opacityProperty(), 1)));
//         nameFadeTimeline.play();
//         grid.add(nameTextField, 1, 1);

//         // Add email Label and TextField with zoom-in animation
//         Label emailLabel = new Label("Username:");
//         emailLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//         grid.add(emailLabel, 0, 2);
//         TextField emailTextField = new TextField();
//         emailTextField.setPrefSize(300, 40);
//         emailTextField.setScaleX(0);
//         emailTextField.setScaleY(0);
//         Timeline emailZoomTimeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(emailTextField.scaleXProperty(), 0),
//                         new KeyValue(emailTextField.scaleYProperty(), 0)),
//                 new KeyFrame(Duration.seconds(1), new KeyValue(emailTextField.scaleXProperty(), 1),
//                         new KeyValue(emailTextField.scaleYProperty(), 1)));
//         emailZoomTimeline.play();
//         grid.add(emailTextField, 1, 2);

//         // Add password Label and PasswordField with fade-in animation
//         Label passwordLabel = new Label("Password:");
//         passwordLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//         grid.add(passwordLabel, 0, 3);
//         PasswordField passwordField = new PasswordField();
//         passwordField.setPrefSize(300, 40);
//         passwordField.setOpacity(0);
//         Timeline passwordFadeTimeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(passwordField.opacityProperty(), 0)),
//                 new KeyFrame(Duration.seconds(1), new KeyValue(passwordField.opacityProperty(), 1)));
//         passwordFadeTimeline.play();
//         grid.add(passwordField, 1, 3);

//         // Add confirm password Label and PasswordField with zoom-in animation
//         Label confirmPasswordLabel = new Label("Confirm Password:");
//         confirmPasswordLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//         grid.add(confirmPasswordLabel, 0, 4);
//         PasswordField confirmPasswordField = new PasswordField();
//         confirmPasswordField.setPrefSize(300, 40);
//         confirmPasswordField.setScaleX(0);
//         confirmPasswordField.setScaleY(0);
//         Timeline confirmPasswordZoomTimeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(confirmPasswordField.scaleXProperty(), 0),
//                         new KeyValue(confirmPasswordField.scaleYProperty(), 0)),
//                 new KeyFrame(Duration.seconds(1), new KeyValue(confirmPasswordField.scaleXProperty(), 1),
//                         new KeyValue(confirmPasswordField.scaleYProperty(), 1)));
//         confirmPasswordZoomTimeline.play();
//         grid.add(confirmPasswordField, 1, 4);

//         // Add sign up button with color change animation
//         Button signUpButton = new Button("Sign Up");
//         signUpButton.setPrefSize(100, 40);
//         signUpButton.setTextFill(Color.WHITE);
//         signUpButton.setStyle("-fx-background-color: #4CAF50;");
//         Timeline signUpColorTimeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(signUpButton.styleProperty(), "-fx-background-color: #4CAF50;")),
//                 new KeyFrame(Duration.seconds(0.5), new KeyValue(signUpButton.styleProperty(), "-fx-background-color: #388E3C;")),
//                 new KeyFrame(Duration.seconds(1), new KeyValue(signUpButton.styleProperty(), "-fx-background-color: #4CAF50;")));
//         signUpColorTimeline.setCycleCount(Timeline.INDEFINITE);
//         signUpColorTimeline.play();
//         HBox signUpBox = new HBox(10);
//         signUpBox.setAlignment(Pos.BOTTOM_RIGHT);
//         signUpBox.getChildren().add(signUpButton);
//         grid.add(signUpBox, 1, 5);

//         // Add sign up message Text with translate animation
//         Text signUpMessageText = new Text("");
//         signUpMessageText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//         signUpMessageText.setOpacity(0);
//         GridPane.setMargin(signUpMessageText, new Insets(50, 0, 0, 0));
//         grid.add(signUpMessageText, 1, 6);

//         Timeline signUpMessageTimeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(signUpMessageText.opacityProperty(), 0),
//                         new KeyValue(signUpMessageText.translateYProperty(), -20)),
//                 new KeyFrame(Duration.seconds(1), new KeyValue(signUpMessageText.opacityProperty(), 1),
//                         new KeyValue(signUpMessageText.translateYProperty(), 0)),
//                 new KeyFrame(Duration.seconds(3), new KeyValue(signUpMessageText.opacityProperty(), 1)),
//                 new KeyFrame(Duration.seconds(4), new KeyValue(signUpMessageText.opacityProperty(), 0),
//                         new KeyValue(signUpMessageText.translateYProperty(), 20)));
//         signUpMessageTimeline.setCycleCount(1);

//         // Add sign up button action to show sign up message Text
//         signUpButton.setOnAction(event -> {
//             boolean success = true;
//             String message = "";

//             // validation logic here
//             if (nameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() || passwordField.getText().isEmpty() || confirmPasswordField.getText().isEmpty()) {
//                 success = false;
//                 message = "Please fill out all fields.";
//             } else if (!passwordField.getText().equals(confirmPasswordField.getText())) {
//                 success = false;
//                 message = "Passwords do not match.";
//             }

//             if (success) {
//                 message = "Sign Up Successful!";
//                 signUpMessageText.setFill(Color.GREEN);
//             } else {
//                 signUpMessageText.setFill(Color.RED);
//             }

//             signUpMessageText.setText(message);
//             signUpMessageTimeline.play();
//         });
//        BorderPane root = new BorderPane(grid, header, null, null, null);
//         //root.setStyle("-fx-background-color: white; -fx-background-insets: 0, 0 0 10 0;");
//         // Add scene to stage and show stage
//         Scene scene = new Scene(root, 500, 500);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//          launch(args);
//     }
// }

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginSignup extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Page");
        // Create UI elements
        Label titleLabel = new Label("FilmFlow");
        titleLabel.setFont(new Font("Arial", 30));
        titleLabel.setTextFill(Color.WHITE);
        HBox header = new HBox(titleLabel);
        header.setStyle("-fx-background-color: black;");
        header.setPrefHeight(primaryStage.getHeight() * 0.1);
        header.setPadding(new Insets(10, 0, 0, 20));
        // Create GridPane layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Add welcome Text with fade-in animation
        Text welcomeText = new Text("Login");
        welcomeText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
        welcomeText.setOpacity(0);
        Timeline welcomeFadeInTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(welcomeText.opacityProperty(), 0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(welcomeText.opacityProperty(), 1)));
        welcomeFadeInTimeline.play();
        GridPane.setMargin(welcomeText, new Insets(100, 0, 100, 20));
        grid.add(welcomeText, 1, 0, 2, 1);

        // Add username Label and TextField with fade-in animation
        Label usernameLabel = new Label("Username:");
        usernameLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(usernameLabel, 0, 1);
        TextField usernameTextField = new TextField();
        usernameTextField.setPrefSize(300, 40);
        usernameTextField.setOpacity(0);
        Timeline usernameFadeTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(usernameTextField.opacityProperty(), 0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(usernameTextField.opacityProperty(), 1)));
        usernameFadeTimeline.play();
        grid.add(usernameTextField, 1, 1);

        // Add password Label and PasswordField with fade-in animation
        Label passwordLabel = new Label("Password:");
        passwordLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(passwordLabel, 0, 2);
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefSize(300, 40);
        passwordField.setOpacity(0);
        Timeline passwordFadeTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(passwordField.opacityProperty(), 0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(passwordField.opacityProperty(), 1)));
        passwordFadeTimeline.play();
        grid.add(passwordField, 1, 2);

        // Add login button with color change animation
        Button loginButton = new Button("Log In");
        loginButton.setPrefSize(100, 40);
        loginButton.setTextFill(Color.WHITE);
        loginButton.setStyle("-fx-background-color: #4CAF50;");
        Timeline loginColorTimeline = new Timeline(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(loginButton.styleProperty(), "-fx-background-color: #4CAF50;")),
                new KeyFrame(Duration.seconds(0.5),
                        new KeyValue(loginButton.styleProperty(), "-fx-background-color: #388E3C;")),
                new KeyFrame(Duration.seconds(1),
                        new KeyValue(loginButton.styleProperty(), "-fx-background-color: #4CAF50;")));
        loginColorTimeline.setCycleCount(Timeline.INDEFINITE);
        loginColorTimeline.play();
        HBox loginBox = new HBox(10);
        loginBox.setAlignment(Pos.BOTTOM_RIGHT);
        loginBox.getChildren().add(loginButton);
        grid.add(loginBox, 1, 3);

        // Add login message Text with translate animation
        Text loginMessageText = new Text("");
        loginMessageText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        loginMessageText.setOpacity(0);
        GridPane.setMargin(loginMessageText, new Insets(50, 0, 0, 0));
        grid.add(loginMessageText, 1, 4);

        Timeline loginMessageTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(loginMessageText.opacityProperty(), 0),
                        new KeyValue(loginMessageText.translateYProperty(), -20)),
                new KeyFrame(Duration.seconds(1), new KeyValue(loginMessageText.opacityProperty(), 1),
                        new KeyValue(loginMessageText.translateYProperty(), 0)),
                new KeyFrame(Duration.seconds(3), new KeyValue(loginMessageText.opacityProperty(), 1)),
                new KeyFrame(Duration.seconds(4), new KeyValue(loginMessageText.opacityProperty(), 0),
                        new KeyValue(loginMessageText.translateYProperty(), 20)));
        loginMessageTimeline.setCycleCount(1);

        // Add login button action to show login message Text
        loginButton.setOnAction(event -> {
            boolean success = true;
            String message = "";

            // validation logic here
            if (usernameTextField.getText().isEmpty() || passwordField.getText().isEmpty()) {
                success = false;
                message = "Please fill out all fields.";
            } else if (!usernameTextField.getText().equals("username") || !passwordField.getText().equals("password")) {
                success = false;
                message = "Invalid username/password.";
            }

            if (success) {
                message = "Login Successful!";
                loginMessageText.setFill(Color.GREEN);
            } else {
                loginMessageText.setFill(Color.RED);
            }

            loginMessageText.setText(message);
            loginMessageTimeline.play();
        });

        BorderPane root = new BorderPane(grid, header, null, null, null);
        // root.setStyle("-fx-background-color: white; -fx-background-insets: 0, 0 0 10
        // 0;");
        // Add scene to stage and show stage
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}