package com.tencent.token.global.taiji;

public class f
  extends Thread
{
  private a a;
  private Runnable b;
  private long c;
  
  public f(ThreadGroup paramThreadGroup, Runnable paramRunnable, String paramString, long paramLong)
  {
    super(paramThreadGroup, paramRunnable, paramString);
    this.b = paramRunnable;
    this.c = paramLong;
  }
  
  public void run()
  {
    if (this.a != null) {
      this.a.b(this, this.b);
    }
    super.run();
    if (this.a != null) {
      this.a.c(this, this.b);
    }
  }
  
  public void start()
  {
    try
    {
      if (this.a != null) {
        this.a.a(this, this.b);
      }
      super.start();
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void a(Thread paramThread, Runnable paramRunnable);
    
    public abstract void b(Thread paramThread, Runnable paramRunnable);
    
    public abstract void c(Thread paramThread, Runnable paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.f
 * JD-Core Version:    0.7.0.1
 */