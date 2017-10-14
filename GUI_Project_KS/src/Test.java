/**
 * Created by Gor on 6/24/2017.
 */

import java.awt.*;
import javax.swing.*;

public class Test extends JPanel
{
    private int height;
    private int width;

    public Test()
    {
        width = getWidth();
        height = getHeight();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        width = getWidth();
        height = getHeight();

        //CREATING OBJECTS
        Rectangle R = new Rectangle(width / 2, height / 2, Color.cyan, width, height);
        Oval O = new Oval(width/2, height/2, Color.CYAN, width, height);
        Circle C = new Circle(width / 2, height / 2, height/2, Color.CYAN, height, width);
        PieChart a = new PieChart(width / 2, height / 2, height / 2, Color.CYAN, width, height, 0,4);

        double [] b = {0.22,0.33,0.12,0.14};



        //Pie Chart
        double prob = 1;
        for (int i = 0; i < b.length; i++ ){
            double count = 0;
            double current = b[i];
            for (int j = 0; j < b.length; j++){
                if (b[j] == current) {count++;}
            }
            double temp = count/b.length;
            int angle = (int) (360 * temp);

            a.setAngle(angle);
            a.draw(g);
            prob = prob - temp;
        }




        //CREATE DIAGONAL LINE
        //MAKE SURE THE STARTING PT.(LEFTMOST PT.) OF THE RECTANGLE IS ON THE LINE
        //g.setColor(Color.black);
        //g.drawLine(0,0,width,height);
    }

    public static void main(String [] args)
    {
        Test test = new Test();
        JFrame app = new JFrame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.add(test);
    }

}