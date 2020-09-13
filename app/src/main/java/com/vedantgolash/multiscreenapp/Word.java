package com.vedantgolash.multiscreenapp;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId=SET_IMAGE;
    private static final int SET_IMAGE=-1;
    private int mResouceId;


    public Word(String defaulTranslation,String MiwokTranslation,int resourceId){
        mDefaultTranslation=defaulTranslation;
        mMiwokTranslation=MiwokTranslation;
        mResouceId=resourceId;
    }



    public Word(String defaultTranslation,String MiwokTranslation,int imageResourceId,int resourceId){
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation= MiwokTranslation;
        mImageResourceId=imageResourceId;
        mResouceId=resourceId;
    }

    public String getDefaultTranslation() {return mDefaultTranslation;}
    public String getMiwokTranslation(){return  mMiwokTranslation;}
    public int getImageResouceId() {return mImageResourceId;}
    public int getAudio(){return mResouceId;}

    public boolean hasimage(){
       return mImageResourceId != SET_IMAGE;
    }
}
