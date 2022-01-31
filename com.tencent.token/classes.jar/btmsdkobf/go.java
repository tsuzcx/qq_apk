package btmsdkobf;

import java.util.Iterator;
import java.util.LinkedList;

class go
  implements Runnable
{
  go(cz paramcz) {}
  
  public void run()
  {
    eh.e("SharkNetworkReceiver", "[conn_monitor]handleNetworkChange()");
    synchronized (cz.b(this.a))
    {
      Object localObject2 = (LinkedList)cz.b(this.a).clone();
      ??? = ((LinkedList)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (cz.b)((Iterator)???).next();
        if (localObject2 != null) {
          ((cz.b)localObject2).bz();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.go
 * JD-Core Version:    0.7.0.1
 */