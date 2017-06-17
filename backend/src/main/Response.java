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
     * @param type Must be either "SSML" or "PlainText"
     * @param text Text to read, use when type is "PlainText"
     * @param ssml Text to read, use when type is "SSML"
     * @return outputSpeech field
     */
    Response outputSpeech(String type, String text, String ssml) {
        Map<String, Object> outputSpeech = new TreeMap<>();

        if (type != null) outputSpeech.put("type", type);
        if (text != null) outputSpeech.put("text", text);
        if (ssml != null) outputSpeech.put("ssml", ssml);

        response.put("outputSpeech", outputSpeech);
        return this;
    }

    /**
     * todo
     *
     * @param type
     * @param title
     * @param content
     * @param text
     * @return
     */
    Response card(String type, String title, String content, String text, ResponseImage image) {
        Map<String, Object> card = new TreeMap<>();

        if (type != null) card.put("type", type);
        if (title != null) card.put("title", title);
        if (content != null) card.put("content", content);
        if (text != null) card.put("text", text);
        if (image != null) card.put("image", image.out());

        response.put("card", card);
        return this;
    }

    /**
     * todo
     *
     * @param type
     * @param text
     * @param ssml
     * @return
     */
    Response reprompt(String type, String text, String ssml) {
        // todo make this sensible
        // if (ssml.length() > 8000) throw new IndexOutOfBoundsException();

        Map<String, Object> reprompt = new TreeMap<>();
        Map<String, Object> outputSpeech = new TreeMap<>();

        if (type != null) outputSpeech.put("type", type);
        if (text != null) outputSpeech.put("text", text);
        if (ssml != null) outputSpeech.put("ssml", ssml);

        reprompt.put("outputSpeech", outputSpeech);
        response.put("reprompt", reprompt);
        return this;
    }


    Response directives() {
        return this;
    }

    /**
     * Specifies whether the session should be ended by this response.
     *
     * @param shouldEndSession true if wish to end session, false otherwise
     * @return response
     */
    Response shouldEndSession(boolean shouldEndSession) {
        response.put("shouldEndSession", shouldEndSession);
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



    static class ResponseImage {
        private Map<String, Object> responseImage;

        ResponseImage(String smallImageUrl, String largeImageUrl) {
            responseImage = new TreeMap<>();
            responseImage.put("smallImageUrl", smallImageUrl);
            responseImage.put("largeImageUrl", largeImageUrl);
        }

        Map<String, Object> out() {
            return responseImage;
        }
    }
}
