package com.example.daan.daanferdinandusse_pset2;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.InputStream;

public class FillWords extends AppCompatActivity {

    private Story story;
    private TextView counterText;
    private TextInputEditText inputbar;
    private TextView specification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_words);

        if(savedInstanceState == null){
            Intent intent = getIntent();
            String name = intent.getStringExtra("text");
            InputStream is = null;
            switch (name){
                case "simple": is = getResources().openRawResource(R.raw.madlib0_simple);
                    break;
                case "tarzan": is = getResources().openRawResource(R.raw.madlib1_tarzan);
                    break;
                case "university": is = getResources().openRawResource(R.raw.madlib2_university);
                    break;
                case "clothes": is = getResources().openRawResource(R.raw.madlib3_clothes);
                    break;
                case "dance": is = getResources().openRawResource(R.raw.madlib4_dance);
                    break;
            }
            story = new Story(is);
        } else{
            story = (Story) savedInstanceState.getSerializable("story");
        }
        counterText = findViewById(R.id.wordCounter);
        counterText.setText(story.getPlaceholderRemainingCount() + " word(s) left");
        inputbar = findViewById(R.id.inputText);
        String placeholder = story.getNextPlaceholder();
        inputbar.setHint(placeholder);
        specification = findViewById(R.id.wordSpecification);
        specification.setText("please type a/an " + placeholder);

    }

    /*
        this method checks if all the words are filled. if so it will give the user the next screen
        else this method will update the text informing the user to
     */
    public void nextWord(View view){
        story.fillInPlaceholder(inputbar.getText().toString());
        if(story.isFilledIn()){
            Intent intent = new Intent(FillWords.this, newStory.class);
            intent.putExtra("story", story);
            startActivity(intent);
        } else {
            inputbar.setText("");
            counterText.setText(story.getPlaceholderRemainingCount() + " word(s) left");
            String placeholder = story.getNextPlaceholder();
            inputbar.setHint(placeholder);
            specification.setText("please type a/an " + placeholder);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("story", story);
    }
}
