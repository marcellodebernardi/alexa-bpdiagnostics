package apis;

import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.GooglePlacesInterface;
import se.walkercrou.places.Place;

import java.util.List;

/**
 * @author Marcello De Bernardi
 */
public class GoogleMapsWrapper {
    // hardcoded for simplicity
    private final double latitude = 51.513668;
    private final double longitude = -0.225236;

    private GooglePlaces client;

    public GoogleMapsWrapper() {
        client = new GooglePlaces("AIzaSyCYmiKxS_5LWtba1KhWfwmNL3LI1aZSmIg");
    }

    /**
     * Returns a mechanic suggestion to be given by alexa.
     * @return mechanic suggestion
     */
    public String getMechanicSuggestion() {
        List<Place> places = client.getPlacesByQuery("mechanic white city london",
                GooglePlacesInterface.DEFAULT_RESULTS);

        return places.get(0).getName() + " at " + places.get(0).getAddress();
    }
}
