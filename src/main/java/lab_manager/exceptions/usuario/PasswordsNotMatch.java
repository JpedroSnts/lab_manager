package lab_manager.exceptions.usuario;

public class PasswordsNotMatch extends RuntimeException {
    public PasswordsNotMatch(String message) {
        super(message);
    }
}