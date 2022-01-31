package com.tencent.mobileqq.msf.core.b;

import java.util.ArrayList;
import java.util.Iterator;

class k
  extends Thread
{
  k(i parami) {}
  
  public void run()
  {
    Iterator localIterator = this.a.o.iterator();
    while (localIterator.hasNext()) {
      ((i.a)localIterator.next()).a();
    }
    this.a.p.addAll(this.a.o);
    this.a.o.clear();
    this.a.q = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.k
 * JD-Core Version:    0.7.0.1
 */