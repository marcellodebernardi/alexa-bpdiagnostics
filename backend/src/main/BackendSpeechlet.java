package main;

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


    @Override
    public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {
        log.info("onSessionStarted requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
                requestEnvelope.getSession().getSessionId());
    }

    @Override
    public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
        log.info("onLaunch requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
                requestEnvelope.getSession().getSessionId());

        return getDiagnostics();
    }

    @Override
    public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
        log.info("onLaunch requestId={}, sessionId={}",
                requestEnvelope.getRequest().getRequestId(),
                requestEnvelope.getSession().getSessionId());

        Intent intent = requestEnvelope.getRequest().getIntent();
        String intentName = (intent != null) ? intent.getName() : null;

        /*
        switch (intentName) {
            // request diagnosis
            case "getDiagnostics":
                return getDiagnostics();
            // request listing problems
            case "listProblems":
                return listProblems();
            // request making appointment
            case "makeAppointment":
                return makeAppointment();
            // provide details in slots
            case "provideAppointmentDetails":
                return provideAppointmentDetails();
            // print appointment details to user
            case "print":
                return print();
            // email details to user
            case "email":
                return email();
            // user asks for nearest BP station
            case "nearestStation":
                return getNearestStation();
            // user asks for nearest mechanic
            case "nearestMechanic":
                return getNearestMechanic();
            // other cases todo amazon defaults
            default:
                return undefinedIntent();
        }*/

        return getDiagnostics();
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
        } else {
            outputSpeech = new PlainTextOutputSpeech();
            ((PlainTextOutputSpeech) outputSpeech).setText(stringOutput);
        }

        if (isRepromptSsml) {
            repromptOutputSpeech = new SsmlOutputSpeech();
            ((SsmlOutputSpeech) repromptOutputSpeech).setSsml(repromptText);
        } else {
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
        return newAskResponse("<speak> That's not how knock knock jokes work! <break time=\"0.3s\" /> Knock knock </speak>",
                true, "Yoooooooo", false);
    }

    /**
     * INTENT HANDLER: handles a request to list problems with vehicle
     *
     * @return response
     */
    private SpeechletResponse listProblems() {
        return null;
    }

    /**
     * INTENT HANDLER: handles a request to make a mechanic appointment
     *
     * @return response
     */
    private SpeechletResponse makeAppointment() {
        return null;
    }

    /**
     * INTENT HANDLER: handles a request to provide appointment details
     *
     * @return response
     */
    private SpeechletResponse provideAppointmentDetails() {

        // todo code to create appointment? Not really needed + what would it even be

        return null;

    }

    /**
     * INTENT HANDLER: handles a request to print details for the appointment
     *
     * @return response
     */
    private SpeechletResponse print() {
        return null;
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
        return null;
    }

    /**
     * INTENT HANDLER: handles requests for the closest mechanic
     *
     * @return response
     */
    private SpeechletResponse getNearestMechanic() {
        return null;
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
