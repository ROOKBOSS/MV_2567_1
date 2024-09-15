import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Cow> cows;

    public Team(String name) {
        this.name = name;
        this.cows = new ArrayList<>();
        cows.add(new Cow("no1" ,name));
        cows.add(new Cow("no2" ,name));
        cows.add(new Cow("no3" ,name));
    }

    public String getName() {
        return name;
    }

    public ArrayList<Cow> getCows() {
        return cows;
    }

    public int getTotalScore() {
        int totalScore = 0;
        for (Cow cow : cows) {
            totalScore += cow.getScores().stream().mapToInt(Integer::intValue).sum();
        }
        return totalScore;
    }
}
