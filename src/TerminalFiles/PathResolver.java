package TerminalFiles;

import FileSystem.FileLib;
import FileSystem.Navigators.FileSystemNavigator;

public interface PathResolver {
    FileLib findFileByPath(String path, FileSystemNavigator fileSystemNavigator);
    String findNameByPath(String path);
    void setShouldSkipTheLastElement(Boolean shouldFindRegularFile);
}
