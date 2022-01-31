package com.tencent.token.global.taiji;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

class f
  implements Runnable
{
  f(d paramd, i parami) {}
  
  public void run()
  {
    d.a(this.b).writeLock().lock();
    try
    {
      Iterator localIterator = d.b(this.b).iterator();
      while (localIterator.hasNext()) {
        ((r)localIterator.next()).b(this.a.a());
      }
    }
    finally
    {
      d.a(this.b).writeLock().unlock();
    }
    if (this.b.e.getActiveCount() + 4 <= d.c(this.b)) {
      d.a(this.b, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.f
 * JD-Core Version:    0.7.0.1
 */