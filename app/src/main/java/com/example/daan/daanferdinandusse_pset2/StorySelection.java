package com.example.daan.daanferdinandusse_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StorySelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_selection);
    }

    public void fillStory(View view){
        Button button = (Button) view;
        String text = button.getText().toString();
        Intent intent = new Intent(StorySelection.this, FillWords.class);
        intent.putExtra("text", text);
        startActivity(intent);
    }
}
