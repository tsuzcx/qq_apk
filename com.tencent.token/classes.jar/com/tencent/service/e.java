package com.tencent.service;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.tencent.jni.FaceDetector;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class e
  implements d
{
  private static final int a;
  private static final int b;
  private static final int c;
  private ArrayList d = new ArrayList();
  private ArrayList e = new ArrayList();
  private a f = null;
  private i g;
  private ThreadPoolExecutor h;
  private f i = null;
  private Context j;
  private FaceServiceDelegate k;
  private String l;
  private boolean m = false;
  private long n = 0L;
  private long o = 0L;
  private int p = 0;
  private int q = 0;
  private boolean r = false;
  
  static
  {
    int i1 = Runtime.getRuntime().availableProcessors();
    a = i1;
    b = i1;
    c = i1;
  }
  
  public e(Context paramContext, FaceServiceDelegate paramFaceServiceDelegate, String paramString)
  {
    this.j = paramContext;
    this.k = paramFaceServiceDelegate;
    this.l = paramString;
  }
  
  public final void a()
  {
    this.g = new i(this.j);
    this.g.a();
    int i1 = 0;
    while (i1 < c)
    {
      FaceDetector localFaceDetector = new FaceDetector();
      localFaceDetector.Initial(this.l);
      this.d.add(localFaceDetector);
      i1 += 1;
    }
    this.i = new f(this, Looper.myLooper());
    this.h = new ThreadPoolExecutor(a, b, 3L, TimeUnit.MINUTES, new ArrayBlockingQueue(4), new g(this));
    this.m = false;
    this.r = true;
  }
  
  public final void a(a parama)
  {
    Message localMessage = new Message();
    localMessage.what = 36865;
    localMessage.obj = parama;
    if (this.i != null) {
      this.i.sendMessage(localMessage);
    }
  }
  
  public final void a(h paramh, DetectType paramDetectType)
  {
    if (this.m) {
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if (!this.g.a)
      {
        if (this.e.size() + this.q == 0) {
          this.n = System.currentTimeMillis();
        }
        if (this.e.size() + this.q == 4) {
          break;
        }
        int i1 = 0;
        while (i1 < this.d.size())
        {
          FaceDetector localFaceDetector = (FaceDetector)this.d.get(i1);
          if (localFaceDetector.idle())
          {
            localFaceDetector.setIdle(false);
            paramDetectType = new b(this, localFaceDetector, paramh, paramDetectType);
            paramDetectType.a = this.n;
            this.h.execute(paramDetectType);
            this.e.add(paramh);
            this.p += 1;
            return;
          }
          i1 += 1;
        }
      }
    }
  }
  
  public final void b()
  {
    this.m = false;
    if (this.r) {
      this.g.b();
    }
    this.g = null;
    if (this.h != null) {}
    try
    {
      this.h.shutdown();
      i1 = 0;
      boolean bool;
      do
      {
        com.tencent.token.global.e.b("awaitTermination before");
        bool = this.h.awaitTermination(100L, TimeUnit.MILLISECONDS);
        StringBuilder localStringBuilder = new StringBuilder().append("awaitTermination after ");
        i1 += 1;
        com.tencent.token.global.e.b(i1);
      } while (!bool);
    }
    catch (InterruptedException localInterruptedException)
    {
      int i1;
      label91:
      break label91;
    }
    i1 = 0;
    while (i1 < c)
    {
      ((FaceDetector)this.d.get(i1)).Destroy();
      i1 += 1;
    }
    this.d.clear();
    this.m = false;
    this.r = false;
    this.j = null;
    this.k = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.e
 * JD-Core Version:    0.7.0.1
 */