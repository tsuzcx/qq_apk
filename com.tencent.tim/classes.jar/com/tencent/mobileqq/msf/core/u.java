package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.msf.core.b.c;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class u
{
  static final String b = "MSF.C.NetConnTag";
  MsfCore a;
  private volatile Handler c;
  
  public u(MsfCore paramMsfCore)
  {
    this.a = paramMsfCore;
  }
  
  public Runnable a(int paramInt, long paramLong)
  {
    a locala = new a(paramInt);
    this.c.postDelayed(locala, paramLong);
    return locala;
  }
  
  public Runnable a(n paramn, long paramLong)
  {
    if (paramn != null)
    {
      paramn = new e(paramn);
      this.c.postDelayed(paramn, paramLong);
      return paramn;
    }
    return null;
  }
  
  public Runnable a(ToServiceMsg paramToServiceMsg, long paramLong)
  {
    d locald = new d(paramToServiceMsg);
    if (paramToServiceMsg != null) {
      this.c.postDelayed(locald, paramLong);
    }
    return locald;
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
  
  public Runnable b(int paramInt, long paramLong)
  {
    c localc = new c(paramInt);
    this.c.postDelayed(localc, paramLong);
    return localc;
  }
  
  public Runnable b(ToServiceMsg paramToServiceMsg, long paramLong)
  {
    b localb = new b(paramToServiceMsg);
    if (paramToServiceMsg != null) {
      this.c.postDelayed(localb, paramLong);
    }
    return localb;
  }
  
  public void b(Runnable paramRunnable)
  {
    this.c.removeCallbacks(paramRunnable);
  }
  
  class a
    implements Runnable
  {
    private int b = 0;
    
    public a(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void run()
    {
      ArrayList localArrayList = (ArrayList)u.this.a.sender.e.remove(Integer.valueOf(this.b));
      if (localArrayList != null) {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "remove merged ssoseq list: " + localArrayList.toString() + " from SSO LoginMerge " + this.b);
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("MSF.C.NetConnTag", 2, "SSO LoginMerge's ssoseq " + this.b + "list has been removed by error code.");
    }
  }
  
  class b
    implements Runnable
  {
    private ToServiceMsg b;
    
    public b(ToServiceMsg paramToServiceMsg)
    {
      this.b = paramToServiceMsg;
    }
    
    public void run()
    {
      if (this.b == null) {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "req null, add preDetTimeout failed! return.");
        }
      }
      do
      {
        for (;;)
        {
          return;
          try
          {
            ToServiceMsg localToServiceMsg = (ToServiceMsg)u.this.a.sender.d.get(Integer.valueOf(this.b.getRequestSsoSeq()));
            if ((localToServiceMsg != null) && (localToServiceMsg.isNeedCallback()))
            {
              localToServiceMsg = (ToServiceMsg)u.this.a.sender.d.get(Integer.valueOf(this.b.getRequestSsoSeq()));
              if (localToServiceMsg == null)
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("MSF.C.NetConnTag", 2, "timeout msg " + localToServiceMsg + " also received resp, return.");
              }
            }
          }
          catch (Exception localException)
          {
            QLog.d("MSF.C.NetConnTag", 1, "got fail msg. " + localException, localException);
            return;
          }
        }
        u.this.a.sender.f(localException);
      } while (localException == null);
      localException.getAttributes().remove("to_predetect_timeoutCallbacker");
    }
  }
  
  class c
    implements Runnable
  {
    private int b;
    
    public c(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void run()
    {
      u.this.a.sender.b(this.b);
    }
  }
  
  class d
    implements Runnable
  {
    private ToServiceMsg b;
    
    public d(ToServiceMsg paramToServiceMsg)
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
          if ((ToServiceMsg)u.this.a.sender.d.get(Integer.valueOf(this.b.getRequestSsoSeq())) == null) {
            continue;
          }
          ToServiceMsg localToServiceMsg = (ToServiceMsg)u.this.a.sender.d.remove(Integer.valueOf(this.b.getRequestSsoSeq()));
          if (!localToServiceMsg.isNeedCallback()) {
            continue;
          }
          if (localToServiceMsg == null)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MSF.C.NetConnTag", 2, "timeout msg " + localToServiceMsg + " also received resp, return.");
            return;
          }
        }
        catch (Exception localException1)
        {
          QLog.d("MSF.C.NetConnTag", 1, "got fail msg. " + localException1, localException1);
          return;
        }
        Object localObject = localException1.getServiceCmd();
        if (QLog.isDevelopLevel())
        {
          QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + localException1.getRequestSsoSeq() + " uin:" + localException1.getUin() + " cmd:" + (String)localObject + " costTime:" + localException1.getTimeout() + NetConnInfoCenter.getSignalStrengthsLog() + " code:" + 1002 + " failMsg:" + "wait serverResp timeout");
          localObject = w.a(localException1);
          ((FromServiceMsg)localObject).setBusinessFail(1002, "wait serverResp timeout");
          boolean bool = u.this.a.sender.a(localException1, (FromServiceMsg)localObject);
          if (!bool) {}
        }
        try
        {
          u.this.a.getSsoRespHandler().b(localException1, (FromServiceMsg)localObject);
          if ((u.this.a.getStatReporter() == null) || (!localException1.isSupportRetry())) {
            continue;
          }
          u.this.a.getStatReporter().e(false);
          return;
          QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + localException1.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(localException1.getUin()) + " cmd:" + c.a((String)localObject) + " costTime:" + localException1.getTimeout() + NetConnInfoCenter.getSignalStrengthsLog() + " code:" + 1002 + " failMsg:" + "wait serverResp timeout");
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
          }
        }
      }
    }
  }
  
  class e
    implements Runnable
  {
    private n b;
    
    public e(n paramn)
    {
      this.b = paramn;
    }
    
    public void run()
    {
      if (this.b != null) {}
      try
      {
        this.b.h();
        return;
      }
      catch (Exception localException)
      {
        QLog.d("MSF.C.NetConnTag", 1, "call loginConnectTimeOut error " + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.u
 * JD-Core Version:    0.7.0.1
 */