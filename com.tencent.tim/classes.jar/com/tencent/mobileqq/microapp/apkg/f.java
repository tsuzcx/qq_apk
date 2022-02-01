package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import android.text.TextUtils;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class f
{
  public String a;
  public p b;
  public String c;
  public String d;
  public String e;
  public MiniAppConfig f;
  private String g;
  private Map h = new HashMap();
  
  public f(String paramString, MiniAppConfig paramMiniAppConfig)
  {
    new HashMap();
    this.g = paramString;
    this.d = paramMiniAppConfig.config.mini_appid;
    this.c = paramMiniAppConfig.config.app_name;
    this.e = paramMiniAppConfig.config.icon_url;
    this.f = paramMiniAppConfig;
  }
  
  public static f a(String paramString, MiniAppConfig paramMiniAppConfig)
  {
    if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {
      return null;
    }
    paramString = new f(paramString, paramMiniAppConfig);
    paramString.a();
    return paramString;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      int j = paramString.indexOf("?");
      int i = j;
      if (j == -1) {
        i = paramString.length();
      }
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  public static boolean a(f paramf)
  {
    if ((paramf != null) && (paramf.f != null)) {
      return paramf.f.isInnerUser();
    }
    return false;
  }
  
  public void a()
  {
    try
    {
      this.a = c.b(new File(this.g, "app-config.json"));
      JSONObject localJSONObject1 = new JSONObject(this.a);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("USER_DATA_PATH", "wxfile://usr");
      localJSONObject1.put("env", localJSONObject2);
      this.a = localJSONObject1.toString();
      this.b = p.a(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void a(MiniAppConfig paramMiniAppConfig)
  {
    int i = this.f.config.mini_version;
    this.f = paramMiniAppConfig;
    this.f.config.mini_version = i;
  }
  
  public void a(String paramString, g.d paramd)
  {
    g.a().a(this, paramString, paramd);
  }
  
  public String b()
  {
    return this.g + "/" + "app-service.js";
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    String str2;
    String str1;
    do
    {
      return paramString;
      str2 = a(paramString);
      str1 = (String)this.h.get(str2);
      paramString = str1;
    } while (!TextUtils.isEmpty(str1));
    paramString = str1;
    try
    {
      String str3 = c.b(new File(this.g, str2));
      paramString = str1;
      str1 = str3.substring(str3.indexOf("<script>") + "<script>".length(), str3.indexOf("</script>"));
      paramString = str1;
      this.h.put(str2, str1);
      return str1;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return paramString;
  }
  
  public String c()
  {
    return g.a().e();
  }
  
  public boolean c(String paramString)
  {
    paramString = d(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool;
    do
    {
      return true;
      paramString = new File(g.a(this.f.config), paramString).getAbsolutePath();
      bool = new File(paramString).exists();
      if (QLog.isColorLevel()) {
        QLog.d("ApkgInfo", 1, "isUrlResReady | subFolderPath :" + paramString + "isExist:" + bool);
      }
    } while (bool);
    return false;
  }
  
  public c d()
  {
    Object localObject = new File(this.g, "page-frame.html");
    c localc = new c();
    if (!((File)localObject).exists())
    {
      localc.a = c();
      return localc;
    }
    localObject = c.a((File)localObject);
    String str = ((String)localObject).substring(((String)localObject).indexOf("<script>") + "<script>".length(), ((String)localObject).indexOf("</script>"));
    localc.a = ((String)localObject).replace(str, "");
    localc.b = str;
    return localc;
  }
  
  public String d(String paramString)
  {
    return this.b.b(paramString);
  }
  
  public String e()
  {
    File localFile = new File(new File(this.g), "app-wxss.js");
    if (localFile.exists()) {
      return c.a(localFile);
    }
    return "";
  }
  
  public String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return this.g + "/" + "app-service.js";
    }
    return new File(new File(this.g, paramString), "app-service.js").getAbsolutePath();
  }
  
  public String f()
  {
    return g.a().b();
  }
  
  public String f(String paramString)
  {
    return c.a(new File(e(paramString)));
  }
  
  public String g()
  {
    return g.a().c();
  }
  
  public String g(String paramString)
  {
    paramString = this.b.b(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new File(new File(this.g, paramString), "page-frame.js");
    if (paramString.exists()) {
      return c.a(paramString);
    }
    return "";
  }
  
  public String h()
  {
    return g.a().d();
  }
  
  public boolean h(String paramString)
  {
    paramString = c.d(paramString);
    Object localObject = this.b.d;
    if (localObject != null)
    {
      localObject = ((t)localObject).f.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((t.a)((Iterator)localObject).next()).a.equals(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean i()
  {
    return this.b.a;
  }
  
  public boolean i(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = c.d(paramString);
    } while ((!h(paramString)) && (!paramString.equals(this.b.b)));
    return true;
  }
  
  public String j(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return new File(this.g, paramString).getAbsolutePath();
  }
  
  public boolean k(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!new File(j(c.d(paramString))).exists()) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.f
 * JD-Core Version:    0.7.0.1
 */