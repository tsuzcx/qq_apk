package tmsdk.common.d.a.c;

import java.util.Iterator;
import java.util.LinkedList;

class l
  implements Runnable
{
  l(j paramj) {}
  
  public void run()
  {
    synchronized (j.a(this.a))
    {
      LinkedList localLinkedList = (LinkedList)j.a(this.a).clone();
      if (localLinkedList != null)
      {
        ??? = localLinkedList.iterator();
        if (((Iterator)???).hasNext()) {
          ((Iterator)???).next();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.c.l
 * JD-Core Version:    0.7.0.1
 */