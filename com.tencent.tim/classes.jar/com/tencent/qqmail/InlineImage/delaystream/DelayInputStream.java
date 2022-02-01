package com.tencent.qqmail.InlineImage.delaystream;

import android.util.Log;
import com.tencent.qqmail.InlineImage.fetcher.Fetcher;
import java.io.IOException;
import java.io.InputStream;

abstract class DelayInputStream
  extends InputStream
{
  private static final String TAG = "DelayInputStream";
  protected Fetcher fetcher;
  private InputStream inputStream = null;
  protected String url;
  
  public DelayInputStream(String paramString)
  {
    this.url = paramString;
  }
  
  public void close()
    throws IOException
  {
    super.close();
    Log.i("DelayInputStream", "closing " + this.url);
    if (this.inputStream != null) {
      this.inputStream.close();
    }
  }
  
  public int read()
    throws IOException
  {
    if (this.inputStream == null) {
      this.inputStream = this.fetcher.fetch(this.url);
    }
    if (this.inputStream == null) {
      return -1;
    }
    return this.inputStream.read();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.InlineImage.delaystream.DelayInputStream
 * JD-Core Version:    0.7.0.1
 */