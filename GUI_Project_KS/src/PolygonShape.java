import java.awt.*;
import java.awt.Polygon;
import java.util.Random;
/**
 * Created by Gor on 6/23/2017.
 */
public class PolygonShape extends Shape {

    private Color m_color;
    private int m_sides;
    private int m_radius;

    public PolygonShape(int x, int y, Color color, int sides, int radius) //CONSTRUCTOR
    {
        super(x,y,color);
        this.m_sides = sides;
        this.m_radius = radius;
    }

    public int getRadius() {return m_radius;}

    public int getSides() {return m_sides;}

    public long getAngle() {return (360/getSides());}

    public long getSide_length()
    {
        long half_inter_angle = getAngle()/2;
        long half_side = Math.abs(Math.round(Math.sin(half_inter_angle) * getRadius()));
        return (half_side * 2);
    }

    public long getPerimeter() {return (getSide_length() * getSides());}

    @Override
    public long getArea()
    {return Math.round(getSides() * getRadius() * getRadius() * Math.tan(Math.PI/getSides()));}

    public Color getColor(){return m_color;}

    //SET FUNCTIONS
    public void setSides(int N){m_sides = N;}

    public void setRadius(int radius) {m_radius = radius;}

    public Color setColor()
    {
        Random color = new Random();
        Color randomColor = new Color((int)color.nextInt(255),
                (int)color.nextInt(255),
                (int)color.nextInt(255));
        m_color = randomColor;
        return randomColor;
    }

    @Override
    public void moveTo(int delta_x, int delta_y){
        setX(getX() + delta_x);
        setY(getY() + delta_y);
    }

    @Override
    public void distanceTo(int x, int y){
        int x_distance = (getX() - x);
        int y_distance = (getY() - y);
        int distance = (int) Math.sqrt((x_distance * x_distance) + (y_distance * y_distance));
        System.out.printf("%s The distance to coordinate (x,y) is:", distance);
    }

    @Override
    public void getPoint(){
        //return the center point (x,y)
        System.out.printf("%s The x-coordinate is: %n%s The y-coordinate is: ",
                getX(), getY());
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(setColor());
        Polygon a = new Polygon();
        for (int j = 0; j < getSides(); j++)
        {
            a.addPoint((int) (getX() + getRadius() * Math.cos(-Math.PI / 2 + j * 2 * Math.PI / getSides())),
                    (int) (getY() + getRadius() * Math.sin(-Math.PI / 2 + j * 2 * Math.PI / getSides())));
        }
        g.fillPolygon(a);

    }

    @Override
    public boolean doOverlap(int l1, int r1){
        if (l1 > (getX() + getRadius()) || (getX() - getRadius()) > r1) {return false;}
        if (l1 < (getY() + getRadius()) || (getY() - getRadius()) < r1) {return false;}
        return true;
        //return if the left-top (x,y) and right-bottom(x,y) of two objects overlap.
        //by taking two bounding square box.
    }

    @Override
    public void getBoundingBox(Graphics g){
        //draw the bounding box of the polygon
        g.drawRect(getX() - getRadius(), getY() - getRadius(), getRadius() * 2, getRadius() * 2);
    }

}
