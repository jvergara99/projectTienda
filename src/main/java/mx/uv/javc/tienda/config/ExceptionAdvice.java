package mx.uv.javc.tienda.config;

import java.util.LinkedList;
import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import mx.uv.javc.tienda.dto.ErrorDTO;

@RestControllerAdvice
public class ExceptionAdvice {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO validationErrors(MethodArgumentNotValidException ex) {

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> errors = new LinkedList<>();

        //Extraer los mensajes de error de la excepción
        for ( FieldError fieldError : fieldErrors) {
            errors.add(fieldError.getDefaultMessage());
        }

        return new ErrorDTO("LIS001", "Error validación datos de entrada", errors);
    }
}
