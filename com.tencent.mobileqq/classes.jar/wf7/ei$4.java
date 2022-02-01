package wf7;

import java.util.Iterator;
import java.util.LinkedList;

class ei$4
  implements Runnable
{
  ei$4(ei paramei) {}
  
  public void run()
  {
    ??? = dn.bK();
    if (??? != null) {
      ((dn)???).bL();
    }
    synchronized (ei.c(this.mu))
    {
      Object localObject2 = (LinkedList)ei.c(this.mu).clone();
      ??? = ((LinkedList)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (ei.a)((Iterator)???).next();
        if (localObject2 != null) {
          ((ei.a)localObject2).onConnected();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.ei.4
 * JD-Core Version:    0.7.0.1
 */