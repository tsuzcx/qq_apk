package tmsdk.common.d.a.c;

import java.util.Iterator;
import java.util.LinkedList;

class k
  implements Runnable
{
  k(j paramj) {}
  
  public void run()
  {
    for (;;)
    {
      boolean bool;
      synchronized (j.a(this.a))
      {
        LinkedList localLinkedList = (LinkedList)j.a(this.a).clone();
        ??? = new StringBuilder().append("copy != null ? ");
        if (localLinkedList != null)
        {
          bool = true;
          ((StringBuilder)???).append(bool).toString();
          if (localLinkedList == null) {
            break;
          }
          new StringBuilder().append("copy.size() : ").append(localLinkedList.size()).toString();
          ??? = localLinkedList.iterator();
          if (!((Iterator)???).hasNext()) {
            break;
          }
          ((m)((Iterator)???).next()).o();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.c.k
 * JD-Core Version:    0.7.0.1
 */