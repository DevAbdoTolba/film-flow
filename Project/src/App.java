// import javafx.application.Application;
// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import javafx.scene.Scene;
// import javafx.scene.chart.CategoryAxis;
// import javafx.scene.chart.LineChart;
// import javafx.scene.chart.NumberAxis;
// import javafx.scene.chart.PieChart;
// import javafx.scene.chart.XYChart;
// import javafx.stage.Stage;

// public class App extends Application {

//     public static void main(String[] args) throws Exception {
//         launch(args);
//     }

//     @Override
//     public void start(Stage primaryStage) throws Exception {
//         PieChart budgetChart = new PieChart();
//         ObservableList<PieChart.Data> budgetData = FXCollections.observableArrayList(
//                 new PieChart.Data("Housing", 1500),
//                 new PieChart.Data("Food", 400),
//                 new PieChart.Data("Travel", 300));

//         final CategoryAxis xAxis = new CategoryAxis();
//         final NumberAxis yAxis = new NumberAxis();
//         LineChart<String, Number> incomeChart = new LineChart<>(xAxis, yAxis);
//         incomeChart.setTitle("Income over Time");

//         XYChart.Series<String, Number> series = new XYChart.Series<>();
//         series.setName("Income");

//         series.getData().add(new XYChart.Data<>("Jan", 2000));
//         series.getData().add(new XYChart.Data<>("Feb", 1500));
//         series.getData().add(new XYChart.Data<>("Mar", 3000));
//         series.getData().add(new XYChart.Data<>("Apr", 2500));
//         series.getData().add(new XYChart.Data<>("May", 4000));
//         series.getData().add(new XYChart.Data<>("Jun", 3500));
//         series.getData().add(new XYChart.Data<>("Jul", 5000));

//         incomeChart.getData().add(series);
//         budgetChart.setData(budgetData);

//         primaryStage.setScene(new Scene(budgetChart, 800, 600));
//         primaryStage.show();
//         Stage stage = new Stage();
//         stage.setScene(new Scene(incomeChart, 800, 800));
//         stage.show();
//     }
// }
//?
// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.PasswordField;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.GridPane;
// import javafx.scene.paint.Color;
// import javafx.scene.text.Font;
// import javafx.scene.text.FontWeight;
// import javafx.scene.text.Text;
// import javafx.stage.Stage;

// public class App extends Application {

//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Login Page");

//         // Create GridPane layout
//         GridPane grid = new GridPane();
//         grid.setAlignment(Pos.CENTER);
//         grid.setHgap(10);
//         grid.setVgap(10);
//         grid.setPadding(new Insets(25, 25, 25, 25));

//         // Add welcome Text
//         Text welcomeText = new Text("Welcome!");
//         welcomeText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//         grid.add(welcomeText, 0, 0, 2, 1);

//         // Add username Label and TextField
//         Label userName = new Label("Username:");
//         grid.add(userName, 0, 1);
//         TextField userTextField = new TextField();
//         grid.add(userTextField, 1, 1);

//         // Add password Label and PasswordField
//         Label pw = new Label("Password:");
//         grid.add(pw, 0, 2);
//         PasswordField pwBox = new PasswordField();
//         grid.add(pwBox, 1, 2);

//         // Add login Button
//         Button loginBtn = new Button("Login");
//         grid.add(loginBtn, 1, 4);

//         // Add login message Text
//         final Text loginMsg = new Text();
//         grid.add(loginMsg, 1, 6);

//         // Set action for login Button
//         loginBtn.setOnAction(e -> {
//             String username = userTextField.getText();
//             String password = pwBox.getText();

//             // Replace with actual login validation logic
//             if (username.equals("admin") && password.equals("password")) {
//                 loginMsg.setFill(Color.GREEN);
//                 loginMsg.setText("Login successful!");
//             } else {
//                 loginMsg.setFill(Color.RED);
//                 loginMsg.setText("Invalid username or password.");
//             }
//         });

//         Scene scene = new Scene(grid, 300, 275);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }
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
// import javafx.scene.layout.GridPane;
// import javafx.scene.paint.Color;
// import javafx.scene.text.Font;
// import javafx.scene.text.FontWeight;
// import javafx.scene.text.Text;
// import javafx.scene.transform.Rotate;
// import javafx.stage.Stage;
// import javafx.util.Duration;

// public class App extends Application {

//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Login Page");

