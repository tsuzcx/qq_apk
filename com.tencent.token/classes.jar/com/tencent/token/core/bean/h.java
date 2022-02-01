package com.tencent.token.core.bean;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.tencent.token.ck;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.g;
import org.json.JSONException;
import org.json.JSONObject;

public class h
{
  private static h k;
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
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("save reminder: ");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(this.h);
    g.a(((StringBuilder)localObject).toString());
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
      SharedPreferences localSharedPreferences = RqdApplication.n().getSharedPreferences("com.tencent.token.com", 0);
      return localSharedPreferences;
    }
    catch (Exception localException)
    {
      label12:
      break label12;
    }
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
    Object localObject = f();
    if (localObject == null) {
      return;
    }
    this.g = ((SharedPreferences)localObject).getInt("remind_version", 0);
    this.i = ((SharedPreferences)localObject).getLong("remind_lasttime", 0L);
    this.h = ((SharedPreferences)localObject).getInt("remind_times", 0);
    this.j = ((SharedPreferences)localObject).getBoolean("remind_start", true);
    this.m = ((SharedPreferences)localObject).getLong("query_time", 0L);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadUpdateInfo");
    localStringBuilder.append(this.m);
    g.c(localStringBuilder.toString());
    this.a = ((SharedPreferences)localObject).getInt("update_type", 0);
    this.b = ((SharedPreferences)localObject).getInt("vestion", 0);
    this.c = ((SharedPreferences)localObject).getString("vestion_name", "");
    this.d = ((SharedPreferences)localObject).getString("downLoad_url", "");
    this.e = ((SharedPreferences)localObject).getString("market_url", "");
    this.f = ((SharedPreferences)localObject).getString("new_feature", "");
    this.n = System.currentTimeMillis();
    i();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("remind his info:[remind_version]");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append("[remind_lasttime]");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append("[remind_times]");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append("[signature]");
    ((StringBuilder)localObject).append(this.l);
    g.a(((StringBuilder)localObject).toString());
  }
  
  private void i()
  {
    try
    {
      Context localContext = RqdApplication.n();
      if (localContext != null)
      {
        this.l = ck.a(com.tencent.token.utils.encrypt.c.b(localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 64).signatures[0].toByteArray()));
        return;
      }
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception:");
      localStringBuilder.append(localException.toString());
      g.c(localStringBuilder.toString());
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NameNotFoundException:");
      localStringBuilder.append(localNameNotFoundException.toString());
      g.c(localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    int i1 = this.a;
    if ((i1 != 0) && (1 != i1) && ((!this.j) || (3 == i1)) && (this.b > com.tencent.token.global.c.d()))
    {
      this.j = true;
      a(this.b);
      return true;
    }
    return false;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    g();
    this.m = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseUpdateInfo");
    localStringBuilder.append(this.m);
    g.c(localStringBuilder.toString());
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
      int i1 = this.a;
      if ((i1 != 0) && (i1 != 1)) {
        e();
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("update:[type]");
      paramJSONObject.append(this.a);
      paramJSONObject.append("[version]");
      paramJSONObject.append(this.b);
      paramJSONObject.append("[name]");
      paramJSONObject.append(this.c);
      paramJSONObject.append("[url]");
      paramJSONObject.append(this.d);
      paramJSONObject.append("[market_url]");
      paramJSONObject.append(this.e);
      paramJSONObject.append("[feature]");
      paramJSONObject.append(this.f);
      g.a(paramJSONObject.toString());
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      g();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseUpdate info json error: ");
      localStringBuilder.append(paramJSONObject.getMessage());
      g.c(localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean c()
  {
    int i1 = this.a;
    return (i1 != 0) && (1 != i1);
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