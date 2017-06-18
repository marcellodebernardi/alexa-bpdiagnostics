package apis;


/**
 * @author Marcello De Bernardi
 */
public class GoogleMapsApi {
    public GoogleMapsApi() {}

    /**
     * Returns a mechanic suggestion to be given by alexa.
     * @return mechanic suggestion
     */
    public static String getMechanicSuggestion(int latitude, int longitude) {
        return "White City Transmission, Unigate House, Wood Ln, Shepherd's Bush, London W12 7RP, 020 7041 9913";
    }
}
