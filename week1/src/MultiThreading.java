import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.stream.IntStream;

/**
 * Created by peterzen on 2017-02-13.
 * Part of the Week1 project.
 */
public class MultiThreading extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        // 30.1
//        TaskThreadDemo.main(null, stage);

        // 30.4
//        new ThousandThreadsIncrement(1000, true);

        // 30.6
        stage.setTitle("Hello bouncy world!");
        BallPane ballPane = new BallPane();
        Scene scene = new Scene(ballPane, 400, 300);
        stage.setScene(scene);
        stage.show();
        Platform.runLater(() -> {
            IntStream.range(0, 100).forEach(i -> ballPane.increaseSpeed());
        });
    }
}