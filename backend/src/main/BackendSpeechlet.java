package main;

import apis.StationFinderApi;
import apis.ZubieApi;
import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.OutputSpeech;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SsmlOutputSpeech;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Marcello De Bernardi
 */
public class BackendSpeechlet implements SpeechletV2 {
    private static final Logger log = LoggerFactory.getLogger(BackendSpeechlet.class);
    private static int CONVERSATION_PHASE;


    @Override
    public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {
        log.info("onSessionStarted requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
                requestEnvelope.getSession().getSessionId());

        CONVERSATION_PHASE = 0;
    }

    @Override
    public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
        log.info("onLaunch requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
                requestEnvelope.getSession().getSessionId());

        return null;
        // return getDiagnostics();
    }

    @Override
    public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
        log.info("onLaunch requestId={}, sessionId={}",
                requestEnvelope.getRequest().getRequestId(),
                requestEnvelope.getSession().getSessionId());

        Intent intent = requestEnvelope.getRequest().getIntent();
        String intentName = (intent != null) ? intent.getName() : null;

        switch (intentName) {
            // request diagnosis
            case "getDiagnostics":
                return getDiagnostics();
            // request making appointment
            case "makeAppointment":
                return makeAppointment();
            // provide details in slots
            case "acceptAppointment":
                return acceptAppointment();
            case "goodbye":
                return goodbye();
            // email details to user
            case "nearestStation":
                return getNearestStation();
            // other cases todo amazon defaults
            case "AMAZON.StopIntent":
                PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
                outputSpeech.setText("");
                return SpeechletResponse.newTellResponse(outputSpeech);
            case "AMAZON.HelpIntent":

            default:
                return undefinedIntent();
        }

    }

    @Override
    public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {
        log.info("onSessionEnded requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
                requestEnvelope.getSession().getSessionId());
    }


    /**
     * Wrapper for creating the Ask response from the input strings.
     *
     * @param stringOutput
     *            the output to be spoken
     * @param isOutputSsml
     *            whether the output text is of type SSML
     * @param repromptText
     *            the reprompt for if the user doesn't reply or is misunderstood.
     * @param isRepromptSsml
     *            whether the reprompt text is of type SSML
     * @return SpeechletResponse the speechlet response
     */
    @SuppressWarnings("Duplicates")
    private SpeechletResponse newAskResponse(String stringOutput, boolean isOutputSsml,
                                             String repromptText, boolean isRepromptSsml) {
        OutputSpeech outputSpeech, repromptOutputSpeech;
        if (isOutputSsml) {
            outputSpeech = new SsmlOutputSpeech();
            ((SsmlOutputSpeech) outputSpeech).setSsml(stringOutput);
        }
        else {
            outputSpeech = new PlainTextOutputSpeech();
            ((PlainTextOutputSpeech) outputSpeech).setText(stringOutput);
        }

        if (isRepromptSsml) {
            repromptOutputSpeech = new SsmlOutputSpeech();
            ((SsmlOutputSpeech) repromptOutputSpeech).setSsml(repromptText);
        }
        else {
            repromptOutputSpeech = new PlainTextOutputSpeech();
            ((PlainTextOutputSpeech) repromptOutputSpeech).setText(repromptText);
        }
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(repromptOutputSpeech);

        return SpeechletResponse.newAskResponse(outputSpeech, reprompt);
    }




    /**
     * INTENT HANDLER: handles the initial intent that initiates the interactions.
     *
     * @return response
     */
    private SpeechletResponse getDiagnostics() {
        return newAskResponse("<speak> Welcome to BP vehicle health! I've analyzed your vehicle. " +
                        "It would seem that there is a problem with "
                + ZubieApi.getDiagnostics() + ". Would you like to book an appointment with a mechanic?</speak>",
                true, "<speak>Would you like to book an appointment?</speak>", true);
    }

    /**
     * INTENT HANDLER: handles a request to make a mechanic appointment
     *
     * @return response
     */
    private SpeechletResponse makeAppointment() {
        return newAskResponse("<speak> A nearby BP station currently has available repair appointments for"
                + " tomorrow. The station is " + StationFinderApi.getClosestStation().get(0) + ". Is 2 pm okay?</speak>",
                true, "<speak>Should I make an appointment?</speak>", true);
    }

    /**
     * INTENT HANDLER: handles a request to provide appointment details
     *
     * @return response
     */
    private SpeechletResponse acceptAppointment() {
        return newAskResponse("<speak> The appointment has been added to your Google calendar. Is there " +
                        "anything else I can do for you? </speak>", true,
                "<speak></speak>", true);

    }

    /**
     * INTENT HANDLER: handles a request to have appointment details emailed to user
     *
     * @return response
     */
    private SpeechletResponse email() {
        return null;
    }

    /**
     * INTENT HANDLER: handles requests for the closest gas station
     *
     * @return response
     */
    private SpeechletResponse getNearestStation() {
        return newAskResponse("<speak> The nearest BP station is " + StationFinderApi.getClosestStation().get(0)
                        + ". Can I help you with anything else?</speak>",
                true, "<speak>Anything else I can help you with?</speak>", true);
    }


    private SpeechletResponse goodbye() {
        return newAskResponse("<speak> Goodbye, and remember <break time=\"0.2s\" /> BP cares!</speak>",
                true, "<speak>Thank you!</speak>", true);
    }

    /**
     * Handles a case where an unknown/undefined intent is received. Not sure if this is even
     * possible with Alexa.
     *
     * @return response
     */
    private SpeechletResponse undefinedIntent() {
        return null;
    }
}
