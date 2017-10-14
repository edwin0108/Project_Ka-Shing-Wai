/**
 * Created by Gor on 7/08/2017.
 */
import java.awt.*;
import java.util.Random;

public class Rectangle extends Shape {
    private Color re_color;
    private int m_width;
    private int m_height;

    public Rectangle (int x, int y, Color color, int width, int height){
        super(x,y,color);
        this.m_width = width;
        this.m_height = height;
    }

    //GET FUNCTIONS
    public int getHeight() {return m_height;}

    public int getWidth() {return m_width;}

    public Color getColor() {return re_color;}

    @Override
    public long getArea() {return (getWidth() * getHeight());}

    @Override
    public long getPerimeter(){
        return ((getWidth() + getHeight()) * 2);
    }

    @Override
    public void getBoundingBox(Graphics g){
        //return the bounding box of the rectangle
        g.drawRect(getX() - (getWidth()/2), getY() - (getHeight()/2), getWidth(), getHeight());
    }

    @Override
    public void getPoint(){
        // return the center point(x,y)
        System.out.printf("%s The x-coordinate is: %n%s The y-coordinate is: ",
                getX(), getY());
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

    //SET FUNCTIONS
    public void setWidth(int width) {m_width = width;}

    public void setHeight(int height) {m_height = height;}

    public Color setColor()
    {
        Random ran_color = new Random();
        Color randomColor = new Color((int)ran_color.nextInt(255),
                (int)ran_color.nextInt(255),
                (int)ran_color.nextInt(255));
        re_color = randomColor;
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
    public void draw(Graphics g)
    {
        setWidth((int)Math.round(getWidth() * Math.cos(Math.PI/4)));    //set the new width of the inscribed rectangle
        setHeight((int)Math.round(getHeight() * Math.sin(Math.PI/4)));  //set the new height of the inscribed rectangle
        g.setColor(setColor());
        g.fillRect(getX() - (getWidth()/2), getY() - (getHeight()/2), getWidth(), getHeight());
    }

}
