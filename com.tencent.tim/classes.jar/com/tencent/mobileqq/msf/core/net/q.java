package com.tencent.mobileqq.msf.core.net;

import java.util.ArrayList;
import java.util.Iterator;

class q
  extends Thread
{
  q(n paramn) {}
  
  public void run()
  {
    Iterator localIterator = n.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((n.a)localIterator.next()).a();
    }
    n.b(this.a).addAll(n.a(this.a));
    n.a(this.a).clear();
    n.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.q
 * JD-Core Version:    0.7.0.1
 */