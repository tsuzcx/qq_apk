package com.tencent.mobileqq.msf.core.a;

import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.b.i;
import com.tencent.mobileqq.msf.core.l;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.f.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.report.StrupBuff;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
{
  static long A = 0L;
  static long B = 0L;
  static long C = 0L;
  static long D = 0L;
  public static final int E = 100;
  public static long F = 0L;
  public static long G = 0L;
  public static final int H = 1;
  public static final int I = 16;
  private static final byte[] K = { -16, 68, 31, 95, -12, 45, -91, -113, -36, -9, -108, -102, -70, 98, -44, 17 };
  public static final String a = "ConfigService.ClientReq";
  static final String b = "MSF.C.ConfigManager";
  public static final String c = "__loginSdk_iconf_UserConf";
  public static final String d = "__loginSdk_iconf_AppConf";
  public static final String e = "__loginSdk_iconf_UserCommCon";
  public static final String f = "__loginSdk_mobilessotime";
  public static final String g = "__loginSdk_wifissotime";
  public static final String h = "__loginSdk_checkmobilessotime";
  public static final String i = "__loginSdk_checkwifissotime";
  public static final String j = "_msf_isBootingKey";
  public static final int k = 32;
  public static final String l = "__loginSdk_iConfAppidTimeKey";
  public static final String m = "__loginSdk_iConfSdkLastTimeKey";
  public static final String n = "__loginSdk_iConfGetEspLastTimeKe";
  public static final String o = "__msf_isAutoBootKey";
  public static final boolean p = true;
  static ConcurrentHashMap q = new ConcurrentHashMap();
  public static HashSet r = new HashSet();
  public static HashSet s = new HashSet();
  public static boolean t = true;
  public static int u = 0;
  public static int v = 0;
  public static boolean w = true;
  static AtomicBoolean y = new AtomicBoolean();
  public static final String z = "__loginSdk_iconf_Msf";
  public ConcurrentHashMap J = new ConcurrentHashMap();
  MsfCore x;
  
  public a(MsfCore paramMsfCore)
  {
    this.x = paramMsfCore;
  }
  
  public static String A()
  {
    if (q.containsKey("bigflowwifi_ver2")) {
      return (String)q.get("bigflowwifi_ver2");
    }
    return "20";
  }
  
  public static long B()
  {
    try
    {
      if (q.containsKey("msf_basicTicketChangeInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_basicTicketChangeInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getBasicTicketChangeInterval error" + localException);
      }
    }
    return 0L;
  }
  
  public static long C()
  {
    try
    {
      if (q.containsKey("msf_webTicketChangeInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_webTicketChangeInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getWebTicketChangeInterval error" + localException);
      }
    }
    return 0L;
  }
  
  public static boolean D()
  {
    return y.get();
  }
  
  private void N()
  {
    boolean bool = false;
    int i2;
    int i1;
    String str2;
    if (q.containsKey("msf_noReportRdmEvent")) {
      try
      {
        String[] arrayOfString1 = ((String)q.get("msf_noReportRdmEvent")).split(";");
        i2 = arrayOfString1.length;
        i1 = 0;
        while (i1 < i2)
        {
          str2 = arrayOfString1[i1];
          if (!str2.trim().equals(""))
          {
            r.add(str2);
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.ConfigManager", 2, "rdm event " + str2 + " set no report.");
            }
          }
          i1 += 1;
        }
        if (!q.containsKey("msf_needPrintLogCmd")) {
          break label294;
        }
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "set msf_noReportRdmEvent error " + localException1);
        }
      }
    } else {
      try
      {
        String[] arrayOfString2 = ((String)q.get("msf_needPrintLogCmd")).split(";");
        i2 = arrayOfString2.length;
        i1 = 0;
        while (i1 < i2)
        {
          str2 = arrayOfString2[i1];
          if (!str2.trim().equals(""))
          {
            s.add(str2);
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.ConfigManager", 2, "msg " + str2 + " need print log.");
            }
          }
          i1 += 1;
        }
        if (!q.containsKey("msf_AnyPacketAsPushHB")) {}
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "set msf_noReportRdmEvent error " + localException2);
        }
      }
    }
    try
    {
      label294:
      String str1 = (String)q.get("msf_AnyPacketAsPushHB");
      if (str1.equals("0"))
      {
        t = bool;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "config useAnyPacketAsPushHB " + str1);
        }
      }
    }
    catch (Exception localException4)
    {
      try
      {
        i.b(Long.parseLong(A()));
      }
      catch (Exception localException4)
      {
        try
        {
          for (;;)
          {
            i.a(Long.parseLong(z()));
            return;
            bool = true;
            continue;
            localException3 = localException3;
            if (QLog.isColorLevel())
            {
              QLog.d("MSF.C.ConfigManager", 2, "set msf_noReportRdmEvent error " + localException3);
              continue;
              localException4 = localException4;
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.ConfigManager", 2, "set3GBigLow error " + localException4);
              }
            }
          }
        }
        catch (Exception localException5)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d("MSF.C.ConfigManager", 2, "setWifiBigLow error " + localException5);
        }
      }
    }
  }
  
  private void O()
  {
    try
    {
      String[] arrayOfString = c();
      if (arrayOfString != null)
      {
        this.x.sender.d = Integer.parseInt(arrayOfString[0]);
        this.x.sender.e = Integer.parseInt(arrayOfString[1]);
        this.x.sender.i = Integer.parseInt(arrayOfString[2]);
        this.x.sender.g = Integer.parseInt(arrayOfString[3]);
      }
      return;
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          arrayOfString = d();
          this.x.sender.a(arrayOfString);
          try
          {
            this.x.sender.h = Integer.parseInt(e());
            return;
          }
          catch (Exception localException3)
          {
            QLog.d("MSF.C.ConfigManager", 1, " " + localException3, localException3);
          }
          localException1 = localException1;
          QLog.d("MSF.C.ConfigManager", 1, " " + localException1, localException1);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.d("MSF.C.ConfigManager", 1, " " + localException2, localException2);
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "msfCore setAutoStaring " + paramBoolean);
      }
      y.set(paramBoolean);
      if (MsfStore.getNativeConfigStore() != null) {
        MsfStore.getNativeConfigStore().setConfig("_msf_isBootingKey", String.valueOf(paramBoolean));
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "storeAutoStaring " + paramBoolean);
      }
      return;
    }
    finally {}
  }
  
  public static boolean a(String paramString)
  {
    if (q.containsKey(paramString + "_isAutoBoot")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)q.get(paramString + "_isAutoBoot")).trim());
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, paramString + " set isAutoBoot error " + localException);
        }
        return false;
      }
    }
    return true;
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      c.a(new ByteArrayInputStream(("<" + paramString1 + ">" + paramString2 + "</" + paramString1 + ">").getBytes("UTF-8")), q, paramString3);
      return true;
    }
    catch (Exception paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "parse " + paramString1 + "Config error " + paramString2, paramString2);
      }
    }
    return false;
  }
  
  static String c(String paramString)
  {
    try
    {
      paramString = HexUtil.bytes2HexStr(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "Str2HexStr error " + paramString, paramString);
      }
    }
    return null;
  }
  
  public static String[] c()
  {
    if (q.containsKey("MultiPkgPara"))
    {
      String[] arrayOfString = ((String)q.get("MultiPkgPara")).replaceAll("\\|", ",").split(",");
      if (arrayOfString.length == 4) {
        return arrayOfString;
      }
    }
    else
    {
      QLog.d("MSF.C.ConfigManager", 1, "login merge configuration not be found.");
    }
    return null;
  }
  
  static String d(String paramString)
  {
    try
    {
      paramString = new String(HexUtil.hexStr2Bytes(paramString), "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "HexStr2Str error " + paramString, paramString);
      }
    }
    return null;
  }
  
  public static String[] d()
  {
    if (q.containsKey("MultiPkgWL")) {
      return ((String)q.get("MultiPkgWL")).replaceAll("\\|", ",").split(",");
    }
    QLog.d("MSF.C.ConfigManager", 1, "login merge whitelist not be found.");
    return null;
  }
  
  public static String e()
  {
    if (q.containsKey("AndroidMergeDuration")) {
      return (String)q.get("AndroidMergeDuration");
    }
    QLog.d("MSF.C.ConfigManager", 1, "login merge duration not be found.");
    return "0";
  }
  
  public static String f()
  {
    if (q.contains("NetFlowMax")) {
      return (String)q.get("NetFlowMax");
    }
    return "10485760";
  }
  
  public static String g()
  {
    if (q.containsKey("msf_locallogtime")) {
      return (String)q.get("msf_locallogtime");
    }
    return "3";
  }
  
  public static String h()
  {
    if (q.containsKey("msf_checkSsoIntervtime")) {
      return (String)q.get("msf_checkSsoIntervtime");
    }
    return "300000";
  }
  
  public static boolean i()
  {
    if (q.containsKey("msf_useLastOpenAddress")) {
      try
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_useLastOpenAddress"));
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "get useLastOpenAddress error " + localException);
        }
      }
    }
    return false;
  }
  
  public static boolean j()
  {
    if (q.containsKey("msf_limitWtChangetoken")) {
      try
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_limitWtChangetoken"));
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "get msf_limitWtChangetoken error " + localException);
        }
      }
    }
    return true;
  }
  
  public static boolean k()
  {
    if (q.containsKey("msf_isSetReloadKeyUin")) {
      try
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_isSetReloadKeyUin"));
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "get msf_isSetReloadKeyUin error " + localException);
        }
      }
    }
    return true;
  }
  
  public static boolean l()
  {
    try
    {
      if (q.containsKey("msf_isUseWtlogin"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_isUseWtlogin"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "msf_isUseWtlogin error" + localException);
      }
    }
    return w;
  }
  
  public static long m()
  {
    try
    {
      if (q.containsKey("msf_heartBeatTimeout"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_heartBeatTimeout"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getHeartBeatTimeout error" + localException);
      }
    }
    return 30000L;
  }
  
  public static int n()
  {
    try
    {
      if (q.containsKey("msf_heartBeatRetrycount"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_heartBeatRetrycount"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getHeartBeatRetryCount error" + localException);
      }
    }
    return 1;
  }
  
  public static int o()
  {
    try
    {
      if (q.containsKey("msf_busPacketTimeoutMaxNum"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_busPacketTimeoutMaxNum"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getBusPacketTimeoutMaxNum error" + localException);
      }
    }
    return 10;
  }
  
  public static long p()
  {
    try
    {
      if (q.containsKey("msf_busCheckServerTimeInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_busCheckServerTimeInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getBusPacketTimeoutMaxNum error" + localException);
      }
    }
    return 5000L;
  }
  
  public static long q()
  {
    try
    {
      if (q.containsKey("msf_checkUpdateServerTimeInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_checkUpdateServerTimeInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getUpdateServerTimePacketTimeoutMaxNum error" + localException);
      }
    }
    return 72000000L;
  }
  
  public static int r()
  {
    try
    {
      if (q.containsKey("msf_heartBeatTimeInterval"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_heartBeatTimeInterval = " + (String)q.get("msf_heartBeatTimeInterval"));
        }
        int i1 = Integer.parseInt((String)q.get("msf_heartBeatTimeInterval"));
        return i1 * 60 * 1000;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "getHeartBeatTimeInterval error" + localException);
      }
    }
    return 60000;
  }
  
  public static int s()
  {
    try
    {
      if (q.containsKey("msf_netIdleTimeInterval"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_netIdleTimeInterval = " + (String)q.get("msf_netIdleTimeInterval"));
        }
        int i1 = Integer.parseInt((String)q.get("msf_netIdleTimeInterval"));
        return i1 * 60 * 1000;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "getNetIdleTimeInterval error" + localException);
      }
    }
    return 1680000;
  }
  
  public static String t()
  {
    try
    {
      if (q.containsKey("TcpdumpSSOVip_new"))
      {
        String str = (String)q.get("TcpdumpSSOVip_new");
        return str;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getTcpdumpSSOVip error" + localException);
      }
    }
    return null;
  }
  
  public static int u()
  {
    try
    {
      if (q.containsKey("TcpdumpSSOTime"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "TcpdumpSSOTime = " + (String)q.get("TcpdumpSSOTime"));
        }
        int i1 = Integer.parseInt((String)q.get("TcpdumpSSOTime"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "getTcpdumpSSOTime error" + localException);
      }
    }
    return 0;
  }
  
  public static int v()
  {
    try
    {
      if (q.containsKey("msf_netWeakTimeInterval"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_netWeakTimeInterval = " + (String)q.get("msf_netWeakTimeInterval"));
        }
        int i1 = Integer.parseInt((String)q.get("msf_netWeakTimeInterval"));
        return i1 * 60 * 1000;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "getNetWeakTimeInterval error" + localException);
      }
    }
    return 180000;
  }
  
  public static int w()
  {
    try
    {
      if (q.containsKey("msf_pcactiveretrytimes"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_pcactiveretrytimes = " + (String)q.get("msf_pcactiveretrytimes"));
        }
        int i1 = Integer.parseInt((String)q.get("msf_pcactiveretrytimes"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "msf_pcactiveretrytimes error" + localException);
      }
    }
    return 10;
  }
  
  public static int x()
  {
    try
    {
      if (q.containsKey("msf_netWeakExceptionCount"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_netWeakExceptionCount = " + (String)q.get("msf_netWeakExceptionCount"));
        }
        int i1 = Integer.parseInt((String)q.get("msf_netWeakExceptionCount"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "getNetWeakExceptionCount error" + localException);
      }
    }
    return 3;
  }
  
  public static long y()
  {
    if (q.containsKey("msf_CallQQIntervTimeOnBoot")) {
      try
      {
        long l1 = Long.parseLong(((String)q.get("msf_CallQQIntervTimeOnBoot")).trim());
        return l1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, " get CallQQIntervTimeOnBoot error " + localNumberFormatException);
        }
      }
    }
    return 10000L;
  }
  
  public static String z()
  {
    if (q.containsKey("bigflow2g3g_ver2")) {
      return (String)q.get("bigflow2g3g_ver2");
    }
    return "40";
  }
  
  public String E()
  {
    return d(MsfStore.getNativeConfigStore().getConfig("__loginSdk_iconf_UserCommCon"));
  }
  
  public String F()
  {
    return d(MsfStore.getNativeConfigStore().getConfig("__loginSdk_iconf_AppConf"));
  }
  
  public String G()
  {
    return d(MsfStore.getNativeConfigStore().getConfig("__loginSdk_iconf_Msf"));
  }
  
  public boolean H()
  {
    long l1 = System.currentTimeMillis();
    if (NetConnInfoCenterImpl.isMobileConn()) {
      if (A != 0L) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
              if (C != 0L) {
                break;
              }
            } while (l1 - A >= 43200000L);
            return false;
          } while (l1 >= C);
          return false;
          if (!NetConnInfoCenterImpl.isWifiConn()) {
            break;
          }
        } while (B == 0L);
        if (D != 0L) {
          break;
        }
      } while (l1 - B >= 43200000L);
      return false;
    } while (l1 >= D);
    return false;
    return false;
  }
  
  public void I()
  {
    MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_mobilessotime", String.valueOf(C));
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.ConfigManager", 2, "save next get mobile sso time is " + this.x.timeFormatter.format(Long.valueOf(C)));
    }
  }
  
  public void J()
  {
    MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_wifissotime", String.valueOf(D));
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.ConfigManager", 2, "save next get Wifi sso time is " + this.x.timeFormatter.format(Long.valueOf(D)));
    }
  }
  
  public byte[] K()
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("KQQ.ConfigService.ConfigServantObj");
    localUniPacket.setFuncName("ClientReq");
    localUniPacket.put("iCmdType", Integer.valueOf(32));
    com.tencent.msf.service.protocol.e.e locale = new com.tencent.msf.service.protocol.e.e();
    Object localObject2 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_iConfAppidTimeKey");
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = "1";
    }
    u = Integer.parseInt((String)localObject1);
    if (u == 0) {
      u = 1;
    }
    localObject2 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_iConfSdkLastTimeKey");
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = "0";
    }
    v = Integer.parseInt((String)localObject1);
    localObject2 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_iConfGetEspLastTimeKe");
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = "0";
    }
    int i1 = Integer.parseInt((String)localObject1);
    locale.e = u;
    locale.b = v;
    locale.d = i1;
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.ConfigManager", 4, "load confReq iGetAppidTime" + locale.e + " iGetSdkLastTime:" + locale.b + " iGetEspLastTime:" + locale.d);
    }
    localObject2 = this.x.getAccountCenter().d();
    Object localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((SimpleAccount)((Iterator)localObject2).next()).getUin());
    }
    locale.c = ((ArrayList)localObject1);
    localUniPacket.put("SDKConfReq", locale);
    return localUniPacket.encode();
  }
  
  public ConcurrentHashMap L()
  {
    return q;
  }
  
  public int a(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg.getWupBuffer() != null) && (paramToServiceMsg.getWupBuffer().length > 0)) {}
    for (;;)
    {
      this.x.sendSsoMsg(paramToServiceMsg);
      return paramToServiceMsg.getRequestSsoSeq();
      Object localObject1 = new com.tencent.msf.service.protocol.f.f();
      ((com.tencent.msf.service.protocol.f.f)localObject1).f = 0;
      ((com.tencent.msf.service.protocol.f.f)localObject1).a = new com.tencent.msf.service.protocol.f.b();
      ((com.tencent.msf.service.protocol.f.f)localObject1).d = "";
      ((com.tencent.msf.service.protocol.f.f)localObject1).e = "";
      ((com.tencent.msf.service.protocol.f.f)localObject1).g = new byte[0];
      ((com.tencent.msf.service.protocol.f.f)localObject1).c = new ArrayList();
      ((com.tencent.msf.service.protocol.f.f)localObject1).b = new ArrayList();
      Object localObject2 = new d();
      ((d)localObject2).e = 0;
      ((d)localObject2).d = 0;
      ((d)localObject2).c = 0;
      ((d)localObject2).a = "";
      ((d)localObject2).b = 0L;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject2);
      localObject2 = new UniPacket(true);
      ((UniPacket)localObject2).setEncodeName("utf-8");
      ((UniPacket)localObject2).setRequestId(0);
      ((UniPacket)localObject2).setServantName("KQQ.ConfigService.ConfigServantObj");
      ((UniPacket)localObject2).setFuncName("ClientReq");
      ((UniPacket)localObject2).put("iCmdType", Integer.valueOf(64));
      ((UniPacket)localObject2).put("ReqUserInfo", localObject1);
      localObject1 = new com.tencent.msf.service.protocol.f.e();
      ((com.tencent.msf.service.protocol.f.e)localObject1).a = localArrayList;
      ((UniPacket)localObject2).put("GetResourceReqV2", localObject1);
      paramToServiceMsg.putWupBuffer(((UniPacket)localObject2).encode());
    }
  }
  
  public int a(HashMap paramHashMap, String paramString)
    throws Exception
  {
    paramHashMap = a(paramString, paramHashMap);
    paramString = new ToServiceMsg("", "0", "CliLogSvc.UploadReq");
    paramString.setAppId(this.x.sender.i());
    paramString.setRequestSsoSeq(MsfCore.getNextSeq());
    paramString.setTimeout(30000L);
    paramString.setNeedCallback(false);
    paramString.putWupBuffer(paramHashMap);
    return this.x.sendSsoMsg(paramString);
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt, String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    paramString1 = new b(this, paramString1, paramInt, paramLong, paramBoolean, paramString2);
    paramString1.setName("checkSsoByHttpThread");
    paramString1.start();
  }
  
  public void a(com.tencent.msf.service.protocol.e.f paramf, FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.ConfigManager", 2, "recvServerConfig: " + paramf);
    }
    if (paramf == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "configInfo.iUpdateType is null , return");
      }
    }
    label279:
    label453:
    do
    {
      String str3;
      do
      {
        do
        {
          do
          {
            return;
            if (paramf.a == 1) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("MSF.C.ConfigManager", 2, "configInfo.iUpdateType is " + paramf.a + " , return");
          return;
          str3 = paramf.d;
          if ((str3 != null) && (str3.length() != 0)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("MSF.C.ConfigManager", 2, "handle config, res.sConf null, return");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "handle sConf " + paramf.d);
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "handle sEspConf " + paramf.f);
        }
        String str4 = "";
        i1 = str3.indexOf("<MSF>");
        i2 = str3.indexOf("</MSF>");
        if ((i1 == -1) || (i2 == -1) || (i1 >= i2))
        {
          str1 = str4;
          paramToServiceMsg = str3;
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.ConfigManager", 2, "handle config MSF null, skip");
            paramToServiceMsg = str3;
            str1 = str4;
          }
          if ((str1 != null) && (str1.length() != 0)) {
            break label453;
          }
        }
        for (;;)
        {
          if ((paramf.b != 0) && (v != paramf.b)) {
            break label538;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.ConfigManager", 2, "handle config,  iGetSdkLastTime is obsolete, skip...");
          }
          if ((paramf.g != 0) && (u != paramf.g)) {
            break label794;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.ConfigManager", 2, "handle config, iGetAppidTime is obsolete, skip...");
          }
          paramToServiceMsg = paramf.f;
          if ((paramToServiceMsg != null) && (paramToServiceMsg.length() != 0)) {
            break label1042;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MSF.C.ConfigManager", 2, "handle config, res.sEspConf null, return");
          return;
          str1 = str3.substring("<MSF>".length() + i1, i2);
          paramToServiceMsg = str3.substring(0, i1) + str3.substring("</MSF>".length() + i2, str3.length());
          break label279;
          if (a("msfConfig", str1, ""))
          {
            str1 = c(str1);
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.ConfigManager", 2, "recv config str_msf: " + str1);
            }
            MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iconf_Msf", str1);
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.ConfigManager", 2, "parse msfConf error , skip store.");
          }
        }
        v = paramf.b;
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.ConfigManager", 4, "save confReq iGetSdkNewTime" + paramf.b);
        }
        MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iConfSdkLastTimeKey", String.valueOf(paramf.b));
        i1 = paramToServiceMsg.indexOf("<CommConf>");
        i2 = paramToServiceMsg.indexOf("</CommConf>");
        if ((i1 != -1) && (i2 != -1) && (i1 < i2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MSF.C.ConfigManager", 2, "handle config CommConf error");
      return;
      String str1 = paramToServiceMsg.substring("<CommConf>".length() + i1, i2);
      if ((str1 == null) || (str1.length() == 0)) {
        MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iconf_UserCommCon", "");
      }
      for (;;)
      {
        try
        {
          MsfSdkUtils.writeServerConfig("com.tencent.qqlite", 0, str1, this.x.sender.h());
        }
        catch (IOException localIOException)
        {
          QLog.e("MSF.C.ConfigManager", 1, "write config error " + localIOException);
        }
        break;
        if (a("commConfig", localIOException, ""))
        {
          str3 = c(localIOException);
          MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iconf_UserCommCon", str3);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.ConfigManager", 2, "parse commonConf error , skip store.");
        }
      }
      u = paramf.g;
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "save confReq getiConfAppidTimeKey" + paramf.g);
      }
      MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iConfAppidTimeKey", String.valueOf(paramf.g));
      i1 = paramToServiceMsg.indexOf("<APPIDConf>");
      i2 = paramToServiceMsg.indexOf("</APPIDConf>");
      if ((i1 != -1) && (i2 != -1) && (i1 < i2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    label538:
    QLog.d("MSF.C.ConfigManager", 2, "handle config APPIDConf error");
    label794:
    return;
    paramToServiceMsg = paramToServiceMsg.substring("<APPIDConf>".length() + i1, i2);
    if ((paramToServiceMsg == null) || (paramToServiceMsg.length() == 0)) {
      MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iconf_AppConf", "");
    }
    for (;;)
    {
      try
      {
        MsfSdkUtils.writeServerConfig("com.tencent.qqlite", 2, paramToServiceMsg, this.x.sender.h());
      }
      catch (IOException paramToServiceMsg)
      {
        QLog.e("MSF.C.ConfigManager", 1, "write config error " + paramToServiceMsg);
      }
      break;
      if (a("appidConf", paramToServiceMsg, ""))
      {
        str2 = c(paramToServiceMsg);
        MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iconf_AppConf", str2);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.ConfigManager", 2, "parse appidConf error , skip store.");
      }
    }
    label1042:
    String str2 = "";
    int i1 = paramToServiceMsg.indexOf("<UserConf>");
    int i2 = paramToServiceMsg.indexOf("</UserConf>");
    if ((i1 == -1) || (i2 == -1) || (i1 >= i2))
    {
      paramToServiceMsg = str2;
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.ConfigManager", 2, "handle config UserConf skip");
        paramToServiceMsg = str2;
      }
    }
    for (;;)
    {
      if ((paramToServiceMsg == null) || (paramToServiceMsg.length() == 0)) {}
      try
      {
        for (;;)
        {
          MsfSdkUtils.writeServerConfig("com.tencent.qqlite", 1, paramToServiceMsg, this.x.sender.h());
          MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iConfGetEspLastTimeKe", String.valueOf(paramf.e));
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.ConfigManager", 4, "save confReq getiConfGetEspLastTimeKey" + paramf.e);
          }
          N();
          O();
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.ConfigManager", 2, "handle server config ok");
          }
          CodecWarpper.getFileStoreKey();
          return;
          paramToServiceMsg = paramToServiceMsg.substring("<UserConf>".length() + i1, i2);
          break;
          if (a("userConf", paramToServiceMsg, paramFromServiceMsg.getUin() + "_"))
          {
            str2 = c(paramToServiceMsg);
            MsfStore.getNativeConfigStore().n_setConfig(paramFromServiceMsg.getUin() + "_" + "__loginSdk_iconf_UserConf", str2);
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.ConfigManager", 2, "parse userConfig error , skip store.");
          }
        }
      }
      catch (IOException paramFromServiceMsg)
      {
        for (;;)
        {
          QLog.e("MSF.C.ConfigManager", 1, "write config error " + paramFromServiceMsg);
        }
      }
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = new com.tencent.msf.service.protocol.d.b();
    paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
    Object localObject2 = new byte[paramFromServiceMsg.length - 4];
    System.arraycopy(paramFromServiceMsg, 4, localObject2, 0, paramFromServiceMsg.length - 4);
    ((com.tencent.msf.service.protocol.d.b)localObject1).readFrom(new JceInputStream((byte[])localObject2));
    long l1 = System.currentTimeMillis() / 1000L;
    localObject2 = ((com.tencent.msf.service.protocol.d.b)localObject1).a.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      com.tencent.msf.service.protocol.d.a locala = (com.tencent.msf.service.protocol.d.a)((Iterator)localObject2).next();
      if ((locala.b > 0) && (locala.b <= 1800))
      {
        String str = new String(locala.a);
        localObject1 = (a)this.J.get(str);
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        if (localObject1 == null) {
          paramFromServiceMsg = new a();
        }
        paramFromServiceMsg.a = l1;
        paramFromServiceMsg.b = locala;
        this.J.put(str, paramFromServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "get a OverloadPushNotify sCmd: " + str + " iDelaySecs = " + locala.b + " timeMsgReceive: " + l1);
        }
      }
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (!paramFromServiceMsg.isSuccess()) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "wait " + paramToServiceMsg + " timeout.");
      }
    }
    UniPacket localUniPacket;
    int i1;
    do
    {
      return;
      localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("UTF-8");
      localUniPacket.decode(paramFromServiceMsg.getWupBuffer());
      i1 = ((Integer)localUniPacket.getByClass("iCmdType", Integer.valueOf(0))).intValue();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "handle check ConfigResp ." + i1);
      }
    } while ((i1 == 16) || (i1 != 32));
    a((com.tencent.msf.service.protocol.e.f)localUniPacket.getByClass("SDKConfRes", new com.tencent.msf.service.protocol.e.f()), paramFromServiceMsg, paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, long paramLong)
  {
    if (H())
    {
      if (!NetConnInfoCenterImpl.isMobileConn()) {
        break label77;
      }
      A = paramLong;
      MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_checkmobilessotime", String.valueOf(A));
      C = A + 3600000L;
      I();
    }
    try
    {
      a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin(), 60000L, NetConnInfoCenterImpl.isWifiConn(), "");
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          a(paramToServiceMsg.getUin(), 60000);
          return;
          label77:
          if (NetConnInfoCenterImpl.isWifiConn())
          {
            B = paramLong;
            MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_checkwifissotime", String.valueOf(B));
            D = B + 3600000L;
            J();
            continue;
            localException = localException;
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.ConfigManager", 2, localException.toString(), localException);
            }
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("MSF.C.ConfigManager", 2, paramToServiceMsg.toString(), paramToServiceMsg);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = K();
    paramString = new ToServiceMsg("", paramString, "ConfigService.ClientReq");
    paramString.setMsfCommand(MsfCommand._msf_getConfig);
    paramString.setRequestSsoSeq(MsfCore.getNextSeq());
    if (this.x.getMsfAppid() == -1) {}
    for (int i1 = 100;; i1 = this.x.getMsfAppid())
    {
      paramString.setAppId(i1);
      paramString.putWupBuffer(arrayOfByte);
      paramString.setTimeout(paramInt);
      this.x.sender.b(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "send checkConfig msg ok...");
      }
      return;
    }
  }
  
  byte[] a(String paramString, HashMap paramHashMap)
  {
    StrupBuff localStrupBuff = new StrupBuff();
    localStrupBuff.prefix = paramString;
    localStrupBuff.logstring = new HashMap(paramHashMap);
    localStrupBuff.encoding = 2;
    paramString = new UniPacket(true);
    paramString.setRequestId(MsfCore.getNextSeq());
    paramString.setEncodeName("utf-8");
    paramString.setServantName("QQService.CliLogSvc.MainServantObj");
    paramString.setFuncName("UploadReq");
    paramString.put("Data", localStrupBuff);
    return paramString.encode();
  }
  
  public int b(ToServiceMsg paramToServiceMsg)
  {
    byte b1 = ((Byte)paramToServiceMsg.getAttributes().get("to_report_type")).byteValue();
    String str = (String)paramToServiceMsg.getAttributes().get("to_report_content");
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setRequestId(MsfCore.getNextSeq());
    localUniPacket.setServantName("KQQ.ConfigService.ConfigServantObj");
    localUniPacket.setFuncName("ClientReportReq");
    com.tencent.msf.service.protocol.e.a locala = new com.tencent.msf.service.protocol.e.a();
    locala.a = b1;
    try
    {
      locala.c = str.getBytes("utf-8");
      localUniPacket.put("ClientReportReq", locala);
      paramToServiceMsg.putWupBuffer(localUniPacket.encode());
      return this.x.sendSsoMsg(paramToServiceMsg);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  public String b(String paramString)
  {
    return d(MsfStore.getNativeConfigStore().getConfig(paramString + "_" + "__loginSdk_iconf_UserConf"));
  }
  
  protected void b()
  {
    String str1 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_checkmobilessotime");
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      localObject = "0";
    }
    A = Long.parseLong((String)localObject);
    str1 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_checkwifissotime");
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      localObject = "0";
    }
    B = Long.parseLong((String)localObject);
    str1 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_mobilessotime");
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      localObject = "0";
    }
    C = Long.parseLong((String)localObject);
    str1 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_wifissotime");
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      localObject = "0";
    }
    D = Long.parseLong((String)localObject);
    str1 = MsfStore.getNativeConfigStore().getConfig("_msf_isBootingKey");
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      localObject = "false";
    }
    a(Boolean.parseBoolean((String)localObject));
    Object localObject = G();
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      a("msfConfig", (String)localObject, "");
    }
    localObject = E();
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      a("commonConfig", (String)localObject, "");
    }
    localObject = F();
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      a("appidConfig", (String)localObject, "");
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.ConfigManager", 4, (String)localObject);
    }
    localObject = this.x.getAccountCenter().c().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str1 = (String)((Iterator)localObject).next();
      String str2 = b(str1);
      if ((str2 != null) && (str2.length() > 0)) {
        a("userConfig", str2, str1 + "_");
      }
    }
    N();
  }
  
  public String c(ToServiceMsg paramToServiceMsg)
  {
    switch (((Integer)paramToServiceMsg.getAttributes().get("to_getServerConfig_type")).intValue())
    {
    default: 
      return null;
    case 0: 
      return E();
    case 1: 
      return b(paramToServiceMsg.getUin());
    }
    return F();
  }
  
  public class a
  {
    public long a;
    public com.tencent.msf.service.protocol.d.a b;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.a
 * JD-Core Version:    0.7.0.1
 */