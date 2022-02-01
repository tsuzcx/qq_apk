package com.tencent.mobileqq.triton.engine;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.triton.jni.a;
import java.util.concurrent.atomic.AtomicInteger;

public class b
  extends Thread
{
  private final AtomicInteger a = new AtomicInteger();
  private TTEngine b;
  private c c;
  private volatile boolean d = false;
  private boolean e;
  private Runnable f = new b.a(this);
  private Choreographer.FrameCallback g = new b.b(this);
  private long h = -1L;
  
  public b(TTEngine paramTTEngine, c paramc)
  {
    this.b = paramTTEngine;
    this.c = paramc;
    setPriority(10);
    setName("JSThread_" + getId());
  }
  
  @MainThread
  private void e()
  {
    this.e = true;
    Choreographer.getInstance().postFrameCallback(this.g);
  }
  
  @MainThread
  private void f()
  {
    Choreographer.getInstance().removeFrameCallback(this.g);
  }
  
  public boolean a()
  {
    return this.h == Thread.currentThread().getId();
  }
  
  public void b()
  {
    f();
    if (this.b.m() != null) {
      a.b(this.b.m(), this.b.k());
    }
  }
  
  public void c()
  {
    e();
    if (this.b.m() != null) {
      a.c(this.b.m(), this.b.k());
    }
  }
  
  public void d()
  {
    this.d = true;
    TTLog.b("JSThread", "JSThread (tid:" + this.h + ") shutdown");
    com.tencent.mobileqq.triton.jni.b.a(this.b);
  }
  
  public void run()
  {
    this.h = getId();
    TTLog.b("JSThread", "JSThread (tid:" + this.h + ") run start");
    c localc = this.c;
    if (localc == null) {
      return;
    }
    localc.c();
    try
    {
      while (!this.d)
      {
        a.e(this.b.m(), this.b.k());
        com.tencent.mobileqq.triton.jni.b.a(this.b, true);
        com.tencent.mobileqq.triton.jni.b.a(this.b, false);
        TTLog.c("JSThread", "JSThread (tid: " + this.h + ") runLoop is interrupted loopQuit=" + this.d);
      }
      return;
    }
    catch (Exception localException)
    {
      TTLog.b("JSThread", "JSThread (tid:" + this.h + ") run error " + localException.getMessage());
      TTLog.b("JSThread", "JSThread (tid:" + this.h + ") run exit");
      this.c.a();
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
    
    public abstract boolean b();
    
    public abstract boolean c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.b
 * JD-Core Version:    0.7.0.1
 */