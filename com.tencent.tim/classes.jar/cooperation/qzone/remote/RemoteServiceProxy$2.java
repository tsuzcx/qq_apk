package cooperation.qzone.remote;

import java.util.concurrent.ConcurrentLinkedQueue;

class RemoteServiceProxy$2
  extends Thread
{
  RemoteServiceProxy$2(RemoteServiceProxy paramRemoteServiceProxy) {}
  
  public void run()
  {
    while (!this.this$0.sendMsgQueue.isEmpty())
    {
      SendMsg localSendMsg = (SendMsg)this.this$0.sendMsgQueue.poll();
      if (localSendMsg != null) {
        try
        {
          this.this$0.sendMsgToService(localSendMsg);
        }
        catch (Exception localException)
        {
          RecvMsg localRecvMsg = this.this$0.createWaiteRespTimeout(localSendMsg, "sendMsgToServiceFailed，" + localException.toString());
          this.this$0.sendFailedRespToApp(localSendMsg, localRecvMsg);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.remote.RemoteServiceProxy.2
 * JD-Core Version:    0.7.0.1
 */