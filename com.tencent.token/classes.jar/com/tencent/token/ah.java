package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.utils.encrypt.c;

public final class ah
{
  private static ah b = null;
  public int a = 0;
  private Context c = null;
  private String d = null;
  
  public static ah a()
  {
    if (b == null) {
      b = new ah();
    }
    ah localah = b;
    Object localObject = RqdApplication.i();
    boolean bool;
    if (localah.c != localObject)
    {
      localah.c = ((Context)localObject);
      if (localObject == null) {
        break label120;
      }
      bool = true;
      e.a(bool);
      localObject = h();
      if (localObject == null) {
        break label125;
      }
      bool = true;
      label57:
      e.a(bool);
      localah.a = ((SharedPreferences)localObject).getInt("pwd_type", 0);
      if (localah.a != 2) {
        break label130;
      }
    }
    label130:
    for (localah.d = ((SharedPreferences)localObject).getString("pwd3g", null);; localah.d = ((SharedPreferences)localObject).getString("pwd", null))
    {
      if (localah.a == 0)
      {
        localah.b(localah.d);
        localah.a = 1;
      }
      return b;
      label120:
      bool = false;
      break;
      label125:
      bool = false;
      break label57;
    }
  }
  
  public static void a(int paramInt)
  {
    Object localObject = h();
    if (localObject != null) {}
    for (boolean bool = true;; bool = false)
    {
      e.a(bool);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("lock_time", paramInt);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
  }
  
  public static void b()
  {
    b = null;
  }
  
  public static void d(String paramString)
  {
    SharedPreferences.Editor localEditor = RqdApplication.i().getSharedPreferences("startpwd_gesture_new_tip", 0).edit();
    localEditor.putBoolean(paramString, false);
    localEditor.commit();
  }
  
  public static int g()
  {
    SharedPreferences localSharedPreferences = h();
    if (localSharedPreferences != null) {}
    for (boolean bool = true;; bool = false)
    {
      e.a(bool);
      return localSharedPreferences.getInt("lock_time", 0);
    }
  }
  
  public static SharedPreferences h()
  {
    switch ()
    {
    default: 
      return RqdApplication.i().getSharedPreferences("token_pwd_file", 0);
    case 0: 
      return RqdApplication.i().getSharedPreferences("token_pwd_file_test", 0);
    case 1: 
      return RqdApplication.i().getSharedPreferences("token_pwd_file", 0);
    case 2: 
      return RqdApplication.i().getSharedPreferences("token_pwd_file_exp", 0);
    }
    return RqdApplication.i().getSharedPreferences("token_pwd_file_gray", 0);
  }
  
  public final boolean a(String paramString)
  {
    if ((paramString == null) || (this.d == null)) {}
    while (this.a <= 0) {
      return false;
    }
    return this.d.equals(c.b(c.a(paramString)));
  }
  
  public final boolean b(String paramString)
  {
    Object localObject = h();
    boolean bool;
    if (localObject != null)
    {
      bool = true;
      e.a(bool);
      localObject = ((SharedPreferences)localObject).edit();
      if ((paramString != null) && (paramString.length() > 0)) {
        break label60;
      }
      this.d = null;
      ((SharedPreferences.Editor)localObject).remove("pwd");
    }
    for (;;)
    {
      ((SharedPreferences.Editor)localObject).commit();
      return true;
      bool = false;
      break;
      label60:
      this.d = c.b(c.a(paramString));
      ((SharedPreferences.Editor)localObject).putString("pwd", this.d);
      ((SharedPreferences.Editor)localObject).putInt("pwd_type", 1);
      this.a = 1;
    }
  }
  
  public final boolean c()
  {
    return (this.d != null) && (this.d.length() > 0);
  }
  
  public final boolean c(String paramString)
  {
    Object localObject = h();
    boolean bool;
    if (localObject != null)
    {
      bool = true;
      e.a(bool);
      localObject = ((SharedPreferences)localObject).edit();
      if ((paramString != null) && (paramString.length() > 0)) {
        break label60;
      }
      this.d = null;
      ((SharedPreferences.Editor)localObject).remove("pwd3g");
    }
    for (;;)
    {
      ((SharedPreferences.Editor)localObject).commit();
      return true;
      bool = false;
      break;
      label60:
      if (this.a == 1) {
        b(null);
      }
      this.d = c.b(c.a(paramString));
      this.a = 2;
      ((SharedPreferences.Editor)localObject).putString("pwd3g", this.d);
      ((SharedPreferences.Editor)localObject).putInt("pwd_type", 2);
    }
  }
  
  public final boolean d()
  {
    return (this.d != null) && (this.d.length() > 0) && (this.a == 2);
  }
  
  public final int e()
  {
    return this.a;
  }
  
  public final void f()
  {
    c(null);
    Object localObject = h();
    if (localObject != null) {}
    for (boolean bool = true;; bool = false)
    {
      e.a(bool);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("last_lock", 0L);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ah
 * JD-Core Version:    0.7.0.1
 */