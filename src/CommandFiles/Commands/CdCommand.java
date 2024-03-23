package CommandFiles.Commands;

import FileSystem.FileLib;
import FileSystem.Navigators.FileSystemNavigator;
import TerminalFiles.DirectPathResolver;

public class CdCommand implements Command {
    private final FileSystemNavigator fileSystemNavigator;
    private final String input;
    private final DirectPathResolver pathResolver;
    public CdCommand(String input, FileSystemNavigator fileSystemNavigator){
        this.fileSystemNavigator = fileSystemNavigator;
        this.input = input;
        this.pathResolver = new DirectPathResolver(false);
    }
    @Override
    public void execute() {

        FileLib destinationFile = pathResolver.findFileByPath(input, fileSystemNavigator);
        if(destinationFile != null && destinationFile.getChildren() == null) {
            System.out.println("Not a directory");
            return;
        }
        if(destinationFile == null){
            System.out.println("Directory doesn't exist");
            return;
        }
        fileSystemNavigator.setCurrentFile(destinationFile);
    }

    @Override
    public String getInput() {
        return this.input;
    }
}
