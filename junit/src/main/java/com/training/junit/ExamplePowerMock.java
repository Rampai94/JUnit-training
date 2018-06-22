package com.training.junit;

public class ExamplePowerMock {

    public String methodMakingPrivateMethodCall(String message) {
        return privateMethod(message);
    }
 
    public String methodMakingStaticNonVoidMethodCall(String message) {
        return ExampleUtil.getMessage("I");
    }
 
    public String methodMakingStaticVoidMethodCall(String message) {
        ExampleUtil.printMessage("Hello");;
        return "printed " + message;
    }
 
    private String privateMethod(String message) {
        return "another " + message;
    }
}
