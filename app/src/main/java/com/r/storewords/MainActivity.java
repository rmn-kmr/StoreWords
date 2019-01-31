package com.r.storewords;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.r.storewords.adapter.WordAdapter;
import com.r.storewords.model.Word;
import com.r.storewords.viewmodel.WordViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    WordAdapter wordAdapter;
    WordViewModel wordViewModel;
    private static final int NEW_WORD_ACTIVITY = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle);
        wordAdapter = new WordAdapter(this);
        recyclerView.setAdapter(wordAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        wordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);

        wordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable List<Word> words) {
                wordAdapter.setWords(words);
            }
        });
    }

    public void removeWord(String word){
        wordViewModel.removeWord(word);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == NEW_WORD_ACTIVITY && resultCode == RESULT_OK){
            Word word = new Word(data.getStringExtra(EntryActivity.EXTRA_WORD));
            wordViewModel.insert(word);
        }else {
            Toast.makeText(this,R.string.empty_not_saved,Toast.LENGTH_SHORT).show();
        }
    }


    public void addWord(View view) {
        Intent intent = new Intent(MainActivity.this, EntryActivity.class);
        startActivityForResult(intent, NEW_WORD_ACTIVITY);
    }
}
