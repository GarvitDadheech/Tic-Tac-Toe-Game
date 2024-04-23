package Controller;

import Exceptions.InvalidMoveException;
import Models.Game;
import Models.Player;
import Models.Enum;
import java.util.List;

public class GameController {
    public Game startGame(int size, List<Player> players) {
        
        return new Game(size,players);
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public Enum.GameStatus checkState(Game game) {
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

}