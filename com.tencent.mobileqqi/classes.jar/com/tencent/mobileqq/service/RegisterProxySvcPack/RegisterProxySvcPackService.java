package com.tencent.mobileqq.service.RegisterProxySvcPack;

import MessageSvcPack.SvcResponseGetMsgV2;
import MessageSvcPack.SvcResponsePullDisMsgSeq;
import MessageSvcPack.SvcResponsePullGroupMsgSeq;
import QQService.SvcReqRegister;
import QQService.SvcRespRegister;
import RegisterProxySvcPack.RegisterPushNotice;
import RegisterProxySvcPack.SvcRequestRegisterAndroid;
import RegisterProxySvcPack.SvcRequestRegisterNew;
import RegisterProxySvcPack.SvcRespParam;
import RegisterProxySvcPack.SvcResponsePullDisGroupSeq;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.Key;

public class RegisterProxySvcPackService
  extends BaseProtocolCoder
{
  private static final int jdField_a_of_type_Int = 200;
  private static final String jdField_a_of_type_JavaLangString = "RegisterProxySvcPackService";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "RegPrxySvc" };
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public RegisterProxySvcPackService(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private SvcReqRegister a()
  {
    SvcReqRegister localSvcReqRegister = new SvcReqRegister();
    localSvcReqRegister.lUin = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localSvcReqRegister.lBid = 7L;
    localSvcReqRegister.cConnType = 0;
    AppRuntime.Status localStatus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
    switch (gis.a[localStatus.ordinal()])
    {
    default: 
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b()) {
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      localSvcReqRegister.bKikPC = ((byte)i);
      localSvcReqRegister.bKikWeak = 0;
      localSvcReqRegister.timeStamp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacts.", 2, " makeSvcReqRegisterPkg " + localSvcReqRegister.iStatus + ", " + localSvcReqRegister.bKikPC + ", " + localSvcReqRegister.timeStamp);
      }
      return localSvcReqRegister;
      localSvcReqRegister.iStatus = 11;
      break;
      localSvcReqRegister.iStatus = 21;
      break;
      localSvcReqRegister.iStatus = 31;
      break;
      localSvcReqRegister.iStatus = 41;
      break;
    }
  }
  
  private SvcRequestRegisterNew a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    SvcRequestRegisterNew localSvcRequestRegisterNew = new SvcRequestRegisterNew();
    localSvcRequestRegisterNew.cDisgroupMsgFilter = 1;
    long l = paramToServiceMsg.extraData.getLong("requestOptional");
    int i = paramToServiceMsg.extraData.getInt("type");
    int j = paramToServiceMsg.extraData.getInt("endSeq");
    localSvcRequestRegisterNew.ulRequestOptional = l;
    localSvcRequestRegisterNew.cSubCmd = 0;
    if ((0x10 & l) == 16L) {
      localSvcRequestRegisterNew.regist = a();
    }
    if ((0x40 & l) == 64L)
    {
      localSvcRequestRegisterNew.c2cmsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      paramUniPacket.put("req_PbOffMsg", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a());
    }
    if (((0x4 & l) == 4L) || ((0x80 & l) == 128L))
    {
      localSvcRequestRegisterNew.groupmsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i);
      if (localSvcRequestRegisterNew.groupmsg == null)
      {
        localSvcRequestRegisterNew.ulRequestOptional &= 0xFFFFFFFB;
        localSvcRequestRegisterNew.ulRequestOptional &= 0xFFFFFF7F;
      }
    }
    if (((0x8 & l) == 8L) || ((l & 0x100) == 256L))
    {
      if (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.infoLogin")) {
        break label324;
      }
      localSvcRequestRegisterNew.disgroupmsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    }
    for (;;)
    {
      if (i == 1) {
        localSvcRequestRegisterNew.cGroupMask = 2;
      }
      localSvcRequestRegisterNew.uEndSeq = j;
      if (QLog.isColorLevel()) {
        QLog.d("SvcRequestRegisterNew", 2, "cDisgroupMsgFilter:" + localSvcRequestRegisterNew.cDisgroupMsgFilter + ",NoticeEndSeq:" + j);
      }
      return localSvcRequestRegisterNew;
      label324:
      localSvcRequestRegisterNew.confmsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      if (localSvcRequestRegisterNew.confmsg == null)
      {
        localSvcRequestRegisterNew.ulRequestOptional &= 0xFFFFFFF7;
        localSvcRequestRegisterNew.ulRequestOptional &= 0xFFFFFEFF;
      }
    }
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRespParam)a(paramFromServiceMsg.getWupBuffer(), "SvcRespParam", new SvcRespParam());
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new SvcRequestRegisterAndroid();
    paramToServiceMsg.ulRequestOptional = 1L;
    paramUniPacket.setServantName("RegisterProxySvcPack");
    paramUniPacket.setFuncName("OffLineMsg");
    paramUniPacket.put("req_OffMsg", paramToServiceMsg);
    return true;
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    SvcRespRegister localSvcRespRegister = null;
    if ((paramToServiceMsg.extraData.getLong("requestOptional", 0L) & 0x10) == 16L) {
      localSvcRespRegister = (SvcRespRegister)a(paramFromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
    }
    if (localSvcRespRegister != null) {
      if (QLog.isColorLevel()) {
        QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyInfoNew resp.strResult =" + localSvcRespRegister.strResult);
      }
    }
    while (!QLog.isColorLevel()) {
      return localSvcRespRegister;
    }
    QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyTroopMsg null");
    return localSvcRespRegister;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("RegPrxySvc");
    SvcRequestRegisterNew localSvcRequestRegisterNew = a(paramToServiceMsg, paramUniPacket);
    paramUniPacket.put("req_OffMsg", a(paramToServiceMsg, paramUniPacket));
    return localSvcRequestRegisterNew.ulRequestOptional != 0L;
  }
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponsePullGroupMsgSeq)a(paramFromServiceMsg.getWupBuffer(), "resp_PullGroupMsgSeq", new SvcResponsePullGroupMsgSeq());
    if (paramToServiceMsg != null) {
      if (QLog.isColorLevel()) {
        QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyTroopSeq cReplyCode = " + paramToServiceMsg.cReplyCode);
      }
    }
    while (!QLog.isColorLevel()) {
      return paramToServiceMsg;
    }
    QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyTroopSeq null");
    return paramToServiceMsg;
  }
  
  private Object e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RegisterPushNotice)a(paramFromServiceMsg.getWupBuffer(), "RegisterPushNotice", new RegisterPushNotice());
    if (paramToServiceMsg != null) {
      if (QLog.isColorLevel()) {
        QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyTroopSeq cReplyCode = " + paramToServiceMsg.ulTimeOutFlag);
      }
    }
    while (!QLog.isColorLevel()) {
      return paramToServiceMsg;
    }
    QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyTroopSeq null");
    return paramToServiceMsg;
  }
  
  private Object f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponsePullDisMsgSeq)a(paramFromServiceMsg.getWupBuffer(), "resp_PullDisMsgSeq", new SvcResponsePullDisMsgSeq());
    if (paramToServiceMsg != null) {
      if (QLog.isColorLevel()) {
        QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyDisMsg cReplyCode = " + paramToServiceMsg.cReplyCode);
      }
    }
    while (!QLog.isColorLevel()) {
      return paramToServiceMsg;
    }
    QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyDisMsg null");
    return paramToServiceMsg;
  }
  
  private Object g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponsePullDisGroupSeq)a(paramFromServiceMsg.getWupBuffer(), "resp_PullDisGroupSeq", new SvcResponsePullDisGroupSeq());
    if (paramToServiceMsg != null) {
      if (QLog.isColorLevel()) {
        QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyDisGroupSeq cReplyCode = " + paramToServiceMsg.cReplyCode);
      }
    }
    while (!QLog.isColorLevel()) {
      return paramToServiceMsg;
    }
    QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyDisGroupSeq null");
    return paramToServiceMsg;
  }
  
  private Object h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcResponseGetMsgV2)a(paramFromServiceMsg.getWupBuffer(), "resp_GetMsgV2", new SvcResponseGetMsgV2());
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("RegPrxySvc.infoAndroid".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      do
      {
        return null;
        if ("RegPrxySvc.PushParam".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
          return b(paramToServiceMsg, paramFromServiceMsg);
        }
      } while ("RegPrxySvc.PbGetMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
      if ("RegPrxySvc.GetMsgV2".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
        return h(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("RegPrxySvc.PullGroupMsgSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
        return d(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("RegPrxySvc.PullDisMsgSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
        return f(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("RegPrxySvc.PullDisGroupSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
        return g(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("RegPrxySvc.infoLogin".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
        return c(paramToServiceMsg, paramFromServiceMsg);
      }
    } while (!"RegPrxySvc.NoticeEnd".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
    return e(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg) {}
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.infoAndroid")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.infoLogin")) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.getOffMsg")) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.RegisterProxySvcPack.RegisterProxySvcPackService
 * JD-Core Version:    0.7.0.1
 */