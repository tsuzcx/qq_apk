package com.tencent.token;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

public class za
{
  private static za c;
  private String a;
  private zb b;
  
  public static za e()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new za();
        }
      }
      finally {}
    }
    return c;
  }
  
  private String g()
  {
    if (TextUtils.isEmpty(this.a))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("qqpimdownload");
      localStringBuilder.append(File.separator);
      this.a = localStringBuilder.toString();
    }
    return this.a;
  }
  
  public final void a()
  {
    zb localzb = this.b;
    if (localzb == null) {
      return;
    }
    localzb.a();
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, yz paramyz)
  {
    if (TextUtils.isEmpty(null)) {
      paramString2 = g();
    }
    if (TextUtils.isEmpty(null)) {
      paramString3 = "qqpim_6.9.20.247000_106613.apk";
    }
    this.b = new zb(new zc(paramString1, paramString2, paramString3), paramyz);
  }
  
  public final void b()
  {
    zb localzb = this.b;
    if (localzb == null) {
      return;
    }
    localzb.b();
  }
  
  public final boolean c()
  {
    try
    {
      boolean bool = new File(g(), "qqpim_6.9.20.247000_106613.apk").exists();
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public final String d()
  {
    try
    {
      String str = new File(g(), "qqpim_6.9.20.247000_106613.apk").getAbsolutePath();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public final boolean f()
  {
    zb localzb = this.b;
    if (localzb == null) {
      return false;
    }
    return localzb.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.za
 * JD-Core Version:    0.7.0.1
 */