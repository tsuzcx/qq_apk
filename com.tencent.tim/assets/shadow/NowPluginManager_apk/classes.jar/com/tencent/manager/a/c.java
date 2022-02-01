package com.tencent.manager.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.manager.c.e;
import com.tencent.manager.c.i;
import com.tencent.util.d.a.b;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.zip.GZIPInputStream;

public class c
{
  a a = null;
  int b = 0;
  String c = "";
  String d;
  boolean e;
  g f = new g();
  long g;
  String h;
  int i;
  String j;
  String k;
  String l;
  long m = 0L;
  long n = 0L;
  protected boolean o = false;
  private ExecutorService p = Executors.newSingleThreadExecutor();
  private Handler q = new Handler(Looper.getMainLooper());
  
  public c(String paramString1, String paramString2)
  {
    this.k = paramString1;
    this.l = paramString2;
  }
  
  private long a(String paramString, Context paramContext)
  {
    if (this.k.equals("2"))
    {
      if (TextUtils.isEmpty(paramString)) {
        return com.tencent.manager.c.c.b(paramContext);
      }
      return Long.parseLong(paramString);
    }
    return com.tencent.manager.c.c.b(paramContext);
  }
  
  private String a(String paramString, boolean paramBoolean)
  {
    long l3 = System.currentTimeMillis();
    com.tencent.util.e.a.a("NowPluginManager | PluginChecker", "开始访问check cgi url= " + paramString);
    this.e = false;
    Object localObject4 = null;
    int i1 = 0;
    long l2 = 0L;
    Object localObject1 = localObject4;
    Object localObject5;
    Object localObject3;
    long l1;
    try
    {
      localObject5 = new URL(paramString);
      localObject1 = localObject4;
      String str2 = ((URL)localObject5).getHost();
      String str1 = "";
      localObject1 = localObject4;
      boolean bool1 = a.b.a().b();
      localObject1 = localObject4;
      boolean bool2 = e.a();
      localObject3 = str1;
      l1 = l2;
      if (paramBoolean)
      {
        localObject3 = str1;
        l1 = l2;
        if (bool1)
        {
          localObject3 = str1;
          l1 = l2;
          if (!bool2)
          {
            localObject3 = str1;
            l1 = l2;
            localObject1 = localObject4;
            if ("now.qq.com".equals(str2))
            {
              localObject1 = localObject4;
              l1 = System.currentTimeMillis();
              localObject1 = localObject4;
              paramString = a(str2, paramString);
              localObject1 = localObject4;
              l2 = System.currentTimeMillis() - l1;
              localObject3 = paramString;
              l1 = l2;
              localObject1 = localObject4;
              if (!TextUtils.isEmpty(paramString))
              {
                localObject1 = localObject4;
                this.e = true;
                l1 = l2;
                localObject3 = paramString;
              }
            }
          }
        }
      }
      localObject1 = localObject4;
      com.tencent.util.e.a.a("NowPluginManager | PluginChecker", "localEnable=" + paramBoolean + ", configEnable=" + bool1 + ", hasProxy=" + bool2 + "， host=" + str2 + ", ip=" + "" + ", dnsTimeCost=" + l1 + ", ipUrl=" + (String)localObject3);
      localObject1 = localObject4;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject1 = localObject4;
        paramString = new URL((String)localObject3);
        i1 = 1;
        localObject1 = localObject4;
        this.o = true;
        localObject1 = localObject4;
        Log.i("NowPluginManager | PluginChecker", " new URL 结束");
        localObject1 = localObject4;
        localObject3 = paramString.openConnection();
        localObject1 = localObject3;
        Log.i("NowPluginManager | PluginChecker", "openConnection结束");
        localObject1 = localObject3;
        ((URLConnection)localObject3).setUseCaches(false);
        if (i1 != 0)
        {
          localObject1 = localObject3;
          ((URLConnection)localObject3).setRequestProperty("Host", str2);
          localObject1 = localObject3;
          Log.i("NowPluginManager | PluginChecker", "use ipUrl, setHost:" + str2);
        }
        localObject1 = localObject3;
        ((URLConnection)localObject3).setRequestProperty("Accept-Encoding", "identity");
        localObject1 = localObject3;
        paramString = (HttpURLConnection)localObject3;
        if (paramString != null)
        {
          localObject1 = localObject3;
          this.i = paramString.getResponseCode();
        }
        localObject1 = localObject3;
        Log.i("NowPluginManager | PluginChecker", "getResponseCode结束: rspCode=" + this.i + ", length=" + paramString.getContentLength());
        localObject1 = localObject3;
        if (!"gzip".equals(((URLConnection)localObject3).getContentEncoding())) {
          break label828;
        }
        localObject1 = localObject3;
        paramString = new InputStreamReader(new GZIPInputStream(((URLConnection)localObject3).getInputStream()));
        label559:
        localObject1 = localObject3;
        paramString = new BufferedReader(paramString);
        localObject1 = localObject3;
        localObject4 = new StringBuilder();
        for (;;)
        {
          localObject1 = localObject3;
          localObject5 = paramString.readLine();
          if (localObject5 == null) {
            break;
          }
          localObject1 = localObject3;
          ((StringBuilder)localObject4).append((String)localObject5);
        }
        com.tencent.util.e.a.a("NowPluginManager | PluginChecker", "check Exception e = " + paramString.toString());
      }
    }
    catch (Exception paramString)
    {
      System.currentTimeMillis();
      if (localObject1 != null) {
        try
        {
          localObject3 = ((URLConnection)localObject1).getHeaderFields();
          Log.i("NowPluginManager | PluginChecker", "getHeaderFields结束");
          localObject1 = new StringBuilder();
          if (localObject3 != null)
          {
            localObject3 = ((Map)localObject3).entrySet().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (Map.Entry)((Iterator)localObject3).next();
              if (localObject4 != null)
              {
                ((StringBuilder)localObject1).append(((Map.Entry)localObject4).getValue() + " ");
                continue;
                this.h = paramString.toString();
              }
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          Log.i("NowPluginManager | PluginChecker", "e1 = " + localException.toString());
        }
      }
    }
    for (;;)
    {
      throw new RuntimeException(paramString);
      Object localObject2 = localObject4;
      this.o = false;
      paramString = (String)localObject5;
      break;
      label828:
      localObject2 = localObject3;
      paramString = new InputStreamReader(((URLConnection)localObject3).getInputStream());
      break label559;
      localObject2 = localObject3;
      paramString = ((StringBuilder)localObject4).toString();
      localObject2 = localObject3;
      l1 = System.currentTimeMillis();
      localObject2 = localObject3;
      com.tencent.util.e.a.a("NowPluginManager | PluginChecker", "downloadBuffer end，cost：" + (l1 - l3));
      return paramString;
      this.j = localObject2.toString();
    }
  }
  
