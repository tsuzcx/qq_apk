package com.tencent.mobileqq.utils.kapalaiadapter;

import android.os.Build;

public class MobileIssueSettings
{
  public static boolean a = true;
  public static boolean b = true;
  public static boolean c = true;
  public static boolean d = true;
  public static boolean e = true;
  public static boolean f = true;
  public static boolean g = true;
  public static boolean h = true;
  public static boolean i = true;
  public static boolean j = true;
  public static boolean k = true;
  public static boolean l = false;
  
  static
  {
    String str1 = Build.MODEL.toLowerCase();
    String str2 = Build.MANUFACTURER.toLowerCase();
    if (str2.indexOf("htc") >= 0) {
      MoblieModelConfig.a().b(str1);
    }
    do
    {
      do
      {
        return;
        if (str2.indexOf("samsung") >= 0)
        {
          MoblieModelConfig.a().a(str1);
          return;
        }
        if (str2.indexOf("motorola") >= 0)
        {
          MoblieModelConfig.a().c(str1);
          return;
        }
        if (str2.indexOf("huawei") >= 0)
        {
          MoblieModelConfig.a().d(str1);
          return;
        }
      } while ((str2.indexOf("hisense") >= 0) || (str2.indexOf("xiaomi") >= 0));
      if (str2.indexOf("zte") >= 0)
      {
        MoblieModelConfig.a().e(str1);
        return;
      }
      if (str2.indexOf("meizu") >= 0)
      {
        MoblieModelConfig.a().h(str1);
        return;
      }
      if (str2.indexOf("alps") >= 0)
      {
        MoblieModelConfig.a().i(str1);
        return;
      }
      if ((str2.indexOf("k-touch") >= 0) || (str2.indexOf("sprd") >= 0))
      {
        MoblieModelConfig.a().j(str1);
        return;
      }
      if ((str2.indexOf("yulong") >= 0) || (str2.indexOf("coolpad") >= 0))
      {
        MoblieModelConfig.a().k(str1);
        return;
      }
      if (str2.indexOf("lenovo") >= 0)
      {
        MoblieModelConfig.a().l(str1);
        return;
      }
      if (str2.indexOf("bbk") >= 0)
      {
        MoblieModelConfig.a().m(str1);
        return;
      }
      if (str2.indexOf("gionee") >= 0)
      {
        MoblieModelConfig.a().n(str1);
        return;
      }
    } while (str2.indexOf("eton") < 0);
    MoblieModelConfig.a().o(str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings
 * JD-Core Version:    0.7.0.1
 */