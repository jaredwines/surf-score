package FinalProject;

import java.text.*;
public class SurfScore {
    //instances variables for the surfer
    String name = "";
    double score1 = 0.0;
    double score2 = 0.0;
    int places = 0;
    double percent = 0.0;
    double allPoints = 0;
    double totalScore = 0.0;
    String ranking = "";
    DecimalFormat oneDigit = new DecimalFormat("#,##0.0");
    //default constructor
    public SurfScore() {
        name = "";
        score1 = 0;
        score2 = 0;
    }

    public SurfScore(String Name, double score1, double score2) {
        this.name = Name;
        this.score1 = score1;
        this.score2 = score2;
    }
    //main constructor that is used in the program
    public SurfScore(String Name) {
        super();
        this.name = Name;
    }

    public SurfScore(double score1, double score2) {
        super();
        this.score1 = score1;
        this.score2 = score2;
    }
    //gets the surfers name
    public String getName() {
        return name;
    }
    //sets the surfers name
    public void setName(String Name) {
        this.name = Name;
    }
    //gets the surfers highest score
    public double getScore1() {
        return score1;
    }
    //gets the surfers second highest score
    public double getScore2() {
        return score2;
    }
    //relieves the user score then puts the score
    //either in score1 or score2; determined by if one
    //score is higher than the other
    public void setScore(double score) {
        if (this.score1 == score)
            this.score2 = this.score1;
        else if (this.score1 > score && this.score2 < score)
            this.score2 = score;
        else if (this.score1 < score && score2 < score) {
            this.score2 = this.score1;
            this.score1 = score;

        }
    }
    //Get the place the surf is currently in
    public int getPlace() {
        return places;
    }
    //Sets the place the surf is currently in
    public void setPlace(int prostition) {
        this.places = prostition;
    }
    //calculates the percent relative to the total score
    //of all the surf's points
    public double getPercent() {
        percent = ((score1 + score2) / getAllPoints()) * 100;
        return percent;
    }
    //sets the percent
    public void setPercent(double percent) {
        this.percent = Math.round(percent);
    }
    //gets the surfs total score by adding
    //the highest and second highest score
    public double getTotalScore() {
        totalScore = score1 + score2;
        return totalScore;
    }
   //gets the surfers current ranking(title)
    public String getRanking() {
        return ranking;
    }
    //gets all the total of all the surfers points
    //(used to calculate the percent)
    public double getAllPoints() {
        return allPoints;
    }
    //sets allPoint
    public void setAllPoints(double AllPoints) {
        allPoints = AllPoints;
    }
    //tells what the surfer rank is relative
    //to the amount of points the surf has
    public void setRanking(double rank) {
        if (rank == 0)
            this.ranking = "CATCH A WAVE!";
        else if (rank < 1)
            this.ranking = "Your a Kook";
        else if (rank < 2)
            this.ranking = "??????";
        else if (rank < 4)
            this.ranking = "Leave The Board";
        else if (rank < 6)
            this.ranking = "WIPEOUT!";
        else if (rank < 8)
            this.ranking = "Bad Day?";
        else if (rank < 10)
            this.ranking = "Average";
        else if (rank < 12)
            this.ranking = "Noticeable";
        else if (rank < 14)
            this.ranking = "Up Coming Hot Shot";
        else if (rank < 16)
            this.ranking = "Beastly";
        else if (rank < 18)
            this.ranking = "Kelly Slater";
        else if (rank == 20)
            this.ranking = "Your a GOD!";

    }
    //displays all the information on the surfer
    public String toString() {
        return "Surfer:  " + getName() + "  Percent:  "
                + oneDigit.format(getPercent()) + "%  " + "  Positions:  " + getPlace()
                + "  Rank:  " + getRanking() + " Highest Wave Score:  "
                + getScore1() + "  Second Highest Wave Score:  "
                + getScore2() + "  Total Score:  " + getTotalScore() + "\n\n";
    }
}//end SurfScore
