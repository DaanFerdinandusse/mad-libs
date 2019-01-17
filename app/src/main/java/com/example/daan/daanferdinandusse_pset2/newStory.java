package com.example.daan.daanferdinandusse_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class newStory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_story);

        Intent intent = getIntent();
        Story story = (Story) intent.getSerializableExtra("story");

        TextView v = findViewById(R.id.stroy);
        v.setText(story.toString());
    }

    public void reset(View view){
        Intent intent = new Intent(newStory.this, MainActivity.class);
        startActivity(intent);
    }
}
