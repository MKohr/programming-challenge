package de.kohr;

import java.util.stream.Stream;

public interface DataStream {
    /**
     * @return returns the data formatted, one vector at a time
     */
    public Stream<String[]> getData();

    /**
     * @return returns the order and names of the data in vector returned by getData()
     */
    public String[] getOrder();
}
