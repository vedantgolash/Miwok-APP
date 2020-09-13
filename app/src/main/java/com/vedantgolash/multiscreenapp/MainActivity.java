package com.vedantgolash.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNumbers(View view){
        Intent intent = new Intent(this,NumbersActivity.class);
        startActivity(intent);
    }
    public void openFamily(View view){
        Intent intent = new Intent(this,FamilyActivity.class);
        startActivity(intent);
    }
    public void openColors(View view){
        Intent intent = new Intent(this,ColorsActivity.class);
        startActivity(intent);
    }
    public void openPhrases(View view){
        Intent intent = new Intent(this,PhrasesActivity.class);
        startActivity(intent);
    }
}