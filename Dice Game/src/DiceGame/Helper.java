package DiceGame;

import java.util.*;

public class Helper {
    private int[] rollOptions = new int[25];

    public void setRollOptions() {
        int from = 0, to = 0;
        for (int i = 1; i <= 6; i++) {
            from = to;
            to += 4;
            if (i == 1)
                to++;
            Arrays.fill(rollOptions, from, to, i);
        }
        for (int i : rollOptions)
            System.out.println(i);
    }

    public static void main(String[] args) {
        Helper temp = new Helper();
        temp.setRollOptions();
    }
}
