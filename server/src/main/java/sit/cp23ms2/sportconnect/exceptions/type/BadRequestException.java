package sit.cp23ms2.sportconnect.exceptions.type;

public class BadRequestException extends Exception{
    public BadRequestException() {
        super("Bad Request");
    }

    public BadRequestException(String message) {
        super("Bad request: " + message);
    }
}
