// import javafx.animation.FadeTransition;
// import javafx.animation.ScaleTransition;
// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.GridPane;
// import javafx.scene.layout.StackPane;
// import javafx.scene.layout.VBox;
// import javafx.scene.paint.Color;
// import javafx.scene.text.Font;
// import javafx.stage.Stage;
// import javafx.util.Duration;

// public class Booking extends Application {

//     public static void main(String[] args) {
//         launch(args);
//     }

//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("The Last Voyage");

//         // Set the background color and image
//         StackPane root = new StackPane();
//         root.setStyle("-fx-background-color: #0E2A4E;");
//         Image backgroundImage = new Image("A1.jpg");
//         ImageView backgroundView = new ImageView(backgroundImage);
//         backgroundView.setFitWidth(800);
//         backgroundView.setFitHeight(600);
//         root.getChildren().add(backgroundView);

//         // Load the movie poster image and add a fade-in effect
//         Image posterImage = new Image("A1.jpg");
//         ImageView posterView = new ImageView(posterImage);
//         posterView.setPreserveRatio(true);
//         posterView.setFitHeight(450);
//         FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), posterView);
//         fadeTransition.setFromValue(0);
//         fadeTransition.setToValue(1);
//         fadeTransition.play();

//         // Create the movie title label and tagline and change the font
//         Label titleLabel = new Label("The Last Voyage");
//         titleLabel.setFont(Font.font("Verdana", 32));
//         titleLabel.setTextFill(Color.WHITE);
//         Label taglineLabel = new Label("When all hope is lost, the journey begins.");
//         taglineLabel.setFont(Font.font("Verdana", 18));
//         taglineLabel.setTextFill(Color.WHITE);

//         // Create the movie plot summary, cast, director, writer, release date, genre, runtime, and rating labels
//         Label plotLabel = new Label("As the world faces imminent destruction, a small group of survivors embark on a perilous journey across the ocean to find a new home. But as they face treacherous storms, dangerous sea creatures, and unexpected challenges, they begin to question whether they will ever find a place to call home.");
//         plotLabel.setWrapText(true);
//         Label castLabel = new Label("Cast:\n- John Smith as Captain Jameson\n- Emily Jones as Dr. Rodriguez\n- Michael Brown as Tom\n- Sarah Lee as Jess");
//         Label directorLabel = new Label("Director: David Chen");
//         Label writerLabel = new Label("Writer: Rachel Kim");
//         Label releaseLabel = new Label("Release Date: TBD");
//         Label genreLabel = new Label("Genre: Adventure, Drama, Sci-Fi");
//         Label runtimeLabel = new Label("Runtime: TBD");
//         Label ratingLabel = new Label("IMDb Rating: TBD");
//         Label trailerLabel = new Label("Trailer:");

//         // Create the trailer button and add a hover effect
//         Button trailerButton = new Button("Watch Trailer");
//         trailerButton.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
//         trailerButton.setTextFill(Color.WHITE);
//         trailerButton.setStyle("-fx-background-color: #3FBFBF;");
//         trailerButton.setOnMouseEntered(e -> {
//             trailerButton.setStyle("-fx-background-color: #5FD9D9;");
//         });
//         trailerButton.setOnMouseExited(e -> {
//             trailerButton.setStyle("-fx-background-color: #3FBFBF;");
//         });

//         // Add a zoom-in effect to the trailer button
//         ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.5), trailerButton);
//         scaleTransition.setFromX(0);
//         scaleTransition.setFromY(0);
//         scaleTransition.setToX(1);
//         scaleTransition.setToY(1);
//         scaleTransition.play();

//         // Create a grid pane for the movie information and add the labels and button
//         GridPane gridPane = new GridPane();
//         gridPane.setPadding(new Insets(20));
//         gridPane.setHgap(10);
//         gridPane.setVgap(10);
//         gridPane.add(titleLabel, 0, 0, 2, 1);
//         gridPane.add(taglineLabel, 0, 1, 2, 1);
//         gridPane.add(posterView, 0, 2, 1, 4);
//         gridPane.add(plotLabel, 1, 2, 1, 4);
//         gridPane.add(castLabel, 1, 6);
//         gridPane.add(directorLabel, 1, 7);
//         gridPane.add(writerLabel, 1, 8);
//         gridPane.add(releaseLabel, 1, 9);
//         gridPane.add(genreLabel, 1, 10);
//         gridPane.add(runtimeLabel, 1, 11);
//         gridPane.add(ratingLabel, 1, 12);
//         gridPane.add(trailerLabel, 0, 14);
//         gridPane.add(trailerButton, 1, 14);

