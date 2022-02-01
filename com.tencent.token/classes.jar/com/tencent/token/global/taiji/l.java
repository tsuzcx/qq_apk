package com.tencent.token.global.taiji;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import com.tencent.token.global.RqdApplication;
import com.tmsdk.base.utils.SDKUtil;
import java.lang.reflect.Method;
import java.util.Map;
import tmsdk.common.module.pgsdk.manager.ITaijiPreferenceManager;

public class l
  implements ITaijiPreferenceManager
{
  private SharedPreferences a;
  private SharedPreferences.Editor b;
  private boolean c;
  
  public l(String paramString)
  {
    try
    {
      this.a = RqdApplication.l().getSharedPreferences(paramString, 0);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private SharedPreferences.Editor a()
  {
    if (this.b == null) {
      this.b = this.a.edit();
    }
    return this.b;
  }
  
  private boolean a(SharedPreferences.Editor paramEditor)
  {
    if ((Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) && (SDKUtil.getSDKVersion() >= 9)) {}
    try
    {
      paramEditor.getClass().getMethod("apply", new Class[0]).invoke(paramEditor, new Object[0]);
      return true;
    }
    catch (Throwable localThrowable)
    {
      label51:
      break label51;
    }
    return paramEditor.commit();
    return paramEditor.commit();
  }
  
  public void beginTransaction()
  {
    this.c = true;
  }
  
  public void clear()
  {
    if (this.a != null) {
      a(a().clear());
    }
  }
  
  public boolean contains(String paramString)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.contains(paramString);
    }
    return false;
  }
  
  public boolean endTransaction()
  {
    this.c = false;
    SharedPreferences.Editor localEditor = this.b;
    if (localEditor != null) {
      return a(localEditor);
    }
    return true;
  }
  
  public Map<String, ?> getAll()
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getAll();
    }
    return null;
  }
  
  public boolean getBoolean(String paramString)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getBoolean(paramString, false);
    }
    return false;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getBoolean(paramString, paramBoolean);
    }
    return false;
  }
  
  public float getFloat(String paramString)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getFloat(paramString, 0.0F);
    }
    return 0.0F;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getFloat(paramString, paramFloat);
    }
    return 0.0F;
  }
  
  public int getInt(String paramString)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getInt(paramString, 0);
    }
    return 0;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getInt(paramString, paramInt);
    }
    return 0;
  }
  
  public long getLong(String paramString)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getLong(paramString, 0L);
    }
    return 0L;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getLong(paramString, paramLong);
    }
    return 0L;
  }
  
  public String getString(String paramString)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString(paramString, null);
    }
    return null;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString(paramString1, paramString2);
    }
    return null;
  }
  
  public boolean putBoolean(String paramString, boolean paramBoolean)
  {
    if (this.a != null)
    {
      SharedPreferences.Editor localEditor = a();
      localEditor.putBoolean(paramString, paramBoolean);
      if (!this.c) {
        return a(localEditor);
      }
    }
    return false;
  }
  
  public boolean putFloat(String paramString, float paramFloat)
  {
    if (this.a != null)
    {
      SharedPreferences.Editor localEditor = a();
      localEditor.putFloat(paramString, paramFloat);
      if (!this.c) {
        return a(localEditor);
      }
    }
    return false;
  }
  
  public boolean putInt(String paramString, int paramInt)
  {
    if (this.a != null)
    {
      SharedPreferences.Editor localEditor = a();
      localEditor.putInt(paramString, paramInt);
      if (!this.c) {
        return a(localEditor);
      }
    }
    return false;
  }
  
  public boolean putLong(String paramString, long paramLong)
  {
    if (this.a != null)
    {
      SharedPreferences.Editor localEditor = a();
      localEditor.putLong(paramString, paramLong);
      if (!this.c) {
        return a(localEditor);
      }
    }
    return false;
  }
  
  public boolean putString(String paramString1, String paramString2)
  {
    if (this.a != null)
    {
      SharedPreferences.Editor localEditor = a();
      localEditor.putString(paramString1, paramString2);
      if (!this.c) {
        return a(localEditor);
      }
    }
    return false;
  }
  
  public boolean remove(String paramString)
  {
    if (this.a != null) {
      return a(a().remove(paramString));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.l
 * JD-Core Version:    0.7.0.1
 */