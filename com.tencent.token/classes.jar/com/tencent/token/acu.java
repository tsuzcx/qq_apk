package com.tencent.token;

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

public final class acu
{
  public static final agi<acu> a = new a();
  public boolean b = false;
  public act c;
  public Handler d;
  public Handler e;
  public final List<adb> f = new ArrayList();
  public afe g;
  public acq h;
  public final b i = new b();
  public final Runnable j = new c();
  
  public acu()
  {
    HandlerThread localHandlerThread = new HandlerThread("TuringMMSensor");
    localHandlerThread.start();
    this.e = new Handler(localHandlerThread.getLooper());
  }
  
  public final void a(Handler paramHandler, acq paramacq)
  {
    try
    {
      if ((this.b) && (this.g != null))
      {
        int k = 0;
        this.b = false;
        paramHandler.removeCallbacks(this.j);
        paramHandler.removeCallbacks(this.i);
        paramHandler = this.c;
        if (paramHandler != null)
        {
          paramHandler.a();
          ??? = this.c;
          long l = ((act)???).e.d / afg.a;
          if ((int)l <= 0) {
            return;
          }
          synchronized (((act)???).d)
          {
            paramHandler = new SparseArray();
            while (k < ((act)???).d.size())
            {
              paramHandler.append(((act)???).d.keyAt(k), (acv)((act)???).d.valueAt(k));
              k += 1;
            }
            if (!act.a(paramHandler)) {
              paramHandler = new SparseArray();
            }
            k = paramHandler.size();
            if (k == 0) {
              return;
            }
            synchronized (this.f)
            {
              ??? = new ArrayList(this.f);
              k = ((ArrayList)???).size();
              if (k <= 0) {
                return;
              }
              ??? = this.g;
              paramacq = (afk.b)paramacq;
              paramacq.getClass();
              k = ((afe)???).a;
              afk.a(paramacq.a);
              paramacq.a.f.post(new afv(k, paramHandler, (List)???, (afe)???));
              return;
            }
          }
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  public final class a
    extends agi<acu>
  {
    public final Object a()
    {
      return new acu();
    }
  }
  
  public final class b
    extends adk
  {
    public int a = 1;
    public int b = 1;
    public long c = 0L;
    
    public b() {}
    
    public final void a()
    {
      Object localObject1 = new adb();
      ??? = acu.this.g.c;
      String str;
      if (Build.VERSION.SDK_INT < 24)
      {
        str = adg.a(new File(agg.a(agg.an)));
        if ((!TextUtils.isEmpty(str)) && (!"CONFIGURED".equals(str))) {}
      }
      label88:
      try
      {
        i = Settings.Secure.getInt(((Context)???).getContentResolver(), "adb_enabled", 0);
        if (i > 0)
        {
          i = 1;
          break label88;
        }
      }
      finally {}
      int i = 0;
      if (i != 0)
      {
        ((adb)localObject1).a = 1;
      }
      else
      {
        ((adb)localObject1).a = 3;
        break label145;
        if ("DISCONNECTED".equals(str)) {
          ((adb)localObject1).a = 2;
        } else if ("CONNECTED".equals(str)) {
          ((adb)localObject1).a = 3;
        }
      }
      label145:
      ??? = ((Context)???).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (??? != null)
      {
        i = ((Intent)???).getIntExtra("status", -1);
        if ((i != 2) && (i != 5)) {
          i = 0;
        } else {
          i = 1;
        }
        if (i == 0)
        {
          ((adb)localObject1).b = 1;
        }
        else
        {
          i = ((Intent)???).getIntExtra("plugged", -1);
          if (i == 2) {
            ((adb)localObject1).b = 3;
          } else if (i == 1) {
            ((adb)localObject1).b = 2;
          } else {
            ((adb)localObject1).b = 0;
          }
        }
      }
      synchronized (acu.this.f)
      {
        acu.this.f.add(localObject1);
        i = this.a;
        if (i >= this.b) {
          try
          {
            localObject1 = acu.this;
            if (!((acu)localObject1).b) {
              return;
            }
            ((acu)localObject1).a(((acu)localObject1).d, ((acu)localObject1).h);
            return;
          }
          finally {}
        }
        i += 1;
        this.a = i;
        long l = this.c + afg.a * i - System.currentTimeMillis();
        if (l > 0L)
        {
          localacu = acu.this;
          localacu.d.postDelayed(localacu.i, l);
          return;
        }
        acu localacu = acu.this;
        localacu.d.post(localacu.i);
        return;
      }
    }
  }
  
  public final class c
    extends adk
  {
    public c() {}
    
    public final void a()
    {
      synchronized (acu.this)
      {
        acu localacu2 = acu.this;
        if (!localacu2.b) {
          return;
        }
        Object localObject2 = localacu2.c;
        if (localObject2 == null) {
          return;
        }
        if (!((act)localObject2).a(localacu2.g.b, localacu2.e)) {
          return;
        }
        localacu2 = acu.this;
        long l1 = localacu2.c.e.b;
        localObject2 = localacu2.i;
        long l2 = localacu2.g.b;
        long l3 = afg.a;
        int i = (int)(l2 / l3);
        ((acu.b)localObject2).a = 1;
        ((acu.b)localObject2).b = i;
        ((acu.b)localObject2).c = l1;
        l1 = l1 + l3 - System.currentTimeMillis();
        if (l1 > 0L)
        {
          localacu2 = acu.this;
          localacu2.d.postDelayed(localacu2.i, l1);
        }
        else
        {
          localacu2 = acu.this;
          localacu2.d.post(localacu2.i);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acu
 * JD-Core Version:    0.7.0.1
 */