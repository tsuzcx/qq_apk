package com.tencent.token.global.taiji;

import java.util.ArrayList;
import java.util.Iterator;

class h
  implements Runnable
{
  h(d paramd, i parami) {}
  
  public void run()
  {
    if (this.b.e.getCorePoolSize() < 18)
    {
      this.b.e.execute(this.a);
      this.b.e.setCorePoolSize(this.b.e.getCorePoolSize() + 1);
      this.b.e.setMaximumPoolSize(this.b.e.getCorePoolSize() + 1);
    }
    for (;;)
    {
      Iterator localIterator = this.b.b().iterator();
      while (localIterator.hasNext()) {
        ((r)localIterator.next()).a(this.a.a(), this.b.e.getActiveCount());
      }
      i.b(this.a).d = 5;
      this.b.e.execute(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.h
 * JD-Core Version:    0.7.0.1
 */