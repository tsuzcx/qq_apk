package com.tencent.mobileqq.msf.core;

import android.content.Context;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class e
{
  public static final String a = "send_mode";
  public static final int b = 0;
  public static final int c = 1;
  private static final String d = "LightSender";
  private MsfCore e;
  private com.tencent.mobileqq.msf.sdk.k f = new com.tencent.mobileqq.msf.sdk.k(1000);
  private LinkedList g = new LinkedList();
  private a h = new a(null);
  private com.tencent.mobileqq.msf.core.net.d i = new com.tencent.mobileqq.msf.core.net.d();
  private long j = 0L;
  
  public e(MsfCore paramMsfCore, Context paramContext)
  {
    this.e = paramMsfCore;
    CodecWarpper.setKsid(paramMsfCore.getAccountCenter().f());
    this.i.b();
    this.h.setName("MsfCoreLightSender");
    this.h.start();
  }
  
  private FromServiceMsg a(FromServiceMsg paramFromServiceMsg)
  {
    byte[] arrayOfByte1;
    int k;
    if ((paramFromServiceMsg.getFlag() & 0x1) != 0)
    {
      arrayOfByte1 = paramFromServiceMsg.getWupBuffer();
      if (arrayOfByte1.length > 4) {
        k = (arrayOfByte1[0] & 0xFF) << 24 | 0x0 | (arrayOfByte1[1] & 0xFF) << 16 | (arrayOfByte1[2] & 0xFF) << 8 | arrayOfByte1[3] & 0xFF;
      }
    }
    else
    {
      try
      {
        byte[] arrayOfByte2 = new byte[k];
        System.arraycopy(arrayOfByte1, 4, arrayOfByte2, 0, k - 4);
        arrayOfByte1 = f.b(arrayOfByte2);
        arrayOfByte2 = new byte[arrayOfByte1.length + 4];
        arrayOfByte2[0] = ((byte)(arrayOfByte1.length + 4 >> 24 & 0xFF));
        arrayOfByte2[1] = ((byte)(arrayOfByte1.length + 4 >> 16 & 0xFF));
        arrayOfByte2[2] = ((byte)(arrayOfByte1.length + 4 >> 8 & 0xFF));
        arrayOfByte2[3] = ((byte)(arrayOfByte1.length + 4 & 0xFF));
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 4, arrayOfByte1.length);
        paramFromServiceMsg.putWupBuffer(arrayOfByte2);
        return paramFromServiceMsg;
      }
      catch (Throwable paramFromServiceMsg)
      {
        QLog.d("LightSender", 1, "LightSender uncompress data failed", paramFromServiceMsg);
        return null;
      }
    }
    return null;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt, String paramString)
  {
    if (paramFromServiceMsg == null)
    {
      paramFromServiceMsg = k.a(paramToServiceMsg);
      if (paramFromServiceMsg != null)
      {
        paramFromServiceMsg.setBusinessFail(paramInt, paramString);
        this.e.getSsoRespHandler().b(paramToServiceMsg, paramFromServiceMsg);
      }
      return;
    }
    this.e.getSsoRespHandler().b(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private boolean c()
  {
    Object localObject;
    if (NetConnInfoCenterImpl.isWifiConn()) {
      localObject = this.e.getSsoListManager().j();
    }
    while (localObject != null)
    {
      localObject = ((CopyOnWriteArrayList)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          d locald = (d)((Iterator)localObject).next();
          this.i.a(locald.e());
          if (this.i.a(locald.c(), locald.d()))
          {
            return true;
            localObject = this.e.getSsoListManager().k();
            break;
          }
        }
      }
      QLog.d("LightSender", 1, "LightSender connect all failed");
      return false;
    }
    QLog.d("LightSender", 1, "LightSender ssolist is empty");
    return false;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      Object localObject = d(paramToServiceMsg);
      if (localObject == null)
      {
        a(paramToServiceMsg, null, 1001, "sendData, send buffer is empty");
        return false;
      }
      if (!c())
      {
        a(paramToServiceMsg, null, 1001, "sendData, connect failed");
        return false;
      }
      localObject = this.i.a((byte[])localObject);
      if (localObject == null)
      {
        a(paramToServiceMsg, null, 1001, "sendData, recv data failed");
        return false;
      }
      localObject = this.e.sender.p.parseData((byte[])localObject);
      if (localObject != null)
      {
        localObject = a((FromServiceMsg)localObject);
        if (localObject == null)
        {
          a(paramToServiceMsg, null, 1001, "sendData, recv data failed");
          return false;
        }
        ((FromServiceMsg)localObject).setRequestSsoSeq(((FromServiceMsg)localObject).getAppSeq());
        if (paramToServiceMsg != null)
        {
          ((FromServiceMsg)localObject).setAppSeq(paramToServiceMsg.getAppSeq());
          ((FromServiceMsg)localObject).setMsfCommand(paramToServiceMsg.getMsfCommand());
          ((FromServiceMsg)localObject).setAppId(paramToServiceMsg.getAppId());
        }
        if (!this.e.getSsoRespHandler().a(paramToServiceMsg, (FromServiceMsg)localObject)) {
          a(paramToServiceMsg, null, 1001, "sendData, recv new ssolist");
        }
        return true;
      }
      a(paramToServiceMsg, null, 1001, "sendData, parse data failed");
      return false;
    }
    catch (Exception localException)
    {
      a(paramToServiceMsg, null, 1001, "sendData, exception");
      localException.printStackTrace();
      return false;
    }
    finally
    {
      this.i.a();
      this.i.b();
    }
  }
  
  private byte d()
  {
    int m = 254;
    if (NetConnInfoCenterImpl.isWifiConn()) {
      return 1;
    }
    int k;
    if (NetConnInfoCenterImpl.isMobileConn())
    {
      k = NetConnInfoCenterImpl.getMobileNetworkType() + 100;
      if (k <= 254) {
        break label144;
      }
      k = m;
      if (QLog.isColorLevel())
      {
        QLog.d("LightSender", 2, "error,netWorkType is " + 254);
        k = m;
      }
    }
    label144:
    for (;;)
    {
      return (byte)k;
      long l = System.currentTimeMillis();
      if ((this.j == 0L) || (l - this.j > 60000L))
      {
        this.j = l;
        try
        {
          NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
          return 0;
        }
        catch (Exception localException)
        {
          QLog.d("LightSender", 1, "checkConnInfo " + localException);
        }
      }
      return 0;
    }
  }
  
  private byte[] d(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return null;
    }
    try
    {
      String str = paramToServiceMsg.getServiceCmd();
      if (paramToServiceMsg.getWupBuffer() != null)
      {
        byte b1 = d();
        int k = 0;
        if (paramToServiceMsg.getAttributes().containsKey("send_mode")) {
          k = ((Integer)paramToServiceMsg.getAttributes().get("send_mode")).intValue();
        }
        if (k == 1) {
          return CodecWarpper.encodeRequest(paramToServiceMsg.getRequestSsoSeq(), k.d(), k.f(), k.g(), "", str, null, paramToServiceMsg.getAppId(), this.e.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, paramToServiceMsg.getWupBuffer(), true);
        }
        return CodecWarpper.encodeRequest(paramToServiceMsg.getRequestSsoSeq(), k.d(), k.f(), k.g(), "", str, null, paramToServiceMsg.getAppId(), this.e.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, paramToServiceMsg.getWupBuffer(), true);
      }
      return new byte[0];
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    if (!this.f.isEmpty())
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        if (((ToServiceMsg)localIterator.next()).getServiceName().equals("MessageSvc.QueryPullUp")) {
          localIterator.remove();
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.f.add(paramToServiceMsg);
  }
  
  public void b()
  {
    if (!this.g.isEmpty())
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        ToServiceMsg localToServiceMsg = (ToServiceMsg)localIterator.next();
        if (localToServiceMsg.getServiceCmd().equals("MessageSvc.QueryPullUp")) {
          localToServiceMsg.getAttributes().put("RequestEcho", Boolean.valueOf(false));
        }
      }
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)localIterator.next();
      if (paramToServiceMsg.getRequestSsoSeq() == localToServiceMsg.getRequestSsoSeq()) {
        localIterator.remove();
      }
    }
  }
  
  private class a
    extends Thread
  {
    private a() {}
    
    public void run()
    {
      try
      {
        for (;;)
        {
          ToServiceMsg localToServiceMsg = (ToServiceMsg)e.a(e.this).k();
          if (localToServiceMsg != null)
          {
            e.b(e.this).add(localToServiceMsg);
            e.a(e.this, localToServiceMsg);
            e.this.b(localToServiceMsg);
            Thread.sleep(10L);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.e
 * JD-Core Version:    0.7.0.1
 */