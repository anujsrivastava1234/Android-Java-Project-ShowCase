package com.crossware.bio;

import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import com.crossware.bio.data.Bio;
import com.crossware.bio.databinding.ActivityMainBinding;

//* Add the View binding library to the project for the View
//* Add the data binding library to the project for the data binding

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final Bio bio = new Bio();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        bio.setName("Anuj Srivastava");
        binding.setBio(bio);
        binding.doneBtn.setOnClickListener(this::addHobbies);
    }

    public void addHobbies(View view) {
        bio.setHobbies(String.format("Hobbies: %s", binding.hobbiesText.getText()
                .toString().trim()));
        binding.invalidateAll();
        binding.textView3.setVisibility(View.VISIBLE);

        //? hide input keyboard
        InputMethodManager inputMethodManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromInputMethod(view.getWindowToken(),0);
    }
}