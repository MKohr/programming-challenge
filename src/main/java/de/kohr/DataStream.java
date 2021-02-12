package de.kohr;

import java.sql.Array;
import java.util.stream.Stream;

public interface DataStream {
    public Stream<String[]> getData();
    public String[] getOrder();
}
