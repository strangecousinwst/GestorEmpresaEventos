/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author joao
 */
public class ExceptionController extends Exception {

    /**
     * Creates a new instance of <code>ExceptionController</code> without detail message.
     */
    public ExceptionController() {
    }

    /**
     * Constructs an instance of <code>ExceptionController</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionController(String msg) {
        super(msg);
    }
}
