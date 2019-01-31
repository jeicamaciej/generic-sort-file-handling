package jeicam;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidation {

    private final static int CSV_LINE_ELEMENTS_NUMBER = 7;
    private final static int CSV_STRING_ELEMENTS_NUMBER = 3;
    private final static String STRING_PATTERN_FORMAT = "[a-zA-Z]";
    private final static String INTEGER_PATTERN_FORMAT = "^[1-9]\\d*$";
    private static Pattern StringPattern = Pattern.compile(STRING_PATTERN_FORMAT);
    private static Pattern IntegerPattern = Pattern.compile(INTEGER_PATTERN_FORMAT);

    public DataValidation() {
    }

    public String[] csvLineArrayValidation(@NotNull String[] array) throws DataException {
        if (array.length != CSV_LINE_ELEMENTS_NUMBER) {
            throw new DataException("incorrect input format");
        }
        Matcher matcher;
        for (int i = 0; i < CSV_LINE_ELEMENTS_NUMBER; i++) {
            if (i < CSV_STRING_ELEMENTS_NUMBER) {
                matcher = StringPattern.matcher(array[i]);
                if (!matcher.matches()) {
                    throw new DataException("incorrect input type");
                }
            } else {
                matcher = IntegerPattern.matcher(array[i]);
                if (!matcher.matches()) {
                    throw new DataException("incorrect input type");
                }
            }
        }
        return array;
    }
}

class DataException extends Exception {
    public DataException(String message) {
        super(message);
    }
}

