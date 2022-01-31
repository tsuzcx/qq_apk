package com.tencent.token.global.taiji;

import java.util.ArrayList;
import java.util.Iterator;

class e
  implements Runnable
{
  e(d paramd, boolean paramBoolean, i parami) {}
  
  public void run()
  {
    if (!this.a)
    {
      localIterator = this.c.a().iterator();
      while (localIterator.hasNext()) {
        ((s)localIterator.next()).a();
      }
    }
    Iterator localIterator = this.c.b().iterator();
    while (localIterator.hasNext()) {
      ((r)localIterator.next()).a(this.b.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.e
 * JD-Core Version:    0.7.0.1
 */