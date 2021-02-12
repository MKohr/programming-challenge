package de.kohr;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class DataAnalyzer {
    private DataStream data;

    public DataAnalyzer(String src) throws Exception {
        data = DataStreamFactory.getStream(src);
    }

    /**
     * Returns the Name of the entry with the minimal difference
     *
     * @param maxColumnName Name of the minuend, only Integer column, note @useAbsolute
     * @param minColumnName Name of the subtrahend, Integer column, note @useAbsolute
     * @param targetColumn Name of the Value to output, as String
     * @param useAbsolute wether to use absolute of difference, makes @maxColumnName and @minColumnName interchangeable
     * @return The Value defined by targetColumn of the smallest distance between maxColumnName and minColumnName
     */
    public String getSmallestDistance(String maxColumnName, String minColumnName, String targetColumn, boolean useAbsolute){
        String[] order = data.getOrder();
        int maxColumnIndex = -1, minColumnIndex = -1, targetColumnIndex = -1;

        for (int i = 0; i < order.length; i++) {
            if (order[i].equals(maxColumnName)) maxColumnIndex = i;
            if (order[i].equals(minColumnName)) minColumnIndex = i;
            if (order[i].equals(targetColumn)) targetColumnIndex = i;
        }

        //check for data sanity
        if (maxColumnIndex == -1 || minColumnIndex == -1 || targetColumnIndex == -1){
            throw new IndexOutOfBoundsException("Could not match given Names to Table: "
            + (maxColumnIndex == -1 ? maxColumnName : "")
            + (minColumnIndex == -1 ? minColumnName : "")
            + (targetColumnIndex == -1 ? targetColumn : ""));
        }

        String answer = "Could Not find minimum";
        //make variables quasi final for lambda
        int finalTargetColumnIndex = targetColumnIndex;
        int finalMaxColumnIndex = maxColumnIndex;
        int finalMinColumnIndex = minColumnIndex;

        Optional<String> optionalAnswer = data.getData().map(
                (line) -> {
                    int dif = Integer.parseInt(line[finalMaxColumnIndex])-Integer.parseInt(line[finalMinColumnIndex]);
                    if (useAbsolute) dif = Math.abs(dif);
                    return new AbstractMap.SimpleImmutableEntry<String,Integer>(
                        line[finalTargetColumnIndex], dif
                        );}
                )
                .min(Comparator.comparing(AbstractMap.SimpleImmutableEntry::getValue))
                .map(line -> line.getKey());

        //check for answer
        if (optionalAnswer.isPresent()) answer = optionalAnswer.get();
        return answer;
    }
}
