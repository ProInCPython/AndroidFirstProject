package com.example.myapplication;

public class Problem {

    private int result;

    public int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    public int getResult() {
        return result;
    }

    public String getProblem() {
        int a = getRandom(-50, 50);
        int b = getRandom(0, 50);
        String sign = getRandomSign();
        switch (sign) {
            case "-":
                result = a - b;
                break;
            case "+":
                result = a + b;
                break;
            case "*":
                a = getRandom(-10, 10);
                b = getRandom(0, 10);
                result = a * b;
                break;
            case "/":
                while (a % b != 0) {
                    a = getRandom(-50, 50);
                    b = getRandom(1, 50);
                }
                result = a / b;
                break;
        }
        return a + sign + b;
    }

    public int getNoiseResult() {
        int get = getRandom(-4, 4);
        while(get == 0) {
            get = getRandom(-4, 4);
        }
        return result + get;
    }

    private String getRandomSign() {
        int r = getRandom(1, 5);
        String res = "";
        switch (r) {
            case 1:
                res = "-";
                break;
            case 2:
                res = "+";
                break;
            case 3:
                res = "*";
            break;
            case 4:
                res = "/";
            break;
        }
        return res;
    }

}
