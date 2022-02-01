package wf7;

import java.util.Iterator;
import java.util.LinkedList;

class ei$3
  implements Runnable
{
  ei$3(ei paramei) {}
  
  public void run()
  {
    synchronized (ei.c(this.mu))
    {
      Object localObject2 = (LinkedList)ei.c(this.mu).clone();
      ??? = ((LinkedList)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (ei.a)((Iterator)???).next();
        if (localObject2 != null) {
          ((ei.a)localObject2).onDisconnected();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.ei.3
 * JD-Core Version:    0.7.0.1
 */