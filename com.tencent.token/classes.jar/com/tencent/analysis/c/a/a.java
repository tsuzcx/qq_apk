package com.tencent.analysis.c.a;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static a a = new a();
  private ThreadPoolExecutor b = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
  
  public static a a()
  {
    return a;
  }
  
  public final void a(c paramc)
  {
    if (paramc == null) {
      return;
    }
    this.b.submit(paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.c.a.a
 * JD-Core Version:    0.7.0.1
 */