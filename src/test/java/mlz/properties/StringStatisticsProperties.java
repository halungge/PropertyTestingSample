package mlz.properties;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.Map;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class StringStatisticsProperties {
    @Property(trials=200)
    public void allLettersInStringAreContainedInHistogram(String input){
        Map<String, Integer> histogram = StringStatistics.histogram(input);
        for(int i = 0; i < input.length(); i++){
            String letter = String.valueOf(input.charAt(i));
            assertTrue(histogram.get(letter) > 0);
        }

    }



}