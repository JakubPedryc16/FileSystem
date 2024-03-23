package TerminalFiles;

import FileSystem.FileLib;
import FileSystem.Navigators.FileSystemNavigator;

public class DirectPathResolver implements PathResolver {
    private Boolean shouldSkipTheLastElement;
    public DirectPathResolver(Boolean shouldSkipTheLastElement){
        this.shouldSkipTheLastElement = shouldSkipTheLastElement;
    }
    @Override
    public FileLib findFileByPath(String path, FileSystemNavigator fileSystemNavigator) {
        FileLib fileDestination;
        if(path.charAt(0) ==  '/'){
            fileDestination = fileSystemNavigator.getRootFile();

        }
        else {
            fileDestination = fileSystemNavigator.getCurrentFile();
        }
        return resolvePath(path, fileDestination);
    }
    private FileLib resolvePath(String path, FileLib destinationReference){
        String[] pathParts = path.split("/");
        FileLib previousDestination = destinationReference;
        FileLib fileDestination = destinationReference;
        int index = 0;

        for (String pathPart : pathParts) {
            if (pathPart.trim().equals("..")) {
                previousDestination = fileDestination;
                fileDestination = fileDestination.getParent();
            }
            else if (!pathPart.trim().equals("") && !pathPart.trim().equals(".") && !pathPart.trim().equals("root") && fileDestination != null) {
                previousDestination = fileDestination;
                fileDestination = fileDestination.getChildByName(pathPart);
            }
            index += 1;
            if (shouldSkipTheLastElement && pathParts.length == index) {
                return previousDestination;
            }
            else if (fileDestination == null){
                return null;
            }
        }
        return fileDestination;
    }

    @Override
    public String findNameByPath(String path) {
        String[] pathParts = path.split("/");
        int lastElementIndex = pathParts.length - 1;
        if(pathParts[lastElementIndex].equals("")){
            lastElementIndex -= 1;
        }
        String newName = pathParts[lastElementIndex].trim().equals("")
                ?  pathParts[lastElementIndex - 1].trim()
                : pathParts[lastElementIndex].trim();
        if(!newName.equals(".") && !newName.equals("..")){
            return newName;
        }
        else {
            return null;
        }
    }

    @Override
    public void setShouldSkipTheLastElement(Boolean shouldSkipTheLastElement) {
        this.shouldSkipTheLastElement = shouldSkipTheLastElement;
    }

}
