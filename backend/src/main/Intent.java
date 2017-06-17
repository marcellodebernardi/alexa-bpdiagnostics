package main;

/**
 * @author Marcello De Bernardi
 */
enum Intent {
    getDiagnostics,         // checks api for diagnostics, either say all good or state there are problems
    listProblems,           // lists problems identified by API, ask if wants to make appointment
    makeAppointment;        // ask alexa to make appointment

    // more intents, set appointment details
}
