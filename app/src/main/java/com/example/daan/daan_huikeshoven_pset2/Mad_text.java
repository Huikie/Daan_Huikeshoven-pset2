package com.example.daan.daan_huikeshoven_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Mad_text extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_text);
        Intent intent = getIntent();
        final Story retrieved_story = (Story) intent.getSerializableExtra("mad_text");
        String mad_text_string = retrieved_story.toString();
        TextView mad_text = findViewById(R.id.mad_text);
        mad_text.setText(mad_text_string);
    }
    public void makeNewStory(View view){
        Intent intent = new Intent(Mad_text.this, Choose_txt.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Mad_text.this,Choose_txt.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
