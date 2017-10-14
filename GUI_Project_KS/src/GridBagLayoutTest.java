/**
 * Created by Gor on 7/15/2017.
 */
import java.awt.*;
import javax.swing.*;

public class GridBagLayoutTest extends JFrame {
    private final JButton button;
    private final JTextField text;
    private final JLabel label;
    private static final String name = "numbers";

    public GridBagLayoutTest()
    {
        super("Testing");
        setLayout(new GridBagLayout());

        button = new JButton("Enter");
        GridBagConstraints g0 = new GridBagConstraints();
        //g0.anchor = GridBagConstraints.FIRST_LINE_END;
        g0.fill = GridBagConstraints.NONE;
        g0.gridx = 8;
        g0.gridy = 0;

        label = new JLabel("Occurrence");
        GridBagConstraints g1 = new GridBagConstraints();
        //g1.anchor = GridBagConstraints.FIRST_LINE_START;
        g1.fill = GridBagConstraints.NONE;
        g1.gridx = 0;
        g1.gridy = 0;

        text = new JTextField();
        GridBagConstraints g2 = new GridBagConstraints();
        //g2.anchor = GridBagConstraints.CENTER;
        g2.fill = GridBagConstraints.NONE;
        g2.gridx = 1;
        g2.gridy = 0;

        add(button, GridBagConstraints.NORTHEAST);
        add(label, GridBagConstraints.NORTHWEST);
        add(text, GridBagConstraints.PAGE_START);


    }
}
