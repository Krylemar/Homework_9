package bg.tu_varna.sit.task3;

public class InvalidDataException extends Exception{
    public InvalidDataException() {
    }

    public InvalidDataException(String message) {
        super(message);
    }
}
