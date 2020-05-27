import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MinesweeperGIUClient extends Application {
    public void start(Stage stage) {
        Scene scene = new Scene(new MinesweeperGUI(), 10000, 10000);

        stage.setTitle("MinesweeperGIUe.java");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
