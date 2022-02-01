package com.tencent.mobileqq.msf.core.net.c;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.msf.service.protocol.push.a.b;
import com.tencent.msf.service.protocol.push.a.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class k
{
  static final String a = "MSF.C.QualityTestManager";
  public static d b = null;
  public static b c = null;
  public static MsfCore d = null;
  public static String e = "";
  public static ArrayList f = new ArrayList();
  public static ArrayList g = new ArrayList();
  static int h = 1;
  static int i = 0;
  
  private static String a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      localObject = "";
    }
    Iterator localIterator;
    do
    {
      return localObject;
      localIterator = paramArrayList.iterator();
      paramArrayList = "";
      localObject = paramArrayList;
    } while (!localIterator.hasNext());
    Object localObject = (Long)localIterator.next();
    if (localObject != null) {}
    for (paramArrayList = paramArrayList + localObject + ";";; paramArrayList = paramArrayList + "-1;") {
      break;
    }
  }
  
  public static void a()
  {
    b = null;
    c = null;
  }
  
  public static void a(FromServiceMsg paramFromServiceMsg)
  {
    UniPacket localUniPacket;
    try
    {
      if (!paramFromServiceMsg.isSuccess()) {
        break label1698;
      }
      if (b != null) {
        break label1689;
      }
      localUniPacket = new UniPacket(true);
      localUniPacket.decode(paramFromServiceMsg.getWupBuffer());
      paramFromServiceMsg = localUniPacket.getFuncName();
      if (!paramFromServiceMsg.equals("QualityTest")) {
        break label1520;
      }
      b = (d)localUniPacket.getByClass("QualityTest", new d());
      QLog.d("MSF.C.QualityTestManager", 1, "Quality getted, start now " + b.a);
      if (b.z != 1) {
        break label817;
      }
      if ((NetConnInfoCenter.isWifiConn()) && (NetConnInfoCenter.getWifiStrength() >= 10)) {
        break label353;
      }
      e = "NotWiFi";
      if (b.a == 1)
      {
        new Thread(new f(b, c, f.b.a, h, i)).start();
        return;
      }
      if (b.a == 2)
      {
        new Thread(new f(b, c, f.b.b, h, i)).start();
        return;
      }
    }
    catch (Throwable paramFromServiceMsg)
    {
      QLog.d("MSF.C.QualityTestManager", 1, "QualityManager error, ", paramFromServiceMsg);
      return;
    }
    if (b.a == 3)
    {
      new Thread(new f(b, c, f.b.c, h, i)).start();
      return;
    }
    if (b.a == 5)
    {
      new Thread(new f(b, c, f.b.e, h, i)).start();
      return;
    }
    if (b.a == 6)
    {
      new Thread(new f(b, c, f.b.d, h, i)).start();
      return;
    }
    a();
    return;
    label353:
    int j;
    if ((b.m & 0xFF) == 1L)
    {
      e = "WiFi";
      if (b.a == 5)
      {
        new Thread(new f(b, c, f.b.e, h, i)).start();
        return;
      }
      if (b.a != 6) {
        break label1707;
      }
      new Thread(new f(b, c, f.b.d, h, i)).start();
      return;
      if (j < 2)
      {
        if (b.a == 1)
        {
          new Thread(new f(b, c, f.b.a, 2, j)).start();
          break label1712;
        }
        if (b.a == 2)
        {
          new Thread(new f(b, c, f.b.b, 2, j)).start();
          break label1712;
        }
        if (b.a == 3)
        {
          new Thread(new f(b, c, f.b.c, 2, j)).start();
          break label1712;
        }
        a();
      }
    }
    else
    {
      e = "WiFi";
      if (b.a == 1)
      {
        new Thread(new f(b, c, f.b.a, h, i)).start();
        return;
      }
      if (b.a == 2)
      {
        new Thread(new f(b, c, f.b.b, h, i)).start();
        return;
      }
      if (b.a == 3)
      {
        new Thread(new f(b, c, f.b.c, h, i)).start();
        return;
      }
      if (b.a == 5)
      {
        new Thread(new f(b, c, f.b.e, h, i)).start();
        return;
      }
      if (b.a == 6)
      {
        new Thread(new f(b, c, f.b.d, h, i)).start();
        return;
      }
      a();
      return;
      label817:
      if ((!NetConnInfoCenter.isWifiConn()) || (NetConnInfoCenter.getWifiStrength() < 10))
      {
        e = "NotWiFi";
        if (b.a == 1)
        {
          new Thread(new c(b, c, c.b.a, h, i)).start();
          return;
        }
        if (b.a == 2)
        {
          new Thread(new c(b, c, c.b.b, h, i)).start();
          return;
        }
        if (b.a == 3)
        {
          new Thread(new c(b, c, c.b.c, h, i)).start();
          return;
        }
        if (b.a == 5)
        {
          new Thread(new c(b, c, c.b.e, h, i)).start();
          return;
        }
        if (b.a == 6)
        {
          new Thread(new c(b, c, c.b.d, h, i)).start();
          return;
        }
        a();
        return;
      }
      if ((b.m & 0xFF) == 1L)
      {
        e = "WiFi";
        if (b.a == 5)
        {
          new Thread(new c(b, c, c.b.e, h, i)).start();
          return;
        }
        if (b.a != 6) {
          break label1719;
        }
        new Thread(new c(b, c, c.b.d, h, i)).start();
        return;
      }
    }
    for (;;)
    {
      label1689:
      label1698:
      if (j < 2)
      {
        if (b.a == 1)
        {
          new Thread(new c(b, c, c.b.a, 2, j)).start();
          break label1724;
        }
        if (b.a == 2)
        {
          new Thread(new c(b, c, c.b.b, 2, j)).start();
          break label1724;
        }
        if (b.a == 3)
        {
          new Thread(new c(b, c, c.b.c, 2, j)).start();
          break label1724;
        }
        a();
        return;
        e = "WiFi";
        if (b.a == 1)
        {
          new Thread(new c(b, c, c.b.a, h, i)).start();
          return;
        }
        if (b.a == 2)
        {
          new Thread(new c(b, c, c.b.b, h, i)).start();
          return;
        }
        if (b.a == 3)
        {
          new Thread(new c(b, c, c.b.c, h, i)).start();
          return;
        }
        if (b.a == 5)
        {
          new Thread(new c(b, c, c.b.e, h, i)).start();
          return;
        }
        if (b.a == 6)
        {
          new Thread(new c(b, c, c.b.d, h, i)).start();
          return;
        }
        a();
        return;
        label1520:
        if (paramFromServiceMsg.equals("MtuTest"))
        {
          c = (b)localUniPacket.getByClass("MtuTest", new b());
          QLog.d("MSF.C.QualityTestManager", 1, "MtuTest getted, start now");
          if (c.a == 1)
          {
            new Thread(new c(b, c, c.b.a, h, i)).start();
            return;
          }
          if (c.a == 2)
          {
            new Thread(new c(b, c, c.b.b, h, i)).start();
            return;
          }
          if (c.a == 3)
          {
            new Thread(new c(b, c, c.b.c, h, i)).start();
            return;
          }
          a();
          return;
          QLog.d("MSF.C.QualityTestManager", 1, "QualityManager getted too frequently drop now");
          return;
          QLog.d("MSF.C.QualityTestManager", 1, "QualityManager getted, return fail do nothing");
        }
      }
      return;
      label1707:
      j = 0;
      break;
      label1712:
      j += 1;
      break;
      label1719:
      j = 0;
      continue;
      label1724:
      j += 1;
    }
  }
  
  public static void a(boolean paramBoolean, d paramd, b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap;
    if (d.getStatReporter() != null)
    {
      localHashMap = new HashMap();
      if (paramd == null) {
        break label395;
      }
      localHashMap.put("TestType", "QualityTest");
      localHashMap.put("ProtoType", "" + paramd.a);
      paramb = new StringBuilder().append("");
      if (paramd.b == null) {
        break label377;
      }
      j = paramd.b.size();
      localHashMap.put("IpNum", j);
      localHashMap.put("PkgNum", "" + paramd.c);
      paramb = new StringBuilder().append("");
      if (paramd.e == null) {
        break label383;
      }
      j = paramd.e.length;
      localHashMap.put("PkgDataSize", j);
      localHashMap.put("RepeatTimes", "" + paramd.f);
      paramb = new StringBuilder().append("");
      if (paramd.g == null) {
        break label389;
      }
      j = paramd.g.length;
      localHashMap.put("HeadDataSize", j);
      localHashMap.put("testPacketRecved", "" + paramInt1);
      localHashMap.put("testPacketSend", "" + paramInt2);
      localHashMap.put("network_type", String.valueOf(paramInt3));
    }
    label377:
    label383:
    while (paramb == null) {
      for (;;)
      {
        d.getStatReporter().a("evt_net_test_result", paramBoolean, 0L, paramInt1 + paramInt2, localHashMap, false, false);
        d.getStatReporter().a("dim.Msf.NetTestResult", paramBoolean, 0L, paramInt1 + paramInt2, localHashMap, false, false);
        return;
        j = -1;
        continue;
        j = -1;
        continue;
        j = -1;
      }
    }
    label389:
    label395:
    localHashMap.put("TestType", "MtuTest");
    localHashMap.put("ProtoType", "" + paramb.a);
    paramd = new StringBuilder().append("");
    if (paramb.b != null) {}
    for (int j = paramb.b.size();; j = -1)
    {
      localHashMap.put("IpNum", j);
      localHashMap.put("PkgNum", "" + paramb.g);
      localHashMap.put("PkgDataSize", b(paramb.c));
      localHashMap.put("RepeatTimes", a(paramb.d));
      localHashMap.put("HeadDataSize", b(paramb.e));
      localHashMap.put("testPacketRecved", "" + paramInt1);
      localHashMap.put("testPacketSend", "" + paramInt2);
      localHashMap.put("network_type", String.valueOf(paramInt3));
      break;
    }
  }
  
  private static String b(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      localObject = "";
    }
    Iterator localIterator;
    do
    {
      return localObject;
      localIterator = paramArrayList.iterator();
      paramArrayList = "";
      localObject = paramArrayList;
    } while (!localIterator.hasNext());
    Object localObject = (byte[])localIterator.next();
    if (localObject != null) {}
    for (paramArrayList = paramArrayList + localObject.length + ";";; paramArrayList = paramArrayList + "-1;") {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.k
 * JD-Core Version:    0.7.0.1
 */