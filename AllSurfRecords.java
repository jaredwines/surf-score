package FinalProject;

//This Class holds all the surfers recorders to one value
public class AllSurfRecords {
    String toString = "";
    String allNames = "";

    //Gets all of the surfers name
    public String getAllNames() {
        return allNames;
    }

    //Sets all of the surf names
    public void setAllNames(String allNames) {
        this.allNames += allNames + "\n";
    }

    //resets the name to null
    public void resetAllNames() {
        this.allNames = "";
    }

    //Set the whole display to a string
    public void setToString(String s) {
        toString += s;
    }

    //resets the whole display to null
    public void resetToString() {
        this.toString = "";
    }

    //gets the whole displays
    public String getToString() {
        return toString;
    }
}  //end AllSurfRecords

