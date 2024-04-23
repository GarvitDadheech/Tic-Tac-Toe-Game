package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int sizeOfBoard;
    List<List<Cell>> board;

    public Board(int size) {
        board = new ArrayList<>();
        sizeOfBoard = size;
        for (int i = 0; i < size; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                board.get(i).add(new Cell(i, j));
            }
        }
    }

    public void printBoard() {
        for (List<Cell> row : board) {
            for (Cell cell : row) {
                if (cell.getCellState().equals(Enum.CellStatus.EMPTY)) {
                    System.out.print("| -- |");
                } else {
                    System.out.print("| " + cell.getPlayer().getSymbol().getaChar() + " |");
                }
            }
            System.out.println();
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public int getSize() {
        return sizeOfBoard;
    }
    
}
