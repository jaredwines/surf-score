package FinalProject;

import java.util.Comparator;
//sets the arraylist in order by Total Score
class SurfComparator implements Comparator<SurfScore> {
    //method that compares one score to either score
    //to get the list in order.
    public int compare(SurfScore o1, SurfScore o2) {
        if (o1.getTotalScore() > o2.getTotalScore()) {
            return -1;
        } else if (o1.getTotalScore() < o2.getTotalScore()) {
            return 1;
        }
        return 0;
    }
} //end //SurfComparator