package DiceGame;

import DiceGame.Player;
import DiceGame.Dice;
import DiceGame.Ref;
import java.util.*;

public class Testing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Dice dices[] = new Dice[4];
        for (int i = 0; i < 4; i++) {
            dices[i] = new Dice(i + 1);
        }

        Player players[] = new Player[4];

        // input player's info
        System.out.print("How many players are there: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter player number " + i + "'s name: ");
            String name = scanner.nextLine();
            Player player = new Player(name, i - 1);
            players[i - 1] = player;
        }

        // fill the remaining players with bots
        for (int i = numPlayers; i < 4; i++) {
            ComputerPlayer com = new ComputerPlayer("", i);
            players[i] = com;
        }
        System.out.println();

        new Ref(players, dices);
        scanner.close();
    }
}
