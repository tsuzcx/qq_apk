package com.tencent.token;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

public class cz
{
  private static cz c;
  private String a;
  private da b;
  
  public static cz f()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new cz();
        }
      }
      finally {}
    }
    return c;
  }
  
  private String h()
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
  
  public void a()
  {
    da localda = this.b;
    if (localda == null) {
      return;
    }
    localda.a();
  }
  
  public void a(cy paramcy)
  {
    a("http://qqwx.qq.com/s?aid=index&p=11&c=106613&vt=1&pf=0", null, null, paramcy);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, cy paramcy)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = h();
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = b();
    }
    this.b = new da(new db(paramString1, str, paramString2), paramcy);
  }
  
  public String b()
  {
    return "qqpim_6.9.20.247000_106613.apk";
  }
  
  public void b(cy paramcy)
  {
    a("http://qqwx.qq.com/s?aid=index&p=11&c=106613&vt=1&pf=0", null, null, paramcy);
  }
  
  public void c()
  {
    da localda = this.b;
    if (localda == null) {
      return;
    }
    localda.b();
  }
  
  public boolean d()
  {
    try
    {
      boolean bool = new File(h(), b()).exists();
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public String e()
  {
    try
    {
      String str = new File(h(), b()).getAbsolutePath();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public boolean g()
  {
    da localda = this.b;
    if (localda == null) {
      return false;
    }
    return localda.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cz
 * JD-Core Version:    0.7.0.1
 */