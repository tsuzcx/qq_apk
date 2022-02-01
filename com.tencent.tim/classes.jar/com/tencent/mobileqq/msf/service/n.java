package com.tencent.mobileqq.msf.service;

import android.os.Binder;
import android.os.Process;
import android.os.RemoteException;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ak;
import com.tencent.mobileqq.msf.core.i;
import com.tencent.mobileqq.msf.core.net.c.a;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseService.Stub;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class n
  extends IBaseService.Stub
{
  n(MsfService paramMsfService) {}
  
  public int getMsfConnectedIPFamily()
  {
    try
    {
      int i = MsfService.core.sender.b.f();
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public int getMsfConnectedNetType()
  {
    try
    {
      int i = MsfService.core.sender.b.e();
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public int onKillProcess()
  {
    Process.killProcess(Process.myPid());
    return 0;
  }
  
  public int onProcessViewableChanged(boolean paramBoolean, long paramLong, String paramString)
  {
    try
    {
      a locala = MsfService.core.getDeepSleepDetector();
      if (locala != null) {
        locala.a(paramBoolean, paramLong, paramString);
      }
    }
    catch (Exception paramString)
    {
      label22:
      break label22;
    }
    return 0;
  }
  
  public FromServiceMsg sendSyncToServiceMsg(ToServiceMsg paramToServiceMsg)
    throws RemoteException
  {
    return null;
  }
  
  public int sendToServiceMsg(ToServiceMsg paramToServiceMsg)
    throws RemoteException
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MSF.S.MsfService", 2, "sendToServiceMsg toServiceMsg null!");
      }
      return -1;
    }
    int i = MsfCore.getNextSeq();
    if (paramToServiceMsg.getRequestSsoSeq() == -1) {
      paramToServiceMsg.setRequestSsoSeq(i);
    }
    if (paramToServiceMsg.getTimeout() == -1L) {
      paramToServiceMsg.setTimeout(30000L);
    }
    if (MsfService.core.getMsfAppid() == -1) {
      MsfService.core.setMsfAppid(paramToServiceMsg.getAppId());
    }
    try
    {
      int j = Binder.getCallingUid();
      paramToServiceMsg.addAttribute("__base_tag_isAppMsg", Boolean.valueOf(true));
      if (paramToServiceMsg.getServiceCmd().startsWith("cmd_sync_syncuser"))
      {
        this.a.handleAccountSyncRequest(this.a, paramToServiceMsg, j);
      }
      else
      {
        i.a();
        if (MsfService.isSamePackage(this.a, j, paramToServiceMsg.getServiceCmd())) {
          MsfService.msfServiceReqHandler.a(this.a, paramToServiceMsg, j);
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w("MSF.S.MsfService", 1, "service handle msg error " + paramToServiceMsg, paramToServiceMsg);
    }
    return -2;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.n
 * JD-Core Version:    0.7.0.1
 */