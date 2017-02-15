package MultiThreading;

import javafx.application.Application;
import javafx.stage.Stage;

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
//        new MultiThreading.ThousandThreadsIncrement(1000, true);

        // 30.6
//        stage.setTitle("Hello bouncy world!");
//        MultiThreading.BallPane ballPane = new MultiThreading.BallPane();
//        Scene scene = new Scene(ballPane, 400, 300);
//        stage.setScene(scene);
//        stage.show();
//        Platform.runLater(() -> {
//            IntStream.range(0, 100).forEach(i -> ballPane.increaseSpeed());
//        });

        // 30.8
//        MultiThreading.ThreadCooperation.main(null);

        // 30.15
        ParallelSum.main(null);
    }
}