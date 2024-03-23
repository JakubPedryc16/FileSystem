package CommandFiles.Commands;


import FileSystem.FileLib;
import FileSystem.Navigators.FileSystemNavigator;
import TerminalFiles.DirectPathResolver;

public class RmCommand  implements Command{
    private final FileSystemNavigator fileSystemNavigator;
    private final String input;
    private final DirectPathResolver pathResolver;
    public RmCommand(String input, FileSystemNavigator fileSystemNavigator){
        this.fileSystemNavigator = fileSystemNavigator;
        this.input = input;
        this.pathResolver = new DirectPathResolver(false);
    }
    @Override
    public void execute() {

        FileLib destinationFile = pathResolver.findFileByPath(input, fileSystemNavigator);
        if(destinationFile == null){
            System.out.println("File doesn't exist");
            return;
        }
        destinationFile.removeFile();
    }

    @Override
    public String getInput() {
        return this.input;
    }
}
