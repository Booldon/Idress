package idress.hello.idress.controller;

import idress.hello.idress.exception.DuplicateMemberException;
import idress.hello.idress.exception.LoginFailException;
import idress.hello.idress.exception.NoLoginException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(LoginFailException.class)
    public String LoginFailException(@ModelAttribute LoginFailException exception) {

        return "exception/LoginFailError";
    }

    @ExceptionHandler(NoLoginException.class)
    public String NoLoginException(@ModelAttribute NoLoginException exception) {

        return "exception/NoLoginError";
    }


    @ExceptionHandler(DuplicateMemberException.class)
    public String DuplicateMemberException(@ModelAttribute DuplicateMemberException exception) {

        return "exception/DuplicateMemberError";
    }
}
