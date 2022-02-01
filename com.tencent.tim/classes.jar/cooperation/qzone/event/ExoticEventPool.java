package cooperation.qzone.event;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import avsn;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ExoticEventPool
{
  private static final int MAX_QUEUE_SIZE = 20;
  private static final String TAG = "ExoticEventPool";
  private final BlockingQueue<ExoticEvent> mQueue = new LinkedBlockingDeque(20);
  
  @NonNull
  public static ExoticEventPool getInstance()
  {
    return a.a();
  }
  
  public boolean onEventReceived(@Nullable ExoticEvent paramExoticEvent)
  {
    if (avsn.aLz()) {
      return false;
    }
    if (paramExoticEvent == null) {
      return true;
    }
    try
    {
      boolean bool = this.mQueue.add(paramExoticEvent);
      return bool;
    }
    catch (Throwable paramExoticEvent)
    {
      QZLog.w("ExoticEventPool", "onEventReceived: failed to add event", paramExoticEvent);
    }
    return false;
  }
  
  @Nullable
  public ExoticEvent pollEvent()
  {
    try
    {
      ExoticEvent localExoticEvent = (ExoticEvent)this.mQueue.take();
      return localExoticEvent;
    }
    catch (Throwable localThrowable)
    {
      QZLog.w("ExoticEventPool", "pollEvent: failed to poll event", localThrowable);
    }
    return null;
  }
  
  static class a
  {
    private static final ExoticEventPool a = new ExoticEventPool(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.event.ExoticEventPool
 * JD-Core Version:    0.7.0.1
 */