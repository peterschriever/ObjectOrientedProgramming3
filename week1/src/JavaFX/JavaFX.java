package JavaFX;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.stream.IntStream;

/**
 * Created by peterzen on 2017-02-15.
 * Part of the OOP3 project.
 */
public class JavaFX extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // 14.2
        stage.setTitle("Hello bouncy world!");

        // prep TicTacToe grid
        Group ticTacToeGrid = new Group();
        Scene scene = new Scene(ticTacToeGrid);

        // prepare and populate a 3*3 GridPane layout
        GridPane layout = new GridPane();
        layout.setGridLinesVisible(true); // NOTICE: for debugging only!
        layout.setStyle("-fx-background-color: #d3d3d3; -fx-border-width: 5px; -fx-border-color: #222;");
        IntStream.range(0, 3).forEach(column ->
            IntStream.range(0, 3).forEach(row -> {
                TicTacToeCell cell = new TicTacToeCell();
                if (cell.iv.getImage() == null) {
                    Pane emptyCell = new Pane();
                    emptyCell.setMinHeight(50);
                    emptyCell.setMinWidth(50);
                    layout.add(emptyCell, column, row);
                } else {
                    layout.add(cell.iv, column, row);
                }
            })
        );
        ticTacToeGrid.getChildren().add(layout);

        stage.setWidth(400);
        stage.setHeight(300);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    private class TicTacToeCell extends Pane {

        public ImageView iv;

        public TicTacToeCell() {
            Image image = this.getCellImage(Math.random());
            iv = new ImageView();

            iv.setImage(image);
            iv.setFitWidth(50);
            iv.setPreserveRatio(true);
            iv.setSmooth(true);
            iv.setCache(true);
        }

        private Image getCellImage(double random) {
            if (random > 0.66) {
                return null;
            } else if (random > 0.33) {
                return new Image("o.gif");
            } else {
                return new Image("x.gif");
            }
        }


    }

}
