import java.util.Scanner;

public class GameController {
    Player player1;
    Player player2;

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public String setPlayer1Name() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Player 1 name: ");
        return sc.next();
    }

    public String setPlayer2Name() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Player 2 name ('bot' to play against a bot): ");
        return sc.next();
    }


    private int getPlayerMove(String playerName) {
        Scanner scan = new Scanner(System.in);
        int move = 0;
        do {
            System.out.println(playerName + "'s move {1 - ROCK, 2 - PAPER, 3 - SCISSORS}");
            move = scan.nextInt();
            if (!GameLogic.isValidMove(move)) {
                System.out.println("Invalid move! Try again");
            }
        } while (!GameLogic.isValidMove(move));
        return move;
    }

    private int getBotMove() {
        return (int) (Math.random() * 3 + 1);
    }

    private String translatingNumberInWord(int move) {
        String moveInWord;
        if (move == 1) {
            moveInWord = "rock";
        } else if (move == 2) {
            moveInWord = "paper";
        } else {
            moveInWord = "scissors";
        }
        return moveInWord;
    }

    public void startGame() {
        System.out.println("Welcome to Rock, Paper and Scissors!");
        player1 = new Player(setPlayer1Name());
        player2 = new Player(setPlayer2Name());

        boolean playNewGame = true;
        while (playNewGame) {
            System.out.println();
            int firstMove = getPlayerMove(player1.getName());
            int secondMove;

            if (player2.getName().equalsIgnoreCase("bot")) {
                secondMove = getBotMove();
            } else {
                secondMove = getPlayerMove(player2.getName());
            }

            playRound(firstMove, secondMove);
            playNewGame = askPlayAgain();
        }


    }

    public void playRound(int firstMove, int secondMove) {

        int result = GameLogic.compareMoves(firstMove, secondMove);
        showMoves(firstMove, secondMove);
        if (result == 1) {
            player1.incrementScore();
            System.out.println(player1.getName() + " wins! Congratulations");
        } else if (result == 2) {
            player2.incrementScore();
            System.out.println(player2.getName() + " wins! Congratulations");
        } else {
            System.out.println("It's a draw :)");
        }
        System.out.println();
    }

    private void showMoves(int firstMove, int secondMove) {
        String firstMoveInWord = translatingNumberInWord(firstMove);
        String secondMoveInWord = translatingNumberInWord(secondMove);
        System.out.print(player1.getName().toUpperCase() + " has chosen " + firstMoveInWord.toUpperCase() + " && ");
        System.out.println(player2.getName().toUpperCase() + " has chosen " + secondMoveInWord.toUpperCase());
    }

    private boolean askPlayAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Play again? (y/n): ");
        String input = scanner.next();
        System.out.println();
        return input.equalsIgnoreCase("y");
    }

    public void displayFinalScores() {
        System.out.println("--- Final Scores ---");
        System.out.println(player1.getName() + ": " + player1.getScore());
        System.out.println(player2.getName() + ": " + player2.getScore());
    }
}
