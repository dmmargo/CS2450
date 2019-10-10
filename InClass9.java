package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InClass9 extends Application {

    Stage window;
    BorderPane layout;


    //@Override
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("InClass 9");

        //File menu
        Menu radioMenu = new Menu("View");
        //MenuItem newFile = new MenuItem("New...");
        //newFile.setOnAction(e -> System.out.println("Create a new file..."));
        //fileMenu.getItems().add(newFile);
        //fileMenu.getItems().add(new MenuItem("Open..."));
        radioMenu.getItems().add(new MenuItem("Book"));
        radioMenu.getItems().add(new SeparatorMenuItem());
        radioMenu.getItems().add(new MenuItem("Movie"));
        radioMenu.getItems().add(new SeparatorMenuItem());
        radioMenu.getItems().add(new MenuItem("Exit"));

        ListView<String> listView1 = new ListView<>();
        listView1.setPrefSize(100,75);
        listView1.getItems().addAll("book1", "book2", "book3");
        VBox vBox = new VBox(listView1);
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.CENTER);
        bp.setCenter(vBox)


        //Help menu
        Menu helpMenu = new Menu("Help");
        helpMenu.getItems().add(new MenuItem("About"));


        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(radioMenu, helpMenu);

        layout = new BorderPane();
        layout.setTop(menuBar);
        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }
}