//         // Create GridPane layout
//         GridPane grid = new GridPane();
//         grid.setAlignment(Pos.CENTER);
//         grid.setHgap(10);
//         grid.setVgap(10);
//         grid.setPadding(new Insets(25, 25, 25, 25));

//         // Add welcome Text with rotation animation
//         Text welcomeText = new Text("Welcome!");
//         welcomeText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//         Rotate rotation = new Rotate(0, welcomeText.getLayoutBounds().getWidth() / 2,
//                 welcomeText.getLayoutBounds().getHeight() / 2);
//         welcomeText.getTransforms().add(rotation);
//         Timeline timeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 0)),
//                 new KeyFrame(Duration.seconds(4), new KeyValue(rotation.angleProperty(), 360)));
//         timeline.setCycleCount(Timeline.INDEFINITE);
//         timeline.play();
//         GridPane.setMargin(welcomeText, new Insets(80, 0, 80, 20));
//         grid.add(welcomeText, 1, 0, 2, 1);

//         // Add username Label and TextField with fade animation
//         Label userName = new Label("Username:");
//         grid.add(userName, 0, 1);
//         TextField userTextField = new TextField();
//         userTextField.setOpacity(0);
//         Timeline fadeTimeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(userTextField.opacityProperty(), 0)),
//                 new KeyFrame(Duration.seconds(1), new KeyValue(userTextField.opacityProperty(), 1)));
//         fadeTimeline.play();
//         grid.add(userTextField, 1, 1);

//         // Add password Label and PasswordField with zoom animation
//         Label pw = new Label("Password:");
//         grid.add(pw, 0, 2);
//         PasswordField pwBox = new PasswordField();
//         pwBox.setScaleX(0);
//         pwBox.setScaleY(0);
//         Timeline zoomTimeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(pwBox.scaleXProperty(), 0),
//                         new KeyValue(pwBox.scaleYProperty(), 0)),
//                 new KeyFrame(Duration.seconds(2), new KeyValue(pwBox.scaleXProperty(), 1),
//                         new KeyValue(pwBox.scaleYProperty(), 1)));
//         zoomTimeline.play();
//         grid.add(pwBox, 1, 2);

//         // Add login Button with color animation
//         Button loginBtn = new Button("Login");
//         loginBtn.setTextFill(Color.WHITE);
//         loginBtn.setStyle("-fx-background-color: #4CAF50;");
//         loginBtn.setOpacity(0);
//         Timeline colorTimeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(loginBtn.opacityProperty(), 0)),
//                 new KeyFrame(Duration.seconds(2), new KeyValue(loginBtn.opacityProperty(), 1)));
//         colorTimeline.play();
//         grid.add(loginBtn, 1, 4);

//         // Add login message Text with translate animation
//         final Text loginMsg = new Text();
//         loginMsg.setOpacity(0);
//         grid.add(loginMsg, 1, 6);
//         Timeline translateTimeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(loginMsg.translateYProperty(), -20),
//                         new KeyValue(loginMsg.opacityProperty(), 0)),
//                 new KeyFrame(Duration.seconds(2), new KeyValue(loginMsg.translateYProperty(), 0),
//                         new KeyValue(loginMsg.opacityProperty(), 1)));

//         // Set action for login Button with animation
//         loginBtn.setOnAction(e -> {
//             String username = userTextField.getText();
//             String password = pwBox.getText();

//             // Replace with actual login validation logic
//             if (username.equals("admin") && password.equals("password")) {
//                 loginMsg.setFill(Color.GREEN);
//                 loginMsg.setText("Login successful!");
//                 translateTimeline.play();
//             } else {
//                 loginMsg.setFill(Color.RED);
//                 loginMsg.setText("Invalid username or password.");
//                 translateTimeline.play();
//             }
//         });

//         Scene scene = new Scene(grid, 300, 275);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }
//?
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
// import javafx.scene.layout.GridPane;
// import javafx.scene.layout.HBox;
// import javafx.scene.paint.Color;
// import javafx.scene.text.Font;
// import javafx.scene.text.FontWeight;
// import javafx.scene.text.Text;
// import javafx.scene.transform.Rotate;
// import javafx.stage.Stage;
// import javafx.util.Duration;

// public class App extends Application {

//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Sign Up Page");

//         // Create GridPane layout
//         GridPane grid = new GridPane();
//         grid.setAlignment(Pos.CENTER);
//         grid.setHgap(10);
//         grid.setVgap(10);
//         grid.setPadding(new Insets(25, 25, 25, 25));

