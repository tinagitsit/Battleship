import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static Coordinate parseInputToCoordinate(String line) {
        Coordinate coordinate;
        Pattern pattern = Pattern.compile("(^[0-9]*)([^0-9]*)([0-9]*$)");
        Matcher xAndY = pattern.matcher(line);
        if(xAndY.find()) {
            int x = Integer.parseInt(xAndY.group(1)) - 1;
            int y = Integer.parseInt(xAndY.group(3)) - 1;
            coordinate = new Coordinate(x,y);
            return coordinate;
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();

        player1.placeShip(new Coordinate(5,2), 3);
        //player1.placeShip(new Coordinate(3,5), 2);
        //player1.placeShip(new Coordinate(8,0), 4);
        System.out.print("Player 1: ");
        player1.getBoard().displayBoardWithShips();

        player2.placeShip(new Coordinate(0,0), 3);
        //player2.placeShip(new Coordinate(9,5), 2);
        //player2.placeShip(new Coordinate(5,5), 4);
        System.out.print("Player 2: ");
        player2.getBoard().displayBoardWithShips();

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println();
            System.out.print("Enter a coordinate to hit (Player 1): ");
            String target = scanner.nextLine();

            Coordinate hit = parseInputToCoordinate(target);
            if(hit != null) {
                player1.hit(player2.getBoard(), hit);
            }

            player1.getBoard().displayBoardWithShips();
            player2.getBoard().displayBoard();
            System.out.println();

            if(player2.getBoard().gameOver()) {
                System.out.println("Game over. Player 1 won.");
                break;
            }

            System.out.print("Enter a coordinate to hit (Player 2): ");
            String target2 = scanner.nextLine();

            Coordinate hit2 = parseInputToCoordinate(target2);
            if(hit2 != null) {
                player2.hit(player1.getBoard(), hit2);
            }

            player2.getBoard().displayBoardWithShips();
            player1.getBoard().displayBoard();

            if(player1.getBoard().gameOver()) {
                System.out.println("Game over. Player 2 won.");
                break;
            }
        }

    }
}
