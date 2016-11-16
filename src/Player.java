import java.util.Scanner;

/**
 * Created by Khalid Muteb on 11/1/2016.
 */
public class Player {
    final int Whammy = -1;
    Scanner scanner = new Scanner(System.in);

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
        int spin;
        System.out.println();
        System.out.println(this.name + "\'s turn");
        System.out.println();
        //
        // loop until a player spins a Whammy or passes to next player
        //
        while (true) {
            System.out.print(this.toString());
            System.out.print("Spin (Y/N) ");
            if (scanner.next().equalsIgnoreCase("Y")) {
                spin = board.spin();
                postMoney(spin);
                if (spin == Whammy) {
                    System.out.println("Spun Whammy!");
                    return 0;
                } else {
                    System.out.println("Spun $" + spin);
                }
            } else {
                return money;
            }
        }
    }

    @Override
    public String toString() {
        return name + ": $" + money + " ";
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
