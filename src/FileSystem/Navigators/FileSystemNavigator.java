package FileSystem.Navigators;

import FileSystem.FileLib;

public class FileSystemNavigator {
    private final FileLib rootFile;
    private FileLib currentFile;

    public FileSystemNavigator(FileLib rootFile) {
        this.rootFile = rootFile;
        this.currentFile = rootFile;
    }

    public void setCurrentFile(FileLib currentFile) {
        this.currentFile = currentFile;
    }

    public FileLib getCurrentFile() {
        return this.currentFile;
    }
    public FileLib getRootFile(){
        return this.rootFile;
    }

    public String getCurrentPath(){
        return currentFile.getPath();
    }
}
