package main;

import java.util.Map;

/**
 * Static helper class for extracting information from request object.
 *
 * @author Marcello De Bernardi
 */
class RequestParser {
    private Map<String, Object> request;


    RequestParser(Map<String, Object> request) {
        this.request = request;
    }

    /**
     * Returns the intent from the Alexa request.
     *
     * @return intent
     */
    Intent getIntent() {
        Map<String, Object> requestField = (Map<String, Object>) request.get("request");
        Map<String, Object> intent = (Map<String, Object>) requestField.get("intent");

        return Intent.valueOf(intent.get("name").toString());
    }

    /**
     * Gets the session Id for the request.
     *
     * @return sessionId
     */
    String getSessionId() {
        Map<String, Object> session = (Map<String, Object>) request.get("session");

        return session.get("sessionId").toString();
    }

    /**
     * Gets the application Id for the request.
     *
     * @return applicationId
     */
    String getApplicationId() {
        Map<String, Object> session = (Map<String, Object>) request.get("session");
        Map<String, Object> application = (Map<String, Object>) session.get("application");

        return application.get("applicationId").toString();
    }

    /**
     * Gets the userId for the request.
     *
     * @return userId
     */
    String getUserId() {
        Map<String, Object> session = (Map<String, Object>) request.get("session");
        Map<String, Object> user = (Map<String, Object>) session.get("user");

        return user.get("userId").toString();
    }

    /**
     * Gets the requestId for the request.
     *
     * @return requestId
     */
    String getRequestId() {
        Map<String, Object> requestField = (Map<String, Object>) request.get("request");

        return requestField.get("requestId").toString();
    }


}
