import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Team team1 = new Team("white");
        Team team2 = new Team("black");
        Team team3 = new Team("brown");

        ArrayList<Team> teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);

        // Start game
        BowlingGame game = new BowlingGame(teams);
        game.playGame();

        // Display results
        game.displayResults();

        // Find winning team
        Team winningTeam = game.findWinningTeam();
        System.out.println("Winning Team: " + winningTeam.getName());
    }
}
