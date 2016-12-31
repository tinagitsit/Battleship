/** Battleship board
 *  X = hit, o = miss, + = ship location
 */

public class Board {
    private String[][] board;
    private int rows;
    private int columns;

    public Board(int rows, int columns) {
        /* set up board with specified rows and columns */
		this.rows = rows;
		this.columns = columns;
        board = new String[rows][columns];
        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                board[row][column] = ".";
            }
        }
    }

    public void setUpBoard(Coordinate start, int length) {
        /* set up the board with the specified target ship piece */
        for(int i = 0; i < length; i++) {
             board[start.getX()][start.getY()+i] = "+";
        }
    }

    public void displayBoard() {
        /* display the board on the screen */
        System.out.println("Opponent's board");
		System.out.print("   ");
        for(int column = 0; column < columns; column++) {
			System.out.format("%d ", column+1);
        }
        System.out.println();

        for(int row = 0; row < rows; row++) {
			System.out.format("%2d ", row+1);
            for(int column = 0; column < columns; column++) {
                if(!board[row][column].equals("+")) {
                    System.out.format("%s ", board[row][column]);
                }
                else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }

    }

	public void displayBoardWithShips() {
        /* display the board with ships on the screen */
        System.out.println("Your board");
		System.out.print("   ");
        for(int column = 0; column < columns; column++) {
			System.out.format("%d ", column+1);
        }
        System.out.println();

        for(int row = 0; row < rows; row++) {
			System.out.format("%2d ", row+1);
            for(int column = 0; column < columns; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }

    }


    public void updateBoard(Coordinate target) {
        /* update the board with the move from the player */
		int x = target.getX();
		int y = target.getY();
		if(board[x][y].equals("+")) {
			board[x][y] = "X";
		}
		else {
			board[x][y] = "o";
		}
    }

    public boolean hit(Coordinate target) {
        /* check if the player has hit a ship at the target coordinate */
        boolean checkHit = board[target.getX()][target.getY()].equals("+");
		updateBoard(target);
    	return checkHit;
	}


    public static void main(String[] args) {
        Board test = new Board(10, 10);
        test.displayBoard();
		
		System.out.println();
		test.setUpBoard(new Coordinate(0,0), 3);
		test.setUpBoard(new Coordinate(5,2), 5);
		test.displayBoardWithShips();

		System.out.println(test.hit(new Coordinate(0,0)));
		test.displayBoard();

		System.out.println(test.hit(new Coordinate(8,9)));
		test.displayBoard();

		System.out.println();
		test.displayBoardWithShips();

    }
}
