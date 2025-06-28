package ivancroce.exceptions;

public class DuplicateGameException extends RuntimeException {
    public DuplicateGameException(String message) {
        super(message);
    }
}
