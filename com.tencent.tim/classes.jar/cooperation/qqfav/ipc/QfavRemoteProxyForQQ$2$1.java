package cooperation.qqfav.ipc;

import avjy;
import avjy.a;
import avjz;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QfavRemoteProxyForQQ$2$1
  extends Thread
{
  public QfavRemoteProxyForQQ$2$1(avjz paramavjz) {}
  
  public void run()
  {
    while (!this.a.this$0.c.isEmpty())
    {
      avjy.a locala = (avjy.a)this.a.this$0.c.poll();
      if (locala != null) {
        avjy.a(this.a.this$0, locala);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavRemoteProxyForQQ.2.1
 * JD-Core Version:    0.7.0.1
 */