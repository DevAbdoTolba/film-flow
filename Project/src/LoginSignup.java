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

// public class LoginSignup extends Application {

//         @Override
//         public void start(Stage primaryStage) {
//                 primaryStage.setTitle("Sign Up Page");
//                 // Create UI elements
//                 Label titleLabel = new Label("FilmFlow");
//                 titleLabel.setFont(new Font("Arial", 30));
//                 titleLabel.setTextFill(Color.WHITE);
//                 HBox header = new HBox(titleLabel);
//                 header.setStyle("-fx-background-color: black;");
//                 header.setPrefHeight(primaryStage.getHeight() * 0.1);
//                 header.setPadding(new Insets(10, 0, 0, 20));
//                 // Create GridPane layout
//                 GridPane grid = new GridPane();
//                 grid.setAlignment(Pos.CENTER);
//                 grid.setHgap(10);
//                 grid.setVgap(10);
//                 grid.setPadding(new Insets(25, 25, 25, 25));

//                 // Add welcome Text with fade-in animation
//                 Text welcomeText = new Text("Sign Up");
//                 welcomeText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
//                 welcomeText.setOpacity(0);
//                 Timeline welcomeFadeInTimeline = new Timeline(
//                                 new KeyFrame(Duration.ZERO, new KeyValue(welcomeText.opacityProperty(), 0)),
//                                 new KeyFrame(Duration.seconds(1), new KeyValue(welcomeText.opacityProperty(), 1)));
//                 welcomeFadeInTimeline.play();
//                 GridPane.setMargin(welcomeText, new Insets(100, 0, 100, 20));
//                 grid.add(welcomeText, 1, 0, 2, 1);

//                 // Add name Label and TextField with fade-in animation
//                 Label nameLabel = new Label("Name:");
//                 nameLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//                 grid.add(nameLabel, 0, 1);
//                 TextField nameTextField = new TextField();
//                 nameTextField.setPrefSize(300, 40);
//                 nameTextField.setOpacity(0);
//                 Timeline nameFadeTimeline = new Timeline(
//                                 new KeyFrame(Duration.ZERO, new KeyValue(nameTextField.opacityProperty(), 0)),
//                                 new KeyFrame(Duration.seconds(1), new KeyValue(nameTextField.opacityProperty(), 1)));
//                 nameFadeTimeline.play();
//                 grid.add(nameTextField, 1, 1);

//                 // Add email Label and TextField with zoom-in animation
//                 Label emailLabel = new Label("Username:");
//                 emailLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//                 grid.add(emailLabel, 0, 2);
//                 TextField emailTextField = new TextField();
//                 emailTextField.setPrefSize(300, 40);
//                 emailTextField.setScaleX(0);
//                 emailTextField.setScaleY(0);
//                 Timeline emailZoomTimeline = new Timeline(
//                                 new KeyFrame(Duration.ZERO, new KeyValue(emailTextField.scaleXProperty(), 0),
//                                                 new KeyValue(emailTextField.scaleYProperty(), 0)),
//                                 new KeyFrame(Duration.seconds(1), new KeyValue(emailTextField.scaleXProperty(), 1),
//                                                 new KeyValue(emailTextField.scaleYProperty(), 1)));
//                 emailZoomTimeline.play();
//                 grid.add(emailTextField, 1, 2);

//                 // Add password Label and PasswordField with fade-in animation
//                 Label passwordLabel = new Label("Password:");
//                 passwordLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//                 grid.add(passwordLabel, 0, 3);
//                 PasswordField passwordField = new PasswordField();
//                 passwordField.setPrefSize(300, 40);
//                 passwordField.setOpacity(0);
//                 Timeline passwordFadeTimeline = new Timeline(
//                                 new KeyFrame(Duration.ZERO, new KeyValue(passwordField.opacityProperty(), 0)),
//                                 new KeyFrame(Duration.seconds(1), new KeyValue(passwordField.opacityProperty(), 1)));
//                 passwordFadeTimeline.play();
//                 grid.add(passwordField, 1, 3);

