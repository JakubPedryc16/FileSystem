package FileSystem;

import java.util.List;

public abstract class File implements FileLib {
    protected String name;
    protected FileLib parent;

    @Override
    public String getPath() {

        StringBuilder pathBuilder = new StringBuilder(name);
        FileLib current = this;

        while(current.getParent() != null){
            current = current.getParent();

            pathBuilder.insert(0, "/");
            pathBuilder.insert(0, current.getName());

        }
        return pathBuilder.toString();
    }

    @Override
    public FileLib getParent() {
        return parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public FileLib getChildByName(String name) {
        return null;
    }

    @Override
    public List<FileLib> getChildren() {
        return null;
    }

    @Override
    public String getContent() {
        return null;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void removeFile() {
        if(getParent() != null){
            getParent().getChildren().remove(this);
        }
    }

    @Override
    public void setParent(FileLib parent) {
        this.parent = parent;
    }
}
