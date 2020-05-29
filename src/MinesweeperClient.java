/*public class MinesweeperClient {
    public static void main(String[] args) {
        int[][] grid = new int[20][20];

        Minesweeper minesweeper = new Minesweeper();

        minesweeper.layMines();
        grid = minesweeper.getGrid();
        for (int x = 0; x < grid.length; x++) {
            System.out.println("");
            for (int y = 0; y < grid[x].length; y++) {
                System.out.print(", " + grid[x][y]);
            }

        }
        System.out.print("\n" + minesweeper.getCount());
        System.out.print("\n" + minesweeper.checkBombs(10,10));
        minesweeper.resetMines();
        minesweeper.layMines();
        grid = minesweeper.getGrid();
        for (int x = 0; x < grid.length; x++) {
            System.out.println("");
            for (int y = 0; y < grid[x].length; y++) {
                System.out.print(", " + grid[x][y]);
            }

        }
        System.out.print("\n");
        if(minesweeper.checkBombs(10,10) == 0){
            int[][] show = minesweeper.showBombs(1, 1);
            for (int x = 0; x < grid.length; x++) {
                System.out.print("\n");
                for (int y = 0; y < grid[x].length; y++) {
                    System.out.print(", " + show[x][y]);
                }
            }
        }
    }
}
*/