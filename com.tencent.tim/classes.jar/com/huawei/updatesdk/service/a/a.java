package com.huawei.updatesdk.service.a;

import android.content.Context;
import android.text.TextUtils;

public final class a
{
  private static final Object a = new Object();
  private static a b;
  private b c;
  private String d;
  
  private a(Context paramContext)
  {
    this.c = b.a("DeviceSessionUpdateSDK_V1", paramContext);
  }
  
  public static a a()
  {
    synchronized (a)
    {
      if (b == null) {
        b = new a(com.huawei.updatesdk.a.b.a.a.a().b());
      }
      a locala = b;
      return locala;
    }
  }
  
  public void a(long paramLong)
  {
    this.c.a("updatesdk.lastCheckDate", paramLong);
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    this.c.a(paramString1, paramString2);
  }
  
  public long b()
  {
    return this.c.b("updatesdk.lastCheckDate", 0L);
  }
  
  public void b(long paramLong)
  {
    this.c.a("updatesdk.lastInitAccountTime", paramLong);
  }
  
  public void b(String paramString)
  {
    this.c.a("updatesdk.lastAccountZone", paramString);
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return this.c.b(paramString, "");
  }
  
  public long d()
  {
    return this.c.b("updatesdk.lastInitAccountTime", 0L);
  }
  
  public void d(String paramString)
  {
    this.c.a(paramString);
  }
  
  public String e()
  {
    return this.c.b("updatesdk.lastAccountZone", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.a.a
 * JD-Core Version:    0.7.0.1
 */