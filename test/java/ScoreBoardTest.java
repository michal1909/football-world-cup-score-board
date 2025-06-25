import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ScoreBoardTest {
    private ScoreBoard scoreBoard;

    @BeforeEach
    void setUp() {
        scoreBoard = new ScoreBoard();
    }

    @Test
    void shouldStartNewGameWithInitialScore() {
        scoreBoard.startGame("Mexico", "Canada");
        assertTrue(scoreBoard.hasMatch("Mexico", "Canada"));
        assertEquals(1, scoreBoard.getMatchCount());
    }

    @Test
    void shouldFinishGameAndRemoveFromScoreBoard() {
        scoreBoard.startGame("Mexico", "Canada");
        scoreBoard.finishGame("Mexico", "Canada");
        assertFalse(scoreBoard.hasMatch("Mexico", "Canada"));
        assertEquals(0, scoreBoard.getMatchCount());
    }

    @Test
    void shouldUpdateScoreOfExistingGame() {
        scoreBoard.startGame("Spain", "Brazil");
        scoreBoard.updateScore("Spain", "Brazil", 10, 2);
        List<String> summary = scoreBoard.getSummary();
        assertEquals("Spain 10 - Brazil 2", summary.get(0));
    }

    @Test
    void shouldThrowExceptionWhenUpdatingScoreWithNegativeValues() {
        scoreBoard.startGame("Argentina", "Australia");
        assertThrows(IllegalArgumentException.class, () ->
                scoreBoard.updateScore("Argentina", "Australia", -3, 1));
        assertThrows(IllegalArgumentException.class, () ->
                scoreBoard.updateScore("Argentina", "Australia", 0, -1));
    }

    @Test
    void shouldThrowExceptionWhenUpdatingScoreOfNonExistentGame() {
        assertThrows(IllegalStateException.class, () ->
                scoreBoard.updateScore("Poland", "Brazil", 7, 0));
    }

    @Test
    void shouldReturnEmptySummaryWhenNoGamesExist() {
        List<String> summary = scoreBoard.getSummary();
        assertTrue(summary.isEmpty());
    }
}
