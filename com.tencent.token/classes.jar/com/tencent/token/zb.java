package com.tencent.token;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

public class zb
{
  private static zb c;
  private String a;
  private zc b;
  
  public static zb e()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new zb();
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
    zc localzc = this.b;
    if (localzc == null) {
      return;
    }
    localzc.a();
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, za paramza)
  {
    if (TextUtils.isEmpty(null)) {
      paramString2 = g();
    }
    if (TextUtils.isEmpty(null)) {
      paramString3 = "qqpim_6.9.20.247000_106613.apk";
    }
    this.b = new zc(new zd(paramString1, paramString2, paramString3), paramza);
  }
  
  public final void b()
  {
    zc localzc = this.b;
    if (localzc == null) {
      return;
    }
    localzc.b();
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
    zc localzc = this.b;
    if (localzc == null) {
      return false;
    }
    return localzc.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zb
 * JD-Core Version:    0.7.0.1
 */