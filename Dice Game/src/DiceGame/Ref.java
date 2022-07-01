package DiceGame;

import java.util.Random;
import javax.sound.sampled.BooleanControl;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Ref {
    private Player players[] = new Player[4];
    private Dice dices[] = new Dice[4];
    private boolean hasWinner = false;
    private Player winner;

    // getters and setters
    public boolean isHasWinner() {
        return hasWinner;
    }

    public void setHasWinner(boolean hasWinner) {
        this.hasWinner = hasWinner;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    // constructor
    public Ref(Player[] players, Dice[] dices) {
        this.players = players;
        this.dices = dices;
        startGame();
        System.out.println();
        showResult();
    }

    // play game
    public void startGame() {
        System.out.println("Let's play!");
        int turnCnt = 1;
        while (!hasWinner) {
            System.out.println("Turn number " + turnCnt + ":");
            for (Player curPlayer : players) {

                // player gets a random dice
                Random rand = new Random();
                int diceIndex = rand.nextInt(4);
                curPlayer.setMyDice(dices[diceIndex]);

                // roll
                int roll = curPlayer.roll();

                if (curPlayer instanceof ComputerPlayer) {
                    System.out.println("Computer " + (curPlayer.getId() + 1) + " rolled a " + roll);
                } else {
                    System.out.println("Player " + curPlayer.getName() + " rolled a " + roll);
                }

                // check if player wins
                if (curPlayer.isWin()) {
                    setHasWinner(true);
                    setWinner(curPlayer);
                    break;
                }
            }
            turnCnt++;
            System.out.println();
        }
    }

    // show result when there's a winner
    public void showResult() {
        Player winner = getWinner();
        if (winner instanceof ComputerPlayer) {
            System.out.println("Computer " + (winner.getId() + 1) + " has won the game!");
        } else {
            System.out.println("Congrats! Player " + winner.getName() + " has won the game!");
        }
        System.out.println();

        for (Player curPlayer : players) {
            if (curPlayer instanceof ComputerPlayer && !curPlayer.equals(winner)) {
                ((ComputerPlayer) curPlayer).showSadness();
                System.out.println();
            }
        }
    }
}
