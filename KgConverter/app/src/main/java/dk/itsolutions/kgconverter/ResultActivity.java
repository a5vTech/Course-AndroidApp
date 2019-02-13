package dk.itsolutions.kgconverter;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.Gravity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();
        Double result;
        Intent intent = getIntent();
        Double kgValue = Double.parseDouble(intent.getStringExtra("kgValue"));
        result = kgValue / 0.45359237;
        resultText.setTextSize(32);
        resultText.setText(String.format("%.3f Kg is %.3f Lb", kgValue, result));
        resultText.setTextColor(Color.rgb(1, 100, 5));
        resultText.setGravity(Gravity.CENTER);
    }

    public void init() {
        resultText = findViewById(R.id.resultText);
    }
}
