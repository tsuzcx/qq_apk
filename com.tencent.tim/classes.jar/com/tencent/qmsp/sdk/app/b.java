package com.tencent.qmsp.sdk.app;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qmsp.sdk.f.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  private static final byte[] d = { 20, 96, -116, 77, 47, 50, 121 };
  private static final byte[] e = { 20, 96, -116, 100, 33, 44, 121, -15, 42, 113, -73 };
  private static b f;
  private List<HandlerThread> a = new ArrayList();
  private Handler b = null;
  private Handler c = null;
  
  private Handler a(String paramString)
  {
    paramString = new HandlerThread(paramString);
    paramString.start();
    Handler localHandler = new Handler(paramString.getLooper());
    this.a.add(paramString);
    return localHandler;
  }
  
  public static b e()
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new b();
      }
      return f;
    }
    finally {}
  }
  
  public void a(Runnable paramRunnable)
  {
    this.b.post(paramRunnable);
  }
  
  public boolean a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      HandlerThread localHandlerThread = (HandlerThread)localIterator.next();
      if (localHandlerThread.getName().equalsIgnoreCase(k.a(d))) {
        return localHandlerThread.isAlive();
      }
    }
    return false;
  }
  
  public Looper b()
  {
    return this.c.getLooper();
  }
  
  public Looper c()
  {
    return this.b.getLooper();
  }
  
  public void d()
  {
    Handler localHandler = this.b;
    if (localHandler != null)
    {
      localHandler.getLooper().quit();
      this.b = null;
    }
    localHandler = this.c;
    if (localHandler != null)
    {
      localHandler.getLooper().quit();
      this.c = null;
    }
    if (f != null) {
      f = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.app.b
 * JD-Core Version:    0.7.0.1
 */