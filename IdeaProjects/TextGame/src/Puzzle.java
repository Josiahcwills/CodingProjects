import java.util.ArrayList;

public class Puzzle {
    private int puzzleID;
    private String puzzleQ;
    private String puzzleA;

    public Puzzle() {
        this.puzzleID = puzzleID;
        this.puzzleQ = puzzleQ;
        this.puzzleA = puzzleA;
    }

    public int getPuzzleID() {
        return puzzleID;
    }

    public void setPuzzleID(int puzzleID) {
        this.puzzleID = puzzleID;
    }

    public String getPuzzleQ() {
        return puzzleQ;
    }

    public void setPuzzleQ(String puzzleQ) {
        this.puzzleQ = puzzleQ;
    }

    public String getPuzzleA() {
        return puzzleA;
    }

    public void setPuzzleA(String puzzleA) {
        this.puzzleA = puzzleA;
    }


    @Override
    public String toString() {
        return "Puzzle{" +
                "puzzleID=" + puzzleID +
                ", puzzleQ='" + puzzleQ + '\'' +
                ", puzzleA='" + puzzleA + '\'' +
                '}';
    }
}
