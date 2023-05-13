public class GameLogic {
    public static final int rock = 1;
    public static final int paper = 2;
    public static final int scissors = 3;

    public static int compareMoves(int firstMove, int secondMove) {
        int result;
        if (firstMove == secondMove) {
            result = 0; // Draw
        } else if ((firstMove == rock && secondMove == scissors) ||
                (firstMove == paper && secondMove == rock) ||
                (firstMove == scissors && secondMove == paper)) {
            result = 1; // Player 1 wins

        } else {
            result = 2; // Player 2 wins
        }
        return result;
    }
    public static boolean isValidMove(int move) {
        boolean isValidMove;
        if (move <= scissors && move >= rock) {
            isValidMove = true;
        } else {
            isValidMove = false;
        }
        return isValidMove;
    }
}