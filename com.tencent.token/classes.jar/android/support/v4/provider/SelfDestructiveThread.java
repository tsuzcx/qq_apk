package android.support.v4.provider;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.GuardedBy;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class SelfDestructiveThread
{
  private static final int MSG_DESTRUCTION = 0;
  private static final int MSG_INVOKE_RUNNABLE = 1;
  private Handler.Callback mCallback = new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return true;
      case 1: 
        SelfDestructiveThread.this.onInvokeRunnable((Runnable)paramAnonymousMessage.obj);
        return true;
      }
      SelfDestructiveThread.this.onDestruction();
      return true;
    }
  };
  private final int mDestructAfterMillisec;
  @GuardedBy("mLock")
  private int mGeneration;
  @GuardedBy("mLock")
  private Handler mHandler;
  private final Object mLock = new Object();
  private final int mPriority;
  @GuardedBy("mLock")
  private HandlerThread mThread;
  private final String mThreadName;
  
  public SelfDestructiveThread(String paramString, int paramInt1, int paramInt2)
  {
    this.mThreadName = paramString;
    this.mPriority = paramInt1;
    this.mDestructAfterMillisec = paramInt2;
    this.mGeneration = 0;
  }
  
  private void onDestruction()
  {
    synchronized (this.mLock)
    {
      if (this.mHandler.hasMessages(1)) {
        return;
      }
      this.mThread.quit();
      this.mThread = null;
      this.mHandler = null;
      return;
    }
  }
  
  private void onInvokeRunnable(Runnable arg1)
  {
    ???.run();
    synchronized (this.mLock)
    {
      this.mHandler.removeMessages(0);
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), this.mDestructAfterMillisec);
      return;
    }
  }
  
  private void post(Runnable paramRunnable)
  {
    synchronized (this.mLock)
    {
      if (this.mThread == null)
      {
        this.mThread = new HandlerThread(this.mThreadName, this.mPriority);
        this.mThread.start();
        this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);
        this.mGeneration += 1;
      }
      this.mHandler.removeMessages(0);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramRunnable));
      return;
    }
  }
  
  @VisibleForTesting
  public int getGeneration()
  {
    synchronized (this.mLock)
    {
      int i = this.mGeneration;
      return i;
    }
  }
  
  @VisibleForTesting
  public boolean isRunning()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.mThread != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public <T> void postAndReply(final Callable<T> paramCallable, final ReplyCallback<T> paramReplyCallback)
  {
    post(new Runnable()
    {
      public void run()
      {
        try
        {
          localObject = paramCallable.call();
        }
        catch (Exception localException)
        {
          final Object localObject;
          label13:
          break label13;
        }
        localObject = null;
        this.val$callingHandler.post(new Runnable()
        {
          public void run()
          {
            SelfDestructiveThread.2.this.val$reply.onReply(localObject);
          }
        });
      }
    });
  }
  
  public <T> T postAndWait(final Callable<T> paramCallable, int paramInt)
  {
    localReentrantLock = new ReentrantLock();
    final Condition localCondition = localReentrantLock.newCondition();
    final AtomicReference localAtomicReference = new AtomicReference();
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(true);
    post(new Runnable()
    {
      public void run()
      {
        try
        {
          localAtomicReference.set(paramCallable.call());
          label16:
          localReentrantLock.lock();
          try
          {
            localAtomicBoolean.set(false);
            localCondition.signal();
            return;
          }
          finally
          {
            localReentrantLock.unlock();
          }
        }
        catch (Exception localException)
        {
          break label16;
        }
      }
    });
    localReentrantLock.lock();
    label104:
    do
    {
      try
      {
        if (!localAtomicBoolean.get())
        {
          paramCallable = localAtomicReference.get();
          return paramCallable;
        }
        l1 = TimeUnit.MILLISECONDS.toNanos(paramInt);
      }
      finally
      {
        long l1;
        long l2;
        localReentrantLock.unlock();
      }
      try
      {
        l2 = localCondition.awaitNanos(l1);
        l1 = l2;
      }
      catch (InterruptedException paramCallable)
      {
        break label104;
      }
      if (!localAtomicBoolean.get())
      {
        paramCallable = localAtomicReference.get();
        localReentrantLock.unlock();
        return paramCallable;
      }
    } while (l1 > 0L);
    throw new InterruptedException("timeout");
  }
  
  public static abstract interface ReplyCallback<T>
  {
    public abstract void onReply(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.provider.SelfDestructiveThread
 * JD-Core Version:    0.7.0.1
 */