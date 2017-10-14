import java.awt.*;
import java.util.Random;

/**
 * Created by Gor on 7/08/2017.
 */
public class Oval extends Shape {
    private Color m_color;
    private int m_width;
    private int m_height;

    public Oval(int x, int y, Color color, int width, int height){
        super(x,y,color);
        this.m_width = width;
        this.m_height = height;
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
        System.out.printf("%s The x-coordinate is: %n%s The y-coordinate is: ",
                getX(), getY());
    }

    public int getHeight() {return m_height;}

    public int getWidth() {return m_width;}

    public Color getColor() {return m_color;}

    @Override
    public long getArea(){
        return Math.round(((getWidth() / 2) * (getHeight() / 2) * Math.PI));
    }

    @Override
    public long getPerimeter(){
        int a = getWidth() / 2;
        int b = getHeight() / 2;
        return (Math.round((2 * Math.PI) * Math.sqrt( ((a * a) + (b * b)) /2 )));
    }

    @Override
    public void getBoundingBox(Graphics g){
        // return the bounding box of the Oval
        g.drawRect(getX() - (getWidth()/2), getY() - (getHeight()/2), getWidth(), getHeight());
    }

    @Override
    public boolean doOverlap(int l1, int r1){
        int a = getWidth() / 2;
        int b = getHeight() / 2;
        if (l1 > (getX() + a) || (getX() - a) > r1) {return false;}
        if (l1 < (getY() + b) || (getY() - b) < r1) {return false;}
        return true;
        //return if the left-top (x,y) and right-bottom(x,y) of two objects overlap.
        //by taking two bounding rectangle box.
    }


    public void setWidth(int width) {m_width = width;}

    public void setHeight(int height) {m_height = height;}

    public Color setColor()
    {
        Random ran_color = new Random();
        Color randomColor = new Color((int)ran_color.nextInt(255),
                (int)ran_color.nextInt(255),
                (int)ran_color.nextInt(255));
        m_color = randomColor;
        return randomColor;
    }

    @Override
    public void draw(Graphics g)
    {
        setWidth((int)Math.round(getWidth() * Math.sin(Math.PI/4)));    //set the new width of the inscribed Oval
        setHeight((int)Math.round(getHeight() * Math.cos(Math.PI/4)));  //set the new height of the inscribed Oval
        g.setColor(setColor());
        g.fillOval(getX() - (getWidth()/2), getY() - (getHeight()/2), getWidth(), getHeight());
    }

}
