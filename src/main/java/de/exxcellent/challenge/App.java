package de.exxcellent.challenge;

import de.kohr.DataAnalyzer;

import java.io.IOException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        try {
            DataAnalyzer da = new DataAnalyzer(args[1]);
            if (args[0].equals("--football")){

                String teamWithSmallestGoalSpread = da.getSmallestDistance("Goals Allowed","Goals","Team",true);
                System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

            } else if (args[0].equals("--weather")){

                String dayWithSmallestTempSpread = da.getSmallestDistance("MxT","MnT","Day",false);
                System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

            }

        } catch (IndexOutOfBoundsException iob){
            System.out.println("Not enough arguments given!");
        } catch (IOException io) {
            System.out.println("Could not find or access given path!");
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
