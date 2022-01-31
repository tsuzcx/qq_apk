package com.tencent.mobileqq.service;

import VIP.VipUserInfo;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class VIPService
  extends BaseProtocolCoder
{
  private static final String[] a = { "ClubInfoSvc" };
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (VipUserInfo)a(paramFromServiceMsg.getWupBuffer(), "stVipInfo", new VipUserInfo());
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("VIP.AsyncSsoProxyServer.QueryVipInfo");
    paramUniPacket.setFuncName("queryQQInfo");
    String str = paramToServiceMsg.extraData.getString("k_uin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("k_skey");
    paramUniPacket.put("sQQNo", str);
    paramUniPacket.put("sKey", paramToServiceMsg);
    paramUniPacket.put("iGetType", Integer.valueOf(0));
    return true;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("ClubInfoSvc.GetVipInfoReq".equals(paramToServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg) {}
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if ("ClubInfoSvc.GetVipInfoReq".equals(paramToServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public String[] a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.VIPService
 * JD-Core Version:    0.7.0.1
 */