package org.sathyabodh.actuator.quartz.exception;

public class UnsupportCronChangeExpression extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UnsupportCronChangeExpression(String message) {
        super(message);
    }
}