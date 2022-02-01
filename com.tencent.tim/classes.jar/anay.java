import AccostSvc.ReqGetBlackList;
import AccostSvc.ReqHeader;
import AccostSvc.RespGetBlackList;
import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;

public class anay
  implements andh
{
  public static String tag = "GetBlackListItem";
  private final QQAppInterface app;
  
  public anay(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public ReqItem a(int paramInt)
  {
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 116;
    Object localObject = new ReqHeader();
    ((ReqHeader)localObject).shVersion = 0;
    ((ReqHeader)localObject).lMID = anbe.J(Long.parseLong(this.app.getAccount()));
    ((ReqHeader)localObject).iAppID = AppSetting.getAppId();
    localObject = new ReqGetBlackList((ReqHeader)localObject, 0L, 1, 0);
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setServantName("AccostObj");
    localUniPacket.setFuncName("CMD_GET_BlackList");
    localUniPacket.put("ReqGetBlackList", localObject);
    localReqItem.vecParam = localUniPacket.encode();
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 116) && (paramRespItem.cResult == 2))
    {
      Object localObject = new UniPacket();
      ((UniPacket)localObject).setEncodeName("utf-8");
      ((UniPacket)localObject).decode(paramRespItem.vecUpdate);
      paramRespItem = (RespGetBlackList)((UniPacket)localObject).getByClass("RespGetBlackList", new RespGetBlackList());
      localObject = (MessageHandler)this.app.getBusinessHandler(0);
      FromServiceMsg localFromServiceMsg = new FromServiceMsg();
      localFromServiceMsg.setMsgSuccess();
      ((MessageHandler)localObject).eK(null, localFromServiceMsg, paramRespItem);
    }
  }
  
  public int mT()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anay
 * JD-Core Version:    0.7.0.1
 */