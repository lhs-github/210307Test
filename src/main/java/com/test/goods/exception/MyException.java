package com.test.goods.exception;

public class MyException extends Exception {

    // 异常信息
    private String message;

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
        this.message=message;
    }

}
