package mlz.properties;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;


public class StringStatisticsTest {
    @Test
    public void returnsNonNullMap() throws Exception {
        Map<String, Integer> counts = StringStatistics.histogram("aabbcde");
        assertNotNull(counts);
    }

    @Test
    public void countLettersInNonEmptyString(){
        Map<String, Integer> counts = StringStatistics.histogram("aaa");
        assertEquals(new Integer(3), counts.get("a"));

    }







}