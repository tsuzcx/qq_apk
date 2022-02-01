import IPwdPxyMQQ.RespondHeader;
import IPwdPxyMQQ.RespondQueryIPwdStat;
import MessageSvcPack.SvcResponseGetMsgV2;
import MessageSvcPack.SvcResponsePullDisMsgSeq;
import MessageSvcPack.SvcResponsePullGroupMsgSeq;
import RegisterProxySvcPack.RegisterPushNotice;
import RegisterProxySvcPack.SvcRequestRegisterAndroid;
import RegisterProxySvcPack.SvcRequestRegisterNew;
import RegisterProxySvcPack.SvcRespParam;
import RegisterProxySvcPack.SvcResponsePullDisGroupSeq;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil;
import com.tencent.msf.service.protocol.push.SvcReqRegister;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.Key;

public class amzv
  extends swr
{
  private static final String[] ba = { "RegPrxySvc" };
  private QQAppInterface app;
  
  public amzv(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private SvcRequestRegisterNew a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("requestOptional");
    int i = paramToServiceMsg.extraData.getInt("type");
    int j = paramToServiceMsg.extraData.getInt("endSeq");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isGetPassword");
    SvcRequestRegisterNew localSvcRequestRegisterNew = new SvcRequestRegisterNew();
    localSvcRequestRegisterNew.cDisgroupMsgFilter = 1;
    localSvcRequestRegisterNew.ulRequestOptional = l;
    localSvcRequestRegisterNew.cSubCmd = 0;
    if (i == 3)
    {
      localSvcRequestRegisterNew.cOptGroupMsgFlag = 1;
      if (QLog.isColorLevel()) {
        QLog.d("SvcRequestRegisterNew", 2, "Type = " + i + ", req.cOptGroupMsgFlag = " + localSvcRequestRegisterNew.cOptGroupMsgFlag);
      }
    }
    if ((0x10 & l) == 16L) {
      localSvcRequestRegisterNew.regist = a();
    }
    if ((0x40 & l) == 64L)
    {
      localSvcRequestRegisterNew.c2cmsg = this.app.a().a();
      paramUniPacket.put("req_PbOffMsg", this.app.a().Q());
    }
    if (((0x4 & l) == 4L) || ((0x80 & l) == 128L))
    {
      localSvcRequestRegisterNew.groupmsg = this.app.a().a(i);
      if (localSvcRequestRegisterNew.groupmsg == null)
      {
        localSvcRequestRegisterNew.ulRequestOptional &= 0xFFFFFFFB;
        localSvcRequestRegisterNew.ulRequestOptional &= 0xFFFFFF7F;
      }
    }
    if (((0x8 & l) == 8L) || ((l & 0x100) == 256L))
    {
      if (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.infoLogin")) {
        break label444;
      }
      localSvcRequestRegisterNew.disgroupmsg = this.app.a().a();
    }
    for (;;)
    {
      if (i == 1) {
        localSvcRequestRegisterNew.cGroupMask = 2;
      }
      localSvcRequestRegisterNew.uEndSeq = j;
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxySvcPackService", 2, "requestMsgRegister , type = " + i + " isGetPassword = " + bool);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SvcRequestRegisterNew", 2, "cDisgroupMsgFilter:" + localSvcRequestRegisterNew.cDisgroupMsgFilter + ",NoticeEndSeq:" + j + " , ulRequestOptional : " + localSvcRequestRegisterNew.ulRequestOptional);
      }
      return localSvcRequestRegisterNew;
      label444:
      localSvcRequestRegisterNew.confmsg = this.app.a().a(i);
      if (localSvcRequestRegisterNew.confmsg == null)
      {
        localSvcRequestRegisterNew.ulRequestOptional &= 0xFFFFFFF7;
        localSvcRequestRegisterNew.ulRequestOptional &= 0xFFFFFEFF;
      }
    }
  }
  
  private SvcReqRegister a()
  {
    SvcReqRegister localSvcReqRegister = new SvcReqRegister();
    localSvcReqRegister.lUin = Long.parseLong(this.app.getCurrentAccountUin());
    localSvcReqRegister.lBid = 7L;
    localSvcReqRegister.cConnType = 0;
    AppRuntime.Status localStatus = this.app.getOnlineStatus();
    switch (amzw.mk[localStatus.ordinal()])
    {
    default: 
      if (!this.app.abj()) {
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      localSvcReqRegister.bKikPC = ((byte)i);
      localSvcReqRegister.bKikWeak = 0;
      localSvcReqRegister.timeStamp = this.app.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
      localSvcReqRegister.iLargeSeq = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).getInt("GetFrdListReq_seq", 0);
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
  
  private SvcRequestRegisterNew b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("requestOptional");
    int i = paramToServiceMsg.extraData.getInt("type");
    int j = paramToServiceMsg.extraData.getInt("endSeq");
    paramToServiceMsg = new SvcRequestRegisterNew();
    paramToServiceMsg.ulRequestOptional = l1;
    paramToServiceMsg.cDisgroupMsgFilter = 1;
    paramToServiceMsg.uEndSeq = j;
    long l2 = this.app.a().gS();
    if (l2 > 0L) {
      paramToServiceMsg.ulSyncTime = l2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterProxySvcPackService", 2, "requestNewRegister , type = " + i + " ,ulRequestOptional = " + paramToServiceMsg.ulRequestOptional + " ,cDisgroupMsgFilter = " + paramToServiceMsg.cDisgroupMsgFilter + " ,NoticeEndSeq = " + paramToServiceMsg.uEndSeq + " ,ulSyncTime = " + paramToServiceMsg.ulSyncTime);
    }
    if (i == 1) {
      paramToServiceMsg.cGroupMask = 2;
    }
    if (i == 3)
    {
      paramToServiceMsg.cOptGroupMsgFlag = 1;
      if (QLog.isColorLevel()) {
        QLog.d("SvcRequestRegisterNew", 2, "Type = " + i + ", req.cOptGroupMsgFlag = " + paramToServiceMsg.cOptGroupMsgFlag);
      }
    }
    if ((0x10 & l1) == 16L) {
      paramToServiceMsg.regist = a();
    }
    if ((l1 & 0x40) == 64L)
    {
      paramToServiceMsg.c2cmsg = this.app.a().a();
      paramUniPacket.put("req_PbOffMsg", this.app.a().a(false));
      paramUniPacket.put("req_PbPubMsg", this.app.a().a(true));
    }
    paramToServiceMsg.bytes_0x769_reqbody = MsfPullConfigUtil.pullConfigRequest(true);
    return paramToServiceMsg;
  }
  
  private Object e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRespParam)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRespParam", new SvcRespParam());
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("RegPrxySvc");
    paramToServiceMsg = new SvcRequestRegisterNew();
    paramToServiceMsg.ulRequestOptional |= 0x20;
    paramUniPacket.put("req_OffMsg", paramToServiceMsg);
    return true;
  }
  
  private Object f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterProxySvcPackService", 2, "decodeSvcResponseIpwdStat() ");
    }
    paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
    paramFromServiceMsg = (RespondHeader)decodePacket(paramToServiceMsg, "RespondHeader", new RespondHeader());
    paramToServiceMsg = (RespondQueryIPwdStat)decodePacket(paramToServiceMsg, "RespondQueryIPwdStat", new RespondQueryIPwdStat());
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = null;
    }
    while (paramFromServiceMsg.result == 0) {
      return paramToServiceMsg;
    }
    return null;
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new SvcRequestRegisterAndroid();
    paramToServiceMsg.ulRequestOptional = 1L;
    paramUniPacket.setServantName("RegisterProxySvcPack");
    paramUniPacket.setFuncName("OffLineMsg");
    paramUniPacket.put("req_OffMsg", paramToServiceMsg);
    return true;
  }
  
  private Object g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    SvcRespRegister localSvcRespRegister = null;
    if ((paramToServiceMsg.extraData.getLong("requestOptional", 0L) & 0x10) == 16L) {
      localSvcRespRegister = (SvcRespRegister)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
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
  
  private boolean g(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("RegPrxySvc");
    paramToServiceMsg = a(paramToServiceMsg, paramUniPacket);
    paramUniPacket.put("req_OffMsg", paramToServiceMsg);
    return paramToServiceMsg.ulRequestOptional != 0L;
  }
  
  private Object h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponsePullGroupMsgSeq)decodePacket(paramFromServiceMsg.getWupBuffer(), "resp_PullGroupMsgSeq", new SvcResponsePullGroupMsgSeq());
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
  
  private boolean h(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    boolean bool = true;
    paramUniPacket.setServantName("RegPrxySvc");
    SvcRequestRegisterNew localSvcRequestRegisterNew = b(paramToServiceMsg, paramUniPacket);
    paramUniPacket.put("req_OffMsg", localSvcRequestRegisterNew);
    paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    if (localSvcRequestRegisterNew.ulRequestOptional == 0L) {
      bool = false;
    }
    return bool;
  }
  
  private Object i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RegisterPushNotice)decodePacket(paramFromServiceMsg.getWupBuffer(), "RegisterPushNotice", new RegisterPushNotice());
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
  
  private Object j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponsePullDisMsgSeq)decodePacket(paramFromServiceMsg.getWupBuffer(), "resp_PullDisMsgSeq", new SvcResponsePullDisMsgSeq());
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
  
  private Object k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponsePullDisGroupSeq)decodePacket(paramFromServiceMsg.getWupBuffer(), "resp_PullDisGroupSeq", new SvcResponsePullDisGroupSeq());
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
  
  private Object l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcResponseGetMsgV2)decodePacket(paramFromServiceMsg.getWupBuffer(), "resp_GetMsgV2", new SvcResponseGetMsgV2());
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
          return e(paramToServiceMsg, paramFromServiceMsg);
        }
      } while ("RegPrxySvc.PbGetMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
      if ("RegPrxySvc.GetMsgV2".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
        return l(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("RegPrxySvc.PullGroupMsgSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
        return h(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("RegPrxySvc.PullDisMsgSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
        return j(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("RegPrxySvc.PullDisGroupSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
        return k(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("RegPrxySvc.infoLogin".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
        return g(paramToServiceMsg, paramFromServiceMsg);
      }
      if ("RegPrxySvc.NoticeEnd".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
        return i(paramToServiceMsg, paramFromServiceMsg);
      }
    } while (!"RegPrxySvc.QueryIpwdStat".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
    return f(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.infoAndroid")) {
      return f(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.infoLogin")) {
      return g(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.getOffMsg")) {
      return g(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.getExtinfo")) {
      return e(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.infoSync")) {
      return h(paramToServiceMsg, paramUniPacket);
    }
    return paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.PbSyncMsg");
  }
  
  public String[] y()
  {
    return ba;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amzv
 * JD-Core Version:    0.7.0.1
 */