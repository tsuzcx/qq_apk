package com.tencent.mobileqq.microapp.appbrand.b;

import android.os.Environment;
import android.text.TextUtils;
import aqhq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class b
{
  private static volatile b b;
  public f a;
  private String c;
  private String d;
  private Map e;
  private Map f = new HashMap();
  
  public static b a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new b();
      }
      return b;
    }
    finally {}
  }
  
  private String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "tmp";
    }
    for (;;)
    {
      return Environment.getExternalStorageDirectory().getPath() + "/miniApp/files/" + this.c + "/" + this.d + "/" + str;
      str = "tmp";
      continue;
      str = "store";
      continue;
      str = "usr";
    }
  }
  
  private void b()
  {
    aqhq.delete(a(0), false);
  }
  
  private String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = e(paramString);
    if (TextUtils.isEmpty(str)) {}
    for (str = "";; str = "." + str)
    {
      str = MD5.toMD5(new StringBuilder().append(System.currentTimeMillis()).append("").toString()) + str;
      str = "wxfile://" + "tmp" + "_" + str;
      this.e.put(str, paramString);
      return str;
    }
  }
  
  private static String e(String paramString)
  {
    String str2 = "";
    try
    {
      str1 = new URL(paramString).getPath();
      paramString = str1;
    }
    catch (Throwable localThrowable)
    {
      String str1;
      label17:
      int i;
      break label17;
    }
    str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramString.lastIndexOf(".");
      str1 = str2;
      if (i != -1)
      {
        str1 = str2;
        if (i + 1 < paramString.length()) {
          str1 = paramString.substring(i + 1);
        }
      }
    }
    return str1;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "";; paramString = "." + paramString)
    {
      paramString = MD5.toMD5(new StringBuilder().append(System.currentTimeMillis()).append("").toString()) + paramString;
      return new File(a(0), paramString).getAbsolutePath();
    }
  }
  
  public void a(f paramf)
  {
    b(paramf);
    b();
  }
  
  public String b(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = new File(paramString);
        String str = ((File)localObject).getParentFile().getAbsolutePath();
        if ((a(0).equals(str)) || (a(1).equals(str)))
        {
          if (((File)localObject).getParentFile().getName().equals("store"))
          {
            localObject = "store";
            paramString = new File(paramString).getName();
            return "wxfile://" + (String)localObject + "_" + paramString;
          }
        }
        else
        {
          if (str.startsWith(a(2)))
          {
            paramString = a(2);
            paramString = ((File)localObject).getAbsolutePath().replace(paramString, "");
            return "wxfile://usr" + paramString;
          }
          if (new File(paramString).exists())
          {
            paramString = d(paramString);
            return paramString;
          }
          return "";
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return "";
      }
      Object localObject = "tmp";
    }
  }
  
  public void b(f paramf)
  {
    this.c = paramf.d;
    this.d = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    this.a = paramf;
    paramf = this.c + this.d;
    this.e = ((Map)this.f.get(paramf));
    if (this.e == null)
    {
      this.e = new HashMap();
      this.f.put(paramf, this.e);
    }
  }
  
  public String c(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = (String)this.e.get(paramString);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    if (paramString.startsWith("wxfile://tmp_"))
    {
      paramString = paramString.replace("wxfile://tmp_", "");
      paramString = new File(a(0), paramString);
      if (paramString.exists()) {
        return paramString.getAbsolutePath();
      }
    }
    else if (paramString.startsWith("wxfile://store_"))
    {
      paramString = paramString.replace("wxfile://store_", "");
      paramString = new File(a(1), paramString);
      if (paramString.exists()) {
        return paramString.getAbsolutePath();
      }
    }
    else if (paramString.startsWith("wxfile://usr"))
    {
      paramString = paramString.replace("wxfile://usr", "");
      paramString = new File(a(2), paramString);
      if (paramString.exists()) {
        return paramString.getAbsolutePath();
      }
    }
    else
    {
      if ((paramString.toLowerCase().startsWith("http://")) || (paramString.toLowerCase().startsWith("https://"))) {
        return paramString;
      }
      if (new File(this.a.j(paramString)).exists()) {
        return this.a.j(paramString);
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.b.b
 * JD-Core Version:    0.7.0.1
 */