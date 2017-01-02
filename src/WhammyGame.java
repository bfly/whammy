import java.util.ArrayList;

/**
 * Created by Khalid Muteb on 11/1/2016.
 */
public class WhammyGame {
    private ArrayList<Player> players;
    private Board board;
    static char nl = '\n';

    public WhammyGame() {       // constructor
        board = new Board();
        players = new ArrayList<>();
    }

    public String addPlayer(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
        return player.toString();
    }

    public int getPlayerCount() {
        return players.size();
    }

    public String playGame() {
        int winnings;
        boolean winner = false;
        String gameResults = "Let's Play" + nl;
/*
 *      loop through players until one player exceeds $10,000
*/
        while (!winner) {
            for (Player p : players) {
                winnings = p.takeTurn(board);
                gameResults += "Player: " + p.getName() + " scored " + p.getMoney() + nl;
                if (winnings >= 10000) {
                    gameResults += "Game over!!" + nl;
                    gameResults += nl;
                    for (Player p2: players) {
                        if(p.equals(p2)) {          // winner
                            gameResults += p2.getName() + " won with $" + p2.getMoney() + " !!!" + nl;
                        } else {                    // also rans
                            gameResults += "Player: " + p2.getName() + " scored " + p2.getMoney() + nl;
                        }
                        gameResults += nl;
                    }
                    players = new ArrayList<>();
                    return gameResults;
                }
            }
        }
        return gameResults;
    }
}
