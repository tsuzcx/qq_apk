package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Looper;
import java.lang.reflect.Method;

public final class sf
  implements sh
{
  private SharedPreferences a;
  private SharedPreferences.Editor b;
  private boolean c;
  
  public sf(Context paramContext, String paramString)
  {
    this.a = paramContext.getSharedPreferences(paramString, 0);
  }
  
  private static boolean a(SharedPreferences.Editor paramEditor)
  {
    if ((Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) && (Build.VERSION.SDK_INT >= 9)) {}
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
  
  private SharedPreferences.Editor c()
  {
    if (this.b == null) {
      this.b = this.a.edit();
    }
    return this.b;
  }
  
  public final int a(String paramString)
  {
    try
    {
      int i = this.a.getInt(paramString, 0);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public final int a(String paramString, int paramInt)
  {
    try
    {
      System.nanoTime();
      int i = this.a.getInt(paramString, paramInt);
      System.nanoTime();
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  public final long a(String paramString, long paramLong)
  {
    try
    {
      System.nanoTime();
      long l = this.a.getLong(paramString, paramLong);
      return l;
    }
    catch (Exception paramString) {}
    return paramLong;
  }
  
  public final String a(String paramString1, String paramString2)
  {
    try
    {
      System.nanoTime();
      paramString1 = this.a.getString(paramString1, paramString2);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return paramString2;
  }
  
  public final void a()
  {
    this.c = true;
  }
  
  public final boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = this.a.getBoolean(paramString, paramBoolean);
      return bool;
    }
    catch (Exception paramString) {}
    return paramBoolean;
  }
  
  public final boolean b()
  {
    this.c = false;
    SharedPreferences.Editor localEditor = this.b;
    if (localEditor != null) {
      return a(localEditor);
    }
    return true;
  }
  
  public final boolean b(String paramString, int paramInt)
  {
    System.nanoTime();
    SharedPreferences.Editor localEditor = c();
    localEditor.putInt(paramString, paramInt);
    if (!this.c)
    {
      boolean bool = a(localEditor);
      System.nanoTime();
      return bool;
    }
    return true;
  }
  
  public final boolean b(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = c();
    localEditor.putLong(paramString, paramLong);
    if (!this.c) {
      return a(localEditor);
    }
    return true;
  }
  
  public final boolean b(String paramString1, String paramString2)
  {
    System.nanoTime();
    SharedPreferences.Editor localEditor = c();
    localEditor.putString(paramString1, paramString2);
    if (!this.c) {
      return a(localEditor);
    }
    return true;
  }
  
  public final boolean b(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = c();
    localEditor.putBoolean(paramString, paramBoolean);
    if (!this.c) {
      return a(localEditor);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sf
 * JD-Core Version:    0.7.0.1
 */