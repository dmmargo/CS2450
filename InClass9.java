package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InClass9 extends Application {

    private Menu viewMenu;
    private Menu helpMenu;
    private BorderPane borderPane;
    private ListView<String> bookListview;
    private ListView<String> moveListview;
    BorderPane layout;

    //@Override
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        moveListview = new ListView<>();
        moveListview.getItems().addAll( "Conjouring", "IT", "UP");
        bookListview = new ListView<>();
        bookListview.getItems().addAll( "Green Eggs and Ham", "Lord of the Flies", "Romeo and Juliet");

        createViewMenu();
        createHelpMenu();

        MenuBar menuBar = new MenuBar();
        layout = new BorderPane();
        layout.setTop(menuBar);


        menuBar.getMenus().addAll( viewMenu, helpMenu);
        borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(bookListview);
        primaryStage.setScene(new Scene(borderPane));
        primaryStage.show();
    }

    private void createHelpMenu()
    {
        helpMenu = new Menu("Help");
        MenuItem aboutItem = new MenuItem("About");

        helpMenu.getItems().add(aboutItem);
        aboutItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText("Diane, 2020");
            alert.show();
        });
    }
    private void createViewMenu()
    {
        viewMenu = new Menu("View");
        RadioMenuItem bookItem = new RadioMenuItem( "Books");
        RadioMenuItem movieItem = new RadioMenuItem( "Movies");
        ToggleGroup toggleGroup = new ToggleGroup();
        bookItem.setToggleGroup(toggleGroup);

        bookItem.setSelected( true);
        movieItem.setToggleGroup(toggleGroup);
        MenuItem exitItem = new MenuItem("Exit");
        viewMenu.getItems().addAll(bookItem, new SeparatorMenuItem(), movieItem, new SeparatorMenuItem(), exitItem);

        bookItem.setOnAction(event -> {
            borderPane.setCenter(bookListview);
        });
        movieItem.setOnAction(event -> {
            borderPane.setCenter(moveListview);
        });
        exitItem.setOnAction(event -> {
            System.exit(0);
        });
    }
}
