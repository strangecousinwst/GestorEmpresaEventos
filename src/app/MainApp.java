/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import gui.Login;

/**
 *
 * @author joao
 */
public class MainApp {
    
    public static void main(String[] args) {
        // setting UI theme and LookAndFeel of the application
        //try {
        //    javax.swing.UIManager.setLookAndFeel(new FlatMaterialDarkerIJTheme());
        //} catch (UnsupportedLookAndFeelException ex) {
        //    Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        //}

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
}
