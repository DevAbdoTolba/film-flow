package film;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;

public class Payment extends Application  {
    
    private String movie ;
    private boolean isOpen = false;
    private boolean isStatueOpen = false;
    private int price;
    private int seats;
    private FilmPage filmPage;
    
    public Payment() {
    }
    
    public Payment(int price){
        this.price = price;
    }
    
    public Payment(String movie) {
        this.movie = movie;
    }

    public Payment(int price, String movie){
        this.price = price;
        this.movie = movie;
    }

    public Payment(String movie, int price, int seats) {
        this.movie = movie;
        this.price = price;
        this.seats = seats;
    }

    public Payment(String movie, int price, int seats, FilmPage filmPage) {
        this.movie = movie;
        this.price = price;
        this.seats = seats;
        this.filmPage = filmPage;
    }
    
    
    
    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    
    
    public boolean isIsStatueOpen() {
        return isStatueOpen;
    }

    public void setIsStatueOpen(boolean isStatueOpen) {
        this.isStatueOpen = isStatueOpen;
    }
    
    public void setIsOpen(boolean isOpen){
        this.isOpen = isOpen; 
    }
    
    public boolean getIsOpen(){
        return this.isOpen; 
    }
    
    
    private TextField cardNumberTextField;
    private TextField cardHolderTextField;
    private TextField expiryDateTextField;
    private TextField cvvTextField;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        this.isOpen = true;
        
        
        primaryStage.setTitle("Payment Page");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Label priceLabel = new Label("Price : " + price + "$");
        gridPane.add(priceLabel, 0, 1);
        
        Label cardNumberLabel = new Label("Card Number:");
        gridPane.add(cardNumberLabel, 0, 2);

        cardNumberTextField = new TextField();
        cardNumberTextField.setPromptText("Card Number");
        
//        TextFormatter<Integer> NumberFormatter = new TextFormatter<>(
//            new IntegerStringConverter(),
//            0,
//            change -> {
//                if (!change.getText().matches("\\d+")) {
//                    change.setText(change.getText().replaceAll("[^\\d]", ""));
//                } else if (change.getText().length() > 50) {
//                    change.setText(change.getText().substring(0, 50));
//                }
//                return change;
//            }
//        );
        


        gridPane.add(cardNumberTextField, 1, 2);
        
        Label cardHolderLabel = new Label("Card Holder: ");
        gridPane.add(cardHolderLabel, 0, 4);

        cardHolderTextField = new TextField();
        cardHolderTextField.setPromptText("CardHolder");
        gridPane.add(cardHolderTextField, 1, 4);

        Label expiryDateLabel = new Label("Expiry Date:");
        gridPane.add(expiryDateLabel, 0, 6);

        expiryDateTextField = new TextField();
        expiryDateTextField.setPromptText("exp. year");
        
        TextFormatter<Integer> DateFormater = new TextFormatter<>(
            new IntegerStringConverter(),
            0,
            change -> {
                if (!change.getText().matches("\\d+") && change.getText().length() > 3) {
                    change.setText(change.getText().replaceAll("[^\\d]", ""));
                    change.setText(change.getText().substring(0, 3));
                }
                return change;
            }
        );
        
        expiryDateTextField.setTextFormatter(DateFormater);
        expiryDateTextField.setText("");
        
        gridPane.add(expiryDateTextField, 1, 6);

        Label cvvLabel = new Label("CVV:");
        gridPane.add(cvvLabel, 0, 5);
        
        TextFormatter<Integer> CvvFormater = new TextFormatter<>(
            new IntegerStringConverter(),
            0,
            change -> {
                if (!change.getText().matches("\\d+") && change.getText().length() > 3) {
                    change.setText(change.getText().replaceAll("[^\\d]", ""));
                    change.setText(change.getText().substring(0, 3));
                }
                return change;
            }
        );


        cvvTextField = new TextField();
        cvvTextField.setPromptText("CVV");

        cvvTextField.setTextFormatter(CvvFormater);
        cvvTextField.setText("");
        
        
        gridPane.add(cvvTextField, 1, 5);
        
