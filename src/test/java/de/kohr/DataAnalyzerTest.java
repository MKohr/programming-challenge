package de.kohr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataAnalyzerTest {

    @Test
    void weatherTest(){
        DataAnalyzer t;
        try {
            t = new DataAnalyzer("src/main/resources/de/exxcellent/challenge/weather.csv");
            String answer = t.getSmallestDistance("MxT","MnT","Day");
            assertEquals(answer, "14");
        } catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }


    }

}
