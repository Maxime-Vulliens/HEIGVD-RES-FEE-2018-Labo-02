package ch.heigvd.res.labs.roulette.net.protocol;

/**
 * Created by Maxime on 16.04.18.
 */
public class ByeCommandResponse {

    private String commandStatus;
    private int numberOfCommands;

    public ByeCommandResponse() {
    }

    public ByeCommandResponse(String commandStatus, int numberOfCommands) {
        this.commandStatus = commandStatus;
        this.numberOfCommands = numberOfCommands;
    }

    public String getCommandStatus() {
        return commandStatus;
    }

    public void setCommandStatus(String commandStatus) {
        this.commandStatus = commandStatus;
    }

    public int getNumberOfCommands() {
        return numberOfCommands;
    }

    public void setNumberOfCommands(int numberOfCommands) {
        this.numberOfCommands = numberOfCommands;
    }
}
