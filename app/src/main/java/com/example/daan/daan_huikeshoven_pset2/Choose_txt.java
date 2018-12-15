package com.example.daan.daan_huikeshoven_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Choose_txt extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_txt);
    }
    /** Method that directs the user from the page where he/she chooses a text to the page where actually can be played.
     * Also the text name that the user choose is put along when directing to the play activity.*/
    public void chooseText(View view)
    {
        Intent intent = new Intent(Choose_txt.this, Play.class);
        switch(view.getId()){
            case R.id.simple_text:
                String id = "simple_text";
                intent.putExtra("simple_text", id);
                break;
            case R.id.tarzan_text:
                String id1 = "tarzan_text";
                intent.putExtra("tarzan_text", id1);
                break;
            case R.id.university_text:
                String id2 = "university_text";
                intent.putExtra("university_text", id2);
                break;
            case R.id.clothes_text:
                String id3 = "clothes_text";
                intent.putExtra("clothes_text", id3);
                break;
            case R.id.dance_text:
                String id4 = "dance_text";
                intent.putExtra("dance_text", id4);
                break;
        }
        startActivity(intent);
        }
    }
