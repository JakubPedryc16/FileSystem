package FileSystem.Collections;

import FileSystem.DirectoryFile;
import FileSystem.File;
import FileSystem.RegularFile;

public abstract class FileSystemCollection {
    // root -> dev, usr, docs
    // dev ->
    // usr -> admin
    //docs -> file.txt
    public static File getExampleFileSystem(){
        File root = new DirectoryFile("root");
        File dev = new DirectoryFile("dev", root);
        File usr = new DirectoryFile("usr", root);
        File admin = new DirectoryFile("admin", usr);
        File docs = new DirectoryFile("docs",root);
        File fileTxt = new RegularFile(
                "file.txt",
                usr,
                "This is and example file\n With some example text\n And nothing more\n" +
                        ".\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n" +
                        ".\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\nEND\n"
        );


        root.addFile(dev);
        root.addFile(usr);
        usr.addFile(admin);
        root.addFile(docs);
        docs.addFile(fileTxt);

        return root;
    }

}
