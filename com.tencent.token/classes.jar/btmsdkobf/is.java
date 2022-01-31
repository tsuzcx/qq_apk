package btmsdkobf;

import java.util.Iterator;
import java.util.LinkedList;

class is
  implements Runnable
{
  is(eb parameb) {}
  
  public void run()
  {
    synchronized (eb.a(this.a))
    {
      LinkedList localLinkedList = (LinkedList)eb.a(this.a).clone();
      if (localLinkedList != null)
      {
        ??? = localLinkedList.iterator();
        if (((Iterator)???).hasNext()) {
          ((eb.a)((Iterator)???).next()).O();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.is
 * JD-Core Version:    0.7.0.1
 */