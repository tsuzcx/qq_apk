package com.tencent.intervideo.nowproxy.customized_interface;

public abstract interface CustomizedLog
{
  public static final int D = 1;
  public static final int E = 4;
  public static final int I = 2;
  public static final int V = 0;
  public static final int W = 3;
  public static final int WTF = 5;
  
  public abstract void onFlushLogs();
  
  public abstract void onLog(int paramInt, String paramString1, String paramString2);
  
  public abstract void onUploadLogs();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.customized_interface.CustomizedLog
 * JD-Core Version:    0.7.0.1
 */