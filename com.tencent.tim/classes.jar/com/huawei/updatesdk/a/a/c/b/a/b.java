package com.huawei.updatesdk.a.a.c.b.a;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class b
{
  private static a.a a = a.a.a;
  private static a b;
  
  public static a a()
  {
    b();
    if (a == a.a.d) {}
    for (b = d.b();; b = c.b()) {
      return b;
    }
  }
  
  public static boolean b()
  {
    boolean bool = false;
    if (a != a.a.a)
    {
      if ((a == a.a.c) || (a == a.a.d)) {
        bool = true;
      }
      return bool;
    }
    if (d())
    {
      a = a.a.d;
      return true;
    }
    if (c())
    {
      a = a.a.c;
      return true;
    }
    a = a.a.b;
    return false;
  }
  
  public static boolean c()
  {
    bool1 = false;
    try
    {
      Object localObject = c.c();
      if (localObject == null) {
        break label168;
      }
      localObject = localObject.getClass().getMethod("isMultiSimEnabled", new Class[0]).invoke(localObject, new Object[0]);
      if (!(localObject instanceof Boolean)) {
        break label168;
      }
      boolean bool2 = ((Boolean)localObject).booleanValue();
      bool1 = bool2;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.d("mutiCardFactory", "MSimTelephonyManager.getDefault().isMultiSimEnabled()?" + localNoSuchMethodException.toString());
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.d("mutiCardFactory", "MSimTelephonyManager.getDefault().isMultiSimEnabled()" + localIllegalAccessException.toString());
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.d("mutiCardFactory", "MSimTelephonyManager.getDefault().isMultiSimEnabled()" + localInvocationTargetException.toString());
        continue;
        bool1 = false;
      }
    }
    com.huawei.updatesdk.a.a.b.a.a.a.a("mutiCardFactory", "isHwGeminiSupport1 " + bool1);
    return bool1;
  }
  
  private static boolean d()
  {
    boolean bool1 = false;
    try
    {
      Field localField = Class.forName("com.mediatek.common.featureoption.FeatureOption").getDeclaredField("MTK_GEMINI_SUPPORT");
      localField.setAccessible(true);
      boolean bool2 = localField.getBoolean(null);
      bool1 = bool2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.b("mutiCardFactory", "FeatureOption.MTK_GEMINI_SUPPORT" + localClassNotFoundException.toString());
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.b("mutiCardFactory", "FeatureOption.MTK_GEMINI_SUPPORT" + localNoSuchFieldException.toString());
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.b("mutiCardFactory", "FeatureOption.MTK_GEMINI_SUPPORT" + localIllegalAccessException.toString());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.b("mutiCardFactory", "FeatureOption.MTK_GEMINI_SUPPORT" + localException.toString());
      }
    }
    com.huawei.updatesdk.a.a.b.a.a.a.a("mutiCardFactory", "isMtkGeminiSupport " + bool1);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.c.b.a.b
 * JD-Core Version:    0.7.0.1
 */