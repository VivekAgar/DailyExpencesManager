package com.mycompany.dailyexpensemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="No such User")  // 404
public class DailyExpenseManagerException extends RuntimeException {

    public DailyExpenseManagerException(String exception) {
        super(exception);
    }
}
