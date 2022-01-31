package com.tencent.mobileqq.msf.core.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.l;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.n;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.h.a;
import com.tencent.msf.service.protocol.h.f;
import com.tencent.msf.service.protocol.h.h;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class d
{
  public static final String a = "MSF.C.SsoListManager";
  private static final String h = "__loginSdk_ssoWifilist";
  private static final String i = "__loginSdk_ssoMobilelist";
  private static final String j = "__loginSdk_ssolist";
  private static final String k = "wifiused";
  private static final int l = 10;
  private static final String m = "wifiname";
  private static final String n = "wifitime";
  private static final String o = "wifiUsedCount";
  CopyOnWriteArrayList b;
  CopyOnWriteArrayList c;
  MsfCore d;
  private CopyOnWriteArrayList e = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList f = new CopyOnWriteArrayList();
  private ConcurrentHashMap g = new ConcurrentHashMap();
  private com.tencent.mobileqq.msf.sdk.k p = new com.tencent.mobileqq.msf.sdk.k(1000);
  private Thread q = null;
  
  public d(MsfCore paramMsfCore)
  {
    this.d = paramMsfCore;
  }
  
  private void a(com.tencent.msf.service.protocol.h.e parame)
  {
    Object localObject;
    Iterator localIterator;
    if ((parame.b != null) && (parame.b.length > 0))
    {
      localObject = new JceInputStream(parame.b);
      parame = new h();
      parame.readFrom((JceInputStream)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.SsoListManager", 2, "recv ssoList Push.");
      }
      if (!NetConnInfoCenterImpl.isWifiConn()) {
        break label141;
      }
      localObject = new ArrayList();
      localIterator = parame.b.iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add(com.tencent.mobileqq.msf.core.d.a((com.tencent.msf.service.protocol.h.i)localIterator.next(), 0));
      }
      a((ArrayList)localObject, false, true);
    }
    for (;;)
    {
      if (parame.c == 1)
      {
        QLog.w("MSF.C.SsoListManager", 1, "set sso reconnect is true.");
        this.d.isReconnectSso.set(true);
      }
      return;
      label141:
      localObject = new ArrayList();
      localIterator = parame.a.iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add(com.tencent.mobileqq.msf.core.d.a((com.tencent.msf.service.protocol.h.i)localIterator.next(), 1));
      }
      b((ArrayList)localObject, false, true);
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, com.tencent.msf.service.protocol.h.e parame)
  {
    a locala;
    if ((parame.b != null) && (parame.b.length > 0))
    {
      JceInputStream localJceInputStream = new JceInputStream(parame.b);
      locala = new a();
      locala.readFrom(localJceInputStream);
      if (locala.a != 2) {
        break label99;
      }
      com.tencent.mobileqq.msf.core.k.a().setConfig("LOGLEVEL_", String.valueOf(locala.d));
      com.tencent.mobileqq.msf.core.k.a().setConfig("LOGLEVELTIME", String.valueOf(System.currentTimeMillis()));
      n.b(locala.d);
      MsfCore.initAppProMsg("*", paramFromServiceMsg.getAppId());
    }
    label99:
    do
    {
      do
      {
        return;
      } while (locala.a != 1);
      locala.f = parame.c;
      this.p.offer(locala);
    } while (this.q != null);
    this.q = new e(this);
    this.q.start();
  }
  
  private void a(String paramString, ArrayList paramArrayList)
  {
    int i1 = 0;
    if (paramString != null) {}
    for (Object localObject = paramString;; localObject = "") {
      try
      {
        if (paramString.length() != 0)
        {
          paramString = ((String)localObject).split(";");
          int i2 = paramString.length;
          while (i1 < i2)
          {
            localObject = paramString[i1];
            if (((String)localObject).length() > 0)
            {
              localObject = com.tencent.mobileqq.msf.core.d.a((String)localObject);
              ((com.tencent.mobileqq.msf.core.d)localObject).a(false);
              paramArrayList.add(localObject);
            }
            i1 += 1;
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public static String b()
  {
    Object localObject = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).getType() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.SsoListManager", 2, "connect to mobile network " + ((NetworkInfo)localObject).getSubtypeName());
        }
        localObject = ((NetworkInfo)localObject).getExtraInfo();
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.SsoListManager", 2, "current apn:" + (String)localObject);
        }
        return localObject;
      }
      return null;
    }
    return null;
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, com.tencent.msf.service.protocol.h.e parame)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("", paramFromServiceMsg.getUin(), "ConfigPushSvc.PushResp");
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    localUniPacket.setServantName("QQService.ConfigPushSvc.MainServant");
    localUniPacket.setFuncName("PushResp");
    f localf = new f();
    localf.b = parame.c;
    localf.a = parame.a;
    if (parame.a == 3) {
      localf.c = parame.b;
    }
    localUniPacket.put("PushResp", localf);
    localToServiceMsg.putWupBuffer(localUniPacket.encode());
    localToServiceMsg.setAppId(this.d.getMsfAppid());
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.setRequestSsoSeq(paramFromServiceMsg.getRequestSsoSeq());
    try
    {
      this.d.sendSsoMsg(localToServiceMsg);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("MSF.C.SsoListManager", 2, "send push sso resp error " + paramFromServiceMsg, paramFromServiceMsg);
    }
  }
  
  /* Error */
  public static String c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 263	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   6: ldc_w 389
    //   9: invokevirtual 271	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   12: checkcast 391	android/net/wifi/WifiManager
    //   15: invokevirtual 395	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual 400	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   23: astore_2
    //   24: aload_2
    //   25: ifnonnull +10 -> 35
    //   28: aconst_null
    //   29: astore_1
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: aload_1
    //   36: invokevirtual 400	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   39: ldc_w 402
    //   42: ldc_w 256
    //   45: invokevirtual 406	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   48: astore_1
    //   49: aload_1
    //   50: ldc_w 408
    //   53: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: istore_0
    //   57: iload_0
    //   58: ifeq -28 -> 30
    //   61: aconst_null
    //   62: astore_1
    //   63: goto -33 -> 30
    //   66: astore_1
    //   67: ldc 2
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   56	2	0	bool	boolean
    //   18	45	1	localObject1	Object
    //   66	5	1	localObject2	Object
    //   23	2	2	str	String
    // Exception table:
    //   from	to	target	type
    //   3	24	66	finally
    //   35	57	66	finally
  }
  
  public void a()
  {
    this.b = new CopyOnWriteArrayList();
    this.c = new CopyOnWriteArrayList();
    this.c.add(com.tencent.mobileqq.msf.core.d.a("socket://211.136.236.89:14000#46000_46002:0:1"));
    this.c.add(com.tencent.mobileqq.msf.core.d.a("socket://211.136.236.90:14000#46000_46002:0:1"));
    this.c.add(com.tencent.mobileqq.msf.core.d.a("socket://112.90.140.220:14000#46001:0:1"));
    this.c.add(com.tencent.mobileqq.msf.core.d.a("socket://112.90.140.221:14000#46001:0:1"));
    this.c.add(com.tencent.mobileqq.msf.core.d.a("socket://113.108.90.48:14000#46003:0:1"));
    this.c.add(com.tencent.mobileqq.msf.core.d.a("socket://113.108.90.49:14000#46003:0:1"));
    this.c.add(com.tencent.mobileqq.msf.core.d.a("socket://202.55.10.141:8080#46000_46002_46001_46003:0:1"));
    this.c.add(com.tencent.mobileqq.msf.core.d.a("socket://202.55.10.141:14000#46000_46002_46001_46003:0:1"));
    this.b.add(com.tencent.mobileqq.msf.core.d.a("socket://msfwifi.3g.qq.com:8080#00000:0:1"));
    this.b.add(com.tencent.mobileqq.msf.core.d.a("socket://113.108.90.53:8080#00000:0:1"));
    this.b.add(com.tencent.mobileqq.msf.core.d.a("socket://120.196.210.32:8080#00000:0:1"));
    this.b.add(com.tencent.mobileqq.msf.core.d.a("socket://120.196.210.30:8080#00000:0:1"));
    this.b.add(com.tencent.mobileqq.msf.core.d.a("socket://112.90.140.143:8080#00000:0:1"));
    this.b.add(com.tencent.mobileqq.msf.core.d.a("socket://112.64.234.200:8080#00000:0:1"));
    this.b.add(com.tencent.mobileqq.msf.core.d.a("socket://202.55.10.141:8080#00000:0:1"));
    this.b.add(com.tencent.mobileqq.msf.core.d.a("socket://202.55.10.141:14000#00000:0:1"));
    d();
    g();
    a(c());
  }
  
  public void a(com.tencent.mobileqq.msf.core.d paramd)
  {
    for (;;)
    {
      try
      {
        if (paramd.k)
        {
          if (this.e.remove(paramd))
          {
            this.e.add(paramd);
            QLog.d("MSF.C.SsoListManager", 1, " set " + paramd + " at wifiList last.");
            return;
          }
          QLog.d("MSF.C.SsoListManager", 1, " not found " + paramd + " at wifiList.");
          continue;
        }
        if (!this.f.remove(paramd)) {
          break label159;
        }
      }
      finally {}
      this.f.add(paramd);
      QLog.d("MSF.C.SsoListManager", 1, " set " + paramd + " at mobileSsos last.");
      continue;
      label159:
      QLog.d("MSF.C.SsoListManager", 1, " not found " + paramd + " at mobileSsos.");
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      localObject = new UniPacket(true);
      ((UniPacket)localObject).setEncodeName("utf-8");
      ((UniPacket)localObject).decode(paramFromServiceMsg.getWupBuffer());
      localObject = (com.tencent.msf.service.protocol.h.e)((UniPacket)localObject).getByClass("PushReq", new com.tencent.msf.service.protocol.h.e());
      if (((com.tencent.msf.service.protocol.h.e)localObject).a == 1) {
        a((com.tencent.msf.service.protocol.h.e)localObject);
      }
      for (;;)
      {
        b(paramFromServiceMsg, (com.tencent.msf.service.protocol.h.e)localObject);
        return;
        if (((com.tencent.msf.service.protocol.h.e)localObject).a != 2) {
          break;
        }
        MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
        paramFromServiceMsg.setMsfCommand(MsfCommand.onRecvConfigPush);
        this.d.addRespToQuque(null, paramFromServiceMsg);
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      Object localObject;
      while (QLog.isColorLevel())
      {
        QLog.i("MSF.C.SsoListManager", 2, "onRecvSsoPush error " + paramFromServiceMsg, paramFromServiceMsg);
        return;
        if (((com.tencent.msf.service.protocol.h.e)localObject).a == 3) {
          a(paramFromServiceMsg, (com.tencent.msf.service.protocol.h.e)localObject);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    label481:
    label484:
    label487:
    label490:
    for (;;)
    {
      try
      {
        Object localObject2 = BaseApplication.getContext().getSharedPreferences("wifiused", 0);
        long l1 = System.currentTimeMillis();
        Object localObject1;
        int i1;
        if (this.g.containsKey(paramString))
        {
          this.g.put(paramString, Long.valueOf(l1));
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.SsoListManager", 2, "find ssid: " + paramString + " update time = " + l1);
          }
          paramString = this.g.entrySet().iterator();
          localObject1 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject1).putInt("wifiUsedCount", this.g.size());
          i1 = 0;
          if (paramString.hasNext())
          {
            localObject2 = (Map.Entry)paramString.next();
            if (localObject2 == null) {
              continue;
            }
            l1 = ((Long)((Map.Entry)localObject2).getValue()).longValue();
            localObject2 = (String)((Map.Entry)localObject2).getKey();
            if (localObject2 == null) {
              break label481;
            }
            ((SharedPreferences.Editor)localObject1).putString("wifiname" + i1, (String)localObject2);
            ((SharedPreferences.Editor)localObject1).putLong("wifitime" + i1, l1);
            i1 += 1;
            break label487;
          }
        }
        else
        {
          i1 = this.g.size();
          l1 = System.currentTimeMillis();
          localObject1 = null;
          if (i1 >= 10)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.SsoListManager", 2, "too much ssid need to delete one find Least Recently Used now...");
            }
            Iterator localIterator = this.g.entrySet().iterator();
            if (localIterator.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              if (localEntry == null) {
                continue;
              }
              long l2 = ((Long)localEntry.getValue()).longValue();
              if (l2 >= l1) {
                break label484;
              }
              localObject1 = (String)localEntry.getKey();
              l1 = l2;
              break label490;
            }
            if (localObject1 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.SsoListManager", 2, "Least Recently Used ssid find delete now: " + (String)localObject1);
              }
              this.g.remove(localObject1);
              localObject1 = "__loginSdk_ssoWifilist_" + (String)localObject1;
              com.tencent.mobileqq.msf.core.k.a().n_removeConfig((String)localObject1);
            }
          }
          this.g.put(paramString, Long.valueOf(System.currentTimeMillis()));
          continue;
        }
        ((SharedPreferences.Editor)localObject1).commit();
      }
      finally {}
      break;
      break label487;
      break label490;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null) {}
    try
    {
      if (paramArrayList.size() == 0)
      {
        QLog.w("MSF.C.SsoListManager", 2, "setTestSso serviceLists is null...");
        throw new RuntimeException("setTestSso serviceLists is null...");
      }
    }
    finally {}
    this.e.clear();
    this.f.clear();
    this.b.clear();
    this.c.clear();
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mobileqq.msf.core.d locald = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject).next();
      this.f.add(locald);
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject = (com.tencent.mobileqq.msf.core.d)paramArrayList.next();
      this.e.add(localObject);
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        if ((!this.d.sender.a.o().equals("")) || (BaseConstants.isUseDebugSso))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.SsoListManager", 4, "debug mode, skip store sso ");
          }
          return;
        }
        this.e.clear();
        localObject = new StringBuffer();
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          com.tencent.mobileqq.msf.core.d locald = (com.tencent.mobileqq.msf.core.d)paramArrayList.next();
          if (locald == null) {
            continue;
          }
          ((StringBuffer)localObject).append(locald.toString() + ";");
          this.e.add(locald);
          continue;
        }
        paramArrayList = ((StringBuffer)localObject).toString();
      }
      finally {}
      Object localObject = c();
      if (localObject != null)
      {
        localObject = "__loginSdk_ssoWifilist_" + (String)localObject;
        com.tencent.mobileqq.msf.core.k.a().n_setConfig((String)localObject, paramArrayList);
        if (paramBoolean2) {
          QLog.d("MSF.C.SsoListManager", 1, "save push wifisso for " + paramArrayList);
        } else {
          QLog.d("MSF.C.SsoListManager", 1, "save http get wifisso for " + paramArrayList);
        }
      }
    }
  }
  
  public void b(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.SsoListManager", 2, "onRecvSsoHelloPush from:" + paramFromServiceMsg);
    }
    for (;;)
    {
      try
      {
        localToServiceMsg = new ToServiceMsg("", paramFromServiceMsg.getUin(), "SSO.HelloPush");
        localToServiceMsg.putWupBuffer(paramFromServiceMsg.getWupBuffer());
        localToServiceMsg.setAppId(this.d.getMsfAppid());
        localToServiceMsg.setNeedCallback(false);
        localToServiceMsg.setTimeout(30000L);
        localToServiceMsg.setRequestSsoSeq(paramFromServiceMsg.getRequestSsoSeq());
      }
      catch (Exception paramFromServiceMsg)
      {
        ToServiceMsg localToServiceMsg;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("MSF.C.SsoListManager", 2, "onRecvSsoHelloPush error " + paramFromServiceMsg, paramFromServiceMsg);
      }
      try
      {
        this.d.sendSsoMsg(localToServiceMsg);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("MSF.C.SsoListManager", 2, "send sso hello push resp error " + paramFromServiceMsg, paramFromServiceMsg);
          return;
        }
      }
    }
  }
  
  public void b(ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        if ((!this.d.sender.a.o().equals("")) || (BaseConstants.isUseDebugSso))
        {
          QLog.d("MSF.C.SsoListManager", 4, "debug mode, skip store sso ");
          return;
        }
        this.f.clear();
        localObject = new StringBuffer();
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          com.tencent.mobileqq.msf.core.d locald = (com.tencent.mobileqq.msf.core.d)paramArrayList.next();
          if (locald == null) {
            continue;
          }
          locald.a(false);
          ((StringBuffer)localObject).append(locald.toString() + ";");
          this.f.add(locald);
          continue;
        }
        paramArrayList = ((StringBuffer)localObject).toString();
      }
      finally {}
      Object localObject = b();
      if (localObject != null)
      {
        localObject = "__loginSdk_ssoMobilelist_" + (String)localObject;
        com.tencent.mobileqq.msf.core.k.a().n_setConfig((String)localObject, paramArrayList);
        if (paramBoolean2) {
          QLog.d("MSF.C.SsoListManager", 1, "save push mobilesso for " + (String)localObject + " " + paramArrayList);
        } else {
          QLog.d("MSF.C.SsoListManager", 1, "save http mobilesso for " + (String)localObject + " " + paramArrayList);
        }
      }
    }
  }
  
  public void d()
  {
    int i1 = 0;
    try
    {
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("wifiused", 0);
      int i2 = localSharedPreferences.getInt("wifiUsedCount", 0);
      while (i1 < i2)
      {
        String str = localSharedPreferences.getString("wifiname" + i1, "");
        long l1 = localSharedPreferences.getLong("wifitime" + i1, 0L);
        if ((str != null) && (l1 > 0L))
        {
          this.g.put(str, Long.valueOf(l1));
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.SsoListManager", 2, "get a ssid " + str + " time = " + l1);
          }
        }
        i1 += 1;
      }
      return;
    }
    finally {}
  }
  
  public void e()
  {
    Object localObject1;
    Object localObject2;
    int i2;
    Object localObject3;
    for (;;)
    {
      try
      {
        localObject1 = new ArrayList();
        String str1 = b();
        if (str1 == null) {
          return;
        }
        str1 = "__loginSdk_ssoMobilelist_" + str1;
        localObject2 = com.tencent.mobileqq.msf.core.k.a().getConfig(str1);
        i2 = 0;
        if ((localObject2 != null) && (((String)localObject2).length() != 0)) {
          break label368;
        }
        localObject2 = com.tencent.mobileqq.msf.core.k.a().getConfig("__loginSdk_ssolist");
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.SsoListManager", 2, "loadSsoStoreForCurrentAPN get a new apn, ssoStore from __loginSdk_ssolist " + (String)localObject2);
        }
        if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
          break;
        }
        localObject3 = new ArrayList();
        a((String)localObject2, (ArrayList)localObject3);
        localObject2 = ((ArrayList)localObject3).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label460;
        }
        localObject3 = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject2).next();
        if (((com.tencent.mobileqq.msf.core.d)localObject3).h.indexOf("00000") <= -1) {
          ((ArrayList)localObject1).add(localObject3);
        } else {
          ((com.tencent.mobileqq.msf.core.d)localObject3).a(true);
        }
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.SsoListManager", 2, "loadSsoStoreForCurrentAPN a new apn get from defaultMobileSso mobile: " + str2 + " " + this.c);
    }
    ((ArrayList)localObject1).addAll(this.c);
    for (;;)
    {
      if (((ArrayList)localObject1).size() > 0)
      {
        this.f.clear();
        this.f.addAll((Collection)localObject1);
      }
      if (i1 == 0) {
        break;
      }
      localObject1 = new StringBuffer();
      localObject2 = this.f.iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject2).next();
          ((StringBuffer)localObject1).append(((com.tencent.mobileqq.msf.core.d)localObject3).toString() + ";");
          continue;
          label368:
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.SsoListManager", 2, "a old apn loadSsoStoreForCurrentAPN mobile: " + str2 + " " + (String)localObject2);
          }
          i1 = i2;
          if (localObject2 == null) {
            break;
          }
          i1 = i2;
          if (((String)localObject2).length() <= 0) {
            break;
          }
          a((String)localObject2, (ArrayList)localObject1);
          i1 = i2;
          break;
        }
      }
      localObject1 = ((StringBuffer)localObject1).toString();
      com.tencent.mobileqq.msf.core.k.a().n_setConfig(str2, (String)localObject1);
      break;
      label460:
      int i1 = 1;
    }
  }
  
  public void f()
  {
    int i2 = 0;
    Object localObject1;
    String str3;
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      try
      {
        localObject1 = new ArrayList();
        String str1 = c();
        if (str1 == null) {
          return;
        }
        str3 = "__loginSdk_ssoWifilist_" + str1;
        localObject2 = com.tencent.mobileqq.msf.core.k.a().getConfig(str3);
        if ((localObject2 != null) && (((String)localObject2).length() != 0)) {
          break label365;
        }
        localObject2 = com.tencent.mobileqq.msf.core.k.a().getConfig("__loginSdk_ssolist");
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.SsoListManager", 2, "loadSsoStoreForCurrentSSID get a new ssid, ssoStore from __loginSdk_ssolist" + (String)localObject2);
        }
        if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
          break;
        }
        localObject3 = new ArrayList();
        a((String)localObject2, (ArrayList)localObject3);
        localObject2 = ((ArrayList)localObject3).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label458;
        }
        localObject3 = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject2).next();
        if (((com.tencent.mobileqq.msf.core.d)localObject3).h.indexOf("00000") > -1) {
          ((ArrayList)localObject1).add(localObject3);
        } else {
          ((com.tencent.mobileqq.msf.core.d)localObject3).a(false);
        }
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.SsoListManager", 2, "loadSsoStoreForCurrentSSID a new ssid get from defaultWifiSso wifi: " + str3 + this.b);
    }
    ((ArrayList)localObject1).addAll(this.b);
    for (;;)
    {
      if (((ArrayList)localObject1).size() > 0)
      {
        this.e.clear();
        this.e.addAll((Collection)localObject1);
      }
      if (i1 != 0)
      {
        localObject1 = new StringBuffer();
        localObject2 = this.e.iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject2).next();
            ((StringBuffer)localObject1).append(((com.tencent.mobileqq.msf.core.d)localObject3).toString() + ";");
            continue;
            label365:
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.SsoListManager", 2, "a old ssid loadSsoStoreForCurrentSSID wifi: " + str3 + (String)localObject2);
            }
            i1 = i2;
            if (localObject2 == null) {
              break;
            }
            i1 = i2;
            if (((String)localObject2).length() <= 0) {
              break;
            }
            a((String)localObject2, (ArrayList)localObject1);
            i1 = i2;
            break;
          }
        }
        localObject1 = ((StringBuffer)localObject1).toString();
        com.tencent.mobileqq.msf.core.k.a().n_setConfig(str3, (String)localObject1);
      }
      a(str2);
      break;
      label458:
      int i1 = 1;
    }
  }
  
  public void g()
  {
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      Object localObject2;
      String str3;
      String str4;
      try
      {
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        Object localObject1 = c();
        if (localObject1 == null) {
          break label428;
        }
        localObject2 = "__loginSdk_ssoWifilist" + "_";
        localObject1 = (String)localObject2 + (String)localObject1;
        str3 = com.tencent.mobileqq.msf.core.k.a().getConfig((String)localObject1);
        localObject2 = "__loginSdk_ssoMobilelist";
        str4 = b();
        if (str4 != null) {
          localObject2 = "__loginSdk_ssoMobilelist" + "_" + str4;
        }
        str4 = com.tencent.mobileqq.msf.core.k.a().getConfig((String)localObject2);
        if (((str3 != null) && (str3.length() != 0)) || ((str4 != null) && (str4.length() != 0))) {
          break label285;
        }
        localObject1 = com.tencent.mobileqq.msf.core.k.a().getConfig("__loginSdk_ssolist");
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.SsoListManager", 2, "load ssoStore " + (String)localObject1);
        }
        if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
          break label406;
        }
        localObject2 = new ArrayList();
        a((String)localObject1, (ArrayList)localObject2);
        localObject1 = ((ArrayList)localObject2).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label406;
        }
        localObject2 = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject1).next();
        if (((com.tencent.mobileqq.msf.core.d)localObject2).h.indexOf("00000") > -1)
        {
          localArrayList1.add(localObject2);
          continue;
        }
        ((com.tencent.mobileqq.msf.core.d)localObject2).a(false);
      }
      finally {}
      localArrayList2.add(localObject2);
      continue;
      label285:
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.SsoListManager", 2, "load wifiStore wifi: " + str1 + ":" + str3);
        QLog.d("MSF.C.SsoListManager", 2, "load mobileStore " + (String)localObject2 + ":" + str4);
      }
      if ((str3 != null) && (str3.length() > 0)) {
        a(str3, localArrayList1);
      }
      if ((str4 != null) && (str4.length() > 0)) {
        a(str4, localArrayList2);
      }
      label406:
      this.e.addAll(localArrayList1);
      this.f.addAll(localArrayList2);
      return;
      label428:
      String str2 = "__loginSdk_ssoWifilist";
    }
  }
  
  public CopyOnWriteArrayList h()
  {
    if (this.e.size() == 0) {
      return this.b;
    }
    return this.e;
  }
  
  public CopyOnWriteArrayList i()
  {
    if (this.f.size() == 0) {
      return this.c;
    }
    return this.f;
  }
  
  public CopyOnWriteArrayList j()
  {
    return this.b;
  }
  
  public CopyOnWriteArrayList k()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.d
 * JD-Core Version:    0.7.0.1
 */