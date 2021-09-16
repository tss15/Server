package commands.excpetionsCommand;

public class ValueTooBigException extends RuntimeException {
    public ValueTooBigException(String message) {super(message);}
}
