package com.tencent.qqmail.InlineImage.delaystream;

import com.tencent.qqmail.InlineImage.fetcher.HttpImageFetcher;

public class DelayHttpInputStream
  extends DelayInputStream
{
  private static final String TAG = "DelayHttpInputStream";
  
  public DelayHttpInputStream(String paramString, int paramInt)
  {
    super(paramString);
    this.fetcher = new HttpImageFetcher(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.InlineImage.delaystream.DelayHttpInputStream
 * JD-Core Version:    0.7.0.1
 */