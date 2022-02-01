package com.tencent.token;

import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.jni.FaceDetector;
import com.tencent.jni.FaceInfo;
import com.tencent.jni.FaceThreshold;
import com.tencent.service.DetectType;
import com.tencent.service.FaceServiceDelegate;
import com.tencent.service.FaceServiceDelegate.FaceDetectErrorCode;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class rg
  implements rf
{
  private static final int b;
  private static final int c;
  private static final int d;
  public FaceThreshold a;
  private ArrayList<FaceDetector> e = new ArrayList();
  private ArrayList<rj> f = new ArrayList();
  private rd g = null;
  private rk h;
  private ThreadPoolExecutor i;
  private a j = null;
  private Context k;
  private FaceServiceDelegate l;
  private String m;
  private boolean n = false;
  private long o = 0L;
  private long p = 0L;
  private int q = 0;
  private int r = 0;
  private boolean s = false;
  
  static
  {
    int i1 = Runtime.getRuntime().availableProcessors();
    b = i1;
    c = i1;
    d = i1;
  }
  
  public rg(Context paramContext, FaceServiceDelegate paramFaceServiceDelegate, String paramString)
  {
    this.k = paramContext;
    this.l = paramFaceServiceDelegate;
    this.m = paramString;
  }
  
  public final void a()
  {
    this.h = new rk(this.k);
    this.h.a();
    int i1 = 0;
    while (i1 < d)
    {
      ((android.app.ActivityManager)this.k.getSystemService("activity")).getProcessMemoryInfo(new int[] { android.os.Process.myPid() })[0].getTotalPrivateDirty();
      FaceDetector localFaceDetector = new FaceDetector();
      localFaceDetector.Initial(this.m, this.a);
      this.e.add(localFaceDetector);
      i1 += 1;
    }
    this.j = new a(Looper.myLooper());
    this.i = new ThreadPoolExecutor(b, c, 3L, TimeUnit.MINUTES, new ArrayBlockingQueue(4), new b());
    this.n = false;
    this.s = true;
  }
  
  public final void a(rd paramrd)
  {
    Message localMessage = new Message();
    localMessage.what = 36865;
    localMessage.obj = paramrd;
    paramrd = this.j;
    if (paramrd != null) {
      paramrd.sendMessage(localMessage);
    }
  }
  
  public final void a(rj paramrj, DetectType paramDetectType)
  {
    if (this.n) {
      return;
    }
    if (this.h.a) {
      return;
    }
    if (this.f.size() + this.r == 0) {
      this.o = System.currentTimeMillis();
    }
    if (this.f.size() + this.r == 4) {
      return;
    }
    int i1 = 0;
    while (i1 < this.e.size())
    {
      FaceDetector localFaceDetector = (FaceDetector)this.e.get(i1);
      if (localFaceDetector.idle())
      {
        localFaceDetector.setIdle(false);
        paramDetectType = new re(this, localFaceDetector, paramrj, paramDetectType);
        paramDetectType.a = this.o;
        this.i.execute(paramDetectType);
        this.f.add(paramrj);
        this.q += 1;
        return;
      }
      i1 += 1;
    }
  }
  
  public final void b()
  {
    this.n = false;
    if (this.s) {
      this.h.b();
    }
    this.h = null;
    Object localObject = this.i;
    if (localObject != null) {}
    try
    {
      ((ThreadPoolExecutor)localObject).shutdown();
      i1 = 0;
      boolean bool;
      do
      {
        xb.b("awaitTermination before");
        bool = this.i.awaitTermination(100L, TimeUnit.MILLISECONDS);
        localObject = new StringBuilder("awaitTermination after ");
        i1 += 1;
        ((StringBuilder)localObject).append(i1);
        xb.b(((StringBuilder)localObject).toString());
      } while (!bool);
    }
    catch (InterruptedException localInterruptedException)
    {
      int i1;
      label90:
      break label90;
    }
    i1 = 0;
    while (i1 < d)
    {
      ((FaceDetector)this.e.get(i1)).Destroy();
      i1 += 1;
    }
    this.e.clear();
    this.n = false;
    this.s = false;
    this.k = null;
    this.l = null;
  }
  
  final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (paramMessage.what != 36865)
      {
        new StringBuilder("Unknown message type ").append(paramMessage.what);
        return;
      }
      paramMessage = (rd)paramMessage.obj;
      paramMessage.a.setIdle(true);
      if (!rg.a(rg.this).contains(paramMessage.b))
      {
        xb.b("Discard pic");
        return;
      }
      if (rg.b(rg.this) != null)
      {
        if (rg.c(rg.this) == null) {
          return;
        }
        if (paramMessage.c == 0)
        {
          if (rg.d(rg.this) == null) {
            rg.a(rg.this, paramMessage);
          } else if (paramMessage.d.qualityScore() > rg.d(rg.this).d.qualityScore()) {
            rg.a(rg.this, paramMessage);
          }
          rg.e(rg.this);
        }
        else
        {
          FaceServiceDelegate.FaceDetectErrorCode localFaceDetectErrorCode = FaceServiceDelegate.FaceDetectErrorCode.values()[paramMessage.c];
          rg.b(rg.this).a(localFaceDetectErrorCode);
        }
        rg.a(rg.this).remove(paramMessage.b);
        if (rg.f(rg.this) == 4)
        {
          rg.a(rg.this, System.currentTimeMillis());
          paramMessage = new StringBuilder("检测了");
          paramMessage.append(rg.g(rg.this));
          paramMessage.append("帧数据 检测到4张人脸时间: ");
          paramMessage.append(rg.h(rg.this) - rg.i(rg.this));
          paramMessage.append(" 最大分数: ");
          paramMessage.append(rg.d(rg.this).d.qualityScore());
          xb.b(paramMessage.toString());
          rg.b(rg.this).a(rg.d(rg.this).b.a, rg.d(rg.this).d.faceData(), rg.g(rg.this));
          rg.a(rg.this, null);
          rg.j(rg.this);
          rg.k(rg.this);
          return;
        }
        rg.b(rg.this);
        return;
      }
    }
  }
  
  final class b
    implements RejectedExecutionHandler
  {
    public b() {}
    
    public final void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rg
 * JD-Core Version:    0.7.0.1
 */