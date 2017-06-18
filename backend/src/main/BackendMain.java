package main;

import apis.GoogleMapsApi;
import apis.StationFinderApi;
import apis.ZubieApi;
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


        switch (parser.getIntent()) {
            // request diagnosis
            case getDiagnostics:
                return getDiagnostics();
            // request listing problems
            case listProblems:
                return listProblems();
            // request making appointment
            case makeAppointment:
                return makeAppointment();
            // provide details in slots
            case provideAppointmentDetails:
                return provideAppointmentDetails();
            // print appointment details to user
            case print:
                return print();
            // email details to user
            case email:
                return email();
            // user asks for nearest BP station
            case nearestStation:
                return getNearestStation();
            // user asks for nearest mechanic
            case nearestMechanic:
                return getNearestMechanic();
            // other cases
            default:
                return undefinedIntent();
        }


        /* general form of response, see documentation for validity requirements

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

        */
    }


    /**
     * INTENT HANDLER: handles the initial intent that initiates the interactions.
     *
     * @return response
     */
    private Map<String, Object> getDiagnostics() {
        return responder.
                version("1.0")
                .response(new Response()
                        .outputSpeech("SSML", null, ZubieApi.getDiagnostics())
                        .shouldEndSession(false))
                // reprompt, card, directives?
                .getJsonResponse();
    }

    /**
     * INTENT HANDLER: handles a request to list problems with vehicle
     *
     * @return response
     */
    private Map<String, Object> listProblems() {
        return responder
                .version("1.0")
                .response(new Response()
                        .outputSpeech("SSML", null, ZubieApi.getProblemList())
                        .shouldEndSession(false))
                .getJsonResponse();
    }

    /**
     * INTENT HANDLER: handles a request to make a mechanic appointment
     *
     * @return response
     */
    private Map<String, Object> makeAppointment() {
        return responder
                .version("1.0")
                .response(new Response()
                        .outputSpeech("SSML", null, "")
                        .shouldEndSession(false))
                .getJsonResponse();
    }

    /**
     * INTENT HANDLER: handles a request to provide appointment details
     *
     * @return response
     */
    private Map<String, Object> provideAppointmentDetails() {

        // todo code to create appointment? Not really needed + what would it even be

        return responder
                .version("1.0")
                .response(new Response()
                        .outputSpeech("SSML", null, "I have created an appointment.")
                        .shouldEndSession(false))
                .getJsonResponse();

    }

    /**
     * INTENT HANDLER: handles a request to print details for the appointment
     *
     * @return response
     */
    private Map<String, Object> print() {
        return responder
                .version("1.0")
                .response(new Response()
                        .outputSpeech("SSML", null, "Here's your receipt. Goodbye!")
                        .shouldEndSession(false))
                .getJsonResponse();
    }

    /**
     * INTENT HANDLER: handles a request to have appointment details emailed to user
     *
     * @return response
     */
    private Map<String, Object> email() {
        return responder
                .version("1.0")
                .response(new Response()
                        .outputSpeech("SSML", null, "I have emailed you the details. Goodbye!")
                        .shouldEndSession(false))
                .getJsonResponse();
    }

    /**
     * INTENT HANDLER: handles requests for the closest gas station
     * @return response
     */
    private Map<String, Object> getNearestStation() {
        return responder
                .version("1.0")
                .response(new Response()
                        .outputSpeech("SSML", null, StationFinderApi.getClosestStation().get(0))
                        .shouldEndSession(false))
                .getJsonResponse();
    }

    /**
     * INTENT HANDLER: handles requests for the closest mechanic
     * @return response
     */
    private Map<String, Object> getNearestMechanic() {
        return responder
                .version("1.0")
                .response(new Response()
                        .outputSpeech("SSML", null, GoogleMapsApi.getMechanicSuggestion(0,0))
                        .shouldEndSession(false))
                .getJsonResponse();
    }

    /**
     * Handles a case where an unknown/undefined intent is received. Not sure if this is even
     * possible with Alexa.
     *
     * @return response
     */
    private Map<String, Object> undefinedIntent() {
        return responder
                .version("1.0")
                .response(new Response()
                        .outputSpeech("SSML", null, "I'm sorry, I didn't understand that.")
                        .shouldEndSession(false))
                .getJsonResponse();
    }
}
