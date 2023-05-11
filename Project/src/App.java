import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
                primaryStage.setTitle("FilmFlow");

                // Create BorderPane layout
                BorderPane borderPane = new BorderPane();

                // Create top bar with logo and login/sign up buttons
                HBox topBar = new HBox();
                topBar.setStyle("-fx-background-color: #191923; -fx-padding: 10px; -fx-alignment: center-right;");

                Label logoLabel = new Label("FilmFlow");
                logoLabel.setFont(Font.font("Helvetica Neue", FontWeight.BOLD, 24));
                logoLabel.setTextFill(Color.WHITE);
                topBar.getChildren().add(logoLabel);

                Button loginBtn = new Button("Login");
                loginBtn.setStyle(
                                "-fx-border-color: #44cf6c; -fx-border-width: 2px; -fx-border-radius: 20; -fx-background-color: transparent; -fx-text-fill: #44cf6c; -fx-padding: 8px 16px; -fx-font-size: 14px;");
                HBox.setMargin(loginBtn, new Insets(0, 10, 0, 10));
                topBar.getChildren().add(loginBtn);

                Button signUpBtn = new Button("Sign Up");
                signUpBtn.setStyle(
                                "-fx-background-color: #44cf6c; -fx-text-fill: white; -fx-padding: 8px 16px; -fx-font-size: 14px; -fx-border-color: #44cf6c; -fx-border-radius: 20;");
                HBox.setMargin(signUpBtn, new Insets(0, 10, 0, 10));
                topBar.getChildren().add(signUpBtn);

                borderPane.setTop(topBar);

                // Create main content area with title, description, and names
                VBox contentVBox = new VBox(20);
                contentVBox.setPadding(new Insets(20));

                Label titleLabel = new Label("FilmFlow");
                titleLabel.setFont(Font.font("Helvetica Neue", FontWeight.BOLD, 48));
                titleLabel.setTextFill(Color.web("#191923"));
                contentVBox.getChildren().add(titleLabel);

                Label descLabel = new Label("Simple description");
                descLabel.setFont(Font.font("Helvetica Neue", FontWeight.NORMAL, 18));
                descLabel.setTextFill(Color.web("#44cf6c"));
                contentVBox.getChildren().add(descLabel);

                Label namesLabel = new Label("Amr Elbana . Omar Farouk . Abdo Tolba");
                namesLabel.setFont(Font.font("Helvetica Neue", FontWeight.NORMAL, 14));
                namesLabel.setTextFill(Color.web("#191923"));
                contentVBox.getChildren().add(namesLabel);

                borderPane.setCenter(contentVBox);

                Scene scene = new Scene(borderPane, 1200, 800);
                primaryStage.setScene(scene);
                primaryStage.show();
        }

        public static void main(String[] args) {
                launch(args);
        }
}