import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Khalid Muteb on 11/1/2016.
 */
public class Board {
    private int numberOfCells = 18;
    private ArrayList<Cell> board = new ArrayList<>(numberOfCells);;
    private Random randomGenerator = new Random();;
    private Scanner scanner;
    private File file;
    private Cell cell;

    public Board() {
        String line;
        int value;
        int multiplier;
        String[] fields = new String[2];;
        //
        // Initialize game board with amounts from CellValues.txt
        //
        file = new File("CellValues.txt");
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < numberOfCells; i++) {
            line = scanner.nextLine();
            fields = line.split(" ");
            value = getNumber(fields[0]);       // cell value
            if (fields.length - 1 == 0) {       // no multiplier
                cell = new Cell(value);
            } else {                            // multiplier present
                multiplier = getNumber(fields[1]);
                cell = new SpecialCell(value, multiplier);
            }
            board.add(cell);        // cell or specialCell to board
        }
    }
    private int getNumber(String line) {
        try {
            return Integer.parseInt(line);
        } catch (Exception e) {
            System.out.println("Oops encountered an input mismatch type error: " + e);
            return 0;
        }
    }

    public Cell spin() {
        //
        // randomly select a cell from the board
        //
        cell = board.get(randomGenerator.nextInt(numberOfCells));
        return cell;
    }
}
