package dk.itsolutions.kgconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView WelcomeHeader;
    private EditText kgInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    public void init() {
        WelcomeHeader = findViewById(R.id.welcomeHeader);
        WelcomeHeader.setTextSize(32);
        kgInput = findViewById(R.id.kgInput);

    }

    public void convert(View view) {
        String kgInputStr = kgInput.getText().toString();

//         Check to see if the input is empty
        if (kgInputStr.length() > 0) {

            try {
                Double weightInKg = Double.parseDouble(kgInputStr);
//                Check if weight is > 0 and makes sure it does not start with 0
                if (weightInKg > 0 && !kgInputStr.startsWith("0")) {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("kgValue", kgInputStr);
                    startActivity(intent);
                } else {
                    Toast errorMsgLow = Toast.makeText(getApplicationContext(), "Please enter a number greater than 0", Toast.LENGTH_LONG);
                    errorMsgLow.show();
                }
            } catch (Exception e) {
//                 Parse exceptions caught here
            }
//             If no weight is entered
        } else {
            Toast errorMsg = Toast.makeText(getApplicationContext(), "Please enter the weight", Toast.LENGTH_LONG);
            errorMsg.show();
        }
    }

}
