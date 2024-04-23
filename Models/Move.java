package Models;

public class Move {
    Cell cell;
    Player player;

    public Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }

    public Cell getCell() {
        return cell;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public Player getPlayer() {
        return player;
    }

}
