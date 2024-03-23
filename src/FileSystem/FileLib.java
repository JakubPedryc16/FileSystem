package FileSystem;

import java.util.List;

public interface FileLib {
    String getPath();
    FileLib getParent();

    String getName();
    FileLib getChildByName(String name);
    List<FileLib> getChildren();

    FileLib makeACopy(String name, FileLib newParent);
    void addFile(FileLib file);
    void removeFile();
    String getContent();
    void setName(String name);
    void setParent(FileLib parent);
}
