package CommandFiles.Factory;

import CommandFiles.Commands.*;
import FileSystem.Navigators.FileSystemNavigator;

public class CommandFactory {
    private final FileSystemNavigator fileSystemNavigator;
    public CommandFactory( FileSystemNavigator fileSystemNavigator){
        this.fileSystemNavigator = fileSystemNavigator;
    }
    public Command getCommandFromString(String commandStr){
        String[] commandParts = commandStr.split("\\s",2);
        String commandType = commandParts[0].toLowerCase();
        String commandArgument = commandParts.length > 1 ? commandParts[1] : "";

        switch (commandType){
            case "cd" -> {
                return new CdCommand(commandArgument, fileSystemNavigator);
            }
            case "cp" -> {
                return new CpCommand(commandArgument, fileSystemNavigator);
            }
            case "ls" -> {
                return new LsCommand(commandArgument, fileSystemNavigator);
            }
            case "mkdir" -> {
                return new MkdirCommand(commandArgument, fileSystemNavigator);
            }
            case "more" -> {
                return new MoreCommand(commandArgument, fileSystemNavigator);
            }
            case "mv" -> {
                return new MvCommand(commandArgument, fileSystemNavigator);
            }
            case "rm" -> {
                return new RmCommand(commandArgument, fileSystemNavigator);
            }
            case "touch" -> {
                return new TouchCommand(commandArgument, fileSystemNavigator);
            }
            default -> {
                return null;
            }
        }
    }
}