//                 // Add confirm password Label and PasswordField with zoom-in animation
//                 Label confirmPasswordLabel = new Label("Confirm Password:");
//                 confirmPasswordLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//                 grid.add(confirmPasswordLabel, 0, 4);
//                 PasswordField confirmPasswordField = new PasswordField();
//                 confirmPasswordField.setPrefSize(300, 40);
//                 confirmPasswordField.setScaleX(0);
//                 confirmPasswordField.setScaleY(0);
//                 Timeline confirmPasswordZoomTimeline = new Timeline(
//                                 new KeyFrame(Duration.ZERO, new KeyValue(confirmPasswordField.scaleXProperty(), 0),
//                                                 new KeyValue(confirmPasswordField.scaleYProperty(), 0)),
//                                 new KeyFrame(Duration.seconds(1),
//                                                 new KeyValue(confirmPasswordField.scaleXProperty(), 1),
//                                                 new KeyValue(confirmPasswordField.scaleYProperty(), 1)));
//                 confirmPasswordZoomTimeline.play();
//                 grid.add(confirmPasswordField, 1, 4);

//                 // Add sign up button with color change animation
//                 Button signUpButton = new Button("Sign Up");
//                 signUpButton.setPrefSize(100, 40);
//                 signUpButton.setTextFill(Color.WHITE);
//                 signUpButton.setStyle("-fx-background-color: #4CAF50;");
//                 Timeline signUpColorTimeline = new Timeline(
//                                 new KeyFrame(Duration.ZERO,
//                                                 new KeyValue(signUpButton.styleProperty(),
//                                                                 "-fx-background-color: #4CAF50;")),
//                                 new KeyFrame(Duration.seconds(0.5),
//                                                 new KeyValue(signUpButton.styleProperty(),
//                                                                 "-fx-background-color: #388E3C;")),
//                                 new KeyFrame(Duration.seconds(1), new KeyValue(signUpButton.styleProperty(),
//                                                 "-fx-background-color: #4CAF50;")));
//                 signUpColorTimeline.setCycleCount(Timeline.INDEFINITE);
//                 signUpColorTimeline.play();
//                 HBox signUpBox = new HBox(10);
//                 signUpBox.setAlignment(Pos.BOTTOM_RIGHT);
//                 signUpBox.getChildren().add(signUpButton);
//                 grid.add(signUpBox, 1, 5);

//                 // Add sign up message Text with translate animation
//                 Text signUpMessageText = new Text("");
//                 signUpMessageText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//                 signUpMessageText.setOpacity(0);
//                 GridPane.setMargin(signUpMessageText, new Insets(50, 0, 0, 0));
//                 grid.add(signUpMessageText, 1, 6);

//                 Timeline signUpMessageTimeline = new Timeline(
//                                 new KeyFrame(Duration.ZERO, new KeyValue(signUpMessageText.opacityProperty(), 0),
//                                                 new KeyValue(signUpMessageText.translateYProperty(), -20)),
//                                 new KeyFrame(Duration.seconds(1), new KeyValue(signUpMessageText.opacityProperty(), 1),
//                                                 new KeyValue(signUpMessageText.translateYProperty(), 0)),
//                                 new KeyFrame(Duration.seconds(3), new KeyValue(signUpMessageText.opacityProperty(), 1)),
//                                 new KeyFrame(Duration.seconds(4), new KeyValue(signUpMessageText.opacityProperty(), 0),
//                                                 new KeyValue(signUpMessageText.translateYProperty(), 20)));
//                 signUpMessageTimeline.setCycleCount(1);

//                 // Add sign up button action to show sign up message Text
//                 signUpButton.setOnAction(event -> {
//                         boolean success = true;
//                         String message = "";

//                         // validation logic here
//                         if (nameTextField.getText().isEmpty() || emailTextField.getText().isEmpty()
//                                         || passwordField.getText().isEmpty()
//                                         || confirmPasswordField.getText().isEmpty()) {
//                                 success = false;
//                                 message = "Please fill out all fields.";
//                         } else if (!passwordField.getText().equals(confirmPasswordField.getText())) {
//                                 success = false;
//                                 message = "Passwords do not match.";
//                         }

//                         if (success) {
//                                 message = "Sign Up Successful!";
//                                 signUpMessageText.setFill(Color.GREEN);
//                         } else {
//                                 signUpMessageText.setFill(Color.RED);
//                         }

//                         signUpMessageText.setText(message);
//                         signUpMessageTimeline.play();
//                 });
//                 BorderPane root = new BorderPane(grid, header, null, null, null);
//                 // root.setStyle("-fx-background-color: white; -fx-background-insets: 0, 0 0 10
//                 // 0;");
//                 // Add scene to stage and show stage
//                 Scene scene = new Scene(root, 500, 500);
//                 primaryStage.setScene(scene);
//                 primaryStage.show();
//         }

