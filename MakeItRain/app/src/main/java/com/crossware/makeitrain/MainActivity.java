package com.crossware.makeitrain;

import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button makeItRain;
    private TextView moneyValue;
    private Button shpwInfo;
    private int moneyCounter = 0;
    private Button newButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.another_layout);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        newButton = findViewById(R.id.button);
        newButton.setOnClickListener(view ->
                Log.d("MainActivity", "Button Clicked"));

        makeItRain = findViewById(R.id.buttonMakeItRain);
        moneyValue = findViewById(R.id.moneyValue);
        shpwInfo = findViewById(R.id.buttonShowInfo);

//        moneyValue.setText("$ 0");
//        makeItRain.setOnClickListener(view ->
//                Log.d("MainActivity", "Button Clicked"));
    }

    public void showMoney(View view) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneyCounter += 1000;
        if(moneyCounter >= 20000){
            Snackbar.make(view, "Wow! That's a lot of money!", Snackbar.LENGTH_SHORT).show();
            moneyValue.setText(numberFormat.format(moneyCounter));
        }else{
            moneyValue.setText(numberFormat.format(moneyCounter));
            Snackbar.make(view, "Keep Going", Snackbar.LENGTH_SHORT).setAction(
                    "More", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
                            int moneyLeft = 20000 - moneyCounter;
                            Snackbar.make(view, "Only " + numberFormat.format(moneyLeft) + " to go", Snackbar.LENGTH_SHORT).show();
                        }
                    }).show();
        }

        Log.d("MainActivity", "Button Clicked");
    }

    public void showInfo(View view) {
//        Toast.makeText(MainActivity.this, R.string.app_info, Toast.LENGTH_SHORT).show();
        Snackbar.make(moneyValue, R.string.app_info, Snackbar.LENGTH_SHORT)
                .setAction("More", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view, "More Info", Snackbar.LENGTH_SHORT).show();
                    }
                }).show();
    }
}