  private void a(final boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    String str;
    label76:
    int i2;
    int i1;
    if (paramBoolean1)
    {
      str = "check_version_complete";
      localBundle.putString("op_name", str);
      localBundle.putString("d2", String.valueOf(c()));
      localBundle.putString("d3", String.valueOf(a(this.f)));
      if (!paramBoolean2) {
        break label178;
      }
      str = "1";
      localBundle.putString("d4", str);
      i2 = 0;
      if ((this.f.f <= 0) || (!this.f.b)) {
        break label186;
      }
      i1 = this.f.f;
    }
    for (;;)
    {
      localBundle.putString("sdkversion", String.valueOf(i1));
      localBundle.putString("timeconsume", String.valueOf(l1 - this.n));
      com.tencent.util.g.a.a(localBundle);
      this.q.post(new Runnable()
      {
        public void run()
        {
          c localc;
          if (c.this.a != null)
          {
            localc = c.this;
            if (!paramBoolean1) {
              break label60;
            }
          }
          label60:
          for (int i = 2;; i = 0)
          {
            localc.b = i;
            c.this.a.a(paramBoolean1, c.this.a(c.this.f));
            return;
          }
        }
      });
      return;
      str = "check_version_fail";
      break;
      label178:
      str = "0";
      break label76;
      label186:
      i1 = i2;
      if (!this.f.b)
      {
        i1 = i2;
        if (this.f.e > 0) {
          i1 = this.f.e;
        }
      }
    }
  }
  
  private String e()
  {
    Object localObject;
    if (this.k.equals("2"))
    {
      localObject = "http://now.qq.com/cgi-bin/now/web/version/now_ver?apptype=now&platform=2";
      if (!i.a(this.k)) {
        break label253;
      }
    }
    label253:
    for (int i1 = 1;; i1 = 0)
    {
      String str = (String)localObject + "&mode=" + i1 + "&frameversion=" + 14 + "&cursdkversion=" + this.l + "&uin=" + this.g;
      localObject = str;
      if (i.b(this.k) != 0) {
        localObject = str + "&targetSdkVersion=" + i.b(this.k);
      }
      this.d = ((String)localObject);
      Log.i("NowPluginManager | PluginChecker", "checkurl= " + (String)localObject);
      return localObject;
      if (this.k.equals("qznow"))
      {
        localObject = "http://now.qq.com/cgi-bin/now/web/version/now_ver?apptype=qznow&platform=2";
        break;
      }
      if (this.k.equals("acnow"))
      {
        localObject = "http://now.qq.com/cgi-bin/now/web/version/now_ver?apptype=acnow&platform=2";
        break;
      }
      if (this.k.equals("1005"))
      {
        localObject = "http://now.qq.com/cgi-bin/now/web/version/now_ver?apptype=demo&platform=2";
        break;
      }
      localObject = "http://now.qq.com/cgi-bin/now/web/version/now_ver?platform=2&apptype=" + this.k;
      break;
    }
  }
  