        // ? PayButton pay
        Button PayButton = new Button("Pay");
        Button cashButton = new Button ("Cash");
        cashButton.setOnAction(e -> {
            
            try {
                String host = "jdbc:derby://localhost:1527/filmflow";
                Connection con = DriverManager.getConnection(host);

                Statement stmt = con.createStatement();

                String IncrementSeats = "update movies SET M_SEATS=M_SEATS+1 WHERE M_NAME='"+movie+"'";
                stmt.execute(IncrementSeats);
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                        
                primaryStage.close();
                
                    
        });
        
        
        PayButton.setOnAction(e -> {
            
            cvvTextField.setStyle("-fx-border-color: black;");
            expiryDateTextField.setStyle("-fx-border-color: black;");
            cardNumberTextField.setStyle("-fx-border-color: black;");
            cardHolderTextField.setStyle("-fx-border-color: black;");
            
            String digits, month, year, ccv;
            
            digits = cardNumberTextField.getText();
            year = expiryDateTextField.getText();
            
            ccv = cvvTextField.getText();
            try{
            if(
                    
                    ccv.length() >= 3 &&
                    year.length() >= 2 &&
                    digits.length() >= 11 &&
                    cardHolderTextField.getText().length() > 0 
                                                )
                    
            {
            
                if(
                    isValidCCV(ccv) &&
                    isValidDate("12", year)&&
                    isValid(digits) ){
            
                 
                
                
            Random rand = new Random();
            int x = (rand.nextInt()) % 100;
            long unsignedInt = Integer.toUnsignedLong(x);
            System.out.println(unsignedInt);
            Stage statue = new Stage() ;
            InputStream Img = null ;
            try {
                System.out.println("Number of Seats : " +filmPage.getSeats());
                if(unsignedInt >= 80  || filmPage.getSeats() < 1){
                    Img = new FileInputStream("C:/Users/20102/Downloads/suc.gif") ;
                    
                    String host = "jdbc:derby://localhost:1527/filmflow";
                    Connection con = DriverManager.getConnection(host);

                    Statement stmt = con.createStatement();

                    String IncrementSeats = "update movies SET M_SEATS=M_SEATS+1 WHERE M_NAME='"+movie+"'";
                    stmt.execute(IncrementSeats);
                    
                    stmt.close();
                    
                    filmPage.setSeats(filmPage.getSeats()+1);
                    
                               Image Suc = new Image(Img);
            ImageView sucI = new ImageView(Suc);
            sucI.setFitWidth(300);
            sucI.setFitHeight(200);
            
            
            HBox lay = new HBox(sucI);
            lay.setStyle("-fx-background-color : #ffffff");
            lay.setAlignment(Pos.CENTER);
            
            
            Scene successS = new Scene(lay , 400 , 400);
            statue.setScene(successS);
            
            if(!isStatueOpen){
                statue.show();
                primaryStage.close();
                setIsStatueOpen(!isStatueOpen);
                
            }
            
                    
                } else {
                    Img = new FileInputStream("C:/Users/20102/Downloads/f.gif")   ;
                    Image Suc = new Image(Img);
                    ImageView sucI = new ImageView(Suc);
                    sucI.setFitWidth(300);
                    sucI.setFitHeight(200);
                    
                    
                    HBox lay = new HBox(sucI);
                    lay.setStyle("-fx-background-color : #ffffff");
                    lay.setAlignment(Pos.CENTER);
                    
                    
                    Scene successS = new Scene(lay , 400 , 400);
                    statue.setScene(successS);
                    
            if(!isStatueOpen){
                statue.show();
                
                setIsStatueOpen(!isStatueOpen);
            }
            
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
            
            
            
            
            
            
 
            
            statue.setOnCloseRequest(ev -> {
                setIsStatueOpen(!isStatueOpen);
            });
             }} else {
                    
                
                if ( ((ccv.length() > 0) && ! isValidCCV(ccv)) ||  (! (ccv.length() == 3 )) )
                    cvvTextField.setStyle("-fx-border-color: red;");
                if ( ((year.length() > 0) && ! isValidDate("12", year) ) || (!  (year.length() >= 2)) )
                    expiryDateTextField.setStyle("-fx-border-color: red;");
                if( ( digits.length() > 0  && ! isValid(digits) ) || (  ! (digits.length() >= 11) ) )
                    cardNumberTextField.setStyle("-fx-border-color: red;");
                if ( ! (cardHolderTextField.getText().length() > 0))
                    cardHolderTextField.setStyle("-fx-border-color: red;");
                
            }
            }  catch(Exception ex) {
                System.out.println(ex.getMessage());
                
              
            }
        });
        
        cvvTextField.setStyle("-fx-border-color: black;");
        expiryDateTextField.setStyle("-fx-border-color: black;");
        cardNumberTextField.setStyle("-fx-border-color: black;");
        cardHolderTextField.setStyle("-fx-border-color: black;");
        
        cashButton.setBorder(new Border(new BorderStroke(Color.web("#44cf6c"),
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(2))));
        cashButton.setStyle(
                "-fx-border-color: #44cf6c; -fx-border-width: 2px; -fx-border-radius: 20; -fx-background-color:  #44cf6c; -fx-text-fill: #191923 ; -fx-padding: 8px 16px; -fx-font-size: 16px;");
        HBox.setMargin(PayButton, new Insets(0, 20, 0, 0));
        HBox.setHgrow(PayButton, Priority.ALWAYS);
        
        PayButton.setBorder(new Border(new BorderStroke(Color.web("#44cf6c"),
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(2))));
        // set radius to PayButton
        
        PayButton.setStyle(
                "-fx-border-color: #44cf6c; -fx-border-width: 2px; -fx-border-radius: 20; -fx-background-color:  #44cf6c; -fx-text-fill: #191923 ; -fx-padding: 8px 16px; -fx-font-size: 16px;");
        HBox.setMargin(PayButton, new Insets(0, 20, 0, 0));
        HBox.setHgrow(PayButton, Priority.ALWAYS);

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(PayButton,cashButton);
        gridPane.add(hbBtn, 1, 7);
        
        
        
        InputStream stream = null;
        stream = new FileInputStream("C:/Users/20102/Downloads/pay.png");
        Image payImg = new Image(stream);
        ImageView payImgV = new ImageView(payImg);
        payImgV.setFitWidth(500);        
        payImgV.setFitHeight(100);


        
        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(gridPane,payImgV);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(vbox);
//        BorderPane topBar = new BorderPane();
//        topBar.setStyle("-fx-background-color: #191923; -fx-padding: 10px;");
//        Button logoButton = new Button("Film Flow");
//        logoButton.setStyle(
//                "-fx-background-color: #191923; -fx-text-fill: green; -fx-padding: 8px 16px; -fx-font-size: 15px; -fx-border-color: black; -fx-border-radius: 20;");
//        topBar.setLeft(logoButton);
//        topBar.setPadding(new Insets(10, 10, 10, 10));

        borderPane.setCenter(vbox);
//        borderPane.setTop(topBar);

        Scene scene = new Scene(borderPane, 650, 450);

        primaryStage.setScene(scene);
        primaryStage.show();

        // Add a fade-in animation to the payment form
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), gridPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        primaryStage.setOnCloseRequest(e -> isOpen = false);
        
    }

    public static boolean isValid(String visaNumber) {
        if(true)
        return true;
        int sum = 0;
        for (int i = 0; i < visaNumber.length(); i++) {
            int digit = visaNumber.charAt(i) - '0';
            sum += digit * (i + 1);
        }
        return sum % 10 == 0;
    }

        public static boolean isValidCCV(String ccv) {
        // Check if the CCV is the correct length.
        if (ccv.length() != 3) {
            return false;
        }

        // Check if the CCV contains only digits.
        for (char c : ccv.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
       
    public static boolean isValidDate(String month, String year) {
        // Check if the month is valid.
        if (month.length() != 2) {
            return false;
        }

        int monthNumber = Integer.parseInt(month);
        if (monthNumber < 1 || monthNumber > 12) {
            return false;
        }

        // Check if the year is valid.
        if (year.length() == 2) {
            year = "20" + year;
        }

        
        int yearNumber = Integer.parseInt(year);
        
        if (yearNumber < 1900 || yearNumber > 2100) {
            return false;
        }

        // Check if the date is in the future.
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.of(yearNumber, monthNumber, 1);
        return date.compareTo(today) > 0;
    }
    
}