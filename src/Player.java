import static javax.swing.JOptionPane.*;
/**
 * Created by Khalid Muteb on 11/1/2016.
 * Modified by Khalid Muteb on 11/29/2016.
 */
public class Player {
    final int Whammy = -1;
    Cell cell;

    private String name;
    private int money;

    public Player(String name) {
        this.name = name;
        this.money = 0;
    }

    public void postMoney(int amount) {
        // Accumulate winnings until a Whammy wipes them out
        if (amount == Whammy) {
            money = 0;
        } else {
            money += amount;
        }
    }

    public int takeTurn(Board board) {
/*
 *      loop until a player spins a Whammy or passes to next player
*/
        while (true) {
            int result = showConfirmDialog(null, name + " has $" + money + "\nSpin?", name, YES_NO_OPTION);
            if (result == NO_OPTION) {
                return money;
            }
            cell = board.spin();
            postMoney(cell.getValue());
            if (cell.getValue() == Whammy) {
                showMessageDialog(null, "WHAMMY!", "Turn Over", INFORMATION_MESSAGE);
                return 0;
            } else {
                showMessageDialog(null, "Hit $" + cell.getValue(), "Money Cell!", INFORMATION_MESSAGE);
            }
        }
    }

    @Override
    public String toString() {
        return name + " has $" + money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
