package de.kohr;

import jdk.jshell.spi.ExecutionControl;

import java.io.IOException;

/**
 * Produces DataStream depending on the source
 */
public class DataStreamFactory {

    /**
     * Tries to parse @src and applies the corresponding specialized constructor
     * @param src source to parse
     * @return the successfull created DataStream Object
     * @throws Exception
     */
    public static DataStream getStream(String src) throws Exception{
        if (src.endsWith(".csv")){
            return getStreamFromCSV(src);
        } else {
            throw new SourceFormatNotSupported("could not interpret Source to DataStream");
        }
    }

    /**
     * @param csvSource path to a valid .csv file
     * @return the DataStream Object
     * @throws IOException
     */
    public static DataStream getStreamFromCSV (String csvSource) throws IOException {
        return new CSVDataStream(csvSource);
    }
}
