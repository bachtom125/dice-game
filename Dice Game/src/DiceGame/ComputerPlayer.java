package DiceGame;

public class ComputerPlayer extends Player {
    private String morne[] = new String[4];

    // constructor
    public ComputerPlayer(String name, int id) {
        super(name, id);
        setMorne();
    }

    // getters and setters
    public String getMorne() {
        return morne[getId()];
    }

    public void setMorne() {
        this.morne[0] = "I'm lost, I'm such a bad computer!";
        this.morne[1] = "I can't even win a dice game, I should be scrapped for parts";
        this.morne[2] = "Well, at least I don't have emotions like humans";
        this.morne[3] = "I'm heartbroken, oh wait, I don't have a heart!";
    }

    // when computer loses
    public void showSadness() {
        if (!isWin()) {
            System.out.println("Computer " + (getId() + 1) + " says: " + getMorne());
        }
    }
}
