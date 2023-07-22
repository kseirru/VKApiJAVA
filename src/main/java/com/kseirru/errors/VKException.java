package com.kseirru.errors;

public class VKException extends Exception {
    public VKException(String message) { super(message);}
    public VKException() { super("Unknown error."); }
}
