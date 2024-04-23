import Controller.GameController;
import Exceptions.InvalidMoveException;
import Models.*;
import Models.Enum;

import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();

        int dimension = 3;
        List<Player> players = List.of(
                new Player("Garvit", new Symbol('X'), Enum.PlayerType.HUMAN),
                new Bot("Bot", new Symbol('O'), Enum.PlayerType.BOT, Enum.DifficultyLevel.EASY)
        );

        Game game = gameController.startGame(dimension, players);


        while (game.getGameState().equals(Enum.GameStatus.IN_PROGRESS)) {

            gameController.printBoard(game);

            //2. Player's turn
            gameController.makeMove(game);
        }

        if (!gameController.checkState(game).equals(Enum.GameStatus.ENDED)) {
            game.setGameState(Enum.GameStatus.DRAW);
            System.out.println("Game DRAW");
        } else {
            gameController.printBoard(game);
            System.out.println("Player " + gameController.getWinner(game).getName() + " is the winner");
        }
    }
}
