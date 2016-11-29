/**
 * Created by Khalid Muteb on 11/16/2016
 */
public class SpecialCell extends Cell {
    private int multiplier;

    public SpecialCell(int value, int multiplier) {
        super(value);
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public int getValue() {
        return super.getValue() * multiplier;
    }

    @Override
    public String toString() {
        return "The value normally would be: $" +
                super.getValue() +
                " but because of the multiplier " +
                this.multiplier +
                " the value to be added is $"  +
                this.getValue();
    }
}