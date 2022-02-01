package com.tencent.token;

import android.text.TextUtils;
import java.io.File;

public class zz
{
  private static zz c;
  private String a;
  private aaa b;
  
  public static zz e()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new zz();
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
      File localFile = zw.a("qqpimdownload");
      if (localFile != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localFile.getAbsolutePath());
        localStringBuilder.append(File.separator);
        this.a = localStringBuilder.toString();
      }
    }
    return this.a;
  }
  
  public final void a()
  {
    aaa localaaa = this.b;
    if (localaaa == null) {
      return;
    }
    localaaa.a();
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, zy paramzy)
  {
    if (TextUtils.isEmpty(null)) {
      paramString2 = g();
    }
    if (TextUtils.isEmpty(null)) {
      paramString3 = "qqpim_6.9.20.247000_106613.apk";
    }
    this.b = new aaa(new aab(paramString1, paramString2, paramString3), paramzy);
  }
  
  public final void b()
  {
    aaa localaaa = this.b;
    if (localaaa == null) {
      return;
    }
    localaaa.b();
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
    aaa localaaa = this.b;
    if (localaaa == null) {
      return false;
    }
    return localaaa.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zz
 * JD-Core Version:    0.7.0.1
 */