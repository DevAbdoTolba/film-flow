///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package film;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
///**
// *
// * @author 20102
// */
//public class Film extends Application {
//    
//    
//    
//    @Override
//    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(e -> {
//             try{
//            String host = "jdbc:derby://localhost:1527/filmflow";
//            Connection con = DriverManager.getConnection(host);
//            
//            
//            
//            Statement stmt = con.createStatement();
//            String SQL = "SELECT * from test";
//            ResultSet rs = stmt.executeQuery(SQL);
//            while(rs.next())
//            System.out.println(rs.getString("NAME"));
//            
//
//        } catch(SQLException er){
//            System.out.println(er);
//        }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//
//    
//}
