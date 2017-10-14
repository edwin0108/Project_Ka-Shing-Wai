import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Gor on 7/15/2017.
 */

public class FlowLayoutTest extends JFrame{
    private JButton button;
    private JTextField text;
    private JLabel label;
    private final MyPieChartPanel jp1;


    public FlowLayoutTest()
    {
        //SET FLOW LAYOUT
        super("Assignment 4 - Ka Shing Wai");
        setLayout(new FlowLayout());
        setSize(900,800);

        //SET BUTTON
        button = new JButton("Enter");

        //SET TEXTBOX
        text = new JTextField("1");
        text.setPreferredSize(new Dimension(100,25));

        //SET LABEL
        label = new JLabel("             Number of occurrence: ");

        //PIE-CHART TO THE PANEL
        ButtonControl handler = new ButtonControl();
        button.addActionListener(handler);
        jp1 = new MyPieChartPanel();
        jp1.setPreferredSize(new Dimension(800,600));

        //ADDING COMPONENTS
        add(label, FlowLayout.LEFT);
        add(text, FlowLayout.CENTER);
        add(button, FlowLayout.RIGHT);
        add(jp1);
    }

    //OVERRIDING INTERFACE METHOD
    private class ButtonControl implements ActionListener
    {
        @Override
        public void actionPerformed (ActionEvent e)
        {
            int x = Integer.parseInt(text.getText());
            HistogramLetters test = new HistogramLetters(x);
            test.openFile();
            test.readFile();
            repaint();
            test.closeFile();
        }
    }

    //INNER CLASS FOR THE PIE-CHART DRAWING
    class MyPieChartPanel extends JPanel
    {
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            int num_arc = Integer.parseInt(text.getText());
            PieChart a = new PieChart(getWidth() / 2, getHeight() / 2, getHeight() / 2,
                    Color.CYAN, getWidth(), getHeight() - 70, 0, num_arc);
            a.draw(g);
        }
    }
}