//         public static void main(String[] args) {
//                 launch(args);
//         }
// }
// import javafx.animation.*;
// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.*;
// import javafx.scene.layout.*;
// import javafx.scene.paint.Color;
// import javafx.scene.text.*;
// import javafx.stage.Stage;
// import javafx.util.Duration;

// public class LoginSignup extends Application {

// private static final String APP_TITLE = "Login Page";
// private static final String HEADER_STYLE = "-fx-background-color: black;";
// private static final String LOGIN_BUTTON_STYLE = "-fx-background-color:
// #4CAF50;";
// private static final String LOGIN_BUTTON_HOVER_STYLE = "-fx-background-color:
// #388E3C;";
// private static final String USERNAME_LABEL_TEXT = "Username:";
// private static final String PASSWORD_LABEL_TEXT = "Password:";
// private static final String LOGIN_BUTTON_TEXT = "Log In";
// private static final String WELCOME_TEXT = "Login";
// private static final String USERNAME = "username";
// private static final String PASSWORD = "password";
// private static final String LOGIN_SUCCESS_MESSAGE = "Login Successful!";
// private static final String LOGIN_FAILURE_MESSAGE = "Invalid
// username/password.";
// private static final String FILL_FIELDS_MESSAGE = "Please fill out all
// fields.";

// @Override
// public void start(Stage primaryStage) {
// primaryStage.setTitle(APP_TITLE);

// // Header
// Label titleLabel = new Label("FilmFlow");
// titleLabel.setFont(new Font("Arial", 30));
// titleLabel.setTextFill(Color.WHITE);
// HBox header = new HBox(titleLabel);
// header.setStyle(HEADER_STYLE);
// header.setPrefHeight(primaryStage.getHeight() * 0.1);
// header.setPadding(new Insets(10, 0, 0, 20));

// // GridPane layout
// GridPane grid = new GridPane();
// grid.setAlignment(Pos.CENTER);
// grid.setHgap(10);
// grid.setVgap(10);
// grid.setPadding(new Insets(25, 25, 25, 25));

// // Welcome Text with fade-in animation
// Text welcomeText = new Text(WELCOME_TEXT);
// welcomeText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
// welcomeText.setOpacity(0);
// Timeline welcomeFadeInTimeline = new Timeline(
// new KeyFrame(Duration.ZERO, new KeyValue(welcomeText.opacityProperty(), 0)),
// new KeyFrame(Duration.seconds(1), new KeyValue(welcomeText.opacityProperty(),
// 1)));
// welcomeFadeInTimeline.play();
// GridPane.setMargin(welcomeText, new Insets(100, 0, 100, 20));
// grid.add(welcomeText, 1, 0, 2, 1);

// // Username Label and TextField with fade-in animation
// Label usernameLabel = new Label(USERNAME_LABEL_TEXT);
// usernameLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
// grid.add(usernameLabel, 0, 1);
// TextField usernameTextField = new TextField();
// usernameTextField.setPrefSize(300, 40);
// usernameTextField.setOpacity(0);
// Timeline usernameFadeTimeline = new Timeline(
// new KeyFrame(Duration.ZERO, new KeyValue(usernameTextField.opacityProperty(),
// 0)),
// new KeyFrame(Duration.seconds(1),
// new KeyValue(usernameTextField.opacityProperty(), 1)));
// usernameFadeTimeline.play();
// grid.add(usernameTextField, 1, 1);

// // Password Label and PasswordField with fade-in animation
// Label passwordLabel = new Label(PASSWORD_LABEL_TEXT);
// passwordLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
// grid.add(passwordLabel, 0, 2);
// PasswordField passwordField = new PasswordField();
// passwordField.setPrefSize(300, 40);
// passwordField.setOpacity(0);
// Timeline passwordFadeTimeline = new Timeline(
// new KeyFrame(Duration.ZERO, new KeyValue(passwordField.opacityProperty(),
// 0)),
// new KeyFrame(Duration.seconds(1), new
// KeyValue(passwordField.opacityProperty(), 1)));
// passwordFadeTimeline.play();
// grid.add(passwordField, 1, 2);

