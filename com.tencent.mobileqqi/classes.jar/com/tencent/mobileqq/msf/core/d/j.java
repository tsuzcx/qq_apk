package com.tencent.mobileqq.msf.core.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import com.tencent.beacon.event.CountItem;
import com.tencent.beacon.event.UserAction;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.feedback.upload.UploadHandleListener;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.b.h;
import com.tencent.mobileqq.msf.core.b.i;
import com.tencent.mobileqq.msf.core.b.i.a;
import com.tencent.mobileqq.msf.core.b.t;
import com.tencent.mobileqq.msf.core.c;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class j
{
  static final String A = "param_Detail";
  static final String B = "param_tokenType";
  public static final String C = "param_reportTime";
  static final String D = "param_LoginConnect";
  static final String E = "param_connectContinuanceTime";
  static HashSet G = null;
  public static volatile boolean H = false;
  static long I = 0L;
  static long J = 0L;
  static AtomicBoolean K = new AtomicBoolean(false);
  static Thread L = new k("MsfCheckDeepSleepThread");
  private static LinkedBlockingQueue M = new LinkedBlockingQueue(100);
  private static ConcurrentHashMap N = new ConcurrentHashMap();
  private static final long O = 900000L;
  static final String a = "MSF.C.StatReport";
  public static final String b = "param_Reason";
  public static final String c = "param_connecttrycount";
  static final String d = "param_sendTime";
  static final String e = "param_connResult";
  static final String f = "param_connFailReason";
  static final String g = "param_connNetType";
  static final String h = "param_connOpenNetType";
  static final String i = "param_connElapseTime";
  static final String j = "param_localIp";
  static final String k = "param_NetworkStatus";
  static final String l = "param_ssoInfo";
  static final String m = "param_liveTime";
  static final String n = "param_sendBytes";
  static final String o = "param_recvBytes";
  static final String p = "param_runStatus";
  static final String q = "param_isDefaultList";
  static final String r = "param_isConnected";
  static final String s = "param_uin";
  static final String t = "param_src";
  static final String u = "param_imei";
  static final String v = "param_FailCode";
  static final String w = "param_SsoServerIp";
  static final String x = "param_GatewayIp";
  static final String y = "param_NowLocalIp";
  static final String z = "param_sendLocalIp";
  MsfCore F;
  
  public j(MsfCore paramMsfCore)
  {
    this.F = paramMsfCore;
    f.a(this, paramMsfCore);
  }
  
  private static byte a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    int i2 = 0;
    int i3;
    label26:
    int i4;
    if (f())
    {
      i1 = 1;
      i3 = (byte)i1;
      if (!e()) {
        break label309;
      }
      i1 = 2;
      i4 = (byte)i1;
      boolean bool = paramBoolean;
      if (!paramBoolean)
      {
        Iterator localIterator = N.entrySet().iterator();
        Map.Entry localEntry;
        do
        {
          bool = paramBoolean;
          if (!localIterator.hasNext()) {
            break;
          }
          localEntry = (Map.Entry)localIterator.next();
        } while (((paramLong1 < ((Long)localEntry.getKey()).longValue()) || (paramLong1 > ((Long)localEntry.getValue()).longValue())) && ((paramLong2 < ((Long)localEntry.getKey()).longValue()) || (paramLong2 > ((Long)localEntry.getValue()).longValue())) && ((paramLong2 < ((Long)localEntry.getKey()).longValue()) || (paramLong1 > ((Long)localEntry.getKey()).longValue())));
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.StatReport", 2, "find deep sleep. report time:[" + paramLong1 + ", " + paramLong2 + "], sleep time:[" + localEntry.getKey() + ", " + localEntry.getValue() + "]");
        }
        bool = true;
      }
      if (!bool) {
        break label315;
      }
    }
    label309:
    label315:
    for (int i1 = 4;; i1 = 0)
    {
      int i5 = (byte)i1;
      i1 = i2;
      if (g()) {
        i1 = 8;
      }
      return (byte)(i5 | i3 | i4 | (byte)i1);
      i1 = 0;
      break;
      i1 = 0;
      break label26;
    }
  }
  
  public static long a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramToServiceMsg != null)
    {
      l1 = l2;
      if (paramToServiceMsg.getWupBuffer() != null) {
        l1 = 0L + paramToServiceMsg.getWupBuffer().length;
      }
    }
    l2 = l1;
    if (paramFromServiceMsg != null)
    {
      l2 = l1;
      if (paramFromServiceMsg.getWupBuffer() != null) {
        l2 = l1 + paramFromServiceMsg.getWupBuffer().length;
      }
    }
    return l2;
  }
  
  private String a(d paramd)
  {
    if (paramd == null) {
      return "null EndpointKey";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramd.b()).append("://");
    localStringBuilder.append(paramd.c()).append(":").append(paramd.d());
    return localStringBuilder.toString();
  }
  
  static void b(boolean paramBoolean)
  {
    while (!M.isEmpty())
    {
      StringBuilder localStringBuilder;
      Map localMap;
      try
      {
        RdmReq localRdmReq = (RdmReq)M.take();
        if (localRdmReq == null) {
          continue;
        }
        localStringBuilder = new StringBuilder();
        localMap = localRdmReq.params;
        if (localMap == null) {
          break label216;
        }
        long l1 = Long.parseLong((String)localMap.get("param_reportTime"));
        localMap.put("param_runStatus", String.valueOf(a(paramBoolean, l1 - localRdmReq.elapse, l1)));
        localMap.remove("param_reportTime");
        Iterator localIterator = localMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localStringBuilder.append("k=").append((String)localEntry.getKey()).append(", v=").append((String)localEntry.getValue()).append("; ");
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      catch (Exception localException) {}
      QLog.w("MSF.C.StatReport", 2, "report RQD error " + localException, localException);
      continue;
      label216:
      if (localException.isMerge) {
        UserAction.onMergeUserAction(localException.eventName, localException.isSucceed, localException.elapse, localException.size, localException.isRealTime, new CountItem[0]);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("MSF.C.StatReport", 2, "report RQD IMEI:" + com.tencent.mobileqq.msf.core.j.d() + " eventName=" + localException.eventName + " isSucceed:" + localException.isSucceed + " elapse:" + localException.elapse + " size:" + localException.size + " isRealTime:" + localException.isRealTime + " isMerge:" + localException.isMerge + " params:" + localStringBuilder.toString());
        break;
        UserAction.onUserAction(localException.eventName, localException.isSucceed, localException.elapse, localException.size, localMap, localException.isRealTime);
      }
    }
  }
  
  private static boolean e()
  {
    return !MsfSdkUtils.isTopActivity(BaseApplication.getContext());
  }
  
  private static boolean f()
  {
    return !MsfSdkUtils.isScreenOn(BaseApplication.getContext());
  }
  
  private static boolean g()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      if (Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "airplane_mode_on", 0) == 0) {}
    }
    while (Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "airplane_mode_on", 0) != 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void a()
  {
    if (!K.get()) {}
    try
    {
      UserAction.initUserAction(BaseApplication.getContext(), true);
      Object localObject = new l(this);
      CrashStrategyBean localCrashStrategyBean = new CrashStrategyBean();
      localCrashStrategyBean.setMaxStackFrame(6);
      localCrashStrategyBean.setMaxStackLine(400);
      CrashReport.initCrashReport(BaseApplication.getContext(), (CrashHandleListener)localObject, new a(), true, localCrashStrategyBean);
      UserAction.closeUseInfoEvent();
      UserAction.setAutoLaunchEventUsable(true);
      localObject = BaseApplication.getContext().getDir("tombs", 0).getAbsolutePath();
      CrashReport.initNativeCrashReport(BaseApplication.getContext(), (String)localObject, true);
      L.start();
      K.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.StatReport", 2, "init RQD finished");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("MSF.C.StatReport", 1, "init RQD error " + localThrowable, localThrowable);
    }
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    if (NetConnInfoCenterImpl.isWifiOrMobileConn())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      a("dim.Msf.TokenExpired", false, paramLong1, paramLong2, localHashMap, false, false);
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    String str = "" + paramLong;
    str = str + "|";
    paramString1 = str + paramString1;
    paramString1 = paramString1 + "|";
    paramString1 = paramString1 + paramString2;
    paramString2 = new HashMap();
    paramString2.put("param_connectContinuanceTime", paramString1);
    a("msf_connectContinuanceTime", false, paramLong, 0L, paramString2, false, false);
  }
  
  public void a(WifiInfo paramWifiInfo)
  {
    int i2;
    label45:
    int i3;
    if ((paramWifiInfo.getBSSID() == null) || (paramWifiInfo.getIpAddress() == 0) || (paramWifiInfo.getSupplicantState() != SupplicantState.COMPLETED))
    {
      if (paramWifiInfo.getBSSID() != null) {
        break label106;
      }
      i1 = 1;
      i2 = (byte)i1;
      if (paramWifiInfo.getIpAddress() != 0) {
        break label111;
      }
      i1 = 2;
      i3 = (byte)i1;
      if (paramWifiInfo.getSupplicantState() == SupplicantState.COMPLETED) {
        break label116;
      }
    }
    label106:
    label111:
    label116:
    for (int i1 = 4;; i1 = 0)
    {
      i1 = (byte)i1;
      paramWifiInfo = new HashMap();
      paramWifiInfo.put("param_FailCode", String.valueOf((i1 | i2 | i3) + 5000));
      a("dim.Msf.WifiNoConnection", false, 0L, 0L, paramWifiInfo, true, false);
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label45;
    }
  }
  
  public void a(String paramString)
  {
    UserAction.setUserID(paramString);
    CrashReport.setUserId(BaseApplication.getContext(), paramString);
  }
  
  public void a(String paramString, boolean paramBoolean, long paramLong1, int paramInt, long paramLong2)
  {
    if (NetConnInfoCenterImpl.isWifiOrMobileConn())
    {
      if (G == null) {
        G = new HashSet();
      }
      if (!G.contains(paramString)) {}
    }
    else
    {
      return;
    }
    G.add(paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", paramString);
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    a("dim.Msf.UserGrayfail", paramBoolean, paramLong1, paramLong2, localHashMap, false, false);
  }
  
  public void a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (H)
    {
      H = false;
      c();
    }
    if (com.tencent.mobileqq.msf.core.a.a.r.contains(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.StatReport", 2, paramString + " is not need report.");
      }
      return;
    }
    if ((paramMap == null) || (!paramBoolean1)) {}
    for (;;)
    {
      int i1;
      try
      {
        if ((this.F != null) && (this.F.sender != null) && (this.F.sender.a != null)) {
          paramMap.put("param_isConnected", String.valueOf(this.F.sender.a.n().b()));
        }
        paramMap.put("param_NetworkOperator", com.tencent.mobileqq.msf.core.j.l());
        i1 = NetConnInfoCenterImpl.getSystemNetworkType();
        paramMap.put("param_NetworkInfo", String.valueOf(i1));
        if (!paramMap.containsKey(BaseConstants.RDM_NoChangeFailCode)) {
          break label356;
        }
        paramMap.remove(BaseConstants.RDM_NoChangeFailCode);
        paramMap.put("param_SsoServerIp", com.tencent.mobileqq.msf.core.l.h);
        paramMap.put("param_GatewayrIp", com.tencent.mobileqq.msf.core.l.l());
        if (!paramMap.containsKey("param_reportTime")) {
          paramMap.put("param_reportTime", String.valueOf(SystemClock.elapsedRealtime()));
        }
        RdmReq localRdmReq = new RdmReq();
        localRdmReq.eventName = paramString;
        localRdmReq.elapse = paramLong1;
        localRdmReq.size = paramLong2;
        localRdmReq.isSucceed = paramBoolean1;
        localRdmReq.isRealTime = paramBoolean2;
        localRdmReq.isMerge = paramBoolean3;
        localRdmReq.params = paramMap;
        if ((M.offer(localRdmReq)) || (!QLog.isColorLevel())) {
          break;
        }
        QLog.e("MSF.C.StatReport", 2, "wait queue is full!");
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("MSF.C.StatReport", 2, "report RQD error " + paramString, paramString);
      return;
      label356:
      if (i1 == 0) {
        paramMap.put("param_FailCode", "900");
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(4015));
    localHashMap.put("param_Reason", String.valueOf(paramBoolean));
    a("Msf.LoginRespTimeout", false, 0L, 0L, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timeConnectTestServerDiff", String.valueOf(paramLong));
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      localHashMap.put("SSOIP" + i1, ((i.a)paramArrayList.get(i1)).a);
      localHashMap.put("ConnTestSsoResult" + i1, String.valueOf(((i.a)paramArrayList.get(i1)).b));
      localHashMap.put("errorDetail" + i1, ((i.a)paramArrayList.get(i1)).c);
      i1 += 1;
    }
    localHashMap.put("respcode", String.valueOf(paramInt));
    a("msf_netStateWhileSSOListCannotConnBDOK5", paramBoolean, 0L, 0L, localHashMap, true, false);
  }
  
  public void a(boolean paramBoolean, long paramLong1, int paramInt, long paramLong2)
  {
    HashMap localHashMap;
    if (NetConnInfoCenterImpl.isWifiOrMobileConn())
    {
      localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt + 3300));
      if (f()) {
        a("dim.Msf.BG.PushQueryResult", paramBoolean, paramLong1, paramLong2, localHashMap, false, false);
      }
    }
    else
    {
      return;
    }
    a("dim.Msf.PushQueryResult", paramBoolean, paramLong1, paramLong2, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, int paramInt, long paramLong2, String paramString1, String paramString2, boolean paramBoolean2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt + 3000));
    localHashMap.put("param_SsoServerIp", paramString1);
    localHashMap.put("param_sendLocalIp", paramString2);
    localHashMap.put("param_NowLocalIp", com.tencent.mobileqq.msf.core.l.i);
    localHashMap.put("param_Reason", String.valueOf(paramBoolean2));
    localHashMap.put("param_sendTime", String.valueOf(paramLong3));
    a("Msf.CommonLogin", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, int paramInt, long paramLong2, boolean paramBoolean2, String paramString)
  {
    HashMap localHashMap;
    if (NetConnInfoCenterImpl.isWifiOrMobileConn())
    {
      localHashMap = new HashMap();
      localHashMap.put("param_Reason", paramString);
      if (paramBoolean2) {
        break label85;
      }
      localHashMap.put("param_FailCode", String.valueOf(paramInt + 3100));
      if (f()) {
        a("dim.Msf.BG.RigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
      }
    }
    else
    {
      return;
    }
    a("dim.Msf.RigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
    return;
    label85:
    localHashMap.put("param_FailCode", String.valueOf(paramInt + 3200));
    if (f())
    {
      a("dim.Msf.BG.UnRigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
      return;
    }
    a("dim.Msf.UnRigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean2, ArrayList paramArrayList, int paramInt)
  {
    if (!NetConnInfoCenterImpl.isWifiOrMobileConn()) {}
    while (paramArrayList.size() <= 0) {
      return;
    }
    Object localObject1 = "" + this.F.getMsfAppid();
    localObject1 = (String)localObject1 + "|1";
    Object localObject2 = c.f(BaseApplication.getContext()) + "." + c.e(BaseApplication.getContext());
    localObject1 = (String)localObject1 + "|" + (String)localObject2;
    localObject2 = (com.tencent.mobileqq.msf.core.b.a)paramArrayList.get(paramArrayList.size() - 1);
    localObject2 = (String)localObject1 + "|" + ((com.tencent.mobileqq.msf.core.b.a)localObject2).g;
    localObject1 = com.tencent.mobileqq.msf.core.j.e();
    if ((localObject1 != null) && (((String)localObject1).length() >= 5))
    {
      localObject2 = (String)localObject2 + "|" + ((String)localObject1).substring(0, 3);
      localObject1 = (String)localObject2 + ":" + ((String)localObject1).substring(3, 5);
      localObject2 = com.tencent.mobileqq.msf.core.j.i();
      if (localObject2 == null) {
        break label582;
      }
      localObject1 = (String)localObject1 + ":" + (String)localObject2;
      label301:
      localObject1 = (String)localObject1 + ":" + false;
      localObject1 = (String)localObject1 + "|" + paramLong1;
      localObject1 = (String)localObject1 + "|" + paramLong2;
      localObject1 = (String)localObject1 + "|" + paramLong3;
      localObject1 = (String)localObject1 + "|" + paramBoolean2;
      if (!paramBoolean1) {
        break label608;
      }
    }
    label582:
    label608:
    for (localObject1 = (String)localObject1 + "|1";; localObject1 = (String)localObject1 + "|" + paramInt)
    {
      localObject2 = paramArrayList.iterator();
      for (paramArrayList = (ArrayList)localObject1; ((Iterator)localObject2).hasNext(); paramArrayList = paramArrayList + "|" + ((com.tencent.mobileqq.msf.core.b.a)localObject1).a()) {
        localObject1 = (com.tencent.mobileqq.msf.core.b.a)((Iterator)localObject2).next();
      }
      localObject1 = (String)localObject2 + "|000";
      localObject1 = (String)localObject1 + ":00";
      break;
      localObject1 = (String)localObject1 + ":000";
      break label301;
    }
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("param_LoginConnect", paramArrayList);
    try
    {
      ((HashMap)localObject1).put("param_totalmemory", MsfSdkUtils.getTotalMemory());
    }
    catch (Exception paramArrayList)
    {
      try
      {
        for (;;)
        {
          ((HashMap)localObject1).put("param_Resolution", MsfSdkUtils.getResolutionString(BaseApplication.getContext()));
          if (paramLong3 == -1L) {
            break;
          }
          a("msf_connAndRecv", paramBoolean1, paramLong1 + paramLong3, 0L, (Map)localObject1, false, false);
          return;
          paramArrayList = paramArrayList;
          QLog.d("MSF.C.StatReport", 1, "getTotalMemoey error " + paramArrayList);
        }
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          QLog.d("MSF.C.StatReport", 1, "getResilution error " + paramArrayList);
        }
        a("msf_connAndRecv", paramBoolean1, paramLong1, 0L, (Map)localObject1, false, false);
      }
    }
  }
  
  public void a(boolean paramBoolean, long paramLong1, d paramd, com.tencent.qphone.base.a parama, int paramInt, long paramLong2, long paramLong3, long paramLong4, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_connOpenNetType", String.valueOf(paramInt));
    localHashMap.put("param_ssoInfo", a(paramd));
    localHashMap.put("param_liveTime", String.valueOf(paramLong2));
    localHashMap.put("param_sendBytes", String.valueOf(paramLong3));
    localHashMap.put("param_recvBytes", String.valueOf(paramLong4));
    localHashMap.put("param_FailCode", String.valueOf(parama.ordinal() + 4900));
    localHashMap.put("param_Reason", parama.toString());
    paramd = "" + paramLong1;
    paramd = paramd + "|";
    paramd = paramd + paramString1;
    paramd = paramd + "|";
    localHashMap.put("param_connectContinuanceTime", paramd + paramString2);
    if (f())
    {
      a("dim.Msf.BG.ConnClose", paramBoolean, paramLong1, 0, localHashMap, false, false);
      return;
    }
    a("dim.Msf.ConnClose", paramBoolean, paramLong1, 0, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ssolist", paramString);
    localHashMap.put("SSOListToConnectEndTime", "" + paramLong);
    a("msf_justGetSSOListButCannotConn", paramBoolean, paramLong, 0L, localHashMap, true, false);
  }
  
  public void a(boolean paramBoolean, String paramString1, long paramLong1, int paramInt, long paramLong2, String paramString2, String paramString3)
  {
    if (NetConnInfoCenterImpl.isWifiOrMobileConn())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      localHashMap.put("param_tokenType", String.valueOf(paramString2));
      localHashMap.put("param_uin", paramString1);
      localHashMap.put("param_src", paramString3);
      localHashMap.put("param_imei", com.tencent.mobileqq.msf.core.j.d());
      a("dim.Msf.RenewToken_3", paramBoolean, paramLong1, paramLong2, localHashMap, false, false);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong, ArrayList paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int i3 = 0;
    int i4 = 0;
    int i1 = i4;
    int i2 = i3;
    if (!paramBoolean3)
    {
      i1 = i4;
      i2 = i3;
      if (paramArrayList.size() > 0)
      {
        localHashMap.put("param_Reason", String.valueOf(((com.tencent.mobileqq.msf.core.b.a)paramArrayList.get(paramArrayList.size() - 1)).e));
        if (((com.tencent.mobileqq.msf.core.b.a)paramArrayList.get(paramArrayList.size() - 1)).e != t.m) {
          break label201;
        }
        i2 = 1;
        i1 = i4;
      }
    }
    for (;;)
    {
      localHashMap.put("param_GatewayIp", com.tencent.mobileqq.msf.core.l.l());
      localHashMap.put("param_FailCode", String.valueOf(paramArrayList.size()));
      localObject = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        com.tencent.mobileqq.msf.core.b.a locala = (com.tencent.mobileqq.msf.core.b.a)paramArrayList.next();
        ((StringBuilder)localObject).append(locala.toString() + "|");
      }
      label201:
      i1 = i4;
      i2 = i3;
      if (((com.tencent.mobileqq.msf.core.b.a)paramArrayList.get(paramArrayList.size() - 1)).e == t.i)
      {
        i1 = 1;
        i2 = i3;
      }
    }
    Object localObject = ((StringBuilder)localObject).toString();
    paramArrayList = (ArrayList)localObject;
    if (((String)localObject).endsWith("|")) {
      paramArrayList = ((String)localObject).substring(0, ((String)localObject).length() - 1);
    }
    localHashMap.put("param_connResult", paramArrayList);
    if (!paramBoolean3)
    {
      localHashMap.put("param_localIp", com.tencent.mobileqq.msf.core.j.n());
      localHashMap.put("param_NetworkStatus", b());
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        a("dim.Msf.MutilConnDefaultElapsedTime", paramBoolean3, paramLong, 0, localHashMap, true, false);
        return;
      }
      a("dim.Msf.MutilConnElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    if (paramBoolean2)
    {
      if (f())
      {
        a("dim.Msf.BG.ConnDefaultElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
        return;
      }
      a("dim.Msf.ConnDefaultElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    if (f())
    {
      if (i2 != 0)
      {
        a("dim.Msf.BG.ConnFailByUnreachable", paramBoolean3, paramLong, 0, localHashMap, false, false);
        return;
      }
      if (i1 != 0)
      {
        a("dim.Msf.BG.ConnFailByPermission", paramBoolean3, paramLong, 0, localHashMap, false, false);
        return;
      }
      a("dim.Msf.BG.ConnElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    if (i2 != 0)
    {
      a("dim.Msf.ConnFailByUnreachable", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    if (i1 != 0)
    {
      a("dim.Msf.ConnFailByPermission", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    a("dim.Msf.ConnElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
  }
  
  String b()
  {
    int i3 = 0;
    int i2 = 0;
    NetworkInfo localNetworkInfo = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo != null)
    {
      int i4;
      if (localNetworkInfo.isAvailable())
      {
        i1 = 1;
        i4 = (byte)i1;
        if (!localNetworkInfo.isConnected()) {
          break label107;
        }
      }
      label107:
      for (int i1 = 2;; i1 = 0)
      {
        int i5 = (byte)i1;
        i1 = i3;
        if (NetConnInfoCenterImpl.isMobileNetworkInfo(localNetworkInfo))
        {
          i1 = i2;
          if (((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getDataState() == 2) {
            i1 = 4;
          }
          i1 = (byte)i1;
        }
        return String.valueOf((byte)(i5 | i4 | i1));
        i1 = 0;
        break;
      }
    }
    return "-1";
  }
  
  public void c()
  {
    a("dim.Msf.AUTOBOTTING", true, 0L, 0L, new HashMap(), false, false);
  }
  
  class a
    implements UploadHandleListener
  {
    a() {}
    
    public void onUploadEnd(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
    {
      if (NetConnInfoCenterImpl.isMobileConn()) {
        f.a(j.this.F.sender.g(), new String[] { "param_XGRdmFlow", "param_XGFlow", "param_Flow" }, paramLong1 + paramLong2);
      }
      while (!NetConnInfoCenterImpl.isWifiConn()) {
        return;
      }
      f.a(j.this.F.sender.g(), new String[] { "param_WIFIRdmFlow", "param_WIFIFlow", "param_Flow" }, paramLong1 + paramLong2);
    }
    
    public void onUploadStart(int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.j
 * JD-Core Version:    0.7.0.1
 */