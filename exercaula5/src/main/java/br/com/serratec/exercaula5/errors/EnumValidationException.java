package br.com.serratec.exercaula5.errors;

public class EnumValidationException extends RuntimeException {

    public EnumValidationException(String message) {
        super(message);
    }

}