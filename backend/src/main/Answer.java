package main;

/**
 * Created by joantsomw on 6/17/17.
 */
public class Answer {

    private int numberOfProblem;
    private String problems;
    private String name;
    private String email;
    protected final String end = "Thank you for using the free car diagnostic service!" +
                                 "Hope to see you next time!";
    protected final String stage1 = "Please plug the cable into your car.";
    protected final String stage2 = "Running car diagnostic. Please wait.";
    protected final String noProblemstage3 = "Prefect! You car doesn't have any problems" + end;
    protected String problemstage3 = "There are " + numberOfProblem + " in your car. " +
                                           "They are " + problems;
    protected final String stage4 = "There are more problems in your car which cannot be all listed. " +
                                    "You can print it out later.";
    protected final String yesStage5 = "Where, what time and date would you like to have your appointment?";
    protected final String noStage5 = "Would you like to print the diagnostic?";
    protected final String stage6 = "What is your name?";
    protected String stage7 = "Your name is " + name + " Is it correct?";
    protected final String stage8 = "Would you like to print your appointment and diagnostic?";
    protected final String stage9 = "Would you like your appointment to be sent to your email";
    protected final String stage10 = "What is your email?";
    protected final String stage11 = "Your email is " + email;

    public void setNumberOfProblem(int numberOfProblem) {
        this.numberOfProblem = numberOfProblem;
    }

    public void setProblems(String problems) {
        this.problems = problems;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
