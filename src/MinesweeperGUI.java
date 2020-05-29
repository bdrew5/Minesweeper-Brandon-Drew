import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import java.awt.*;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class MinesweeperGUI extends GridPane {
    Font f1 = new Font(40);
    Font f2 = new Font(12);
    Minesweeper minesweeper = new Minesweeper();
    private Button[][] grid = new Button[20][20];
    private Button newGame;
    private int[][] bombs;
    private TextField numBombs;
    private int totalMines;
    private Label numBombsLabel;
    private Label win;
    private Label lose;

    public MinesweeperGUI(){
        numBombs = new TextField();
        numBombs.setPrefWidth(70.0D);
        numBombs.setAlignment(Pos.CENTER);
        numBombs.setOnAction(this::processReturn);
        win = new Label("You Win");
        win.setVisible(false);
        win.setFont(f2);
        win.setTextFill(Color.WHITE);
        lose = new Label("You Lose");
        lose.setVisible(false);
        lose.setFont(f2);
        lose.setTextFill(Color.WHITE);
        numBombsLabel = new Label("Enter the Amount of Mines");

        bombs = minesweeper.getGrid();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y] = new Button("");
                grid[x][y].setOnAction(this::processClick);
                grid[x][y].setStyle("-fx-background-color: GREENYELLOW");
                grid[x][y].setTextFill(Color.WHITE);
                grid[x][y].setVisible(false);
            }
        }
        newGame = new Button("Reset");
        newGame.setOnAction(this::processReset);
        newGame.setVisible(false);

        setAlignment(Pos.CENTER);
        setHgap(20);
        setVgap(10);
        setStyle("-fx-background-color: GREEN");



        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                add(grid[x][y], x+1,y);
            }
        }
        add(newGame, 0,9);
        add(numBombs, 0, 1);
        add(numBombsLabel,0,0);
        add(win, 22, 6);
        add(lose,22,11);
    }
    private void processClick(ActionEvent event1){
        int colorCount =0;
        int positionX = 0;
        int positionY = 0;
        int count = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if(grid[x][y].equals(event1.getSource())) {
                    positionX = x;
                    positionY = y;
                }
            }
        }
        if(bombs[positionX][positionY] == 1){
            lose.setVisible(true);
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[x].length; y++) {
                    if(bombs[x][y] == 1) {
                        grid[x][y].setText("Bomb");
                    }
                }
            }
        }
        else {
            if(minesweeper.checkBombs(positionX, positionY) != 0) {
                grid[positionX][positionY].setText(minesweeper.checkBombs(positionX, positionY) + "");
                grid[positionX][positionY].setStyle("-fx-background-color: BROWN");
            }
            else {
                for (int x = 0; x < bombs.length; x++) {
                    for (int y = 0; y < bombs[x].length; y++) {
                        if (minesweeper.showBombs(positionX, positionY)[x][y] < 9 && minesweeper.showBombs(positionX, positionY)[x][y] != 0) {
                            grid[x][y].setText(minesweeper.checkBombs(x, y) + "");
                            grid[x][y].setStyle("-fx-background-color: BROWN");
                        }
                        else if (minesweeper.showBombs(positionX, positionY)[x][y] == 9 || minesweeper.showBombs(positionX, positionY)[x][y] == 0) {
                            grid[x][y].setText(" ");
                            grid[x][y].setStyle("-fx-background-color: BROWN");
                        }
                    }
                }
            }
        }
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if(grid[x][y].getText().equals("")){
                    count++;
                }
            }
        }
        if(count == totalMines) {
            win.setVisible(true);
        }
    }

    private void processReset(ActionEvent event2){
        totalMines = Integer.parseInt(numBombs.getText());
        minesweeper.resetMines();
        minesweeper.layMines(totalMines);
        for (int x = 0; x < minesweeper.getGrid().length; x++) {
            for (int y = 0; y < minesweeper.getGrid()[x].length; y++) {
                bombs[x][y] = minesweeper.getGrid()[x][y];
            }
        }

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y].setText("");
                grid[x][y].setVisible(true);
                grid[x][y].setStyle("-fx-background-color: GREENYELLOW");
            }
        }
        newGame.setMinHeight(5);
        newGame.setMinWidth(10);
        newGame.setFont(f2);
        win.setVisible(false);
        lose.setVisible(false);
    }
    private void processReturn(ActionEvent event3){
        newGame.setVisible(true);
        totalMines = Integer.parseInt(numBombs.getText());
        minesweeper.layMines(totalMines);
        newGame.setVisible(true);
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y].setVisible(true);
            }
        }
    }
}
