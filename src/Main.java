import java.util.List;

public class Main {
    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard();

        scoreBoard.startGame("Mexico", "Canada");
        scoreBoard.startGame("Spain", "Brazil");
        scoreBoard.startGame("Germany", "France");
        scoreBoard.startGame("Uruguay", "Italy");
        scoreBoard.startGame("Argentina", "Australia");

        scoreBoard.updateScore("Mexico", "Canada", 0, 5);
        scoreBoard.updateScore("Spain", "Brazil", 10, 2);
        scoreBoard.updateScore("Germany", "France", 2, 2);
        scoreBoard.updateScore("Uruguay", "Italy", 6, 6);
        scoreBoard.updateScore("Argentina", "Australia", 3, 1);

        List<String> summary = scoreBoard.getSummary();
        for (int i = 0; i < summary.size(); i++) {
            System.out.println((i + 1) + ". " + summary.get(i));
        }

        scoreBoard.finishGame("Mexico", "Canada");
        scoreBoard.finishGame("Spain", "Brazil");
        scoreBoard.finishGame("Germany", "France");
        scoreBoard.finishGame("Uruguay", "Italy");
        scoreBoard.finishGame("Argentina", "Australia");
    }
}