import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;

public class MinesweeperGUI extends GridPane {
    Minesweeper minesweeper = new Minesweeper();
    private Button[][] grid = new Button[20][20];
    private Button newGame;
    private int[][] bombs = new int[20][20];

    public MinesweeperGUI(){
        bombs = minesweeper.start();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y] = new Button("Click Here");
                grid[x][y].setOnAction(this::processClick);
            }
        }
        newGame = new Button("Reset");
        newGame.setOnAction(this::processReset);

        setAlignment(Pos.CENTER);
        setHgap(20);
        setVgap(10);
        setStyle("-fx-background-color: white");



        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                add(grid[x][y], x,y);
            }
        }
        add(newGame, 24,0);
    }
    private void processClick(ActionEvent event1){
        
    }

    private void processReset(ActionEvent event2){

    }
}
