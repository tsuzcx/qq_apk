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

public final class abv
{
  public static boolean a = false;
  public static Handler b;
  public static Set<Object> c = new CopyOnWriteArraySet();
  public static Set<abt> d = new CopyOnWriteArraySet();
  public static abu e;
  public static boolean f = false;
  public static Set<String> g = new HashSet();
  public static final abz h = new a();
  public static final acd i = new b();
  public static final abt j = new c();
  
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
    extends abz
  {
    public final void a(Activity paramActivity)
    {
      if ((abv.g.contains(paramActivity.getClass().getName())) || (abv.f)) {
        abv.a(paramActivity);
      }
    }
    
    public final void onActivityPaused(Activity paramActivity)
    {
      abv.e.b(paramActivity);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      a(paramActivity);
      abv.e.a(paramActivity);
    }
  }
  
  public static final class b
    implements acd
  {}
  
  public static final class c
    implements abt
  {
    public final void a(String paramString, View paramView)
    {
      Iterator localIterator = abv.d.iterator();
      while (localIterator.hasNext()) {
        ((abt)localIterator.next()).a(paramString, paramView);
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
        if ((??? != null) && ((??? instanceof abw)))
        {
          abw localabw = (abw)???;
          Iterator localIterator = abv.c.iterator();
          for (;;)
          {
            boolean bool = localIterator.hasNext();
            int i = 0;
            if (!bool) {
              break;
            }
            abp.d locald = (abp.d)localIterator.next();
            if (locald.e.equals(localabw.m))
            {
              if (localabw.g <= 0) {
                bool = true;
              } else {
                bool = false;
              }
              locald.f = bool;
              if (Build.VERSION.SDK_INT >= 14)
              {
                if (localabw.h == 0) {
                  bool = true;
                } else {
                  bool = false;
                }
                locald.g = bool;
              }
              switch (localabw.f)
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
                  ??? = new abp.c(2, localabw.i, localabw.j, localabw.k, localabw.l);
                }
                else
                {
                  locald.a();
                  ??? = new abp.c(0, localabw.i, localabw.j, localabw.k, localabw.l);
                  locald.b = System.currentTimeMillis();
                }
                locald.d.add(???);
                break;
              case 1: 
                long l = locald.b;
                locald.c = (System.currentTimeMillis() - l);
                ??? = new abp.c(1, localabw.i, localabw.j, localabw.k, localabw.l);
                locald.d.add(???);
                ??? = abp.a(locald.d);
                ??? = abp.a(locald.b, locald.c, ???);
                if ((!locald.f) && (!locald.g)) {
                  abp.a(locald.h, locald.e, locald.a, 1, ???);
                } else {
                  abp.a(locald.h, locald.e, locald.a, 2, ???);
                }
                locald.a();
                break;
              case 0: 
                locald.a();
                locald.b = System.currentTimeMillis();
                ??? = new abp.c(0, localabw.i, localabw.j, localabw.k, localabw.l);
                locald.d.add(???);
              }
            }
          }
          if (!localabw.e) {
            synchronized (abw.c)
            {
              localabw.f = 0;
              localabw.g = 0;
              localabw.h = 0;
              localabw.i = 0.0F;
              localabw.j = 0.0F;
              localabw.k = 0.0F;
              localabw.l = 0.0F;
              localabw.m = "";
              if (abw.b < 20)
              {
                localabw.d = abw.a;
                localabw.e = true;
                abw.a = localabw;
                abw.b += 1;
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
 * Qualified Name:     com.tencent.token.abv
 * JD-Core Version:    0.7.0.1
 */