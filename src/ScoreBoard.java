import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScoreBoard {
    private final Map<Match, Match> matches;

    public ScoreBoard() {
        this.matches = new HashMap<>();
    }

    public void startGame(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);

        if (matches.containsKey(match))
            throw new IllegalStateException("Match already exists: " + homeTeam + " vs " + awayTeam);

        matches.put(match, match);
    }

    public void finishGame(String homeTeam, String awayTeam) {
        Match matchToRemove = new Match(homeTeam, awayTeam);

        if (matches.remove(matchToRemove) == null)
            throw new IllegalStateException("Match not found: " + homeTeam + " - " + awayTeam);
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        Match searchMatch = new Match(homeTeam, awayTeam);
        Match actualMatch = matches.get(searchMatch);

        if (actualMatch == null)
            throw new IllegalStateException("Match not found: " + homeTeam + " - " + awayTeam);

        actualMatch.updateScore(homeScore, awayScore);
    }

    public List<String> getSummary() {
        return matches.values().stream()
                .sorted((m1, m2) -> {
                    int totalScoreComparison = Integer.compare(m2.getTotalScore(), m1.getTotalScore());
                    if (totalScoreComparison != 0) {
                        return totalScoreComparison;
                    }
                    return Long.compare(m2.getStartTime(), m1.getStartTime());
                })
                .map(Match::toString)
                .collect(Collectors.toList());
    }

    public int getMatchCount() {
        return matches.size();
    }

    public boolean hasMatch(String homeTeam, String awayTeam) {
        return matches.containsKey(new Match(homeTeam, awayTeam));
    }
}
