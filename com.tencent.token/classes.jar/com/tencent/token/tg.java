package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.tencent.token.global.RqdApplication;
import org.json.JSONException;
import org.json.JSONObject;

public final class tg
{
  private static tg k;
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
  
  private tg()
  {
    Object localObject = a();
    if (localObject != null)
    {
      this.g = ((SharedPreferences)localObject).getInt("remind_version", 0);
      this.i = ((SharedPreferences)localObject).getLong("remind_lasttime", 0L);
      this.h = ((SharedPreferences)localObject).getInt("remind_times", 0);
      this.j = ((SharedPreferences)localObject).getBoolean("remind_start", true);
      this.m = ((SharedPreferences)localObject).getLong("query_time", 0L);
      StringBuilder localStringBuilder2 = new StringBuilder("loadUpdateInfo");
      localStringBuilder2.append(this.m);
      xv.c(localStringBuilder2.toString());
      this.a = ((SharedPreferences)localObject).getInt("update_type", 0);
      this.b = ((SharedPreferences)localObject).getInt("vestion", 0);
      this.c = ((SharedPreferences)localObject).getString("vestion_name", "");
      this.d = ((SharedPreferences)localObject).getString("downLoad_url", "");
      this.e = ((SharedPreferences)localObject).getString("market_url", "");
      this.f = ((SharedPreferences)localObject).getString("new_feature", "");
      this.n = System.currentTimeMillis();
      try
      {
        localObject = RqdApplication.n();
        if (localObject != null) {
          this.l = tl.a(abt.a(localObject.getPackageManager().getPackageInfo(localObject.getPackageName(), 64).signatures[0].toByteArray()));
        }
      }
      catch (Exception localException)
      {
        localStringBuilder2 = new StringBuilder("Exception:");
        localStringBuilder2.append(localException.toString());
        xv.c(localStringBuilder2.toString());
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        localStringBuilder2 = new StringBuilder("NameNotFoundException:");
        localStringBuilder2.append(localNameNotFoundException.toString());
        xv.c(localStringBuilder2.toString());
      }
      StringBuilder localStringBuilder1 = new StringBuilder("remind his info:[remind_version]");
      localStringBuilder1.append(this.g);
      localStringBuilder1.append("[remind_lasttime]");
      localStringBuilder1.append(this.i);
      localStringBuilder1.append("[remind_times]");
      localStringBuilder1.append(this.h);
      localStringBuilder1.append("[signature]");
      localStringBuilder1.append(this.l);
      xv.a(localStringBuilder1.toString());
    }
  }
  
  public static SharedPreferences a()
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
  
  public static tg b()
  {
    if (k == null) {
      k = new tg();
    }
    return k;
  }
  
  private void c()
  {
    this.a = 0;
    this.b = 0;
    this.c = "";
    this.d = "";
    this.e = "";
    this.f = "";
    this.j = true;
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    c();
    this.m = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder("parseUpdateInfo");
    localStringBuilder.append(this.m);
    xv.c(localStringBuilder.toString());
    try
    {
      this.a = paramJSONObject.getInt("type");
      this.b = paramJSONObject.getInt("version");
      this.c = paramJSONObject.getString("name");
      this.d = paramJSONObject.getString("url");
      this.e = paramJSONObject.getString("market_url");
      this.f = paramJSONObject.getString("feature");
      paramJSONObject = a();
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
      if ((i1 != 0) && (i1 != 1))
      {
        paramJSONObject = a().edit();
        paramJSONObject.putBoolean("sp_new_key", true);
        paramJSONObject.commit();
      }
      paramJSONObject = new StringBuilder("update:[type]");
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
      xv.a(paramJSONObject.toString());
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      c();
      localStringBuilder = new StringBuilder("parseUpdate info json error: ");
      localStringBuilder.append(paramJSONObject.getMessage());
      xv.c(localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tg
 * JD-Core Version:    0.7.0.1
 */