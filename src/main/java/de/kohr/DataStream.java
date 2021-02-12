package de.kohr;

import java.sql.Array;
import java.util.stream.Stream;

public interface DataStream {
    public Stream<Object> getData();
    public String[] getOrder();
}
