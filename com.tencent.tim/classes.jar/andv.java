import KQQ.RespBatchProcess;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetMultiTroopInfoResp;
import friendlist.GetTroopAppointRemarkResp;
import friendlist.GetTroopListRespV2;
import friendlist.GetTroopMemberListResp;
import friendlist.GetTroopRemarkResp;
import friendlist.ModifyGroupCardResp;
import friendlist.ModifyGroupInfoResp;

public class andv
{
  private Object aD(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetMultiTroopInfoResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "GMTIRESP", new GetMultiTroopInfoResp());
  }
  
  private Object aE(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = (GetTroopListRespV2)decodePacket(paramFromServiceMsg.getWupBuffer(), "GetTroopListRespV2", new GetTroopListRespV2());
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.result != 1))
    {
      paramToServiceMsg = paramFromServiceMsg;
      if (paramFromServiceMsg.vecTroopList == null)
      {
        paramToServiceMsg = paramFromServiceMsg;
        if (paramFromServiceMsg.vecTroopListDel == null)
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg.vecTroopRank == null)
          {
            paramToServiceMsg = paramFromServiceMsg;
            if (paramFromServiceMsg.vecFavGroup != null) {}
          }
        }
      }
    }
    else
    {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  private Object aF(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = (GetTroopRemarkResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "GTRRESP", new GetTroopRemarkResp());
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = null;
    }
    do
    {
      return paramToServiceMsg;
      paramToServiceMsg = paramFromServiceMsg;
    } while (paramFromServiceMsg.result != 1);
    return null;
  }
  
  private Object aG(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      paramToServiceMsg = (GetTroopMemberListResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "GTMLRESP", new GetTroopMemberListResp());
      paramFromServiceMsg = paramToServiceMsg;
      StringBuilder localStringBuilder;
      label74:
      return paramFromServiceMsg;
    }
    catch (OutOfMemoryError paramToServiceMsg)
    {
      try
      {
        if (!QLog.isColorLevel()) {
          return paramFromServiceMsg;
        }
        localStringBuilder = new StringBuilder().append("FriendListService.decodeTroopGetMemberList");
        if (paramToServiceMsg == null) {}
        for (paramFromServiceMsg = "resp == null";; paramFromServiceMsg = "resp != null")
        {
          QLog.d("get_troop_member", 2, paramFromServiceMsg);
          return paramToServiceMsg;
        }
        paramToServiceMsg = paramToServiceMsg;
        paramToServiceMsg = null;
      }
      catch (OutOfMemoryError paramFromServiceMsg)
      {
        break label74;
      }
      paramFromServiceMsg = paramToServiceMsg;
      if (QLog.isColorLevel())
      {
        QLog.e("TroopReceiver", 2, "decodeTroopGetMemberList OOM");
        return paramToServiceMsg;
      }
    }
  }
  
  private Object aH(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (ModifyGroupCardResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "MGCRESP", new ModifyGroupCardResp());
  }
  
  private Object aI(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (ModifyGroupInfoResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "MGIRESP", new ModifyGroupInfoResp());
  }
  
  private Object aJ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetTroopAppointRemarkResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "GTARESP", new GetTroopAppointRemarkResp());
  }
  
  private Object aK(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RespBatchProcess)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespBatchProcess", new RespBatchProcess());
  }
  
  private final <T> T decodePacket(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    catch (RuntimeException paramArrayOfByte) {}
    return null;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("TroopReceiver", 2, "~~~decode cmd: " + str);
    }
    if ("friendlist.GetMultiTroopInfoReq".equalsIgnoreCase(str)) {
      return aD(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetTroopListReqV2".equalsIgnoreCase(str)) {
      return aE(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.getTroopRemark".equalsIgnoreCase(str)) {
      return aF(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.getTroopMemberList".equalsIgnoreCase(str)) {
      return aG(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.ModifyGroupCardReq".equalsIgnoreCase(str)) {
      return aH(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.ModifyGroupInfoReq".equalsIgnoreCase(str)) {
      return aI(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetTroopAppointRemarkReq".equalsIgnoreCase(str)) {
      return aJ(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("ProfileService.ReqBatchProcess".equalsIgnoreCase(str)) {
      return aK(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     andv
 * JD-Core Version:    0.7.0.1
 */