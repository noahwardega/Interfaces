import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class BigRectLister {
    public static void main(String[] args) {
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(1, 2));    // Perimeter = 6
        rectangles.add(new Rectangle(2, 3));    // Perimeter = 10
        rectangles.add(new Rectangle(3, 4));    // Perimeter = 14
        rectangles.add(new Rectangle(4, 5));    // Perimeter = 18
        rectangles.add(new Rectangle(5, 6));    // Perimeter = 22
        rectangles.add(new Rectangle(1, 1));    // Perimeter = 4
        rectangles.add(new Rectangle(7, 8));    // Perimeter = 30
        rectangles.add(new Rectangle(2, 2));    // Perimeter = 8
        rectangles.add(new Rectangle(9, 10));   // Perimeter = 38
        rectangles.add(new Rectangle(10, 11));  // Perimeter = 42

        Object[] objectArray = rectangles.toArray();

        BigRectangleFilter bigRectangleFilter = new BigRectangleFilter();
        Object[] bigRectangles = Main.collectAll(objectArray, bigRectangleFilter);

        System.out.println("Rectangles with Big Perimeters:");
        for (Object obj : bigRectangles) {
            Rectangle rectangle = (Rectangle) obj; // Cast back to Rectangle
            System.out.println("Perimeter: " + 2 * (rectangle.getWidth() + rectangle.getHeight()) +
                    ", Width: " + rectangle.getWidth() + ", Height: " + rectangle.getHeight());
        }
    }
}


