public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
        gameController.displayFinalScores();
        System.out.println("Thank you for playing!");
    }
}