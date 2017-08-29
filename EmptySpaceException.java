package FinalProject;

import javax.swing.*;
// a exception class to check if the textfield is empty
public class EmptySpaceException extends Exception

{
    //main constructor
    public EmptySpaceException() {
        super("EmptySpaceException!");
        JOptionPane.showMessageDialog(null,
                "Exception, You Have Enter Nothing!", "EmptySpaceException",
                JOptionPane.ERROR_MESSAGE);
    }
    //constructor with a string variable for messages
    public EmptySpaceException(String message) {
        super(message);
        System.out.println(
                "EmptySpaceException invoked with an argument.");
    }

}  //end EmptySpaceException