import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Collection;

public class acfk
  extends FriendListHandler
  implements andh
{
  private ToServiceMsg i;
  
  public acfk(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public ReqItem a(int paramInt)
  {
    Object localObject2 = new ArrayList(2);
    ((ArrayList)localObject2).add(this.app.getAccount());
    Object localObject1 = (anxr)this.app.getManager(61);
    if (localObject1 != null) {}
    for (localObject1 = ((anxr)localObject1).dK();; localObject1 = null)
    {
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
        ((ArrayList)localObject2).addAll((Collection)localObject1);
      }
      localObject1 = new String[((ArrayList)localObject2).size()];
      ((ArrayList)localObject2).toArray((Object[])localObject1);
      K((String[])localObject1);
      if (this.i != null)
      {
        localObject2 = this.app.a.a(this.i.getServiceCmd());
        if (localObject2 != null)
        {
          localObject1 = new UniPacket(true);
          ((UniPacket)localObject1).setEncodeName("utf-8");
          if (((swr)localObject2).a(this.i, (UniPacket)localObject1))
          {
            localObject2 = new ReqItem();
            ((ReqItem)localObject2).eServiceID = 119;
            ((ReqItem)localObject2).vecParam = ((UniPacket)localObject1).encode();
            return localObject2;
          }
        }
      }
      return null;
    }
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 119) && (paramRespItem.cResult == 2))
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(this.app.getAccount(), "ProfileService.GetRichSig");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acfk
 * JD-Core Version:    0.7.0.1
 */