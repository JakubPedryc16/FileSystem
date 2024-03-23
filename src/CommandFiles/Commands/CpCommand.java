package CommandFiles.Commands;

import FileSystem.FileLib;
import FileSystem.Navigators.FileSystemNavigator;
import TerminalFiles.DirectPathResolver;

public class CpCommand implements Command{
    private final FileSystemNavigator fileSystemNavigator;
    private final String input;
    private final DirectPathResolver pathResolver;
    public CpCommand(String input, FileSystemNavigator fileSystemNavigator){
        this.fileSystemNavigator = fileSystemNavigator;
        this.input = input;
        this.pathResolver = new DirectPathResolver(false);
    }
    @Override
    public void execute() {
        String[] commandParts = input.split("\\s");
        FileLib fileSource;
        FileLib fileDestination;
        String newName;

        if(commandParts.length != 2){
            System.out.println("Invalid cp syntax (cp source destination)\n");
            return;
        }

        fileSource = pathResolver.findFileByPath(commandParts[0], fileSystemNavigator);
        if(fileSource == null){
            System.out.println("Invalid path, files doesn't exit\n");
            return;
        }

        fileDestination = pathResolver.findFileByPath(commandParts[1], fileSystemNavigator);
        newName = fileSource.getName();

        if(fileDestination == null || fileDestination.getChildren() == null) {
            pathResolver.setShouldSkipTheLastElement(true);
            fileDestination = pathResolver.findFileByPath(commandParts[1], fileSystemNavigator);

            if(fileDestination == null){
                System.out.println("Invalid path, files doesn't exist\n");
                return;
            }

            newName = pathResolver.findNameByPath(commandParts[1]);
            if(newName == null){
                System.out.println("Unable to get new name\n");
                return;
            }
        }

        for(FileLib file : fileDestination.getChildren()){
            if(newName.equals(file.getName())){
                System.out.println("File with that name already exists");
                return;
            }
        }
        fileDestination.getChildren().add(fileSource.makeACopy(newName, fileDestination));

    }
    @Override
    public String getInput() {
        return this.input;
    }
}
