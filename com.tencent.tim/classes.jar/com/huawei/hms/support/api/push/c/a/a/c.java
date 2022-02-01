package com.huawei.hms.support.api.push.c.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

public class c
{
  protected SharedPreferences a;
  
  public c(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new NullPointerException("context is null!");
    }
    Context localContext = paramContext;
    SharedPreferences localSharedPreferences;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localContext = paramContext.createDeviceProtectedStorageContext();
      localSharedPreferences = localContext.getSharedPreferences("move_to_de_records", 0);
      if (localSharedPreferences.getBoolean(paramString, false)) {
        break label100;
      }
      if (localContext.moveSharedPreferencesFrom(paramContext, paramString)) {
        break label76;
      }
      localContext = paramContext;
    }
    label76:
    label100:
    for (;;)
    {
      this.a = localContext.getSharedPreferences(paramString, 0);
      return;
      paramContext = localSharedPreferences.edit();
      paramContext.putBoolean(paramString, true);
      paramContext.commit();
    }
  }
  
  public String a(String paramString)
  {
    if (this.a != null) {
      return this.a.getString(paramString, "");
    }
    return "";
  }
  
  public void a(String paramString, Long paramLong)
  {
    if (this.a == null) {}
    SharedPreferences.Editor localEditor;
    do
    {
      return;
      localEditor = this.a.edit();
    } while (localEditor == null);
    localEditor.putLong(paramString, paramLong.longValue()).commit();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.a == null) {}
    SharedPreferences.Editor localEditor;
    do
    {
      return;
      localEditor = this.a.edit();
    } while (localEditor == null);
    localEditor.putBoolean(paramString, paramBoolean).commit();
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (this.a == null) {}
    SharedPreferences.Editor localEditor;
    do
    {
      return false;
      localEditor = this.a.edit();
    } while (localEditor == null);
    return localEditor.putString(paramString1, paramString2).commit();
  }
  
  public boolean b(String paramString)
  {
    return (this.a != null) && (this.a.contains(paramString));
  }
  
  public boolean c(String paramString)
  {
    if ((this.a != null) && (this.a.contains(paramString)))
    {
      SharedPreferences.Editor localEditor = this.a.edit();
      if (localEditor != null) {
        return localEditor.remove(paramString).commit();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.push.c.a.a.c
 * JD-Core Version:    0.7.0.1
 */