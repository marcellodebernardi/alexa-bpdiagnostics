package main;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Marcello De Bernardi
 */
class ResponseBuilder {
    private Map<String, Object> jsonResponse;


    ResponseBuilder() {
        jsonResponse = new TreeMap<>();
    }


    /**
     * Returns the generated JSON response.
     *
     * @return json response
     */
    Map<String, Object> getJsonResponse() {
        return jsonResponse;
    }

    /**
     * Adds the version number field to the response object.
     *
     * @param version version number
     * @return this
     */
    ResponseBuilder version(String version) {
        jsonResponse.put("version", version);
        return this;
    }

    /**
     * Adds the session attributes field to the response object.
     *
     * @param sessionAttributes session attributes
     * @return this
     */
    ResponseBuilder sessionAttributes(Map<String, Object> sessionAttributes) {
        jsonResponse.put("sessionAttributes", sessionAttributes);
        return this;
    }

    /**
     * Adds the response field to the response object
     *
     * @param response response body
     * @return this
     */
    ResponseBuilder response(Response response) {
        jsonResponse.put("response", response.out());
        return this;
    }
}
