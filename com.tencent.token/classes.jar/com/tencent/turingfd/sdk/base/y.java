package com.tencent.turingfd.sdk.base;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.SparseArray;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class y
{
  public static final cx<y> a = new a();
  public boolean b = false;
  public t c;
  public Handler d;
  public Handler e;
  public final List<ac> f = new ArrayList();
  public at g;
  public s h;
  public final c i = new c("checkStopSensor");
  public final Runnable j = new b("openSensorCallback");
  
  public y()
  {
    HandlerThread localHandlerThread = new HandlerThread("TuringMMSensor");
    localHandlerThread.start();
    this.e = new Handler(localHandlerThread.getLooper());
  }
  
  public final void a()
  {
    ??? = this.c;
    if (??? != null) {
      ((t)???).b();
    }
    synchronized (this.f)
    {
      this.f.clear();
      return;
    }
  }
  
  public final void a(Handler paramHandler, s params)
  {
    for (;;)
    {
      try
      {
        if (this.b)
        {
          ??? = this.g;
          if (??? != null) {}
        }
        else
        {
          return;
        }
        this.b = false;
        paramHandler.removeCallbacks(this.j);
        paramHandler.removeCallbacks(this.i);
        paramHandler = this.c;
        if (paramHandler == null) {
          continue;
        }
        paramHandler.a();
        paramHandler = this.c;
        if ((int)(paramHandler.e.d / ay.a) < 1)
        {
          ((bb.d)params).a(-100);
          continue;
        }
        paramHandler = paramHandler.c();
      }
      finally {}
      if (paramHandler.size() == 0)
      {
        ((bb.d)params).a(-101);
        continue;
      }
      synchronized (this.f)
      {
        ArrayList localArrayList = new ArrayList(this.f);
        if (localArrayList.size() < 1)
        {
          ((bb.d)params).a(-102);
          continue;
        }
        ??? = this.g;
        ((bb.d)params).a((at)???, localArrayList, paramHandler);
      }
    }
  }
  
  public static final class a
    extends cx<y>
  {
    public Object a()
    {
      return new y(null);
    }
  }
  
  public class b
    extends x
  {
    public b(String paramString)
    {
      super();
    }
    
    public void a()
    {
      synchronized (y.this)
      {
        if (!y.c(y.this)) {
          return;
        }
        if (y.g(y.this) == null) {
          return;
        }
      }
      if (!y.g(y.this).a(y.a(y.this).b, y.h(y.this))) {
        return;
      }
      long l = y.g(y.this).e.b;
      y.c localc = y.f(y.this);
      int i = (int)(y.a(y.this).b / ay.a);
      localc.a = 1;
      localc.b = i;
      localc.c = l;
      l = l + ay.a - System.currentTimeMillis();
      if (l > 0L) {
        y.d(y.this).postDelayed(y.f(y.this), l);
      }
      for (;;)
      {
        return;
        y.d(y.this).post(y.f(y.this));
      }
    }
  }
  
  private class c
    extends x
  {
    public int a = 1;
    public int b = 1;
    public long c = 0L;
    
    public c(String paramString)
    {
      super();
    }
    
    public void a()
    {
      ac localac = new ac();
      ??? = y.a(y.this).c;
      if (Build.VERSION.SDK_INT >= 24) {}
      label278:
      for (;;)
      {
        ??? = ((Context)???).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (??? == null) {}
        label51:
        synchronized (y.b(y.this))
        {
          y.b(y.this).add(localac);
          int i = this.a;
          if (i >= this.b) {
            try
            {
              if (!y.c(y.this))
              {
                return;
                Object localObject4 = cm.a(new File(ct.a(ct.an)));
                if (TextUtils.isEmpty((CharSequence)localObject4)) {
                  continue;
                }
                if ("CONFIGURED".equals(localObject4))
                {
                  for (;;)
                  {
                    try
                    {
                      localObject4 = ((Context)???).getContentResolver();
                      i = Settings.Secure.getInt((ContentResolver)localObject4, "adb_enabled", 0);
                      if (i <= 0) {
                        continue;
                      }
                      i = 1;
                    }
                    catch (Throwable localThrowable)
                    {
                      i = 0;
                      continue;
                      localac.a = 3;
                    }
                    if (i == 0) {
                      continue;
                    }
                    localac.a = 1;
                    break;
                    i = 0;
                  }
                  continue;
                }
                if ("DISCONNECTED".equals(localThrowable))
                {
                  localac.a = 2;
                  continue;
                }
                if (!"CONNECTED".equals(localThrowable)) {
                  continue;
                }
                localac.a = 3;
                continue;
                i = ((Intent)???).getIntExtra("status", -1);
                if ((i == 2) || (i == 5)) {}
                for (i = 1;; i = 0)
                {
                  if (i != 0) {
                    break label278;
                  }
                  localac.b = 1;
                  break;
                }
                i = ((Intent)???).getIntExtra("plugged", -1);
                if (i == 2)
                {
                  localac.b = 3;
                  break label51;
                }
                if (i == 1)
                {
                  localac.b = 2;
                  break label51;
                }
                localac.b = 0;
                break label51;
              }
              y.a(y.this, y.d(y.this), y.e(y.this));
              return;
            }
            finally {}
          }
          this.a = (i + 1);
          long l = this.c + ay.a * this.a - System.currentTimeMillis();
          if (l > 0L)
          {
            y.d(y.this).postDelayed(y.f(y.this), l);
            return;
          }
          y.d(y.this).post(y.f(y.this));
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.y
 * JD-Core Version:    0.7.0.1
 */