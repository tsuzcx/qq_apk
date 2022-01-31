package com.tencent.mobileqq.msf.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.b.g;
import com.tencent.mobileqq.msf.core.b.g.b;
import com.tencent.mobileqq.msf.core.c.a;
import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.msf.sdk.m;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.msf.service.protocol.pb.WirelessMibao.CWirelessMibaoReq;
import com.tencent.msf.service.protocol.pb.WirelessPsw.CWirelessPswReq;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.MsfServiceBindInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class f
{
  private static String a = "MSF.S.ReqHandler";
  
  public static void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)paramLong);
  }
  
  void a(Context paramContext, ToServiceMsg paramToServiceMsg, int paramInt)
  {
    if (paramToServiceMsg == null) {}
    for (;;)
    {
      return;
      localObject1 = h.b(paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "recv " + (String)localObject1 + " req:" + paramToServiceMsg);
      }
      paramToServiceMsg.addAttribute("__timestamp_app2msf", Long.valueOf(System.currentTimeMillis()));
      if ((paramToServiceMsg.getServiceCmd().equals("RegPrxySvc.infoLogin")) && (!e.n))
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "get infoLogin, but not register push, register now");
        }
        localObject3 = paramContext.getPackageName();
        if (localObject3 == null) {
          break label607;
        }
        localObject2 = new ToServiceMsg("", paramToServiceMsg.getUin(), "push.register");
        ((ToServiceMsg)localObject2).setMsfCommand(MsfCommand.registerPush);
        ((ToServiceMsg)localObject2).setAppId(paramToServiceMsg.getAppId());
        ((ToServiceMsg)localObject2).setTimeout(30000L);
        MsfSdkUtils.addToMsgProcessName((String)localObject3, (ToServiceMsg)localObject2);
        localObject3 = (a)MsfService.core.pushManager.g.get(localObject3);
        if (localObject3 == null) {
          break label481;
        }
        m.a((ToServiceMsg)localObject2, ((a)localObject3).k);
        MsfService.core.pushManager.a((ToServiceMsg)localObject2, com.tencent.mobileqq.msf.core.c.j.g);
      }
      for (;;)
      {
        switch (1.a[paramToServiceMsg.getMsfCommand().ordinal()])
        {
        case 34: 
        default: 
          MsfService.core.sendSsoMsg(paramToServiceMsg);
          return;
          label481:
          QLog.d(a, 1, "AppPushInfo not find can not register");
          localObject3 = new PushRegisterInfo();
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(Long.valueOf(1L));
          localArrayList.add(Long.valueOf(2L));
          localArrayList.add(Long.valueOf(4L));
          ((PushRegisterInfo)localObject3).pushIds = localArrayList;
          ((PushRegisterInfo)localObject3).uin = paramToServiceMsg.getUin();
          ((PushRegisterInfo)localObject3).iStatus = 11;
          ((PushRegisterInfo)localObject3).bKikPC = 0;
          ((PushRegisterInfo)localObject3).bKikWeak = 0;
          ((PushRegisterInfo)localObject3).timeStamp = 0L;
          m.a((ToServiceMsg)localObject2, (PushRegisterInfo)localObject3);
          MsfService.core.pushManager.a((ToServiceMsg)localObject2, com.tencent.mobileqq.msf.core.c.j.h);
          continue;
          label607:
          QLog.d(a, 1, "qqprocessName not find can not register");
        }
      }
      paramContext = (MsfServiceBindInfo)paramToServiceMsg.getAttributes().get("intent_bindServiceInfo");
      d.a(paramContext.getProcessName(), paramContext.getBootBoradcastName(), paramContext.getMsfServiceCallbacker(), paramToServiceMsg.getAppId());
      MsfCore.initAppProMsg(h.b(paramToServiceMsg), paramToServiceMsg.getAppId());
      return;
      d.a((String)localObject1, ((Boolean)paramToServiceMsg.getAttribute("attr_be_guarded")).booleanValue(), ((Integer)paramToServiceMsg.getAttribute("attr_active_degree")).intValue(), ((Integer)paramToServiceMsg.getAttribute("attr_memory_cost")).intValue());
      return;
      paramContext = Boolean.valueOf(true);
      if (paramToServiceMsg.extraData.containsKey("to_stop_wake_process")) {
        paramContext = Boolean.valueOf(paramToServiceMsg.extraData.getBoolean("to_stop_wake_process"));
      }
      d.a((String)localObject1, paramContext);
      return;
      MsfService.core.login(paramToServiceMsg, 16, 0, new byte[0]);
      return;
      MsfService.core.ChangeUinLogin(paramToServiceMsg);
      return;
      MsfService.core.changeTokenAfterLogin(paramToServiceMsg, true);
      return;
      MsfService.core.syncDelAccount(paramToServiceMsg);
      paramContext = h.a(paramToServiceMsg);
      paramContext.addAttribute("resp_simpleAccount_uin", paramToServiceMsg.getUin());
      paramContext.setMsgSuccess();
      d.a((String)localObject1, paramToServiceMsg, paramContext);
      return;
      MsfService.core.submitVerifycode(paramToServiceMsg);
      return;
      MsfService.core.refreVerifycode(paramToServiceMsg);
      return;
      paramContext = paramToServiceMsg.getUin();
      if (!TextUtils.isEmpty(paramContext))
      {
        MsfService.core.refreshWebviewTickets(paramContext, "NotifyReLogin");
        return;
        MsfService.core.registerPush(paramToServiceMsg);
        return;
        MsfService.core.unRegisterPush(paramToServiceMsg);
        return;
        MsfService.core.registerCmdCall(paramToServiceMsg);
        return;
        MsfService.core.unRegisterCmdCall(paramToServiceMsg);
        return;
        paramContext = m.d(paramToServiceMsg);
        d.a(paramContext.d(), paramContext.e(), null, paramToServiceMsg.getAppId());
        MsfService.core.proxyRegister(paramContext, paramToServiceMsg);
        return;
        paramContext = (String)paramToServiceMsg.getAttribute(paramToServiceMsg.getServiceCmd());
        if (d.b(paramContext))
        {
          MsfService.core.proxyUnRegister(paramContext, paramToServiceMsg);
          return;
        }
        paramContext = h.a(paramToServiceMsg);
        paramContext.setBusinessFail(1011, "can not unregister by proxy.");
        d.a((String)localObject1, paramToServiceMsg, paramContext);
        return;
        MsfService.core.report(paramToServiceMsg);
        return;
        paramContext = MsfService.core.handleGetAccountKey(paramContext, paramToServiceMsg, paramInt);
        localObject2 = h.a(paramToServiceMsg);
        ((FromServiceMsg)localObject2).addAttribute(((FromServiceMsg)localObject2).getServiceCmd(), paramContext);
        ((FromServiceMsg)localObject2).setMsgSuccess();
        d.a((String)localObject1, paramToServiceMsg, (FromServiceMsg)localObject2);
        return;
        paramContext = paramToServiceMsg.getUin();
        paramContext = MsfService.core.getWtLoginCenter().c(paramContext);
        localObject2 = h.a(paramToServiceMsg);
        ((FromServiceMsg)localObject2).getAttributes().put("keyMap", paramContext);
        ((FromServiceMsg)localObject2).setMsgSuccess();
        d.a((String)localObject1, paramToServiceMsg, (FromServiceMsg)localObject2);
        return;
        paramContext = MsfService.core.syncGetServerConfig(paramToServiceMsg);
        localObject2 = h.a(paramToServiceMsg);
        ((FromServiceMsg)localObject2).addAttribute("to_getServerConfig_type", Integer.valueOf(((Integer)paramToServiceMsg.getAttributes().get("to_getServerConfig_type")).intValue()));
        ((FromServiceMsg)localObject2).addAttribute("to_getServerConfig_content", paramContext);
        ((FromServiceMsg)localObject2).setMsgSuccess();
        d.a((String)localObject1, paramToServiceMsg, (FromServiceMsg)localObject2);
        return;
        MsfService.core.getPluginConfig(paramToServiceMsg);
        return;
        MsfService.core.getWtLoginCenter().c(paramToServiceMsg);
        return;
        MsfService.core.getWtLoginCenter().d(paramToServiceMsg);
        return;
        MsfService.core.getWtLoginCenter().g(paramToServiceMsg);
        return;
        MsfService.core.getWtLoginCenter().e(paramToServiceMsg);
        return;
        MsfService.core.getWtLoginCenter().f(paramToServiceMsg);
        return;
        MsfService.core.getWtLoginCenter().h(paramToServiceMsg);
        return;
        MsfService.core.suspend();
        return;
        MsfService.core.resume();
        return;
        paramContext = (Object[])paramToServiceMsg.getAttributes().get("to_dataIncerment_app");
        com.tencent.mobileqq.msf.core.d.f.a(paramToServiceMsg.getUin(), (String[])paramContext[0], ((Long)paramContext[1]).longValue());
        return;
        paramContext = com.tencent.mobileqq.msf.core.d.f.a((String[])paramToServiceMsg.getAttributes().get(paramToServiceMsg.getServiceCmd()));
        localObject2 = h.a(paramToServiceMsg);
        ((FromServiceMsg)localObject2).addAttribute("__base_tag_curentDay", paramContext[0]);
        ((FromServiceMsg)localObject2).addAttribute("__base_tag_curentMonth", paramContext[1]);
        ((FromServiceMsg)localObject2).setMsgSuccess();
        d.a((String)localObject1, paramToServiceMsg, (FromServiceMsg)localObject2);
        return;
        paramContext = h.a(paramToServiceMsg);
        paramContext.addAttribute(paramToServiceMsg.getServiceCmd(), "dropped");
        paramContext.setMsgSuccess();
        d.a((String)localObject1, paramToServiceMsg, paramContext);
        return;
        paramContext = new JceInputStream((byte[])paramToServiceMsg.getAttribute(paramToServiceMsg.getServiceCmd()));
        paramToServiceMsg = new RdmReq();
        paramToServiceMsg.readFrom(paramContext);
        MsfService.core.getStatReporter().a(paramToServiceMsg.eventName, paramToServiceMsg.isSucceed, paramToServiceMsg.elapse, paramToServiceMsg.size, paramToServiceMsg.params, paramToServiceMsg.isRealTime, paramToServiceMsg.isMerge);
        return;
        paramContext = com.tencent.mobileqq.msf.core.l.l();
        localObject2 = h.a(paramToServiceMsg);
        ((FromServiceMsg)localObject2).addAttribute(paramToServiceMsg.getServiceCmd(), paramContext);
        ((FromServiceMsg)localObject2).setMsgSuccess();
        d.a((String)localObject1, paramToServiceMsg, (FromServiceMsg)localObject2);
        return;
        d.b((String)localObject1, paramToServiceMsg, h.a(paramToServiceMsg));
        return;
        paramInt = ((Integer)paramToServiceMsg.getAttribute("NetExceptionType")).intValue();
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.NetExceptionStat", 4, "get a NetExceptionStatistics event value:" + paramInt);
        }
        switch (paramInt)
        {
        default: 
          return;
        }
        g.a(g.b.a);
        return;
        paramInt = ((Integer)paramToServiceMsg.getAttribute("cmd")).intValue();
        paramContext = new WirelessPsw.CWirelessPswReq();
        paramContext.cmd.set(paramInt);
        paramContext.time.set((int)(System.currentTimeMillis() / 1000L));
        paramContext.uin.set(Long.parseLong(paramToServiceMsg.getUin()));
        try
        {
          localObject1 = InetAddress.getByName(com.tencent.mobileqq.msf.core.l.l());
          localObject2 = ((InetAddress)localObject1).getAddress();
          if ((localObject2.length > 4) || (localObject2.length <= 0))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(a, 2, "SEND_WIRELESS_PSWREQ inetAddress error :" + localObject1);
            return;
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        i = localObject2[0];
        j = localObject2[1];
        k = localObject2[2];
        m = localObject2[3];
        paramContext.ip.set(0x0 | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8 | m & 0xFF);
        localObject1 = MsfService.getCore().getAccountCenter().f();
        paramContext.ksid.set(ByteStringMicro.copyFrom((byte[])localObject1));
        localObject2 = paramContext.toByteArray();
        l = localObject2.length;
        localObject3 = new byte[(int)l + 4];
        a((byte[])localObject3, 0, 4L + l);
        System.arraycopy(localObject2, 0, localObject3, 4, (int)l);
        paramToServiceMsg.putWupBuffer((byte[])localObject3);
        if (QLog.isDevelopLevel()) {
          QLog.d(a, 4, "WIRELESS_PSWREQ cmd:" + paramInt + " time:" + paramContext.time.get() + " uin:" + paramContext.uin.get() + " ip:" + paramContext.ip.get() + " ksid:" + localObject1);
        }
        MsfService.core.sendSsoMsg(paramToServiceMsg);
        return;
        paramInt = ((Integer)paramToServiceMsg.getAttribute("cmd")).intValue();
        paramContext = new WirelessMibao.CWirelessMibaoReq();
        paramContext.cmd.set(paramInt);
        paramContext.time.set((int)(System.currentTimeMillis() / 1000L));
        paramContext.uin.set(Long.parseLong(paramToServiceMsg.getUin()));
        try
        {
          localObject1 = InetAddress.getByName(com.tencent.mobileqq.msf.core.l.l());
          localObject2 = ((InetAddress)localObject1).getAddress();
          if ((localObject2.length > 4) || (localObject2.length <= 0))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(a, 2, "SEND_WIRELESS_PSWREQ inetAddress error :" + localObject1);
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
      }
    }
    int i = localObject2[0];
    int j = localObject2[1];
    int k = localObject2[2];
    int m = localObject2[3];
    paramContext.ip.set(0x0 | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8 | m & 0xFF);
    Object localObject1 = MsfService.getCore().getAccountCenter().f();
    paramContext.ksid.set(ByteStringMicro.copyFrom((byte[])localObject1));
    paramContext.imei.set(com.tencent.mobileqq.msf.core.j.d());
    paramContext.guid.set(ByteStringMicro.copyFrom(com.tencent.mobileqq.msf.core.auth.h.a()));
    Object localObject2 = paramContext.toByteArray();
    long l = localObject2.length;
    Object localObject3 = new byte[(int)l + 4];
    a((byte[])localObject3, 0, 4L + l);
    System.arraycopy(localObject2, 0, localObject3, 4, (int)l);
    paramToServiceMsg.putWupBuffer((byte[])localObject3);
    if (QLog.isDevelopLevel()) {
      QLog.d(a, 4, "WIRELESS_MEIBAOREQ cmd:" + paramInt + " time:" + paramContext.time.get() + " uin:" + paramContext.uin.get() + " ip:" + paramContext.ip.get() + " ksid:" + localObject1);
    }
    MsfService.core.sendSsoMsg(paramToServiceMsg);
    return;
    MsfService.core.wt_GetStWithPasswd(paramToServiceMsg);
    return;
    MsfService.core.wt_GetStWithoutPasswd(paramToServiceMsg);
    return;
    MsfService.core.wt_CheckPictureAndGetSt(paramToServiceMsg);
    return;
    MsfService.core.wt_RefreshPictureData(paramToServiceMsg);
    return;
    MsfService.core.wt_VerifyCode(paramToServiceMsg);
    return;
    MsfService.core.wt_CloseCode(paramToServiceMsg);
    return;
    MsfService.core.wt_GetA1WithA1(paramToServiceMsg);
    return;
    MsfService.core.wt_CheckDevLockStatus(paramToServiceMsg);
    return;
    MsfService.core.wt_AskDevLockSms(paramToServiceMsg);
    return;
    MsfService.core.wt_CheckDevLockSms(paramToServiceMsg);
    return;
    MsfService.core.wt_CloseDevLock(paramToServiceMsg);
    return;
    MsfService.core.wt_setRegDevLockFlag(paramToServiceMsg);
    return;
    MsfService.core.wt_RefreshSMSData(paramToServiceMsg);
    return;
    MsfService.core.wt_CheckSMSAndGetSt(paramToServiceMsg);
    return;
    MsfService.core.wt_CheckSMSAndGetStExt(paramToServiceMsg);
    return;
    MsfService.core.wt_RegGetSMSVerifyLoginAccount(paramToServiceMsg);
    return;
    MsfService.core.wt_CheckSMSVerifyLoginAccount(paramToServiceMsg);
    return;
    MsfService.core.wt_RefreshSMSVerifyLoginCode(paramToServiceMsg);
    return;
    MsfService.core.wt_VerifySMSVerifyLoginCode(paramToServiceMsg);
    return;
    MsfService.core.wt_GetStViaSMSVerifyLogin(paramToServiceMsg);
    return;
    MsfService.core.sendSsoMsg(paramToServiceMsg);
    paramContext = String.valueOf(paramToServiceMsg.getAttribute("stype", Integer.valueOf(0)));
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("MsgType", paramToServiceMsg.toString());
    ((HashMap)localObject1).put("SharpType", paramContext);
    MsfService.core.getStatReporter().a("dim.Msf.RecvVideoS2CACK", false, 0L, 0L, (Map)localObject1, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.f
 * JD-Core Version:    0.7.0.1
 */