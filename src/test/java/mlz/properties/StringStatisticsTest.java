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

    @Test
    public void correctlyCountsLettersInAnOtherString() throws Exception {

        Map<String, Integer> counts = StringStatistics.histogram("abc");
        assertEquals(new Integer(1), counts.get("a"));
        assertEquals(new Integer(1), counts.get("c"));
        assertEquals(new Integer(1), counts.get("b"));
    }

    @Test
    public void correctlyCountsLettersInAabbcde() throws Exception {

        Map<String, Integer> counts = StringStatistics.histogram("aabbcde");
        assertEquals(new Integer(2), counts.get("a"));
        assertEquals(new Integer(2), counts.get("b"));
        assertEquals(new Integer(1), counts.get("c"));
        assertEquals(new Integer(1), counts.get("d"));
        assertEquals(new Integer(1), counts.get("e"));
    }





}