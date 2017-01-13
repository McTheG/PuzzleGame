package com.example.elvin.puzzlegame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Victory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);
        }

    public void NewGame(View view) {
        Intent intent = new Intent(this, LightOut.class);
        startActivity(intent);
    }
}


