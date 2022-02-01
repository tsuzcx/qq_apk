package com.tencent.token.core.bean;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.tencent.token.ci;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.g;
import org.json.JSONException;
import org.json.JSONObject;

public class h
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
    h();
  }
  
  private boolean a(int paramInt)
  {
    if (this.g != paramInt) {
      this.h = 0;
    }
    this.g = paramInt;
    this.i = (System.currentTimeMillis() / 1000L);
    this.h += 1;
    Object localObject = f();
    if (localObject == null) {
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("remind_version", this.g);
    ((SharedPreferences.Editor)localObject).putLong("remind_lasttime", this.i);
    ((SharedPreferences.Editor)localObject).putInt("remind_times", this.h);
    ((SharedPreferences.Editor)localObject).putBoolean("remind_start", this.j);
    ((SharedPreferences.Editor)localObject).commit();
    g.a("save reminder: " + this.g + "-" + this.i + "-" + this.h);
    return true;
  }
  
  public static h b()
  {
    if (k == null) {
      k = new h();
    }
    return k;
  }
  
  private SharedPreferences f()
  {
    try
    {
      SharedPreferences localSharedPreferences = RqdApplication.l().getSharedPreferences("com.tencent.token.com", 0);
      return localSharedPreferences;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private void g()
  {
    this.a = 0;
    this.b = 0;
    this.c = "";
    this.d = "";
    this.e = "";
    this.f = "";
    this.j = true;
  }
  
  private void h()
  {
    SharedPreferences localSharedPreferences = f();
    if (localSharedPreferences == null) {
      return;
    }
    this.g = localSharedPreferences.getInt("remind_version", 0);
    this.i = localSharedPreferences.getLong("remind_lasttime", 0L);
    this.h = localSharedPreferences.getInt("remind_times", 0);
    this.j = localSharedPreferences.getBoolean("remind_start", true);
    this.m = localSharedPreferences.getLong("query_time", 0L);
    g.c("loadUpdateInfo" + this.m);
    this.a = localSharedPreferences.getInt("update_type", 0);
    this.b = localSharedPreferences.getInt("vestion", 0);
    this.c = localSharedPreferences.getString("vestion_name", "");
    this.d = localSharedPreferences.getString("downLoad_url", "");
    this.e = localSharedPreferences.getString("market_url", "");
    this.f = localSharedPreferences.getString("new_feature", "");
    this.n = System.currentTimeMillis();
    i();
    g.a("remind his info:[remind_version]" + this.g + "[remind_lasttime]" + this.i + "[remind_times]" + this.h + "[signature]" + this.l);
  }
  
  private void i()
  {
    try
    {
      Context localContext = RqdApplication.l();
      if (localContext != null) {
        this.l = ci.a(com.tencent.token.utils.encrypt.c.b(localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 64).signatures[0].toByteArray()));
      }
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      g.c("NameNotFoundException:" + localNameNotFoundException.toString());
      return;
    }
    catch (Exception localException)
    {
      g.c("Exception:" + localException.toString());
    }
  }
  
  public boolean a()
  {
    if ((this.a == 0) || (1 == this.a) || ((this.j) && (3 != this.a)) || (this.b <= com.tencent.token.global.c.d())) {
      return false;
    }
    this.j = true;
    a(this.b);
    return true;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    g();
    this.m = System.currentTimeMillis();
    g.c("parseUpdateInfo" + this.m);
    try
    {
      this.a = paramJSONObject.getInt("type");
      this.b = paramJSONObject.getInt("version");
      this.c = paramJSONObject.getString("name");
      this.d = paramJSONObject.getString("url");
      this.e = paramJSONObject.getString("market_url");
      this.f = paramJSONObject.getString("feature");
      paramJSONObject = f();
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
      if ((this.a != 0) && (this.a != 1)) {
        e();
      }
      g.a("update:[type]" + this.a + "[version]" + this.b + "[name]" + this.c + "[url]" + this.d + "[market_url]" + this.e + "[feature]" + this.f);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      g();
      g.c("parseUpdate info json error: " + paramJSONObject.getMessage());
    }
    return false;
  }
  
  public boolean c()
  {
    boolean bool = true;
    if ((this.a == 0) || (1 == this.a)) {
      bool = false;
    }
    return bool;
  }
  
  public void d()
  {
    SharedPreferences.Editor localEditor = f().edit();
    localEditor.putBoolean("sp_new_key", false);
    localEditor.commit();
  }
  
  public void e()
  {
    SharedPreferences.Editor localEditor = f().edit();
    localEditor.putBoolean("sp_new_key", true);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.h
 * JD-Core Version:    0.7.0.1
 */