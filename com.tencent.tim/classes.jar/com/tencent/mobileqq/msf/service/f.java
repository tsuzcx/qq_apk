package com.tencent.mobileqq.msf.service;

import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class f
{
  private static final String a = "MSF.S.IPCTransportManager";
  private static final int[] b = { 716800, 655360, 409600, 204800, 102400 };
  private int c = b[0];
  private boolean d = false;
  
  public static f a()
  {
    return a.a();
  }
  
  private c d()
  {
    Iterator localIterator = e.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (c)e.c.get(localObject);
      if ((localObject != null) && (((c)localObject).c() != null)) {
        return localObject;
      }
    }
    return null;
  }
  
  int b()
  {
    c();
    return this.c;
  }
  
  void c()
  {
    if (this.d) {}
    c localc;
    do
    {
      return;
      localc = d();
      if (localc != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.S.IPCTransportManager", 2, "adjustTransPackageLenIfNeed, but appProcessInfo = null");
    return;
    FromServiceMsg localFromServiceMsg = new FromServiceMsg();
    localFromServiceMsg.setServiceCmd("test_ipc_package_length");
    localFromServiceMsg.setBusinessFail(-2);
    localFromServiceMsg.setRequestSsoSeq(-1);
    MsfMessagePair localMsfMessagePair = new MsfMessagePair(null, localFromServiceMsg);
    int i = 0;
    for (;;)
    {
      int j;
      if (i < b.length) {
        j = b[i];
      }
      try
      {
        localFromServiceMsg.putWupBuffer(new byte[j]);
        e.d.a(localMsfMessagePair, localc.c());
        this.c = j;
        QLog.d("MSF.S.IPCTransportManager", 1, "adjustTransPackageLenIfNeed suc, len = " + this.c);
        this.d = true;
        return;
      }
      catch (Throwable localThrowable)
      {
        if (i == b.length - 1)
        {
          this.c = j;
          QLog.d("MSF.S.IPCTransportManager", 1, "adjustTransPackageLenIfNeed fail, last len = " + this.c);
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.IPCTransportManager", 2, "adjustTransPackageLenIfNeed throw e: ", localThrowable);
        }
        i += 1;
      }
    }
  }
  
  static class a
  {
    private static final f a = new f(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.f
 * JD-Core Version:    0.7.0.1
 */