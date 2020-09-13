package com.vedantgolash.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mmediaplayer;

    private MediaPlayer.OnCompletionListener mcompletelistener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list1);


        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Where are you going?", "minto wuksus",
                 R.raw.phrase_where_are_you_going  ));

        words.add(new Word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is","oyaseet",
                R.raw.phrase_my_name_is));
        words.add(new Word("How you are feeling?","michekes",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("im feeling good","kuchi achit",R.raw.phrase_im_feeling_good));
        words.add(new Word("are you coming?","eenesaa",R.raw.phrase_are_you_coming));
        words.add(new Word("yes i'm coming","heeeenem",R.raw.phrase_yes_im_coming));
        words.add(new Word("i'm coming","eenem",R.raw.phrase_yes_im_coming));
        words.add(new Word("let's go","yoowutis",R.raw.phrase_lets_go));
        words.add(new Word("come here","pappa",R.raw.phrase_come_here));



        WordAdapter adapter = new WordAdapter(this, words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word=words.get(i);
                releaseMediaPlayer();
                mmediaplayer=MediaPlayer.create(PhrasesActivity.this,word.getAudio());
                mmediaplayer.start();
                mmediaplayer.setOnCompletionListener(mcompletelistener);

            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mmediaplayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mmediaplayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mmediaplayer = null;
        }
    }

}