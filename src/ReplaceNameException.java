import javax.swing.*;
// a exception class to check if the name is being replaced
public class ReplaceNameException extends Exception

{
    //main constructor
    public ReplaceNameException() {
        super("ReplaceNameException!");
        JOptionPane.showMessageDialog(null,
                "Exception, Surfers Name Already Exists!", "ReplaceNameException",
                JOptionPane.ERROR_MESSAGE);
    }
    //constructor with a string variable for messages
    public ReplaceNameException(String message) {
        super(message);
        System.out.println(
                "ReplaceNameException invoked with an argument.");
    }

} //end ReplaceNameException