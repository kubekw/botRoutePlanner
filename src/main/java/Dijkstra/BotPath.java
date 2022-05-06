package Dijkstra;

import java.util.List;

public class BotPath {
    private int movesNumber;
    private double totalTime;
    private List<String> movesList;

    public BotPath(int movesNumber, double totalTime, List<String> movesList) {
        this.movesNumber = movesNumber;
        this.totalTime = totalTime;
        this.movesList = movesList;
    }

    public int getMovesNumber() {
        return movesNumber;
    }

    public void setMovesNumber(int movesNumber) {
        this.movesNumber = movesNumber;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public List<String> getMovesList() {
        return movesList;
    }

    public void setMovesList(List<String> movesList) {
        this.movesList = movesList;
    }
}
