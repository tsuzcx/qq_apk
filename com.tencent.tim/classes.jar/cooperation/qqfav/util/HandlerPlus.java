package cooperation.qqfav.util;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import java.lang.ref.WeakReference;

public class HandlerPlus
  extends Handler
{
  private final SparseArray<TimerRunnable> dZ = new SparseArray();
  private WeakReference<Handler.Callback> mWeakReferCallBack;
  
  public HandlerPlus(Handler.Callback paramCallback)
  {
    this.mWeakReferCallBack = new WeakReference(paramCallback);
  }
  
  public HandlerPlus(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper);
    this.mWeakReferCallBack = new WeakReference(paramCallback);
  }
  
  public boolean a(Runnable paramRunnable, int paramInt, long paramLong1, long paramLong2)
  {
    synchronized (this.dZ)
    {
      TimerRunnable localTimerRunnable2 = (TimerRunnable)this.dZ.get(paramRunnable.hashCode());
      TimerRunnable localTimerRunnable1 = localTimerRunnable2;
      if (localTimerRunnable2 == null)
      {
        localTimerRunnable1 = new TimerRunnable(paramRunnable, null);
        this.dZ.put(paramRunnable.hashCode(), localTimerRunnable1);
      }
      localTimerRunnable1.bZm = paramInt;
      localTimerRunnable1.azB = paramLong1;
      return postDelayed(localTimerRunnable1, paramLong2);
    }
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Handler.Callback localCallback = (Handler.Callback)this.mWeakReferCallBack.get();
    if (localCallback != null) {
      localCallback.handleMessage(paramMessage);
    }
  }
  
  class TimerRunnable
    implements Runnable
  {
    long azB;
    int bZm;
    private WeakReference<Runnable> jb;
    
    private TimerRunnable(Runnable paramRunnable)
    {
      this.jb = new WeakReference(paramRunnable);
    }
    
    public void run()
    {
      Runnable localRunnable = (Runnable)this.jb.get();
      if ((localRunnable != null) && (this.bZm > 0))
      {
        this.bZm -= 1;
        localRunnable.run();
        if (this.bZm > 0) {
          HandlerPlus.this.a(localRunnable, this.bZm, this.azB, 0L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqfav.util.HandlerPlus
 * JD-Core Version:    0.7.0.1
 */