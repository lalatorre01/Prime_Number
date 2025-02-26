package COSC526.q6;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;
    private AppInterface appInterface;
    private ButtonHandler buttonHandler;
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //create buttonhandler
        buttonHandler = new ButtonHandler();
        //create app interface
        appInterface = new AppInterface(this, buttonHandler);
        //set appinterface to setContentView method
        setContentView(appInterface);

    }

    private class ButtonHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //read the user input from appInterface
            number = appInterface.getInputNumber();
            //create a new calculator and add number to parameter
            calculator = new Calculator(number);
            //call isPrime() method to determine if the number is a prime or not
            String message = calculator.isPrime();
            //output result message to output text view
            appInterface.setOutputString(message);
        }
    }
}