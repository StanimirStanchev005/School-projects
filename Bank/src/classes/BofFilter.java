package classes;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class BofFilter extends FileFilter{

    public BofFilter() {
    }

    @Override
    public boolean accept(File f) {
        if(f.isDirectory() || f.getName().toLowerCase().endsWith(".bof")) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String getDescription() {
        return "Bank Object File";
    }
}