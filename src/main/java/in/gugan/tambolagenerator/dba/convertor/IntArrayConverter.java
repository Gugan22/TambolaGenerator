package in.gugan.tambolagenerator.dba.convertor;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

@Converter
public class IntArrayConverter implements AttributeConverter<int[][], String> {

    private static final String DELIMITER = ",";

    // Converting two-dimensional int array to String
    @Override
    public String convertToDatabaseColumn(int[][] integers) {
        StringBuilder result = new StringBuilder();
        for (int ij = 0, row = 0, col = 0; ij < integers.length * integers[0].length; ++ij) {
            result.append(integers[row][col] + DELIMITER);
            if (++col == integers[0].length) {
                col = 0;
                result.deleteCharAt(result.length() - 1);
                result.append("\n");
                ++row;
            }
        }
        return result.toString();
    }

    // Converting String to two-dimensional int array
    @Override
    public int[][] convertToEntityAttribute(String data) {
        String[] row = data.split("\n");
        int[][] result = new int[row.length][row[0].split(DELIMITER).length];
        for (int i = 0; i < row.length; i++)
            result[i] = Arrays.stream(row[i].split(DELIMITER)).mapToInt(Integer::parseInt).toArray();
        return result;
    }
}
