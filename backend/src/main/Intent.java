package main;

/**
 * @author Marcello De Bernardi
 */
enum Intent {
    getDiagnostics,             // checks api for diagnostics, state all good or state problems found
    listProblems,               // lists problems, ask if wants to make appointment
    makeAppointment,            // ask alexa to make appointment or reject offer
    provideAppointmentDetails,  // provide details for appointment in slots
    print,                      // print a receipt
    email,                      // email a receipt
    nearestStation,             // get nearest gas station
    nearestMechanic;            // get nearest mechanic

    // more intents, set appointment details
}
