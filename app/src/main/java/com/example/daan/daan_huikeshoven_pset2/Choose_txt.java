package com.example.daan.daan_huikeshoven_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

public class Choose_txt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_txt);
        InputStream is = getResources().openRawResource(R.raw.madlib0_simple);
        Story simple_text = new Story(is);
        List<String> placeholders =  simple_text.getPlaceholders();
        Log.d("placeholder", placeholders.toString());

    }
    public void goBack(View view)
    {
        Intent intent = new Intent(Choose_txt.this, MainActivity.class);
        startActivity(intent);
    }
    public void chooseText(View view)
    {
        Intent intent = new Intent(Choose_txt.this, Play.class);
        switch(view.getId()){
            case R.id.simple_text:
                InputStream is = getResources().openRawResource(R.raw.madlib0_simple);
                Story simple_text = new Story(is);
                intent.putExtra("simple_text", simple_text);
                break;
            case R.id.tarzan_text:
                InputStream is1 = getResources().openRawResource(R.raw.madlib1_tarzan);
                Story tarzan_text = new Story(is1);
                intent.putExtra("tarzan_text", tarzan_text);
                break;
        }
        startActivity(intent);
        }
    }
