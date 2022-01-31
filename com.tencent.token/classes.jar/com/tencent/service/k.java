package com.tencent.service;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.tencent.jni.FaceDetector;
import com.tencent.jni.FaceThreshold;
import com.tencent.token.fj;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class k
  implements j
{
  private static final int a = Runtime.getRuntime().availableProcessors();
  private static final int b = a;
  private static final int c = b;
  private ArrayList d = new ArrayList();
  private ArrayList e = new ArrayList();
  private g f = null;
  private o g;
  private ThreadPoolExecutor h;
  private l i = null;
  private Context j;
  private FaceServiceDelegate k;
  private String l;
  private boolean m = false;
  private long n = 0L;
  private long o = 0L;
  private int p = 0;
  private int q = 0;
  private boolean r = false;
  private FaceThreshold s;
  
  public k(Context paramContext, FaceServiceDelegate paramFaceServiceDelegate, String paramString)
  {
    this.j = paramContext;
    this.k = paramFaceServiceDelegate;
    this.l = paramString;
  }
  
  private void c()
  {
    this.g = new o(this.j);
    this.g.a();
  }
  
  private void d()
  {
    if (this.r) {
      this.g.b();
    }
    this.g = null;
  }
  
  private void e()
  {
    int i1 = 0;
    while (i1 < c)
    {
      fj.a(this.j);
      FaceDetector localFaceDetector = new FaceDetector();
      localFaceDetector.Initial(this.l, this.s);
      this.d.add(localFaceDetector);
      i1 += 1;
    }
    this.i = new l(this, Looper.myLooper());
    this.h = new ThreadPoolExecutor(a, b, 3L, TimeUnit.MINUTES, new ArrayBlockingQueue(4), new m(this));
  }
  
  private void f()
  {
    if (this.h == null) {
      return;
    }
    try
    {
      this.h.shutdown();
      i1 = 0;
      boolean bool;
      do
      {
        com.tencent.token.global.h.b("awaitTermination before");
        bool = this.h.awaitTermination(100L, TimeUnit.MILLISECONDS);
        StringBuilder localStringBuilder = new StringBuilder().append("awaitTermination after ");
        i1 += 1;
        com.tencent.token.global.h.b(i1);
      } while (!bool);
    }
    catch (InterruptedException localInterruptedException)
    {
      int i1;
      label68:
      break label68;
    }
    i1 = 0;
    while (i1 < c)
    {
      ((FaceDetector)this.d.get(i1)).Destroy();
      i1 += 1;
    }
    this.d.clear();
  }
  
  private void g()
  {
    this.m = false;
    d();
    f();
  }
  
  public void a()
  {
    c();
    e();
    this.m = false;
    this.r = true;
  }
  
  public void a(FaceThreshold paramFaceThreshold)
  {
    this.s = paramFaceThreshold;
  }
  
  public void a(g paramg)
  {
    Message localMessage = new Message();
    localMessage.what = 36865;
    localMessage.obj = paramg;
    if (this.i != null) {
      this.i.sendMessage(localMessage);
    }
  }
  
  public void a(n paramn, DetectType paramDetectType)
  {
    if (this.m) {}
    for (;;)
    {
      return;
      if (this.g.a)
      {
        this.k.b();
        return;
      }
      if (this.e.size() + this.q == 0) {
        this.n = System.currentTimeMillis();
      }
      if (this.e.size() + this.q != 4)
      {
        int i1 = 0;
        while (i1 < this.d.size())
        {
          FaceDetector localFaceDetector = (FaceDetector)this.d.get(i1);
          if (localFaceDetector.idle())
          {
            localFaceDetector.setIdle(false);
            paramDetectType = new h(this, localFaceDetector, paramn, paramDetectType);
            paramDetectType.a = this.n;
            this.h.execute(paramDetectType);
            this.e.add(paramn);
            this.p += 1;
            this.k.a();
            return;
          }
          i1 += 1;
        }
      }
    }
  }
  
  public void b()
  {
    g();
    this.m = false;
    this.r = false;
    this.j = null;
    this.k = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.k
 * JD-Core Version:    0.7.0.1
 */