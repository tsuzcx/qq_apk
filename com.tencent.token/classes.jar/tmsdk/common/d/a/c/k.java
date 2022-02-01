package tmsdk.common.d.a.c;

import java.util.Iterator;
import java.util.LinkedList;

class k
  implements Runnable
{
  k(j paramj) {}
  
  public void run()
  {
    synchronized (j.a(this.a))
    {
      Object localObject1 = (LinkedList)j.a(this.a).clone();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("copy != null ? ");
      boolean bool;
      if (localObject1 != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)???).append(bool);
      ((StringBuilder)???).toString();
      if (localObject1 != null)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("copy.size() : ");
        ((StringBuilder)???).append(((LinkedList)localObject1).size());
        ((StringBuilder)???).toString();
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((m)((Iterator)localObject1).next()).o();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.c.k
 * JD-Core Version:    0.7.0.1
 */