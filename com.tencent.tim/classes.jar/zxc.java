import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class zxc
  extends Handler
{
  private boolean isRunning;
  private long mCountdownInterval = 1000L;
  public CopyOnWriteArrayList<zxc.a> mListeners = new CopyOnWriteArrayList();
  private boolean mPause;
  private long mStopTimeInFuture;
  
  public zxc() {}
  
  public zxc(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a(zxc.a parama)
  {
    long l = SystemClock.elapsedRealtime();
    if (zxc.a.a(parama) > l)
    {
      this.mListeners.add(parama);
      setTime(zxc.a.a(parama) - l);
      return;
    }
    parama.onFinish();
  }
  
  public void b(zxc.a parama)
  {
    this.mListeners.remove(parama);
  }
  
  public void cse()
  {
    if (this.mListeners.isEmpty()) {
      stop();
    }
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((zxc.a)localIterator.next()).tick();
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        l = this.mStopTimeInFuture - SystemClock.elapsedRealtime();
        if (l <= 0L)
        {
          onFinish();
          return;
        }
        if (l < this.mCountdownInterval)
        {
          sendMessageDelayed(obtainMessage(1), l);
          continue;
        }
        l = SystemClock.elapsedRealtime();
      }
      finally {}
      cse();
      for (long l = l + this.mCountdownInterval - SystemClock.elapsedRealtime(); l < 0L; l += this.mCountdownInterval) {}
      sendMessageDelayed(obtainMessage(1), l);
    }
  }
  
  public void notifyFinish()
  {
    if (this.mListeners.size() < 2) {
      stop();
    }
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((zxc.a)localIterator.next()).onFinish();
    }
  }
  
  public void onFinish()
  {
    this.isRunning = false;
    cse();
    notifyFinish();
  }
  
  public void pause()
  {
    removeMessages(1);
    this.mPause = true;
  }
  
  public void resume()
  {
    this.mPause = false;
    if (this.mStopTimeInFuture >= SystemClock.elapsedRealtime()) {
      sendMessage(obtainMessage(1));
    }
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    if (!this.mPause) {
      return super.sendMessageAtTime(paramMessage, paramLong);
    }
    return false;
  }
  
  public void setTime(long paramLong)
  {
    this.mStopTimeInFuture = Math.max(SystemClock.elapsedRealtime() + 1000L * paramLong, this.mStopTimeInFuture);
    start();
  }
  
  public void start()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.isRunning;
        if (bool) {
          return;
        }
        if (this.mStopTimeInFuture <= SystemClock.elapsedRealtime())
        {
          onFinish();
          continue;
        }
        this.isRunning = true;
      }
      finally {}
      sendMessage(obtainMessage(1));
    }
  }
  
  public void stop()
  {
    this.isRunning = false;
    removeMessages(1);
    this.mListeners.clear();
  }
  
  public static abstract class a
  {
    private long LD;
    private zxc a;
    private long mStopTimeInFuture;
    
    public a(long paramLong)
    {
      gD(paramLong);
    }
    
    public void gD(long paramLong)
    {
      if (this.a != null) {
        this.a.setTime(paramLong);
      }
      this.LD = paramLong;
      this.mStopTimeInFuture = (SystemClock.elapsedRealtime() + 1000L * paramLong);
    }
    
    public abstract void onFinish();
    
    public abstract void onTick(long paramLong);
    
    public final void tick()
    {
      long l = this.mStopTimeInFuture - SystemClock.elapsedRealtime();
      if (l > 1000L)
      {
        onTick(l);
        return;
      }
      onFinish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zxc
 * JD-Core Version:    0.7.0.1
 */