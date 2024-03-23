import CommandFiles.CommandInvoker;
import CommandFiles.Commands.Command;
import CommandFiles.Factory.CommandFactory;
import FileSystem.Collections.FileSystemCollection;
import FileSystem.FileLib;
import FileSystem.Navigators.FileSystemNavigator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileLib root = FileSystemCollection.getExampleFileSystem();

        FileSystemNavigator fileSystemNavigator = new FileSystemNavigator(root);

        CommandInvoker commandInvoker = new CommandInvoker();
        CommandFactory commandFactory = new CommandFactory(fileSystemNavigator);

        Scanner scanner = new Scanner(System.in);
        String commandString;
        Command currentCommand;

        while(true){

            System.out.print(fileSystemNavigator.getCurrentPath() + ": ");
            commandString = scanner.nextLine().trim();

            if(commandString.equals("exit")){
                System.out.println("Exiting the program.");
                break;
            }
            currentCommand = commandFactory.getCommandFromString(commandString);

            commandInvoker.setCommand(currentCommand);
            commandInvoker.executeCommand();

        }
        scanner.close();
    }
}