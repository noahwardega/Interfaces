import java.awt.*;

public class BigRectangleFilter implements Filter{
    @Override
    public boolean accept(Object x) {
        if (x instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) x;
            return (2 * (rectangle.getWidth() + rectangle.getHeight())) > 10;
        }
        return false;
    }
}

