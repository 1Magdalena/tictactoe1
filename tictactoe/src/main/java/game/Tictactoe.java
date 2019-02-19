package game;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import javafx.stage.Stage;


import java.util.Scanner;

public class Tictactoe extends Application {
    private Image image = new Image("graphics/image.png");



    public static void main(String[] args) {


        launch (args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(650, 650, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);




        GridPane grid = new GridPane();

        GridPane gridpane = new GridPane();
        gridpane.getColumnConstraints().add(new ColumnConstraints(200));
        gridpane.getColumnConstraints().add(new ColumnConstraints(200));

        grid.setBackground(background);

        Scene scene = new Scene(grid, 600, 600, Color.WHITESMOKE);

        primaryStage.setTitle("Tictactoe");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
