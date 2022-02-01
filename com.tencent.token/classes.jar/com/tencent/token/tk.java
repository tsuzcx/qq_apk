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

public final class tk
{
  ExecutorService a = Executors.newFixedThreadPool(5);
  public b b = new b("");
  public a c = new a()
  {
    public final void a(aaq paramAnonymousaaq)
    {
      MotionEvent localMotionEvent = zr.a().j;
      if (localMotionEvent != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("cginame:");
        localStringBuilder.append(paramAnonymousaaq.a);
        xa.c(localStringBuilder.toString());
        localStringBuilder = new StringBuilder("pagename:");
        localStringBuilder.append(paramAnonymousaaq.i);
        xa.c(localStringBuilder.toString());
        localStringBuilder = new StringBuilder("getRawX:");
        localStringBuilder.append(localMotionEvent.getRawX());
        xa.c(localStringBuilder.toString());
        localStringBuilder = new StringBuilder("getRawY:");
        localStringBuilder.append(localMotionEvent.getRawY());
        xa.c(localStringBuilder.toString());
        long l = System.currentTimeMillis() - (SystemClock.uptimeMillis() - localMotionEvent.getDownTime());
        xa.c("eventStartTime:".concat(String.valueOf(l)));
        int i = zr.a().k;
        xa.c("touch_type:".concat(String.valueOf(i)));
        zr.a().a(i, paramAnonymousaaq.a, paramAnonymousaaq.i, "", "", "", (int)localMotionEvent.getRawX(), (int)localMotionEvent.getRawY(), l);
        zr.a().b();
      }
    }
    
    public final void a(aaq paramAnonymousaaq, wy paramAnonymouswy)
    {
      if (paramAnonymouswy.b())
      {
        rx.a().a(System.currentTimeMillis(), 0, paramAnonymousaaq.a, 0, "", aac.i());
        if ((!paramAnonymousaaq.e) && (paramAnonymousaaq.d != null))
        {
          paramAnonymouswy = paramAnonymousaaq.d.obtainMessage(paramAnonymousaaq.f);
          paramAnonymouswy.arg1 = 0;
          paramAnonymouswy.sendToTarget();
          paramAnonymousaaq.e = true;
        }
      }
      else
      {
        if (paramAnonymouswy.a < 10000) {
          rx.a().a(System.currentTimeMillis(), 0, paramAnonymousaaq.a, 0, "", aac.i());
        } else {
          rx.a().a(System.currentTimeMillis(), rx.a(paramAnonymouswy.a), paramAnonymousaaq.a, 1, paramAnonymouswy.b, aac.i());
        }
        if ((!paramAnonymousaaq.e) && (paramAnonymousaaq.d != null))
        {
          Message localMessage = paramAnonymousaaq.d.obtainMessage(paramAnonymousaaq.f);
          localMessage.arg1 = paramAnonymouswy.a;
          localMessage.obj = paramAnonymouswy;
          localMessage.sendToTarget();
          paramAnonymousaaq.e = true;
        }
      }
      paramAnonymouswy = tk.this.b;
      paramAnonymouswy.a.post(new tk.b.4(paramAnonymouswy, paramAnonymousaaq));
    }
  };
  
  public static abstract interface a
  {
    public abstract void a(aaq paramaaq);
    
    public abstract void a(aaq paramaaq, wy paramwy);
  }
  
  public final class b
    extends HandlerThread
  {
    public Handler a = new Handler();
    private Map<aaq, Future<wy>> c = Collections.synchronizedMap(new HashMap());
    
    public b(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tk
 * JD-Core Version:    0.7.0.1
 */