package com.tencent.turingfd.sdk.base;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ba
{
  public static boolean a;
  public static Handler b;
  public static Set c = new CopyOnWriteArraySet();
  public static Set d = new CopyOnWriteArraySet();
  public static aw e;
  public static boolean f = false;
  public static Set g = new HashSet();
  public static final bk h = new ay();
  public static final bt i = new ax();
  public static final av j = new az();
  
  public static void a()
  {
    try
    {
      HandlerThread localHandlerThread = new HandlerThread("TuringDispatch");
      localHandlerThread.start();
      b = new bb(localHandlerThread.getLooper());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(Application paramApplication)
  {
    try
    {
      paramApplication.unregisterActivityLifecycleCallbacks(h);
      paramApplication.registerActivityLifecycleCallbacks(h);
      return;
    }
    finally
    {
      paramApplication = finally;
      throw paramApplication;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ba
 * JD-Core Version:    0.7.0.1
 */