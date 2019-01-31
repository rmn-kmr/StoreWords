package com.r.storewords;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class EntryActivity extends AppCompatActivity {

    EditText wordText;
    public static final String EXTRA_WORD = "extra_word";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_entry);
        wordText = findViewById(R.id.wordView);
    }

    public void addWord(View view) {
        Intent replyIntent = new Intent();
        if (TextUtils.isEmpty(wordText.getText())){
            setResult(RESULT_CANCELED,replyIntent);
        }else {
            String word = wordText.getText().toString();
            replyIntent.putExtra(EXTRA_WORD,word);
            setResult(RESULT_OK, replyIntent);
        }
        finish();
    }

}
