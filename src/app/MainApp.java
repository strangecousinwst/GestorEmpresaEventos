package app;

import gui.LoginGUI;

/**
 * Main App
 * Esta classe possui o main().
 * 
 * @author joao
 */
public class MainApp {
    
    /**
     * Função Main()
     * @param args
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }
}
