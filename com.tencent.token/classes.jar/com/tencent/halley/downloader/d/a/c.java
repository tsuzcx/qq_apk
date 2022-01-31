package com.tencent.halley.downloader.d.a;

import java.util.concurrent.FutureTask;

public final class c
  extends FutureTask
  implements Comparable
{
  private Object a;
  
  public c(b paramb, Runnable paramRunnable, Object paramObject)
  {
    super(paramRunnable, null);
    this.a = paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.d.a.c
 * JD-Core Version:    0.7.0.1
 */