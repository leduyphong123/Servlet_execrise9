package com.example.caculatorjslt.model;

public class Caculator {
    public static float caculator(float firt,float second,String operator) throws ClassNotFoundException {
        switch (operator){
            case "+":
                return firt+second;
            case "-":
                return firt-second;
            case "*":
                return firt*second;
            case "/":
                if (second!=0){
                    return firt/second;
                }
            default:
                throw new ClassNotFoundException();
        }
    }
}
