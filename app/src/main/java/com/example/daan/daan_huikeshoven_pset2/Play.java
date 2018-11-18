package com.example.daan.daan_huikeshoven_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.InputStream;
import java.io.Serializable;

public class Play extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        TextView play_text = findViewById(R.id.play_text);
        if (extras != null){
            if(extras.containsKey("simple_text")){
                Serializable simple_text = intent.getSerializableExtra("simple_text");
                String text1 = simple_text.toString();
                play_text.setText(text1);
            }
            if(extras.containsKey("tarzan_text")){
                Serializable tarzan_text = intent.getSerializableExtra("tarzan_text");
                String text2 = tarzan_text.toString();
                play_text.setText(text2);
            }

    }
}
}
