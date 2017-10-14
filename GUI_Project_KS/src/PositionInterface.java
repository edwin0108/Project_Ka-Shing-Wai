/**
 * Created by Gor on 7/8/2017.
 */
public interface PositionInterface {
    void getPoint();                        //return coordinate(x,y)
    void distanceTo(int x, int y);         //using distance formula
    void moveTo(int delta_x, int delta_y); //move point to (x + delta_x, y + delta_y)
}
