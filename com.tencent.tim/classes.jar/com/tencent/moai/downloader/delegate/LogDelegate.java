package com.tencent.moai.downloader.delegate;

public abstract interface LogDelegate
{
  public static final int DEBUG = 1;
  public static final int ERROR = 4;
  public static final int INFO = 2;
  public static final int VERBOSE = 0;
  public static final int WARM = 3;
  
  public abstract void log(int paramInt, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.delegate.LogDelegate
 * JD-Core Version:    0.7.0.1
 */