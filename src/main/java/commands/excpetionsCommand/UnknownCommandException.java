package commands.excpetionsCommand;

public class UnknownCommandException extends RuntimeException{
    public UnknownCommandException(String message) {super(message);}
}