// // Login button with color change animation
// Button loginButton = new Button(LOGIN_BUTTON_TEXT);
// loginButton.setPrefSize(100, 40);
// loginButton.setTextFill(Color.WHITE);
// loginButton.setStyle(LOGIN_BUTTON_STYLE);
// Timeline loginColorTimeline = new Timeline(
// new KeyFrame(Duration.ZERO,
// new KeyValue(loginButton.styleProperty(), LOGIN_BUTTON_STYLE)),
// new KeyFrame(Duration.seconds(0.5),
// new KeyValue(loginButton.styleProperty(), LOGIN_BUTTON_HOVER_STYLE)),
// new KeyFrame(Duration.seconds(1),
// new KeyValue(loginButton.styleProperty(), LOGIN_BUTTON_STYLE)));
// loginColorTimeline.setCycleCount(Timeline.INDEFINITE);
// loginColorTimeline.play();
// HBox loginBox = new HBox(10);
// loginBox.setAlignment(Pos.BOTTOM_RIGHT);
// loginBox.getChildren().add(loginButton);
// grid.add(loginBox, 1, 3);

// // Login message Text with translate animation
// Text loginMessageText = new Text("");
// loginMessageText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
// loginMessageText.setOpacity(0);
// GridPane.setMargin(loginMessageText, new Insets(50, 0, 0, 0));
// grid.add(loginMessageText, 1, 4);

// Timeline loginMessageTimeline = new Timeline(
// new KeyFrame(Duration.ZERO, new KeyValue(loginMessageText.opacityProperty(),
// 0),
// new KeyValue(loginMessageText.translateYProperty(), -20)),
// new KeyFrame(Duration.seconds(1), new
// KeyValue(loginMessageText.opacityProperty(), 1),
// new KeyValue(loginMessageText.translateYProperty(), 0)),
// new KeyFrame(Duration.seconds(3), new
// KeyValue(loginMessageText.opacityProperty(), 1)),
// new KeyFrame(Duration.seconds(4), new
// KeyValue(loginMessageText.opacityProperty(), 0),
// new KeyValue(loginMessageText.translateYProperty(), 20)));
// loginMessageTimeline.setCycleCount(1);

// // Login button action to show login message Text
// loginButton.setOnAction(event -> {
// boolean success = true;
// String message = "";

// // validation logic here
// if (usernameTextField.getText().isEmpty() ||
// passwordField.getText().isEmpty()) {
// success = false;
// message = FILL_FIELDS_MESSAGE;
// } else if (!usernameTextField.getText().equals(USERNAME)
// || !passwordField.getText().equals(PASSWORD)) {
// success = false;
// message = LOGIN_FAILURE_MESSAGE;
// }

// if (success) {
// message = LOGIN_SUCCESS_MESSAGE;
// loginMessageText.setFill(Color.GREEN);
// } else {
// loginMessageText.setFill(Color.RED);
// }

// loginMessageText.setText(message);
// loginMessageTimeline.play();
// });

// BorderPane root = new BorderPane(grid, header, null, null, null);
// Scene scene = new Scene(root, 500, 500);
// primaryStage.setScene(scene);
// primaryStage.show();
// }

// public static void main(String[] args) {
// launch(args);
// }
// // }
// import javafx.animation.*;
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

// public class LoginSignup extends Application {

//         private static final String APP_TITLE = "FilmFlow";
//         private static final int APP_WIDTH = 500;
//         private static final int APP_HEIGHT = 500;
//         private static final int HEADER_HEIGHT = (int) (APP_HEIGHT * 0.1);
//         private static final int FIELD_WIDTH = 300;
//         private static final int FIELD_HEIGHT = 40;
//         private static final int FIELD_ANIMATION_DURATION = 1;
//         private static final int MESSAGE_ANIMATION_DURATION = 4;
//         private static final int MESSAGE_SHOW_DURATION = 3;

//         @Override
//         public void start(Stage primaryStage) {
//                 primaryStage.setTitle(APP_TITLE);

//                 // Create UI elements
//                 Label titleLabel = new Label(APP_TITLE);
//                 titleLabel.setFont(new Font("Arial", 30));
//                 titleLabel.setTextFill(Color.WHITE);
//                 HBox header = new HBox(titleLabel);
//                 header.setStyle("-fx-background-color: black;");
//                 header.setPrefHeight(HEADER_HEIGHT);
//                 header.setPadding(new Insets(10, 0, 0, 20));

//                 GridPane grid = createGridPane();

//                 BorderPane root = new BorderPane(grid, header, null, null, null);

//                 // Add scene to stage and show stage
//                 Scene scene = new Scene(root, APP_WIDTH, APP_HEIGHT);
//                 primaryStage.setScene(scene);
//                 primaryStage.show();
//         }

//         private GridPane createGridPane() {
//                 GridPane grid = new GridPane();
//                 grid.setAlignment(Pos.CENTER);
//                 grid.setHgap(10);
//                 grid.setVgap(10);
//                 grid.setPadding(new Insets(25, 25, 25, 25));