  private void f()
  {
    String str2 = e();
    Log.e("NowPluginManager | PluginChecker", "runImpl, request first time, enable ip");
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("op_name", "check_version_start");
    ((Bundle)localObject).putString("d1", str2);
    com.tencent.util.g.a.a((Bundle)localObject);
    String str1 = a(str2, true);
    localObject = str1;
    if (this.o)
    {
      if (!TextUtils.isEmpty(str1)) {
        break label136;
      }
      Log.e("NowPluginManager | PluginChecker", "runImpl, ret is empty, request again, disable ip");
      localObject = a(str2, false);
    }
    for (;;)
    {
      this.c = ((String)localObject);
      if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        break;
      }
      this.h += " mJson == null";
      a(false, this.e);
      return;
      label136:
      String str3 = new g().a(str1);
      localObject = str1;
      if (str3 != null)
      {
        Log.e("NowPluginManager | PluginChecker", "runImpl, parse json failed, request again, disable ip:" + str3);
        localObject = a(str2, false);
      }
    }
    Log.e("NowPluginManager | PluginChecker", "check 收到回包 ，json = " + (String)localObject);
    localObject = this.f.a((String)localObject);
    if (localObject != null)
    {
      this.h = (this.h + "parse json fail,exception = " + (String)localObject);
      a(false, this.e);
      return;
    }
    if ((!this.f.b) && (!this.f.c))
    {
      a(false, this.e);
      return;
    }
    a(System.currentTimeMillis());
    a(true, this.e);
  }
  
  public int a(g paramg)
  {
    int i2 = 4;
    int i1;
    if ((!paramg.b) && (paramg.f == 0) && (paramg.c)) {
      i1 = 3;
    }
    do
    {
      do
      {
        do
        {
          return i1;
          if ((!paramg.b) && (paramg.f > 0) && (paramg.c)) {
            return 1;
          }
          if (!paramg.b) {
            break;
          }
          i1 = i2;
        } while (!paramg.c);
        i1 = i2;
      } while (!paramg.b);
      i1 = i2;
    } while (!paramg.c);
    return 2;
  }
  
  public String a(final String paramString1, final String paramString2)
  {
    paramString1 = Executors.newSingleThreadExecutor().submit(new Callable()
    {
      public String a()
      {
        String str = a.b.a().a(paramString1);
        if (!TextUtils.isEmpty(str))
        {
          str = e.a(paramString2, str);
          com.tencent.util.e.a.a("NowPluginManager | PluginChecker", "getIp ipurl = " + str);
          return str;
        }
        return "";
      }
    });
    try
    {
      paramString1 = (String)paramString1.get(200L, TimeUnit.MILLISECONDS);
      return paramString1;
    }
    catch (InterruptedException paramString1)
    {
      return "";
    }
    catch (ExecutionException paramString1)
    {
      return "";
    }
    catch (TimeoutException paramString1)
    {
      com.tencent.util.e.a.a("NowPluginManager | PluginChecker", "getIp timeout");
    }
    return "";
  }
  
  public void a(long paramLong)
  {
    this.m = paramLong;
  }
  
  public void a(String paramString1, Context paramContext, String paramString2, a parama)
  {
    if (parama != null) {
      this.a = parama;
    }
    this.k = paramString2;
    try
    {
      this.g = a(paramString1, paramContext);
      com.tencent.util.e.a.a("NowPluginManager | PluginChecker", "PluginChecker-DeviceId=" + com.tencent.manager.c.c.a(paramContext) + ";mUin= " + this.g + ";sourceId=" + paramString1);
      if (this.b == 1) {
        return;
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        com.tencent.util.e.a.b("NowPluginManager | PluginChecker", "getDeviceIdHash--error");
        com.tencent.util.e.a.a(paramString2);
        this.g = com.tencent.manager.c.c.b(paramContext);
      }
      if ((this.b == 0) || (a()))
      {
        this.b = 1;
        this.n = System.currentTimeMillis();
        this.p.submit(new Runnable()
        {
          public void run()
          {
            try
            {
              c.a(c.this);
              return;
            }
            catch (Exception localException)
            {
              c.b(c.this).post(new Runnable()
              {
                public void run()
                {
                  c.this.a.a(false, 0);
                }
              });
              Bundle localBundle = new Bundle();
              localBundle.putString("op_name", "check_version_error");
              localBundle.putString("d1", localException.toString());
              com.tencent.util.g.a.a(localBundle);
              com.tencent.util.e.a.b("NowPluginManager | PluginChecker", "runImpl, e=" + localException.toString());
            }
          }
        });
        return;
      }
      a(true, this.e);
    }
  }
  
  public boolean a()
  {
    long l2 = System.currentTimeMillis();
    long l3 = this.m;
    long l1 = 86400000L;
    if (i.a(this.k)) {
      l1 = 180000L;
    }
    return l2 - l3 > l1;
  }
  
  public long b()
  {
    return this.m;
  }
  
  public String c()
  {
    return this.h + " json = " + this.c;
  }
  
  public g d()
  {
    return this.f;
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.a.c
 * JD-Core Version:    0.7.0.1
 */