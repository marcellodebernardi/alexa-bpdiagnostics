package main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

/**
 * @author Marcello De Bernardi
 */
public class BackendMain implements RequestHandler<Map<String, Object>, Map<String, Object>> {
    /**
     * Handles the Alexa skill set trigger.
     *
     * @param request json request serialized to map
     * @param context context object
     * @return response as map, serialized to json
     */
    @Override
    public Map<String, Object> handleRequest(Map<String, Object> request, Context context) {
        ResponseBuilder responder = new ResponseBuilder();

        return responder
                .version("1.0")
                .sessionAttributes(null)
                .response(new Response().outputSpeech("goo", "byy", "hello").out())
                .getJsonResponse();
    }
}
