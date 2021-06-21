/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageSorter;

import java.awt.Component;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author dougthompson
 */
public class Utilities {
    
    public static Path selectDir(Component parent, String fileName) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        Path currPath = null;
        if (fileName != null) {
            currPath = Paths.get(fileName);
        }
        if (currPath != null) {
            chooser.setCurrentDirectory(currPath.toFile());
        }
        int returnValue = chooser.showDialog(parent, "Select Export Destination Directory");
        switch(returnValue) {
            case JFileChooser.CANCEL_OPTION:
                return null;
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(parent, "There was an error", "Error Selecting Directory", JOptionPane.OK_OPTION);
                return null;
            case JFileChooser.APPROVE_OPTION:
                break;
        }
        File fileItem = chooser.getSelectedFile();
        Path newPath = fileItem.toPath();
        
        return newPath;
        
    }
    
    public static boolean isDevelopment() {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        if (currentPath.resolve("dist").toFile().exists()) {
            return true;
        }
        return false;
    }
}
