import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Khalid Muteb on 11/1/2016.
 */
public class WhammyGame {
    private ArrayList<Player> players;
    private Board board;
    private Scanner scanner;

    public WhammyGame() {       // constructor
        board = new Board();
        players = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void playGame() throws IOException {
        System.out.print("Enter number of players: ");
        String line = scanner.nextLine();
        int numberOfPlayers = 0;
        try {
            numberOfPlayers = Integer.parseInt(line);
        } catch (Exception e) {
            System.out.println("Oops encountered an input mismatch type error: " + e);
        }
        String name;
        //
        // Load players
        //
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Enter name of player number: " + (i + 1) + " ");
            name = scanner.nextLine();
            players.add(new Player(name));
        }
        int winnings;
        boolean winner = false;
        //
        // loop through players until one player exceed $10,000
        //
        while (!winner) {
            for (Player p : players) {
                winnings = p.takeTurn(board);
                if (winnings >= 10000) {
                    System.out.println(p.getName() + " won with $" + p.getMoney() + " !!!");
                    winner = true;
                    break;
                }
            }
        }
        //
        // outout GameResults
        //
        try {
            FileWriter writer = new FileWriter("GameResults.txt", false);
            BufferedWriter bw = new BufferedWriter(writer);

            bw.write("Number of players is " + numberOfPlayers);
            bw.newLine();
            for (Player p : players) {
                bw.write(p.toString());
                bw.newLine();
            }
            bw.close();

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
