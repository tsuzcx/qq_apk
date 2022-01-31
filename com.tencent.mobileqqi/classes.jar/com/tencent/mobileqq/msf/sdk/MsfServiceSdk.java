package com.tencent.mobileqq.msf.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.msf.sdk.utils.a;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class MsfServiceSdk
  extends j
{
  private static MsfServiceSdk sdk = new MsfServiceSdk();
  private static final String tag = "MsfServiceSdk";
  private volatile boolean initFinished = false;
  g proxy;
  
  private void beforeSend(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    paramToServiceMsg.setAppId(this.appid);
    paramToServiceMsg.setTimeout(30000L);
    MsfSdkUtils.addToMsgProcessName(this.processName, paramToServiceMsg);
  }
  
  public static MsfServiceSdk get()
  {
    return sdk;
  }
  
  public void bindBaseService()
  {
    this.proxy.b();
  }
  
  public ToServiceMsg getA1WithA1(String paramString)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "login.auth");
    paramString.setMsfCommand(MsfCommand.wt_GetA1WithA1);
    paramString.getAttributes().put("dwSrcAppid", Long.valueOf(16L));
    paramString.getAttributes().put("dwSubSrcAppid", Long.valueOf(16L));
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getChangeTokenAfterLoginMsg(String paramString, int paramInt, HashMap paramHashMap)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "login.chgTok");
    paramString.setMsfCommand(MsfCommand.changeToken);
    paramString.getAttributes().put("to_login_token_cmdhead", Integer.valueOf(paramInt));
    paramString.getAttributes().put("to_login_token_map", paramHashMap);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getChangeUinAndLoginMsg(String paramString, byte[] paramArrayOfByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), paramString, "login.auth");
    localToServiceMsg.setMsfCommand(MsfCommand.changeUinLogin);
    localToServiceMsg.getAttributes().put("to_login_pwd", paramArrayOfByte);
    localToServiceMsg.getAttributes().put("to_login_changeuin", paramString);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getCheckSMSAndGetStMsg(String paramString, byte[] paramArrayOfByte)
  {
    paramString = new ToServiceMsg(this.msfServiceName, paramString, "cmd_appUseWtLogin");
    paramString.setMsfCommand(MsfCommand.wt_CheckSMSAndGetSt);
    paramString.getAttributes().put("userInput", paramArrayOfByte);
    paramString.setTimeout(30000L);
    return paramString;
  }
  
  public ToServiceMsg getDataFlowMsg(String paramString, a parama)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "socketnetflow");
    localToServiceMsg.setMsfCommand(MsfCommand.reportSocket);
    localToServiceMsg.extraData.putString("processName", paramString);
    localToServiceMsg.extraData.putString("ip", parama.b);
    localToServiceMsg.extraData.putString("refer", parama.c);
    localToServiceMsg.extraData.putInt("port", parama.d);
    localToServiceMsg.extraData.putInt("flag", parama.e);
    localToServiceMsg.extraData.putLong("buffersize", parama.f);
    localToServiceMsg.extraData.putInt("networktype", parama.g);
    localToServiceMsg.extraData.putString("mType", parama.h);
    localToServiceMsg.setNeedCallback(false);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getDelLoginedAccount(String paramString1, String paramString2)
  {
    paramString1 = new ToServiceMsg(getMsfServiceName(), paramString1, "cmd_DelLoginedAccount");
    paramString1.setMsfCommand(MsfCommand.delLoginedAccount);
    paramString1.getAttributes().put(paramString1.getServiceCmd(), paramString2);
    beforeSend(paramString1);
    return paramString1;
  }
  
  public ToServiceMsg getKeyMsg(String paramString)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "MSF.getKey");
    paramString.setMsfCommand(MsfCommand.getKey);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getLoginMsg(String paramString, byte[] paramArrayOfByte)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "login.auth");
    paramString.setMsfCommand(MsfCommand.loginAuth);
    paramString.getAttributes().put("to_login_pwd", paramArrayOfByte);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getLoginWithoutPasswdMsg(String paramString)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "login.auth");
    paramString.setMsfCommand(MsfCommand.wt_GetStWithoutPasswd);
    paramString.getAttributes().put("dwSrcAppid", Long.valueOf(16L));
    paramString.getAttributes().put("dwDstAppid", Long.valueOf(16L));
    beforeSend(paramString);
    return paramString;
  }
  
  public String getMsfServiceName()
  {
    if (this.initFinished == true) {
      return this.proxy.a.msfServiceName;
    }
    this.proxy = new g("com.tencent.mobileqq.msf.service.MsfService");
    this.proxy.a(this);
    this.initFinished = true;
    this.appid = 88886666;
    return this.proxy.a.msfServiceName;
  }
  
  public ToServiceMsg getPluginConfigMsg(String paramString)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "ConfigService.ClientReq");
    paramString.setMsfCommand(MsfCommand.getPluginConfig);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getRefreVerifyCodeMsg(VerifyCodeInfo paramVerifyCodeInfo)
  {
    if (paramVerifyCodeInfo == null)
    {
      QLog.w("MsfServiceSdk", 1, "getRefreVerifyCodeMsg info null!");
      return null;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), paramVerifyCodeInfo.uin, "login.auth");
    localToServiceMsg.setMsfCommand(MsfCommand.refreVerifyCode);
    VerifyCodeInfo.putVerifyCodeInfo(localToServiceMsg, paramVerifyCodeInfo);
    localToServiceMsg.setRequestSsoSeq(paramVerifyCodeInfo.ssoSeq);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRefreshDevLockSmsMsg(String paramString)
  {
    paramString = new ToServiceMsg(this.msfServiceName, paramString, "cmd_appUseWtLogin");
    paramString.setMsfCommand(MsfCommand.wt_RefreshSMSData);
    paramString.getAttributes().put("smsAppid", Long.valueOf(9L));
    paramString.setTimeout(30000L);
    return paramString;
  }
  
  public ToServiceMsg getRefreshTicketsMsg(String paramString)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "cmd_refreshTickets");
    paramString.setMsfCommand(MsfCommand.refreshTickets);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getRegQueryAccountMsg(String paramString)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.getAttributes().put("to_register_cr_mobile", paramString);
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_queryMobile);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterCmdCallMsg(CommandCallbackerInfo paramCommandCallbackerInfo)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), paramCommandCallbackerInfo.uin, "push.cmdRegister");
    localToServiceMsg.setMsfCommand(MsfCommand.registerCmdCallback);
    m.a(localToServiceMsg, paramCommandCallbackerInfo);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterCommitMobileMsg(byte paramByte1, byte paramByte2, byte paramByte3, String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_commitMobile);
    localToServiceMsg.getAttributes().put("to_register_cr_country", Byte.valueOf(paramByte1));
    localToServiceMsg.getAttributes().put("to_register_cr_language", Byte.valueOf(paramByte2));
    localToServiceMsg.getAttributes().put("to_register_cr_pigType", Byte.valueOf(paramByte3));
    localToServiceMsg.getAttributes().put("to_register_cr_appName", paramString1);
    localToServiceMsg.getAttributes().put("to_register_cr_appVersion", paramString2);
    localToServiceMsg.getAttributes().put("to_register_cr_mobile", paramString3);
    localToServiceMsg.getAttributes().put("appid", paramLong);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterCommitPassMsg(String paramString1, String paramString2, String paramString3)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_commitPass);
    localToServiceMsg.getAttributes().put("To_register_smsCode", paramString1);
    localToServiceMsg.getAttributes().put("To_register_pass", paramString2);
    localToServiceMsg.getAttributes().put("To_register_nick", paramString3);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterCommitSmsCodeMsg(String paramString)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_commitSmsCode);
    localToServiceMsg.getAttributes().put("To_register_smsCode", paramString);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterProxyMsg(int paramInt, String paramString1, String paramString2, String paramString3, NotifyRegisterInfo paramNotifyRegisterInfo, CommandCallbackerInfo paramCommandCallbackerInfo)
  {
    paramString1 = new ToServiceMsg(getMsfServiceName(), paramString1, "push.proxyRegister");
    paramString1.setMsfCommand(MsfCommand.proxyRegisterPush);
    l locall = new l();
    locall.a = paramInt;
    locall.b = paramString2;
    locall.c = paramString3;
    locall.d = paramNotifyRegisterInfo;
    locall.e = paramCommandCallbackerInfo;
    m.a(paramString1, locall);
    beforeSend(paramString1);
    return paramString1;
  }
  
  public ToServiceMsg getRegisterPushMsg(PushRegisterInfo paramPushRegisterInfo)
  {
    if (paramPushRegisterInfo == null)
    {
      QLog.w("MsfServiceSdk", 1, "getRegisterPushMsg pushRegisterInfo null!");
      return null;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), paramPushRegisterInfo.uin, "push.register");
    localToServiceMsg.setMsfCommand(MsfCommand.registerPush);
    m.a(localToServiceMsg, paramPushRegisterInfo);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterQueryUpSmsStatMsg()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_querySmsStat);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterSendReSendSmsMsg()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_reSendSms);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getReportMsg(byte paramByte, String paramString)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "ConfigService.ClientReq");
    localToServiceMsg.setMsfCommand(MsfCommand.reportMsg);
    localToServiceMsg.getAttributes().put("to_report_type", Byte.valueOf(paramByte));
    localToServiceMsg.getAttributes().put("to_report_content", paramString);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getReportTrafficeMsg4Highway(Intent paramIntent)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "socketnetflow");
    localToServiceMsg.setMsfCommand(MsfCommand.reportSocket);
    localToServiceMsg.extraData.putString("ip", paramIntent.getStringExtra("ip"));
    localToServiceMsg.extraData.putString("processName", "com.tencent.mobileqqi");
    localToServiceMsg.extraData.putString("refer", null);
    localToServiceMsg.extraData.putInt("port", paramIntent.getIntExtra("port", 0));
    localToServiceMsg.extraData.putString("mType", paramIntent.getStringExtra("mType"));
    localToServiceMsg.extraData.putInt("flag", paramIntent.getIntExtra("flag", 0));
    localToServiceMsg.extraData.putLong("buffersize", paramIntent.getLongExtra("buffersize", -1L));
    localToServiceMsg.extraData.putInt("networktype", paramIntent.getIntExtra("networktype", 1));
    localToServiceMsg.setNeedCallback(false);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getResetCmdCallMsg(String paramString, CommandCallbackerInfo paramCommandCallbackerInfo)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "push.resetCmds");
    paramString.setMsfCommand(MsfCommand.resetCmdCallback);
    m.a(paramString, paramCommandCallbackerInfo);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getResumedMsg()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "Msf.SetResume");
    localToServiceMsg.setMsfCommand(MsfCommand._setMsfResunmed);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getSubmitVerifyCodeMsg(String paramString, VerifyCodeInfo paramVerifyCodeInfo)
  {
    if (paramVerifyCodeInfo == null)
    {
      QLog.w("MsfServiceSdk", 1, "getSubmitVerifyCodeMsg info null!");
      return null;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), paramVerifyCodeInfo.uin, "login.auth");
    localToServiceMsg.setMsfCommand(MsfCommand.submitVerifyCode);
    VerifyCodeInfo.putVerifyCodeInfo(localToServiceMsg, paramVerifyCodeInfo);
    localToServiceMsg.getAttributes().put("to_verify_code", paramString);
    localToServiceMsg.setRequestSsoSeq(paramVerifyCodeInfo.ssoSeq);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getSuspendMsg()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "Msf.SetSuspend");
    localToServiceMsg.setMsfCommand(MsfCommand._setMsfSuspend);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getUnRegisterProxyMsg(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = new ToServiceMsg(getMsfServiceName(), paramString1, "push.proxyUnRegister");
    paramString1.setMsfCommand(MsfCommand.proxyUnRegisterPush);
    paramString1.getAttributes().put(paramString1.getServiceCmd(), paramString2);
    beforeSend(paramString1);
    return paramString1;
  }
  
  public ToServiceMsg getUnRegisterPushMsg(PushRegisterInfo paramPushRegisterInfo)
  {
    if (paramPushRegisterInfo == null)
    {
      QLog.w("MsfServiceSdk", 1, "getUnRegisterPushMsg pushRegisterInfo null!");
      return null;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), paramPushRegisterInfo.uin, "push.unRegister");
    localToServiceMsg.setMsfCommand(MsfCommand.unRegisterPush);
    m.a(localToServiceMsg, paramPushRegisterInfo);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public void init(Context paramContext, int paramInt, String paramString1, String paramString2, IErrorHandler paramIErrorHandler)
  {
    this.proxy = new g(paramString2);
    paramContext = MsfSdkUtils.getProcessName(paramContext);
    this.proxy.a(this);
    super.initSub(paramContext, paramInt, paramString1, paramIErrorHandler);
    this.initFinished = true;
  }
  
  public void initMsfService()
  {
    this.proxy.a();
    this.proxy.b();
  }
  
  public void registerMsfService()
  {
    this.proxy.f();
  }
  
  public int sendMsg(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    if (paramToServiceMsg.getServiceName().equals(getMsfServiceName())) {
      return this.proxy.b(paramToServiceMsg);
    }
    return d.a(paramToServiceMsg);
  }
  
  public void sendStartUseAccountBroadcast(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      QLog.w("MsfServiceSdk", 1, "sendStartUseAccountBroadcast context null!");
    }
    do
    {
      return;
      Intent localIntent = new Intent("com.tencent.mobileqq.usersync");
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("action", "enter");
      paramContext.sendBroadcast(localIntent);
    } while (!QLog.isColorLevel());
    QLog.d("MsfServiceSdk", 2, "send bootAction user " + paramString + " enter broadcast");
  }
  
  public void sendstopUseAccountBroadcast(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      QLog.w("MsfServiceSdk", 1, "sendstopUseAccountBroadcast context null!");
    }
    do
    {
      return;
      Intent localIntent = new Intent("com.tencent.mobileqq.usersync");
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("action", "exit");
      paramContext.sendBroadcast(localIntent);
    } while (!QLog.isColorLevel());
    QLog.d("MsfServiceSdk", 2, "send bootAction user " + paramString + " exit broadcast");
  }
  
  public void startBaseService()
  {
    this.proxy.a();
  }
  
  public void stopMsfService()
  {
    this.proxy.c();
  }
  
  public ArrayList syncGetLoginedAccountList()
  {
    return MsfSdkUtils.getLoginedAccountList();
  }
  
  public int syncGetNetInfo()
  {
    return AppNetConnInfo.getConnInfo();
  }
  
  public String syncGetServerAppConfig()
  {
    return syncGetServerConfig("0", 2);
  }
  
  public String syncGetServerCommonConfig()
  {
    return syncGetServerConfig("0", 0);
  }
  
  public String syncGetServerConfig(String paramString, int paramInt)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "cmd_getServerConfig");
    paramString.setMsfCommand(MsfCommand.getServerConfig);
    paramString.getAttributes().put("to_getServerConfig_type", Integer.valueOf(paramInt));
    beforeSend(paramString);
    sendMsg(paramString);
    return MsfSdkUtils.getServerConfig(this.processName, paramInt);
  }
  
  public String syncGetServerUserConfig(String paramString)
  {
    return syncGetServerConfig(paramString, 1);
  }
  
  public void unRegisterMsfService()
  {
    this.proxy.a(Boolean.valueOf(true));
  }
  
  public void unRegisterMsfService(Boolean paramBoolean)
  {
    this.proxy.a(paramBoolean);
  }
  
  public void unbindMsfService()
  {
    this.proxy.e();
    this.proxy.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.MsfServiceSdk
 * JD-Core Version:    0.7.0.1
 */