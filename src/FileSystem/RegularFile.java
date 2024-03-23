package FileSystem;

public class RegularFile extends File {

    private final String content;
    public RegularFile(String name, FileLib parent, String content){
        this.content = content;
        this.name = name;
        this.parent = parent;
    }

    @Override
    public void addFile(FileLib file) {
    }

    @Override
    public FileLib makeACopy(String name, FileLib newParent) {
        return new RegularFile(name, newParent, this.content);
    }

    @Override
    public String getContent() {
        return this.content;
    }
}
