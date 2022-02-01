package com.tencent.viola.commons;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.utils.ViolaLogUtils;

public class ViolaThread
  extends HandlerThread
{
  private Handler mHandler;
  
  public ViolaThread(String paramString, Handler.Callback paramCallback)
  {
    super(paramString);
    start();
    this.mHandler = new Handler(getLooper(), secure(paramCallback));
  }
  
  public static Handler.Callback secure(Handler.Callback paramCallback)
  {
    if ((paramCallback == null) || ((paramCallback instanceof SafeCallback))) {
      return paramCallback;
    }
    return new SafeCallback(paramCallback);
  }
  
  public static Runnable secure(Runnable paramRunnable)
  {
    if ((paramRunnable == null) || ((paramRunnable instanceof SafeRunnable))) {
      return paramRunnable;
    }
    return new SafeRunnable(paramRunnable);
  }
  
  public Handler getHandler()
  {
    return this.mHandler;
  }
  
  public boolean isThreadAlive()
  {
    return (this.mHandler != null) && (getLooper() != null) && (isAlive());
  }
  
  static class SafeCallback
    implements Handler.Callback
  {
    static final String TAG = "SafeCallback";
    final Handler.Callback mCallback;
    
    SafeCallback(Handler.Callback paramCallback)
    {
      this.mCallback = paramCallback;
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      try
      {
        if (this.mCallback != null) {
          bool1 = this.mCallback.handleMessage(paramMessage);
        }
        return bool1;
      }
      catch (Throwable paramMessage)
      {
        do
        {
          bool1 = bool2;
        } while (!ViolaEnvironment.isDebugable());
        ViolaLogUtils.e("SafeCallback", "SafeCallback handleMessage throw expection:" + paramMessage.getMessage());
        throw paramMessage;
      }
    }
  }
  
  static class SafeRunnable
    implements Runnable
  {
    static final String TAG = "SafeRunnable";
    final Runnable mTask;
    
    SafeRunnable(Runnable paramRunnable)
    {
      this.mTask = paramRunnable;
    }
    
    public void run()
    {
      try
      {
        if (this.mTask != null) {
          this.mTask.run();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        while (!ViolaEnvironment.isDebugable()) {}
        ViolaLogUtils.e("SafeRunnable", "SafeRunnable run throw expection:" + localThrowable.getMessage());
        throw localThrowable;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.commons.ViolaThread
 * JD-Core Version:    0.7.0.1
 */