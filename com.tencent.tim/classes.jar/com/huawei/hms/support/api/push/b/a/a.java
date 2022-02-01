package com.huawei.hms.support.api.push.b.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private static final String[] a = { "phone", "url", "app", "cosa", "rp" };
  private Context b;
  private com.huawei.hms.support.api.push.b.b.a c;
  
  public a(Context paramContext, com.huawei.hms.support.api.push.b.b.a parama)
  {
    this.b = paramContext;
    this.c = parama;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private String b(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        int j = paramString.indexOf('?');
        if (j == -1) {
          return paramString;
        }
        Object localObject2 = paramString.substring(j + 1).split("&");
        Object localObject1 = new ArrayList();
        int k = localObject2.length;
        i = 0;
        if (i < k)
        {
          Object localObject3 = localObject2[i];
          if ((!localObject3.startsWith("h_w_hiapp_referrer")) && (!localObject3.startsWith("h_w_gp_referrer"))) {
            ((List)localObject1).add(localObject3);
          }
        }
        else
        {
          localObject2 = new StringBuilder();
          k = ((List)localObject1).size();
          i = 0;
          if (i < k)
          {
            ((StringBuilder)localObject2).append((String)((List)localObject1).get(i));
            if (i >= ((List)localObject1).size() - 1) {
              break label275;
            }
            ((StringBuilder)localObject2).append("&");
            break label275;
          }
          if (((List)localObject1).size() == 0)
          {
            localObject1 = paramString.substring(0, j);
            HMSLog.d("PushSelfShowLog", "after delete referrer, the new IntentUri is:" + (String)localObject1);
            return localObject1;
          }
          localObject1 = paramString.substring(0, j + 1) + ((StringBuilder)localObject2).toString();
          continue;
        }
        i += 1;
      }
      catch (Exception localException)
      {
        HMSLog.e("PushSelfShowLog", "delete referrer exception" + localException.toString());
        return paramString;
      }
      continue;
      label275:
      i += 1;
    }
  }
  
  private void b()
  {
    HMSLog.d("PushSelfShowLog", "enter launchCall");
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.DIAL").setData(Uri.parse("tel:" + this.c.n())).setFlags(268435456);
      this.b.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      HMSLog.e("PushSelfShowLog", localException.toString(), localException);
    }
  }
  
  private void c()
  {
    try
    {
      HMSLog.i("PushSelfShowLog", "enter launchApp, appPackageName =" + this.c.o() + ",and msg.intentUri is " + this.c.g());
      if (com.huawei.hms.support.api.push.b.d.a.c(this.b, this.c.o()))
      {
        f();
        return;
      }
      HMSLog.i("PushSelfShowLog", "enter launch app, appPackageName =" + this.c.o() + ",and msg.intentUri is " + this.c.g());
      d();
      return;
    }
    catch (Exception localException)
    {
      HMSLog.e("PushSelfShowLog", "launchApp error:" + localException.toString());
    }
  }
  
  private void d()
  {
    try
    {
      Object localObject = new StringBuilder();
      if (!TextUtils.isEmpty(this.c.g())) {
        ((StringBuilder)localObject).append("&referrer=").append(Uri.encode(b(this.c.g())));
      }
      localObject = "market://details?id=" + this.c.o() + localObject;
      Intent localIntent1 = new Intent("android.intent.action.VIEW");
      localIntent1.setData(Uri.parse((String)localObject));
      localIntent1.setPackage("com.huawei.appmarket");
      Intent localIntent2 = new Intent("android.intent.action.VIEW");
      localIntent2.setData(Uri.parse((String)localObject));
      localIntent2.setPackage("com.android.vending");
      if (com.huawei.hms.support.api.push.b.d.a.a(this.b, "com.android.vending", localIntent2).booleanValue())
      {
        localIntent2.setFlags(402653184);
        HMSLog.i("PushSelfShowLog", "open google play store's app detail, IntentUrl is:" + localIntent2.toURI());
        this.b.startActivity(localIntent2);
        return;
      }
      if (com.huawei.hms.support.api.push.b.d.a.a(this.b, "com.huawei.appmarket", localIntent1).booleanValue())
      {
        localIntent1.setFlags(402653184);
        HMSLog.i("PushSelfShowLog", "open HiApp's app detail, IntentUrl is:" + localIntent1.toURI());
        this.b.startActivity(localIntent1);
        return;
      }
    }
    catch (Exception localException)
    {
      HMSLog.e("PushSelfShowLog", "open market app detail failed,exception:" + localException);
      return;
    }
    HMSLog.i("PushSelfShowLog", "open app detail by browser.");
    e();
  }
  
  private void e()
  {
    String str5 = "";
    for (;;)
    {
      try
      {
        localObject = Uri.parse(Uri.decode(this.c.g()));
      }
      catch (Exception localException4)
      {
        Object localObject;
        String str1;
        String str3;
        String str4;
        String str2 = "";
        continue;
        str2 = null;
        continue;
      }
      try
      {
        str1 = ((Uri)localObject).getQueryParameter("h_w_hiapp_referrer");
      }
      catch (Exception localException1)
      {
        try
        {
          localObject = ((Uri)localObject).getQueryParameter("h_w_gp_referrer");
          if ((!Util.isEMUI()) || (!Util.isChinaROM()))
          {
            HMSLog.i("PushSelfShowLog", "not EMUI system or not in China, open google play web, referrer: " + (String)localObject);
            str1 = Uri.decode((String)localObject);
            if (URLUtil.isValidUrl(str1))
            {
              HMSLog.i("PushSelfShowLog", "open the URL by browser: " + str1);
              com.huawei.hms.support.api.push.b.d.a.d(this.b, str1);
              return;
              localException1 = localException1;
              HMSLog.i("PushSelfShowLog", "parse h_w_hiapp_referrer faied");
              str2 = "";
              continue;
            }
          }
        }
        catch (Exception localException2)
        {
          try
          {
            HMSLog.i("PushSelfShowLog", "parse h_w_hiapp_referrer faied");
            str3 = str5;
          }
          catch (Exception localException3) {}
          HMSLog.w("PushSelfShowLog", "parse intentUri error" + localException3.toString());
          str4 = str5;
          continue;
          ResourceLoaderUtil.setmContext(this.b);
          str2 = ResourceLoaderUtil.getString("hms_push_google") + this.c.o();
          continue;
          HMSLog.i("PushSelfShowLog", "It is China device, open Huawei market web, referrer: " + str2);
          str4 = Uri.decode(str2);
          str2 = str4;
          if (URLUtil.isValidUrl(str4)) {
            continue;
          }
          if (this.b == null) {
            continue;
          }
        }
      }
      ResourceLoaderUtil.setmContext(this.b);
      str2 = ResourceLoaderUtil.getString("hms_push_vmall");
    }
  }
  
  private void f()
  {
    int i = 0;
    HMSLog.i("PushSelfShowLog", "run into launchCosaApp ");
    label319:
    label378:
    label381:
    for (;;)
    {
      try
      {
        HMSLog.i("PushSelfShowLog", "enter launchExistApp cosa, appPackageName =" + this.c.o() + ",and msg.intentUri is " + this.c.g());
        Object localObject1 = com.huawei.hms.support.api.push.b.d.a.b(this.b, this.c.o());
        Object localObject2 = this.c.g();
        if (localObject2 != null)
        {
          try
          {
            localObject2 = Intent.parseUri(this.c.g(), 0);
            HMSLog.i("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0)," + ((Intent)localObject2).toURI());
            boolean bool = com.huawei.hms.support.api.push.b.d.a.a(this.b, this.c.o(), (Intent)localObject2).booleanValue();
            if (!bool) {
              break label381;
            }
            i = 1;
            localObject1 = localObject2;
          }
          catch (Exception localException2)
          {
            HMSLog.w("PushSelfShowLog", "intentUri error" + localException2.toString());
            continue;
          }
          if (localObject1 == null) {
            HMSLog.i("PushSelfShowLog", "launchCosaApp,intent == null");
          }
        }
        else
        {
          if (this.c.p() == null) {
            break label378;
          }
          Intent localIntent = new Intent(this.c.p());
          if (!com.huawei.hms.support.api.push.b.d.a.a(this.b, this.c.o(), localIntent).booleanValue()) {
            break label378;
          }
          localObject1 = localIntent;
          ((Intent)localObject1).setPackage(this.c.o());
          continue;
        }
        if (com.huawei.hms.support.api.push.b.d.a.a(this.b, localException1)) {
          break label319;
        }
      }
      catch (Exception localException1)
      {
        HMSLog.e("PushSelfShowLog", "launch Cosa App exception" + localException1.toString());
        return;
      }
      HMSLog.w("PushSelfShowLog", "no permission to start Activity");
      return;
      if (i != 0) {
        localException1.addFlags(268435456);
      }
      for (;;)
      {
        HMSLog.i("PushSelfShowLog", "start " + localException1.toURI());
        this.b.startActivity(localException1);
        return;
        localException1.setFlags(805437440);
      }
    }
  }
  
  public void a()
  {
    HMSLog.d("PushSelfShowLog", "enter launchNotify()");
    if ((this.b == null) || (this.c == null))
    {
      HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
      return;
    }
    if ("app".equals(this.c.j()))
    {
      c();
      return;
    }
    if ("cosa".equals(this.c.j()))
    {
      f();
      return;
    }
    if ("phone".equals(this.c.j()))
    {
      b();
      return;
    }
    if ("rp".equals(this.c.j()))
    {
      HMSLog.w("PushSelfShowLog", this.c.j() + " not support rich message.");
      return;
    }
    if ("url".equals(this.c.j()))
    {
      HMSLog.w("PushSelfShowLog", this.c.j() + " not support URL.");
      return;
    }
    HMSLog.d("PushSelfShowLog", this.c.j() + " is not exist in hShowType");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.push.b.a.a
 * JD-Core Version:    0.7.0.1
 */