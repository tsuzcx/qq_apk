package com.tencent.image;

public abstract class AbsThirdDataSourceAdapter
{
  public static final int STATUS_NOT_PREPARED = 0;
  public static final int STATUS_PREPARED = 2;
  public static final int STATUS_PREPARING = 1;
  
  public abstract int getPlayType();
  
  public abstract int getStaus();
  
  public abstract String getURL();
  
  public abstract void requestPrepare(String paramString, OnPreparedCallback paramOnPreparedCallback);
  
  public static abstract interface OnPreparedCallback
  {
    public abstract void onPrepared();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.AbsThirdDataSourceAdapter
 * JD-Core Version:    0.7.0.1
 */