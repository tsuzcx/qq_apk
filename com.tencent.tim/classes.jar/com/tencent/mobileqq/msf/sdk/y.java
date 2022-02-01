package com.tencent.mobileqq.msf.sdk;

import alky;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.HashMap;

public class y
{
  public static final int a = 29;
  private static final String b = "MSF.C.NetworkType5GWrapper";
  private static final String c = "nrState=";
  private static final String d = "NetworkRegistrationInfo";
  private static final String e = "NONE";
  private static final String f = "RESTRICTED";
  private static final String g = "NOT_RESTRICTED";
  private static final String h = "CONNECTED";
  private static final String[] i = { "NONE", "RESTRICTED", "NOT_RESTRICTED", "CONNECTED" };
  private static final String j = "evt_five_g_network_type";
  private static final String k = "evt_read_phone_state_per";
  private static final String l = "user_uin";
  private static final String m = "has_read_phone_per";
  private static final String n = "is_five_g";
  private static final long o = 86400000L;
  private static final String p = "sp_network";
  private static final String q = "last_report_5g_network_type";
  private static final String r = "last_report_read_phone_state_per_time";
  private static long s = c("last_report_5g_network_type");
  private static long t = c("last_report_read_phone_state_per_time");
  
  public static int a(int paramInt)
  {
    try
    {
      int i1 = b(paramInt);
      return i1;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MSF.C.NetworkType5GWrapper", 1, "getNetworkTypeWhenSDKVerAboveQ throw e", localThrowable);
    }
    return paramInt;
  }
  
