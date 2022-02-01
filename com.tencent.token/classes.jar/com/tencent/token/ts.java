package com.tencent.token;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class ts
{
  ExecutorService a = Executors.newFixedThreadPool(5);
  public b b = new b("");
  public a c = new a()
  {
    public final void a(abc paramAnonymousabc)
    {
      MotionEvent localMotionEvent = aad.a().j;
      if (localMotionEvent != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("cginame:");
        localStringBuilder.append(paramAnonymousabc.a);
        xj.c(localStringBuilder.toString());
        localStringBuilder = new StringBuilder("pagename:");
        localStringBuilder.append(paramAnonymousabc.i);
        xj.c(localStringBuilder.toString());
        localStringBuilder = new StringBuilder("getRawX:");
        localStringBuilder.append(localMotionEvent.getRawX());
        xj.c(localStringBuilder.toString());
        localStringBuilder = new StringBuilder("getRawY:");
        localStringBuilder.append(localMotionEvent.getRawY());
        xj.c(localStringBuilder.toString());
        long l = System.currentTimeMillis() - (SystemClock.uptimeMillis() - localMotionEvent.getDownTime());
        xj.c("eventStartTime:".concat(String.valueOf(l)));
        int i = aad.a().k;
        xj.c("touch_type:".concat(String.valueOf(i)));
        aad.a().a(i, paramAnonymousabc.a, paramAnonymousabc.i, "", "", "", (int)localMotionEvent.getRawX(), (int)localMotionEvent.getRawY(), l);
        aad.a().b();
      }
    }
    
    public final void a(abc paramAnonymousabc, xh paramAnonymousxh)
    {
      if (paramAnonymousxh.b())
      {
        sf.a().a(System.currentTimeMillis(), 0, paramAnonymousabc.a, 0, "", aao.i());
        if ((!paramAnonymousabc.e) && (paramAnonymousabc.d != null))
        {
          paramAnonymousxh = paramAnonymousabc.d.obtainMessage(paramAnonymousabc.f);
          paramAnonymousxh.arg1 = 0;
          paramAnonymousxh.sendToTarget();
          paramAnonymousabc.e = true;
        }
      }
      else
      {
        if (paramAnonymousxh.a < 10000) {
          sf.a().a(System.currentTimeMillis(), 0, paramAnonymousabc.a, 0, "", aao.i());
        } else {
          sf.a().a(System.currentTimeMillis(), sf.a(paramAnonymousxh.a), paramAnonymousabc.a, 1, paramAnonymousxh.b, aao.i());
        }
        if ((!paramAnonymousabc.e) && (paramAnonymousabc.d != null))
        {
          Message localMessage = paramAnonymousabc.d.obtainMessage(paramAnonymousabc.f);
          localMessage.arg1 = paramAnonymousxh.a;
          localMessage.obj = paramAnonymousxh;
          localMessage.sendToTarget();
          paramAnonymousabc.e = true;
        }
      }
      paramAnonymousxh = ts.this.b;
      paramAnonymousxh.a.post(new ts.b.4(paramAnonymousxh, paramAnonymousabc));
    }
  };
  
  public static abstract interface a
  {
    public abstract void a(abc paramabc);
    
    public abstract void a(abc paramabc, xh paramxh);
  }
  
  public final class b
    extends HandlerThread
  {
    public Handler a = new Handler();
    private Map<abc, Future<xh>> c = Collections.synchronizedMap(new HashMap());
    
    public b(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ts
 * JD-Core Version:    0.7.0.1
 */