package de.exxcellent.challenge;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests functionality of App
 */
class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void runFootball() {
        App.main("--football", "src/main/resources/de/exxcellent/challenge/football.csv");
        assertEquals("Team with smallest goal spread       : Aston_Villa"+System.lineSeparator(), outContent.toString());
    }

    @Test
    void runWeather() {
        App.main("--weather", "src/main/resources/de/exxcellent/challenge/weather.csv");
        assertEquals("Day with smallest temperature spread : 14"+System.lineSeparator(), outContent.toString());
    }


    @Test
    void runLessParams() {
        App.main( "src/main/resources/de/exxcellent/challenge/weather.csv");
        assertEquals("Not enough arguments given!"+System.lineSeparator(), outContent.toString());
    }

}