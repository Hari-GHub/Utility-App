package au.edu.jcu.cp3406.utilityapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    public SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        preferences = getSharedPreferences("config", MODE_PRIVATE);

        AppCompatDelegate.setDefaultNightMode(preferences.getInt("default night mode",
                AppCompatDelegate.MODE_NIGHT_UNSPECIFIED));
    }
    public void clickButton(View view){
        //Button button = (Button) view;
        //button.setOnClickListener(new View.OnClickListener() {
      //      @Override
     //       public void onClick(View v) {
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }

          // }

       // });

    }
    @Override
    protected void onDestroy(){
        preferences.edit().putInt("mode", AppCompatDelegate.getDefaultNightMode()).apply();
        super.onDestroy();
    }

    public void displayIndex(View view) {
        Toast toast = Toast.makeText(this, "Keep Up the Good Work !!", Toast.LENGTH_LONG);
        toast.show();
        finish();

    }// Will be Further developed to display BMI Index according to age using switch cases
}
