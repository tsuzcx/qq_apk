package com.tencent.TMG.ptt;

public abstract interface PttListener
{
  public static abstract interface DownloadFileListener
  {
    public abstract void onCompleted(int paramInt, String paramString1, String paramString2);
  }
  
  public static abstract interface PlayFileListener
  {
    public abstract void onCompleted(int paramInt, String paramString);
  }
  
  public static abstract interface RecordFileListener
  {
    public abstract void onCompleted(int paramInt, String paramString);
  }
  
  public static abstract interface UploadFileListener
  {
    public abstract void onCompleted(int paramInt, String paramString1, String paramString2);
  }
  
  public static abstract interface Voice2TextListener
  {
    public abstract void onCompleted(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.ptt.PttListener
 * JD-Core Version:    0.7.0.1
 */