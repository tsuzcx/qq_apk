package okhttp3;

import java.io.IOException;
import okio.Timeout;

public abstract interface Call
  extends Cloneable
{
  public abstract void cancel();
  
  public abstract Call clone();
  
  public abstract void enqueue(Callback paramCallback);
  
  public abstract Response execute()
    throws IOException;
  
  public abstract boolean isCanceled();
  
  public abstract boolean isExecuted();
  
  public abstract Request request();
  
  public abstract Timeout timeout();
  
  public static abstract interface Factory
  {
    public abstract Call newCall(Request paramRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.Call
 * JD-Core Version:    0.7.0.1
 */