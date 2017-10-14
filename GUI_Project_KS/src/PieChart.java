import java.awt.*;
import java.util.Random;

/*
 * Created by Gor on 7/11/2017.
 */

public class PieChart  {
    private Color arc_color;
    private int m_start_angle;
    private int m_angle;
    private int m_x, m_y, m_radius, m_width, m_height;
    private int n_arc;

    //CONSTRUCTOR
    public PieChart(int x, int y, int radius, Color color, int width, int height, int start_angle, int arc){
        this.m_x =x;
        this.m_y = y;
        this.m_radius = radius;
        this.arc_color = color;
        this.m_width = width;
        this.m_height = height;
        this.m_start_angle = start_angle;
        this.n_arc = arc;

    }

    public void setAngle(int angle) {m_angle = angle;}

    public void setStartAngle(int angle) {m_start_angle = angle;}

    public int getRadius() {return m_radius;}

    public int getAngle() {return m_angle;}

    public int getnumArc() {return n_arc;}

    public int getWidth() {return m_width;}

    public int getHeight() {return m_height;}

    public int getStartAngle() {return m_start_angle;}

    public Color setColor()
    {
        Random ran_color = new Random();
        Color randomColor = new Color((int)ran_color.nextInt(255),
                (int)ran_color.nextInt(255),
                (int)ran_color.nextInt(255));
        arc_color = randomColor;
        return randomColor;
    }

    public void draw(Graphics g)
    {
        //DRAW THE OUTBOUND CIRCLE
        g.setColor(Color.black);
        g.drawOval((getWidth() - getHeight())/2, 100,getHeight() - 100, getHeight() - 100);
        HistogramLetters test1 = new HistogramLetters(getnumArc());
        test1.openFile();
        test1.readFile();     //READ THE FILE AND GET THE DATA FOR DRAWING ARCS
        double event = 1;    //INITIALIZING EVENT = 1
        int sumAngle = 360;  //INITIALIZING FULL CIRCLE = 360 DEGREES

        for (int i = 0; i < test1.getSize(); i++)
        {
            int angle = (int)(test1.getProb(i) * 360);

            event = event - test1.getProb(i);          //CALCULATE FOR OTHER EVENTS
            sumAngle = sumAngle - angle;               //CALCULATE THE ANGLE FOR OTHER EVENTS

            setAngle(angle);
            g.setColor(setColor());
            g.fillArc((getWidth() - getHeight())/2, 100, getHeight() - 100,
                    getHeight() - 100, getStartAngle(), getAngle());

            String result = test1.getLetterIndex(i) + ", " + test1.getProb(i);

            //SET FONT
            Font f = new Font("Serif", Font.BOLD, 18);
            g.setFont(f);

            //SET DRAWSTRING (OCCURRENCE)
            int drawStringAngle = getStartAngle() + (getAngle() / 2);
            if(drawStringAngle < 90 && drawStringAngle > 0)         //0 < X < 90
            {
                g.drawString(result, m_x + (int) (m_radius * Math.cos(Math.toRadians(drawStringAngle))) - 100,
                        m_y - (int) (m_radius * Math.sin(Math.toRadians(drawStringAngle))) + 60);

            }
            else if (drawStringAngle < 180 && drawStringAngle > 90) //90 < X < 180
            {
                g.drawString(result, m_x + (int) (m_radius * Math.cos(Math.toRadians(drawStringAngle))) - 60,
                        m_y - (int) (m_radius * Math.sin(Math.toRadians(drawStringAngle))) + 60);
            }

            else if (drawStringAngle < 270 && drawStringAngle > 180)//180 < X < 270
            {
                g.drawString(result, m_x + (int) (m_radius * Math.cos(Math.toRadians(drawStringAngle))) - 80,
                        m_y - (int) (m_radius * Math.sin(Math.toRadians(drawStringAngle))));
            }
            else                                                    //270 < X < 360
                {
                    g.drawString(result, m_x + (int) (m_radius * Math.cos(Math.toRadians(drawStringAngle))) - 80,
                            m_y - (int) (m_radius * Math.sin(Math.toRadians(drawStringAngle))) - 30);
                }

            setStartAngle(getStartAngle() + getAngle());
        }

        g.setColor(Color.black);
        String other_events =  "Others, " + Math.round(event * 10000.0)/10000.0;
        int drawFinalAngle = getStartAngle() + (sumAngle / 2);

        //SET DRAWSTRING (OTHER EVENTS)
        if(drawFinalAngle < 90 && drawFinalAngle > 0)
        {
            g.drawString(other_events, m_x + (int) (m_radius * Math.cos(Math.toRadians(drawFinalAngle))) - 100,
                    m_y - (int) (m_radius * Math.sin(Math.toRadians(drawFinalAngle))) + 60);
        }
        else if (drawFinalAngle < 180 && drawFinalAngle > 90)
        {
            g.drawString(other_events, m_x + (int) (m_radius * Math.cos(Math.toRadians(drawFinalAngle))) - 60,
                    m_y - (int) (m_radius * Math.sin(Math.toRadians(drawFinalAngle))) + 60);
        }
        else if (drawFinalAngle < 270 && drawFinalAngle > 180)
        {
            g.drawString(other_events, m_x + (int) (m_radius * Math.cos(Math.toRadians(drawFinalAngle))) - 80,
                    m_y - (int) (m_radius * Math.sin(Math.toRadians(drawFinalAngle))));
        }
        else
        {
            g.drawString(other_events, m_x + (int) (m_radius * Math.cos(Math.toRadians(drawFinalAngle))) - 80,
                    m_y - (int) (m_radius * Math.sin(Math.toRadians(drawFinalAngle))) - 30);
        }
    }
}
