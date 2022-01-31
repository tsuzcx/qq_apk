package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class i
{
  static final String b = "MSF.C.NetConnTag";
  MsfCore a;
  private volatile Handler c;
  
  public i(MsfCore paramMsfCore)
  {
    this.a = paramMsfCore;
  }
  
  public Runnable a(com.tencent.mobileqq.msf.core.b.i parami, long paramLong)
  {
    if (parami != null)
    {
      parami = new b(parami);
      this.c.postDelayed(parami, paramLong);
      return parami;
    }
    return null;
  }
  
  public Runnable a(ToServiceMsg paramToServiceMsg, long paramLong)
  {
    a locala = new a(paramToServiceMsg);
    if (paramToServiceMsg != null) {
      this.c.postDelayed(locala, paramLong);
    }
    return locala;
  }
  
  public void a()
  {
    HandlerThread localHandlerThread = new HandlerThread("MsfCoreTimeoutChecker", 5);
    localHandlerThread.start();
    this.c = new Handler(localHandlerThread.getLooper());
  }
  
  public void a(Runnable paramRunnable)
  {
    this.c.removeCallbacks(paramRunnable);
  }
  
  public Handler b()
  {
    return this.c;
  }
  
  class a
    implements Runnable
  {
    private ToServiceMsg b;
    
    public a(ToServiceMsg paramToServiceMsg)
    {
      this.b = paramToServiceMsg;
    }
    
    public void run()
    {
      if (this.b == null) {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "req null, return.");
        }
      }
      for (;;)
      {
        return;
        try
        {
          if ((ToServiceMsg)i.this.a.sender.e().get(Integer.valueOf(this.b.getRequestSsoSeq())) != null)
          {
            ToServiceMsg localToServiceMsg = (ToServiceMsg)i.this.a.sender.e().remove(Integer.valueOf(this.b.getRequestSsoSeq()));
            if (localToServiceMsg == null)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("MSF.C.NetConnTag", 2, "timeout msg " + localToServiceMsg + " also received resp, return.");
            }
          }
        }
        catch (Exception localException1)
        {
          QLog.d("MSF.C.NetConnTag", 1, "got fail msg. " + localException1, localException1);
          return;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + localException1.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(localException1.getUin()) + " cmd:" + localException1.getServiceCmd() + " len:" + 0 + " costTime:" + localException1.getTimeout() + NetConnInfoCenter.getSignalStrengthsLog() + " code:" + 1002 + " failMsg:" + "wait serverResp timeout");
      }
      for (;;)
      {
        FromServiceMsg localFromServiceMsg = j.a(localException1);
        localFromServiceMsg.setBusinessFail(1002, "wait serverResp timeout");
        boolean bool = i.this.a.sender.a(localException1, localFromServiceMsg);
        if (!bool) {
          break;
        }
        try
        {
          i.this.a.getSsoRespHandler().a(localException1, localFromServiceMsg);
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          return;
        }
        QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + localException2.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(localException2.getUin()) + " cmd:" + localException2.getServiceCmd().hashCode() + " len:" + 0 + " costTime:" + localException2.getTimeout() + NetConnInfoCenter.getSignalStrengthsLog() + " code:" + 1002 + " failMsg:" + "wait serverResp timeout");
      }
    }
  }
  
  class b
    implements Runnable
  {
    private com.tencent.mobileqq.msf.core.b.i b;
    
    public b(com.tencent.mobileqq.msf.core.b.i parami)
    {
      this.b = parami;
    }
    
    public void run()
    {
      if (this.b != null) {}
      try
      {
        this.b.d();
        return;
      }
      catch (Exception localException)
      {
        QLog.d("MSF.C.NetConnTag", 1, "call loginConnectTimeOut error " + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.i
 * JD-Core Version:    0.7.0.1
 */