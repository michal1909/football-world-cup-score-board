public class Match {
    private final String homeTeam;
    private final String awayTeam;
    private int homeScore;
    private int awayScore;
    private final long startTime;

    public Match(String homeTeam, String awayTeam) {
        if (homeTeam == null || homeTeam.trim().isEmpty())
            throw new IllegalArgumentException("Home team cannot be null or empty");
        if (awayTeam == null || awayTeam.trim().isEmpty())
            throw new IllegalArgumentException("Away team cannot be null or empty");
        if (homeTeam.equalsIgnoreCase(awayTeam))
            throw new IllegalArgumentException("Home team and away team cannot be the same");

        this.homeTeam = homeTeam.trim();
        this.awayTeam = awayTeam.trim();
        this.homeScore = 0;
        this.awayScore = 0;
        this.startTime = System.nanoTime();
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public long getStartTime() {
        return startTime;
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }

    public void updateScore(int homeScore, int awayScore) {
        if (homeScore < 0 || awayScore < 0)
            throw new IllegalArgumentException("Scores cannot be negative");

        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    @Override
    public String toString() {
        return homeTeam + " " + homeScore + " - " + awayTeam + " " + awayScore;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Match match = (Match) obj;
        return homeTeam.equalsIgnoreCase(match.homeTeam) &&
                awayTeam.equalsIgnoreCase(match.awayTeam);
    }

    @Override
    public int hashCode() {
        return (homeTeam.toLowerCase() + awayTeam.toLowerCase()).hashCode();
    }
}
