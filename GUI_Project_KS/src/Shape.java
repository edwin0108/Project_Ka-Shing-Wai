import java.awt.*;

/**
 * Created by Gor on 7/08/2017.
 */
public abstract class Shape extends Object implements ShapePositionInterface{

    private int m_x;        //x-coordinate
    private int m_y;        //y-coordinate
    private Color m_color;  //color of the shape

    public Shape(int x, int y, Color color){  //CONSTRUCTOR
        this.m_x = x;
        this.m_y = y;
        this.m_color = Color.white;
    }

    //ABSTRACT METHODS
    public abstract void draw(Graphics g);        // draw function - OVERRIDE

    //GET FUNCTIONS
    public int getX() {return m_x;} //return x-coordinate

    public int getY() {return m_y;} //return y-coordinate

    public Color getColor() {return m_color;} //return color of the shape

    //SET FUNCTIONS
    public void setX(int x) {m_x = x;} //set x-coordinate

    public void setY(int y) {m_y = y;} //set y-coordinate

    public void setColor(Color color) {m_color = color;}

    //MOVE_TO FUNCTION
    public void moveTo(int delta_x, int delta_y)
    {
        m_x += delta_x;
        m_y += delta_y;
    }

}