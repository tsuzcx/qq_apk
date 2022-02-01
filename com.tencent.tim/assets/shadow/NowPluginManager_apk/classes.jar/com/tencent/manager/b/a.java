package com.tencent.manager.b;

import android.os.Handler;
import android.os.HandlerThread;

public class a
{
  private static a a = new a("AV_THREAD");
  private static a b = new a("BIZ_THREAD");
  private Handler c;
  private String d;
  
  private a(String paramString)
  {
    this.d = paramString;
  }
  
  public static a a()
  {
    return a;
  }
  
  public static a b()
  {
    return b;
  }
  
  public void a(final Runnable paramRunnable)
  {
    this.c.post(new Runnable()
    {
      public void run()
      {
        paramRunnable.run();
      }
    });
  }
  
  public void a(final Runnable paramRunnable, long paramLong)
  {
    this.c.postDelayed(new Runnable()
    {
      public void run()
      {
        paramRunnable.run();
      }
    }, paramLong);
  }
  
  public void c()
  {
    HandlerThread localHandlerThread = new HandlerThread(this.d);
    localHandlerThread.start();
    this.c = new Handler(localHandlerThread.getLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.b.a
 * JD-Core Version:    0.7.0.1
 */