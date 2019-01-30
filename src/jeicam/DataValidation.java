package jeicam;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidation {

    private Pattern StringPattern;
    private Pattern IntegerPattern;
    private final static String STRING_PATTERN_FORMAT = "[a-zA-Z]";
    private final static String INTEGER_PATTERN_FORMAT = "\"^[1-9]\\\\d*$\"";

    public DataValidation() {
        this.StringPattern = Pattern.compile(STRING_PATTERN_FORMAT);
        this.IntegerPattern = Pattern.compile(INTEGER_PATTERN_FORMAT);
    }

    public String[] validateString(@NotNull String[] array) throws DataException {

        if (array.length != 7) {
            throw new DataException("incorrect input format");
        }

        Matcher matcher;

        for (int i = 0; i < 7; i++) {
            if (i >= 0 && i < 3) {
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

