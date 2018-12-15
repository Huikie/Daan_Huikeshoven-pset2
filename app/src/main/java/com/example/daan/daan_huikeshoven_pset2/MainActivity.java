package com.example.daan.daan_huikeshoven_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** Method that directs the user from the begin page to the page where he/she can choose a text to play with.*/
    public void buttonClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, Choose_txt.class);
        startActivity(intent);
    }

}
