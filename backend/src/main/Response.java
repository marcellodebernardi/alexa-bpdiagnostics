package main;

import java.util.Map;
import java.util.TreeMap;

/**
 * Represents the response field within a json response.
 *
 * @author Marcello De Bernardi
 */
class Response {
    private Map<String, Object> response;

    Response() {
        response = new TreeMap<>();
    }

    /**
     * Generates the map used for the outputSpeech field within the response field.
     *
     * @param type todo
     * @param text todo
     * @param ssml todo
     * @return outputSpeech field
     */
    Response outputSpeech(String type, String text, String ssml) {
        Map<String, Object> outputSpeech = new TreeMap<>();

        outputSpeech.put("type", type);
        outputSpeech.put("text", text);
        outputSpeech.put("ssml", ssml);

        response.put("outputSpeech", outputSpeech);
        return this;
    }

    /**
     * Returns the response body's content.
     *
     * @return response body
     */
    Map<String, Object> out() {
        return response;
    }
}
