import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.compatible.ActionListener;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class gip
  extends ActionListener
{
  public gip(MobileQQService paramMobileQQService) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && ("VideoSvc.Send".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())))
    {
      localObject = this.a.a("VideoSvc.Send");
      if (localObject != null)
      {
        localObject = ((BaseProtocolCoder)localObject).a(paramToServiceMsg, paramFromServiceMsg);
        localMessageHandler = MobileQQService.a(this.a).a();
        if ((localMessageHandler != null) && (localObject != null)) {
          localMessageHandler.a(paramToServiceMsg, paramFromServiceMsg, localObject);
        }
      }
    }
    while (paramFromServiceMsg == null)
    {
      Object localObject;
      MessageHandler localMessageHandler;
      return;
    }
    this.a.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gip
 * JD-Core Version:    0.7.0.1
 */