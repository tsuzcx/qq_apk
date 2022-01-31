package com.tencent.mobileqq.msf.core.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.TrafficStats;
import android.os.Process;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.k;
import com.tencent.mobileqq.msf.core.l;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class f
{
  private static final int A = 0;
  private static final String B = "cw_";
  private static final String C = "cx_";
  private static final String D = "MSF_lastMonthWifiFlow";
  private static final String E = "MSF_lastMonthXGFlow";
  private static final String F = "MSF_monthWifiFlow";
  private static final String G = "MSF_monthXGFlow";
  static a a;
  static m b;
  static j c;
  static MsfCore d;
  static String[] e;
  public static long f = 0L;
  static Object g = new Object();
  static Object h = new Object();
  static Object i = new Object();
  static File j = null;
  static volatile File k = null;
  static volatile File l = null;
  static volatile File m = null;
  static byte n = 0;
  static String o = null;
  static long p = 0L;
  static long q = 0L;
  static long r = 0L;
  private static final String s = "MSF.C.NetworkTraffic";
  private static final String t = "MSF_Metrics";
  private static final String u = "MSF_NetflowRdmReport";
  private static final String v = "MSF_NetflowRdmReport_TIME";
  private static final String w = "MSF_TransportMetrics_Status";
  private static long x = 0L;
  private static long y = 0L;
  private static boolean z;
  
  static
  {
    a = new a();
    b = new m();
    e = new String[] { "param_XGChatFlow", "param_XGFlow", "param_Flow" };
    f = 0L;
    z = false;
  }
  
  public static void a()
  {
    if (MsfCore.SysVerSion >= 8) {}
    long l1;
    try
    {
      j();
      int i1 = l();
      k();
      do
      {
        synchronized (i)
        {
          l1 = TrafficStats.getUidRxBytes(Process.myUid()) + TrafficStats.getUidTxBytes(Process.myUid());
          if ((i1 == 0) || (i1 == 1))
          {
            a(true, l1);
            return;
          }
        }
      } while (i1 != 2);
    }
    catch (Exception localException)
    {
      QLog.e("MSF.C.NetworkTraffic", 1, "get flowDic error " + BaseApplication.getContext().getFilesDir() + " " + localException);
      return;
    }
    a(false, l1);
  }
  
  public static void a(int paramInt)
  {
    g localg = new g(paramInt);
    localg.setName("doReportRdmThread");
    localg.start();
  }
  
  public static void a(long paramLong)
  {
    b.a = (paramLong * 1024L * 1024L);
    d();
  }
  
  public static void a(long paramLong, int paramInt)
  {
    int i1 = 0;
    Object localObject1 = g;
    if (paramInt == 1) {}
    for (;;)
    {
      boolean bool;
      try
      {
        if ((y != 0L) && (paramLong >= y))
        {
          a(1);
          y = 0L;
          k.a().removeConfig("MONITOR_NetflowRdmReport_TIME");
        }
        if ((b.d != 0L) && (paramLong < b.d)) {
          break label379;
        }
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.set(2, localCalendar.get(2) + 1);
        localCalendar.set(5, 1);
        localCalendar.set(11, 0);
        localCalendar.set(12, 0);
        localCalendar.set(13, 0);
        localCalendar.set(14, 0);
        b.d = localCalendar.getTimeInMillis();
        bool = true;
        paramInt = 1;
        if ((b.c == 0L) || (paramLong >= b.c))
        {
          localCalendar = Calendar.getInstance();
          localCalendar.set(6, localCalendar.get(6) + 1);
          localCalendar.set(11, 0);
          localCalendar.set(12, 0);
          localCalendar.set(13, 0);
          localCalendar.set(14, 0);
          if (b.c != 0L)
          {
            h localh = new h(paramLong, bool);
            localh.setName("makeReportDataThread");
            localh.start();
          }
          b.c = localCalendar.getTimeInMillis();
          paramInt = 1;
        }
        if (paramInt != 0) {
          d();
        }
        if (b.e != 0L) {
          break label342;
        }
        b.e = paramLong;
        c();
        return;
      }
      finally {}
      if ((x != 0L) && (paramLong >= x))
      {
        a(0);
        x = 0L;
        k.a().removeConfig("MSF_NetflowRdmReport_TIME");
        continue;
        label342:
        if ((b.e != 0L) && (paramLong - b.e > 120000L))
        {
          b.e = paramLong;
          c();
          return;
          label379:
          bool = false;
          paramInt = i1;
        }
      }
    }
  }
  
  private static void a(long paramLong1, long paramLong2)
  {
    try
    {
      k.a().setConfig("MSF_lastMonthWifiFlow", String.valueOf(paramLong1));
      k.a().setConfig("MSF_lastMonthXGFlow", String.valueOf(paramLong2));
      QLog.d("MSF.C.NetworkTraffic", 1, "save lastMonthWifiCount " + paramLong1 + " lastMonthXGCount " + paramLong2);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.NetworkTraffic", 1, "save lastMonthData error " + localException);
    }
  }
  
  public static void a(j paramj, MsfCore paramMsfCore)
  {
    c = paramj;
    d = paramMsfCore;
    b();
    a(System.currentTimeMillis(), 0);
  }
  
  public static void a(String paramString, String[] paramArrayOfString, long paramLong)
  {
    a(System.currentTimeMillis(), 0);
    if (!a.a.containsKey(paramString))
    {
      localn = new n();
      localn.a = paramString;
      localn.b = new HashMap();
      localn.c = new HashMap();
      a.a.put(paramString, localn);
    }
    n localn = (n)a.a.get(paramString);
    if (localn != null)
    {
      int i2 = paramArrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = paramArrayOfString[i1];
        label158:
        synchronized (h)
        {
          if (!localn.b.containsKey(str)) {
            localn.b.put(str, Long.valueOf(paramLong));
          }
        }
        synchronized (h)
        {
          if (!localn.c.containsKey(str))
          {
            localn.c.put(str, Long.valueOf(paramLong));
            if ((z) && (QLog.isDevelopLevel())) {
              QLog.d("MSF.C.NetworkTraffic", 4, "onDataIncerment uin:" + paramString + " key:" + str + " count:" + paramLong + " all:" + localn.b.get(str));
            }
            i1 += 1;
            continue;
            localn.b.put(str, Long.valueOf(((Long)localn.b.get(str)).longValue() + paramLong));
            break label158;
            paramString = finally;
            throw paramString;
          }
          else
          {
            localn.c.put(str, Long.valueOf(((Long)localn.c.get(str)).longValue() + paramLong));
          }
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean)
    throws IOException
  {
    for (;;)
    {
      synchronized (i)
      {
        if ((k != null) && (k.exists()))
        {
          if (paramBoolean)
          {
            localFile = new File(o + "last_w");
            k.renameTo(localFile);
            k = localFile;
            return;
          }
          File localFile = new File(o + "last_g");
        }
      }
      if (paramBoolean)
      {
        j();
        k = new File(o + "last_w");
        k.createNewFile();
      }
      else
      {
        j();
        k = new File(o + "last_g");
        k.createNewFile();
      }
    }
  }
  
  private static void a(boolean paramBoolean, long paramLong)
    throws IOException
  {
    long l1 = paramLong - p;
    p = paramLong;
    if (l1 > 0L)
    {
      if (!paramBoolean) {
        break label116;
      }
      q += l1;
      a(true, j.getAbsolutePath(), "cw_" + q);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetworkTraffic", 2, "monitorNetFlow llastBytesCount " + p + " wifi add " + l1 + " today " + q);
      }
    }
    label116:
    do
    {
      return;
      r += l1;
      a(false, j.getAbsolutePath(), "cx_" + r);
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.NetworkTraffic", 2, "monitorNetFlow llastBytesCount " + p + " xg add " + l1 + " today " + r);
  }
  
  public static void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3)
  {
    if (NetConnInfoCenterImpl.isMobileConn()) {
      a(paramString1, e, paramInt1);
    }
    while (!NetConnInfoCenterImpl.isWifiConn()) {
      return;
    }
    a(paramString1, e, paramInt1);
  }
  
  private static void a(boolean paramBoolean, String paramString1, String paramString2)
    throws IOException
  {
    int i1 = 0;
    label265:
    label273:
    label276:
    for (;;)
    {
      String str;
      synchronized (i)
      {
        File localFile = l;
        if (paramBoolean) {
          break label273;
        }
        localFile = m;
        if (localFile == null) {
          break label265;
        }
        str = localFile.getName();
        if ((localFile != null) && (localFile.exists()))
        {
          paramString1 = new File(paramString1 + "/" + paramString2);
          localFile.renameTo(paramString1);
          if (!paramBoolean)
          {
            m = paramString1;
            break label276;
            if (paramBoolean) {
              break label214;
            }
            m = paramString1;
            if (i1 == 0) {
              break label221;
            }
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetworkTraffic", 2, "monitorNetFlow " + str + " rename to " + paramString2);
            }
            return;
          }
          l = paramString1;
        }
      }
      j();
      paramString1 = new File(paramString1 + "/" + paramString2);
      paramString1.createNewFile();
      continue;
      label214:
      l = paramString1;
      continue;
      label221:
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.NetworkTraffic", 2, "monitorNetFlow " + str + " not found, create file " + paramString2);
        return;
        str = "null";
        continue;
        continue;
        i1 = 1;
      }
    }
  }
  
  public static long[][] a(String[] paramArrayOfString)
  {
    a(System.currentTimeMillis(), 0);
    long[] arrayOfLong1 = new long[paramArrayOfString.length];
    long[] arrayOfLong2 = new long[paramArrayOfString.length];
    int i3 = paramArrayOfString.length;
    int i2 = 0;
    int i1 = 0;
    while (i2 < i3)
    {
      String str = paramArrayOfString[i2];
      Iterator localIterator = a.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        n localn = (n)((Map.Entry)localIterator.next()).getValue();
        if (localn.b.containsKey(str)) {
          arrayOfLong1[i1] += ((Long)localn.b.get(str)).longValue();
        }
        if (localn.c.containsKey(str))
        {
          long l1 = arrayOfLong2[i1];
          arrayOfLong2[i1] = (((Long)localn.c.get(str)).longValue() + l1);
        }
      }
      i2 += 1;
      i1 += 1;
    }
    return new long[][] { arrayOfLong1, arrayOfLong2 };
  }
  
  public static void b()
  {
    try
    {
      localObject = k.a().getConfig("MSF_NetflowRdmReport_TIME");
      String str = k.a().getConfig("MONITOR_NetflowRdmReport_TIME");
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        x = Long.parseLong((String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetworkTraffic", 2, "load reportRDM time is " + x);
        }
      }
      if ((str != null) && (str.length() > 0))
      {
        y = Long.parseLong(str);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetworkTraffic", 2, "load monitor_reportRDM time is " + y);
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject;
        label161:
        label200:
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetworkTraffic", 2, "load reportRDM error " + localException1);
        }
      }
    }
    try
    {
      localObject = k.a().getConfig("MSF_TransportMetrics_Status");
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = new JceInputStream(HexUtil.hexStr2Bytes((String)localObject));
        b.readFrom((JceInputStream)localObject);
      }
    }
    catch (Exception localException2)
    {
      if (!QLog.isColorLevel()) {
        break label161;
      }
      QLog.d("MSF.C.NetworkTraffic", 2, "load transportMetriceStatus error " + localException2);
      break label161;
    }
    try
    {
      localObject = k.a().getConfig("MSF_Metrics");
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = new JceInputStream(HexUtil.hexStr2Bytes((String)localObject));
        a.readFrom((JceInputStream)localObject);
      }
    }
    catch (Exception localException3)
    {
      if (!QLog.isColorLevel()) {
        break label200;
      }
      QLog.d("MSF.C.NetworkTraffic", 2, "load transportMetriceInfo error " + localException3);
      break label200;
    }
    if (a.a == null) {
      a.a = new HashMap();
    }
  }
  
  private static void b(int paramInt, long paramLong)
  {
    Object localObject1 = new e();
    ((e)localObject1).a = new ArrayList();
    Object localObject2;
    Object localObject3;
    Object localObject5;
    Object localObject4;
    if (paramInt == 0)
    {
      localObject2 = a.a.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject5 = (n)a.a.get(localObject3);
        if (localObject5 != null)
        {
          localObject4 = new HashMap();
          if (!((n)localObject5).b.containsKey("param_Flow")) {
            break label1201;
          }
        }
      }
    }
    label1201:
    for (paramLong = ((Long)((n)localObject5).b.get("param_Flow")).longValue();; paramLong = 0L)
    {
      Iterator localIterator = ((n)localObject5).b.keySet().iterator();
      String str;
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        Long localLong = (Long)((n)localObject5).b.get(str);
        if (localLong != null) {
          ((HashMap)localObject4).put(str, String.valueOf(Long.valueOf(localLong.longValue() / 1024L)));
        }
      }
      ((HashMap)localObject4).put("uin", localObject3);
      paramLong /= 1024L;
      localObject5 = new i();
      ((i)localObject5).b = paramLong;
      ((i)localObject5).c = ((Map)localObject4);
      ((i)localObject5).a = ((String)localObject3);
      ((e)localObject1).a.add(localObject5);
      break;
      localObject2 = new i();
      localObject3 = new HashMap();
      ((i)localObject2).b = (q + r);
      ((HashMap)localObject3).put("param_WIFISystemFlow", String.valueOf(q));
      ((HashMap)localObject3).put("param_XGSystemFlow", String.valueOf(r));
      ((HashMap)localObject3).put("param_MonthWIFISystemFlow", String.valueOf(f()));
      ((HashMap)localObject3).put("param_MonthXGSystemFlow", String.valueOf(g()));
      ((HashMap)localObject3).put("param_LastMonthWIFISystemFlow", String.valueOf(h()));
      ((HashMap)localObject3).put("param_LastMonthXGSystemFlow", String.valueOf(i()));
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.NetworkTraffic", 2, "monitorNetFlow makeRdmData todayWifiCount " + q + " todayXGCount:" + r);
        QLog.d("MSF.C.NetworkTraffic", 2, "monitorNetFlow makeRdmData currentMonthWifCount " + (String)((HashMap)localObject3).get("param_MonthWIFISystemFlow") + " currentMonthXGCount:" + (String)((HashMap)localObject3).get("param_MonthXGSystemFlow"));
        QLog.d("MSF.C.NetworkTraffic", 2, "monitorNetFlow makeRdmData lastMonthWifiCount " + (String)((HashMap)localObject3).get("param_LastMonthWIFISystemFlow") + " lastMonthXGCount:" + (String)((HashMap)localObject3).get("param_LastMonthXGSystemFlow"));
      }
      ((i)localObject2).c = ((Map)localObject3);
      if ((d != null) && (d.sender != null) && (d.sender.g().length() > 4))
      {
        ((i)localObject2).a = d.sender.g();
        ((e)localObject1).a.add(localObject2);
        localObject2 = new JceOutputStream();
        ((e)localObject1).writeTo((JceOutputStream)localObject2);
        k.a().setConfig("MSF_NetflowRdmReport", HexUtil.bytes2HexStr(((JceOutputStream)localObject2).toByteArray()));
        localObject1 = new Intent(NetConnInfoCenter.RDMREPORT_INTENT);
        ((Intent)localObject1).setAction(NetConnInfoCenter.RDMREPORT_INTENT);
        localObject1 = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject1, 0);
        localObject2 = (AlarmManager)BaseApplication.getContext().getSystemService("alarm");
        localObject3 = new Random(System.currentTimeMillis());
        paramLong = System.currentTimeMillis() + ((Random)localObject3).nextInt(21600000);
        ((AlarmManager)localObject2).set(0, paramLong, (PendingIntent)localObject1);
        localObject1 = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault());
        x = paramLong;
        k.a().setConfig("MSF_NetflowRdmReport_TIME", String.valueOf(x));
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetworkTraffic", 2, "set reportRDM at " + ((SimpleDateFormat)localObject1).format(Long.valueOf(x)));
        }
      }
      do
      {
        return;
        ((i)localObject2).a = "10000";
        break;
        QLog.d("MSF.C.MonitorNetFlowStore", 1, "make report RDM net flow by socket monitor.");
        localObject2 = d.getNetFlowStore().b(paramLong);
        localObject3 = ((HashMap)localObject2).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localObject5 = new i();
          ((i)localObject5).a = ((String)localObject4);
          ((i)localObject5).c = new HashMap();
          ((i)localObject5).c.put("uin", localObject4);
          localIterator = ((HashMap)((HashMap)localObject2).get(localObject4)).keySet().iterator();
          while (localIterator.hasNext())
          {
            str = (String)localIterator.next();
            paramLong = ((Long)((HashMap)((HashMap)localObject2).get(localObject4)).get(str)).longValue();
            ((i)localObject5).b += paramLong;
            ((i)localObject5).c.put(str, String.valueOf(paramLong));
          }
          ((e)localObject1).a.add(localObject5);
        }
        localObject2 = new JceOutputStream();
        ((e)localObject1).writeTo((JceOutputStream)localObject2);
        k.a().setConfig("MONITOR_NetflowRdmReport", HexUtil.bytes2HexStr(((JceOutputStream)localObject2).toByteArray()));
        localObject1 = new Intent(NetConnInfoCenter.RDMREPORT_INTENT);
        ((Intent)localObject1).setAction(NetConnInfoCenter.RDMREPORT_INTENT);
        localObject1 = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject1, 0);
        localObject2 = (AlarmManager)BaseApplication.getContext().getSystemService("alarm");
        localObject3 = new Random(System.currentTimeMillis());
        paramLong = System.currentTimeMillis() + ((Random)localObject3).nextInt(21600000);
        ((AlarmManager)localObject2).set(0, paramLong, (PendingIntent)localObject1);
        localObject1 = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault());
        y = paramLong;
        k.a().setConfig("MONITOR_NetflowRdmReport_TIME", String.valueOf(y));
      } while (!QLog.isColorLevel());
      QLog.d("MSF.C.MonitorNetFlowStore", 2, "set new netflow reportRDM at " + ((SimpleDateFormat)localObject1).format(Long.valueOf(y)));
      return;
    }
  }
  
  public static void b(long paramLong)
  {
    b.b = (paramLong * 1024L * 1024L);
    d();
  }
  
  private static void b(long paramLong1, long paramLong2)
  {
    try
    {
      k.a().setConfig("MSF_monthWifiFlow", String.valueOf(paramLong1));
      k.a().setConfig("MSF_monthXGFlow", String.valueOf(paramLong2));
      QLog.d("MSF.C.NetworkTraffic", 1, "save monthWifiCount " + paramLong1 + " monthXGCount " + paramLong2);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.NetworkTraffic", 1, "save monthData error " + localException);
    }
  }
  
  public static void c()
  {
    JceOutputStream localJceOutputStream = new JceOutputStream();
    a.writeTo(localJceOutputStream);
    k.a().setConfig("MSF_Metrics", HexUtil.bytes2HexStr(localJceOutputStream.toByteArray()));
  }
  
  public static void d()
  {
    JceOutputStream localJceOutputStream = new JceOutputStream();
    b.writeTo(localJceOutputStream);
    k.a().setConfig("MSF_TransportMetrics_Status", HexUtil.bytes2HexStr(localJceOutputStream.toByteArray()));
  }
  
  private static void d(boolean paramBoolean)
  {
    Iterator localIterator = a.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((n)localEntry.getValue()).b.clear();
      if (paramBoolean) {
        ((n)localEntry.getValue()).c.clear();
      }
    }
    a.b = 0L;
    a.c = 0L;
  }
  
  public static void e()
  {
    long l1;
    if (MsfCore.SysVerSion >= 8) {
      synchronized (i)
      {
        l1 = TrafficStats.getUidRxBytes(Process.myUid()) + TrafficStats.getUidTxBytes(Process.myUid());
      }
    }
    try
    {
      if (NetConnInfoCenterImpl.isMobileConn()) {
        a(false, l1);
      }
      while (!NetConnInfoCenterImpl.isWifiConn())
      {
        return;
        localObject2 = finally;
        throw localObject2;
      }
      a(true, l1);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  private static void e(boolean paramBoolean)
  {
    File localFile;
    synchronized (i)
    {
      if ((l != null) && (l.exists()))
      {
        localFile = new File(j.getAbsolutePath() + "/" + "cw_" + "0");
        l.renameTo(localFile);
        l = localFile;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.NetworkTraffic", 2, "monitorNetFlow currentWifiFlowFile " + l.getName() + " rename to " + localFile.getName());
          QLog.d("MSF.C.NetworkTraffic", 2, "monitorNetFlow currentDay wifiFlow " + q);
        }
      }
    }
    for (;;)
    {
      long l1;
      long l2;
      synchronized (i)
      {
        if ((m != null) && (m.exists()))
        {
          localFile = new File(j.getAbsolutePath() + "/" + "cx_" + "0");
          m.renameTo(localFile);
          m = localFile;
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.NetworkTraffic", 2, "monitorNetFlow currentXGFlowFile " + m.getName() + " rename to " + localFile.getName());
            QLog.d("MSF.C.NetworkTraffic", 2, "monitorNetFlow currentDay xgFlow " + r);
          }
        }
        l1 = f();
        l2 = g();
        if (paramBoolean)
        {
          a(l1 + q, l2 + r);
          b(0L, 0L);
          q = 0L;
          r = 0L;
          return;
          localObject2 = finally;
          throw localObject2;
        }
      }
      b(l1 + q, l2 + r);
    }
  }
  
  private static long f()
  {
    try
    {
      String str = k.a().getConfig("MSF_monthWifiFlow");
      if ((str != null) && (str.length() > 0))
      {
        long l1 = Long.parseLong(str);
        return l1;
      }
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.NetworkTraffic", 1, "get monthWifiData error " + localException);
    }
    return 0L;
  }
  
  private static long g()
  {
    try
    {
      String str = k.a().getConfig("MSF_monthXGFlow");
      if ((str != null) && (str.length() > 0))
      {
        long l1 = Long.parseLong(str);
        return l1;
      }
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.NetworkTraffic", 1, "get monthXGData error " + localException);
    }
    return 0L;
  }
  
  private static long h()
  {
    try
    {
      String str = k.a().getConfig("MSF_lastMonthWifiFlow");
      if ((str != null) && (str.length() > 0))
      {
        long l1 = Long.parseLong(str);
        return l1;
      }
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.NetworkTraffic", 1, "get lastMonthWifiData error " + localException);
    }
    return 0L;
  }
  
  private static long i()
  {
    try
    {
      String str = k.a().getConfig("MSF_lastMonthXGFlow");
      if ((str != null) && (str.length() > 0))
      {
        long l1 = Long.parseLong(str);
        return l1;
      }
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.NetworkTraffic", 1, "get lastMonthXGData error " + localException);
    }
    return 0L;
  }
  
  private static void j()
  {
    if (o == null) {
      o = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/flow/";
    }
    if (j == null) {
      j = new File(o);
    }
    if (!j.exists()) {
      j.mkdirs();
    }
  }
  
  private static void k()
    throws IOException
  {
    int i2 = 0;
    if ((j != null) && (j.exists()))
    {
      String[] arrayOfString = j.list();
      int i5 = arrayOfString.length;
      int i1 = 0;
      int i3 = 0;
      if (i1 < i5)
      {
        String str = arrayOfString[i1];
        int i4;
        if (str.startsWith("cx_"))
        {
          m = new File(j.getAbsolutePath() + "/" + str);
          r = Long.parseLong(str.substring("cx_".length(), str.length()));
          i4 = 1;
        }
        for (;;)
        {
          i1 += 1;
          i2 = i4;
          break;
          i4 = i2;
          if (str.startsWith("cw_"))
          {
            l = new File(j.getAbsolutePath() + "/" + str);
            q = Long.parseLong(str.substring("cw_".length(), str.length()));
            i3 = 1;
            i4 = i2;
          }
        }
      }
      if (i2 == 0)
      {
        m = new File(j.getAbsolutePath() + "/" + "cx_" + "0");
        m.createNewFile();
      }
      if (i3 == 0)
      {
        l = new File(j.getAbsolutePath() + "/" + "cw_" + "0");
        l.createNewFile();
      }
      p = q + r;
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.NetworkTraffic", 2, "monitorNetFlow load lastRunning bytesCount " + p + " todayWifiCount:" + q + " todayXGCount:" + r);
        QLog.d("MSF.C.NetworkTraffic", 2, "monitorNetFlow currentXGFlowFile is " + m.getName());
        QLog.d("MSF.C.NetworkTraffic", 2, "monitorNetFlow currentWifiFlowFile is " + l.getName());
      }
    }
  }
  
  private static byte l()
    throws IOException
  {
    k = new File(o + "last_w");
    if (!k.exists())
    {
      k = new File(o + "last_g");
      if (!k.exists()) {
        return 0;
      }
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.f
 * JD-Core Version:    0.7.0.1
 */