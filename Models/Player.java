package Models;

import java.util.Scanner;

public class Player {
    String name;
    Symbol symbol;
    Enum.PlayerType playerType;

    Scanner scanner = new Scanner(System.in);
    public Player(String name, Symbol symbol, Enum.PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public Move makeMove(Board board) {
        //Ask the user where they want to place the symbol.

        System.out.println("Please enter the row number where you want to make a move ?");
        int row = scanner.nextInt();

        System.out.println("Please enter the col number where you want to make a move ?");
        int col = scanner.nextInt();

        return new Move(new Cell(row, col), this);
    }
    
}
