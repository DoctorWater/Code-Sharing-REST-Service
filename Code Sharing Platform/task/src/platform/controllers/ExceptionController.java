package platform.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import platform.DTO.ExceptionDTO;

import java.io.FileNotFoundException;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = FileNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ExceptionDTO handleException(FileNotFoundException e) {
        return new ExceptionDTO(e);
    }
}
