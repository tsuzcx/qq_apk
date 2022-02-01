package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.token.global.RqdApplication;
import java.io.File;

public class zk
{
  private static zk c;
  public zo a;
  private String b;
  
  public static File a(String paramString)
  {
    File localFile = RqdApplication.b().getExternalFilesDir(null);
    if (localFile != null)
    {
      paramString = new File(localFile, paramString);
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return paramString;
    }
    return null;
  }
  
  public static String b()
  {
    return "gallerymanager_102322.apk";
  }
  
  public static zk g()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new zk();
        }
      }
      finally {}
    }
    return c;
  }
  
  public final void a()
  {
    zo localzo = this.a;
    if (localzo == null) {
      return;
    }
    localzo.a();
  }
  
  public final void c()
  {
    zo localzo = this.a;
    if (localzo == null) {
      return;
    }
    localzo.b();
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
      File localFile = a("gallerymanager");
      if (localFile != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localFile.getAbsolutePath());
        localStringBuilder.append(File.separator);
        this.b = localStringBuilder.toString();
      }
    }
    return this.b;
  }
  
  public final boolean h()
  {
    zo localzo = this.a;
    if (localzo == null) {
      return false;
    }
    return localzo.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zk
 * JD-Core Version:    0.7.0.1
 */