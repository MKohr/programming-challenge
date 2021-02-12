package de.kohr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataStreamFactoryTest {

    @Test
    void CSVTest(){
        DataStream t;
        try {
            t = DataStreamFactory.getStream("src/main/resources/de/exxcellent/challenge/football.csv");
        } catch (Exception e){
            assertTrue(false);
        }
    }


}
