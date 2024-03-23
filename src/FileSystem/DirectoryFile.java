package FileSystem;

import java.util.ArrayList;
import java.util.List;

public class DirectoryFile extends File {

    List<FileLib> children;
    public DirectoryFile(String name, FileLib parent){
        this.children = new ArrayList<>();
        this.name = name;
        this.parent = parent;
    }
    public DirectoryFile(String name){
        this.children = new ArrayList<>();
        this.name = name;
        this.parent = null;
    }
    @Override
    public FileLib getChildByName(String name){
        if(!children.isEmpty()){
            for( FileLib child : children){
                if(child.getName().equals(name)){
                    return child;
                }
            }
        }
        return null;
    }

    @Override
    public void addFile(FileLib file) {
        children.add(file);
    }

    @Override
    public List<FileLib> getChildren(){
        return children;
    }

    @Override
    public FileLib makeACopy(String name, FileLib newParent) {
        FileLib fileCopy = new DirectoryFile(name, newParent);
        for(FileLib child : this.children){
            fileCopy.getChildren().add(child.makeACopy(child.getName(), newParent));
        }
        return fileCopy;
    }

}
