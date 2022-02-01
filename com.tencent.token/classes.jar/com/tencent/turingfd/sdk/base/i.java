package com.tencent.turingfd.sdk.base;

import android.app.Activity;
import android.app.Application;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class i
{
  public static boolean a = false;
  public static Handler b;
  public static Set<Object> c = new CopyOnWriteArraySet();
  public static Set<g> d = new CopyOnWriteArraySet();
  public static h e;
  public static boolean f = false;
  public static Set<String> g = new HashSet();
  public static final m h = new a();
  public static final q i = new b();
  public static final g j = new c();
  
  public static void a()
  {
    try
    {
      HandlerThread localHandlerThread = new HandlerThread("TuringDispatch");
      localHandlerThread.start();
      b = new d(localHandlerThread.getLooper());
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
  
  public static final class a
    extends m
  {
    public void a(Activity paramActivity, String paramString)
    {
      if ((i.g.contains(paramActivity.getClass().getName())) || (i.f)) {
        i.a(paramActivity);
      }
    }
    
    public void onActivityPaused(Activity paramActivity)
    {
      i.e.b(paramActivity);
    }
    
    public void onActivityResumed(Activity paramActivity)
    {
      a(paramActivity, "onActivityResumed");
      i.e.a(paramActivity);
    }
  }
  
  public static final class b
    implements q
  {
    public void a(String paramString, MotionEvent paramMotionEvent)
    {
      j localj = j.a();
      localj.m = paramString;
      localj.f = paramMotionEvent.getAction();
      localj.g = paramMotionEvent.getDeviceId();
      localj.h = paramMotionEvent.getToolType(0);
      localj.i = paramMotionEvent.getRawX();
      localj.j = paramMotionEvent.getRawY();
      localj.k = paramMotionEvent.getPressure();
      localj.l = paramMotionEvent.getSize();
      i.b.obtainMessage(1, localj).sendToTarget();
    }
  }
  
  public static final class c
    implements g
  {
    public void a(String paramString, View paramView)
    {
      Iterator localIterator = i.d.iterator();
      while (localIterator.hasNext()) {
        ((g)localIterator.next()).a(paramString, paramView);
      }
    }
  }
  
  private static class d
    extends Handler
  {
    public d(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what != 1) {
        return;
      }
      paramMessage = paramMessage.obj;
      if (paramMessage == null) {
        return;
      }
      if (!(paramMessage instanceof j)) {
        return;
      }
      j localj = (j)paramMessage;
      Iterator localIterator = i.c.iterator();
      while (localIterator.hasNext())
      {
        c.d locald = (c.d)localIterator.next();
        if (locald.e.equals(localj.m))
        {
          int j = localj.g;
          int i = 0;
          boolean bool;
          if (j <= 0) {
            bool = true;
          } else {
            bool = false;
          }
          locald.f = bool;
          if (Build.VERSION.SDK_INT >= 14)
          {
            if (localj.h == 0) {
              bool = true;
            } else {
              bool = false;
            }
            locald.g = bool;
          }
          switch (localj.f)
          {
          default: 
            break;
          case 3: 
            locald.a();
            break;
          case 2: 
            if (locald.b != -1L) {
              i = 1;
            }
            if (i != 0)
            {
              paramMessage = new c.c(locald.h, 2, localj.i, localj.j, localj.k, localj.l);
            }
            else
            {
              locald.a();
              paramMessage = new c.c(locald.h, 0, localj.i, localj.j, localj.k, localj.l);
              locald.b = System.currentTimeMillis();
            }
            locald.d.add(paramMessage);
            break;
          case 1: 
            long l = locald.b;
            locald.c = (System.currentTimeMillis() - l);
            paramMessage = new c.c(locald.h, 1, localj.i, localj.j, localj.k, localj.l);
            locald.d.add(paramMessage);
            paramMessage = c.a(locald.h, locald.d);
            paramMessage = c.a(locald.h, locald.b, locald.c, paramMessage);
            if ((!locald.f) && (!locald.g)) {
              c.a(locald.h, locald.e, locald.a, 1, paramMessage);
            } else {
              c.a(locald.h, locald.e, locald.a, 2, paramMessage);
            }
            locald.a();
            break;
          case 0: 
            locald.a();
            locald.b = System.currentTimeMillis();
            paramMessage = new c.c(locald.h, 0, localj.i, localj.j, localj.k, localj.l);
            locald.d.add(paramMessage);
          }
        }
      }
      localj.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.i
 * JD-Core Version:    0.7.0.1
 */