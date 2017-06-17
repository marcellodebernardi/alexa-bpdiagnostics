package main;

import apis.ZubieApi;
import apis.GoogleMapsApi;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;


/**
 * @author Marcello De Bernardi
 */
public class BackendMain implements RequestHandler<Map<String, Object>, Map<String, Object>> {
    private ResponseBuilder responder;
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
        responder = new ResponseBuilder();


        switch(parser.getIntent()) {
            case getDiagnostics:
                return getDiagnostics();
            case listProblems:
                return listProblems();
            case makeAppointment:
                return makeAppointment();
            // other cases
        }


        // general form of response, see documentation for validity requirements
        return responder
                .version("1.0")
                // .sessionAttributes(null)
                .response(new Response()
                        .outputSpeech("SSML", null, new GoogleMapsApi().getMechanicSuggestion(0,0))
                        // .reprompt("goo", "byy", "hello")
                        // .card("goo", "boo", "cool", "sometext", null)
                        // .directives()
                        .shouldEndSession(false))
                .getJsonResponse();
    }


    private Map<String, Object> getDiagnostics() {
        return responder.
                version("1.0")
                .response(new Response()
                        .outputSpeech("SSML", null, ZubieApi.getDiagnostics())
                        .shouldEndSession(false))
                // reprompt, card, directives?
                .getJsonResponse();
    }

    private Map<String, Object> listProblems() {
        return responder
                .version("1.0")
                .response(new Response()
                        .outputSpeech("SSML", null, ZubieApi.getProblemList())
                        .shouldEndSession(false))
                .getJsonResponse();
    }

    private Map<String, Object> makeAppointment() {
        return responder
                .version("1.0")
                .response(new Response()
                        .outputSpeech("SSML", null, ZubieApi.getProblemList())
                        .shouldEndSession(false))
                .getJsonResponse();
    }
}
