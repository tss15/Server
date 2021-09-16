package commands.excpetionsCommand;

public class InappropriateArgForCommandException extends RuntimeException {
    public InappropriateArgForCommandException(String message) { super(message);}
}
