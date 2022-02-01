package cooperation.qqindividuality.ipc;

import avld;
import avld.a;
import avle;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QQIndividualityRemoteProxy$2$1
  extends Thread
{
  public QQIndividualityRemoteProxy$2$1(avle paramavle) {}
  
  public void run()
  {
    while (!this.a.this$0.c.isEmpty())
    {
      avld.a locala = (avld.a)this.a.this$0.c.poll();
      if (locala != null) {
        this.a.this$0.a(locala);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.2.1
 * JD-Core Version:    0.7.0.1
 */