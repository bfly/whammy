import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Khalid Muteb on 11/1/2016.
 */
public class WhammyGame {
    private ArrayList<Player> players;
    private Board board;
    private Scanner scanner;

    public WhammyGame() {
        board = new Board();
        players = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void playGame() {
        System.out.print("Enter number of players:");
        int numberOfPlayers = scanner.nextInt();
        String name;
        //
        // Load players
        //
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Enter name of player number " + (i + 1) + " ");
            name = scanner.next();
            players.add(new Player(name));
        }
        int winnings;
        boolean winner = false;
        //
        // loop through players until one player exceed $10,000
        //
        while (!winner) {
            for (Player p: players) {
                winnings = p.takeTurn(board);
                if (winnings >= 10000) {
                    System.out.println(p.getName() + " won with $" + p.getMoney() + " !!!");
                    winner = true;
                    break;
                }
            }
        }
    }
}
