package com.tencent.halley.downloader.c;

import android.os.SystemClock;

public class a
{
  private long a = 0L;
  private h b;
  private long c = 0L;
  private long d = 0L;
  private int e = 0;
  private c f = new c((byte)0);
  
  public a(h paramh)
  {
    this.b = paramh;
  }
  
  public final void a()
  {
    this.a = SystemClock.elapsedRealtime();
    this.c = 0L;
    this.d = 0L;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.e += paramInt2;
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.a;
    this.a = l1;
    h localh = this.b;
    localh.j = (l1 - l2 + localh.j);
    this.f.a(paramInt1);
    this.b.q = this.f.a();
  }
  
  public final void b()
  {
    this.c = System.currentTimeMillis();
  }
  
  public final void c()
  {
    this.d = System.currentTimeMillis();
  }
  
  public final long d()
  {
    return this.d - this.c;
  }
  
  public final int e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.c.a
 * JD-Core Version:    0.7.0.1
 */