//         // Set the grid pane as the center of the border pane
//         BorderPane borderPane = new BorderPane();
//         borderPane.setCenter(gridPane);

//         // Set the scene and show the stage
//         Scene scene = new Scene(root, 800, 600);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }
// // }

//? game code
// import javafx.animation.Animation;
// import javafx.animation.KeyFrame;
// import javafx.animation.KeyValue;
// import javafx.animation.Timeline;
// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Label;
// import javafx.scene.input.MouseEvent;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.StackPane;
// import javafx.scene.paint.Color;
// import javafx.scene.shape.Circle;
// import javafx.scene.text.Font;
// import javafx.stage.Stage;
// import javafx.util.Duration;

// public class Booking extends Application {

//     private Circle circle;
//     private Label scoreLabel;
//     private int score;

//     public static void main(String[] args) {
//         launch(args);
//     }

//     @Override
//     public void start(Stage primaryStage) {
//         // Create the circle and set its properties
//         circle = new Circle(50, Color.RED);
//         circle.setStroke(Color.BLACK);
//         circle.setStrokeWidth(2);

//         // Set up the game score label
//         scoreLabel = new Label("Score: 0");
//         scoreLabel.setFont(new Font("Arial", 24));
//         scoreLabel.setTextFill(Color.WHITE);

//         // Set up the root pane
//         StackPane root = new StackPane();
//         root.setStyle("-fx-background-color: #1E8449;");
//         root.getChildren().add(circle);
//         root.getChildren().add(scoreLabel);

//         // Set up the scene and show the stage
//         Scene scene = new Scene(root, 400, 400);
//         primaryStage.setScene(scene);
//         primaryStage.show();

//         // Set up the timeline animation for the circle movement
//         Timeline timeline = new Timeline(
//                 new KeyFrame(Duration.ZERO, new KeyValue(circle.translateXProperty(), 0)),
//                 new KeyFrame(Duration.seconds(3), new KeyValue(circle.translateXProperty(), scene.getWidth() - circle.getRadius() * 2))
//         );
//         timeline.setCycleCount(Animation.INDEFINITE);
//         timeline.setAutoReverse(true);
//         timeline.play();

//         // Add an event handler for the circle click
//         circle.setOnMouseClicked((MouseEvent event) -> {
//             // Increase the score and update the label
//             score++;
//             scoreLabel.setText("Score: " + score);

//             // Stop and restart the animation to make the circle move faster
//             timeline.stop();
//             timeline.setRate(timeline.getRate() + 0.1);
//             timeline.play();
//         });

