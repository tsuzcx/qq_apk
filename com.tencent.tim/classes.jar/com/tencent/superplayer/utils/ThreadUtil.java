package com.tencent.superplayer.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadUtil
{
  private static final int CORE_POOL_SIZE;
  private static final int CPU_COUNT;
  private static final int KEEP_ALIVE_SECONDS = 30;
  private static final int MAXIMUM_POOL_SIZE;
  public static final Executor THREAD_POOL_EXECUTOR;
  private static volatile UIHandler sMainThreadHandler = null;
  private static final BlockingQueue<Runnable> sPoolWorkQueue;
  private static volatile HandlerThread sSubThread = null;
  private static volatile Handler sSubThreadHandler = null;
  private static final ThreadFactory sThreadFactory;
  private static final Executor sThreadPool = THREAD_POOL_EXECUTOR;
  
  static
  {
    CPU_COUNT = Runtime.getRuntime().availableProcessors();
    CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    sThreadFactory = new ThreadUtil.1();
    sPoolWorkQueue = new LinkedBlockingQueue(128);
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    THREAD_POOL_EXECUTOR = localThreadPoolExecutor;
  }
  
  public static Handler getSubThreadHandler()
  {
    if (sSubThreadHandler == null) {}
    try
    {
      if (sSubThreadHandler == null) {
        sSubThreadHandler = new Handler(getSubThreadLooper());
      }
      return sSubThreadHandler;
    }
    finally {}
  }
  
  public static Looper getSubThreadLooper()
  {
    try
    {
      initSubThreadHandler();
      Looper localLooper = sSubThread.getLooper();
      return localLooper;
    }
    finally {}
  }
  
  public static Handler getUIHandler()
  {
    initMainThreadHandler();
    return sMainThreadHandler;
  }
  
  private static void initMainThreadHandler()
  {
    if (sMainThreadHandler == null) {
      try
      {
        if (sMainThreadHandler == null)
        {
          Looper localLooper = Looper.getMainLooper();
          if (localLooper != null) {
            sMainThreadHandler = new UIHandler(localLooper);
          }
        }
        else
        {
          return;
        }
        sMainThreadHandler = null;
        throw new IllegalStateException("cannot get UI Thread looper!");
      }
      finally {}
    }
  }
  
  private static void initSubThreadHandler()
  {
    if (sSubThread == null) {
      try
      {
        if (sSubThread == null)
        {
          sSubThread = new DebugHandlerThread("SuperPlayerSubThread");
          sSubThread.start();
        }
        return;
      }
      finally {}
    }
  }
  
  public static void runOnThreadPool(@NonNull Runnable paramRunnable)
  {
    sThreadPool.execute(paramRunnable);
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      paramRunnable.run();
    }
    do
    {
      return;
      initMainThreadHandler();
    } while (sMainThreadHandler == null);
    sMainThreadHandler.post(paramRunnable);
  }
  
  static class DebugHandlerThread
    extends HandlerThread
  {
    private static final String TAG = "DebugHandlerThread";
    
    public DebugHandlerThread(String paramString)
    {
      super();
      LogUtil.e("DebugHandlerThread", "create");
    }
    
    public Looper getLooper()
    {
      LogUtil.e("DebugHandlerThread", "getLooper start, alive=" + isAlive());
      Looper localLooper = super.getLooper();
      LogUtil.e("DebugHandlerThread", "getLooper finished looper=" + localLooper + ", alive=" + isAlive());
      return localLooper;
    }
    
    protected void onLooperPrepared()
    {
      super.onLooperPrepared();
      LogUtil.e("DebugHandlerThread", "onLooperPrepared");
    }
    
    public void run()
    {
      LogUtil.e("DebugHandlerThread", "start run");
      super.run();
    }
  }
  
  static class UIHandler
    extends Handler
  {
    public UIHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.utils.ThreadUtil
 * JD-Core Version:    0.7.0.1
 */