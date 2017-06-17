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

        // general form of response
        return responder
                .version("1.0")
                .sessionAttributes(null)
                .response(new Response()
                        .outputSpeech("goo", "byy", "hello")
                        .reprompt("goo", "byy", "hello")
                        .card("goo", "boo", "cool", "sometext",
                                new Response.ResponseImage("smallUrl", "largeUrl"))
                        .directives()
                        .shouldEndSession(false))
                .getJsonResponse();
    }
}
