package com.tencent.qmsp.sdk.c;

import java.util.concurrent.atomic.AtomicInteger;

public class o
{
  private AtomicInteger a = new AtomicInteger(0);
  
  public boolean a()
  {
    int i;
    do
    {
      i = this.a.get();
      if ((i & 0x1) != 0) {
        return false;
      }
    } while (!this.a.compareAndSet(i, i + 2));
    return true;
  }
  
  public void b()
  {
    int i;
    do
    {
      i = this.a.get();
      if ((i & 0xFFFFFFFE) == 0) {}
      do
      {
        return;
        if ((i & 0x1) == 0) {
          break;
        }
      } while ((this.a.addAndGet(-2) & 0xFFFFFFFE) != 0);
      synchronized (this.a)
      {
        this.a.notifyAll();
        return;
      }
    } while (!this.a.compareAndSet(i, i - 2));
  }
  
  public void c()
  {
    if (this.a.compareAndSet(0, 1)) {}
    while (this.a.compareAndSet(1, 1)) {
      return;
    }
    int i;
    do
    {
      i = this.a.get();
    } while (!this.a.compareAndSet(i, i | 0x1));
    try
    {
      synchronized (this.a)
      {
        this.a.wait();
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.o
 * JD-Core Version:    0.7.0.1
 */