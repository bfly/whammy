import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Khalid Muteb on 11/28/2016.
 */
public class WhammyGui extends JFrame {
    static char nl = '\n';
    public WhammyGui()  throws IOException {
        WhammyGame game = new WhammyGame();

        this.setTitle("Whammy!");

        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout());

        JButton newGameButton = new JButton();
        newGameButton.setText("New Game");

        JLabel playerNameLabel = new JLabel("Player Name:");
        JTextField playerName = new JTextField(20);
        playerName.setEnabled(false);
        JButton addPlayerButton = new JButton("Add Player");
        addPlayerButton.setEnabled(false);

        JTextArea gameResult = new JTextArea(14,40);
        gameResult.setFont(new Font("Serif", Font.BOLD, 16));
        gameResult.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(gameResult);
        JButton playButton = new JButton("Play");
        playButton.setEnabled(false);

        // Start a new game
        newGameButton.addActionListener(e -> {
            newGameButton.setEnabled(false);
            addPlayerButton.setEnabled(true);
            playerName.setEnabled(true);
            gameResult.setText("NEW GAME!" + nl);
        });

        // add a new player
        addPlayerButton.addActionListener(e -> {
            gameResult.append("Added player: " + game.addPlayer(playerName.getText()) + nl);
            if (game.getPlayerCount() >= 2)
                playButton.setEnabled(true);    //enable play game button after 2nd player added
            playerName.setText(null);
        });

        // begin playing game
        playButton.addActionListener(e -> {
            gameResult.append(game.playGame());
            newGameButton.setEnabled(true);
            playerName.setEnabled(false);
            addPlayerButton.setEnabled(false);
            playButton.setEnabled(false);
        });

        panel.add(newGameButton);
        panel.add(playerNameLabel);
        panel.add(playerName);
        panel.add(addPlayerButton);

        panel.add(scrollPane);
        panel.add(playButton);

        this.add(panel);

        this.pack();
    }
}
