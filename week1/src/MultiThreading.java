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
        TaskThreadDemo.main(null, stage);
    }
}