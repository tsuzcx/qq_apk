package com.tencent.token;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

public class dz
{
  private static dz c;
  private String a;
  private ea b;
  
  public static dz f()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new dz();
      }
      return c;
    }
    finally {}
  }
  
  private String h()
  {
    if (TextUtils.isEmpty(this.a)) {
      this.a = (Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qqpimdownload" + File.separator);
    }
    return this.a;
  }
  
  public void a()
  {
    if (this.b == null) {
      return;
    }
    this.b.a();
  }
  
  public void a(dy paramdy)
  {
    a("http://qqwx.qq.com/s?aid=index&p=11&c=106613&vt=1&pf=0", null, null, paramdy);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, dy paramdy)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = h();
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = b();
    }
    this.b = new ea(new ed(paramString1, str, paramString2), paramdy);
  }
  
  public String b()
  {
    return "qqpim_6.9.20.247000_106613.apk";
  }
  
  public void b(dy paramdy)
  {
    a("http://qqwx.qq.com/s?aid=index&p=11&c=106613&vt=1&pf=0", null, null, paramdy);
  }
  
  public void c()
  {
    if (this.b == null) {
      return;
    }
    this.b.b();
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
    if (this.b == null) {
      return false;
    }
    return this.b.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dz
 * JD-Core Version:    0.7.0.1
 */