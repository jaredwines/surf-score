import javax.swing.*;
import java.io.*;

public class SurfFileO_I {
    //writes the display(toString) to a txt file
    public void fileOutput(String s) {
        // Create object(stream) for output using the FileOutputStream class
        PrintWriter outputStream = null;

        try {
            outputStream = new PrintWriter(new FileOutputStream(
                    "SurfRecord.txt"));
        }

        // Check to see if file can be created or exists. If not, end program
        catch (FileNotFoundException e) {
            System.out.println("Error opening the file dataFile.");
            System.exit(0);
        }

        // Tell user you are writing out to file
        JOptionPane.showMessageDialog(null, "Writing to file.", "Writing",
                JOptionPane.INFORMATION_MESSAGE);

        // Write out to file
        outputStream.println(s);

        // Close output file
        outputStream.close();

        JOptionPane.showMessageDialog(null, "File is done writing", "Done",
                JOptionPane.INFORMATION_MESSAGE);
    }
    //reads the txt file from beginning to end
    public void fileRead() {
        BufferedReader br = null;

        try {

            String sCurrentLine;
            String allCurrent = "";
            br = new BufferedReader(new FileReader("SurfRecord.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                allCurrent += "\n" + sCurrentLine;
            }
            JOptionPane.showMessageDialog(null, allCurrent, "Record",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}  //end SurfFileO_I