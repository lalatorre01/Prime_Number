package COSC526.q6;

import static android.view.View.TEXT_ALIGNMENT_CENTER;


import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AppInterface extends RelativeLayout {
    private EditText inputNumber;
    private TextView outputTextView;
    private Button button;
    private RelativeLayout scene;

    public AppInterface(Context context, View.OnClickListener buttonHandler) {
        super(context);
        //create scene relative layout, DP, and params
        scene = new RelativeLayout(context);
        final int DP = (int) (getResources().getDisplayMetrics().density);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0, 0);

        //create EditText for user input
        inputNumber = new EditText(context);
        inputNumber.setId(EditText.generateViewId());
        inputNumber.setTextColor(Color.parseColor("#000000"));
        inputNumber.setBackgroundColor(Color.parseColor("#FFFFFF"));
        inputNumber.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        inputNumber.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        inputNumber.setPadding(10 * DP, 10 * DP, 10 * DP, 10 * DP);
        inputNumber.setHint("Enter a number");
        inputNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
        params.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.leftMargin = 140 * DP;
        params.topMargin = 240 * DP;
        inputNumber.setLayoutParams(params);


        //create output TextView
        outputTextView = new TextView(context);
        outputTextView.setId(TextView.generateViewId());
        outputTextView.setTextColor(Color.parseColor("#000000"));
        outputTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        outputTextView.setPadding(10 * DP, 10 * DP, 10 * DP, 10 * DP);
        outputTextView.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        outputTextView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        params = new RelativeLayout.LayoutParams(0, 0);
        params.width = 285 * DP;
        params.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.leftMargin = 140 * DP;
        params.topMargin = 370 * DP;
        outputTextView.setLayoutParams(params);


        //create button
        button = new Button(context);
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        button.setPadding(15 * DP, 15 * DP, 15 * DP, 15 * DP);
        button.setTextColor(Color.parseColor("#FFFFFF"));
        button.setBackgroundColor(Color.parseColor("#190E5D"));
        button.setText("Submit");
        params = new RelativeLayout.LayoutParams(0, 0);
        params.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin = 40 * DP;
        params.addRule(RelativeLayout.BELOW, outputTextView.getId());
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        button.setLayoutParams(params);
        button.setOnClickListener(buttonHandler);


        //set background color of scene and add to view the scene, button, outputTextView, and inputNumber
        scene.setBackgroundColor(Color.parseColor("#B8DDF7"));
        addView(scene);
        addView(button);
        addView(outputTextView);
        addView(inputNumber);

    }

    public int getInputNumber() {
        //this method gets the number inputted by the user
        //first, read number from edit text
        String numberstr = inputNumber.getText().toString().trim();
        //second, parse string to a int
        int number = Integer.parseInt(numberstr);
        return number;

    }
    public void setOutputString(String message){
        //method to output prime message
        outputTextView.setText(message);
    }
}