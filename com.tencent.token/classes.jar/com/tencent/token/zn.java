package com.tencent.token;

import android.text.TextUtils;
import java.io.File;

public class zn
{
  private static zn c;
  private String a;
  private zo b;
  
  public static zn e()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new zn();
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
      File localFile = zk.a("qqpimdownload");
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
    zo localzo = this.b;
    if (localzo == null) {
      return;
    }
    localzo.a();
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, zm paramzm)
  {
    if (TextUtils.isEmpty(null)) {
      paramString2 = g();
    }
    if (TextUtils.isEmpty(null)) {
      paramString3 = "qqpim_6.9.20.247000_106613.apk";
    }
    this.b = new zo(new zp(paramString1, paramString2, paramString3), paramzm);
  }
  
  public final void b()
  {
    zo localzo = this.b;
    if (localzo == null) {
      return;
    }
    localzo.b();
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
    zo localzo = this.b;
    if (localzo == null) {
      return false;
    }
    return localzo.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zn
 * JD-Core Version:    0.7.0.1
 */