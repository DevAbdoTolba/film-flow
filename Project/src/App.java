
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
                BorderPane topBar = new BorderPane();

                topBar.setStyle("-fx-background-color: #191923; -fx-padding: 10px;");
                topBar.setPadding(new Insets(10, 10, 10, 10));

                // Create logo label and add it to logoBox
                Label logoLabel = new Label("FilmFlow");
                logoLabel.setFont(Font.font("Helvetica Neue", FontWeight.BOLD, 28));
                logoLabel.setTextFill(Color.WHITE);
                HBox logoBox = new HBox(logoLabel);
                logoBox.setAlignment(Pos.CENTER_LEFT);
                topBar.setLeft(logoBox);

                // Create login and sign up buttons and add them to buttonsBox
                Button loginBtn = createButton("Login");
                addScaleTransitionToButton(loginBtn);
                Button signUpBtn = createButton("Sign Up");
                signUpBtn.setStyle(
                                "-fx-background-color: #44cf6c; -fx-text-fill: white; -fx-padding: 8px 16px; -fx-font-size: 14px; -fx-border-color: #44cf6c; -fx-border-radius: 20;");
                addScaleTransitionToButton(signUpBtn);
                HBox buttonsBox = new HBox(loginBtn, signUpBtn);
                buttonsBox.setAlignment(Pos.CENTER_RIGHT);
                topBar.setRight(buttonsBox);

                BorderPane.setAlignment(topBar, Pos.CENTER_LEFT);
                borderPane.setTop(topBar);

                // Create main content area with title, description, and names
                VBox contentVBox = new VBox(20);
                contentVBox.setPadding(new Insets(20));
                contentVBox.setStyle("-fx-padding: 20px 0 0 30%;");

                Label titleLabel = createLabel("FilmFlow", FontWeight.BOLD, 80, Color.web("#191923"));
                VBox.setMargin(titleLabel, new Insets(80, 10, 0, 200));
                Label descLabel = createLabel("Simple description", FontWeight.NORMAL, 60, Color.web("#44cf6c"));
                VBox.setMargin(descLabel, new Insets(20, 20, 20, 200));
                Label namesLabel = createLabel("Amr Elbana . Omar Farouk . Abdo Tolba", FontWeight.NORMAL, 18,
                                Color.web("#191923"));
                VBox.setMargin(namesLabel, new Insets(20, 20, 20, 200));

                contentVBox.getChildren().addAll(titleLabel, descLabel, namesLabel);
                BorderPane.setAlignment(contentVBox, Pos.CENTER_LEFT);
                borderPane.setCenter(contentVBox);

                Scene scene = new Scene(borderPane, 1200, 800);
                primaryStage.setScene(scene);
                primaryStage.show();
        }

        private Button createButton(String text) {
                Button button = new Button(text);
                button.setStyle("-fx-border-color: #44cf6c; -fx-border-width: 2px; -fx-border-radius: 20; -fx-background-color: transparent; -fx-text-fill: #44cf6c; -fx-padding: 8px 16px; -fx-font-size: 16px;");
                HBox.setMargin(button, new Insets(0, 20, 0, 0));
                HBox.setHgrow(button, Priority.ALWAYS);
                return button;
        }

        private Label createLabel(String text, FontWeight fontWeight, double fontSize, Color textColor) {
                Label label = new Label(text);
                label.setFont(Font.font("Helvetica Neue", fontWeight, fontSize));
                label.setTextFill(textColor);
                return label;
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