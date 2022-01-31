package com.tencent.mobileqq.msf.service;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.core.k;
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

public class d
{
  static String a = "MSF.S.AppProcessManager";
  public static final String b = "app_process_info_";
  static ConcurrentHashMap c = new ConcurrentHashMap();
  static a d = new a();
  static MsfCore e;
  
  public static b a(String paramString)
  {
    return (b)c.get(paramString);
  }
  
  public static void a(Context paramContext)
  {
    String[] arrayOfString1 = k.a().getConfigList("app_process_info_");
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "start loadAppProcessInfos");
    }
    int j = arrayOfString1.length;
    int i = 0;
    while (i < j)
    {
      paramContext = arrayOfString1[i];
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "loadAppProcessInfo proInfo:" + paramContext);
      }
      String[] arrayOfString2 = paramContext.split(",");
      String str = arrayOfString2[0];
      paramContext = "";
      if (arrayOfString2.length > 1) {
        paramContext = arrayOfString2[1];
      }
      a(str, paramContext, null, 0);
      i += 1;
    }
  }
  
  public static void a(Context paramContext, MsfCore paramMsfCore)
  {
    e = paramMsfCore;
    d.setName("MsfServiceAppMsgHandler");
    d.start();
    a(paramContext);
  }
  
  public static void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e(a, 2, "find null processName msg to app " + paramToServiceMsg + " " + paramFromServiceMsg);
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
        ((b)((Map.Entry)localObject).getValue()).g.add(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
      }
    }
    Object localObject = (b)c.get(paramString);
    if (localObject != null)
    {
      ((b)localObject).g.add(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
      if (paramFromServiceMsg.getServiceCmd().equals(com.tencent.qphone.base.BaseConstants.CMD_NeedBootPushCmdHeads[1]))
      {
        paramToServiceMsg = new HashMap();
        a(paramToServiceMsg);
        paramToServiceMsg.put("MsgType", paramFromServiceMsg.toString());
        if (localObject == null) {
          break label332;
        }
      }
    }
    label332:
    for (boolean bool = true;; bool = false)
    {
      paramToServiceMsg.put("AppInfo", String.valueOf(bool));
      paramToServiceMsg.put("uin", paramFromServiceMsg.getUin());
      paramToServiceMsg.put("ProcName", paramString);
      paramToServiceMsg.put("appid", String.valueOf(paramFromServiceMsg.getAppId()));
      e.getStatReporter().a("dim.Msf.ForkVideoProc", false, 0L, 0L, paramToServiceMsg, true, false);
      d.a();
      return;
      QLog.e(a, 1, "can not find " + paramString + " to receive msg to:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
      break;
    }
  }
  
  public static void a(String paramString, Boolean paramBoolean)
  {
    b localb = (b)c.get(paramString);
    if (!paramBoolean.booleanValue())
    {
      if (localb != null) {
        localb.d();
      }
      if (QLog.isColorLevel())
      {
        paramBoolean = a;
        localStringBuilder = new StringBuilder().append("unregister process :").append(paramString).append(" ");
        if (localb != null) {
          break label79;
        }
        paramString = "failed";
        QLog.d(paramBoolean, 2, paramString);
      }
    }
    label79:
    do
    {
      return;
      paramString = "succ";
      break;
      localb = (b)c.remove(paramString);
      k.a().removeConfig("app_process_info_" + paramString);
    } while (!QLog.isColorLevel());
    paramBoolean = a;
    StringBuilder localStringBuilder = new StringBuilder().append("remove process :").append(paramString).append(" ");
    if (localb == null) {}
    for (paramString = "failed";; paramString = "succ")
    {
      QLog.d(paramBoolean, 2, paramString);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, IMsfServiceCallbacker paramIMsfServiceCallbacker, int paramInt)
  {
    if (!c.containsKey(paramString1))
    {
      c.putIfAbsent(paramString1, new b());
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "add bootName " + paramString1);
      }
    }
    ((b)c.get(paramString1)).a(paramString1, paramString2, paramIMsfServiceCallbacker);
    k.a().setConfig("app_process_info_" + paramString1, ((b)c.get(paramString1)).a());
    paramString2 = BaseApplication.getContext().getPackageName();
    if ((paramInt != 0) && (paramString1.equals(paramString2)) && ((MsfCore.mobileQQAppid == -1) || (MsfCore.mobileQQAppid != paramInt)))
    {
      MsfCore.mobileQQAppid = paramInt;
      k.a().setConfig("key_mobileQQAppid", String.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "set mobileQQAppid :" + paramInt);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "add process :" + paramString1);
    }
    d.a();
  }
  
  public static void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    b localb = (b)c.get(paramString);
    if (localb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "onUnGuardApp, " + paramString + " can not found");
      }
      return;
    }
    localb.a(paramBoolean, paramInt1, paramInt2);
  }
  
  public static void a(HashMap paramHashMap)
  {
    ActivityManager localActivityManager = (ActivityManager)BaseApplication.getContext().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    paramHashMap.put("availMem", String.valueOf(localMemoryInfo.availMem));
    paramHashMap.put("lowMemory", String.valueOf(localMemoryInfo.lowMemory));
  }
  
  public static void b(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e(a, 2, "find null processName msg to app " + paramToServiceMsg + " " + paramFromServiceMsg);
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
        localb.c = true;
        localb.b = SystemClock.elapsedRealtime();
      }
      for (;;)
      {
        QLog.e(a, 1, "setAppConnStatus " + paramString + " " + i);
        return;
        if (i == 2) {
          localb.c = false;
        }
      }
    }
    QLog.e(a, 1, "can not find " + paramString + " to receive msg to:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
  }
  
  public static boolean b(String paramString)
  {
    b localb = (b)c.get(paramString);
    if ((localb != null) && (localb.c() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "process " + paramString + " also registed,can not unregister by proxy.");
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.d
 * JD-Core Version:    0.7.0.1
 */