  private static ServiceState a()
  {
    Object localObject = BaseApplication.getContext();
    TelephonyManager localTelephonyManager = (TelephonyManager)((Context)localObject).getSystemService("phone");
    if ((Build.VERSION.SDK_INT >= 26) && (localTelephonyManager != null) && (((Context)localObject).checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
      try
      {
        int i1 = g.a(g.a(localTelephonyManager));
        if (i1 < 0) {
          return alky.a(localTelephonyManager);
        }
        localObject = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", new Class[] { Integer.TYPE });
        ((Method)localObject).setAccessible(true);
        localObject = (ServiceState)((Method)localObject).invoke(localTelephonyManager, new Object[] { Integer.valueOf(i1) });
        return localObject;
      }
      catch (Exception localException)
      {
        QLog.e("MSF.C.NetworkType5GWrapper", 1, "getServiceState throw e", localException);
        return alky.a(localTelephonyManager);
      }
    }
    return null;
  }
  
  private static void a(k paramk, int paramInt, String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - t <= 86400000L) {
      return;
    }
    t = l1;
    a("last_report_read_phone_state_per_time", l1);
    HashMap localHashMap;
    if (BaseApplication.getContext().checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)
    {
      bool = true;
      localHashMap = new HashMap();
      localHashMap.put("user_uin", paramString);
      localHashMap.put("has_read_phone_per", String.valueOf(bool));
      if (paramInt != 20) {
        break label114;
      }
    }
    label114:
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("is_five_g", String.valueOf(bool));
      paramk.a("evt_read_phone_state_per", true, 0L, 0L, localHashMap, false, false);
      return;
      bool = false;
      break;
    }
  }
  
  private static void a(String paramString, long paramLong)
  {
    BaseApplication.getContext().getSharedPreferences("sp_network", 0).edit().putLong(paramString, paramLong).apply();
  }
  
  private static boolean a(String paramString)
  {
    return (TextUtils.equals(paramString, "CONNECTED")) || (TextUtils.equals(paramString, "NOT_RESTRICTED"));
  }
  
  private static int b(int paramInt)
  {
    int i1;
    if (Build.VERSION.SDK_INT < 29) {
      i1 = paramInt;
    }
    for (;;)
    {
      try
      {
        d(i1);
        return i1;
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        QLog.e("MSF.C.NetworkType5GWrapper", 1, "reportIfNeed throw t", localThrowable);
        return i1;
      }
      i1 = paramInt;
      if (paramInt != 20) {
        if (paramInt != 13)
        {
          i1 = paramInt;
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.NetworkType5GWrapper", 2, "networkType != LTE");
            i1 = paramInt;
          }
        }
        else if (Build.MANUFACTURER.equalsIgnoreCase("huawei"))
        {
          paramInt = c(paramInt);
          i1 = paramInt;
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.NetworkType5GWrapper", 2, "getHwNetworkType = " + paramInt);
            i1 = paramInt;
          }
        }
        else
        {
          localObject = a();
          if (localObject == null)
          {
            localObject = "";
            if (a(b((String)localObject)))
            {
              if (!QLog.isColorLevel()) {
                break label191;
              }
              QLog.d("MSF.C.NetworkType5GWrapper", 2, "getNetworkTypeWhenSDKVerAboveQ, res is nr last");
              i1 = 20;
            }
          }
          else
          {
            localObject = ((ServiceState)localObject).toString();
            continue;
          }
          i1 = paramInt;
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.NetworkType5GWrapper", 2, "go end");
            i1 = paramInt;
            continue;
            label191:
            i1 = 20;
          }
        }
      }
    }
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetworkType5GWrapper", 2, "strServiceState is empty");
      }
    }
    label79:
    Object localObject;
    do
    {
      do
      {
        return "NONE";
        paramString = paramString.split("NetworkRegistrationInfo");
        if (paramString.length > 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MSF.C.NetworkType5GWrapper", 2, "strArr.len = " + paramString.length);
      return "NONE";
      i1 = paramString.length - 1;
      if (i1 < 1) {
        break label277;
      }
      localObject = paramString[i1];
      if ((!localObject.contains("domain=PS")) || (!localObject.contains("transportType=WWAN"))) {
        break label272;
      }
      i1 = localObject.indexOf("nrState=");
      if (i1 >= 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.NetworkType5GWrapper", 2, "paramStartIndex = " + i1);
    return "NONE";
    int i2 = i1 + "nrState=".length();
    int i1 = 0;
    if (i1 < i.length)
    {
      String str = i[i1];
      int i3 = str.length() + i2;
      if (i3 > localObject.length()) {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetworkType5GWrapper", 2, "nrStateEndIndex = " + i3 + ", strNetworkRegistrationInfo.len = " + localObject.length());
        }
      }
      do
      {
        i1 += 1;
        break;
        paramString = localObject.substring(i2, i3);
      } while (!str.equalsIgnoreCase(paramString));
    }
    for (;;)
    {
      return paramString;
      label272:
      i1 -= 1;
      break label79;
      label277:
      break;
      paramString = "NONE";
    }
  }
  
  private static void b(k paramk, int paramInt, String paramString)
  {
    long l1 = System.currentTimeMillis();
    if ((paramInt != 20) || (l1 - s <= 86400000L)) {
      return;
    }
    s = l1;
    a("last_report_5g_network_type", l1);
    HashMap localHashMap = new HashMap();
    localHashMap.put("user_uin", paramString);
    paramk.a("evt_five_g_network_type", true, 0L, 0L, localHashMap, false, false);
  }
  
  private static int c(int paramInt)
  {
    Object localObject2 = BaseApplication.getContext();
    Object localObject1 = a();
    int i1 = paramInt;
    if (Build.VERSION.SDK_INT >= 26)
    {
      i1 = paramInt;
      if (localObject1 != null)
      {
        i1 = paramInt;
        if (((Context)localObject2).checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {}
      }
    }
    try
    {
      localObject2 = ServiceState.class.getMethod("getHwNetworkType", new Class[0]);
      ((Method)localObject2).setAccessible(true);
      localObject1 = (Integer)((Method)localObject2).invoke(localObject1, new Object[0]);
      i1 = paramInt;
      if (localObject1 != null)
      {
        int i2 = ((Integer)localObject1).intValue();
        i1 = paramInt;
        if (i2 == 20) {
          i1 = 20;
        }
      }
      return i1;
    }
    catch (Exception localException)
    {
      QLog.e("MSF.C.NetworkType5GWrapper", 1, "getHwNetworkType throw ex", localException);
    }
    return paramInt;
  }
  
  private static long c(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("sp_network", 0).getLong(paramString, 0L);
  }
  
  private static void d(int paramInt)
  {
    k localk = MsfCore.sCore.statReporter;
    if ((localk == null) || (Build.VERSION.SDK_INT < 29)) {
      return;
    }
    String str = MsfCore.sCore.getAccountCenter().i();
    a(localk, paramInt, str);
    b(localk, paramInt, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.y
 * JD-Core Version:    0.7.0.1
 */