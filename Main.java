public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();

        player1.placeShip(new Coordinate(5,2), 3);
        player1.placeShip(new Coordinate(3,5), 2);
        player1.placeShip(new Coordinate(8,0), 4);
        player1.getBoard().displayBoardWithShips();

        player2.placeShip(new Coordinate(0,0), 3);
        player2.placeShip(new Coordinate(9,5), 2);
        player2.placeShip(new Coordinate(5,5), 4);
        player2.getBoard().displayBoardWithShips();

        System.out.println(player1.hit(player2.getBoard(), new Coordinate(0,1)));
        player1.getBoard().displayBoardWithShips();
        player2.getBoard().displayBoard();
    }
}
