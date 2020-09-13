package com.vedantgolash.multiscreenapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {

    private int mColor;

    public WordAdapter(Activity context, ArrayList<Word> words,int colorid){
        super(context,0,words);
        mColor=colorid;
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Word currentword = getItem(position);

        TextView miwoktext = (TextView)listItemView.findViewById(R.id.miwok_text_view);
        miwoktext.setText(currentword.getMiwokTranslation());

        TextView defaulttext = (TextView)listItemView.findViewById(R.id.default_text_view);
        defaulttext.setText(currentword.getDefaultTranslation());

        ImageView imageView = (ImageView)listItemView.findViewById(R.id.image);

        if(currentword.hasimage()) {
            imageView.setImageResource(currentword.getImageResouceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        View colorview = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColor);
        colorview.setBackgroundColor(color);


        return listItemView;


    }
}
