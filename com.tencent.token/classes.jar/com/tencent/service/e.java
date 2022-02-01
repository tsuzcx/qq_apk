package com.tencent.service;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.jni.FaceDetector;
import com.tencent.jni.FaceInfo;
import com.tencent.jni.FaceThreshold;
import com.tencent.token.eb;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class e
  implements d
{
  private static final int a = Runtime.getRuntime().availableProcessors();
  private static final int b = a;
  private static final int c = b;
  private ArrayList<FaceDetector> d = new ArrayList();
  private ArrayList<f> e = new ArrayList();
  private b f = null;
  private g g;
  private ThreadPoolExecutor h;
  private a i = null;
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
  
  public e(Context paramContext, FaceServiceDelegate paramFaceServiceDelegate, String paramString)
  {
    this.j = paramContext;
    this.k = paramFaceServiceDelegate;
    this.l = paramString;
  }
  
  private void c()
  {
    this.g = new g(this.j);
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
      eb.a(this.j);
      FaceDetector localFaceDetector = new FaceDetector();
      localFaceDetector.Initial(this.l, this.s);
      this.d.add(localFaceDetector);
      i1 += 1;
    }
    this.i = new a(Looper.myLooper());
    this.h = new ThreadPoolExecutor(a, b, 3L, TimeUnit.MINUTES, new ArrayBlockingQueue(4), new b());
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
        com.tencent.token.global.g.b("awaitTermination before");
        bool = this.h.awaitTermination(100L, TimeUnit.MILLISECONDS);
        StringBuilder localStringBuilder = new StringBuilder().append("awaitTermination after ");
        i1 += 1;
        com.tencent.token.global.g.b(i1);
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
  
  public void a(b paramb)
  {
    Message localMessage = new Message();
    localMessage.what = 36865;
    localMessage.obj = paramb;
    if (this.i != null) {
      this.i.sendMessage(localMessage);
    }
  }
  
  public void a(f paramf, DetectType paramDetectType)
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
            paramDetectType = new c(this, localFaceDetector, paramf, paramDetectType);
            paramDetectType.a = this.n;
            this.h.execute(paramDetectType);
            this.e.add(paramf);
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
  
  private class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    private void a(Message paramMessage)
    {
      paramMessage = (b)paramMessage.obj;
      paramMessage.a.setIdle(true);
      if (!e.a(e.this).contains(paramMessage.b)) {
        com.tencent.token.global.g.b("Discard pic");
      }
      while ((e.b(e.this) == null) || (e.c(e.this) == null)) {
        return;
      }
      if (paramMessage.c == 0) {
        if (e.d(e.this) == null)
        {
          e.a(e.this, paramMessage);
          e.e(e.this);
        }
      }
      for (;;)
      {
        e.a(e.this).remove(paramMessage.b);
        if (e.f(e.this) != 4) {
          break label345;
        }
        e.a(e.this, System.currentTimeMillis());
        com.tencent.token.global.g.b("检测了" + e.g(e.this) + "帧数据 检测到" + 4 + "张人脸时间: " + (e.h(e.this) - e.i(e.this)) + " 最大分数: " + e.d(e.this).d.qualityScore());
        e.b(e.this).a(e.d(e.this).b.a, e.d(e.this).d.faceData(), e.g(e.this));
        e.a(e.this, null);
        e.a(e.this, 0);
        e.b(e.this, 0);
        return;
        if (paramMessage.d.qualityScore() <= e.d(e.this).d.qualityScore()) {
          break;
        }
        e.a(e.this, paramMessage);
        break;
        FaceServiceDelegate.FaceDetectErrorCode localFaceDetectErrorCode = FaceServiceDelegate.FaceDetectErrorCode.values()[paramMessage.c];
        e.b(e.this).a(localFaceDetectErrorCode);
      }
      label345:
      e.b(e.this).a();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.e("FaceService", "Unknown message type " + paramMessage.what);
        return;
      }
      a(paramMessage);
    }
  }
  
  private class b
    implements RejectedExecutionHandler
  {
    public b() {}
    
    public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.e
 * JD-Core Version:    0.7.0.1
 */