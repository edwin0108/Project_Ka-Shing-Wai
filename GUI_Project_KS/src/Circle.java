import java.awt.*;
import java.util.Random;
/**
 * Created by Gor on 07/08/2017.
 */
public class Circle extends Oval
{
    private int m_radius;
    private Color cir_color;

    public Circle(int x, int y, int radius,Color color, int height, int width) //CONSTRUCTOR
    {
        super(x,y,color, width, height);
        this.cir_color = color;
        this.m_radius = radius;}

    //GET FUNCTIONS
    public int getRadius(){return m_radius;}

    @Override
    public long getArea(){return (Math.round(m_radius * m_radius * Math.PI));}

    @Override
    public long getPerimeter(){return (Math.round(2 * Math.PI * m_radius));}

    public Color getColor() {return cir_color;}

    //SET FUNCTIONS
    public void setRadius(int r){m_radius = r;}

    public Color setColor()
    {
        Random ran_color = new Random();
        Color randomColor = new Color((int)ran_color.nextInt(255),
                (int)ran_color.nextInt(255),
                (int)ran_color.nextInt(255));
        cir_color = randomColor;
        return randomColor;
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.black);
        g.drawOval(getX() - getRadius(),getY() - getRadius(),getRadius() * 2, getRadius() * 2);
    }

}
