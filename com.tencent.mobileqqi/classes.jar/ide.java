import cooperation.qzone.remote.RecvMsg;
import cooperation.qzone.remote.RemoteServiceProxy;
import cooperation.qzone.remote.SendMsg;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ide
  extends Thread
{
  public ide(RemoteServiceProxy paramRemoteServiceProxy) {}
  
  public void run()
  {
    while (!this.a.sendMsgQueue.isEmpty())
    {
      SendMsg localSendMsg = (SendMsg)this.a.sendMsgQueue.poll();
      if (localSendMsg != null) {
        try
        {
          this.a.sendMsgToService(localSendMsg);
        }
        catch (Exception localException)
        {
          RecvMsg localRecvMsg = this.a.createWaiteRespTimeout(localSendMsg, "sendMsgToServiceFailed，" + localException.toString());
          this.a.sendFailedRespToApp(localSendMsg, localRecvMsg);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ide
 * JD-Core Version:    0.7.0.1
 */