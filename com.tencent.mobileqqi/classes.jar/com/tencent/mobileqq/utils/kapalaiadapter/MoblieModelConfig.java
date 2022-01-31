package com.tencent.mobileqq.utils.kapalaiadapter;

public class MoblieModelConfig
  implements IMoblieModelConfig
{
  private static MoblieModelConfig a;
  
  public static MoblieModelConfig a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new MoblieModelConfig();
      }
      return a;
    }
    finally {}
  }
  
  private String a(String paramString)
  {
    return "_" + paramString.replaceAll("[-\\s+]", "_").toUpperCase();
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = IMoblieModelConfig.SAMSUNG.valueOf(a(paramString));
      int i = her.a[paramString.ordinal()];
      switch (i)
      {
      }
      for (;;)
      {
        i = her.a[paramString.ordinal()];
        return;
        MobileIssueSettings.b = false;
        DualSimManager.jdField_a_of_type_Int = 3;
        continue;
        MobileIssueSettings.c = false;
        continue;
        MobileIssueSettings.f = false;
        continue;
        MobileIssueSettings.j = false;
        continue;
        MobileIssueSettings.j = false;
        continue;
        MobileIssueSettings.i = false;
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void b(String paramString)
  {
    try
    {
      paramString = IMoblieModelConfig.HTC.valueOf(a(paramString));
      switch (her.b[paramString.ordinal()])
      {
      default: 
        return;
      }
      MobileIssueSettings.b = false;
      DualSimManager.jdField_a_of_type_Int = 5;
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void c(String paramString)
  {
    try
    {
      paramString = IMoblieModelConfig.MOTOROLA.valueOf(a(paramString));
      switch (her.c[paramString.ordinal()])
      {
      default: 
        return;
      case 1: 
        MobileIssueSettings.a = false;
        MobileIssueSettings.b = false;
        DualSimManager.jdField_a_of_type_Int = 2;
        DualSimManager.jdField_a_of_type_JavaLangString = "subscription";
        return;
      }
      MobileIssueSettings.d = false;
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void d(String paramString)
  {
    try
    {
      paramString = IMoblieModelConfig.HUAWEI.valueOf(a(paramString));
      switch (her.d[paramString.ordinal()])
      {
      default: 
        return;
      case 1: 
        MobileIssueSettings.d = false;
        return;
      case 2: 
        MobileIssueSettings.d = false;
        return;
      case 3: 
        MobileIssueSettings.d = false;
        return;
      case 4: 
        MobileIssueSettings.d = false;
        return;
      }
      MobileIssueSettings.d = false;
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void e(String paramString)
  {
    try
    {
      paramString = IMoblieModelConfig.ZTE.valueOf(a(paramString));
      switch (her.e[paramString.ordinal()])
      {
      default: 
        return;
      case 1: 
        MobileIssueSettings.b = false;
        DualSimManager.jdField_a_of_type_Int = 2;
        return;
      case 2: 
        MobileIssueSettings.d = false;
        return;
      }
      MobileIssueSettings.k = false;
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void f(String paramString)
  {
    try
    {
      IMoblieModelConfig.HISENSE.valueOf(a(paramString));
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void g(String paramString)
  {
    try
    {
      IMoblieModelConfig.XIAOMI.valueOf(a(paramString));
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void h(String paramString)
  {
    try
    {
      paramString = IMoblieModelConfig.MEIZU.valueOf(a(paramString));
      switch (her.f[paramString.ordinal()])
      {
      default: 
        return;
      case 1: 
        MobileIssueSettings.e = false;
        return;
      case 2: 
        MobileIssueSettings.e = false;
        return;
      case 3: 
        MobileIssueSettings.e = false;
        return;
      case 4: 
        MobileIssueSettings.e = false;
        return;
      }
      MobileIssueSettings.e = false;
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void i(String paramString)
  {
    try
    {
      paramString = IMoblieModelConfig.ALPS.valueOf(a(paramString));
      switch (her.g[paramString.ordinal()])
      {
      default: 
        return;
      }
      MobileIssueSettings.g = false;
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void j(String paramString)
  {
    try
    {
      paramString = IMoblieModelConfig.K_TOUCH.valueOf(a(paramString));
      switch (her.h[paramString.ordinal()])
      {
      default: 
        return;
      case 1: 
        MobileIssueSettings.h = false;
        return;
      case 2: 
        MobileIssueSettings.i = false;
        return;
      case 3: 
        MobileIssueSettings.i = false;
        return;
      }
      MobileIssueSettings.i = false;
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void k(String paramString)
  {
    try
    {
      paramString = IMoblieModelConfig.YULONG.valueOf(a(paramString));
      switch (her.i[paramString.ordinal()])
      {
      default: 
        return;
      case 1: 
        MobileIssueSettings.h = false;
        return;
      case 2: 
        MobileIssueSettings.i = false;
        return;
      case 3: 
        MobileIssueSettings.i = false;
        return;
      }
      MobileIssueSettings.i = false;
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void l(String paramString)
  {
    try
    {
      paramString = IMoblieModelConfig.LENOVO.valueOf(a(paramString));
      switch (her.j[paramString.ordinal()])
      {
      default: 
        return;
      case 1: 
        MobileIssueSettings.h = false;
        return;
      case 2: 
        MobileIssueSettings.i = false;
        return;
      case 3: 
        MobileIssueSettings.i = false;
        return;
      }
      MobileIssueSettings.i = false;
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void m(String paramString)
  {
    try
    {
      paramString = IMoblieModelConfig.VIVO.valueOf(a(paramString));
      switch (her.k[paramString.ordinal()])
      {
      default: 
        return;
      case 1: 
        MobileIssueSettings.l = true;
        return;
      case 2: 
        MobileIssueSettings.l = true;
        return;
      case 3: 
        MobileIssueSettings.l = true;
        return;
      case 4: 
        MobileIssueSettings.l = true;
        return;
      case 5: 
        MobileIssueSettings.l = true;
        return;
      case 6: 
        MobileIssueSettings.l = true;
        return;
      }
      MobileIssueSettings.l = true;
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void n(String paramString)
  {
    try
    {
      paramString = IMoblieModelConfig.GIONEE.valueOf(a(paramString));
      switch (her.l[paramString.ordinal()])
      {
      default: 
        return;
      case 1: 
        MobileIssueSettings.l = true;
        return;
      case 2: 
        MobileIssueSettings.l = true;
        return;
      case 3: 
        MobileIssueSettings.l = true;
        return;
      case 4: 
      case 5: 
        MobileIssueSettings.l = true;
        return;
      case 6: 
        MobileIssueSettings.l = true;
        return;
      case 7: 
        MobileIssueSettings.l = true;
        return;
      }
      MobileIssueSettings.l = true;
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void o(String paramString)
  {
    try
    {
      paramString = IMoblieModelConfig.ETON.valueOf(a(paramString));
      switch (her.m[paramString.ordinal()])
      {
      default: 
        return;
      }
      MobileIssueSettings.i = false;
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void p(String paramString)
  {
    try
    {
      IMoblieModelConfig.OTHERPHONE.valueOf(a(paramString));
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.MoblieModelConfig
 * JD-Core Version:    0.7.0.1
 */