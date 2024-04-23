package Models;

public class Enum {
    public enum GameStatus {
        IN_PROGRESS,ENDED,DRAW;
    }
    public enum PlayerType {
        HUMAN,BOT;
    }
    public enum CellStatus {
        EMPTY, FILLED,BLOCKED;
    }
    public enum DifficultyLevel {
        EASY, MEDIUM,HARD;
    }
}
