/**
 * Created by Khalid Muteb on 11/1/2016.
 */
public class Cell {
    private int value;

    public Cell(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value == -1? "Whammy": "$" + String.valueOf(value);
    }
}
