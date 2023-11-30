import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static Object[] collectAll(Object[] objects, Filter filter) {
        List<Object> filteredObjects = new ArrayList<>();
        for (Object obj : objects) {
            if (filter.accept(obj)) {
                filteredObjects.add(obj);
            }
        }
        return filteredObjects.toArray();
    }
}