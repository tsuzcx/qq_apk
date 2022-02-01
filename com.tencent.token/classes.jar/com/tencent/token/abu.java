package com.tencent.token;

import android.app.Activity;
import android.app.Application;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class abu
{
  public static boolean a = false;
  public static Handler b;
  public static Set<Object> c = new CopyOnWriteArraySet();
  public static Set<abs> d = new CopyOnWriteArraySet();
  public static abt e;
  public static boolean f = false;
  public static Set<String> g = new HashSet();
  public static final aby h = new a();
  public static final acc i = new b();
  public static final abs j = new c();
  
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
    extends aby
  {
    public final void a(Activity paramActivity)
    {
      if ((abu.g.contains(paramActivity.getClass().getName())) || (abu.f)) {
        abu.a(paramActivity);
      }
    }
    
    public final void onActivityPaused(Activity paramActivity)
    {
      abu.e.b(paramActivity);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      a(paramActivity);
      abu.e.a(paramActivity);
    }
  }
  
  public static final class b
    implements acc
  {}
  
  public static final class c
    implements abs
  {
    public final void a(String paramString, View paramView)
    {
      Iterator localIterator = abu.d.iterator();
      while (localIterator.hasNext()) {
        ((abs)localIterator.next()).a(paramString, paramView);
      }
    }
  }
  
  public static final class d
    extends Handler
  {
    public d(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message arg1)
    {
      if (???.what == 1)
      {
        ??? = ???.obj;
        if ((??? != null) && ((??? instanceof abv)))
        {
          abv localabv = (abv)???;
          Iterator localIterator = abu.c.iterator();
          for (;;)
          {
            boolean bool = localIterator.hasNext();
            int i = 0;
            if (!bool) {
              break;
            }
            abo.d locald = (abo.d)localIterator.next();
            if (locald.e.equals(localabv.m))
            {
              if (localabv.g <= 0) {
                bool = true;
              } else {
                bool = false;
              }
              locald.f = bool;
              if (Build.VERSION.SDK_INT >= 14)
              {
                if (localabv.h == 0) {
                  bool = true;
                } else {
                  bool = false;
                }
                locald.g = bool;
              }
              switch (localabv.f)
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
                  ??? = new abo.c(2, localabv.i, localabv.j, localabv.k, localabv.l);
                }
                else
                {
                  locald.a();
                  ??? = new abo.c(0, localabv.i, localabv.j, localabv.k, localabv.l);
                  locald.b = System.currentTimeMillis();
                }
                locald.d.add(???);
                break;
              case 1: 
                long l = locald.b;
                locald.c = (System.currentTimeMillis() - l);
                ??? = new abo.c(1, localabv.i, localabv.j, localabv.k, localabv.l);
                locald.d.add(???);
                ??? = abo.a(locald.d);
                ??? = abo.a(locald.b, locald.c, ???);
                if ((!locald.f) && (!locald.g)) {
                  abo.a(locald.h, locald.e, locald.a, 1, ???);
                } else {
                  abo.a(locald.h, locald.e, locald.a, 2, ???);
                }
                locald.a();
                break;
              case 0: 
                locald.a();
                locald.b = System.currentTimeMillis();
                ??? = new abo.c(0, localabv.i, localabv.j, localabv.k, localabv.l);
                locald.d.add(???);
              }
            }
          }
          if (!localabv.e) {
            synchronized (abv.c)
            {
              localabv.f = 0;
              localabv.g = 0;
              localabv.h = 0;
              localabv.i = 0.0F;
              localabv.j = 0.0F;
              localabv.k = 0.0F;
              localabv.l = 0.0F;
              localabv.m = "";
              if (abv.b < 20)
              {
                localabv.d = abv.a;
                localabv.e = true;
                abv.a = localabv;
                abv.b += 1;
              }
              return;
            }
          }
          throw new IllegalStateException("Already recycled.");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.abu
 * JD-Core Version:    0.7.0.1
 */