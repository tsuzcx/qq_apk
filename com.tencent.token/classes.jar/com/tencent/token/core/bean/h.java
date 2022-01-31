package com.tencent.token.core.bean;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.tencent.token.ap;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.gv;
import com.tencent.token.utils.encrypt.c;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
{
  private static h k = null;
  public int a = 0;
  public int b = 0;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public int g = 0;
  public int h = 0;
  public long i = 0L;
  public boolean j = true;
  private String l = "";
  private long m = 0L;
  private long n = 0L;
  
  private h()
  {
    Object localObject = g();
    if (localObject != null)
    {
      this.g = ((SharedPreferences)localObject).getInt("remind_version", 0);
      this.i = ((SharedPreferences)localObject).getLong("remind_lasttime", 0L);
      this.h = ((SharedPreferences)localObject).getInt("remind_times", 0);
      this.j = ((SharedPreferences)localObject).getBoolean("remind_start", true);
      this.m = ((SharedPreferences)localObject).getLong("query_time", 0L);
      e.c("loadUpdateInfo" + this.m);
      this.a = ((SharedPreferences)localObject).getInt("update_type", 0);
      this.b = ((SharedPreferences)localObject).getInt("vestion", 0);
      this.c = ((SharedPreferences)localObject).getString("vestion_name", "");
      this.d = ((SharedPreferences)localObject).getString("downLoad_url", "");
      this.e = ((SharedPreferences)localObject).getString("market_url", "");
      this.f = ((SharedPreferences)localObject).getString("new_feature", "");
      this.n = System.currentTimeMillis();
    }
    try
    {
      localObject = RqdApplication.i();
      if (localObject != null) {
        this.l = ap.a(c.a(localObject.getPackageManager().getPackageInfo(localObject.getPackageName(), 64).signatures[0].toByteArray()));
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        e.c("NameNotFoundException:" + localNameNotFoundException.toString());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        e.c("Exception:" + localException.toString());
      }
    }
    e.a("remind his info:[remind_version]" + this.g + "[remind_lasttime]" + this.i + "[remind_times]" + this.h + "[signature]" + this.l);
  }
  
  public static h b()
  {
    if (k == null) {
      k = new h();
    }
    return k;
  }
  
  public static void f()
  {
    SharedPreferences.Editor localEditor = g().edit();
    localEditor.putBoolean("sp_new_key", false);
    localEditor.commit();
  }
  
  private static SharedPreferences g()
  {
    try
    {
      SharedPreferences localSharedPreferences = RqdApplication.i().getSharedPreferences("com.tencent.token.com", 0);
      return localSharedPreferences;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private void h()
  {
    this.a = 0;
    this.b = 0;
    this.c = "";
    this.d = "";
    this.e = "";
    this.f = "";
    this.j = true;
  }
  
  public final boolean a()
  {
    boolean bool = true;
    if ((this.a == 0) || (1 == this.a) || ((this.j) && (3 != this.a)) || (this.b <= b.b())) {
      bool = false;
    }
    do
    {
      return bool;
      this.j = true;
      int i1 = this.b;
      if (this.g != i1) {
        this.h = 0;
      }
      this.g = i1;
      this.i = (System.currentTimeMillis() / 1000L);
      this.h += 1;
      localObject = g();
    } while (localObject == null);
    Object localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("remind_version", this.g);
    ((SharedPreferences.Editor)localObject).putLong("remind_lasttime", this.i);
    ((SharedPreferences.Editor)localObject).putInt("remind_times", this.h);
    ((SharedPreferences.Editor)localObject).putBoolean("remind_start", this.j);
    ((SharedPreferences.Editor)localObject).commit();
    e.a("save reminder: " + this.g + "-" + this.i + "-" + this.h);
    return true;
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    h();
    this.m = System.currentTimeMillis();
    e.c("parseUpdateInfo" + this.m);
    try
    {
      this.a = paramJSONObject.getInt("type");
      this.b = paramJSONObject.getInt("version");
      this.c = paramJSONObject.getString("name");
      this.d = paramJSONObject.getString("url");
      this.e = paramJSONObject.getString("market_url");
      this.f = paramJSONObject.getString("feature");
      paramJSONObject = g();
      if (paramJSONObject == null) {
        return false;
      }
      paramJSONObject = paramJSONObject.edit();
      paramJSONObject.putInt("update_type", this.a);
      paramJSONObject.putInt("vestion", this.b);
      paramJSONObject.putString("vestion_name", this.c);
      paramJSONObject.putString("downLoad_url", this.d);
      paramJSONObject.putString("market_url", this.e);
      paramJSONObject.putString("new_feature", this.f);
      paramJSONObject.putBoolean("remind_start", false);
      this.j = false;
      paramJSONObject.putLong("query_time", this.m);
      paramJSONObject.commit();
      if ((this.a != 0) && (this.a != 1))
      {
        paramJSONObject = g().edit();
        paramJSONObject.putBoolean("sp_new_key", true);
        paramJSONObject.commit();
      }
      e.a("update:[type]" + this.a + "[version]" + this.b + "[name]" + this.c + "[url]" + this.d + "[market_url]" + this.e + "[feature]" + this.f);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      h();
      e.c("parseUpdate info json error: " + paramJSONObject.getMessage());
    }
    return false;
  }
  
  public final boolean c()
  {
    e.c("mNowTime" + this.n);
    e.c("mLastQueryTime" + this.m);
    return this.n - this.m > 7200000L;
  }
  
  public final d d()
  {
    e.a("start getHttpUpdateInfo process");
    d locald = new d((byte)0);
    Object localObject2 = "?mobile_type=" + 4 + "&client_type=" + 2 + "&client_ver=" + b.b() + "&local_id=0";
    Object localObject1 = localObject2;
    if (this.g > 0) {
      localObject1 = (String)localObject2 + "&rmd_ver=" + this.g + "&rmd_times=" + this.h + "&rmd_last_time=" + this.i;
    }
    String str = b.f();
    localObject2 = localObject1;
    if (str != null) {
      localObject2 = (String)localObject1 + "&ill_priv=" + URLEncoder.encode(str);
    }
    localObject1 = b.c() + "/cn/mbtoken3/mbtoken3_qry_update_info" + (String)localObject2;
    e.a("url params=" + ((String)localObject2).length() + ":" + (String)localObject2);
    localObject2 = new gv();
    localObject1 = ((gv)localObject2).a((String)localObject1);
    if (localObject1 == null)
    {
      localObject1 = ((gv)localObject2).a();
      locald.a(((d)localObject1).a, ((d)localObject1).b, ((d)localObject1).c);
      return locald;
    }
    try
    {
      localObject1 = new String((byte[])localObject1);
      e.a("response: " + (String)localObject1);
      localObject1 = new JSONObject((String)localObject1);
      int i1 = ((JSONObject)localObject1).getInt("err");
      if (i1 != 0)
      {
        localObject1 = ((JSONObject)localObject1).getString("info");
        locald.a(i1, "server errcode=" + i1 + ":" + (String)localObject1, (String)localObject1);
      }
      else if (!a(((JSONObject)localObject1).getJSONObject("update")))
      {
        e.c("parseUpdateInfo error");
      }
    }
    catch (JSONException localJSONException)
    {
      e.c("parse json failed: " + localJSONException.toString());
      locald.a(10020, "JSONException:" + localJSONException.toString(), null);
    }
    return locald;
  }
  
  public final boolean e()
  {
    boolean bool = true;
    if ((this.a == 0) || (1 == this.a)) {
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.h
 * JD-Core Version:    0.7.0.1
 */