package CommandFiles.Commands;

import java.util.regex.Pattern;

public class CommandProxy implements Command {
    Command command;
    public CommandProxy(Command command){
        this.command = command;
    }
    @Override
    public void execute() {
        if(command == null){
            System.out.println("Unknown Command");
            return;
        }
        if(isCommandValid()) {
            command.execute();
        }
        else{
            System.out.println("Illegal Character/s Found");
        }
    }

    @Override
    public String getInput() {
        return command.getInput();
    }
    private boolean isCommandValid() {

        String forbiddenChars = "*?!<>|\\$";

        String regex = "[" + Pattern.quote(forbiddenChars) + "]";
        return !Pattern.compile(regex).matcher(command.getInput()).find();
    }
}
