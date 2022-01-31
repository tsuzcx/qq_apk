package com.tencent.mobileqq.msf.service;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.push.d;
import com.tencent.mobileqq.msf.core.push.f;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

public class b
{
  private static final String j = "MSF.S.AppProcessInfo";
  volatile boolean a = true;
  volatile boolean b = true;
  volatile long c = 0L;
  volatile boolean d = false;
  volatile long e = 0L;
  String f;
  String g;
  ConcurrentLinkedQueue h = new ConcurrentLinkedQueue();
  public h i = null;
  private IMsfServiceCallbacker k;
  
  public String a()
  {
    return this.f + "," + b() + "," + this.a + "," + this.b;
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (this.i != null) {
      this.i.a(paramInt, paramLong1, paramLong2);
    }
  }
  
  public void a(IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    this.k = paramIMsfServiceCallbacker;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.h.add(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
    c.d.a();
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public void a(String paramString1, String paramString2, IMsfServiceCallbacker paramIMsfServiceCallbacker, boolean paramBoolean)
  {
    this.f = paramString1;
    a(paramString2);
    if (paramIMsfServiceCallbacker != null)
    {
      a(paramIMsfServiceCallbacker);
      this.a = true;
    }
    for (;;)
    {
      this.e = 0L;
      this.d = false;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.AppProcessInfo", 2, paramString1 + " onAppBind, isAppConnected " + this.a);
      }
      if (this.i != null) {
        this.i.a(paramIMsfServiceCallbacker);
      }
      return;
      if (c() == null) {
        this.a = false;
      } else {
        this.a = true;
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.i != null)
    {
      paramString = this.i;
      if (paramBoolean)
      {
        m = 1;
        paramString.a(m);
      }
    }
    while ((paramBoolean) || (TextUtils.isEmpty(this.g))) {
      for (;;)
      {
        return;
        m = 0;
      }
    }
    int m = c.e.getUinPushStatus(paramString);
    g.a(BaseApplication.getContext(), this.f, paramString, this.g, m);
    MsfService.getCore().pushManager.i.a();
  }
  
  public String b()
  {
    return this.g;
  }
  
  public IMsfServiceCallbacker c()
  {
    return this.k;
  }
  
  public void d()
  {
    a(null);
    this.a = false;
    this.d = false;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.S.AppProcessInfo", 2, this.f + " setAppDisConnected, isAppConnected " + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.b
 * JD-Core Version:    0.7.0.1
 */