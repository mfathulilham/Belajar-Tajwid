package com.example.belajartajdwid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuisActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer suaraButton;
    private QuestionBank mQuestionBank = new QuestionBank();
    private TextView mtvQuestion;
    private Button mbtnChoice1;
    private Button mbtnChoice2;
    private Button mbtnChoice3;
    private Button mbtnChoice4;

    private String mAnswer;

    private int score = 100;
    private int mQuestionNum = 0;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quis);

        suaraButton = MediaPlayer.create(this, R.raw.button);

        int pertanyaanke = getIntent().getExtras().getInt("Question");
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            num = getIntent().getExtras().getInt("num");
        }


        mQuestionNum = pertanyaanke;

        mtvQuestion = findViewById(R.id.tvQuestion);
        mbtnChoice1 = findViewById(R.id.btnChoice1);
        mbtnChoice2 = findViewById(R.id.btnChoice2);
        mbtnChoice3 = findViewById(R.id.btnChoice3);
        mbtnChoice4 = findViewById(R.id.btnChoice4);

        updateQuestion();
        mbtnChoice1.setOnClickListener(this);
        mbtnChoice2.setOnClickListener(this);
        mbtnChoice3.setOnClickListener(this);
        mbtnChoice4.setOnClickListener(this);
    }

    private void updateQuestion() {

        mtvQuestion.setText(mQuestionBank.getQuestion(mQuestionNum)); // pertanyaan
        mbtnChoice1.setText(mQuestionBank.getChoice(mQuestionNum, 0)); // jawaban
        mbtnChoice2.setText(mQuestionBank.getChoice(mQuestionNum, 1));
        mbtnChoice3.setText(mQuestionBank.getChoice(mQuestionNum, 2));
        mbtnChoice4.setText(mQuestionBank.getChoice(mQuestionNum, 3));

        mAnswer = mQuestionBank.getCorrectAnswer(mQuestionNum);

    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Jawaban Kamu Salah ! ");
        builder.setPositiveButton("Kembali Ke Menu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                suaraButton.start();
                QuisActivity.super.onBackPressed();
            }
        });
        builder.setNegativeButton("Coba Lagi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                suaraButton.start();
                dialogInterface.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        mpRelease();
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        if (button.getText() == mAnswer) {
            suaraButton.start();
            Intent intent = new Intent(this, ResultAnswer.class);
            intent.putExtra("score", score);
            changeImage();
            startActivity(intent);
            finish();
        } else {
            suaraButton.start();
            score = score - 10;
            showDialog();
        }
    }

    private void changeImage() {
        SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putInt("VALUE_NUM",num);
        editor.commit();
//        if (num <= 5) {
//            SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
//            SharedPreferences.Editor editor = mPrefs.edit();
//            editor.putInt("VALUE_NUM",num);
//            editor.commit();
//        }
//        else if (num <= 10) {
//            SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
//            SharedPreferences.Editor editor = mPrefs.edit();
//            editor.putInt("VALUE_NUM_2",num);
//            editor.commit();
//        }
//        else if (num <= 15) {
//            SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
//            SharedPreferences.Editor editor = mPrefs.edit();
//            editor.putInt("VALUE_NUM_3",num);
//            editor.commit();
//        }
    }

    private void mpRelease() {
        suaraButton.release();
        suaraButton = null;
    }
}