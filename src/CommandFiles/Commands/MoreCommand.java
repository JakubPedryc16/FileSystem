package CommandFiles.Commands;

import FileSystem.FileLib;
import FileSystem.Navigators.FileSystemNavigator;
import TerminalFiles.DirectPathResolver;

import java.util.Scanner;

public class MoreCommand  implements Command{
    private final FileSystemNavigator fileSystemNavigator;
    private final String input;
    private final DirectPathResolver pathResolver;
    public MoreCommand(String input, FileSystemNavigator fileSystemNavigator){
        this.fileSystemNavigator = fileSystemNavigator;
        this.input = input;
        this.pathResolver = new DirectPathResolver(false);
    }
    @Override
    public void execute() {
        FileLib destinationFile = pathResolver.findFileByPath(input, fileSystemNavigator);
        if (destinationFile == null || destinationFile.getChildren() != null || destinationFile.getContent() == null) {
            System.out.println("Invalid path or not a regular file");
            return;
        }
        Scanner scanner = new Scanner(destinationFile.getContent());
        int linesDisplayed = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            linesDisplayed++;

            if (linesDisplayed == 20) {
                System.out.print("Press Enter to continue...");
                new Scanner(System.in).nextLine();
                System.out.println();
                linesDisplayed = 0;
            }
        }
        System.out.println();
        scanner.close();
    }

    @Override
    public String getInput() {
        return this.input;
    }
}
