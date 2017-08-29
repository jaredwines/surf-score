package FinalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class SurfGui extends JFrame {
    //gui private variables
    private JPanel panel;
    private JPanel panel2;
    private JLabel msgLabel;
    private JTextArea textArea;
    private JButton enterNameDis;
    private JButton enterName;
    private JButton enterScore;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton ten;
    private String name = "";
    private JTextField surfText;
    //call classes
    AllSurfRecords all = new AllSurfRecords();
    SurfFileO_I fileOI = new SurfFileO_I();
    ArrayList<SurfScore> list = new ArrayList<SurfScore>();
    SurfScore theSurfer = new SurfScore();
    Object theObject;   // creating a reference variable
    //main gui constructor
    public SurfGui() {
        // Set the title bar text, window size and action for close button
        super("Surf Score");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create label to display message
        // Creates a menubar for a JFrame
        JMenuBar menuBar = new JMenuBar();

        // Add the menubar to the frame
        setJMenuBar(menuBar);

        // Define and add two drop down menu to the menubar
        JMenu border = new JMenu("Surf Score Menu");
        JMenu rec_Write = new JMenu("Record Data");
        menuBar.add(border);
        menuBar.add(rec_Write);

        // Create 9 buttons
        enterName = new JButton("Enter");
        enterNameDis = new JButton("Enter");
        enterScore = new JButton("Enter");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        ten = new JButton("10");
        //adding menu items
        JMenuItem display = new JMenuItem("Score Display");
        JMenuItem sName = new JMenuItem("Enter Surfers Names");
        JMenuItem sScore = new JMenuItem("Enter Surfer Score");
        JMenuItem disqualified = new JMenuItem("Enter Disqualified Surfer");

        JMenuItem write = new JMenuItem("Record Data");
        JMenuItem read = new JMenuItem("Read Data");

        JMenuItem black = new JMenuItem("Black Skin");
        JMenuItem blue = new JMenuItem("Blue Skin");
        JMenuItem red = new JMenuItem("Red Skin");
        JMenuItem white = new JMenuItem("White Skin");
        JMenuItem defaultS = new JMenuItem("Default Skin");
        //declaring ActionListeners for buttons and menu
        black.addActionListener(new BlackLine());
        blue.addActionListener(new BlueLine());
        red.addActionListener(new RedLine());
        white.addActionListener(new WhiteLine());
        defaultS.addActionListener(new DefaultLine());

        display.addActionListener(new DisplayAllMenu());
        sName.addActionListener(new EnterNameMenu());
        enterName.addActionListener(new EnterButton());
        enterNameDis.addActionListener(new DisqualifiedButton());
        sScore.addActionListener(new EnterScoreMenu());
        disqualified.addActionListener(new DisqualifiedMenu());

        read.addActionListener(new ReadInput());
        write.addActionListener(new WriteOutput());

        one.addActionListener(new OneListener());
        two.addActionListener(new TwoListener());
        three.addActionListener(new ThreeListener());
        four.addActionListener(new FourListener());
        five.addActionListener(new FiveListener());
        six.addActionListener(new SixListener());
        seven.addActionListener(new SevenListener());
        eight.addActionListener(new EightListener());
        nine.addActionListener(new NineListener());
        ten.addActionListener(new TenListener());

        // Create a panel and add the components to it.
        panel = new JPanel();
        panel2 = new JPanel();
        JMenu sub = new JMenu("Sub-Menu");
        JMenu sub_color = new JMenu("Skins");
        sub_color.add(defaultS);
        sub_color.add(black);
        sub_color.add(blue);
        sub_color.add(red);
        sub_color.add(white);
        sub.add(sub_color);
        border.add(display);
        border.add(sName);
        border.add(sScore);
        border.add(disqualified);
        border.add(sub);
        rec_Write.add(write);
        rec_Write.add(read);

        // setting components
        msgLabel = new JLabel("");
        textArea = new JTextArea("Welcome To SurfScore");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setColumns(55);
        textArea.setRows(10);
        textArea.setSize(textArea.getPreferredSize());
        surfText = new JTextField(10);

        //adding and setting components to panel
        add(panel);
        panel.add(msgLabel);
        panel.add(panel2);
        panel2.add(textArea, BorderLayout.PAGE_START);
        panel2.setBorder(BorderFactory.createRaisedBevelBorder());
        panel2.setBackground(Color.cyan);
        panel.setBackground(Color.lightGray);
        //make the gui visible
        setVisible(true);
        setLocationRelativeTo(null);
        validate();
    }
    //a menu to display all the surfers info on the heat
    private class DisplayAllMenu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            removeNumButton();
            panel.remove(surfText);
            panel.remove(msgLabel);
            panel.remove(enterName);
            panel.remove(enterNameDis);
            allScore();
            msgLabel.setText("Display Surf");
            panel.add(msgLabel);
            panel.validate();
            panel.repaint();
        }
    }
    //a menu to enter a surfer to the heat
    private class EnterNameMenu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            allNames();
            removeNumButton();
            panel.remove(msgLabel);
            panel.add(msgLabel);
            panel.add(surfText);
            panel.add(enterName);
            panel.remove(enterNameDis);
            msgLabel.setText("Enter Surfer");
            panel.validate();
            panel.repaint();
        }
    }
    //a menu to disqualify a surfer from the heat
    private class DisqualifiedMenu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            allNames();
            removeNumButton();
            panel.remove(msgLabel);
            panel.add(msgLabel);
            panel.add(surfText);
            panel.add(enterNameDis);
            panel.remove(enterName);
            msgLabel.setText("Enter Disqualified Surfer");
            panel.validate();
            panel.repaint();
        }
    }
    //a menu to enter the score of the surf for
    //their performance on their wave
    private class EnterScoreMenu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            allScore();
            addNumButton();
            panel.remove(msgLabel);
            panel.add(msgLabel);
            panel.remove(enterName);
            panel.remove(enterNameDis);
            panel.remove(surfText);
            panel.remove(enterName);
            msgLabel.setText("Push the button to enter a surfers score, followed by their name");
            panel.validate();
            panel.repaint();
        }
    }
     //a button to end add the surfer to the arraylist
    private class EnterButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                name = surfText.getText();
                if (name.length() <= 0)
                    throw new EmptySpaceException();
                for (SurfScore aList : list) {
                    theObject = aList;    // get the ith item in the list
                    if (theObject != null)  // test if obj in Dog2 class
                    {
                        SurfScore theSurfer = (SurfScore) theObject;  // is a dog, typecast
                        if (name.equalsIgnoreCase(theSurfer.getName()))
                            throw new ReplaceNameException();
                    }
                }
                list.add(new SurfScore(name));

            } catch (ReplaceNameException r) {
                allNames();
                JOptionPane.showMessageDialog(null, "Please Try Again.",
                        "ReplaceNameException",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (EmptySpaceException a) {
                allNames();
                JOptionPane.showMessageDialog(null, "Please Try Again.",
                        "EmptySpaceException",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            allNames();
            panel.validate();
            panel.repaint();
        }
    }
    //a button to remove(disqualify) a surfer from the arraylist
    private class DisqualifiedButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                name = surfText.getText();
                if (name.length() <= 0)
                    throw new EmptySpaceException();
                for (int i = 0; i < list.size(); i++) {
                    theObject = list.get(i);    // get the ith item in the list
                    if (theObject != null)  // test if obj in Dog2 class
                    {
                        SurfScore theSurfer = (SurfScore) theObject;  // is a dog, typecast
                        if (name.equalsIgnoreCase(theSurfer.getName()))
                            list.remove(i);
                    }
                }
            } catch (EmptySpaceException e3) {
                allNames();
                JOptionPane.showMessageDialog(null, "Please Try Again.",
                        "EmptySpaceException",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            allNames();
            panel.validate();
            panel.repaint();
        }
    }

    //skin red
    private class RedLine implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.red);
            panel2.setBackground(Color.black);
            msgLabel.setForeground(Color.yellow);
        }
    }
    //skin blue
    private class BlueLine implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.blue);
            panel2.setBackground(Color.red);
            msgLabel.setForeground(Color.pink);
        }
    }
    //skin black
    private class BlackLine implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.black);
            panel2.setBackground(Color.blue);
            msgLabel.setForeground(Color.yellow);
        }
    }
   //skin white
    private class WhiteLine implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.white);
            panel2.setBackground(Color.white);
            msgLabel.setForeground(Color.black);
        }
    }
     //default skin
    private class DefaultLine implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.lightGray);
            panel2.setBackground(Color.cyan);
            msgLabel.setForeground(Color.black);
        }
    }

    // Number Pad ActiongLisener 1-10 that
    //sets the surfers score
    private class OneListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            numScore(1, "One");
        }
    }

    private class TwoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            numScore(2, "Two");
        }
    }

    private class ThreeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            numScore(3, "Three");
        }
    }

    private class FourListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            numScore(4, "Four");
        }
    }

    private class FiveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            numScore(5, "Five");
        }
    }

    private class SixListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            numScore(6, "Six");
        }
    }

    private class SevenListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            numScore(7, "Seven");
        }
    }

    private class EightListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            numScore(8, "Eight");
        }
    }

    private class NineListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            numScore(9, "Nine");
        }
    }

    private class TenListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            numScore(10, "Ten");
        }
    }
    //actionlistener to write the display(toString) to a txt file
    private class WriteOutput implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            all.resetToString();
            textArea.setText("");
            for (SurfScore aList : list) {
                SurfScore theSurfer = (SurfScore) aList;
                all.setToString(theSurfer.toString());
            }
            fileOI.fileOutput(all.getToString());
        }
    }
    //actionlistener to read the txt file from beginning to end
    private class ReadInput implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            fileOI.fileRead();
        }
    }
    //inputs the score of the wave
    public void numScore(int n, String s) {


        String name = JOptionPane
                .showInputDialog("Enter the surfer you wish to receive a score of " + s + ".");
        try {
            if (name.length() <= 0)
                throw new EmptySpaceException();

            for (SurfScore aList1 : list) {
                theObject = aList1;
                if (theObject != null) {
                    SurfScore theSurfer = (SurfScore) theObject;
                    if (theSurfer.getName().equalsIgnoreCase(name)) {
                        JOptionPane.showMessageDialog(null, "The surfer "
                                + theSurfer.getName()
                                + " has received " + s + " point.",
                                "theSurfer.getName",
                                JOptionPane.INFORMATION_MESSAGE);
                        theSurfer.setScore(n);
                        theSurfer.setRanking(theSurfer.getTotalScore());
                    }

                }
            }

        } catch (EmptySpaceException e) {
            JOptionPane.showMessageDialog(null, "Please Try Again.",
                    "EmptySpaceException",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        allScore();
        getAllPoints();
        panel2.validate();
        panel2.repaint();

    }
     //refreshes the names
    public void allNames() {
        surfText.setText("");
        all.resetAllNames();
        for (SurfScore aList1 : list) {
            theSurfer = aList1;
            all.setAllNames(theSurfer.getName());
        }
        textArea.setText(all.getAllNames());
        panel.validate();
        panel.repaint();
    }
    //refreshes all the surfers scores combined
    public void allScore() {
        all.resetToString();
        textArea.setText("");
        for (SurfScore aList : list) {
            SurfScore theSurfer = aList;
            all.setToString(theSurfer.toString());
        }
        textArea.setText(all.getToString());
        panel.validate();
        panel.repaint();
    }
    // gets all of the points of the surfers
    public void getAllPoints() {
        allScore();
        double sum = 0.0;
        //puts the list in order relative to total score
        Collections.sort(list, new SurfComparator());

        for (int index = 0; index < list.size(); index++) {
            SurfScore theSurfer = list.get(index);
            sum += theSurfer.getTotalScore();
            theSurfer.setPlace(index + 1);
        }

        for (SurfScore aList1 : list) {
            SurfScore theSurfer = aList1;
            theSurfer.setAllPoints(sum);
        }
        panel.validate();
        panel.repaint();
        allScore();
    }
    //removes all the numButtons(1-10) from the panel
    public void removeNumButton() {
        panel.remove(enterScore);
        panel.remove(one);
        panel.remove(two);
        panel.remove(three);
        panel.remove(four);
        panel.remove(five);
        panel.remove(six);
        panel.remove(seven);
        panel.remove(eight);
        panel.remove(nine);
        panel.remove(ten);
        panel.validate();
        panel.repaint();
    }
    //adds all the numButtons(1-10) to the panel
    public void addNumButton() {
        two.setSize(new Dimension(200, 200));
        panel.add(one);
        panel.add(two);
        panel.add(three);
        panel.add(four);
        panel.add(five);
        panel.add(six);
        panel.add(seven);
        panel.add(eight);
        panel.add(nine);
        panel.add(ten);
        panel.validate();
        panel.repaint();
    }

}
