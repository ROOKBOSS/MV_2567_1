import java.util.ArrayList;

public class BowlingGame {
    private ArrayList<Team> teams;

    public BowlingGame(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public void playGame() {
        for (int round = 1; round <= 10; round++) {
            System.out.println("Round " + round + " starts!");

            for (Team team : teams) {
                for (Cow cow : team.getCows()) {
                    int[] Throws = cow.bowl();
                    cow.setCheating();
                    cow.setHumble();
                    boolean isCheatingCaught = checkIfCheating(cow, Throws);
                    boolean isHumbleWhiteCow = checkIfHumble(cow, Throws);
                    cow.reportScore(Throws);
                    if(isCheatingCaught == true)
                    {
                        System.out.println(cow.getName() + " from " + team.getName() + " scored " +
                            Throws[0] + " + " + Throws[1] + "(Caught cheating!)" + cow.getScores());
                    }
                    else if(isHumbleWhiteCow)
                    {
                        System.out.println(cow.getName() + " from " + team.getName() + " scored " +
                            Throws[0] + " + " + Throws[1] + "(Caught humble!)" + cow.getScores());
                    }
                    else
                    {
                        System.out.println(cow.getName() + " from " + team.getName() + " scored " +
                            Throws[0] + " + " + Throws[1] + cow.getScores());
                    }
                }
            }

            System.out.println("Round " + round + " ends!\n");
        }
    }

    private boolean checkIfCheating(Cow cow, int[] Throws) {
        if (cow.getColor().equals("black") && cow.isCheating()) {
            return true;
        }
        return false;
    }
    private boolean checkIfHumble(Cow cow, int[] Throws) {
        if (cow.getColor().equals("white") && cow.isHumble()) {
            return true;
        }
        return false;
    }
    public void displayResults() {
        for (Team team : teams) {
            System.out.println(team.getName() + " total score: " + team.getTotalScore());
        }
    }

    public Team findWinningTeam() {
        Team winningTeam = null;
        int highestScore = 0;

        for (Team team : teams) {
            int teamScore = team.getTotalScore();
            if (teamScore > highestScore) {
                highestScore = teamScore;
                winningTeam = team;
            }
        }

        return winningTeam;
    }
}
