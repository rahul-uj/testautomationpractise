package TestNgBasics;

import org.testng.annotations.Test;

public class Calculator {
    public  int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public  int subtract(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public  double percentage(int number, int total) {
        return number * 100 / total;
    }

    public int square(int number) {
        return number *  number;
    }
    }
