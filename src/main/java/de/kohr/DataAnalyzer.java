package de.kohr;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Optional;

public class DataAnalyzer {
    private DataStream data;
    public DataAnalyzer(String src) throws Exception {
        data = DataStreamFactory.getStream(src);
    }

    public String getSmallestDistance(String maxColumnName, String minColumnName, String targetColumn){
        String[] order = data.getOrder();
        int maxColumnIndex = -1, minColumnIndex = -1, targetColumnIndex = -1;

        for (int i = 0; i < order.length; i++) {
            if (order[i].equals(maxColumnName)) maxColumnIndex = i;
            if (order[i].equals(minColumnName)) minColumnIndex = i;
            if (order[i].equals(targetColumn)) targetColumnIndex = i;
        }

        if (maxColumnIndex == -1 || minColumnIndex == -1 || targetColumnIndex == -1){
            throw new IndexOutOfBoundsException("Could not match given Names to Table: "
            + (maxColumnIndex == -1 ? maxColumnName : "")
            + (minColumnIndex == -1 ? minColumnName : "")
            + (targetColumnIndex == -1 ? targetColumn : ""));
        }

        String answer = "Could Not find minimum";
        int finalTargetColumnIndex = targetColumnIndex;
        int finalMaxColumnIndex = maxColumnIndex;
        int finalMinColumnIndex = minColumnIndex;

        Optional<String> optionalAnswer = data.getData().map(
                (line) -> {return new AbstractMap.SimpleImmutableEntry<String,Integer>(
                        line[finalTargetColumnIndex],
                        Integer.parseInt(line[finalMaxColumnIndex])-Integer.parseInt(line[finalMinColumnIndex]));}
                )
                .min((lhs, rhs)->lhs.getValue().compareTo(rhs.getValue()))
                .map(line -> line.getKey());

        if (optionalAnswer.isPresent()) answer = optionalAnswer.get();
        return answer;
    }
}
