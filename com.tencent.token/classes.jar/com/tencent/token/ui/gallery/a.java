package com.tencent.token.ui.gallery;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.token.cx;
import com.tencent.token.cz;
import com.tencent.token.da;
import java.io.File;

public class a
{
  private static a c;
  private String a;
  private cz b;
  
  public static a f()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new a();
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
      localStringBuilder.append("gallerymanager");
      localStringBuilder.append(File.separator);
      this.a = localStringBuilder.toString();
    }
    return this.a;
  }
  
  public void a()
  {
    cz localcz = this.b;
    if (localcz == null) {
      return;
    }
    localcz.a();
  }
  
  public void a(cx paramcx)
  {
    a("http://qqwx.qq.com/s?aid=index&p=14&c=102322&vt=1&pf=0", null, null, paramcx);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, cx paramcx)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = h();
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = b();
    }
    this.b = new cz(new da(paramString1, str, paramString2), paramcx);
  }
  
  public String b()
  {
    return "gallerymanager_102322.apk";
  }
  
  public void c()
  {
    cz localcz = this.b;
    if (localcz == null) {
      return;
    }
    localcz.b();
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
    cz localcz = this.b;
    if (localcz == null) {
      return false;
    }
    return localcz.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gallery.a
 * JD-Core Version:    0.7.0.1
 */