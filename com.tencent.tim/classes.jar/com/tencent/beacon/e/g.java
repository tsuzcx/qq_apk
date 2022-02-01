package com.tencent.beacon.e;

import android.content.Context;
import android.util.Base64;
import com.tencent.beacon.base.util.b;
import java.util.Date;

public class g
{
  private static volatile g a;
  private final String b = "sid";
  private final Context c = com.tencent.beacon.a.c.c.d().c();
  private c d;
  private String e = "";
  private boolean f = true;
  private int g = 8081;
  private String h = "";
  private String i = "";
  
  private g()
  {
    e locale = new e(this);
    com.tencent.beacon.a.b.a.a().a(locale);
  }
  
  public static g b()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new g();
      }
      return a;
    }
    finally {}
  }
  
  public String a()
  {
    try
    {
      String str = this.i;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String a(String paramString)
  {
    c localc = this.d;
    if (localc != null) {
      return localc.a(paramString);
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    try
    {
      com.tencent.beacon.a.d.a locala = com.tencent.beacon.a.d.a.a();
      String str = locala.getString("sid_value", "");
      if (locala.getLong("sid_mt", 0L) > new Date().getTime() / 1000L) {
        b(str);
      }
      a(paramContext, b.b());
      return;
    }
    finally {}
  }
  
  void a(Context paramContext, String paramString)
  {
    try
    {
      this.i = paramString;
      paramContext = com.tencent.beacon.base.net.b.c.a(paramContext, paramString);
      if (paramContext != null) {
        this.h = Base64.encodeToString(paramContext, 2);
      }
      return;
    }
    finally {}
  }
  
  public void a(c paramc)
  {
    this.d = paramc;
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      com.tencent.beacon.base.util.c.a("[net] -> update local sid|time[%s|%s].", new Object[] { paramString1, paramString2 });
      this.e = paramString1;
      com.tencent.beacon.a.b.a.a().a(new f(this, paramString2, paramString1));
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      this.e = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String c()
  {
    try
    {
      String str = this.e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String d()
  {
    try
    {
      String str = this.h;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.e.g
 * JD-Core Version:    0.7.0.1
 */