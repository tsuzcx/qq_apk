package com.tencent.mobileqq.msf.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.msf.core.l;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class g
{
  public static final String a = "MSF.S.Util";
  
  public static FromServiceMsg a(ToServiceMsg paramToServiceMsg)
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    localFromServiceMsg.setAppId(paramToServiceMsg.getAppId());
    localFromServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
    localFromServiceMsg.setRequestSsoSeq(paramToServiceMsg.getRequestSsoSeq());
    localFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
    MsfSdkUtils.addFromMsgProcessName(b(paramToServiceMsg), localFromServiceMsg);
    return localFromServiceMsg;
  }
  
  public static String a()
  {
    Random localRandom = new Random(System.currentTimeMillis());
    String str = "---------";
    int i = 0;
    while (i < 12)
    {
      str = str + String.valueOf(localRandom.nextInt(10));
      i += 1;
    }
    return str;
  }
  
  public static String a(FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getAttributes().get("to_SenderProcessName") != null) {
      return (String)paramFromServiceMsg.getAttributes().get("to_SenderProcessName");
    }
    return "";
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent(paramString3);
    localIntent.putExtra("uin", paramString2);
    localIntent.putExtra("istatus", paramInt);
    localIntent.putExtra("gatewayip", l.m());
    try
    {
      if (paramString3.toLowerCase().indexOf("activity", 0) != -1)
      {
        localIntent.setFlags(268435456);
        paramContext.startActivity(localIntent);
      }
      localIntent.setFlags(32);
      paramContext.sendBroadcast(localIntent);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.d("MSF.S.Util", 1, "sendBootAction " + paramContext);
      }
    }
    QLog.d("MSF.S.Util", 1, "send bootAction " + paramString3 + " for " + paramString1 + " uin:" + MsfSdkUtils.getShortUin(paramString2) + " istatus:" + paramInt);
  }
  
  public static String b(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes().get("to_SenderProcessName") != null)) {
      return (String)paramToServiceMsg.getAttributes().get("to_SenderProcessName");
    }
    return "";
  }
  
  public static boolean b()
  {
    for (;;)
    {
      try
      {
        Object localObject = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningAppProcesses();
        if (localObject == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MSF.S.Util", 2, "can not load appProcesses.");
          break;
        }
        String str = MsfSdkUtils.getProcessName(BaseApplication.getContext());
        if ((str != null) && (str.indexOf(":") > 0))
        {
          str = str.substring(0, str.indexOf(":"));
          localObject = ((List)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          boolean bool = ((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals(str);
          if (bool) {
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.d("MSF.S.Util", 1, "check isMainProcessRunning error " + localException);
        return false;
      }
    }
    return false;
  }
  
  public static String c()
  {
    b localb = c.a(BaseApplication.getContext().getPackageName());
    String str = "com.tencent.qqlite.broadcast.qq";
    if (localb != null) {
      str = localb.b();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.g
 * JD-Core Version:    0.7.0.1
 */