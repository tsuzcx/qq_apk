package cooperation.qappcenter.remote;

import avgx;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RemoteServiceProxy$2
  extends Thread
{
  public RemoteServiceProxy$2(avgx paramavgx) {}
  
  public void run()
  {
    while (!this.this$0.sendMsgQueue.isEmpty())
    {
      SendMsg localSendMsg = (SendMsg)this.this$0.sendMsgQueue.poll();
      if (localSendMsg != null) {
        try
        {
          this.this$0.b(localSendMsg);
        }
        catch (Exception localException)
        {
          RecvMsg localRecvMsg = this.this$0.a(localSendMsg, "sendMsgToServiceFailed，" + localException.toString());
          this.this$0.a(localSendMsg, localRecvMsg);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qappcenter.remote.RemoteServiceProxy.2
 * JD-Core Version:    0.7.0.1
 */