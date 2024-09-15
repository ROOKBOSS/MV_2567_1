import java.util.ArrayList;
import java.util.Random;

public class Cow {
    private String name;
    private String color;
    private ArrayList<Integer> scores;
    private boolean isCheatingBlackCow;
    private boolean isHumbleWhiteCow;
    
    private Random random = new Random();

    public Cow(String name, String color) {
        this.name = name;
        this.color = color;
        this.scores = new ArrayList<>();
        
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public boolean isCheating() {
        return isCheatingBlackCow;
    }
    public boolean setCheating()
    {
        if(this.getColor() =="black"){
            return this.isCheatingBlackCow = random.nextDouble() < 0.2;
        }
        else
        {
            return false;
        }
    }
    public boolean isHumble() {
        return isHumbleWhiteCow;
    }
    public boolean setHumble()
    {
        if(this.getColor() =="white"){
            return this.isHumbleWhiteCow = random.nextDouble() < 0.1;
        }
        else
        {
            return false;
        }
    }
    public int[] bowl() {
        int pinsRemaining = 10;
        int firstThrow = random.nextInt(pinsRemaining + 1); 
        pinsRemaining -= firstThrow;

        int secondThrow = random.nextInt(pinsRemaining + 1);
        return new int[]{firstThrow, secondThrow};
    }

    public void reportScore(int[] Throws) {
        int firstThrow = Throws[0];
        int secondThrow = Throws[1];

        if (this.isCheatingBlackCow) {
            firstThrow = 0;
            secondThrow = 0;
            this.isCheatingBlackCow =false;
        }
        if (this.isHumbleWhiteCow )
        {
            if(firstThrow > 0)
            {
                secondThrow = 10-firstThrow;
            }
            else{
                firstThrow = 10;
                secondThrow = 0;
            }
            this.isHumbleWhiteCow =false;
        }
        if (firstThrow == 10) {
            scores.add(10); // Cow Strike
        } else if (firstThrow + secondThrow == 10) {
            scores.add(10); // Cow Spare
        } else {
            scores.add(firstThrow + secondThrow); // Cow Open
        }
    }
}
