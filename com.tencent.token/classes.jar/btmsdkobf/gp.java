package btmsdkobf;

import java.util.Iterator;
import java.util.LinkedList;

class gp
  implements Runnable
{
  gp(cz paramcz) {}
  
  public void run()
  {
    eh.e("SharkNetworkReceiver", "[conn_monitor]handleChange2DisConnected(), 有网络 -> 无网络");
    synchronized (cz.c(this.a))
    {
      Object localObject2 = (LinkedList)cz.c(this.a).clone();
      ??? = ((LinkedList)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (cz.a)((Iterator)???).next();
        if (localObject2 != null) {
          ((cz.a)localObject2).onDisconnected();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.gp
 * JD-Core Version:    0.7.0.1
 */