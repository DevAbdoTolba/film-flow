import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {

        private static final Duration ANIMATION_DURATION = Duration.seconds(0.2);
        private static final double BUTTON_SCALE_ON_HOVER = 1.1;

        @Override
        public void start(Stage primaryStage) {
                primaryStage.setTitle("FilmFlow");

                // Create BorderPane layout
                BorderPane borderPane = new BorderPane();

                // Create top bar with logo and login/sign up buttons
                HBox topBar = new HBox();
                topBar.setStyle("-fx-background-color: #191923; -fx-padding: 10px;");
                topBar.setAlignment(Pos.CENTER);
                topBar.setSpacing(20);

                HBox logoBox = new HBox();
                logoBox.setAlignment(Pos.CENTER_LEFT);
                Label logoLabel = new Label("FilmFlow");
                logoLabel.setFont(Font.font("Helvetica Neue", FontWeight.BOLD, 28));
                logoLabel.setTextFill(Color.WHITE);
                HBox.setMargin(logoLabel, new Insets(0, 800, 0, 0));
                logoBox.getChildren().add(logoLabel);
                topBar.getChildren().add(logoBox);

                HBox buttonsBox = new HBox();
                buttonsBox.setAlignment(Pos.CENTER_RIGHT);

                Button loginBtn = new Button("Login");
                loginBtn.setStyle(
                                "-fx-border-color: #44cf6c; -fx-border-width: 2px; -fx-border-radius: 20; -fx-background-color: transparent; -fx-text-fill: #44cf6c; -fx-padding: 8px 16px; -fx-font-size: 16px;");
                HBox.setMargin(loginBtn, new Insets(0, 20, 0, 0));
                addScaleTransitionToButton(loginBtn);
                buttonsBox.getChildren().add(loginBtn);

                Button signUpBtn = new Button("Sign Up");
                signUpBtn.setStyle(
                                "-fx-background-color: #44cf6c; -fx-text-fill: white; -fx-padding: 8px 16px; -fx-font-size: 16px; -fx-border-color: #44cf6c; -fx-border-radius: 20;");
                HBox.setMargin(signUpBtn, new Insets(0, 20, 0, 20));
                addScaleTransitionToButton(signUpBtn);
                buttonsBox.getChildren().add(signUpBtn);

                topBar.getChildren().add(buttonsBox);

                BorderPane.setAlignment(topBar, Pos.CENTER_LEFT);
                borderPane.setTop(topBar);

                // Create main content area with title, description, and names
                VBox contentVBox = new VBox(20);
                contentVBox.setPadding(new Insets(20));
                contentVBox.setStyle("-fx-padding: 20px 0 0 30%;");

                Label titleLabel = new Label("FilmFlow");
                titleLabel.setFont(Font.font("Helvetica Neue", FontWeight.BOLD, 80));
                titleLabel.setTextFill(Color.web("#191923"));
                VBox.setMargin(titleLabel, new Insets(80, 10, 0, 200));
                contentVBox.getChildren().add(titleLabel);

                Label descLabel = new Label("Simple description");
                descLabel.setFont(Font.font("Helvetica Neue", FontWeight.NORMAL, 60));
                descLabel.setTextFill(Color.web("#44cf6c"));
                VBox.setMargin(descLabel, new Insets(20, 20, 20, 200));

                contentVBox.getChildren().add(descLabel);

                Label namesLabel = new Label("Amr Elbana . Omar Farouk . Abdo Tolba");
                namesLabel.setFont(Font.font("Helvetica Neue", FontWeight.NORMAL, 18));
                namesLabel.setTextFill(Color.web("#191923"));
                VBox.setMargin(namesLabel, new Insets(20, 20, 20, 200));
                contentVBox.getChildren().add(namesLabel);
                BorderPane.setAlignment(contentVBox, Pos.CENTER_LEFT);
                borderPane.setCenter(contentVBox);

                Scene scene = new Scene(borderPane, 1200, 800);
                primaryStage.setScene(scene);
                primaryStage.show();
        }

        private void addScaleTransitionToButton(Button button) {
                ScaleTransition scaleTransition = new ScaleTransition(ANIMATION_DURATION, button);
                scaleTransition.setToX(BUTTON_SCALE_ON_HOVER);
                scaleTransition.setToY(BUTTON_SCALE_ON_HOVER);

                button.setOnMouseEntered(event -> scaleTransition.play());

                button.setOnMouseExited(event -> {
                        scaleTransition.stop();
                        button.setScaleX(1);
                        button.setScaleY(1);
                });
        }

        public static void main(String[] args) {
                launch(args);
        }
}