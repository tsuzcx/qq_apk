package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.token.global.RqdApplication;

public final class sc
{
  private static sc b;
  public int a = 0;
  private Context c = null;
  private String d = null;
  
  public static sc a()
  {
    if (b == null) {
      b = new sc();
    }
    sc localsc = b;
    Object localObject = RqdApplication.n();
    if (localsc.c != localObject)
    {
      localsc.c = ((Context)localObject);
      boolean bool;
      if (localObject != null) {
        bool = true;
      } else {
        bool = false;
      }
      xa.a(bool);
      localObject = g();
      if (localObject != null) {
        bool = true;
      } else {
        bool = false;
      }
      xa.a(bool);
      localsc.a = ((SharedPreferences)localObject).getInt("pwd_type", 0);
      if (localsc.a == 2) {
        localsc.d = ((SharedPreferences)localObject).getString("pwd3g", null);
      } else {
        localsc.d = ((SharedPreferences)localObject).getString("pwd", null);
      }
      if (localsc.a == 0)
      {
        localsc.b(localsc.d);
        localsc.a = 1;
      }
    }
    return b;
  }
  
  public static void a(int paramInt)
  {
    Object localObject = g();
    boolean bool;
    if (localObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    xa.a(bool);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("lock_time", paramInt);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static void b()
  {
    b = null;
  }
  
  public static void d(String paramString)
  {
    SharedPreferences.Editor localEditor = RqdApplication.n().getSharedPreferences("startpwd_gesture_new_tip", 0).edit();
    localEditor.putBoolean(paramString, false);
    localEditor.commit();
  }
  
  public static int f()
  {
    SharedPreferences localSharedPreferences = g();
    boolean bool;
    if (localSharedPreferences != null) {
      bool = true;
    } else {
      bool = false;
    }
    xa.a(bool);
    return localSharedPreferences.getInt("lock_time", 0);
  }
  
  public static SharedPreferences g()
  {
    switch ()
    {
    default: 
      return RqdApplication.n().getSharedPreferences("token_pwd_file", 0);
    case 3: 
      return RqdApplication.n().getSharedPreferences("token_pwd_file_gray", 0);
    case 2: 
      return RqdApplication.n().getSharedPreferences("token_pwd_file_exp", 0);
    case 1: 
      return RqdApplication.n().getSharedPreferences("token_pwd_file", 0);
    }
    return RqdApplication.n().getSharedPreferences("token_pwd_file_test", 0);
  }
  
  public final boolean a(String paramString)
  {
    if (paramString != null)
    {
      String str = this.d;
      if (str == null) {
        return false;
      }
      if (this.a > 0) {
        return str.equals(aax.b(aax.a(paramString)));
      }
      return false;
    }
    return false;
  }
  
  public final boolean b(String paramString)
  {
    Object localObject = g();
    boolean bool;
    if (localObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    xa.a(bool);
    localObject = ((SharedPreferences)localObject).edit();
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.d = aax.b(aax.a(paramString));
      ((SharedPreferences.Editor)localObject).putString("pwd", this.d);
      ((SharedPreferences.Editor)localObject).putInt("pwd_type", 1);
      this.a = 1;
    }
    else
    {
      this.d = null;
      ((SharedPreferences.Editor)localObject).remove("pwd");
    }
    ((SharedPreferences.Editor)localObject).commit();
    return true;
  }
  
  public final boolean c()
  {
    String str = this.d;
    return (str != null) && (str.length() > 0);
  }
  
  public final boolean c(String paramString)
  {
    Object localObject = g();
    boolean bool;
    if (localObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    xa.a(bool);
    localObject = ((SharedPreferences)localObject).edit();
    if ((paramString != null) && (paramString.length() > 0))
    {
      if (this.a == 1) {
        b(null);
      }
      this.d = aax.b(aax.a(paramString));
      this.a = 2;
      ((SharedPreferences.Editor)localObject).putString("pwd3g", this.d);
      ((SharedPreferences.Editor)localObject).putInt("pwd_type", 2);
    }
    else
    {
      this.d = null;
      ((SharedPreferences.Editor)localObject).remove("pwd3g");
    }
    ((SharedPreferences.Editor)localObject).commit();
    return true;
  }
  
  public final boolean d()
  {
    String str = this.d;
    return (str != null) && (str.length() > 0) && (this.a == 2);
  }
  
  public final void e()
  {
    c(null);
    Object localObject = g();
    boolean bool;
    if (localObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    xa.a(bool);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("last_lock", 0L);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sc
 * JD-Core Version:    0.7.0.1
 */