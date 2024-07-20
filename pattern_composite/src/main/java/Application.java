import fs.File;
import fs.Folder;

public class Application {
    public static void main(String[] args) {
        Folder root = new Folder("Root");
        root.add(new File("java.txt"));
        root.add(new File("pom.xml"));
        root.afficher();
        Folder src = (Folder) root.add(new Folder("config"));
        src.add(new File("config.js"));
        src.add(new File("config2.js"));

        src.afficher();
    }
}
