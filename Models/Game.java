package Models;

import Exceptions.InvalidMoveException;
import strategies.WinningAlgo;

import java.util.*;


public class Game {
    public Board board;
    public List<Player> listOfPlayers;
    public int nextPlayerMoveIndex;
    public Player winner;
    public List<Move> moves;
    public Enum.GameStatus gameStatus;

    public Game(int size,List<Player> players) {
        this.board = new Board(size);
        this.listOfPlayers = players;
        nextPlayerMoveIndex = 0;
        winner = null;
        moves = new ArrayList<>();
        gameStatus = Enum.GameStatus.IN_PROGRESS;
    }

    public Enum.GameStatus getGameState() {
        return gameStatus;
    }

    public void setGameState(Enum.GameStatus gameState) {
        this.gameStatus = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void printBoard() {
        this.board.printBoard();
    }


    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (row < 0 || row >= board.getSize() || col < 0  || col >= board.getSize()) {
            return false;
        }

        return board.getBoard().get(row).get(col).getCellState().equals(Enum.CellStatus.EMPTY);
    }

    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = listOfPlayers.get(nextPlayerMoveIndex);

        System.out.println("It is " + currentPlayer.getName() + "'s move.");

        //Move that currentPlayer wants to make
        Move move = currentPlayer.makeMove(board);

        //Game will validate the move before executing.
        if (!validateMove(move)) {
            //throw an exception
            throw new InvalidMoveException("Invalid move made by " + currentPlayer.getName());
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setCellState(Enum.CellStatus.FILLED);

        Move finalMove = new Move(cellToChange, currentPlayer);
        moves.add(finalMove);
        nextPlayerMoveIndex = (nextPlayerMoveIndex + 1) % listOfPlayers.size();

        //Check if the current move is the winning move or not.
        if (WinningAlgo.checkWinner(board, finalMove)) {
            gameStatus = Enum.GameStatus.ENDED;
            winner = currentPlayer;
        }
    }



}