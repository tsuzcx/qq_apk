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

public final class ue
{
  ExecutorService a = Executors.newFixedThreadPool(5);
  public b b = new b("");
  public a c = new a()
  {
    public final void a(abm paramAnonymousabm)
    {
      MotionEvent localMotionEvent = aan.a().j;
      if (localMotionEvent != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("cginame:");
        localStringBuilder.append(paramAnonymousabm.a);
        xv.c(localStringBuilder.toString());
        localStringBuilder = new StringBuilder("pagename:");
        localStringBuilder.append(paramAnonymousabm.i);
        xv.c(localStringBuilder.toString());
        localStringBuilder = new StringBuilder("getRawX:");
        localStringBuilder.append(localMotionEvent.getRawX());
        xv.c(localStringBuilder.toString());
        localStringBuilder = new StringBuilder("getRawY:");
        localStringBuilder.append(localMotionEvent.getRawY());
        xv.c(localStringBuilder.toString());
        long l = System.currentTimeMillis() - (SystemClock.uptimeMillis() - localMotionEvent.getDownTime());
        xv.c("eventStartTime:".concat(String.valueOf(l)));
        int i = aan.a().k;
        xv.c("touch_type:".concat(String.valueOf(i)));
        aan.a().a(i, paramAnonymousabm.a, paramAnonymousabm.i, "", "", "", (int)localMotionEvent.getRawX(), (int)localMotionEvent.getRawY(), l);
        aan.a().b();
      }
    }
    
    public final void a(abm paramAnonymousabm, xt paramAnonymousxt)
    {
      if (paramAnonymousxt.b())
      {
        sr.a().a(System.currentTimeMillis(), 0, paramAnonymousabm.a, 0, "", aay.i());
        if ((!paramAnonymousabm.e) && (paramAnonymousabm.d != null))
        {
          paramAnonymousxt = paramAnonymousabm.d.obtainMessage(paramAnonymousabm.f);
          paramAnonymousxt.arg1 = 0;
          paramAnonymousxt.sendToTarget();
          paramAnonymousabm.e = true;
        }
      }
      else
      {
        if (paramAnonymousxt.a < 10000) {
          sr.a().a(System.currentTimeMillis(), 0, paramAnonymousabm.a, 0, "", aay.i());
        } else {
          sr.a().a(System.currentTimeMillis(), sr.a(paramAnonymousxt.a), paramAnonymousabm.a, 1, paramAnonymousxt.b, aay.i());
        }
        if ((!paramAnonymousabm.e) && (paramAnonymousabm.d != null))
        {
          Message localMessage = paramAnonymousabm.d.obtainMessage(paramAnonymousabm.f);
          localMessage.arg1 = paramAnonymousxt.a;
          localMessage.obj = paramAnonymousxt;
          localMessage.sendToTarget();
          paramAnonymousabm.e = true;
        }
      }
      paramAnonymousxt = ue.this.b;
      paramAnonymousxt.a.post(new ue.b.4(paramAnonymousxt, paramAnonymousabm));
    }
  };
  
  public static abstract interface a
  {
    public abstract void a(abm paramabm);
    
    public abstract void a(abm paramabm, xt paramxt);
  }
  
  public final class b
    extends HandlerThread
  {
    public Handler a = new Handler();
    private Map<abm, Future<xt>> c = Collections.synchronizedMap(new HashMap());
    
    public b(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ue
 * JD-Core Version:    0.7.0.1
 */