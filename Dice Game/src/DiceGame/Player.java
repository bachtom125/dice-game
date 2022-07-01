package DiceGame;

import java.util.*;

public class Player {
    protected int id;
    protected Dice myDice;
    protected boolean win = false;
    protected String name;
    protected int currentScore = 0;

    // constructor
    public Player(String name, int id) {
        setName(name);
        setId(id);
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dice getMyDice() {
        return myDice;
    }

    public void setMyDice(Dice myDice) {
        this.myDice = myDice;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isWin() {
        if (getCurrentScore() == 21)
            setWin(true);

        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    // roll and update current point
    public int roll() { // working
        int roll = getMyDice().roll();

        setCurrentScore(getCurrentScore() + roll);
        if (getCurrentScore() > 21) {
            setCurrentScore(0);
        }

        return roll;
    }

}
