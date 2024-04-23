package strategies;
import java.util.HashMap;
import Models.Board;
import Models.Move;
public class WinningAlgo {

        static HashMap<Integer, HashMap<Character, Integer>> rowMaps = new HashMap<>();
        static HashMap<Integer, HashMap<Character, Integer>> colMaps = new HashMap<>();
        static HashMap<Character, Integer> leftDiagonalMap = new HashMap<>();
        static HashMap<Character, Integer> rightDiagonalMap = new HashMap<>();

        public static boolean checkWinner(Board board, Move move) {
            int row = move.getCell().getRow();
            int col = move.getCell().getCol();
            Character character = move.getPlayer().getSymbol().getaChar();

            if (!rowMaps.containsKey(row)) {
                rowMaps.put(row, new HashMap<>());
            }
            HashMap<Character, Integer> currRowMap = rowMaps.get(row);

            if (!currRowMap.containsKey(character)) {
                currRowMap.put(character, 1);
            } else {
                currRowMap.put(character, currRowMap.get(character) + 1);
            }

            if (currRowMap.get(character) == board.getSize()) {
                return true;
            }


            if (!colMaps.containsKey(col)) {
                colMaps.put(col, new HashMap<>());
            }
            HashMap<Character, Integer> currColMap = colMaps.get(col);

            if (!currColMap.containsKey(character)) {
                currColMap.put(character, 1);
            } else {
                currColMap.put(character, currColMap.get(character) + 1);
            }

            if (currColMap.get(character) == board.getSize()) {
                return true;
            }

            if (row == col) {
                if (!leftDiagonalMap.containsKey(character)) {
                    leftDiagonalMap.put(character, 1);
                } else {
                    leftDiagonalMap.put(character, leftDiagonalMap.get(character) + 1);
                }

                if (leftDiagonalMap.get(character) == board.getSize()) {
                    return true;
                }
            }


            if (row + col == board.getSize() - 1) {
                if (!rightDiagonalMap.containsKey(character)) {
                    rightDiagonalMap.put(character, 1);
                } else {
                    rightDiagonalMap.put(character, rightDiagonalMap.get(character) + 1);
                }

                if (rightDiagonalMap.get(character) == board.getSize()) {
                    return true;
                }
            }

            return false;
        }
}

