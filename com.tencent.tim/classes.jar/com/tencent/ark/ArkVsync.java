package com.tencent.ark;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;

class ArkVsync
{
  protected static final ArkEnvironmentManager ENV = ;
  protected static final String TAG = "ArkApp.ArkVsync";
  private static final ArkVsync gInstance = new ArkVsync();
  protected CallbackItem[] mCallbackArrays;
  protected ArrayList<CallbackItem> mCallbacks = new ArrayList();
  protected ArkVsyncImpl mImpl;
  
  private ArkVsync()
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      this.mImpl = new TimerVsync();
      return;
    }
    this.mImpl = new SystemVsync();
  }
  
  public static ArkVsync getInstance()
  {
    return gInstance;
  }
  
  void addFrameCallback(String paramString, ArkFrameCallback paramArkFrameCallback)
  {
    if ((paramArkFrameCallback == null) || (!ArkStateCenter.getInstance().isForeground()))
    {
      ENV.logE("ArkApp.ArkVsync", "add frame callback fail. callback:" + paramArkFrameCallback + ",isForeground:" + ArkStateCenter.getInstance().isForeground());
      return;
    }
    synchronized (this.mCallbacks)
    {
      Iterator localIterator = this.mCallbacks.iterator();
      while (localIterator.hasNext())
      {
        CallbackItem localCallbackItem = (CallbackItem)localIterator.next();
        if (localCallbackItem.callback == paramArkFrameCallback) {
          this.mCallbacks.remove(localCallbackItem);
        }
      }
      this.mCallbacks.add(new CallbackItem(paramString, paramArkFrameCallback));
      this.mCallbackArrays = null;
      if ((this.mCallbacks.size() == 1) && (this.mImpl != null)) {
        ArkDispatchTask.getInstance().postToArkThread(new ArkVsync.1(this, this));
      }
      return;
    }
  }
  
  void frameCallback()
  {
    for (;;)
    {
      int i;
      synchronized (this.mCallbacks)
      {
        if (this.mCallbacks.size() <= 0) {
          return;
        }
        if (this.mCallbackArrays == null) {
          this.mCallbackArrays = ((CallbackItem[])this.mCallbacks.toArray(new CallbackItem[this.mCallbacks.size()]));
        }
        CallbackItem[] arrayOfCallbackItem = this.mCallbackArrays;
        int j = arrayOfCallbackItem.length;
        i = 0;
        if (i < j)
        {
          CallbackItem localCallbackItem = arrayOfCallbackItem[i];
          if (localCallbackItem.isCallbacking) {
            break label122;
          }
          localCallbackItem.isCallbacking = true;
          ArkDispatchQueue.asyncRun(localCallbackItem.queueKey, new ArkVsync.3(this, localCallbackItem));
        }
      }
      return;
      label122:
      i += 1;
    }
  }
  
  void removeFrameCallback(ArkFrameCallback paramArkFrameCallback)
  {
    if (paramArkFrameCallback == null) {
      return;
    }
    synchronized (this.mCallbacks)
    {
      Iterator localIterator = this.mCallbacks.iterator();
      while (localIterator.hasNext())
      {
        CallbackItem localCallbackItem = (CallbackItem)localIterator.next();
        if (localCallbackItem.callback == paramArkFrameCallback)
        {
          localCallbackItem.callback = null;
          this.mCallbacks.remove(localCallbackItem);
        }
      }
      this.mCallbackArrays = null;
      if ((this.mCallbacks.size() == 0) && (this.mImpl != null)) {
        ArkDispatchTask.getInstance().postToArkThread(new ArkVsync.2(this));
      }
      return;
    }
  }
  
  public static abstract interface ArkFrameCallback
  {
    public abstract void doFrame();
  }
  
  public static abstract interface ArkVsyncImpl
  {
    public abstract void start(ArkVsync paramArkVsync);
    
    public abstract void stop();
  }
  
  static class CallbackItem
  {
    ArkVsync.ArkFrameCallback callback;
    boolean isCallbacking = false;
    String queueKey;
    
    CallbackItem(String paramString, ArkVsync.ArkFrameCallback paramArkFrameCallback)
    {
      this.queueKey = paramString;
      this.callback = paramArkFrameCallback;
    }
  }
  
  static final class SystemVsync
    implements Choreographer.FrameCallback, ArkVsync.ArkVsyncImpl
  {
    Choreographer mChoreographer;
    ArkVsync mVsync;
    
    public void doFrame(long paramLong)
    {
      if ((this.mVsync == null) || (this.mChoreographer == null)) {
        return;
      }
      this.mVsync.frameCallback();
      this.mChoreographer.postFrameCallback(this);
    }
    
    public void start(ArkVsync paramArkVsync)
    {
      if (this.mVsync != null)
      {
        Log.d("ArkApp.ArkVsync", String.format("mVsync != null", new Object[0]));
        return;
      }
      this.mVsync = paramArkVsync;
      ArkDispatchTask.getInstance().postToArkThread(new ArkVsync.SystemVsync.1(this));
    }
    
    public void stop()
    {
      ArkDispatchTask.getInstance().postToArkThread(new ArkVsync.SystemVsync.2(this));
    }
  }
  
  static final class TimerVsync
    implements ArkVsync.ArkVsyncImpl, Runnable
  {
    volatile boolean mCallbacking;
    Timer mTimer;
    ArkVsync mVsync;
    
    public void run()
    {
      if (this.mVsync != null) {
        this.mVsync.frameCallback();
      }
    }
    
    public void start(ArkVsync paramArkVsync)
    {
      if (this.mVsync != null) {
        return;
      }
      this.mTimer = new Timer();
      this.mVsync = paramArkVsync;
      this.mTimer.scheduleAtFixedRate(new ArkVsync.TimerVsync.1(this), 0L, 16L);
    }
    
    public void stop()
    {
      if (this.mTimer != null)
      {
        this.mTimer.cancel();
        this.mTimer.purge();
        this.mTimer = null;
      }
      this.mVsync = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkVsync
 * JD-Core Version:    0.7.0.1
 */