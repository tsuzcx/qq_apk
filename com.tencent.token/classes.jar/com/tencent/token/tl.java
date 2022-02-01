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

public final class tl
{
  ExecutorService a = Executors.newFixedThreadPool(5);
  public b b = new b("");
  public a c = new a()
  {
    public final void a(aar paramAnonymousaar)
    {
      MotionEvent localMotionEvent = zs.a().j;
      if (localMotionEvent != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("cginame:");
        localStringBuilder.append(paramAnonymousaar.a);
        xb.c(localStringBuilder.toString());
        localStringBuilder = new StringBuilder("pagename:");
        localStringBuilder.append(paramAnonymousaar.i);
        xb.c(localStringBuilder.toString());
        localStringBuilder = new StringBuilder("getRawX:");
        localStringBuilder.append(localMotionEvent.getRawX());
        xb.c(localStringBuilder.toString());
        localStringBuilder = new StringBuilder("getRawY:");
        localStringBuilder.append(localMotionEvent.getRawY());
        xb.c(localStringBuilder.toString());
        long l = System.currentTimeMillis() - (SystemClock.uptimeMillis() - localMotionEvent.getDownTime());
        xb.c("eventStartTime:".concat(String.valueOf(l)));
        int i = zs.a().k;
        xb.c("touch_type:".concat(String.valueOf(i)));
        zs.a().a(i, paramAnonymousaar.a, paramAnonymousaar.i, "", "", "", (int)localMotionEvent.getRawX(), (int)localMotionEvent.getRawY(), l);
        zs.a().b();
      }
    }
    
    public final void a(aar paramAnonymousaar, wz paramAnonymouswz)
    {
      if (paramAnonymouswz.b())
      {
        ry.a().a(System.currentTimeMillis(), 0, paramAnonymousaar.a, 0, "", aad.i());
        if ((!paramAnonymousaar.e) && (paramAnonymousaar.d != null))
        {
          paramAnonymouswz = paramAnonymousaar.d.obtainMessage(paramAnonymousaar.f);
          paramAnonymouswz.arg1 = 0;
          paramAnonymouswz.sendToTarget();
          paramAnonymousaar.e = true;
        }
      }
      else
      {
        if (paramAnonymouswz.a < 10000) {
          ry.a().a(System.currentTimeMillis(), 0, paramAnonymousaar.a, 0, "", aad.i());
        } else {
          ry.a().a(System.currentTimeMillis(), ry.a(paramAnonymouswz.a), paramAnonymousaar.a, 1, paramAnonymouswz.b, aad.i());
        }
        if ((!paramAnonymousaar.e) && (paramAnonymousaar.d != null))
        {
          Message localMessage = paramAnonymousaar.d.obtainMessage(paramAnonymousaar.f);
          localMessage.arg1 = paramAnonymouswz.a;
          localMessage.obj = paramAnonymouswz;
          localMessage.sendToTarget();
          paramAnonymousaar.e = true;
        }
      }
      paramAnonymouswz = tl.this.b;
      paramAnonymouswz.a.post(new tl.b.4(paramAnonymouswz, paramAnonymousaar));
    }
  };
  
  public static abstract interface a
  {
    public abstract void a(aar paramaar);
    
    public abstract void a(aar paramaar, wz paramwz);
  }
  
  public final class b
    extends HandlerThread
  {
    public Handler a = new Handler();
    private Map<aar, Future<wz>> c = Collections.synchronizedMap(new HashMap());
    
    public b(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tl
 * JD-Core Version:    0.7.0.1
 */