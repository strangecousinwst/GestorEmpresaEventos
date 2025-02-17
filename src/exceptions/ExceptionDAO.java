package exceptions;

/**
 * Classe genérica para excepções com os Data Acess Objects.
 * @author joao
 */
public class ExceptionDAO extends Exception {

    /**
     * Constructs an instance of <code>ExceptionDAO</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionDAO(String msg) { super(msg); }
}