package Models;

import java.util.List;

public class Bot extends Player {
    
    Enum.DifficultyLevel difficulty;


    public Bot(String name, Symbol symbol, Enum.PlayerType playerType, Enum.DifficultyLevel difficulty) {
        super(name, symbol, playerType);
        this.difficulty = difficulty;
    }

    @Override
    public Move makeMove(Board board) {
        //Find the first empty cell and make the move there.
        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getCellState().equals(Enum.CellStatus.EMPTY)) {
                    return new Move(cell, this);
                }
            }
        }
        return null;
    }
    
}
