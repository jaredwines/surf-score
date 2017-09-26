/*
   File Name:          SurfScore.java
   Programmer:         Jared Wines
   Date Last Modified: 12/1/13 @ 7:09 PM

   Problem Statement: This project will keep track of the surfers info in a heat.
   This will be done by a arraylist, gui, constructor, setters and getters.
   This program will be called SurfScore. It will be able to add and remove surfers
   from the heat. It also will show the percent relative to all the surfers point, highest wave
   second highest wave, position, rank(title), and total points for each surfer at once.
   The program will be constantly refreshing to show the most accurate results.

   Overall Plan (step-by-step, how you want the code to make it happen):
   1. Make a class called surfscore to hold all the individuals info
    I) Make instances variables to store the surfers info
        a)Make a variable to hold percents
            i)the percent will be relative to all the surfers
            points combined
        b)Make a variable to hold high score
        c)Make a variable to hold second high score
        e)Make a variable to hold total score
            i)total score will add high score and
            second high score
        f)Make a variable to hold rank
            i)Make matched to use the total score to
            determine rank
        h)Make a toString to display all the surfers info
   2. Make a class called AllSurfRecords to hold info
   from all the surfers to curtain variables.
    I)Make a setter, getter, reset for a toString that holds all the surfers info
    II)Make a setter, getter, reset for a toString that holds all the surfers names
   3. make a class called SurfFileI_O to read and write txt files
    I)Make a method to write all the current surfers info to a txt file
    II)make a method to read the txt file from beginning to end
   4.Make a class called SurfGui to so the program in a gui
     I)make gui private variables like JButton, JPanel, etc
     II)add textarea, textfield,etc to panel
     III)Creates a menubar for a JFrame
        a) make a menu for display surfers info
        b) make a menu to add a surf
        c) make a menu to remove surf
        d) make a menu to enter the scores
        e) make a sub-menu that holds the skins(appearances)
        f) make a menu to write info to txt file
        h) make a menu to read txt file from beginning to end
     III) create the actionlisteners for the menus and buttons
        a)make a actionlistener for the menus to change the gui display according
        b) make actionlistener for buttons to add items to arraylist,
        remove items to arraylist, or set score for surfer
   5. Make a class called SurfComparator that sorts the arraylist by each surfers
   total score to get there current position in the heat.
    I) the class will be a comparator class
   6. Make a class called ReplaceNameException
    I) this will be a execution class used to check if the user if
    replace a surf's name
   6. Make a class called EmptySpaceException
    I) this will be a execution class used to check if the user if
    has enter a name with a black statement.
   7. Make a class called SurfScoreDemo
    I)this is where the main void will be to run the whole program
   8.RUN!!!!!!!!!!! :)

   Classes needed and Purpose (Input, Processing, Output)
   main class – MyProgram
*/
public class SurfScoreDemo {
    //main void
    public static void main(String[] args) {
        new SurfGui();
    } //  end main
} //end SurfScoreDemo
