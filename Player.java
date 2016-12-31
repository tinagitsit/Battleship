public class Player {
    private Board board;

    public Player() {
        board = new Board(10, 10);
    }

    public Board getBoard() {
        return board;
    }

    public void placeShip(Coordinate start, int length) {
        /* place the ship at the specified target coordinate */
        board.setUpBoard(start, length);
    }

    public boolean hit(Board b, Coordinate target) {
        /* player hits specified target coordinate on opponent's board; return True if hit */
        return b.hit(target);
    }
}