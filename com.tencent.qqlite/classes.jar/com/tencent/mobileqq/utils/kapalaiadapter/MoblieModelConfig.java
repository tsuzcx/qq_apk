package com.tencent.mobileqq.utils.kapalaiadapter;

public class MoblieModelConfig
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
  
  public void a(String paramString)
  {
    if (paramString.equalsIgnoreCase("SCH-N719"))
    {
      MobileIssueSettings.b = false;
      DualSimManager.jdField_a_of_type_Int = 3;
    }
    do
    {
      return;
      if (paramString.equalsIgnoreCase("GT-I9103"))
      {
        MobileIssueSettings.c = false;
        return;
      }
      if (paramString.equalsIgnoreCase("SCH-I779"))
      {
        MobileIssueSettings.f = false;
        return;
      }
      if (paramString.equalsIgnoreCase("GT-S5830"))
      {
        MobileIssueSettings.j = false;
        return;
      }
      if (paramString.equalsIgnoreCase("SCH-I739"))
      {
        MobileIssueSettings.i = false;
        return;
      }
    } while (!paramString.equalsIgnoreCase("GT-I9082"));
    MobileIssueSettings.l = true;
  }
  
  public void b(String paramString)
  {
    if (paramString.equalsIgnoreCase("HTC T328w"))
    {
      MobileIssueSettings.b = false;
      DualSimManager.jdField_a_of_type_Int = 5;
    }
  }
  
  public void c(String paramString)
  {
    if (paramString.equalsIgnoreCase("MOT-XT788"))
    {
      MobileIssueSettings.a = false;
      MobileIssueSettings.b = false;
      DualSimManager.jdField_a_of_type_Int = 2;
      DualSimManager.jdField_a_of_type_JavaLangString = "subscription";
    }
  }
  
  public void d(String paramString)
  {
    if (paramString.equalsIgnoreCase("HUAWEI C8812")) {
      MobileIssueSettings.d = false;
    }
    do
    {
      return;
      if (paramString.equalsIgnoreCase("HUAWEI C8813"))
      {
        MobileIssueSettings.d = false;
        return;
      }
      if (paramString.equalsIgnoreCase("HUAWEI U8825D"))
      {
        MobileIssueSettings.d = false;
        return;
      }
      if (paramString.equalsIgnoreCase("HUAWEI C8812E"))
      {
        MobileIssueSettings.d = false;
        return;
      }
    } while (!paramString.equalsIgnoreCase("HUAWEI G520-0000"));
    MobileIssueSettings.d = false;
  }
  
  public void e(String paramString)
  {
    if (paramString.equalsIgnoreCase("ZTE V889D"))
    {
      MobileIssueSettings.b = false;
      DualSimManager.jdField_a_of_type_Int = 2;
    }
    do
    {
      return;
      if (paramString.equalsIgnoreCase("ZTE-T U960s"))
      {
        MobileIssueSettings.k = false;
        return;
      }
    } while (!paramString.equalsIgnoreCase("ZTE-U V880"));
    MobileIssueSettings.d = false;
  }
  
  public void f(String paramString)
  {
    if (paramString.equalsIgnoreCase("M032")) {
      MobileIssueSettings.e = false;
    }
    do
    {
      return;
      if (paramString.equalsIgnoreCase("M030"))
      {
        MobileIssueSettings.e = false;
        return;
      }
      if (paramString.equalsIgnoreCase("M040"))
      {
        MobileIssueSettings.e = false;
        return;
      }
      if (paramString.equalsIgnoreCase("M351"))
      {
        MobileIssueSettings.e = false;
        return;
      }
    } while (!paramString.equalsIgnoreCase("M9"));
    MobileIssueSettings.e = false;
  }
  
  public void g(String paramString)
  {
    if (paramString.equalsIgnoreCase("U701")) {
      MobileIssueSettings.g = false;
    }
  }
  
  public void h(String paramString)
  {
    if (paramString.equalsIgnoreCase("T580")) {
      MobileIssueSettings.h = false;
    }
    do
    {
      return;
      if (paramString.equalsIgnoreCase("K-Touch T619"))
      {
        MobileIssueSettings.i = false;
        return;
      }
      if (paramString.equalsIgnoreCase("K-Touch T621"))
      {
        MobileIssueSettings.i = false;
        return;
      }
    } while (!paramString.equalsIgnoreCase("Haier_HT-I600"));
    MobileIssueSettings.i = false;
  }
  
  public void i(String paramString)
  {
    if (paramString.equalsIgnoreCase("8022")) {
      MobileIssueSettings.h = false;
    }
    do
    {
      return;
      if (paramString.equalsIgnoreCase("8150D"))
      {
        MobileIssueSettings.i = false;
        return;
      }
      if (paramString.equalsIgnoreCase("Coolpad 8079"))
      {
        MobileIssueSettings.i = false;
        return;
      }
    } while (!paramString.equalsIgnoreCase("Coolpad W706"));
    MobileIssueSettings.i = false;
  }
  
  public void j(String paramString)
  {
    if (paramString.equalsIgnoreCase("Lenovo A278t")) {
      MobileIssueSettings.h = false;
    }
    do
    {
      return;
      if (paramString.equalsIgnoreCase("Lenovo P700"))
      {
        MobileIssueSettings.i = false;
        return;
      }
      if (paramString.equalsIgnoreCase("Lenovo A750"))
      {
        MobileIssueSettings.i = false;
        return;
      }
      if (paramString.equalsIgnoreCase("Lenovo S880"))
      {
        MobileIssueSettings.i = false;
        return;
      }
      if (paramString.equalsIgnoreCase("Lenovo A390t"))
      {
        MobileIssueSettings.m = true;
        return;
      }
    } while (!paramString.equalsIgnoreCase("Lenovo S890"));
    MobileIssueSettings.m = true;
  }
  
  public void k(String paramString)
  {
    if (paramString.equalsIgnoreCase("vivo S11t")) {
      MobileIssueSettings.l = true;
    }
    do
    {
      return;
      if (paramString.equalsIgnoreCase("vivo S7"))
      {
        MobileIssueSettings.l = true;
        return;
      }
      if (paramString.equalsIgnoreCase("vivo Y11"))
      {
        MobileIssueSettings.l = true;
        return;
      }
      if (paramString.equalsIgnoreCase("vivo S9"))
      {
        MobileIssueSettings.l = true;
        return;
      }
      if (paramString.equalsIgnoreCase("vivo Y19t"))
      {
        MobileIssueSettings.l = true;
        return;
      }
      if (paramString.equalsIgnoreCase("vivo S12"))
      {
        MobileIssueSettings.l = true;
        return;
      }
    } while (!paramString.equalsIgnoreCase("vivo X1"));
    MobileIssueSettings.l = true;
  }
  
  public void l(String paramString)
  {
    if (paramString.equalsIgnoreCase("GN800")) {
      MobileIssueSettings.l = true;
    }
    do
    {
      return;
      if (paramString.equalsIgnoreCase("E3T"))
      {
        MobileIssueSettings.l = true;
        return;
      }
      if (paramString.equalsIgnoreCase("V182"))
      {
        MobileIssueSettings.l = true;
        return;
      }
      if ((paramString.equalsIgnoreCase("GN700W")) || (paramString.equalsIgnoreCase("GiONEE GN700W")))
      {
        MobileIssueSettings.l = true;
        return;
      }
      if (paramString.equalsIgnoreCase("GN137"))
      {
        MobileIssueSettings.l = true;
        return;
      }
      if (paramString.equalsIgnoreCase("GN700T"))
      {
        MobileIssueSettings.l = true;
        return;
      }
    } while (!paramString.equalsIgnoreCase("X805"));
    MobileIssueSettings.l = true;
  }
  
  public void m(String paramString)
  {
    if (paramString.equalsIgnoreCase("T730")) {
      MobileIssueSettings.i = false;
    }
  }
  
  public void n(String paramString)
  {
    if (paramString.equalsIgnoreCase("DOOV S1")) {
      MobileIssueSettings.l = true;
    }
  }
  
  public void o(String paramString)
  {
    if (paramString.equalsIgnoreCase("LT26i")) {
      MobileIssueSettings.m = true;
    }
    while (!paramString.equalsIgnoreCase("LT18i")) {
      return;
    }
    MobileIssueSettings.m = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.MoblieModelConfig
 * JD-Core Version:    0.7.0.1
 */