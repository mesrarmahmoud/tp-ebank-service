package fs;

import java.util.ArrayList;
import java.util.List;

public class File extends Composante{

    public File(String name) {
        super(name);
    }

    @Override
    public void afficher() {

        System.out.println(getTab() + " - Folder => " + name );
    }
}
