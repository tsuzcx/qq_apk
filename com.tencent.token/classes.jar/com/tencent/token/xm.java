package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import com.tencent.token.global.RqdApplication;
import com.tmsdk.base.utils.SDKUtil;
import java.lang.reflect.Method;

public final class xm
  implements asg
{
  private SharedPreferences a;
  private SharedPreferences.Editor b;
  private boolean c;
  
  public xm(String paramString)
  {
    try
    {
      this.a = RqdApplication.n().getSharedPreferences(paramString, 0);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static boolean a(SharedPreferences.Editor paramEditor)
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
  
  private SharedPreferences.Editor d()
  {
    if (this.b == null) {
      this.b = this.a.edit();
    }
    return this.b;
  }
  
  public final int a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getInt(paramString, paramInt);
    }
    return 0;
  }
  
  public final long a(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getLong(paramString, paramLong);
    }
    return 0L;
  }
  
  public final String a(String paramString)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString(paramString, null);
    }
    return null;
  }
  
  public final String a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString(paramString1, paramString2);
    }
    return null;
  }
  
  public final void a()
  {
    if (this.a != null) {
      a(d().clear());
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getBoolean(paramString, paramBoolean);
    }
    return false;
  }
  
  public final void b()
  {
    this.c = true;
  }
  
  public final boolean b(String paramString)
  {
    if (this.a != null) {
      return a(d().remove(paramString));
    }
    return false;
  }
  
  public final boolean b(String paramString, int paramInt)
  {
    if (this.a != null)
    {
      SharedPreferences.Editor localEditor = d();
      localEditor.putInt(paramString, paramInt);
      if (!this.c) {
        return a(localEditor);
      }
    }
    return false;
  }
  
  public final boolean b(String paramString, long paramLong)
  {
    if (this.a != null)
    {
      SharedPreferences.Editor localEditor = d();
      localEditor.putLong(paramString, paramLong);
      if (!this.c) {
        return a(localEditor);
      }
    }
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2)
  {
    if (this.a != null)
    {
      SharedPreferences.Editor localEditor = d();
      localEditor.putString(paramString1, paramString2);
      if (!this.c) {
        return a(localEditor);
      }
    }
    return false;
  }
  
  public final boolean b(String paramString, boolean paramBoolean)
  {
    if (this.a != null)
    {
      SharedPreferences.Editor localEditor = d();
      localEditor.putBoolean(paramString, paramBoolean);
      if (!this.c) {
        return a(localEditor);
      }
    }
    return false;
  }
  
  public final boolean c()
  {
    this.c = false;
    SharedPreferences.Editor localEditor = this.b;
    if (localEditor != null) {
      return a(localEditor);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xm
 * JD-Core Version:    0.7.0.1
 */