//         // Set up the layout for the game score label
//         BorderPane.setAlignment(scoreLabel, Pos.TOP_CENTER);
//         BorderPane.setMargin(scoreLabel, new Insets(10));
//     }
// }
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Booking extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // Film title
    String title = "The Shawshank Redemption";
    // film summary
    String summary = "The Shawshank Redemption is a 1994 drama film directed by Frank Darabont and starring Tim Robbins and Morgan Freeman. The story is based on a Stephen King novella and follows the life of Andy Dufresne, a successful banker who is wrongly convicted of murder and sentenced to life in prison. While in prison, he befriends a fellow inmate and learns to navigate prison life. He uses his financial expertise to gain the trust of the prison guards and warden and works tirelessly to prove his innocence and secure his release. The film explores themes of hope, friendship, institutionalization, and perseverance. It received critical acclaim and is considered one of the greatest films ever made.";

    // Film poster
    String poster = "shawshank.jpg";
    // Film director
    String director = "Frank Darabont";
    // Film writers
    String writers = "Stephen King (short story \"Rita Hayworth and Shawshank Redemption\"), Frank Darabont (screenplay)";
    // Film stars
    String stars = "Tim Robbins, Morgan Freeman, Bob Gunton";
    // Film genres
    String genres = "Drama";
    // Film release date
    String releaseDate = "14 October 1994 (USA)";
    // Film runtime
    String runtime = "142 min";
    // Film Rate
    String Rate = "9.3";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Page Preview");

        Label FilmFlow = new Label("Film Flow");
        FilmFlow.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        FilmFlow.setTextFill(Color.WHITE);
        Label headerLabel = new Label(title);
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        HBox headerPane = new HBox(10, FilmFlow, headerLabel);
        headerPane.setAlignment(Pos.CENTER_LEFT);
        headerPane.setPadding(new Insets(10));
        headerPane.setBackground(new Background(new BackgroundFill(Color.rgb(20, 20, 20), null, null)));

        // Set up the poster image pane with a drop shadow effect
        ImageView posterView = new ImageView(new Image(poster));
        posterView.setFitWidth(300);
        posterView.setPreserveRatio(true);
        posterView.setEffect(new DropShadow());

        // Set up the summary pane with film details
        Label summaryHeadingLabel = new Label("Summary");
        summaryHeadingLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        Text summaryTextArea = new Text(summary);
        summaryTextArea.setWrappingWidth(800);

        // summaryTextArea.setEditable(true);
        // summaryTextArea.setWrapText(true);
        // summaryTextArea.setPrefRowCount(5);
        summaryTextArea.setFont(Font.font("Arial", 25));
        VBox summaryPane = new VBox(10);
        summaryPane.setPadding(new Insets(10));

        // Set up the details pane with film information
        Label detailsHeadingLabel = new Label("Details");
        detailsHeadingLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        Label directorLabel = new Label();
        Text directorText = new Text("Director: ");
        Text dieText = new Text(director);
        directorText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        directorLabel.setGraphic(new HBox(directorText, dieText));

        Label writerLabel = new Label();
        Text writerText = new Text("Writer: ");
        Text wriText = new Text(writers);
        writerText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        writerLabel.setGraphic(new HBox(writerText, wriText));

        Label starsLabel = new Label();
        starsLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        Text starText = new Text("Star: ");
        Text stText = new Text(stars);
        starText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        starsLabel.setGraphic(new HBox(starText, stText));

        //Label genreLabel = new Label("Geners :" + genres);
        Label genreLabel = new Label();
        Text generText = new Text("Geners:");
        Text gnText = new Text(genres);
        generText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        genreLabel.setGraphic(new HBox(generText, gnText));








        Label releaseDateLabel = new Label("Release Date : " + releaseDate);
        Label runtimeLabel = new Label("Run Time : " + runtime);
        
        VBox detailsPane = new VBox(10, detailsHeadingLabel, directorLabel, writerLabel, starsLabel, genreLabel,
                releaseDateLabel, runtimeLabel);
        detailsPane.setPadding(new Insets(10));

        // Set up the reviews pane with user reviews
        Label reviewsHeadingLabel = new Label("User Reviews");
        reviewsHeadingLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        Label noReviewsLabel = new Label("Film Rate : " + Rate + " / 10");
        noReviewsLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        // change the color of the label
        noReviewsLabel.setTextFill(Color.rgb(255, 0, 0));

        VBox reviewsPane = new VBox(10, reviewsHeadingLabel, noReviewsLabel);
        reviewsPane.setPadding(new Insets(10));

        summaryPane.getChildren().addAll(summaryHeadingLabel, summaryTextArea, reviewsHeadingLabel, noReviewsLabel);
        // Set up the sidebar pane with related films
        Label sidebarHeadingLabel = new Label("Related Films");
        sidebarHeadingLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        VBox sidebarPane = new VBox(10, sidebarHeadingLabel);
        sidebarPane.setPadding(new Insets(10));

        // Set up the footer pane with home, about, and contact buttons
        Button BookNow = new Button("BOOK NOW");
        // change the color of the button
        BookNow.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff;");

        HBox footerPane = new HBox();
        footerPane.getChildren().add(BookNow);
        footerPane.setAlignment(Pos.CENTER);
        footerPane.setPadding(new Insets(10));
        footerPane.setBackground(new Background(new BackgroundFill(Color.rgb(20, 20, 20), null, null)));

        // Set up the main pane with the header, poster, summary, details, reviews,
        // sidebar, and footer panes
        BorderPane mainPane = new BorderPane();
        mainPane.setTop(headerPane);
        mainPane.setLeft(posterView);
        mainPane.setCenter(summaryPane);
        mainPane.setRight(detailsPane);
        mainPane.setBottom(footerPane);
        BorderPane.setMargin(posterView, new Insets(10));
        BorderPane.setMargin(summaryPane, new Insets(10));
        BorderPane.setMargin(detailsPane, new Insets(10));
        BorderPane.setMargin(footerPane, new Insets(10));
        mainPane.setBackground(new Background(new BackgroundFill(Color.rgb(245, 245, 245), null, null)));

        // Set up the scene and show the stage
        Scene scene = new Scene(mainPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Fade in the UI
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), mainPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }
}