//         // Add welcome Text with rotation animation
//         Text welcomeText = new Text("Sign Up");
//         welcomeText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//         Rotate rotation = new Rotate(0, welcomeText.getLayoutBounds().getWidth() / 2,
//                 welcomeText.getLayoutBounds().getHeight() / 2);
//         welcomeText.getTransforms().add(rotation);
//         Timeline timeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 0)),
//                 new KeyFrame(Duration.seconds(3), new KeyValue(rotation.angleProperty(), 360)));
//         timeline.setCycleCount(Timeline.INDEFINITE);
//         timeline.play();
//         GridPane.setMargin(welcomeText, new Insets(80, 0, 80, 20));
//         grid.add(welcomeText, 1, 0, 2, 1);

//         // Add name Label and TextField with fade animation
//         Label nameLabel = new Label("Name:");
//         grid.add(nameLabel, 0, 1);
//         TextField nameTextField = new TextField();
//         nameTextField.setOpacity(0);
//         Timeline nameFadeTimeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(nameTextField.opacityProperty(), 0)),
//                 new KeyFrame(Duration.seconds(1), new KeyValue(nameTextField.opacityProperty(), 1)));
//         nameFadeTimeline.play();
//         grid.add(nameTextField, 1, 1);

//         // Add email Label and TextField with zoom animation
//         Label emailLabel = new Label("Email:");
//         grid.add(emailLabel, 0, 2);
//         TextField emailTextField = new TextField();
//         emailTextField.setScaleX(0);
//         emailTextField.setScaleY(0);
//         Timeline emailZoomTimeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(emailTextField.scaleXProperty(), 0),
//                         new KeyValue(emailTextField.scaleYProperty(), 0)),
//                 new KeyFrame(Duration.seconds(1), new KeyValue(emailTextField.scaleXProperty(), 1),
//                         new KeyValue(emailTextField.scaleYProperty(), 1)));
//         emailZoomTimeline.play();
//         grid.add(emailTextField, 1, 2);

//         // Add password Label and PasswordField with fade animation
//         Label passwordLabel = new Label("Password:");
//         grid.add(passwordLabel, 0, 3);
//         PasswordField passwordField = new PasswordField();
//         passwordField.setOpacity(0);
//         Timeline passwordFadeTimeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(passwordField.opacityProperty(), 0)),
//                 new KeyFrame(Duration.seconds(1), new KeyValue(passwordField.opacityProperty(), 1)));
//         passwordFadeTimeline.play();
//         grid.add(passwordField, 1, 3);

//         // Add confirm password Label and PasswordField with zoom animation
//         Label confirmPasswordLabel = new Label("Confirm Password:");
//         grid.add(confirmPasswordLabel, 0, 4);
//         PasswordField confirmPasswordField = new PasswordField();
//         confirmPasswordField.setScaleX(0);
//         confirmPasswordField.setScaleY(0);
//         Timeline confirmPasswordZoomTimeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(confirmPasswordField.scaleXProperty(), 0),
//                         new KeyValue(confirmPasswordField.scaleYProperty(), 0)),
//                 new KeyFrame(Duration.seconds(1), new KeyValue(confirmPasswordField.scaleXProperty(), 1),
//                         new KeyValue(confirmPasswordField.scaleYProperty(), 1)));
//         confirmPasswordZoomTimeline.play();
//         grid.add(confirmPasswordField, 1, 4);

//         // Add sign up Button with color animation
//         Button signUpBtn = new Button("Sign Up");
//         signUpBtn.setTextFill(Color.WHITE);
//         signUpBtn.setStyle("-fx-background-color: #4CAF50;");
//         signUpBtn.setOpacity(0);
//         Timeline signUpColorTimeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(signUpBtn.opacityProperty(), 0)),
//                 new KeyFrame(Duration.seconds(1), new KeyValue(signUpBtn.opacityProperty(), 1)));
//         signUpColorTimeline.play();
//         HBox hbSignUpBtn = new HBox(10);
//         hbSignUpBtn.setAlignment(Pos.BOTTOM_RIGHT);
//         hbSignUpBtn.getChildren().add(signUpBtn);
//         grid.add(hbSignUpBtn, 1, 6);

