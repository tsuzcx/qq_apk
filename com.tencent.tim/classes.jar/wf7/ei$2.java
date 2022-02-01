package wf7;

import java.util.Iterator;
import java.util.LinkedList;

class ei$2
  implements Runnable
{
  ei$2(ei paramei) {}
  
  public void run()
  {
    synchronized (ei.b(this.mu))
    {
      Object localObject2 = (LinkedList)ei.b(this.mu).clone();
      ??? = ((LinkedList)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (ei.b)((Iterator)???).next();
        if (localObject2 != null) {
          ((ei.b)localObject2).cM();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.ei.2
 * JD-Core Version:    0.7.0.1
 */