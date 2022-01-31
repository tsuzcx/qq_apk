package com.tencent.beacon.event;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class d
  implements Cloneable
{
  private int a = 12;
  private int b = 60;
  private int c = 12;
  private int d = 60;
  private int e = 20;
  private int f = 61440;
  private int g = 10240;
  private int h = 2097152;
  private int i = 60;
  private int j = 600;
  private boolean k = true;
  private int l = 30;
  private boolean m = true;
  private boolean n = true;
  private Set<String> o = null;
  
  private void a(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.a = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.b = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.c = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void d(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.d = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void e(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.e = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void f(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.h = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void g(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.f = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void h(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.g = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private d o()
  {
    try
    {
      d locald = new d();
      locald.d(this.d);
      locald.c(this.c);
      locald.e(this.e);
      locald.h(this.g);
      locald.g(this.f);
      locald.f(this.h);
      locald.b(this.b);
      locald.a(this.a);
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int a()
  {
    try
    {
      int i1 = this.a;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(Map<String, String> paramMap)
  {
    if (paramMap != null) {}
    for (;;)
    {
      String str;
      try
      {
        str = (String)paramMap.get("realNumUp");
        int i1;
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 > 0) && (i1 <= 50)) {
            this.a = i1;
          }
        }
        str = (String)paramMap.get("realDelayUp");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 >= 10) && (i1 <= 600)) {
            this.b = i1;
          }
        }
        str = (String)paramMap.get("comNumDB");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 > 0) && (i1 <= 50)) {
            this.c = i1;
          }
        }
        str = (String)paramMap.get("comDelayDB");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 >= 60) && (i1 <= 600)) {
            this.d = i1;
          }
        }
        str = (String)paramMap.get("comNumUp");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 > 0) && (i1 <= 100)) {
            this.e = i1;
          }
        }
        str = (String)paramMap.get("sizeUpWifi");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 >= 10240) && (i1 <= 102400)) {
            this.f = i1;
          }
        }
        str = (String)paramMap.get("sizeUpNoWifi");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 >= 5120) && (i1 <= 51200)) {
            this.g = i1;
          }
        }
        str = (String)paramMap.get("dailyNetFlowLimit");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 >= 204800) && (i1 <= 10485760)) {
            this.h = i1;
          }
        }
        str = (String)paramMap.get("runInfoPeriod");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 >= 30) && (i1 <= 300)) {
            this.i = i1;
          }
        }
        str = (String)paramMap.get("useTimeUpPeriod");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 >= 300) && (i1 <= 1800)) {
            this.j = i1;
          }
        }
        str = (String)paramMap.get("useTimeOnOff");
        if (str != null)
        {
          if (!str.toLowerCase().equals("y")) {
            continue;
          }
          this.k = true;
        }
        str = (String)paramMap.get("proChangePeriod");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 >= 10) && (i1 <= 300)) {
            this.l = i1;
          }
        }
        str = (String)paramMap.get("proChangeOnOff");
        if (str != null)
        {
          if (!str.toLowerCase().equals("y")) {
            break label594;
          }
          this.m = true;
        }
        paramMap = (String)paramMap.get("heartOnOff");
        if (paramMap != null)
        {
          if (!paramMap.toLowerCase().equals("y")) {
            break label614;
          }
          this.n = true;
        }
      }
      catch (Exception paramMap)
      {
        paramMap.printStackTrace();
        continue;
      }
      finally {}
      return;
      if (str.toLowerCase().equals("n"))
      {
        this.k = false;
        continue;
        label594:
        if (str.toLowerCase().equals("n"))
        {
          this.m = false;
          continue;
          label614:
          if (paramMap.toLowerCase().equals("n")) {
            this.n = false;
          }
        }
      }
    }
  }
  
  public final void a(Set<String> paramSet)
  {
    try
    {
      this.o = paramSet;
      return;
    }
    finally
    {
      paramSet = finally;
      throw paramSet;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.k = false;
  }
  
  public final boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.o != null)
      {
        bool1 = bool2;
        if (this.o.size() > 0) {
          bool1 = this.o.contains(paramString);
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public final int b()
  {
    try
    {
      int i1 = this.b;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int c()
  {
    try
    {
      int i1 = this.c;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int d()
  {
    try
    {
      int i1 = this.d;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int e()
  {
    try
    {
      int i1 = this.e;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int f()
  {
    try
    {
      int i1 = this.h;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int g()
  {
    try
    {
      int i1 = this.f;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int h()
  {
    try
    {
      int i1 = this.g;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int i()
  {
    try
    {
      int i1 = this.j;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int j()
  {
    return this.i;
  }
  
  public final boolean k()
  {
    return this.k;
  }
  
  public final int l()
  {
    return this.l;
  }
  
  public final boolean m()
  {
    return this.m;
  }
  
  public final boolean n()
  {
    return this.n;
  }
  
  public final String toString()
  {
    try
    {
      String str = String.format(Locale.US, "[rnum:%d,rdelay:%d,cndb:%d,cdelay:%d,csWifi:%d,csGPRS:%d,cnum:%d,dLimit:%d]", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.g), Integer.valueOf(this.h) });
      return str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        Object localObject1 = null;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.event.d
 * JD-Core Version:    0.7.0.1
 */