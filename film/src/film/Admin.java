package film;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.*;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class Admin extends Application {

    private TableView<ObservableList<String>> usersTable = new TableView<>();
    private TableView<ObservableList<String>> moviesTable = new TableView<>();

    private ObservableList<ObservableList<String>> usersData = FXCollections.observableArrayList();
    private ObservableList<ObservableList<String>> moviesData = FXCollections.observableArrayList();

    private Connection conn;

    private Label usersLabel = new Label("Users Table");
    private Label moviesLabel = new Label("Movies Table");

    private Button addUserButton = new Button("Add User");
   private Button deleteUserButton = new Button("Delete User");
    private Button addMovieButton = new Button("Add Movie");
    private Button deleteMovieButton = new Button("Delete Movie");

    private TextField usernameField = new TextField();
    private TextField passwordField = new TextField();
    private TextField movieNameField = new TextField();
    private TextField imageLinkField = new TextField();
    private TextField movieDescField = new TextField();

    private final String USER_TABLE_NAME = "USERS";
    private final String MOVIE_TABLE_NAME = "MOVIES";
    
    
    Button closeButton = new Button("Close");
    
   


    @Override
    public void start(Stage primaryStage) {
        closeButton.setStyle("-fx-background-color : red;");

        closeButton.setOnAction(e -> {
            // Get the current stage
            Stage stage = (Stage) closeButton.getScene().getWindow();
            // Close the stage
            stage.close();
        });
        
        try {
            // Connect to the database
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/filmflow");

            // Initialize the tables
            initUsersTable();
            initMoviesTable();

            // Initialize the buttons
            initAddUserButton();
            initDeleteUserButton();
            initAddMovieButton();
            initDeleteMovieButton();

            // Initialize the text fields
            initUsernameField();
            initPasswordField();
            initMovieNameField();
            initImageLinkField();
            initMovieDescField();

            // Set up the layout
            HBox root = new HBox();
            root.setPadding(new Insets(10, 10, 10, 10));

            VBox usersBox = new VBox();
            usersBox.setAlignment(Pos.CENTER);
            usersBox.setSpacing(10);
            usersBox.getChildren().addAll(usersLabel, usersTable, addUserButton, deleteUserButton, usernameField, passwordField );

            VBox moviesBox = new VBox();
            moviesBox.setPrefWidth(1000);
            moviesBox.setAlignment(Pos.CENTER);
            moviesBox.setSpacing(10);
            moviesBox.getChildren().addAll(moviesLabel, moviesTable, addMovieButton, deleteMovieButton, movieNameField, imageLinkField, movieDescField);

            HBox hbox = new HBox();
            hbox.setSpacing(10);
            hbox.getChildren().addAll(usersBox, moviesBox, closeButton);
            hbox.setSpacing(250);
            hbox.setPadding(new Insets(30));

            root.getChildren().addAll(hbox);
            
            
            
                    
            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            double screenWidth = screenBounds.getWidth();
            double screenHeight = screenBounds.getHeight();
            // Set up the scene
            Scene scene = new Scene(new Group(), screenWidth , screenHeight);
            ((Group) scene.getRoot()).getChildren().addAll(root);
            primaryStage.setScene(scene);
            primaryStage.setFullScreen(true);

            // Show the stage
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initUsersTable() {
        usersTable.setEditable(true);

        // Add columns to the table
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + USER_TABLE_NAME);
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            for (int i = 1; i <= colCount; i++) {
                final int j = i - 1;
                TableColumn<ObservableList<String>, String> col = new TableColumn<>(rsmd.getColumnLabel(i));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList<String>, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j));
                    }
                });
                col.setCellFactory(TextFieldTableCell.forTableColumn());
                usersTable.getColumns().add(col);
            }

            // Populate the table with data
            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= colCount; i++) {
                    row.add(rs.getString(i));
                }
                usersData.add(row);
            }
            usersTable.setItems(usersData);

            // Close the statement and result set
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initMoviesTable() {
        moviesTable.setEditable(true);

        // Add columns to the table
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + MOVIE_TABLE_NAME);
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            for (int i = 1; i <= colCount; i++) {
                final int j = i - 1;
                TableColumn<ObservableList<String>, String>col = new TableColumn<>(rsmd.getColumnLabel(i));
                if (i == 2) {
                    col.setCellFactory(param -> new TableCell<ObservableList<String>, String>() {
                        private final ImageView imageView = new ImageView();

                        
                    });
                } else {
                    col.setCellFactory(TextFieldTableCell.forTableColumn());
                }
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList<String>, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j));
                    }
                });
                moviesTable.getColumns().add(col);
            }

            // Populate the table with data
            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= colCount; i++) {
                    row.add(rs.getString(i));
                }
                moviesData.add(row);
            }
            moviesTable.setItems(moviesData);

            // Close the statement and result set
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initAddUserButton() {
        addUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    // Get the username and password from the text fields
                    String username = usernameField.getText();
                    String password = passwordField.getText();

                    // Insert the new user into the database
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO " + USER_TABLE_NAME + " (username, password) VALUES (?, ?)");
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    stmt.executeUpdate();

                    // Update the table view
                    ObservableList<String> row = FXCollections.observableArrayList();
                    row.add(Integer.toString(usersData.size() + 1));
                    row.add(username);
                    row.add(password);
                    row.add("-1");
                    usersData.add(row);
                    usersTable.setItems(usersData);

                    // Clear the text fields
                    usernameField.clear();
                    passwordField.clear();

                    // Close the statement
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initDeleteUserButton() {
        deleteUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    // Get the selected row
                    ObservableList<String> row = usersTable.getSelectionModel().getSelectedItem();

                    // Delete the user from the database
                    PreparedStatement stmt = conn.prepareStatement("DELETE FROM " + USER_TABLE_NAME + " WHERE id = ?");
                    stmt.setInt(1, Integer.parseInt(row.get(0)));
                    stmt.executeUpdate();

                    // Remove the row from the table view
                    usersData.remove(row);
                    usersTable.setItems(usersData);

                    // Close the statement
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initAddMovieButton() {
        addMovieButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    // Get the movie name, image link, and description from the text fields
                    String movieName = movieNameField.getText();
                    String imageLink = imageLinkField.getText();
                    String movieDesc = movieDescField.getText();

                    // Insert the new movie into the database
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO " + MOVIE_TABLE_NAME + " (m_name, ImageLink, m_desc) VALUES (?, ?, ?)");
                    stmt.setString(1, movieName);
                    stmt.setString(2, imageLink);
                    stmt.setString(3,movieDesc);
                    stmt.executeUpdate();// Update the table view
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(Integer.toString(moviesData.size() + 1));
                row.add(movieName);
                row.add(imageLink);
                row.add(movieDesc);
                moviesData.add(row);
                moviesTable.setItems(moviesData);

                // Clear the text fields
                movieNameField.clear();
                imageLinkField.clear();
                movieDescField.clear();

                // Close the statement
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    });
}

private void initDeleteMovieButton() {
    deleteMovieButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try {
                // Get the selected row
                ObservableList<String> row = moviesTable.getSelectionModel().getSelectedItem();

                // Delete the movie from the database
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM " + MOVIE_TABLE_NAME + " WHERE id = ?");
                stmt.setInt(1, Integer.parseInt(row.get(0)));
                stmt.executeUpdate();

                // Remove the row from the table view
                moviesData.remove(row);
                moviesTable.setItems(moviesData);

                // Close the statement
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    });
}

private void initUsernameField() {
    usernameField.setPromptText("Username");
}

private void initPasswordField() {
    passwordField.setPromptText("Password");
}

private void initMovieNameField() {
    movieNameField.setPromptText("Movie Name");
}

private void initImageLinkField() {
    imageLinkField.setPromptText("Image Link");
}

private void initMovieDescField() {
    movieDescField.setPromptText("Movie Description");
}


@Override
public void stop() throws Exception {
    super.stop();
    conn.close();
}

}
