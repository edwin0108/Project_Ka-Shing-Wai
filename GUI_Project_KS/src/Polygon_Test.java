import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Created by Gor on 6/24/2017.
 */
public class Polygon_Test extends JPanel {
    private int height;
    private int width;

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        width = getWidth();
        height = getHeight();

        int radius = (Math.min(height, width)) / 2;

        for(int i = 0; i < 2; i++) {
            PolygonShape b = new PolygonShape(width / 2, height / 2, Color.cyan, 5, radius);
            b.draw(g);
            System.out.println(b);

            radius = (int) ((radius) * Math.cos(Math.PI / b.getSides()));
        }
        g.setColor(Color.black);
        g.drawRect(0,0,width,height);
        g.drawLine(0,0,width,height);
        g.drawLine(0,height,width,0);
    }

    public static void main(String[] args)
    {
        int width;
        int height;

        Scanner input = new Scanner(System.in);
        System.out.printf("Please enter the width:");
        width = input.nextInt();
        System.out.printf("Please enter the height:");
        height = input.nextInt();

        Polygon_Test panel = new Polygon_Test();
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setTitle("Assignment 2 - Ka Shing Wai");
        application.setSize(width,height);
        application.setVisible(true);
    }

}
