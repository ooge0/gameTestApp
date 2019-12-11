package com.gameApp.appManager.helpers;

public class HelperBase {
    public static String getThisMethodName() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            return  stackTrace[2].getMethodName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
