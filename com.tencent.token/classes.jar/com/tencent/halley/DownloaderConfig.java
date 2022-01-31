package com.tencent.halley;

public class DownloaderConfig
{
  public static final DownloaderConfig DEFAULT_DOWNLOADERCONFIG = new DownloaderConfig(2, 3);
  private int a = 0;
  private int b = 0;
  
  public DownloaderConfig(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public int getEaseTaskNum()
  {
    return this.b;
  }
  
  public int getMassTaskNum()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.DownloaderConfig
 * JD-Core Version:    0.7.0.1
 */