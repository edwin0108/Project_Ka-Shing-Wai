/**
 * Created by Gor on 7/15/2017.
 */
import java.awt.*;
import javax.swing.*;

public class Border_Layout extends JFrame {
    private final JButton button;
    private final JTextField text;
    private final JLabel label;
    private static final String name = "numbers";
    private final BorderLayout layout;

    public Border_Layout()
    {
        super("Testing");
        layout = new BorderLayout(5,5);
        setLayout(layout);

        button = new JButton("Enter");
        label = new JLabel("Occurrence");
        text = new JTextField();


        add(text, BorderLayout.NORTH);
        add(button, BorderLayout.EAST);
        //add(label, BorderLayout.CENTER);

    }

}
