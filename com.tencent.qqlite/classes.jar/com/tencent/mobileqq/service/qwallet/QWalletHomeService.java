package com.tencent.mobileqq.service.qwallet;

import Wallet.ReqApplication;
import Wallet.RspPayApplication;
import Wallet.RspRealApplication;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class QWalletHomeService
  extends BaseProtocolCoder
{
  private static final String jdField_a_of_type_JavaLangString = "QWalletHomeService";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  static
  {
    a = new String[] { "WalletRecommend" };
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (RspPayApplication)paramToServiceMsg.getByClass("RspPayApplication", new RspPayApplication());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QWalletHomeService", 4, "decodeRecommentWUP error:" + paramToServiceMsg.getMessage());
      }
      return null;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QWalletHomeService", 4, "decodeRecommentWUP error:" + paramToServiceMsg.getMessage());
      }
    }
    return null;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("WalletRecommendServer");
    paramUniPacket.setFuncName("getWalletRecommendAPP");
    paramUniPacket.put("ReqApplication", (ReqApplication)paramToServiceMsg.extraData.getSerializable("ReqApplication"));
    return true;
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (RspRealApplication)paramToServiceMsg.getByClass("RspRealApplication", new RspRealApplication());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QWalletHomeService", 4, "decodeRecommentWUP error:" + paramToServiceMsg.getMessage());
      }
      return null;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QWalletHomeService", 4, "decodeRecommentWUP error:" + paramToServiceMsg.getMessage());
      }
    }
    return null;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("WalletRecommendServer");
    paramUniPacket.setFuncName("getWalletRealAPP");
    paramUniPacket.put("ReqApplication", (ReqApplication)paramToServiceMsg.extraData.getSerializable("ReqApplication"));
    return true;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return null;
      if (str.compareTo("WalletRecommend.getWalletRecommendAPP") == 0) {
        return b(paramToServiceMsg, paramFromServiceMsg);
      }
    } while (str.compareTo("WalletRecommend.getWalletRealAPP") != 0);
    return c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg) {}
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return false;
      if (str.compareTo("WalletRecommend.getWalletRecommendAPP") == 0) {
        return b(paramToServiceMsg, paramUniPacket);
      }
    } while (str.compareTo("WalletRecommend.getWalletRealAPP") != 0);
    return c(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.qwallet.QWalletHomeService
 * JD-Core Version:    0.7.0.1
 */