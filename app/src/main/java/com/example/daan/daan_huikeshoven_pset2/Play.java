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

        // Get the extras that are put along if there are extra's and if there isn't a savedInstanceState.
        // Find out what text the user choose to play with by checking 'extras'.
        // Based on what text the user choose load that text, make a new Story of it and give feedback during gameplay.
        // The code that makes it possible to fill in the story can be seen below in the setOnClickListener.
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
        // If there is a savedInstanceState, fill the right views with the right gameplay feedback.
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
        // Code that makes it possible to fill in the story.
        fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = findViewById(R.id.editText);
                // Put <b></b> around the filled in placeholder to be able to make the filled in placeholder bold in the Mad_text activity.
                text.fillInPlaceholder("<b>" + input.getText().toString() + "</b>");
                TextView type_info = findViewById(R.id.type_info);
                type_info.setText("Please type a/an ");
                String info = text.getNextPlaceholder();
                type_info.append(info);
                int rem = text.getPlaceholderRemainingCount();
                TextView words_left = findViewById(R.id.rem_placeholders);
                words_left.setText("");
                words_left.setText(rem + " word(s) left");
                // If the whole text is filled in, put the created text to the activity where the text will be shown.
                if(text.isFilledIn()){
                    Intent intent_next = new Intent(Play.this, Mad_text.class);
                    intent_next.putExtra("mad_text", text);
                    startActivity(intent_next);
                }
            }
        });
    }
    /** Save gameplay progress, so it can be regenerated.*/
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("text", text);
    }

}
