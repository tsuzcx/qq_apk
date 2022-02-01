import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class andi
  extends FriendListHandler
  implements andh
{
  public static String tag = "GetSimpleInfoCheckUpdateItem";
  private ToServiceMsg i;
  
  public andi(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public ReqItem a(int paramInt)
  {
    Object localObject2 = null;
    DG(this.app.getAccount());
    Object localObject1 = localObject2;
    if (this.i != null)
    {
      swr localswr = this.app.a.a(this.i.getServiceCmd());
      localObject1 = localObject2;
      if (localswr != null)
      {
        UniPacket localUniPacket = new UniPacket(true);
        localUniPacket.setEncodeName("utf-8");
        localObject1 = localObject2;
        if (localswr.a(this.i, localUniPacket))
        {
          localObject1 = new ReqItem();
          ((ReqItem)localObject1).eServiceID = 113;
          ((ReqItem)localObject1).vecParam = localUniPacket.encode();
        }
      }
    }
    return localObject1;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 113) && (paramRespItem.cResult == 2))
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(this.app.getAccount(), "ProfileService.GetSimpleInfo");
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
    this.i = paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     andi
 * JD-Core Version:    0.7.0.1
 */