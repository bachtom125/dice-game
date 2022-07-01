package DiceGame;

import java.util.*;

public class Dice {
    private int faultySide;
    private int[] rollOptions = new int[25];

    // getters and setters
    public int getFaultySide() {
        return faultySide;
    }

    public void setFaultySide(int faultySide) {
        this.faultySide = faultySide;
    }

    public void setRollOptions(int[] rollOptions) {
        this.rollOptions = rollOptions;
    }

    // constructor
    public Dice(int faultySide) {
        setFaultySide(faultySide);
        int[] rollNumbers = new int[25];

        int from = 0, to = 0;
        for (int i = 1; i <= 6; i++) {
            from = to;
            to += 4;
            if (i == getFaultySide())
                to++;
            Arrays.fill(rollNumbers, from, to, i);
        }
        setRollOptions(rollNumbers);
    }

    // roll a random number
    public int roll() {
        Random rand = new Random();
        int index = rand.nextInt(25);
        int roll = rollOptions[index];

        return roll;
    }
}
