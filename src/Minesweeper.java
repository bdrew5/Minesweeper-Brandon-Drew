import java.util.ArrayList;
import java.util.Random;

public class Minesweeper {
    Random ran = new Random();
    private int[][] grid;
    private int count = 0;
    int[][] all = new int[20][20];

    public Minesweeper() {
        grid = new int[20][20];
    }

    public void resetMines() {
        count = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y] = 0;
            }
        }
    }

    public void layMines() {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (ran.nextInt(15) == 1 && count < 30) {
                    count++;
                    grid[x][y] = 1;
                } else
                    grid[x][y] = 0;
            }
        }
        if (count != 30) {
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[x].length; y++) {
                    if (ran.nextInt(15) == 1 && count < 30 && grid[x][y] != 1) {
                        count++;
                        grid[x][y] = 1;
                    }
                }
            }
        }

    }

    public int[][] getGrid() {
        return grid;
    }

    public int getCount() {
        return count;
    }

    public int checkBombs(int positionX, int positionY) {
        int count = 0;
        if (positionX != 0 && positionX != grid.length - 1 && positionY != 0 && positionY != grid.length - 1) {
            for (int i = positionX - 1; i < positionX + 2; i++) {
                if (grid[i][positionY - 1] == 1) {
                    count++;
                }
                if (grid[i][positionY] == 1) {
                    count++;
                }
                if (grid[i][positionY + 1] == 1) {
                    count++;
                }
            }
        } else if (positionX == 0 && positionY != 0 && positionY != grid.length - 1) {
            for (int i = positionX; i < positionX + 2; i++) {
                if (grid[i][positionY - 1] == 1) {
                    count++;
                }
                if (grid[i][positionY] == 1) {
                    count++;
                }
                if (grid[i][positionY + 1] == 1) {
                    count++;
                }
            }
        } else if (positionX == 0 && positionY == 0) {
            for (int i = positionX; i < positionX + 2; i++) {
                if (grid[i][positionY] == 1) {
                    count++;
                }
                if (grid[i][positionY + 1] == 1) {
                    count++;
                }
            }
        } else if (positionX == 0 && positionY == grid.length - 1) {
            for (int i = positionX; i < positionX + 2; i++) {
                if (grid[i][positionY - 1] == 1) {
                    count++;
                }
                if (grid[i][positionY] == 1) {
                    count++;
                }
            }
        } else if (positionX == grid.length - 1 && positionY != 0 && positionY != grid.length - 1) {
            for (int i = positionX - 1; i < positionX + 1; i++) {
                if (grid[i][positionY - 1] == 1) {
                    count++;
                }
                if (grid[i][positionY] == 1) {
                    count++;
                }
                if (grid[i][positionY + 1] == 1) {
                    count++;
                }
            }
        } else if (positionX == grid.length - 1 && positionY == 0) {
            for (int i = positionX - 1; i < positionX + 1; i++) {
                if (grid[i][positionY] == 1) {
                    count++;
                }
                if (grid[i][positionY + 1] == 1) {
                    count++;
                }
            }
        } else if (positionX == grid.length - 1 && positionY == grid.length - 1) {
            for (int i = positionX - 1; i < positionX + 1; i++) {
                if (grid[i][positionY - 1] == 1) {
                    count++;
                }
                if (grid[i][positionY] == 1) {
                    count++;
                }
            }
        } else if (positionX != grid.length - 1 && positionX != 0 && positionY == grid.length - 1) {
            for (int i = positionX - 1; i < positionX + 2; i++) {
                if (grid[i][positionY - 1] == 1) {
                    count++;
                }
                if (grid[i][positionY] == 1) {
                    count++;
                }
            }
        } else if (positionX != grid.length - 1 && positionX != 0 && positionY == 0) {
            for (int i = positionX - 1; i < positionX + 2; i++) {
                if (grid[i][positionY] == 1) {
                    count++;
                }
                if (grid[i][positionY] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
    public void checkAllBombs(){
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                all[x][y] = 0;
            }
        }
    }

   public int[][] showBombs(int positionX, int positionY) {
        int[][] section = new int[20][20];
        for (int x = 0; x < section.length; x++) {
            for (int y = 0; y < section[x].length; y++) {
                section[x][y] = 10;
            }
        }
        section[positionX][positionY] = 9;
        for (int i = positionX - 1; i < positionX + 2; i++) {
            section[i][positionY - 1] = all[i][positionY - 1];
            section[i][positionY + 1] = all[i][positionY + 1];
            if (i != positionX)
                section[i][positionY] = checkBombs(i, positionY);
        }
       return section;
    }
}