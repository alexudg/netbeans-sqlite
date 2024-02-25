package main;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro Ramirez Macias
 * @since 2024
 * 
 */
public class Message {
    
    /**
     * @param txt : text of error
     */
    public static void showError(String txt) {
        JOptionPane.showMessageDialog(null, txt, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * @param txt : text of message
     */
    public static void showInformation(String txt) {
        JOptionPane.showMessageDialog(null, txt, "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int showDeleteConfirmation(String subject) {
        // get last character
        String chr = subject.substring(subject.length() - 1);
        
        String txt = "¿Estás segur@ de eliminar";
        txt += chr.equals("o") ? " el " : " la ";
        txt += subject + " seleccionad" + chr + "?"; 
        return JOptionPane.showConfirmDialog(null, txt, "ELIMINAR", JOptionPane.YES_NO_OPTION);
    }
}
