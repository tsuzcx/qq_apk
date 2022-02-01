package com.tencent.token;

import java.util.Iterator;
import java.util.LinkedList;
import tmsdk.common.d.a.c.j;

public final class ara
  implements Runnable
{
  public ara(j paramj) {}
  
  public final void run()
  {
    synchronized (j.a(this.a))
    {
      LinkedList localLinkedList = (LinkedList)j.a(this.a).clone();
      ??? = new StringBuilder("copy != null ? ");
      boolean bool;
      if (localLinkedList != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)???).append(bool);
      if (localLinkedList != null)
      {
        new StringBuilder("copy.size() : ").append(localLinkedList.size());
        ??? = localLinkedList.iterator();
        while (((Iterator)???).hasNext()) {
          ((arc)((Iterator)???).next()).f();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ara
 * JD-Core Version:    0.7.0.1
 */