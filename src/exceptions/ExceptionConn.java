/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author joao
 */
public class ExceptionConn extends Exception {

    /**
     * Creates a new instance of <code>ExceptionConn</code> without detail
     * message.
     */
    public ExceptionConn() {
    }

    /**
     * Constructs an instance of <code>ExceptionConn</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionConn(String msg) {
        super(msg);
    }
}
