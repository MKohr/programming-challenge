package de.kohr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Stream;

public class CSVDataStream implements DataStream {
    private Stream<String> data;
    private String[] order;


    /**
     * Does not Check for validity of .csv.
     *
     * @param csvSource Relative or direct path to a CSV file, does not check for correctness of csv format
     * @throws java.io.IOException
     */
    CSVDataStream(String csvSource) throws java.io.IOException{
        BufferedReader csvReader = new BufferedReader(new FileReader(csvSource));
        order = csvReader.readLine().split(",");
        data = csvReader.lines();
    }

    @Override
    public Stream<String[]> getData() {
        return data.skip(1).parallel().map(line -> line.split(","));
    }

    @Override
    public String[] getOrder() {
        return order;
    }
}
