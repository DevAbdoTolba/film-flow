package film;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FilmPage {
    public String s; 
    public Payment pr = null ;
    private int seats ;
    private int rate;
    
    Label seatsLabel = new Label("Seats remaining : " + (12 - this.seats));
    Label rateValueLabel = new Label("Rating : "+this.rate + "/5");


    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
        this.seatsLabel.setText("Seats remaining : " + (12 - this.seats));
    }
    
    
    
    public Scene createScene(String title, String summary, InputStream poster, String posterString, int price, int seats, int rate) throws FileNotFoundException, SQLException {
        setSeats(seats);
        this.rate = rate;
        System.out.println("Poster : " + poster);
        System.out.println("PosterString : " + posterString);
        InputStream posterStream = new FileInputStream(posterString);
        
//        Label FilmFlow = new Label("Film Flow");
//        FilmFlow.setFont(Font.font("Arial", FontWeight.BOLD, 24));
//        FilmFlow.setTextFill(Color.GREEN);
        Label headerLabel = new Label(title);
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        headerLabel.setTextFill(Color.WHITE);
        BorderPane headerPane = new BorderPane();
         headerPane.setStyle("-fx-background-color: #191923; -fx-padding: 10px;");
                headerPane.setPadding(new Insets(10, 10, 10, 10));

                // Create logo label and add it to logoBox
                Button logoButton = new Button("Film Flow");
                logoButton.setStyle(
                                "-fx-background-color: #191923; -fx-text-fill: #44cf6c; -fx-padding: 8px 16px; -fx-font-size: 40px; -fx-border-color: #191923; -fx-border-radius: 20;");
                        logoButton.setOnAction(e -> {
            // Get the current stage
            Stage stage = (Stage) logoButton.getScene().getWindow();
            // Close the stage
            stage.close();
        });
        headerPane.setLeft(logoButton);
        headerPane.setLeft(logoButton);
        headerPane.setCenter(headerLabel);
        
        
        
        

        // headerPane.setAlignment(Pos.CENTER_LEFT);
        headerPane.setPadding(new Insets(10));
        headerPane.setBackground(new Background(new BackgroundFill(Color.rgb(20, 20, 20), null, null)));

        // Set up the poster image pane with a drop shadow effect
        Image posterImage = new Image(posterStream);
        ImageView posterView = new ImageView(posterImage);
        posterView.setFitWidth(300);
        posterView.setPreserveRatio(true);
        posterView.setEffect(new DropShadow());

        // Set up the summary pane with film detailsLabel
        Label priceLabel = new Label();
        priceLabel.setText("Price : " + price + "$");
        Label summaryHeadingLabel = new Label("Description");
        summaryHeadingLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));
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

        

       
       

        // Label releaseDateLabel = new Label("Release Date : " + releaseDate);
        // Label runtimeLabel = new Label("Run Time : " + runtime);

       

       

        summaryPane.getChildren().addAll(priceLabel,summaryHeadingLabel, summaryTextArea);
        // Set up the sidebar pane with related films
        Label sidebarHeadingLabel = new Label("Related Films");
        sidebarHeadingLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        VBox sidebarPane = new VBox(10, sidebarHeadingLabel);
        sidebarPane.setPadding(new Insets(10));

        BorderPane footerPane = new BorderPane();
        footerPane.setStyle("-fx-background-color: #191923; -fx-padding: 10px;");
        Button BookNow = new Button("BOOK NOW");
        // change the color of the button
        BookNow.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff;");
        BookNow.setOnAction(e -> {
            pr = new Payment( title, price, this.seats, this);
            if( !pr.getIsOpen() ) try {
                pr.start(new Stage());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FilmPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        footerPane.setCenter(BookNow);
        // Set up the main pane that contains all the other panes
        BorderPane mainPane = new BorderPane();
        mainPane.setTop(headerPane);
        mainPane.setLeft(posterView);
        mainPane.setCenter(summaryPane);
        
        Label seatsLabel = new Label("Seats remaining : " + (12 - this.seats));
        seatsLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        
        
        
        Label rateLabel = new Label("Rate");
        ComboBox<Integer> rateComboBox = new ComboBox<>();
        rateComboBox.getItems().addAll(1, 2, 3, 4, 5);
        
        rateComboBox.setOnAction(e ->{
                
                int rateValue = rateComboBox.getValue();
                String host ;
                Connection con;

                host = "jdbc:derby://localhost:1527/filmflow";
            try {
                rateValueLabel.setText("Rating : "+ ((this.rate + rateValue) / 2) + "/5");
                System.out.println("Added! value : " + rateValue + "\nTo the movie : " + title);
                con = DriverManager.getConnection(host);
                String AverageRate = "update movies SET M_RATE = (M_RATE + ? ) / 2 WHERE M_NAME = ?";

                PreparedStatement stetmt = con.prepareStatement(AverageRate);
                stetmt.setInt(1, rateValue);
                stetmt.setString(2, title);
                
                stetmt.executeUpdate();
                
                stetmt.close();
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(FilmPage.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                
        });
        
        
        rateValueLabel.setText("Rating : "+this.rate + "/5");
        HBox rateBox = new HBox(rateLabel, rateComboBox, rateValueLabel);
        rateBox.setSpacing(20);
        
        VBox rateAndSeats = new VBox();
        
        String host = "jdbc:derby://localhost:1527/filmflow";
        Connection con = DriverManager.getConnection(host);

        Statement stmt = con.createStatement();

        String IncrementSeats = "select * from movies where m_name = '" + title + "'";
        ResultSet rs ;
        rs = stmt.executeQuery(IncrementSeats);

        rs.next();
        int Time = rs.getInt("M_TIME") ; 
        Label timeLabel = new Label("At  " + (Time > 9 ? "" : "0") + Time + ":00 O'Clock");
        timeLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        stmt.close();
        
        rateAndSeats.getChildren().addAll(timeLabel,seatsLabel,rateBox);
        rateAndSeats.setPadding( new Insets(50.0,50.0,0.0,0.0));
        
        
        mainPane.setRight(rateAndSeats);
       
        mainPane.setBottom(footerPane);
        BorderPane.setMargin(posterView, new Insets(10));
        BorderPane.setMargin(summaryPane, new Insets(10));
       
        BorderPane.setMargin(sidebarPane, new Insets(10));
        mainPane.setBackground(new Background(new BackgroundFill(Color.rgb(240, 240, 240), null, null)));

        // Set up the scene with the main pane
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = screenBounds.getWidth();
        double screenHeight = screenBounds.getHeight();
        Scene scene = new Scene(mainPane, screenWidth, screenHeight);

        // Set up the fade in transition for the scene
        FadeTransition ft = new FadeTransition(Duration.millis(1000), mainPane);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();

        return scene;
    }
}