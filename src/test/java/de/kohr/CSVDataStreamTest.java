package de.kohr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVDataStreamTest {

    private DataStream target;

    @BeforeEach
    void setUp() {

        try {
            target = new CSVDataStream("src/main/resources/de/exxcellent/challenge/football.csv");
        } catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }


    @Test
    void orderTest(){
        String[] order = target.getOrder();
        String[] trueOrder = new String[]{"Team","Games","Wins","Losses","Draws","Goals","Goals Allowed","Points"};
        for (int i = 0; i < trueOrder.length; i++) {
            assertTrue(trueOrder[i].equals(order[i]));
        }
    }


}
