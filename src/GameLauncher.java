import java.io.IOException;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by Khalid Muteb on 11/1/2016.
 * Modified by Khalid Muteb on 11/29/2016.
 */
public class GameLauncher {

    public static void main(String[] args) throws IOException {
        WhammyGui game = new WhammyGui();

        game.setDefaultCloseOperation(EXIT_ON_CLOSE);

        game.setSize(600,400);
        game.setVisible(true);
    }
}
