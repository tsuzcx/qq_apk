package com.tencent.mobileqq.msf.sdk;

import android.telephony.TelephonyManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class g
{
  private static String a = "MSF.D.AppNetSubscriptionManager";
  
  public static int a(TelephonyManager paramTelephonyManager, int paramInt)
  {
    try
    {
      Method localMethod = TelephonyManager.class.getDeclaredMethod("getNetworkClass", new Class[] { Integer.TYPE });
      localMethod.setAccessible(true);
      paramInt = ((Integer)localMethod.invoke(paramTelephonyManager, new Object[] { Integer.valueOf(paramInt) })).intValue();
      return paramInt;
    }
    catch (Exception paramTelephonyManager)
    {
      QLog.e(a, 1, "getSystemNetworkClass excep!", paramTelephonyManager);
    }
    return 1;
  }
  
  public static int a(Object paramObject)
  {
    if (paramObject == null) {
      return -1;
    }
    try
    {
      Method localMethod1 = paramObject.getClass().getDeclaredMethod("getDefaultDataSubId", new Class[0]);
      localMethod1.setAccessible(true);
      i = ((Integer)localMethod1.invoke(paramObject, new Object[0])).intValue();
      return i;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      try
      {
        Method localMethod2 = paramObject.getClass().getDeclaredMethod("getDefaultDataSubscriptionId", new Class[0]);
        localMethod2.setAccessible(true);
        i = ((Integer)localMethod2.invoke(paramObject, new Object[0])).intValue();
        return i;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          int i;
          if (QLog.isColorLevel())
          {
            QLog.w(a, 2, "getDefaultDataSubscriptionId excep!", paramObject);
            i = -1;
          }
          else
          {
            QLog.w(a, 2, "getDefaultDataSubscriptionId excep!");
            i = -1;
          }
        }
      }
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel())
      {
        QLog.w(a, 2, "getDefaultDataSubId excep!", paramObject);
        return -1;
      }
      QLog.w(a, 2, "getDefaultDataSubId excep!");
    }
    return -1;
  }
  
  public static Object a(TelephonyManager paramTelephonyManager)
  {
    try
    {
      Field localField = TelephonyManager.class.getDeclaredField("mSubscriptionManager");
      localField.setAccessible(true);
      paramTelephonyManager = localField.get(paramTelephonyManager);
      return paramTelephonyManager;
    }
    catch (Exception paramTelephonyManager)
    {
      if (QLog.isColorLevel())
      {
        QLog.w(a, 2, "getSubscriptionManager excep!", paramTelephonyManager);
        return null;
      }
      QLog.w(a, 2, "getSubscriptionManager excep!");
    }
    return null;
  }
  
  public static int b(TelephonyManager paramTelephonyManager)
  {
    long l = System.currentTimeMillis();
    int k = a(a(paramTelephonyManager));
    int i;
    if (k == -1) {
      i = paramTelephonyManager.getNetworkType();
    }
    for (;;)
    {
      return i;
      try
      {
        Method localMethod = TelephonyManager.class.getDeclaredMethod("getNetworkType", new Class[] { Integer.TYPE });
        localMethod.setAccessible(true);
        i = ((Integer)localMethod.invoke(paramTelephonyManager, new Object[] { Integer.valueOf(k) })).intValue();
        int j = y.a(i);
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(a, 2, "getNetworkType:" + j + " ,simID:" + k + " ,cost:" + (System.currentTimeMillis() - l));
        return j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e(a, 1, "getNetworkType excep!", localException);
          try
          {
            i = paramTelephonyManager.getNetworkType();
          }
          catch (SecurityException paramTelephonyManager)
          {
            QLog.e(a, 1, "getNetworkType se", localException);
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.g
 * JD-Core Version:    0.7.0.1
 */