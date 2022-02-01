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

public final class acl
{
  public static final afk<acl> a = new a();
  public boolean b = false;
  public acg c;
  public Handler d;
  public Handler e;
  public final List<acp> f = new ArrayList();
  public adh g;
  public acf h;
  public final c i = new c();
  public final Runnable j = new b();
  
  public acl()
  {
    HandlerThread localHandlerThread = new HandlerThread("TuringMMSensor");
    localHandlerThread.start();
    this.e = new Handler(localHandlerThread.getLooper());
  }
  
  public final void a()
  {
    acg localacg = this.c;
    if (localacg != null) {
      synchronized (localacg.d)
      {
        localacg.d.clear();
      }
    }
    synchronized (this.f)
    {
      this.f.clear();
      return;
    }
  }
  
  public final void a(Handler paramHandler, acf paramacf)
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
          if ((int)(paramHandler.e.d / adl.a) <= 0)
          {
            ((ado.d)paramacf).a();
            return;
          }
          paramHandler = paramHandler.b();
          if (paramHandler.size() == 0)
          {
            ((ado.d)paramacf).a();
            return;
          }
          synchronized (this.f)
          {
            ArrayList localArrayList = new ArrayList(this.f);
            if (localArrayList.size() <= 0)
            {
              ((ado.d)paramacf).a();
              return;
            }
            ??? = this.g;
            paramacf = (ado.d)paramacf;
            int k = ((adh)???).a;
            ado.b();
            ado.c(paramacf.a).post(new ado.d.a(k, paramHandler, localArrayList, (adh)???));
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
    extends afk<acl>
  {
    public final Object a()
    {
      return new acl((byte)0);
    }
  }
  
  public final class b
    extends ack
  {
    public b() {}
    
    public final void a()
    {
      synchronized (acl.this)
      {
        if (!acl.c(acl.this)) {
          return;
        }
        if (acl.g(acl.this) == null) {
          return;
        }
        if (!acl.g(acl.this).a(acl.a(acl.this).b, acl.h(acl.this))) {
          return;
        }
        long l = acl.g(acl.this).e.b;
        acl.c localc = acl.f(acl.this);
        int i = (int)(acl.a(acl.this).b / adl.a);
        localc.a = 1;
        localc.b = i;
        localc.c = l;
        l = l + adl.a - System.currentTimeMillis();
        if (l > 0L) {
          acl.d(acl.this).postDelayed(acl.f(acl.this), l);
        } else {
          acl.d(acl.this).post(acl.f(acl.this));
        }
        return;
      }
    }
  }
  
  public final class c
    extends ack
  {
    public int a = 1;
    public int b = 1;
    public long c = 0L;
    
    public c() {}
    
    public final void a()
    {
      acp localacp = new acp();
      ??? = acl.a(acl.this).c;
      Object localObject4;
      if (Build.VERSION.SDK_INT < 24)
      {
        localObject4 = aez.a(new File(afg.a(afg.an)));
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
        localacp.a = 1;
      }
      else
      {
        localacp.a = 3;
        break label149;
        if ("DISCONNECTED".equals(localObject4)) {
          localacp.a = 2;
        } else if ("CONNECTED".equals(localObject4)) {
          localacp.a = 3;
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
          localacp.b = 1;
        }
        else
        {
          i = ((Intent)???).getIntExtra("plugged", -1);
          if (i == 2) {
            localacp.b = 3;
          } else if (i == 1) {
            localacp.b = 2;
          } else {
            localacp.b = 0;
          }
        }
      }
      synchronized (acl.b(acl.this))
      {
        acl.b(acl.this).add(localacp);
        i = this.a;
        if (i >= this.b) {
          try
          {
            if (!acl.c(acl.this)) {
              return;
            }
            acl.a(acl.this, acl.d(acl.this), acl.e(acl.this));
            return;
          }
          finally {}
        }
        this.a = (i + 1);
        long l = this.c;
        l = adl.a * this.a + l - System.currentTimeMillis();
        if (l > 0L)
        {
          acl.d(acl.this).postDelayed(acl.f(acl.this), l);
          return;
        }
        acl.d(acl.this).post(acl.f(acl.this));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acl
 * JD-Core Version:    0.7.0.1
 */