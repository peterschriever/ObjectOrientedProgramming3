package JavaFX;

import javafx.application.Application;
import javafx.stage.Stage;

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
        new RandomTicTacToe(stage);


    }

}
