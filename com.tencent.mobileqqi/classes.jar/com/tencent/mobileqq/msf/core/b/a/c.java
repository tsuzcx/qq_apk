package com.tencent.mobileqq.msf.core.b.a;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.msf.service.protocol.push.a.b;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class c
{
  static final String a = "MSF.C.QualityTestManager";
  public static com.tencent.msf.service.protocol.push.a.c b = null;
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
        break label710;
      }
      if (b != null) {
        break label701;
      }
      localUniPacket = new UniPacket(true);
      localUniPacket.decode(paramFromServiceMsg.getWupBuffer());
      paramFromServiceMsg = localUniPacket.getFuncName();
      if (!paramFromServiceMsg.equals("QualityTest")) {
        break label536;
      }
      b = (com.tencent.msf.service.protocol.push.a.c)localUniPacket.getByClass("QualityTest", new com.tencent.msf.service.protocol.push.a.c());
      QLog.d("MSF.C.QualityTestManager", 1, "Quality getted, start now " + b.a);
      if ((NetConnInfoCenterImpl.isWifiConn()) && (NetConnInfoCenter.getWifiStrength() >= 10)) {
        break label252;
      }
      e = "NotWiFi";
      if (b.a == 1)
      {
        new Thread(new a(b, c, a.a.a, h, i)).start();
        return;
      }
      if (b.a == 2)
      {
        new Thread(new a(b, c, a.a.b, h, i)).start();
        return;
      }
    }
    catch (Throwable paramFromServiceMsg)
    {
      QLog.d("MSF.C.QualityTestManager", 1, "QualityManager error, ", paramFromServiceMsg);
      return;
    }
    label252:
    int j;
    if (b.a == 3)
    {
      new Thread(new a(b, c, a.a.c, h, i)).start();
      return;
      if ((b.m & 0xFF) == 1L)
      {
        e = "WiFi";
        j = 0;
      }
    }
    for (;;)
    {
      if (j < 2)
      {
        if (b.a == 1)
        {
          new Thread(new a(b, c, a.a.a, 2, j)).start();
          break label719;
        }
        if (b.a == 2)
        {
          new Thread(new a(b, c, a.a.b, 2, j)).start();
          break label719;
        }
        if (b.a != 3) {
          break label719;
        }
        new Thread(new a(b, c, a.a.c, 2, j)).start();
        break label719;
        e = "WiFi";
        if (b.a == 1)
        {
          new Thread(new a(b, c, a.a.a, h, i)).start();
          return;
        }
        if (b.a == 2)
        {
          new Thread(new a(b, c, a.a.b, h, i)).start();
          return;
        }
        if (b.a == 3)
        {
          new Thread(new a(b, c, a.a.c, h, i)).start();
          return;
          label536:
          if (paramFromServiceMsg.equals("MtuTest"))
          {
            c = (b)localUniPacket.getByClass("MtuTest", new b());
            QLog.d("MSF.C.QualityTestManager", 1, "MtuTest getted, start now");
            if (c.a == 1)
            {
              new Thread(new a(b, c, a.a.a, h, i)).start();
              return;
            }
            if (c.a == 2)
            {
              new Thread(new a(b, c, a.a.b, h, i)).start();
              return;
            }
            if (c.a == 3)
            {
              new Thread(new a(b, c, a.a.c, h, i)).start();
              return;
              label701:
              QLog.d("MSF.C.QualityTestManager", 1, "QualityManager getted too frequently drop now");
              return;
              label710:
              QLog.d("MSF.C.QualityTestManager", 1, "QualityManager getted, return fail do nothing");
            }
          }
        }
      }
      return;
      label719:
      j += 1;
    }
  }
  
  public static void a(boolean paramBoolean, com.tencent.msf.service.protocol.push.a.c paramc, b paramb, int paramInt1, int paramInt2)
  {
    int j = -1;
    HashMap localHashMap = new HashMap();
    int k;
    if (paramc != null)
    {
      localHashMap.put("TestType", "QualityTest");
      localHashMap.put("ProtoType", "" + paramc.a);
      paramb = new StringBuilder().append("");
      if (paramc.b != null)
      {
        k = paramc.b.size();
        localHashMap.put("IpNum", k);
        localHashMap.put("PkgNum", "" + paramc.c);
        paramb = new StringBuilder().append("");
        if (paramc.e == null) {
          break label334;
        }
        k = paramc.e.length;
        label159:
        localHashMap.put("PkgDataSize", k);
        localHashMap.put("RepeatTimes", "" + paramc.f);
        paramb = new StringBuilder().append("");
        if (paramc.g != null) {
          j = paramc.g.length;
        }
        localHashMap.put("HeadDataSize", j);
        localHashMap.put("testPacketRecved", "" + paramInt1);
        localHashMap.put("testPacketSend", "" + paramInt2);
      }
    }
    for (;;)
    {
      d.getStatReporter().a("dim.Msf.NetTestResult", paramBoolean, 0L, paramInt1 + paramInt2, localHashMap, false, false);
      return;
      k = -1;
      break;
      label334:
      k = -1;
      break label159;
      if (paramb != null)
      {
        localHashMap.put("TestType", "MtuTest");
        localHashMap.put("ProtoType", "" + paramb.a);
        paramc = new StringBuilder().append("");
        if (paramb.b != null) {
          j = paramb.b.size();
        }
        localHashMap.put("IpNum", j);
        localHashMap.put("PkgNum", "" + paramb.g);
        localHashMap.put("PkgDataSize", b(paramb.c));
        localHashMap.put("RepeatTimes", a(paramb.d));
        localHashMap.put("HeadDataSize", b(paramb.e));
        localHashMap.put("testPacketRecved", "" + paramInt1);
        localHashMap.put("testPacketSend", "" + paramInt2);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.a.c
 * JD-Core Version:    0.7.0.1
 */