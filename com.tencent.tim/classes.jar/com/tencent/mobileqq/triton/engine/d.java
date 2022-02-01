package com.tencent.mobileqq.triton.engine;

import android.os.SystemClock;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.ITTEngine.IListener;
import com.tencent.mobileqq.triton.touch.TouchEventManager;
import com.tencent.mobileqq.triton.utils.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class d
  implements b.c
{
  private static final long l = TimeUnit.MILLISECONDS.toNanos(1500L);
  private static final long m = TimeUnit.SECONDS.toNanos(5L);
  private final a a = new a();
  private final TTEngine b;
  private final CountDownLatch c = new CountDownLatch(1);
  private b d;
  private long e = 0L;
  private long f;
  private long g;
  private long h;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  
  public d(TTEngine paramTTEngine)
  {
    this.b = paramTTEngine;
    this.d = new b(paramTTEngine, this);
    this.d.start();
  }
  
  private void a(long paramLong)
  {
    if (paramLong - this.h > m)
    {
      int n = this.b.getProcessedMessageCount();
      TTLog.c("ScriptService", "JSThread liveLog in 5s Frame=[" + this.j + "] DrawCall=[" + this.k + "] Message=[" + (n - this.i) + "]");
      this.j = 0;
      this.k = 0;
      this.h = paramLong;
      this.i = n;
    }
  }
  
  private void j()
  {
    long l1 = SystemClock.uptimeMillis();
    this.b.a();
    this.c.countDown();
    if (this.b.h() != null) {
      this.b.h().e();
    }
    TTLog.c("ScriptService", "injectJS BaseLib cost time:" + (SystemClock.uptimeMillis() - l1) + "ms");
  }
  
  public void a()
  {
    com.tencent.mobileqq.triton.jni.b.c(this.b);
    if (this.b.e() != null) {
      this.b.e().onExit();
    }
  }
  
  void a(int paramInt)
  {
    if (paramInt >= this.b.d())
    {
      this.a.a(0.0F);
      return;
    }
    this.a.a(paramInt);
  }
  
  public boolean b()
  {
    long l3 = System.nanoTime();
    long l2 = l3 - this.f;
    long l1 = l2;
    if (l2 > l) {
      l1 = TimeUnit.SECONDS.toNanos(1L) / this.b.getTargetFPS();
    }
    this.f = l3;
    this.g = (l1 + this.g);
    if (this.a.a(this.g))
    {
      this.b.l().reportDC04902("game_start", 0L);
      if (this.b.m() == null) {
        break label206;
      }
    }
    label206:
    for (TouchEventManager localTouchEventManager = this.b.m().e();; localTouchEventManager = null)
    {
      if (localTouchEventManager != null) {
        localTouchEventManager.a();
      }
      com.tencent.mobileqq.triton.jni.b.a(this.b, this.g);
      this.e = com.tencent.mobileqq.triton.jni.b.e(this.b);
      com.tencent.mobileqq.triton.jni.b.b(this.b);
      l1 = (System.nanoTime() - l3) / 1000000L;
      this.b.l().reportDC04902("draw_frame", l1);
      this.j += 1;
      this.k = ((int)(this.k + this.e));
      a(l3);
      return false;
    }
  }
  
  public boolean c()
  {
    j();
    return false;
  }
  
  void d()
  {
    long l1 = SystemClock.uptimeMillis();
    for (;;)
    {
      if (this.c.getCount() != 0L) {}
      try
      {
        this.c.await(1L, TimeUnit.SECONDS);
        label28:
        if (this.c.getCount() == 0L) {
          continue;
        }
        TTLog.d("ScriptService", "awaitStart cost too long!!! " + (SystemClock.uptimeMillis() - l1) + "ms");
        continue;
        TTLog.c("ScriptService", "awaitStartCostTime:" + (SystemClock.uptimeMillis() - l1) + "ms");
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label28;
      }
    }
  }
  
  public long e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    b localb = this.d;
    return (localb != null) && (localb.a());
  }
  
  public void g()
  {
    b localb = this.d;
    if (localb != null)
    {
      localb.d();
      this.d = null;
    }
  }
  
  public void h()
  {
    TTLog.c("ScriptService", "============onPause==============");
    b localb = this.d;
    if (localb != null)
    {
      localb.b();
      this.b.l().reportDC04902("game_end", 0L);
    }
  }
  
  public void i()
  {
    TTLog.c("ScriptService", "============onResume==============");
    b localb = this.d;
    if (localb != null) {
      localb.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.d
 * JD-Core Version:    0.7.0.1
 */