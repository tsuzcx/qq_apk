package btmsdkobf;

import java.util.Iterator;
import java.util.LinkedList;

class gq
  implements Runnable
{
  gq(cz paramcz) {}
  
  public void run()
  {
    eh.e("SharkNetworkReceiver", "[conn_monitor]handleChange2Connected(), 无网络 -> 有网络");
    ??? = cg.bb();
    Object localObject2 = new StringBuilder().append("[conn_monitor][ip_list]handleChange2Connected(), notify hiplist first: ");
    boolean bool;
    if (??? != null) {
      bool = true;
    }
    for (;;)
    {
      eh.e("SharkNetworkReceiver", bool);
      if (??? != null) {
        ((cg)???).bc();
      }
      synchronized (cz.c(this.a))
      {
        localObject2 = (LinkedList)cz.c(this.a).clone();
        ??? = ((LinkedList)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (cz.a)((Iterator)???).next();
          if (localObject2 != null)
          {
            ((cz.a)localObject2).onConnected();
            continue;
            bool = false;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.gq
 * JD-Core Version:    0.7.0.1
 */