//         // Add sign up message Text with translate animation
//         final Text signUpMsg = new Text();
//         signUpMsg.setOpacity(0);
//         grid.add(signUpMsg, 0, 7, 2, 1);
//         Timeline signUpTranslateTimeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(signUpMsg.translateYProperty(), -20),
//                         new KeyValue(signUpMsg.opacityProperty(), 0)),
//                 new KeyFrame(Duration.seconds(1), new KeyValue(signUpMsg.translateYProperty(), 0),
//                         new KeyValue(signUpMsg.opacityProperty(), 1)));

//         // Set action for sign up Button with animation
//         signUpBtn.setOnAction(e -> {
//             String name = nameTextField.getText();
//             String email = emailTextField.getText();
//             String password = passwordField.getText();
//             String confirmPassword = confirmPasswordField.getText();

//             // Replace with actual sign up validation logic
//             if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
//                 signUpMsg.setFill(Color.RED);
//                 signUpMsg.setText("Please fill in all fields.");
//                 signUpTranslateTimeline.play();
//             } else if (!password.equals(confirmPassword)) {
//                 signUpMsg.setFill(Color.RED);
//                 signUpMsg.setText("Passwords do not match.");
//                 signUpTranslateTimeline.play();
//             } else {
//                 signUpMsg.setFill(Color.GREEN);
//                 signUpMsg.setText("Sign up successful!");
//                 signUpTranslateTimeline.play();
//             }
//         });

//         Scene scene = new Scene(grid, 300, 400);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }
//?
// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.layout.GridPane;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;

// public class App extends Application {

//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Home Page");

//         // Create GridPane layout
//         GridPane grid = new GridPane();
//         grid.setAlignment(Pos.CENTER);
//         grid.setHgap(10);
//         grid.setVgap(10);
//         grid.setPadding(new Insets(25, 25, 25, 25));

//         // Add welcome Label
//         Label welcomeLabel = new Label("Welcome to our Application!");
//         welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
//         grid.add(welcomeLabel, 0, 0, 2, 1);

//         // Add description Label
//         Label descriptionLabel = new Label("This application does something really cool.");
//         descriptionLabel.setStyle("-fx-font-size: 18px;");
//         grid.add(descriptionLabel, 0, 1, 2, 1);

//         // Add buttons for different features
//         Button feature1Btn = new Button("Feature 1");
//         Button feature2Btn = new Button("Feature 2");
//         Button feature3Btn = new Button("Feature 3");
//         Button feature4Btn = new Button("Feature 4");

//         VBox featuresVBox = new VBox(10);
//         featuresVBox.setAlignment(Pos.CENTER);
//         featuresVBox.getChildren().addAll(feature1Btn, feature2Btn, feature3Btn, feature4Btn);

//         grid.add(featuresVBox, 0, 2, 2, 1);

//         // Add footer with legal information
//         HBox footer = new HBox();
//         footer.setAlignment(Pos.CENTER_RIGHT);
//         footer.setPadding(new Insets(10));
//         Label legalLabel = new Label("Copyright © 2023. All rights reserved.");
//         Button privacyBtn = new Button("Privacy Policy");
//         Button termsBtn = new Button("Terms of Service");
//         footer.getChildren().addAll(legalLabel, privacyBtn, termsBtn);

//         grid.add(footer, 0, 3, 2, 1);

