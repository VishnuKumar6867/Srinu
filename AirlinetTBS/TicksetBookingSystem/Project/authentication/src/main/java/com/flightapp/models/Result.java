package com.flightapp.models;

public class Result {
    String result;

    @Override
    public String toString() {
        return "Result{" +
                "result='" + result + '\'' +
                '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Result(String result) {
        this.result = result;
    }

    public Result() {
    }
}
