package com.tencent.qmsp.sdk.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qmsp.sdk.g.e.f;

public class e
  implements IVendorCallback
{
  private static boolean c = false;
  private static String d = "b2FpZA";
  private static String e = "b2FpZA";
  private static Context f;
  private b a = null;
  private IVendorCallback b = null;
  
  public static String a(Context paramContext, String paramString, int paramInt)
  {
    String str = null;
    if (paramContext != null) {
      for (;;)
      {
        try
        {
          if ((paramContext instanceof Context))
          {
            localObject = paramContext.getSharedPreferences(d, 0);
            paramContext = ((SharedPreferences)localObject).getString(e, null);
            if (!TextUtils.isEmpty(paramContext))
            {
              paramContext = new String(Base64.decode(paramContext.getBytes("UTF-8"), 0));
              if (paramInt != 1) {}
            }
          }
        }
        catch (Exception paramString)
        {
          Object localObject;
          paramContext = null;
        }
        try
        {
          if (c)
          {
            localObject = ((SharedPreferences)localObject).edit();
            boolean bool = TextUtils.isEmpty(paramString);
            if (!bool) {
              str = Base64.encodeToString(paramString.getBytes("UTF-8"), 0);
            }
            ((SharedPreferences.Editor)localObject).putString(e, str);
            ((SharedPreferences.Editor)localObject).commit();
          }
          return paramContext;
        }
        catch (Exception paramString)
        {
          break label133;
        }
        paramContext = null;
        continue;
        label133:
        paramString.printStackTrace();
        return paramContext;
      }
    }
    return null;
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      if ((paramContext instanceof Context)) {
        paramContext.getSharedPreferences(d, 0).edit().clear().commit();
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    c = paramBoolean1;
    f = paramContext;
    c.a(paramBoolean2);
  }
  
  public int a(IVendorCallback paramIVendorCallback)
  {
    this.b = paramIVendorCallback;
    paramIVendorCallback = d.a(Build.MANUFACTURER);
    if (paramIVendorCallback == d.b)
    {
      onResult(false, null, null);
      return a.a;
    }
    switch (e.a.a[paramIVendorCallback.ordinal()])
    {
    }
    while (this.a == null)
    {
      c.b("vendorInfo == null");
      onResult(false, null, null);
      return a.b;
      this.a = new com.tencent.qmsp.sdk.g.d.e();
      continue;
      this.a = new com.tencent.qmsp.sdk.g.f.a();
      continue;
      this.a = new f();
      continue;
      this.a = new com.tencent.qmsp.sdk.g.h.c();
      continue;
      this.a = new com.tencent.qmsp.sdk.g.a.c();
      continue;
      this.a = new com.tencent.qmsp.sdk.g.c.b();
      continue;
      this.a = new com.tencent.qmsp.sdk.g.g.c();
      continue;
      this.a = new com.tencent.qmsp.sdk.g.b.c();
      continue;
      this.a = new com.tencent.qmsp.sdk.g.i.b();
      continue;
      this.a = new com.tencent.qmsp.sdk.g.j.a();
    }
    c.b("init");
    try
    {
      this.a.a(f, this);
      if (!this.a.d()) {
        try
        {
          this.a.c();
          return 0;
        }
        catch (Exception paramIVendorCallback)
        {
          onResult(false, null, null);
          return a.c;
        }
      }
      c.b("sync");
      try
      {
        onResult(this.a.e(), this.a.b(), this.a.a());
        return 0;
      }
      catch (Exception paramIVendorCallback)
      {
        onResult(false, null, null);
        return 0;
      }
      return a.c;
    }
    catch (Exception paramIVendorCallback)
    {
      onResult(false, null, null);
    }
  }
  
  public void onResult(boolean paramBoolean, String paramString1, String paramString2)
  {
    c.c("vm onResult " + paramBoolean);
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = a(f, null, 0);
    }
    for (;;)
    {
      IVendorCallback localIVendorCallback = this.b;
      if (localIVendorCallback != null) {
        localIVendorCallback.onResult(paramBoolean, paramString1, paramString2);
      }
      paramString1 = this.a;
      if (paramString1 != null) {
        paramString1.f();
      }
      return;
      a(f, paramString2, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.base.e
 * JD-Core Version:    0.7.0.1
 */