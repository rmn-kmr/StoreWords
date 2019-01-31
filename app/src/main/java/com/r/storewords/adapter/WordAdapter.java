package com.r.storewords.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.r.storewords.R;
import com.r.storewords.model.Word;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordHolder> {

    private final LayoutInflater mInflater;
    List<Word> words;

    public WordAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        words = new ArrayList<>();
    }

    @NonNull
    @Override
    public WordHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new WordHolder(mInflater.inflate(R.layout.item_view,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull WordHolder wordHolder, int i) {
        wordHolder.wordView.setText(words.get(i).getWord());
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public void setWords(List<Word> words){
        this.words = words;
        notifyDataSetChanged();
    }

    public class WordHolder extends RecyclerView.ViewHolder{

        public TextView wordView;

        public WordHolder(@NonNull View itemView) {
            super(itemView);
            wordView = itemView.findViewById(R.id.textView);
        }
    }
}
