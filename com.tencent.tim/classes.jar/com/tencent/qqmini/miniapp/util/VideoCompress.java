package com.tencent.qqmini.miniapp.util;

public class VideoCompress
{
  public static abstract interface Listener
  {
    public abstract void onFailure(String paramString);
    
    public abstract void onFinish(boolean paramBoolean);
    
    public abstract void onProgress(String paramString, float paramFloat);
    
    public abstract void onStart();
    
    public abstract void onSuccess(String paramString);
  }
  
  public static class Option
  {
    public int crf;
    public int scale;
    public VideoCompress.TargetEncoding targetEncoding;
    public int targetFrameRate;
  }
  
  public static enum TargetEncoding
  {
    x264;
    
    private TargetEncoding() {}
  }
  
  public static class X264EncodingOption
  {
    String preset;
    String profile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.VideoCompress
 * JD-Core Version:    0.7.0.1
 */