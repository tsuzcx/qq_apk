import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class acla
  extends FriendListHandler
  implements andh
{
  private ToServiceMsg i;
  
  public acla(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public ReqItem a(int paramInt)
  {
    Object localObject1;
    if (this.app.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.cyz == 2)
    {
      localObject1 = (aqlz)this.app.getManager(31);
      if (localObject1 != null) {
        ((aqlz)localObject1).a(true, this);
      }
    }
    if (this.i != null)
    {
      Object localObject2 = this.app.jdField_a_of_type_Amzo.a(this.i.getServiceCmd());
      if (localObject2 != null)
      {
        localObject1 = new UniPacket(true);
        ((UniPacket)localObject1).setEncodeName("utf-8");
        if (((swr)localObject2).a(this.i, (UniPacket)localObject1))
        {
          localObject2 = new ReqItem();
          ((ReqItem)localObject2).eServiceID = 115;
          ((ReqItem)localObject2).vecParam = ((UniPacket)localObject1).encode();
          return localObject2;
        }
      }
    }
    return null;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 115) && (paramRespItem.cResult == 2))
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(this.app.getAccount(), "ProfileService.ReqGetSettings");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.putWupBuffer(paramRespItem.vecUpdate);
      this.app.f(this.i, localFromServiceMsg);
    }
  }
  
  public int mT()
  {
    return 1;
  }
  
  public void send(ToServiceMsg paramToServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "ReqGetSettingsItem.send...");
    }
    this.i = paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acla
 * JD-Core Version:    0.7.0.1
 */