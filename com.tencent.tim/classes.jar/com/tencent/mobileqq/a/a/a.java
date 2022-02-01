package com.tencent.mobileqq.a.a;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.a.g;
import com.tencent.mobileqq.msf.core.a.g.a;
import com.tencent.mobileqq.msf.core.ak;
import com.tencent.mobileqq.msf.core.as;
import com.tencent.mobileqq.msf.core.as.f;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.c.k.a;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.core.net.j;
import com.tencent.mobileqq.msf.core.net.x;
import com.tencent.mobileqq.msf.core.quicksend.f;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
  extends c
  implements as.f
{
  public static final boolean a = ;
  public static boolean b = false;
  public static int c = 0;
  private static final String d = "ConnQualityStat";
  private static final long e = 15000L;
  private static long f = 0L;
  
  private a()
  {
    if (a)
    {
      if (as.a().b() != null)
      {
        as.a().a(this);
        QLog.i("ConnQualityStat", 1, as.a().b().toString());
      }
      return;
    }
    QLog.d("ConnQualityStat", 1, "WeaknetNew enable=" + a);
  }
  
  public static a a()
  {
    return a.a();
  }
  
  public static boolean b()
  {
    return (a) && (as.a().c());
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, long paramLong, x paramx)
  {
    if (a) {}
    try
    {
      as.a().a(paramInt, paramLong, paramx);
      c.a().a(false);
      return;
    }
    catch (Exception paramx)
    {
      for (;;)
      {
        QLog.w("ConnQualityStat", 1, "onConnOpenFailed", paramx);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (a) {}
    try
    {
      as.a().a(paramLong1, paramLong2);
      return;
    }
    catch (Exception localException)
    {
      QLog.w("ConnQualityStat", 1, "onPingRecved", localException);
    }
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    if (a) {}
    try
    {
      as.a().a(parama);
      c.a().a(false);
      return;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        QLog.w("ConnQualityStat", 1, "onConnClose", parama);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (a) {}
    try
    {
      as.a().a(paramToServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w("ConnQualityStat", 1, "onPingSent", paramToServiceMsg);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (a) {}
    try
    {
      as.a().a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w("ConnQualityStat", 1, "onRecvRespPkg", paramToServiceMsg);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, f paramf)
  {
    if (a) {}
    try
    {
      as.a().a(paramToServiceMsg, paramFromServiceMsg, paramf);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w("ConnQualityStat", 1, "onQuickSendResp", paramToServiceMsg);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean, int paramInt)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      paramFromServiceMsg.getAttributes().put("conn_cross_oper_flag", Boolean.valueOf(b));
    }
    if (QLog.isColorLevel())
    {
      boolean bool = ((Boolean)paramFromServiceMsg.getAttribute("attr_quick_send_by_xg", Boolean.valueOf(false))).booleanValue();
      QLog.d("ConnQualityStat", 2, "onRecvSendChatMsgResp ssoReq=" + paramFromServiceMsg.getRequestSsoSeq() + " weaknet=" + b() + " cross=" + b + " xgSent=" + bool);
    }
    if (paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net_boot"))
    {
      long l = SystemClock.elapsedRealtime() - ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net_boot", Long.valueOf(0L))).longValue();
      if (l > 0L) {
        MsfCore.sCore.getStatReporter().a(l);
      }
    }
    if (a) {
      try
      {
        try
        {
          as.a().a(paramToServiceMsg, paramFromServiceMsg, paramBoolean, 0);
          return;
        }
        finally {}
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.w("ConnQualityStat", 1, "onRecvSendChatMsgResp", paramToServiceMsg);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    if ((paramToServiceMsg != null) && (paramToServiceMsg.isNeedCallback()) && (!"SSO.LoginMerge".equals(paramToServiceMsg.getServiceCmd()))) {
      c += 1;
    }
    if (a) {}
    try
    {
      as.a().a(paramToServiceMsg, paramBoolean);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w("ConnQualityStat", 1, "onSendReqPkg", paramToServiceMsg);
    }
  }
  
  public void a(Socket paramSocket, int paramInt1, int paramInt2)
  {
    if (a) {}
    try
    {
      if (NetConnInfoCenter.isWifiConn()) {
        as.a().a(paramSocket, paramInt2);
      }
      for (;;)
      {
        if (MsfService.serviceInitStart > 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ConnQualityStat", 2, "onConnOpened netType: " + paramInt1 + " serviceInit: " + MsfService.serviceInitStart + " cost:" + (SystemClock.elapsedRealtime() - MsfService.serviceInitStart));
          }
          paramSocket = new d();
          if (paramSocket != null)
          {
            paramSocket.a("netType", String.valueOf(paramInt1));
            paramSocket.a("cost", String.valueOf(SystemClock.elapsedRealtime() - MsfService.serviceInitStart));
            paramSocket.a(SystemClock.elapsedRealtime() - MsfService.serviceInitStart);
          }
          MsfService.serviceInitStart = 0L;
        }
        return;
        as.a().b(paramSocket, paramInt2);
      }
    }
    catch (Exception paramSocket)
    {
      for (;;)
      {
        QLog.w("ConnQualityStat", 1, "onConnOpened", paramSocket);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (a) {}
    try
    {
      as.a().a(paramBoolean);
      if (paramBoolean)
      {
        long l = SystemClock.uptimeMillis();
        if (l - f >= 15000L) {
          f = l;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          MsfCore.sCore.sender.g();
          MsfCore.sCore.screenOn();
          return;
        }
        catch (Throwable localThrowable) {}
        localException = localException;
        QLog.w("ConnQualityStat", 1, "onScreenOn", localException);
      }
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    if (a) {}
    try
    {
      as.a().b(paramToServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w("ConnQualityStat", 1, "onSendChatMsg", paramToServiceMsg);
    }
  }
  
  public void c()
  {
    if (a) {
      as.a().d();
    }
    c.a().a(false);
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    if (a) {}
    try
    {
      as.a().c(paramToServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w("ConnQualityStat", 1, "onQuickSendReqBefore", paramToServiceMsg);
    }
  }
  
  public void d()
  {
    if (a) {}
    try
    {
      as.a().e();
      return;
    }
    catch (Exception localException)
    {
      QLog.w("ConnQualityStat", 1, "onScreenOff", localException);
    }
  }
  
  static class a
  {
    private static final a a = new a(null);
  }
  
  public static class b
    extends k.a
  {
    private static final String b = "freqCloseConn";
    private static final String c = "msf.event.freqCloseConn";
    volatile AtomicBoolean a = new AtomicBoolean(false);
    private long d = 0L;
    private int e = 0;
    private HashMap f = null;
    
    public static b a()
    {
      return a.a();
    }
    
    private void b()
    {
      a("closeConnCount", String.valueOf(this.e));
      a("closeConnReason", String.valueOf(this.f.keySet()));
      a("msf.event.freqCloseConn", true, 0L, this.e);
    }
    
    public void a(com.tencent.qphone.base.a parama)
    {
      long l = System.currentTimeMillis();
      if (this.a.compareAndSet(false, true))
      {
        parama = parama.toString();
        if (this.f == null) {
          this.f = new HashMap();
        }
        if (l - this.d <= 300000L) {
          break label147;
        }
        if (this.e > 10)
        {
          b();
          QLog.d("freqCloseConn", 1, "closeConnCount:" + this.e + " ,reasonMap:" + this.f.keySet());
        }
        this.e = 1;
        this.d = l;
        this.f.clear();
        this.f.put(parama, Integer.valueOf(1));
      }
      for (;;)
      {
        this.a.set(false);
        return;
        label147:
        this.e += 1;
        if ((this.f.containsKey(parama)) && (this.f.get(parama) != null)) {
          this.f.put(parama, Integer.valueOf(((Integer)this.f.get(parama)).intValue() + 1));
        } else {
          this.f.put(parama, Integer.valueOf(1));
        }
      }
    }
    
    static class a
    {
      private static final a.b a = new a.b();
    }
  }
  
  public static class c
  {
    private static final String a = "msf.event.NetConnDontMatched";
    private boolean b = false;
    private d c;
    private boolean d = false;
    
    public static c a()
    {
      return a.a();
    }
    
    public void a(boolean paramBoolean)
    {
      this.b = paramBoolean;
      if (!paramBoolean) {
        a.b = false;
      }
      if ((this.b) && (this.c != null) && (j.a(this.c))) {
        a.b = true;
      }
    }
    
    public void a(boolean paramBoolean, d paramd)
    {
      this.b = paramBoolean;
      this.c = paramd;
      this.d = false;
      a.b = false;
    }
    
    public void b()
    {
      if ((this.b) && (this.c != null)) {
        if (!"00000".equals(this.c.i)) {
          break label235;
        }
      }
      label235:
      for (int i = 2;; i = 1)
      {
        if (j.a(this.c))
        {
          a.b = true;
          QLog.i("ConnQualityStat", 1, "conn is cross oper!!! " + this.c.toString());
          HashMap localHashMap = new HashMap();
          localHashMap.put("uin", String.valueOf(MsfCore.sCore.getAccountCenter().i()));
          localHashMap.put("netType", String.valueOf(i));
          localHashMap.put("region", this.c.j);
          localHashMap.put("oper", this.c.k);
          localHashMap.put("vip", this.c.c());
          localHashMap.put("uintime", String.valueOf(MsfCore.sCore.getAccountCenter().i() + "_" + i + "_" + System.currentTimeMillis()));
          if (MsfService.getCore().getStatReporter() != null) {
            MsfService.getCore().getStatReporter().a("msf.event.NetConnDontMatched", true, 0L, 0L, localHashMap, false, false);
          }
        }
        return;
      }
    }
    
    static class a
    {
      private static final a.c a = new a.c();
    }
  }
  
  class d
    extends k.a
  {
    public static final String a = "dim.msf.ServiceInitToConnedCost";
    
    d() {}
    
    public void a(long paramLong)
    {
      if (paramLong > 0L) {
        a("dim.msf.ServiceInitToConnedCost", true, paramLong, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.a.a.a
 * JD-Core Version:    0.7.0.1
 */