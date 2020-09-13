package com.vedantgolash.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mediaplayer;

    private MediaPlayer.OnCompletionListener moncompletion = new MediaPlayer.OnCompletionListener() {
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

        words.add(new Word("red", "wetetti",R.drawable.color_red));

        words.add(new Word("green","chokkoki",R.drawable.color_green));

        words.add(new Word("brown","takkakki",R.drawable.color_brown));
        words.add(new Word("gray","taachi",R.drawable.color_gray));
        words.add(new Word("black","kulluli",R.drawable.color_black));
        words.add(new Word("White","kelleli",R.drawable.color_white));
        words.add(new Word("dusty yellow","kelleli",R.drawable.color_dusty_yellow));
        words.add(new Word("mustard yellow","topise",R.drawable.color_mustard_yellow));




        WordAdapter adapter = new WordAdapter(this, words,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                releaseMediaPlayer();

                mediaplayer=MediaPlayer.create(ColorsActivity.this,word.getAudio());
                mediaplayer.start();
                mediaplayer.setOnCompletionListener(moncompletion);
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
        if (mediaplayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaplayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaplayer = null;
        }
    }

}