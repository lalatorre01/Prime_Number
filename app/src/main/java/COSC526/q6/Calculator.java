package COSC526.q6;

public class Calculator {
    private int number;

    public Calculator(int number) {
        this.number = number;
    }
    public String isPrime() {
        //method checks if number is a prime number and returns string value
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return "Not a Prime Number";
            }
        }
        return "A Prime Number";
    }

}
