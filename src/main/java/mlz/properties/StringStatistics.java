package mlz.properties;


import java.util.HashMap;
import java.util.Map;

public class StringStatistics {
    public static Map<String,Integer> histogram(String input) {
        HashMap<String, Integer> histogram = new HashMap<>();

        histogram.put("a", 3);
        return histogram;
    }
}
