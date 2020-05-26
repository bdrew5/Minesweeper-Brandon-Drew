public class Minesweeper {
    int[][] grid;
    public Minesweeper(){
        grid = new int[20][20];
    }
    public int[][] start() {
        int count = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if((int)Math.random() *10 ==1 && count<=30){
                    count++;
                    grid[x][y] = 1;
                }
                else
                    grid[x][y] = 0;
            }
        }
        return grid;
    }
}