//                 Text welcomeText = createWelcomeText();
//                 grid.add(welcomeText, 1, 0, 2, 1);

//                 Label nameLabel = new Label("Name:");
//                 nameLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//                 grid.add(nameLabel, 0, 1);
//                 TextField nameTextField = createTextField();
//                 grid.add(nameTextField, 1, 1);

//                 Label emailLabel = new Label("Username:");
//                 emailLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//                 grid.add(emailLabel, 0, 2);
//                 TextField emailTextField = createTextField();
//                 grid.add(emailTextField, 1, 2);

//                 Label passwordLabel = new Label("Password:");
//                 passwordLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//                 grid.add(passwordLabel, 0, 3);
//                 PasswordField passwordField = createPasswordField();
//                 grid.add(passwordField, 1, 3);

//                 Label confirmPasswordLabel = new Label("Confirm Password:");
//                 confirmPasswordLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//                 grid.add(confirmPasswordLabel, 0, 4);
//                 PasswordField confirmPasswordField = createPasswordField();
//                 grid.add(confirmPasswordField, 1, 4);

//                 Button signUpButton = createSignUpButton();
//                 HBox signUpBox = new HBox(10, signUpButton);
//                 signUpButton.setPrefSize(100, 40);
//                 signUpButton.setTextFill(Color.WHITE);
//                 signUpButton.setStyle("-fx-background-color: #4CAF50;");
//                 Timeline signUpColorTimeline = new Timeline(
//                                 new KeyFrame(Duration.ZERO,
//                                                 new KeyValue(signUpButton.styleProperty(),
//                                                                 "-fx-background-color: #4CAF50;")),
//                                 new KeyFrame(Duration.seconds(0.5),
//                                                 new KeyValue(signUpButton.styleProperty(),
//                                                                 "-fx-background-color: #388E3C;")),
//                                 new KeyFrame(Duration.seconds(1), new KeyValue(signUpButton.styleProperty(),
//                                                 "-fx-background-color: #4CAF50;")));
//                 signUpColorTimeline.setCycleCount(Timeline.INDEFINITE);
//                 signUpColorTimeline.play();
//                 signUpBox.setAlignment(Pos.BOTTOM_RIGHT);
//                 grid.add(signUpBox, 1, 5);

//                 Text signUpMessageText = createSignUpMessageText();
//                 grid.add(signUpMessageText, 1, 6);

//                 signUpButton.setOnAction(event -> {
//                         boolean success = true;
//                         String message = "";

//                         if (nameTextField.getText().isEmpty() || emailTextField.getText().isEmpty()
//                                         || passwordField.getText().isEmpty()
//                                         || confirmPasswordField.getText().isEmpty()) {
//                                 success = false;
//                                 message = "Please fill out all fields.";
//                         } else if (!passwordField.getText().equals(confirmPasswordField.getText())) {
//                                 success = false;
//                                 message = "Passwords do not match.";
//                         }

//                         if (success) {
//                                 message = "Sign Up Successful!";
//                                 signUpMessageText.setFill(Color.GREEN);
//                         } else {
//                                 signUpMessageText.setFill(Color.RED);
//                         }

//                         signUpMessageText.setText(message);
//                         animateSignUpMessage(signUpMessageText);
//                 });

//                 return grid;
//         }

//         private Text createWelcomeText() {
//                 Text welcomeText = new Text("Sign Up");
//                 welcomeText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
//                 welcomeText.setOpacity(0);
//                 Timeline welcomeFadeInTimeline = new Timeline(
//                                 new KeyFrame(Duration.ZERO, new KeyValue(welcomeText.opacityProperty(), 0)),
//                                 new KeyFrame(Duration.seconds(FIELD_ANIMATION_DURATION),
//                                                 new KeyValue(welcomeText.opacityProperty(), 1)));
//                 welcomeFadeInTimeline.play();
//                 GridPane.setMargin(welcomeText, new Insets(100, 0, 100, 20));
//                 return welcomeText;
//         }

//         private TextField createTextField() {
//                 TextField textField = new TextField();
//                 textField.setPrefSize(FIELD_WIDTH, FIELD_HEIGHT);
//                 textField.setOpacity(0);
//                 Timeline fadeTimeline = new Timeline(
//                                 new KeyFrame(Duration.ZERO, new KeyValue(textField.opacityProperty(), 0)),
//                                 new KeyFrame(Duration.seconds(FIELD_ANIMATION_DURATION),
//                                                 new KeyValue(textField.opacityProperty(), 1)));
//                 fadeTimeline.play();
//                 return textField;
//         }

