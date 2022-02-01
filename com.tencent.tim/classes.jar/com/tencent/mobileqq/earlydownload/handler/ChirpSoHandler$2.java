package com.tencent.mobileqq.earlydownload.handler;

import afet;
import afet.a;
import java.util.Iterator;
import java.util.LinkedList;

public class ChirpSoHandler$2
  implements Runnable
{
  public ChirpSoHandler$2(afet paramafet) {}
  
  public void run()
  {
    synchronized (afet.a(this.this$0))
    {
      Iterator localIterator = afet.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((afet.a)localIterator.next()).bwK();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.2
 * JD-Core Version:    0.7.0.1
 */