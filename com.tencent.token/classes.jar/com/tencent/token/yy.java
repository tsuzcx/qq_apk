package com.tencent.token;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

public class yy
{
  private static yy c;
  public zc a;
  private String b;
  
  public static String b()
  {
    return "gallerymanager_102322.apk";
  }
  
  public static yy g()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new yy();
        }
      }
      finally {}
    }
    return c;
  }
  
  public final void a()
  {
    zc localzc = this.a;
    if (localzc == null) {
      return;
    }
    localzc.a();
  }
  
  public final void c()
  {
    zc localzc = this.a;
    if (localzc == null) {
      return;
    }
    localzc.b();
  }
  
  public final boolean d()
  {
    try
    {
      boolean bool = new File(f(), "gallerymanager_102322.apk").exists();
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public final String e()
  {
    try
    {
      String str = new File(f(), "gallerymanager_102322.apk").getAbsolutePath();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public final String f()
  {
    if (TextUtils.isEmpty(this.b))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("gallerymanager");
      localStringBuilder.append(File.separator);
      this.b = localStringBuilder.toString();
    }
    return this.b;
  }
  
  public final boolean h()
  {
    zc localzc = this.a;
    if (localzc == null) {
      return false;
    }
    return localzc.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.yy
 * JD-Core Version:    0.7.0.1
 */