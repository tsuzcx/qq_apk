package com.tencent.mobileqq.service.troop;

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

public class TroopReceiver
{
  private static final String a = TroopReceiver.class.getSimpleName();
  
  private final Object a(byte[] paramArrayOfByte, String paramString, Object paramObject)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramObject);
    }
    catch (RuntimeException paramArrayOfByte)
    {
      return (Object)null;
    }
    catch (Exception paramArrayOfByte) {}
    return (Object)null;
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetMultiTroopInfoResp)a(paramFromServiceMsg.getWupBuffer(), "GMTIRESP", new GetMultiTroopInfoResp());
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = (GetTroopListRespV2)a(paramFromServiceMsg.getWupBuffer(), "GetTroopListRespV2", new GetTroopListRespV2());
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
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = (GetTroopRemarkResp)a(paramFromServiceMsg.getWupBuffer(), "GTRRESP", new GetTroopRemarkResp());
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
  
  private Object e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = (GetTroopMemberListResp)a(paramFromServiceMsg.getWupBuffer(), "GTMLRESP", new GetTroopMemberListResp());
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("FriendListService.decodeTroopGetMemberList");
      if (paramFromServiceMsg != null) {
        break label63;
      }
    }
    label63:
    for (paramToServiceMsg = "resp == null";; paramToServiceMsg = "resp != null")
    {
      QLog.d("get_troop_member", 2, paramToServiceMsg);
      return paramFromServiceMsg;
    }
  }
  
  private Object f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (ModifyGroupCardResp)a(paramFromServiceMsg.getWupBuffer(), "MGCRESP", new ModifyGroupCardResp());
  }
  
  private Object g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (ModifyGroupInfoResp)a(paramFromServiceMsg.getWupBuffer(), "MGIRESP", new ModifyGroupInfoResp());
  }
  
  private Object h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetTroopAppointRemarkResp)a(paramFromServiceMsg.getWupBuffer(), "GTARESP", new GetTroopAppointRemarkResp());
  }
  
  private Object i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RespBatchProcess)a(paramFromServiceMsg.getWupBuffer(), "RespBatchProcess", new RespBatchProcess());
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "~~~decode cmd: " + str);
    }
    if ("friendlist.GetMultiTroopInfoReq".equalsIgnoreCase(str)) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetTroopListReqV2".equalsIgnoreCase(str)) {
      return c(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.getTroopRemark".equalsIgnoreCase(str)) {
      return d(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.getTroopMemberList".equalsIgnoreCase(str)) {
      return e(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.ModifyGroupCardReq".equalsIgnoreCase(str)) {
      return f(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.ModifyGroupInfoReq".equalsIgnoreCase(str)) {
      return g(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetTroopAppointRemarkReq".equalsIgnoreCase(str)) {
      return h(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("ProfileService.ReqBatchProcess".equalsIgnoreCase(str)) {
      return i(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.troop.TroopReceiver
 * JD-Core Version:    0.7.0.1
 */