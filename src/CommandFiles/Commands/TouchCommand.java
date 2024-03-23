package CommandFiles.Commands;

import FileSystem.FileLib;
import FileSystem.Navigators.FileSystemNavigator;
import FileSystem.RegularFile;
import TerminalFiles.DirectPathResolver;

public class TouchCommand  implements Command{
    private final FileSystemNavigator fileSystemNavigator;
    private final String input;
    private final DirectPathResolver pathResolver;
    public TouchCommand(String input, FileSystemNavigator fileSystemNavigator){
        this.fileSystemNavigator = fileSystemNavigator;
        this.input = input;
        this.pathResolver = new DirectPathResolver(true);
    }
    @Override
    public void execute() {
        FileLib fileDestination = pathResolver.findFileByPath(input, fileSystemNavigator);
        String name = pathResolver.findNameByPath(input);
        if(fileDestination == null || name == null) {
            System.out.println("Invalid Path");
            return;
        }
        for(FileLib file : fileDestination.getChildren()){
            if(name.equals(file.getName())){
                System.out.println("File with that name already exists");
                return;
            }
        }
        fileDestination.addFile(new RegularFile(name, fileDestination, ""));
    }

    @Override
    public String getInput() {
        return this.input;
    }
}
