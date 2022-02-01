import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

public class arci
  implements Handler.Callback
{
  private final arci.a a;
  private boolean ajb = true;
  private boolean mCancelled;
  private final Handler mHandler;
  
  public arci(arci.a parama)
  {
    this.a = parama;
    this.mHandler = new auru(Looper.getMainLooper(), this);
  }
  
  public void av(Bundle paramBundle)
  {
    this.mCancelled = false;
    do
    {
      while (!this.mCancelled) {
        switch (this.a.m(paramBundle))
        {
        }
      }
      return;
    } while (!this.ajb);
    Message localMessage = this.mHandler.obtainMessage(1);
    localMessage.setData(paramBundle);
    this.mHandler.sendMessage(localMessage);
  }
  
  public void cFX()
  {
    this.ajb = false;
  }
  
  public void cancel()
  {
    this.mCancelled = true;
    this.mHandler.removeMessages(1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (!this.mCancelled) {
      av(paramMessage.getData());
    }
    return true;
  }
  
  public static abstract interface a
  {
    public abstract int m(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arci
 * JD-Core Version:    0.7.0.1
 */