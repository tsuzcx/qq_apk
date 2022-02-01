package com.tencent.token.core.protocolcenter;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.tencent.token.bx;
import com.tencent.token.dn;
import com.tencent.token.do;
import com.tencent.token.upload.useraction.a;
import com.tencent.token.utils.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class e
{
  private ExecutorService a = Executors.newFixedThreadPool(5);
  private b b = new b("");
  private a c = new a()
  {
    public void a(dn paramAnonymousdn)
    {
      MotionEvent localMotionEvent = a.a().b();
      if (localMotionEvent != null)
      {
        com.tencent.token.global.g.c("cginame:" + paramAnonymousdn.a);
        com.tencent.token.global.g.c("pagename:" + paramAnonymousdn.i);
        com.tencent.token.global.g.c("getRawX:" + localMotionEvent.getRawX());
        com.tencent.token.global.g.c("getRawY:" + localMotionEvent.getRawY());
        long l = System.currentTimeMillis() - (SystemClock.uptimeMillis() - localMotionEvent.getDownTime());
        com.tencent.token.global.g.c("eventStartTime:" + l);
        int i = a.a().c();
        com.tencent.token.global.g.c("touch_type:" + i);
        a.a().a(i, paramAnonymousdn.a, paramAnonymousdn.i, "", "", "", (int)localMotionEvent.getRawX(), (int)localMotionEvent.getRawY(), l);
        a.a().d();
      }
    }
    
    public void a(dn paramAnonymousdn, com.tencent.token.global.e paramAnonymouse)
    {
      if (paramAnonymouse.b())
      {
        bx.a().a(System.currentTimeMillis(), 0, paramAnonymousdn.a, 0, "", l.k());
        if (!paramAnonymousdn.e)
        {
          paramAnonymouse = paramAnonymousdn.d.obtainMessage(paramAnonymousdn.f);
          paramAnonymouse.arg1 = 0;
          paramAnonymouse.sendToTarget();
          paramAnonymousdn.e = true;
        }
      }
      label175:
      for (;;)
      {
        e.a(e.this).b(paramAnonymousdn);
        return;
        if (paramAnonymouse.a < 10000) {
          bx.a().a(System.currentTimeMillis(), 0, paramAnonymousdn.a, 0, "", l.k());
        }
        for (;;)
        {
          if (paramAnonymousdn.e) {
            break label175;
          }
          Message localMessage = paramAnonymousdn.d.obtainMessage(paramAnonymousdn.f);
          localMessage.arg1 = paramAnonymouse.a;
          localMessage.obj = paramAnonymouse;
          localMessage.sendToTarget();
          paramAnonymousdn.e = true;
          break;
          bx.a().a(System.currentTimeMillis(), bx.a(paramAnonymouse.a), paramAnonymousdn.a, 1, paramAnonymouse.b, l.k());
        }
      }
    }
  };
  
  public int a(dn paramdn)
  {
    paramdn.l = this.c;
    this.b.a(paramdn);
    return 0;
  }
  
  public int a(String paramString)
  {
    this.b.a(paramString);
    return 0;
  }
  
  public do b(dn paramdn)
  {
    d locald = b.a(paramdn.a);
    if (locald == null) {
      return null;
    }
    return locald.d(paramdn);
  }
  
  public static abstract interface a
  {
    public abstract void a(dn paramdn);
    
    public abstract void a(dn paramdn, com.tencent.token.global.e parame);
  }
  
  class b
    extends HandlerThread
  {
    private Handler b = new Handler();
    private Map<dn, Future<com.tencent.token.global.e>> c = Collections.synchronizedMap(new HashMap());
    
    public b(String paramString)
    {
      super();
    }
    
    public void a(final dn paramdn)
    {
      paramdn.l.a(paramdn);
      this.b.post(new Runnable()
      {
        public void run()
        {
          Object localObject = null;
          switch (paramdn.b)
          {
          }
          for (;;)
          {
            if (localObject != null)
            {
              localObject = e.b(e.this).submit((Callable)localObject);
              e.b.a(e.b.this).put(paramdn, localObject);
            }
            return;
            localObject = h.a(paramdn);
            continue;
            localObject = g.a(paramdn);
            continue;
            localObject = c.a(paramdn);
          }
        }
      });
      this.b.postDelayed(new Runnable()
      {
        public void run()
        {
          Object localObject2 = (Future)e.b.a(e.b.this).remove(paramdn);
          if (localObject2 == null) {}
          for (;;)
          {
            return;
            ((Future)localObject2).cancel(true);
            Object localObject1 = new com.tencent.token.global.e();
            try
            {
              localObject2 = (com.tencent.token.global.e)((Future)localObject2).get();
              try
              {
                if ((paramdn.e) || (paramdn.d == null)) {
                  continue;
                }
                localObject1 = paramdn.d.obtainMessage(paramdn.f);
                ((Message)localObject1).arg1 = ((com.tencent.token.global.e)localObject2).a;
                ((Message)localObject1).obj = localObject2;
                ((Message)localObject1).sendToTarget();
                paramdn.e = true;
                return;
              }
              catch (Exception localException1)
              {
                return;
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException = localInterruptedException;
              com.tencent.token.global.g.b("task interrupted because timeout, tag=" + paramdn.i);
              localException1.b(200);
              try
              {
                if ((paramdn.e) || (paramdn.d == null)) {
                  continue;
                }
                Message localMessage1 = paramdn.d.obtainMessage(paramdn.f);
                localMessage1.arg1 = localException1.a;
                localMessage1.obj = localException1;
                localMessage1.sendToTarget();
                paramdn.e = true;
                return;
              }
              catch (Exception localException2)
              {
                return;
              }
            }
            catch (ExecutionException localExecutionException)
            {
              localExecutionException = localExecutionException;
              com.tencent.token.global.g.b("task interrupted because local bug, tag=" + paramdn.i);
              localException2.a(10000, "Exception:" + localExecutionException.toString());
              try
              {
                if ((paramdn.e) || (paramdn.d == null)) {
                  continue;
                }
                Message localMessage2 = paramdn.d.obtainMessage(paramdn.f);
                localMessage2.arg1 = localException2.a;
                localMessage2.obj = localException2;
                localMessage2.sendToTarget();
                paramdn.e = true;
                return;
              }
              catch (Exception localException3)
              {
                return;
              }
            }
            catch (CancellationException localCancellationException)
            {
              localCancellationException = localCancellationException;
              com.tencent.token.global.g.b("task cancelled because timeout, tag=" + paramdn.i);
              localException3.b(200);
              try
              {
                if ((paramdn.e) || (paramdn.d == null)) {
                  continue;
                }
                Message localMessage3 = paramdn.d.obtainMessage(paramdn.f);
                localMessage3.arg1 = localException3.a;
                localMessage3.obj = localException3;
                localMessage3.sendToTarget();
                paramdn.e = true;
                return;
              }
              catch (Exception localException4)
              {
                return;
              }
            }
            catch (Exception localException7)
            {
              localException7 = localException7;
              com.tencent.token.global.g.b("task interrupted because local bug, tag=" + paramdn.i);
              localException4.a(10000, "Exception:" + localException7.toString());
              try
              {
                if ((paramdn.e) || (paramdn.d == null)) {
                  continue;
                }
                Message localMessage4 = paramdn.d.obtainMessage(paramdn.f);
                localMessage4.arg1 = localException4.a;
                localMessage4.obj = localException4;
                localMessage4.sendToTarget();
                paramdn.e = true;
                return;
              }
              catch (Exception localException5)
              {
                return;
              }
            }
            finally {}
            try
            {
              if (!paramdn.e)
              {
                if (paramdn.d == null) {
                  continue;
                }
                Message localMessage5 = paramdn.d.obtainMessage(paramdn.f);
                localMessage5.arg1 = localException5.a;
                localMessage5.obj = localException5;
                localMessage5.sendToTarget();
                paramdn.e = true;
              }
              label633:
              throw localObject3;
            }
            catch (Exception localException6)
            {
              break label633;
            }
          }
        }
      }, paramdn.h);
    }
    
    public void a(final String paramString)
    {
      this.b.post(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = e.b.a(e.b.this).entrySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject1 = (Map.Entry)localIterator.next();
            Object localObject4 = (Future)((Map.Entry)localObject1).getValue();
            localObject1 = (dn)((Map.Entry)localObject1).getKey();
            if ((((dn)localObject1).i != null) && (paramString != null) && (((dn)localObject1).i.contains(paramString)))
            {
              localIterator.remove();
              ((Future)localObject4).cancel(true);
              Object localObject3 = new com.tencent.token.global.e();
              try
              {
                localObject4 = (com.tencent.token.global.e)((Future)localObject4).get();
                if (!((dn)localObject1).e)
                {
                  localObject3 = ((dn)localObject1).d.obtainMessage(2002);
                  ((Message)localObject3).arg1 = ((com.tencent.token.global.e)localObject4).a;
                  ((Message)localObject3).obj = localObject4;
                  ((Message)localObject3).sendToTarget();
                  ((dn)localObject1).e = true;
                }
              }
              catch (InterruptedException localInterruptedException)
              {
                com.tencent.token.global.g.b("task interrupted because cancel, tag=" + ((dn)localObject1).i);
                ((com.tencent.token.global.e)localObject3).b(10024);
                if (!((dn)localObject1).e)
                {
                  Message localMessage1 = ((dn)localObject1).d.obtainMessage(2002);
                  localMessage1.arg1 = ((com.tencent.token.global.e)localObject3).a;
                  localMessage1.obj = localObject3;
                  localMessage1.sendToTarget();
                  ((dn)localObject1).e = true;
                }
              }
              catch (ExecutionException localExecutionException)
              {
                ((com.tencent.token.global.e)localObject3).a(10000, "Exception:" + localExecutionException.toString());
                if (!((dn)localObject1).e)
                {
                  Message localMessage2 = ((dn)localObject1).d.obtainMessage(2002);
                  localMessage2.arg1 = ((com.tencent.token.global.e)localObject3).a;
                  localMessage2.obj = localObject3;
                  localMessage2.sendToTarget();
                  ((dn)localObject1).e = true;
                }
              }
              catch (CancellationException localCancellationException)
              {
                com.tencent.token.global.g.b("task cancelled because cancel, tag=" + ((dn)localObject1).i);
                ((com.tencent.token.global.e)localObject3).b(10024);
                if (!((dn)localObject1).e)
                {
                  Message localMessage3 = ((dn)localObject1).d.obtainMessage(2002);
                  localMessage3.arg1 = ((com.tencent.token.global.e)localObject3).a;
                  localMessage3.obj = localObject3;
                  localMessage3.sendToTarget();
                  ((dn)localObject1).e = true;
                }
              }
              catch (Exception localException)
              {
                ((com.tencent.token.global.e)localObject3).a(10000, "Exception:" + localException.toString());
                if (!((dn)localObject1).e)
                {
                  localMessage4 = ((dn)localObject1).d.obtainMessage(2002);
                  localMessage4.arg1 = ((com.tencent.token.global.e)localObject3).a;
                  localMessage4.obj = localObject3;
                  localMessage4.sendToTarget();
                  ((dn)localObject1).e = true;
                }
              }
              finally
              {
                Message localMessage4;
                if (!((dn)localObject1).e)
                {
                  localMessage4 = ((dn)localObject1).d.obtainMessage(2002);
                  localMessage4.arg1 = ((com.tencent.token.global.e)localObject3).a;
                  localMessage4.obj = localObject3;
                  localMessage4.sendToTarget();
                  ((dn)localObject1).e = true;
                }
              }
            }
          }
        }
      });
    }
    
    public void b(final dn paramdn)
    {
      this.b.post(new Runnable()
      {
        public void run()
        {
          e.b.a(e.b.this).remove(paramdn);
          paramdn.a();
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.e
 * JD-Core Version:    0.7.0.1
 */