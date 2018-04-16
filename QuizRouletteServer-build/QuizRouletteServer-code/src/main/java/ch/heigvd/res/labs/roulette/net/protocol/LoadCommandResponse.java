package ch.heigvd.res.labs.roulette.net.protocol;

/**
 * Created by Maxime on 16.04.18.
 */
public class LoadCommandResponse {

    private String commandStatus;
    private int numberOfNewStudents;



    public LoadCommandResponse() {
    }

    public LoadCommandResponse(String commandStatus, int numberOfNewStudents) {
        this.commandStatus = commandStatus;
        this.numberOfNewStudents = numberOfNewStudents;
    }

    public String getCommandStatus() {
        return commandStatus;
    }

    public void setCommandStatus(String commandStatus) {
        this.commandStatus = commandStatus;
    }

    public int getNumberOfNewStudents() {
        return numberOfNewStudents;
    }

    public void setNumberOfNewStudents(int numberOfNewStudents) {
        this.numberOfNewStudents = numberOfNewStudents;
    }

}
