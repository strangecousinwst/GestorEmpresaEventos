package exceptions;

/**
 * Classe genérica para excepções com a conexão.
 * @author joao
 */
public class ExceptionConn extends Exception {

    /**
     * Creates a new instance of <code>ExceptionConn</code> without detail
     * message.
     */
    public ExceptionConn() { }

    /**
     * Constructs an instance of <code>ExceptionConn</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionConn(String msg) { super(msg); }
}