package main;

import com.amazon.speech.speechlet.SpeechletV2;
import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marcello De Bernardi
 */
public class DiagnosticsRequestHandler extends SpeechletRequestStreamHandler {
    private static Set<String> supportedApplicationIds;

    static {
        /*
         * This Id can be found on https://developer.amazon.com/edw/home.html#/ "Edit" the relevant
         * Alexa Skill and put the relevant Application Ids in this Set.
         */
        supportedApplicationIds = new HashSet<String>();
        // supportedApplicationIds.add("amzn1.ask.skill.d3b59cbb-1fd4-4732-84fc-7665c33e4fe3");
    }


    public DiagnosticsRequestHandler(SpeechletV2 speechlet, Set<String> supportedApplicationIds) {
        super(speechlet, supportedApplicationIds);
    }

    public DiagnosticsRequestHandler() {
        super(new BackendSpeechlet(), supportedApplicationIds);
    }
}
