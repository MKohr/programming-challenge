package de.kohr;

import jdk.jshell.spi.ExecutionControl;

import java.io.IOException;

public class DataStreamFactory {

    public static DataStream getStream(String src) throws Exception{
        if (src.endsWith(".csv")){
            return getStreamFromCSV(src);
        } else {
            throw new ExecutionControl.NotImplementedException("could not interpret Source to DataStream"); //TODO: write own meaningfull exception
        }
    }

    public static DataStream getStreamFromCSV (String csvSource) throws IOException {
        return new CSVDataStream(csvSource);
    }
}
