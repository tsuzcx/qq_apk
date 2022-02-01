package cooperation.qlink;

import avhs;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QlinkServiceProxy$2
  extends Thread
{
  public QlinkServiceProxy$2(avhs paramavhs) {}
  
  public void run()
  {
    while (!avhs.a(this.this$0).isEmpty())
    {
      SendMsg localSendMsg = (SendMsg)avhs.a(this.this$0).poll();
      if (localSendMsg != null) {
        try
        {
          avhs.a(this.this$0, localSendMsg);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkServiceProxy.2
 * JD-Core Version:    0.7.0.1
 */