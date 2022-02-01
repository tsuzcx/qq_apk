import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

class amzp
  extends aefh
{
  amzp(amzo paramamzo) {}
  
  public void onRecvResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && ("VideoSvc.Send".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())))
    {
      localObject = this.b.a("VideoSvc.Send");
      if (localObject != null)
      {
        localObject = ((swr)localObject).a(paramToServiceMsg, paramFromServiceMsg);
        localMessageHandler = amzo.a(this.b).a();
        if ((localMessageHandler != null) && (localObject != null)) {
          localMessageHandler.onReceive(paramToServiceMsg, paramFromServiceMsg, localObject);
        }
      }
    }
    while (paramFromServiceMsg == null)
    {
      Object localObject;
      MessageHandler localMessageHandler;
      return;
    }
    this.b.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     amzp
 * JD-Core Version:    0.7.0.1
 */