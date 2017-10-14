/**
 * Created by Gor on 7/15/2017.
 */
import java.awt.*;
import javax.swing.*;

public class Layout_Test {
    private JFrame frame;
    private String[] name;

    public Layout_Test()
    {
        frame = new JFrame();
        String [] s = {"# of most frequent occurrences","Begin"};
        name = s;
    }


    public void process()
    {
        frame.setSize(600,400);
        frame.setLayout(new GridBagLayout());
        frame.setTitle("Assignment 4 - Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel(name[0]);
        GridBagConstraints g0 = new GridBagConstraints();
        g0.gridx = 0;
        g0.gridy = 0;
        g0.anchor = GridBagConstraints.WEST;
        g0.fill = GridBagConstraints.NONE;
        frame.add(label,g0);

        JTextField input = new JTextField();
        GridBagConstraints g1 = new GridBagConstraints();
        //g1.gridx = 1;
        //g1.gridy = 0;
        //g1.gridwidth = 7;
        //g1.gridheight = 1;
        g1.anchor = GridBagConstraints.PAGE_START;
        g1.fill = GridBagConstraints.BOTH;
        frame.add(input,g1);

        JButton button = new JButton(name[1]);
        GridBagConstraints g2 = new GridBagConstraints();
        g2.gridx = 8;
        g2.gridy = 0;
        g2.gridwidth = 5;
        g2.gridheight = 1;
        g1.anchor = GridBagConstraints.CENTER;
        g1.fill = GridBagConstraints.HORIZONTAL;

        frame.setVisible(true);

    }
}
