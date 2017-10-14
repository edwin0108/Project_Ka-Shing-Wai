import java.awt.*;

/**
 * Created by Gor on 7/8/2017.
 */
public interface ShapePositionInterface extends PositionInterface, ShapeInterface {
    boolean doOverlap(int l1, int r1);

    void getBoundingBox(Graphics g);

}
