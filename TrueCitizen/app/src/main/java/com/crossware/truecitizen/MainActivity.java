package com.crossware.truecitizen;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.crossware.truecitizen.databinding.ActivityMainBinding;
import com.crossware.truecitizen.model.Question;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int currentQuestionIndex = 0;
    private Question[] questionsBank = new Question[]{
            new Question(R.string.question_amendments, false),
            new Question(R.string.question_constitution, true),
            new Question(R.string.question_declaration, true),
            new Question(R.string.question_independence_rights, true),
            new Question(R.string.question_religion, true),
            new Question(R.string.question_government, false),
            new Question(R.string.question_government_feds, false),
            new Question(R.string.question_government_senators, true)
            new Question("Capital of India is new Delhi",true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.questionTextView.setText(questionsBank[currentQuestionIndex].getAnswerResId());
        //* functionalities
        binding.nextButton.setOnClickListener(this::onNext);
        binding.prevButton.setOnClickListener(this::onPrev);
        binding.trueButton.setOnClickListener(this::onTrue);
        binding.falseButton.setOnClickListener(this::onFalse);
    }

    public void onNext(View view) {
        currentQuestionIndex = (currentQuestionIndex + 1) % questionsBank.length;
        Log.d("Main","Question Index : " + currentQuestionIndex);
        updateQuestions();
    }
    public void onPrev(View view) {
        if(currentQuestionIndex > 0){
            currentQuestionIndex = (currentQuestionIndex - 1) % questionsBank.length;
            updateQuestions();
        }
    }

    private void checkAnswer(boolean userAnswer) {
        boolean correctAnswer = questionsBank[currentQuestionIndex].isAnswerTrue();
        int messageId;
        if (userAnswer == correctAnswer) {
            messageId = R.string.correct_answer;
        } else {
            messageId = R.string.wrong_answer;
        }
        Snackbar.make(binding.main, messageId, Snackbar.LENGTH_SHORT).show();
    }

    private void updateQuestions() {
        binding.questionTextView.setText(questionsBank[currentQuestionIndex].getAnswerResId());
    }

    public void onTrue(View view){
        checkAnswer(true);
    }
    public void onFalse(View view) {
        checkAnswer(false);
    }
}