//         Scene scene = new Scene(grid, 400, 300);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class App extends Application {

        @Override
        public void start(Stage primaryStage) {
                primaryStage.setTitle("GitHub Home Page");

                // Create BorderPane layout
                BorderPane borderPane = new BorderPane();

                // Create top bar with logo and search bar
                StackPane topBar = new StackPane();
                topBar.setStyle("-fx-background-color: #24292e; -fx-padding: 10px;");

                Label logoLabel = new Label("GitHub");
                logoLabel.setFont(Font.font("Helvetica Neue", FontWeight.BOLD, 24));
                logoLabel.setTextFill(Color.WHITE);
                topBar.getChildren().add(logoLabel);
                StackPane.setAlignment(logoLabel, Pos.CENTER_LEFT);

                TextField searchBar = new TextField();
                searchBar.setPromptText("Search GitHub");
                searchBar.setStyle(
                                "-fx-background-color: #24292e; -fx-text-fill: white; -fx-border-color: white; -fx-border-radius: 20;");
                searchBar.setPrefWidth(400);
                HBox.setMargin(searchBar, new Insets(0, 10, 0, 10));

                Button searchBtn = new Button("Search");
                searchBtn.setStyle(
                                "-fx-background-color: #28a745; -fx-text-fill: white; -fx-padding: 8px 16px; -fx-font-size: 14px; -fx-border-color: #28a745; -fx-border-radius: 20;");
                HBox searchBox = new HBox(10);
                searchBox.setAlignment(Pos.CENTER_RIGHT);
                searchBox.getChildren().addAll(searchBar, searchBtn);
                topBar.getChildren().add(searchBox);
                StackPane.setAlignment(searchBox, Pos.CENTER_RIGHT);

                borderPane.setTop(topBar);

                // Create main content area with featured projects and trending repositories
                VBox contentVBox = new VBox(20);
                contentVBox.setPadding(new Insets(20));

                Label exploreLabel = new Label("Explore GitHub");
                exploreLabel.setFont(Font.font("Helvetica Neue", FontWeight.BOLD, 24));
                exploreLabel.setTextFill(Color.web("#24292e"));
                contentVBox.getChildren().add(exploreLabel);

                GridPane exploreGrid = new GridPane();
                exploreGrid.setHgap(20);
                exploreGrid.setVgap(20);
                exploreGrid.setPadding(new Insets(10));

                Button btn1 = new Button("Topics");
                btn1.setStyle("-fx-background-color: #24292e; -fx-text-fill: white; -fx-padding: 8px 16px; -fx-font-size: 14px; -fx-border-color: #24292e; -fx-border-radius: 20;");
                exploreGrid.add(btn1, 0, 0);

                Button btn2 = new Button("Trending");
                btn2.setStyle("-fx-background-color: #24292e; -fx-text-fill: white; -fx-padding: 8px 16px; -fx-font-size: 14px; -fx-border-color: #24292e; -fx-border-radius: 20;");
                exploreGrid.add(btn2, 1, 0);

                Button btn3 = new Button("Collections");
                btn3.setStyle("-fx-background-color: #24292e; -fx-text-fill: white; -fx-padding: 8px 16px; -fx-font-size: 14px; -fx-border-color: #24292e; -fx-border-radius: 20;");
                exploreGrid.add(btn3, 2, 0);

                contentVBox.getChildren().add(exploreGrid);

                Label trendingReposLabel = new Label("Trending repositories");
                trendingReposLabel.setFont(Font.font("Helvetica Neue", FontWeight.BOLD, 24));
                trendingReposLabel.setTextFill(Color.web("#24292e"));
                contentVBox.getChildren().add(trendingReposLabel);

                VBox trendingReposVBox = new VBox(10);
                trendingReposVBox.setPadding(new Insets(10));

                for (int i = 0; i < 10; i++) {
                        Label repoNameLabel = new Label("Repository " + (i + 1));
                        repoNameLabel.setFont(Font.font("Helvetica Neue", FontWeight.BOLD, 18));
                        repoNameLabel.setTextFill(Color.web("#24292e"));

                        Label repoDescLabel = new Label("This is a description of the repository.");
                        repoDescLabel.setFont(Font.font("Helvetica Neue", FontWeight.NORMAL, 14));
                        repoDescLabel.setTextFill(Color.web("#586069"));

                        Button starBtn = new Button("Star");
                        starBtn.setStyle(
                                        "-fx-background-color: #24292e; -fx-text-fill: white; -fx-padding: 8px 16px; -fx-font-size: 14px; -fx-border-color: #24292e; -fx-border-radius: 20;");
                        Button forkBtn = new Button("Fork");
                        forkBtn.setStyle(
                                        "-fx-background-color: #24292e; -fx-text-fill: white; -fx-padding: 8px 16px; -fx-font-size: 14px; -fx-border-color: #24292e; -fx-border-radius: 20;");

                        HBox repoHBox = new HBox(10);
                        repoHBox.setAlignment(Pos.CENTER_LEFT);
                        repoHBox.getChildren().addAll(repoNameLabel, starBtn, forkBtn);

                        trendingReposVBox.getChildren().addAll(repoHBox, repoDescLabel);
                }

                contentVBox.getChildren().add(trendingReposVBox);

                borderPane.setCenter(contentVBox);

                Scene scene = new Scene(borderPane, 1200, 800);
                primaryStage.setScene(scene);
                primaryStage.show();
        }

        public static void main(String[] args) {
                launch(args);
        }
}