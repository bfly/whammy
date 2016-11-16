import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Khalid Muteb on 11/1/2016.
 */
public class Board {
    private ArrayList<Cell> board;
    private Random randomGenerator;
    private final int[] amounts = {1000,1500,750,600,500,100,250,750,600,1500,-1,500,1000,1500,750,-1,500,1500};

    public Board() {
        board = new ArrayList<>();
        //
        // Initialize game board with amounts from previous lab
        //
        for (int i =0; i<18;i++) {
            board.add(new Cell(amounts[i]));
        }
        randomGenerator = new Random();
    }

    public int spin() {
        //
        // randomly select a cell from the board
        //
        int cell = randomGenerator.nextInt(18);
        return board.get(cell).getValue();
    }
}
