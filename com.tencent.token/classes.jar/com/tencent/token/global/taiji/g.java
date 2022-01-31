package com.tencent.token.global.taiji;

import java.util.ArrayList;
import java.util.Iterator;

class g
  implements Runnable
{
  g(d paramd, i parami) {}
  
  public void run()
  {
    this.b.e.execute(this.a);
    if ((this.b.e.getActiveCount() >= d.c(this.b)) && (this.b.e.getCorePoolSize() < 18))
    {
      this.b.e.setCorePoolSize(this.b.e.getCorePoolSize() + 1);
      this.b.e.setMaximumPoolSize(this.b.e.getCorePoolSize() + 1);
    }
    for (;;)
    {
      Iterator localIterator = this.b.b().iterator();
      while (localIterator.hasNext()) {
        ((r)localIterator.next()).a(this.a.a(), this.b.e.getActiveCount());
      }
      d.a(this.b, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.g
 * JD-Core Version:    0.7.0.1
 */