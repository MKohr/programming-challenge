package de.kohr;

public class DataAnalyzer {
    private DataStream data;
    public DataAnalyzer(String src) throws Exception {
        data = DataStreamFactory.getStream(src);
    }

    public String getSmallestDistance(String maxColumnName, String minColumnName, String targetColumn){
        return null;
    }
}
