package mlz.properties;


import java.util.HashMap;
import java.util.Map;

public class StringStatistics {
    public static Map<String,Integer> histogram(String input) {
        Map<String, Integer> histogram = new HashMap<>();

        for (int i = 0;i <input.length(); i++){
            String c = String.valueOf(input.charAt(i));
            if(histogram.putIfAbsent(c, 1) != null){
                histogram.replace(c, histogram.get(c) + 1);
            }
        }
        return histogram;
    }

}
