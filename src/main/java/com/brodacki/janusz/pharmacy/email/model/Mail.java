package com.brodacki.janusz.pharmacy.email.model;

public class Mail {
    private String mailTo;
    private String subject;
    private String message;

    public Mail(String mailTo, String subject, String message, String s) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
    }

    public String getMailTo() {
        return mailTo;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }
}
