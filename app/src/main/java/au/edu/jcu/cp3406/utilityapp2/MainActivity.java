package au.edu.jcu.cp3406.utilityapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public double getInput(){
        EditText userHeight = findViewById(R.id.userInput1);
        String text = userHeight.getText().toString();
        if (text.length() == 0){
            return -1;
        }
        double height = Integer.parseInt(text);
        EditText userWeight = findViewById(R.id.userInput2);
        String text2 = userWeight.getText().toString();
        double weight = Integer.parseInt(text2);
        double BMI = weight/(height*height);
        System.out.println(BMI);
        return BMI*10000;

    }

    public void goSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }


     public double getBMI(View view) {
         TextView textView = (TextView) findViewById(R.id.result);
            double b = getInput();
            if (b == -1){
                return 0;
            }
            textView.setText(b + "");
            return b;
    }


}