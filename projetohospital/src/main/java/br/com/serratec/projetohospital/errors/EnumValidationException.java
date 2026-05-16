package br.com.serratec.projetohospital.errors;

public class EnumValidationException extends RuntimeException {

    public EnumValidationException(String message) {
        super(message);
    }

}