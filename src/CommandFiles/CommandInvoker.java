package CommandFiles;

import CommandFiles.Commands.Command;
import CommandFiles.Commands.CommandProxy;

public class CommandInvoker {
    private CommandProxy command;

    public void setCommand(Command command){
        this.command = new CommandProxy(command);
    }
    public void executeCommand(){
        this.command.execute();
    }
}
