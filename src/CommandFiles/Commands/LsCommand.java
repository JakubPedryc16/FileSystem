package CommandFiles.Commands;

import FileSystem.FileLib;
import FileSystem.Navigators.FileSystemNavigator;
import TerminalFiles.DirectPathResolver;

public class LsCommand implements Command {
    private final FileSystemNavigator fileSystemNavigator;
    private final String input;
    private final DirectPathResolver pathResolver;
    public LsCommand(String input, FileSystemNavigator fileSystemNavigator){
        this.fileSystemNavigator = fileSystemNavigator;
        this.input = input;
        this.pathResolver = new DirectPathResolver(false);
    }
    @Override
    public void execute() {
        FileLib file = input.trim().equals("") || input.trim().equals(".")
                ? fileSystemNavigator.getCurrentFile()
                : pathResolver.findFileByPath(input, fileSystemNavigator);
        if(file == null){
            System.out.println("File doesn't exist");
            return;
        }
        if(file.getChildren() == null){
            System.out.println("File is not a directory");
            return;
        }
        StringBuilder childrenBuilder = new StringBuilder();
        for (FileLib child : file.getChildren()){
            childrenBuilder.append(child.getName());
            childrenBuilder.append(" ");
        }
        System.out.println(childrenBuilder);
    }

    @Override
    public String getInput() {
        return this.input;
    }
}
