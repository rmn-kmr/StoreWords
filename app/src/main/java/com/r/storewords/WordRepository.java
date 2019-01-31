package com.r.storewords;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.r.storewords.dao.WordDao;
import com.r.storewords.db.WordRoomDatabase;
import com.r.storewords.model.Word;

import java.util.List;

public class WordRepository {
    private WordDao wordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        wordDao = db.wordDao();
        mAllWords = wordDao.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        if (word != null)
            new InsertTask(wordDao).execute(word);
    }

    public void removeWord(String word) {
        if (word != null)
            new DeleteTask(wordDao).execute(word);
    }


    private static class InsertTask extends AsyncTask<Word, Void, String> {

        private WordDao masyncWordDao;

        public InsertTask(WordDao wordDao) {
            masyncWordDao = wordDao;
        }

        @Override
        protected String doInBackground(Word... words) {
            masyncWordDao.insert(words[0]);
            return null;
        }
    }
    private static class DeleteTask extends AsyncTask<String, Void, String> {

        private WordDao masyncWordDao;

        public DeleteTask(WordDao wordDao) {
            masyncWordDao = wordDao;
        }

        @Override
        protected String doInBackground(String... words) {
            masyncWordDao.delete(words[0]);
            return null;
        }
    }
}
