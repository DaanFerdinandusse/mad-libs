package com.example.daan.daanferdinandusse_pset2;

import android.content.Intent;
import android.content.SyncStatusObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getStarted(View view){
        Intent intent = new Intent(MainActivity.this, StorySelection.class);
        startActivity(intent);
    }
}
