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

public class aa
  implements ITaijiPreferenceManager
{
  private SharedPreferences a;
  private SharedPreferences.Editor b;
  private boolean c;
  
  public aa(String paramString)
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
    if ((Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) && (SDKUtil.getSDKVersion() >= 9)) {
      try
      {
        paramEditor.getClass().getMethod("apply", new Class[0]).invoke(paramEditor, new Object[0]);
        return true;
      }
      catch (Throwable localThrowable)
      {
        return paramEditor.commit();
      }
    }
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
    if (this.a != null) {
      return this.a.contains(paramString);
    }
    return false;
  }
  
  public boolean endTransaction()
  {
    this.c = false;
    if (this.b != null) {
      return a(this.b);
    }
    return true;
  }
  
  public Map getAll()
  {
    if (this.a != null) {
      return this.a.getAll();
    }
    return null;
  }
  
  public boolean getBoolean(String paramString)
  {
    boolean bool = false;
    if (this.a != null) {
      bool = this.a.getBoolean(paramString, false);
    }
    return bool;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.getBoolean(paramString, paramBoolean);
    }
    return false;
  }
  
  public float getFloat(String paramString)
  {
    float f = 0.0F;
    if (this.a != null) {
      f = this.a.getFloat(paramString, 0.0F);
    }
    return f;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    if (this.a != null) {
      return this.a.getFloat(paramString, paramFloat);
    }
    return 0.0F;
  }
  
  public int getInt(String paramString)
  {
    int i = 0;
    if (this.a != null) {
      i = this.a.getInt(paramString, 0);
    }
    return i;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    if (this.a != null) {
      return this.a.getInt(paramString, paramInt);
    }
    return 0;
  }
  
  public long getLong(String paramString)
  {
    long l = 0L;
    if (this.a != null) {
      l = this.a.getLong(paramString, 0L);
    }
    return l;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    if (this.a != null) {
      return this.a.getLong(paramString, paramLong);
    }
    return 0L;
  }
  
  public String getString(String paramString)
  {
    String str = null;
    if (this.a != null) {
      str = this.a.getString(paramString, null);
    }
    return str;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    if (this.a != null) {
      return this.a.getString(paramString1, paramString2);
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
 * Qualified Name:     com.tencent.token.global.taiji.aa
 * JD-Core Version:    0.7.0.1
 */