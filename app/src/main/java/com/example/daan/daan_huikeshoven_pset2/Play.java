package com.example.daan.daan_huikeshoven_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
public class Play extends AppCompatActivity {
    Story text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null && savedInstanceState == null) {
            if (extras.containsKey("simple_text")) {
                InputStream is = getResources().openRawResource(R.raw.madlib0_simple);
                text = new Story(is);
                TextView type_info = findViewById(R.id.type_info);
                String info = text.getNextPlaceholder();
                type_info.append(info);
                int rem = text.getPlaceholderCount();
                TextView words_left = findViewById(R.id.rem_placeholders);
                words_left.setText(rem + " word(s) left");
            }
            if (extras.containsKey("tarzan_text")) {
                InputStream is = getResources().openRawResource(R.raw.madlib1_tarzan);
                text = new Story(is);
                TextView type_info = findViewById(R.id.type_info);
                String info = text.getNextPlaceholder();
                type_info.append(info);

                int rem = text.getPlaceholderCount();
                TextView words_left = findViewById(R.id.rem_placeholders);
                words_left.setText(rem + " word(s) left");
            }
            if (extras.containsKey("university_text")) {
                InputStream is = getResources().openRawResource(R.raw.madlib2_university);
                text = new Story(is);
                TextView type_info = findViewById(R.id.type_info);
                String info = text.getNextPlaceholder();
                type_info.append(info);

                int rem = text.getPlaceholderCount();
                TextView words_left = findViewById(R.id.rem_placeholders);
                words_left.setText(rem + " word(s) left");
            }
            if (extras.containsKey("clothes_text")) {
                InputStream is = getResources().openRawResource(R.raw.madlib3_clothes);
                text = new Story(is);
                TextView type_info = findViewById(R.id.type_info);
                String info = text.getNextPlaceholder();
                type_info.append(info);

                int rem = text.getPlaceholderCount();
                TextView words_left = findViewById(R.id.rem_placeholders);
                words_left.setText(rem + " word(s) left");
            }
            if (extras.containsKey("dance_text")) {
                InputStream is = getResources().openRawResource(R.raw.madlib4_dance);
                text = new Story(is);
                TextView type_info = findViewById(R.id.type_info);
                String info = text.getNextPlaceholder();
                type_info.append(info);

                int rem = text.getPlaceholderCount();
                TextView words_left = findViewById(R.id.rem_placeholders);
                words_left.setText(rem + " word(s) left");
            }

        }
        else{
            text = (Story) savedInstanceState.getSerializable("text");
            TextView type_info = findViewById(R.id.type_info);
            String info = text.getNextPlaceholder();
            type_info.append(info);

            int rem = text.getPlaceholderRemainingCount();
            TextView words_left = findViewById(R.id.rem_placeholders);
            words_left.setText(rem + " word(s) left");
        }

        Button fill = findViewById(R.id.fill_button);
        fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = findViewById(R.id.editText);
                text.fillInPlaceholder("<b>" + input.getText().toString() + "</b>");
                TextView type_info = findViewById(R.id.type_info);
                type_info.setText("Please type a/an ");
                String info = text.getNextPlaceholder();
                type_info.append(info);
                int rem = text.getPlaceholderRemainingCount();
                TextView words_left = findViewById(R.id.rem_placeholders);
                words_left.setText("");
                words_left.setText(rem + " word(s) left");
                if(text.isFilledIn()){
                    Intent intent_next = new Intent(Play.this, Mad_text.class);
                    intent_next.putExtra("mad_text", text);
                    startActivity(intent_next);
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState); // always call super
        outState.putSerializable("text", text);
    }

}
