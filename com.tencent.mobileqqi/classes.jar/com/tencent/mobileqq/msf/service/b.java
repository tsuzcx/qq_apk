package com.tencent.mobileqq.msf.service;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

public class b
{
  static long k = 0L;
  static long l = 720000L;
  private static final String m = "MSF.S.AppProcessInfo";
  volatile boolean a = true;
  volatile long b = 0L;
  volatile boolean c = false;
  volatile long d = 0L;
  String e;
  String f;
  ConcurrentLinkedQueue g = new ConcurrentLinkedQueue();
  int h;
  int i;
  volatile long j;
  private IMsfServiceCallbacker n;
  
  public String a()
  {
    return this.e + "," + b() + "," + this.a;
  }
  
  public void a(IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    this.n = paramIMsfServiceCallbacker;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.g.add(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
    d.d.a();
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(String paramString1, String paramString2, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    this.e = paramString1;
    a(paramString2);
    if (paramIMsfServiceCallbacker != null)
    {
      a(paramIMsfServiceCallbacker);
      this.a = true;
    }
    for (;;)
    {
      this.d = 0L;
      this.c = false;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.AppProcessInfo", 2, paramString1 + " onAppBind, isAppConnected " + this.a);
      }
      if ((this.a) && (paramString1.equals(BaseApplication.getContext().getPackageName())))
      {
        MsfService.getCore().pushManager.k();
        MsfService.getCore().pushManager.l();
      }
      try
      {
        paramIMsfServiceCallbacker.asBinder().linkToDeath(new c(this), 0);
        return;
      }
      catch (RemoteException paramString1)
      {
        paramString1.printStackTrace();
      }
      if (c() == null) {
        this.a = false;
      } else {
        this.a = true;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.S.AppProcessInfo", 2, "onGuardModeChange, guard " + paramBoolean + ", active degree " + paramInt1 + ", memory size " + paramInt2);
    }
    if (paramBoolean)
    {
      this.j = 0L;
      return;
    }
    this.h = paramInt1;
    this.i = paramInt2;
    this.j = System.currentTimeMillis();
  }
  
  public String b()
  {
    return this.f;
  }
  
  public IMsfServiceCallbacker c()
  {
    return this.n;
  }
  
  public void d()
  {
    a(null);
    this.a = false;
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.S.AppProcessInfo", 2, this.e + " setAppDisConnected, isAppConnected " + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.b
 * JD-Core Version:    0.7.0.1
 */