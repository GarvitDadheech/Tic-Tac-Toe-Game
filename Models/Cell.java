package Models;

public class Cell {
    int row;
    int column;
    Player player;
    Enum.CellStatus status;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.status = Enum.CellStatus.EMPTY;
    }

    public Enum.CellStatus getCellState() {
        return status;
    }

    public Player getPlayer() {
        return player;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return column;
    }

    public void setCellState(Enum.CellStatus cellState) {
        this.status = cellState;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

}
