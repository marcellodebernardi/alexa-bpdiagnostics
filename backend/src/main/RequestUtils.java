package main;

import java.util.Map;

/**
 * Static helper class for extracting information from request object.
 *
 * @author Marcello De Bernardi
 */
class RequestUtils {
    /**
     * Returns the intent from the Alexa request.
     *
     * @param request alexa request
     * @return intent
     */
    static Intent getIntent(Map<String, Object> request) {
        Map<String, Object> requestField = (Map<String, Object>) request.get("request");
        Map<String, Object> intent = (Map<String, Object>) requestField.get("intent");

        return Intent.valueOf(intent.get("name").toString());
    }


}
