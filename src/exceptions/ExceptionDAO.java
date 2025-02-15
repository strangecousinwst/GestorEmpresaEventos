/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author joao
 */
public class ExceptionDAO extends Exception {

    /**
     * Creates a new instance of <code>ExceptionDAO</code> without detail message.
     */
    public ExceptionDAO() {
    }

    /**
     * Constructs an instance of <code>ExceptionDAO</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionDAO(String msg) {
        super(msg);
    }
}
