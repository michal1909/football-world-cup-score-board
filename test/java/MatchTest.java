import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {
    @Test
    public void testMatchCreation() {
        Match match = new Match("Mexico", "Canada");
        assertEquals("Mexico", match.getHomeTeam());
        assertEquals("Canada", match.getAwayTeam());
        assertEquals(0, match.getHomeScore());
        assertEquals(0, match.getAwayScore());
    }

    @Test
    public void testMatchEmptyTeamName() {
        assertThrows(IllegalArgumentException.class, () -> new Match("", "Brazil"));
        assertThrows(IllegalArgumentException.class, () -> new Match("Spain", null));
    }

    @Test
    public void testMatchSameTeams() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Match("Germany", "Germany");
        });
        assertTrue(exception.getMessage().contains("cannot be the same"));
    }

    @Test
    public void testScoreUpdate() {
        Match match = new Match("Germany", "France");
        match.updateScore(2, 1);
        assertEquals(2, match.getHomeScore());
        assertEquals(1, match.getAwayScore());
    }
}