//         private PasswordField createPasswordField() {
//                 PasswordField passwordField = new PasswordField();
//                 passwordField.setPrefSize(FIELD_WIDTH, FIELD_HEIGHT);
//                 passwordField.setOpacity(0);
//                 Timeline fadeTimeline = new Timeline(
//                                 new KeyFrame(Duration.ZERO, new KeyValue(passwordField.opacityProperty(), 0)),
//                                 new KeyFrame(Duration.seconds(FIELD_ANIMATION_DURATION),
//                                                 new KeyValue(passwordField.opacityProperty(), 1)));
//                 fadeTimeline.play();
//                 return passwordField;
//         }

//         private Button createSignUpButton() {
//                 Button signUpButton = new Button("Sign Up");
//                 signUpButton.setPrefSize(FIELD_WIDTH, FIELD_HEIGHT);
//                 signUpButton.setOpacity(0);
//                 Timeline fadeTimeline = new Timeline(
//                                 new KeyFrame(Duration.ZERO, new KeyValue(signUpButton.opacityProperty(), 0)),
//                                 new KeyFrame(Duration.seconds(FIELD_ANIMATION_DURATION),
//                                                 new KeyValue(signUpButton.opacityProperty(), 1)));
//                 fadeTimeline.play();
//                 return signUpButton;
//         }

//         private Text createSignUpMessageText() {
//                 Text signUpMessageText = new Text();
//                 signUpMessageText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//                 signUpMessageText.setFill(Color.RED);
//                 signUpMessageText.setOpacity(0);
//                 GridPane.setMargin(signUpMessageText, new Insets(10, 0, 0, 0));
//                 return signUpMessageText;
//         }

//         private void animateSignUpMessage(Text signUpMessageText) {
//                 Timeline messageFadeInTimeline = new Timeline(
//                                 new KeyFrame(Duration.ZERO, new KeyValue(signUpMessageText.opacityProperty(), 0)),
//                                 new KeyFrame(Duration.seconds(FIELD_ANIMATION_DURATION),
//                                                 new KeyValue(signUpMessageText.opacityProperty(), 1)),
//                                 new KeyFrame(Duration.seconds(MESSAGE_SHOW_DURATION),
//                                                 new KeyValue(signUpMessageText.opacityProperty(), 1)),
//                                 new KeyFrame(Duration.seconds(MESSAGE_ANIMATION_DURATION),
//                                                 new KeyValue(signUpMessageText.opacityProperty(), 0)));
//                 messageFadeInTimeline.play();
//         }

//         public static void main(String[] args) {
//                 launch(args);
//         }
// }
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginSignup extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a GridPane to hold the product information
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Create a VBox to hold the product image
        VBox imageBox = new VBox();
        imageBox.setAlignment(Pos.CENTER);
        Rectangle image = new Rectangle(200, 200, Color.LIGHTGRAY);
        imageBox.getChildren().add(image);

        // Add the image VBox to the GridPane
        grid.add(imageBox, 0, 0);

        // Add the product name label to the GridPane
        Label nameLabel = new Label("Product Name");
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        grid.add(nameLabel, 1, 0);

        // Add the product description label to the GridPane
        Label descriptionLabel = new Label("Product Description");
        descriptionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        grid.add(descriptionLabel, 1, 1);

        // Add the product price label to the GridPane
        Label priceLabel = new Label("$99.99");
        priceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        priceLabel.setTextFill(Color.GREEN);
        grid.add(priceLabel, 1, 2);

        // Create an HBox to hold the quantity field and the add to cart button
        HBox quantityBox = new HBox();
        quantityBox.setAlignment(Pos.CENTER);
        quantityBox.setSpacing(10);
        TextField quantityField = new TextField("1");
        quantityField.setPrefWidth(50);
        quantityBox.getChildren().add(quantityField);

        Label addToCartButton = new Label("Add to Cart");
        addToCartButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        addToCartButton.setTextFill(Color.WHITE);
        addToCartButton.setStyle("-fx-background-color: #0066CC;");
        addToCartButton.setPadding(new Insets(5));
        quantityBox.getChildren().add(addToCartButton);

        // Add the quantity HBox to the GridPane
        grid.add(quantityBox, 1, 3);

        // Create a Scene and add the GridPane to it
        Scene scene = new Scene(grid, 500, 500);

        // Set the title of the Stage and show it
        primaryStage.setTitle("Product Preview");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
