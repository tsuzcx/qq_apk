package com.tencent.token;

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

public final class ack
{
  public static final afj<ack> a = new a();
  public boolean b = false;
  public acf c;
  public Handler d;
  public Handler e;
  public final List<aco> f = new ArrayList();
  public adg g;
  public ace h;
  public final c i = new c();
  public final Runnable j = new b();
  
  public ack()
  {
    HandlerThread localHandlerThread = new HandlerThread("TuringMMSensor");
    localHandlerThread.start();
    this.e = new Handler(localHandlerThread.getLooper());
  }
  
  public final void a()
  {
    acf localacf = this.c;
    if (localacf != null) {
      synchronized (localacf.d)
      {
        localacf.d.clear();
      }
    }
    synchronized (this.f)
    {
      this.f.clear();
      return;
    }
  }
  
  public final void a(Handler paramHandler, ace paramace)
  {
    try
    {
      if ((this.b) && (this.g != null))
      {
        this.b = false;
        paramHandler.removeCallbacks(this.j);
        paramHandler.removeCallbacks(this.i);
        paramHandler = this.c;
        if (paramHandler != null)
        {
          paramHandler.a();
          paramHandler = this.c;
          if ((int)(paramHandler.e.d / adk.a) <= 0)
          {
            ((adn.d)paramace).a();
            return;
          }
          paramHandler = paramHandler.b();
          if (paramHandler.size() == 0)
          {
            ((adn.d)paramace).a();
            return;
          }
          synchronized (this.f)
          {
            ArrayList localArrayList = new ArrayList(this.f);
            if (localArrayList.size() <= 0)
            {
              ((adn.d)paramace).a();
              return;
            }
            ??? = this.g;
            paramace = (adn.d)paramace;
            int k = ((adg)???).a;
            adn.b();
            adn.c(paramace.a).post(new adn.d.a(k, paramHandler, localArrayList, (adg)???));
            return;
          }
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  public static final class a
    extends afj<ack>
  {
    public final Object a()
    {
      return new ack((byte)0);
    }
  }
  
  public final class b
    extends acj
  {
    public b() {}
    
    public final void a()
    {
      synchronized (ack.this)
      {
        if (!ack.c(ack.this)) {
          return;
        }
        if (ack.g(ack.this) == null) {
          return;
        }
        if (!ack.g(ack.this).a(ack.a(ack.this).b, ack.h(ack.this))) {
          return;
        }
        long l = ack.g(ack.this).e.b;
        ack.c localc = ack.f(ack.this);
        int i = (int)(ack.a(ack.this).b / adk.a);
        localc.a = 1;
        localc.b = i;
        localc.c = l;
        l = l + adk.a - System.currentTimeMillis();
        if (l > 0L) {
          ack.d(ack.this).postDelayed(ack.f(ack.this), l);
        } else {
          ack.d(ack.this).post(ack.f(ack.this));
        }
        return;
      }
    }
  }
  
  public final class c
    extends acj
  {
    public int a = 1;
    public int b = 1;
    public long c = 0L;
    
    public c() {}
    
    public final void a()
    {
      aco localaco = new aco();
      ??? = ack.a(ack.this).c;
      Object localObject4;
      if (Build.VERSION.SDK_INT < 24)
      {
        localObject4 = aey.a(new File(aff.a(aff.an)));
        if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!"CONFIGURED".equals(localObject4))) {}
      }
      label149:
      try
      {
        localObject4 = ((Context)???).getContentResolver();
        i = Settings.Secure.getInt((ContentResolver)localObject4, "adb_enabled", 0);
        if (i > 0) {
          i = 1;
        }
      }
      catch (Throwable localThrowable)
      {
        int i;
        label90:
        break label90;
      }
      i = 0;
      if (i != 0)
      {
        localaco.a = 1;
      }
      else
      {
        localaco.a = 3;
        break label149;
        if ("DISCONNECTED".equals(localObject4)) {
          localaco.a = 2;
        } else if ("CONNECTED".equals(localObject4)) {
          localaco.a = 3;
        }
      }
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
          localaco.b = 1;
        }
        else
        {
          i = ((Intent)???).getIntExtra("plugged", -1);
          if (i == 2) {
            localaco.b = 3;
          } else if (i == 1) {
            localaco.b = 2;
          } else {
            localaco.b = 0;
          }
        }
      }
      synchronized (ack.b(ack.this))
      {
        ack.b(ack.this).add(localaco);
        i = this.a;
        if (i >= this.b) {
          try
          {
            if (!ack.c(ack.this)) {
              return;
            }
            ack.a(ack.this, ack.d(ack.this), ack.e(ack.this));
            return;
          }
          finally {}
        }
        this.a = (i + 1);
        long l = this.c;
        l = adk.a * this.a + l - System.currentTimeMillis();
        if (l > 0L)
        {
          ack.d(ack.this).postDelayed(ack.f(ack.this), l);
          return;
        }
        ack.d(ack.this).post(ack.f(ack.this));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ack
 * JD-Core Version:    0.7.0.1
 */