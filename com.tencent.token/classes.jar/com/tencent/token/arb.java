package com.tencent.token;

import java.util.Iterator;
import java.util.LinkedList;
import tmsdk.common.d.a.c.j;

public final class arb
  implements Runnable
{
  public arb(j paramj) {}
  
  public final void run()
  {
    synchronized (j.a(this.a))
    {
      LinkedList localLinkedList = (LinkedList)j.a(this.a).clone();
      if (localLinkedList != null)
      {
        ??? = localLinkedList.iterator();
        while (((Iterator)???).hasNext()) {
          ((Iterator)???).next();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.arb
 * JD-Core Version:    0.7.0.1
 */