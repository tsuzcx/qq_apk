package com.tencent.mobileqq.msf.sdk.report;

import android.os.SystemClock;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.msf.sdk.handler.IMsfProxy;
import com.tencent.mobileqq.msf.sdk.l;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class e
{
  public static final String a = "StatReportManager";
  public static String b = "1000";
  private static final String c = "param_ProductVersion";
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap paramHashMap, String paramString3, boolean paramBoolean2)
  {
    if (paramString1 == null) {
      paramString1 = "10000";
    }
    for (;;)
    {
      paramString3 = paramString1;
      if (paramString1 != null)
      {
        paramString3 = paramString1;
        if (paramString1.length() < 1) {
          paramString3 = "10000";
        }
      }
      UserAction.setUserID(paramString3);
      paramString3 = new RdmReq();
      paramString3.eventName = paramString2;
      paramString3.elapse = paramLong1;
      paramString3.size = paramLong2;
      paramString3.isSucceed = paramBoolean1;
      paramString3.isRealTime = paramBoolean2;
      if (paramHashMap == null)
      {
        paramString1 = new HashMap();
        if (paramString1 != null) {
          paramString1.put("param_ProductVersion", "" + BaseApplication.getContext().getAppId());
        }
        if (QLog.isColorLevel()) {
          QLog.d("StatReportManager", 2, "event report: " + paramString2 + " " + paramBoolean1 + " time:" + paramLong1 + " size:" + paramLong2);
        }
        if ((paramBoolean1) && ((!paramString1.containsKey("param_FailCode")) || ("".equals(paramString1.get("param_FailCode"))))) {
          paramString1.put("param_FailCode", String.valueOf(0));
        }
        paramString3.params = paramString1;
      }
      try
      {
        paramString1 = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramString3);
        paramString1.setTimeout(30000L);
        MsfServiceSdk.get().sendMsg(paramString1);
        return;
      }
      catch (Exception paramString1)
      {
        Iterator localIterator;
        return;
      }
      paramString1 = new HashSet();
      paramString1.addAll(paramHashMap.keySet());
      localIterator = paramString1.iterator();
      for (;;)
      {
        paramString1 = paramHashMap;
        if (!localIterator.hasNext()) {
          break;
        }
        paramString1 = (String)localIterator.next();
        if ((String)paramHashMap.get(paramString1) == null) {
          paramHashMap.put(paramString1, "");
        }
      }
    }
  }
  
  public static void a(Throwable paramThrowable)
  {
    try
    {
      Properties localProperties = new Properties();
      localProperties.put("uin", MsfCore.sCore.getAccountCenter().i());
      localProperties.put("exception", paramThrowable.getMessage());
      if (MTAReportManager.getMtaReporter() != null) {
        MTAReportManager.getMtaReporter().reportKVEvent("monitor_IllegalMonitorStateException", localProperties);
      }
      return;
    }
    catch (Throwable paramThrowable)
    {
      paramThrowable.printStackTrace();
    }
  }
  
  public static class a
  {
    HashMap a = null;
    
    public void a()
    {
      if (this.a != null) {
        this.a.clear();
      }
    }
    
    public void a(RdmReq paramRdmReq)
    {
      try
      {
        paramRdmReq = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramRdmReq);
        paramRdmReq.setTimeout(30000L);
        MsfServiceSdk.get().sendMsg(paramRdmReq);
        return;
      }
      catch (Exception paramRdmReq) {}
    }
    
    public void a(String paramString)
    {
      RdmReq localRdmReq = new RdmReq();
      localRdmReq.eventName = paramString;
      localRdmReq.isRealTime = true;
      localRdmReq.params = this.a;
      a(localRdmReq);
    }
    
    public void a(String paramString, int paramInt)
    {
      try
      {
        Properties localProperties = new Properties();
        if ((this.a != null) && (this.a.size() > 0)) {
          localProperties.putAll(this.a);
        }
        if (MTAReportManager.getMtaReporter() != null) {
          MTAReportManager.getMtaReporter().reportTimeKVEvent(paramString, localProperties, paramInt);
        }
        return;
      }
      catch (Exception paramString)
      {
        QLog.w("StatReportManager", 1, "reportTimeMTA", paramString);
        paramString.printStackTrace();
      }
    }
    
    public void a(String paramString1, String paramString2)
    {
      if (this.a == null) {
        this.a = new HashMap();
      }
      this.a.put(paramString1, paramString2);
    }
    
    public void a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2)
    {
      RdmReq localRdmReq = new RdmReq();
      localRdmReq.eventName = paramString;
      localRdmReq.isSucceed = paramBoolean1;
      localRdmReq.elapse = paramLong1;
      localRdmReq.size = paramLong2;
      localRdmReq.isRealTime = paramBoolean2;
      localRdmReq.params = this.a;
      a(localRdmReq);
    }
    
    public void b(String paramString)
    {
      try
      {
        Properties localProperties = new Properties();
        if ((this.a != null) && (this.a.size() > 0)) {
          localProperties.putAll(this.a);
        }
        if (MTAReportManager.getMtaReporter() != null) {
          MTAReportManager.getMtaReporter().reportKVEvent(paramString, localProperties);
        }
        return;
      }
      catch (Exception paramString)
      {
        QLog.w("StatReportManager", 1, "reportMTA", paramString);
        paramString.printStackTrace();
      }
    }
  }
  
  public static class b
    extends e.a
  {
    public static final String b = "msf.sdk.event_bindCost";
    private long c = 0L;
    private short d = 0;
    
    public static b b()
    {
      return a.a();
    }
    
    private void b(long paramLong)
    {
      a("proxy", String.valueOf(MsfServiceSdk.isUseNewProxy));
      a("cost", String.valueOf(paramLong));
      a("count", String.valueOf(this.d));
      a("msf.sdk.event_bindCost", true, paramLong, 0L, true);
    }
    
    public void a(long paramLong)
    {
      if (this.c == 0L) {
        this.c = paramLong;
      }
    }
    
    public void a(boolean paramBoolean)
    {
      if ((this.c > 0L) && (paramBoolean)) {
        b(System.currentTimeMillis() - this.c);
      }
      this.c = 0L;
      this.d = 0;
    }
    
    public void c()
    {
      this.d = ((short)(this.d + 1));
    }
    
    static class a
    {
      private static final e.b a = new e.b();
    }
  }
  
  public static class c
    extends e.a
  {
    public static final String b = "msf.core.DeadObjectException";
    
    public static c b()
    {
      return a.a();
    }
    
    public void a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      String str = String.valueOf(System.currentTimeMillis() + "_" + paramString1 + "_" + paramString4 + " " + paramString2 + "_" + paramString3);
      a("uin", String.valueOf(paramString1));
      a("type", String.valueOf(paramString2));
      a("msg", String.valueOf(str));
      a("exception", String.valueOf(paramString3));
      a("processName", String.valueOf(paramString4));
      a("msf.core.DeadObjectException", true, 0L, 0L, true);
      a();
    }
    
    static class a
    {
      private static final e.c a = new e.c();
    }
  }
  
  public static class d
    extends e.a
  {
    public static final String b = "msf.sdk.MsfReceiverHeld";
    private static final String c = "EventMsfReceiverHeld";
    private boolean d = false;
    private boolean e = false;
    private int f = 0;
    private long g = 0L;
    private int h = 0;
    
    public static d b()
    {
      return a.a();
    }
    
    public void a(String paramString1, String paramString2, int paramInt)
    {
      if (this.f == 0) {
        if (paramInt >= 10)
        {
          this.g = SystemClock.uptimeMillis();
          this.f = paramInt;
        }
      }
      do
      {
        do
        {
          return;
          if ((this.f <= 0) || (paramInt <= this.f)) {
            break;
          }
          this.f = paramInt;
          this.h += 1;
        } while ((this.g <= 0L) || (this.h < 5) || (Math.abs(SystemClock.uptimeMillis() - this.g) <= 300000L) || (this.e));
        this.e = true;
        String str = MsfSdkUtils.getThreadStackString("MSF-Receiver");
        a();
        a("queuesize", String.valueOf(paramInt));
        a("time", "5");
        a("uin", paramString2);
        a("cmd", paramString1);
        if (MsfServiceSdk.get().getProxy() != null) {}
        for (paramString1 = Boolean.valueOf(MsfServiceSdk.get().getProxy().serviceConnected());; paramString1 = "false")
        {
          a("binder", String.valueOf(paramString1));
          a("stack", str);
          QLog.w("EventMsfReceiverHeld", 1, "MSF-Receiver held 5min " + BaseApplication.gMsfReceiverStarted);
          a.a(new b("MSF-Receiver Held " + BaseApplication.gMsfReceiverStarted), "MSFReceiverHeldCatchedException", "MSF-Receiver线程卡住5分钟");
          a("msf.sdk.MsfReceiverHeld", (int)(SystemClock.elapsedRealtime() - this.g));
          return;
        }
      } while (paramInt > this.f);
      this.f = 0;
      this.g = 0L;
      this.h = 0;
    }
    
    static class a
    {
      private static final e.d a = new e.d();
    }
  }
  
  public static class e
    extends e.a
  {
    private static final String b = "pullServiceFail";
    private boolean c = false;
    private long d = 0L;
    private short e = 0;
    private long f = 0L;
    
    public static e b()
    {
      return a.a();
    }
    
    private void f()
    {
      if (!MsfServiceSdk.isUseNewProxy) {
        return;
      }
      l.a(e.b, false);
    }
    
    private void g()
    {
      if (!MsfServiceSdk.isUseNewProxy) {}
    }
    
    private void h()
    {
      this.f = 0L;
      this.d = 0L;
      this.e = 0;
      this.c = false;
    }
    
    public void a(boolean paramBoolean)
    {
      this.e = ((short)(this.e + 1));
      if ((this.e > 10) && (this.f == 0L) && (this.d > 0L) && (SystemClock.elapsedRealtime() > this.d + 60000L) && (!this.c))
      {
        this.f = SystemClock.elapsedRealtime();
        this.c = true;
        f();
        QLog.d("pullServiceFail", 1, "cannot pull msf service.");
      }
    }
    
    public void c()
    {
      if (this.d == 0L) {
        this.d = SystemClock.elapsedRealtime();
      }
    }
    
    public void d()
    {
      g();
      h();
    }
    
    public void e()
    {
      h();
    }
    
    static class a
    {
      private static final e.e a = new e.e();
    }
  }
  
  public static class f
    extends e.a
  {
    public static final String b = "msf.sdk.event_sendToServiceCost";
    
    private void a(long paramLong)
    {
      a("proxy", String.valueOf(MsfServiceSdk.isUseNewProxy));
      a("cost", String.valueOf(paramLong));
      a("msf.sdk.event_sendToServiceCost", true, paramLong, 0L, true);
    }
    
    public static f b()
    {
      return a.a();
    }
    
    public void a(ToServiceMsg paramToServiceMsg, int paramInt)
    {
      if (paramToServiceMsg == null) {}
      long l1;
      long l2;
      do
      {
        do
        {
          return;
        } while (paramInt <= 0);
        l1 = System.currentTimeMillis();
        paramToServiceMsg.addAttribute("to_SendSuccTime", Long.valueOf(l1));
        l2 = ((Long)paramToServiceMsg.getAttribute("to_appSendMsg", Long.valueOf(0L))).longValue();
      } while (l2 <= 0L);
      a(l1 - l2);
    }
    
    public void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
    {
      if ((!paramBoolean) && (!MsfCommand.reportRdm.equals(paramToServiceMsg.getMsfCommand())) && (!"App_reportRDM".equals(paramToServiceMsg.getServiceCmd()))) {
        paramToServiceMsg.addAttribute("to_appSendMsg", Long.valueOf(System.currentTimeMillis()));
      }
    }
    
    static class a
    {
      private static final e.f a = new e.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.report.e
 * JD-Core Version:    0.7.0.1
 */