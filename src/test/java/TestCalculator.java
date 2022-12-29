import TestNgBasics.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalculator {
    @Test
    public void testAdditionOfTwoNumbers() {
        //Arrange
        int number1 = 1;
        int number2 = 2;

        //Act
        Calculator calculator = new Calculator();
        int addition = calculator.add(number1, number2);

        //Assert
        Assert.assertEquals(addition, 3);
    }

    @Test
    public void testSubtractTwoNumbers() {

        int i = 20, j = 15;

        Calculator calculator = new Calculator();
        int res = calculator.subtract(i, j);

        Assert.assertEquals(res, 5);
    }

    @Test
    public void testMultiplyTwoNumbers() {
        int i = 2, j = 5;

        Calculator calculator = new Calculator();
        int multiply = calculator.multiply(i, j);

        Assert.assertEquals(multiply, 10);

    }
    @Test
    public void testFindPercentage(){
        int i = 25,j = 100;

        Calculator calculator = new Calculator();
        double percent = calculator.percentage(i,j);

        Assert.assertEquals(percent,25);
    }

    @Test
    public void calulateSquareOfNumber(){
        int i = 10;

        Calculator calculator = new Calculator();
        int result = calculator.square(i);

        Assert.assertEquals(result,100);
    }


}
