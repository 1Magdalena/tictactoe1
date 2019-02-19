package game;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Tictactoe extends Application {
    private Image image = new Image("graphics/image.png");
    private StateOfTheGame stateOfTheGame = new StateOfTheGame();


    public static void main(String[] args) {


        launch(args);
    }

    private static final Image CROSS = new Image("graphics/cross.png");
    private static final Image CIRCLE = new Image("graphics/circle.png");

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(650, 650, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();

        grid.setBackground(background);

        grid.add(createSquare(0, 0), 0, 0);
        grid.add(createSquare(1, 0), 1, 0);
        grid.add(createSquare(2, 0), 2, 0);

        grid.add(createSquare(0, 1), 0, 1);
        grid.add(createSquare(1, 1), 1, 1);
        grid.add(createSquare(2, 1), 2, 1);

        grid.add(createSquare(0, 2), 0, 2);
        grid.add(createSquare(1, 2), 1, 2);
        grid.add(createSquare(2, 2), 2, 2);

        Scene scene = new Scene(grid, 600, 600, Color.WHITESMOKE);

        primaryStage.setTitle("Tictactoe");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private ImageView createSquare(double x, double y) {
        ImageView imageView = new ImageView();
        imageView.setImage(CROSS);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ImageView thisElement = (ImageView) event.getSource();

                if (stateOfTheGame.isAvailable((int) thisElement.getX(), (int) thisElement.getY())) {

                    if (thisElement.getImage().equals(CROSS)) {
                        thisElement.setImage(CIRCLE);
                    } else {
                        thisElement.setImage(CROSS);
                    }

                }else {
                    Stage dialogStage = new Stage();
                    dialogStage.initModality(Modality.WINDOW_MODAL);

                    VBox vbox = new VBox(new Text("Hi"), new Button("Ok."));
                    vbox.setAlignment(Pos.CENTER);
                    vbox.setPadding(new Insets(15));

                    dialogStage.setScene(new Scene(vbox));
                    dialogStage.show();

                }

                System.out.println("Coordinates clicked is x = " + thisElement.getX() + " y = " + thisElement.getY());


            }
        });
        imageView.setX(x);
        imageView.setY(y);

        return imageView;
    }
}
