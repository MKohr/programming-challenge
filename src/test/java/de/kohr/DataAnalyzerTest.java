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
            String answer = t.getSmallestDistance("MxT","MnT","Day",false);
            assertEquals(answer, "14");
        } catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }


    }

    @Test
    void FootballTest(){
        DataAnalyzer t;
        try {
            t = new DataAnalyzer("src/main/resources/de/exxcellent/challenge/football.csv");
            String answer = t.getSmallestDistance("Goals Allowed","Goals","Team",true);
            assertEquals(answer, "Aston_Villa");
        } catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }


    }

}
