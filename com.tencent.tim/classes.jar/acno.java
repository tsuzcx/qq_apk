import VIP.AIOKeyWordReq;
import VIP.AIOSendReq;
import VIP.AIOSendRes;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class acno
  extends accg
{
  public static String CMD = "AIOSendSvc.CheckPopGrayStips";
  public static int bDr = 1;
  public static String bpT = "AIOSendSvc.getUserKeyWordStips";
  
  public acno(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void FJ(String paramString)
  {
    paramString = new AIOKeyWordReq(this.app.getCurrentUin(), paramString);
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), bpT);
    localToServiceMsg.extraData.putSerializable("VIPAioSendRequest", paramString);
    super.send(localToServiceMsg);
  }
  
  public void a(AIOSendReq paramAIOSendReq)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), CMD);
    localToServiceMsg.extraData.putSerializable("VIPAioSendRequest", paramAIOSendReq);
    super.send(localToServiceMsg);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return acnp.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null))
    {
      notifyUI(bDr, false, null);
      return;
    }
    paramToServiceMsg = paramToServiceMsg.getServiceCmd();
    if (CMD.equals(paramToServiceMsg))
    {
      paramToServiceMsg = (AIOSendRes)paramObject;
      aquu.a().a(this.app, paramToServiceMsg);
    }
    for (;;)
    {
      notifyUI(bDr, true, paramObject);
      return;
      if (bpT.equals(paramToServiceMsg))
      {
        paramToServiceMsg = (AIOSendRes)paramObject;
        aquv.a().b(this.app, paramToServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acno
 * JD-Core Version:    0.7.0.1
 */