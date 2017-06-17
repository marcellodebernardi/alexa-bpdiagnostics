package main;

import apis.GoogleMapsWrapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;


/**
 * @author Marcello De Bernardi
 */
public class BackendMain implements RequestHandler<Map<String, Object>, Map<String, Object>> {
    /**
     * Handles the Alexa skill set trigger. Entry point for application.
     *
     * @param request json request serialized to map
     * @param context context object
     * @return response as map, serialized to json
     */
    @Override
    public Map<String, Object> handleRequest(Map<String, Object> request, Context context) {
        // for handling request and response
        RequestParser parser = new RequestParser(request);
        ResponseBuilder responder = new ResponseBuilder();


        // todo: logic goes here


        // todo build response here
        // general form of response, see documentation for validity requirements
        return responder
                .version("1.0")
                // .sessionAttributes(null)
                .response(new Response()
                        .outputSpeech("SSML", null, new GoogleMapsWrapper().getMechanicSuggestion(0,0))
                        // .reprompt("goo", "byy", "hello")
                        // .card("goo", "boo", "cool", "sometext", null)
                        // .directives()
                        .shouldEndSession(false))
                .getJsonResponse();
    }


    private String getDiagnostics() {
        return null;
    }

    private String setAppointment() {
        return null;
    }
}
