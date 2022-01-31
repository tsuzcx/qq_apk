package com.tencent.mobileqq.msf.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseService;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.MsfServiceBindInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

class g
  extends s
{
  private static final String n = "MSF.D.Proxy";
  MsfServiceSdk a;
  protected volatile boolean b = false;
  IMsfServiceCallbacker c = new h(this);
  
  public g(String paramString)
  {
    super(paramString);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.Proxy", 2, " onRecvPushResp " + paramFromServiceMsg);
    }
    if (!b(null, paramFromServiceMsg))
    {
      if (paramFromServiceMsg.getMsfCommand() != MsfCommand.pushSetConfig) {
        break label113;
      }
      n.b(((Integer)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd())).intValue());
      com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = ((Integer)paramFromServiceMsg.getAttribute("_attr_socket_connstate")).intValue();
      com.tencent.mobileqq.msf.core.NetConnInfoCenter.servetTimeSecondInterv = ((Long)paramFromServiceMsg.getAttribute("_attr_server")).longValue();
      com.tencent.mobileqq.msf.core.NetConnInfoCenter.GUID = (byte[])paramFromServiceMsg.getAttribute("_attr_deviceGUID");
    }
    label113:
    do
    {
      return;
      if (this.b)
      {
        this.a.addServicePushMsg(paramFromServiceMsg);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.D.Proxy", 2, " close msfServiceConn. push msg is droped." + paramFromServiceMsg);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((ToServiceMsg)g.remove(Integer.valueOf(paramToServiceMsg.getAppSeq())) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.Proxy", 2, " onResponse " + paramToServiceMsg.getRequestSsoSeq() + " " + paramFromServiceMsg);
      }
      if (!b(paramToServiceMsg, paramFromServiceMsg))
      {
        if (!this.b) {
          break label136;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.D.Proxy", 2, "add queue req:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
        }
      }
    }
    label136:
    while (!QLog.isColorLevel())
    {
      this.a.addServiceRespMsg(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("MSF.D.Proxy", 2, " close msfServiceConn. msg is droped." + paramToServiceMsg.getRequestSsoSeq() + " " + paramFromServiceMsg);
      return;
    }
    QLog.d("MSF.D.Proxy", 2, " found timeout resp to:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
  }
  
  protected int a(ToServiceMsg paramToServiceMsg)
    throws RemoteException
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    paramToServiceMsg.setAppId(this.a.appid);
    paramToServiceMsg.getAttributes().put("to_SendTime", Long.valueOf(System.currentTimeMillis()));
    paramToServiceMsg.getAttributes().put("to_SenderProcessName", this.a.processName);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.Proxy", 2, " send req to msfService:" + paramToServiceMsg);
    }
    return this.d.sendToServiceMsg(paramToServiceMsg);
  }
  
  public int a(Boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(this.a.msfServiceName, "0", "cmd_UnRegisterMsfService");
    localToServiceMsg.setMsfCommand(MsfCommand.unRegisterMsfService);
    localToServiceMsg.extraData.putBoolean("to_stop_wake_process", paramBoolean.booleanValue());
    this.b = false;
    return b(localToServiceMsg);
  }
  
  void a()
  {
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.a.msfServiceName);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      localIntent.putExtra("to_SenderProcessName", this.a.processName);
      BaseApplication.getContext().startService(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.Proxy", 2, "start service finish");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(MsfServiceSdk paramMsfServiceSdk)
  {
    this.a = paramMsfServiceSdk;
    paramMsfServiceSdk.msfServiceName = this.l;
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  boolean b()
  {
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.a.msfServiceName);
      Intent localIntent = new Intent();
      localIntent.putExtra("to_SenderProcessName", this.a.processName);
      localIntent.setComponent(localComponentName);
      bool = BaseApplication.getContext().bindService(localIntent, this.m, 1);
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.D.Proxy", 2, "threadID:" + Thread.currentThread().getId() + " bind " + this.a.msfServiceName + " service finished " + bool);
        }
        return bool;
      }
      catch (Exception localException2)
      {
        boolean bool;
        break label130;
      }
      localException1 = localException1;
      bool = false;
    }
    label130:
    return bool;
  }
  
  public boolean b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramFromServiceMsg.getBusinessFailCode();
    if (paramFromServiceMsg.getAttributes().containsKey("_attr_sameDevice")) {}
    for (boolean bool = ((Boolean)paramFromServiceMsg.getAttribute("_attr_sameDevice")).booleanValue();; bool = false)
    {
      switch (i)
      {
      case 2002: 
      case 2003: 
      case 2004: 
      case 2005: 
      case 2006: 
      case 2007: 
      case 2010: 
      default: 
        return false;
      case 2001: 
        QLog.d("MSF.D.Proxy", 1, "BaseConstants.CODE_NO_LOGIN " + paramFromServiceMsg.hashCode());
        this.a.errorHandler.onUserTokenExpired(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2011: 
        this.a.errorHandler.onRecvServerTip(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2012: 
        this.a.errorHandler.onKickedAndClearToken(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2013: 
        this.a.errorHandler.onKicked(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2009: 
        this.a.errorHandler.onServerSuspended(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2008: 
        this.a.errorHandler.onGrayError(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      }
      this.a.errorHandler.onInvalidSign(bool);
      return true;
    }
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.Proxy", 2, "add fail queue req:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
    }
    this.a.addServiceRespMsg(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
  }
  
  public boolean c()
  {
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.a.msfServiceName);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      localIntent.putExtra("to_SenderProcessName", this.a.processName);
      boolean bool = BaseApplication.getContext().stopService(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.Proxy", 2, " stopService service finished " + bool);
      }
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  protected void d()
  {
    int i = f();
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.Proxy", 2, " registerMsfService result:" + i);
    }
    i locali = new i(this);
    locali.setName("handleWaitSendProxyMsgThread");
    locali.start();
  }
  
  public void e()
  {
    while (!f.isEmpty())
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)f.poll();
      if (localToServiceMsg != null) {
        try
        {
          a(localToServiceMsg);
        }
        catch (Exception localException)
        {
          c(localToServiceMsg, a(localToServiceMsg, localToServiceMsg.getServiceName() + "sendMsgToServiceFailed，" + localException.toString()));
        }
      }
    }
  }
  
  public int f()
  {
    if ((this.a.processName == null) || (this.a.processName.endsWith("picture"))) {
      return -1;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg(this.a.msfServiceName, "0", "cmd_RegisterMsfService");
    localToServiceMsg.setMsfCommand(MsfCommand.registerMsfService);
    MsfServiceBindInfo localMsfServiceBindInfo = new MsfServiceBindInfo(this.a.appid, this.a.processName, this.a.getBootBroadcastName(), this.c);
    localToServiceMsg.getAttributes().put("intent_bindServiceInfo", localMsfServiceBindInfo);
    localToServiceMsg.setNeedCallback(false);
    this.b = true;
    return b(localToServiceMsg);
  }
  
  public void g()
  {
    super.g();
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.g
 * JD-Core Version:    0.7.0.1
 */