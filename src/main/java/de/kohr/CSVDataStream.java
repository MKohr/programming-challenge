package de.kohr;

import java.util.stream.Stream;

public class CSVDataStream implements DataStream {
    @Override
    public Stream<Object> getData() {
        return null;
    }

    @Override
    public String[] getOrder() {
        return new String[0];
    }
}
