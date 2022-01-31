package com.tencent.mobileqq.msf.service;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.b.e;
import com.tencent.mobileqq.msf.core.b.e.a;
import com.tencent.mobileqq.msf.core.b.m;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class c
{
  static final String a = "MSF.S.AppProcessManager";
  public static final String b = "app_process_info_";
  static ConcurrentHashMap c = new ConcurrentHashMap();
  static a d = new a();
  static MsfCore e;
  static h f = null;
  
  public static b a(String paramString)
  {
    return (b)c.get(paramString);
  }
  
  public static void a(Context paramContext)
  {
    String[] arrayOfString1 = MsfStore.getNativeConfigStore().getConfigList("app_process_info_");
    if (QLog.isColorLevel()) {
      QLog.d("MSF.S.AppProcessManager", 2, "start loadAppProcessInfos");
    }
    int j = arrayOfString1.length;
    int i = 0;
    String[] arrayOfString2;
    String str;
    if (i < j)
    {
      paramContext = arrayOfString1[i];
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.AppProcessManager", 2, "loadAppProcessInfo proInfo:" + paramContext);
      }
      arrayOfString2 = paramContext.split(",");
      str = arrayOfString2[0];
      paramContext = "";
      if (arrayOfString2.length > 1) {
        paramContext = arrayOfString2[1];
      }
      if (arrayOfString2.length <= 2) {
        break label132;
      }
    }
    label132:
    for (boolean bool = Boolean.parseBoolean(arrayOfString2[2]);; bool = true)
    {
      a(str, paramContext, null, 0, bool);
      i += 1;
      break;
      return;
    }
  }
  
  public static void a(Context paramContext, MsfCore paramMsfCore)
  {
    e = paramMsfCore;
    d.setName("MsfServiceAppMsgHandler");
    f = new h(paramMsfCore);
    d.start();
    a(paramContext);
  }
  
  public static void a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    paramString = (b)c.get(paramString);
    if (paramString != null) {
      paramString.a(paramInt, paramLong1, paramLong2);
    }
  }
  
  public static void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MSF.S.AppProcessManager", 2, "find null processName msg to app " + paramToServiceMsg + " " + paramFromServiceMsg);
      }
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
        e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 7);
      }
      return;
    }
    if (paramString.equals("*"))
    {
      paramString = c.entrySet().iterator();
      while (paramString.hasNext())
      {
        localObject = (Map.Entry)paramString.next();
        MsfSdkUtils.addFromMsgProcessName((String)((Map.Entry)localObject).getKey(), paramFromServiceMsg);
        ((b)((Map.Entry)localObject).getValue()).h.add(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
      }
    }
    Object localObject = (b)c.get(paramString);
    if (localObject != null)
    {
      ((b)localObject).h.add(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
      if (paramFromServiceMsg.getServiceCmd().equals(com.tencent.qphone.base.BaseConstants.CMD_NeedBootPushCmdHeads[1]))
      {
        paramToServiceMsg = new HashMap();
        a(paramToServiceMsg);
        paramToServiceMsg.put("MsgType", paramFromServiceMsg.toString());
        if (localObject == null) {
          break label410;
        }
      }
    }
    label410:
    for (boolean bool = true;; bool = false)
    {
      paramToServiceMsg.put("AppInfo", String.valueOf(bool));
      paramToServiceMsg.put("uin", paramFromServiceMsg.getUin());
      paramToServiceMsg.put("ProcName", paramString);
      paramToServiceMsg.put("appid", String.valueOf(paramFromServiceMsg.getAppId()));
      e.getStatReporter().a("dim.Msf.ForkVideoProc", false, 0L, 0L, paramToServiceMsg, true, false);
      d.a();
      return;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
        e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 8);
      }
      QLog.e("MSF.S.AppProcessManager", 1, "can not find " + paramString + " to receive msg to:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
      break;
    }
  }
  
  public static void a(String paramString, Boolean paramBoolean)
  {
    b localb = (b)c.get(paramString);
    if (localb != null)
    {
      localb.d();
      if (BaseApplication.getContext().getPackageName().equals(paramString)) {
        localb.a(100, 0L, 0L);
      }
    }
    if (!paramBoolean.booleanValue()) {
      if (QLog.isColorLevel())
      {
        paramBoolean = new StringBuilder().append("unregister process :").append(paramString).append(" ");
        if (localb != null) {
          break label99;
        }
        paramString = "failed";
        QLog.d("MSF.S.AppProcessManager", 2, paramString);
      }
    }
    label99:
    do
    {
      return;
      paramString = "succ";
      break;
      localb = (b)c.remove(paramString);
      MsfStore.getNativeConfigStore().removeConfig("app_process_info_" + paramString);
    } while (!QLog.isColorLevel());
    paramBoolean = new StringBuilder().append("remove process :").append(paramString).append(" ");
    if (localb == null) {}
    for (paramString = "failed";; paramString = "succ")
    {
      QLog.d("MSF.S.AppProcessManager", 2, paramString);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, IMsfServiceCallbacker paramIMsfServiceCallbacker, int paramInt, boolean paramBoolean)
  {
    boolean bool = paramString1.equals(BaseApplication.getContext().getPackageName());
    if (!c.containsKey(paramString1))
    {
      c.putIfAbsent(paramString1, new b());
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.AppProcessManager", 2, "add bootName " + paramString1);
      }
      if (bool)
      {
        ((b)c.get(paramString1)).i = f;
        f.e = paramBoolean;
      }
    }
    ((b)c.get(paramString1)).a(paramString1, paramString2, paramIMsfServiceCallbacker, paramBoolean);
    MsfStore.getNativeConfigStore().setConfig("app_process_info_" + paramString1, ((b)c.get(paramString1)).a());
    if ((paramInt != 0) && (bool) && ((MsfCore.mobileQQAppid == -1) || (MsfCore.mobileQQAppid != paramInt)))
    {
      MsfCore.mobileQQAppid = paramInt;
      MsfStore.getNativeConfigStore().setConfig("key_mobileQQAppid", String.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.AppProcessManager", 2, "set mobileQQAppid :" + paramInt);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.S.AppProcessManager", 2, "add process :" + paramString1);
    }
    d.a();
  }
  
  public static void a(HashMap paramHashMap)
  {
    ActivityManager localActivityManager = (ActivityManager)BaseApplication.getContext().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    paramHashMap.put("availMem", String.valueOf(localMemoryInfo.availMem));
    paramHashMap.put("lowMemory", String.valueOf(localMemoryInfo.lowMemory));
  }
  
  public static boolean a()
  {
    return f.a();
  }
  
  public static void b(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MSF.S.AppProcessManager", 2, "find null processName msg to app " + paramToServiceMsg + " " + paramFromServiceMsg);
      }
      return;
    }
    b localb = (b)c.get(paramString);
    if (localb != null)
    {
      int i = ((Integer)paramToServiceMsg.getAttribute("status")).intValue();
      paramFromServiceMsg.addAttribute("status", Integer.valueOf(i));
      paramFromServiceMsg.setMsgSuccess();
      if (i == 1)
      {
        a(paramString, paramToServiceMsg, paramFromServiceMsg);
        localb.d = true;
        localb.c = SystemClock.elapsedRealtime();
      }
      for (;;)
      {
        QLog.e("MSF.S.AppProcessManager", 1, "setAppConnStatus " + paramString + " " + i);
        return;
        if (i == 2) {
          localb.d = false;
        }
      }
    }
    QLog.e("MSF.S.AppProcessManager", 1, "can not find " + paramString + " to receive msg to:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
  }
  
  public static boolean b(String paramString)
  {
    b localb = (b)c.get(paramString);
    if ((localb != null) && (localb.c() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.AppProcessManager", 2, "process " + paramString + " also registed,can not unregister by proxy.");
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.c
 * JD-Core Version:    0.7.0.1
 */