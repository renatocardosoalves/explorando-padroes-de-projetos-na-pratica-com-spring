package one.digitalinnovation.padroesdeprojetospring.services.viacep.exceptions;

public class ZipCodeNotFoundException extends RuntimeException {

    public ZipCodeNotFoundException(String message) {
        super(message);
    }
}
