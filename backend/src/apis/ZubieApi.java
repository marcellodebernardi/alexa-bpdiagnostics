package apis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Wraps API calls for the API we will use.
 * <p>
 * API details:
 * <p>
 * Marcello De Bernardi
 * marcello1234@live.co.uk
 * Z00bi3_is_c00l
 *
 * @author Marcello De Bernardi
 */
public class ZubieApi {
    private static List<String> problems = new ArrayList<>();


    public static String getDiagnostics() {
        return "poo poo poo";
    }

    public static String getProblemList() {
        return problems.stream().collect(Collectors.joining(""));
    }
}
