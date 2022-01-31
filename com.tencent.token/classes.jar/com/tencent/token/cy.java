package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;

public class cy
{
  private static cy b = null;
  public int a = 0;
  private Context c = null;
  private String d = null;
  
  public static cy a()
  {
    if (b == null) {
      b = new cy();
    }
    b.d(RqdApplication.l());
    return b;
  }
  
  public static void b()
  {
    b = null;
  }
  
  private String c(String paramString)
  {
    return com.tencent.token.utils.encrypt.c.c(com.tencent.token.utils.encrypt.c.a(paramString));
  }
  
  private void d(Context paramContext)
  {
    if (this.c == paramContext) {}
    label36:
    label105:
    label110:
    label124:
    for (;;)
    {
      return;
      this.c = paramContext;
      boolean bool;
      if (paramContext != null)
      {
        bool = true;
        h.a(bool);
        paramContext = c(paramContext);
        if (paramContext == null) {
          break label105;
        }
        bool = true;
        h.a(bool);
        this.a = paramContext.getInt("pwd_type", 0);
        if (this.a != 2) {
          break label110;
        }
      }
      for (this.d = paramContext.getString("pwd3g", null);; this.d = paramContext.getString("pwd", null))
      {
        if (this.a != 0) {
          break label124;
        }
        a(this.c, this.d);
        this.a = 1;
        return;
        bool = false;
        break;
        bool = false;
        break label36;
      }
    }
  }
  
  public void a(Context paramContext)
  {
    b(paramContext, null);
    a(paramContext, 0L);
  }
  
  public void a(Context paramContext, int paramInt)
  {
    paramContext = c(paramContext);
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      h.a(bool);
      paramContext = paramContext.edit();
      paramContext.putInt("lock_time", paramInt);
      paramContext.commit();
      return;
    }
  }
  
  public void a(Context paramContext, long paramLong)
  {
    paramContext = c(paramContext);
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      h.a(bool);
      paramContext = paramContext.edit();
      paramContext.putLong("last_lock", paramLong);
      paramContext.commit();
      return;
    }
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    paramContext = c(paramContext);
    boolean bool;
    if (paramContext != null)
    {
      bool = true;
      h.a(bool);
      paramContext = paramContext.edit();
      if ((paramString != null) && (paramString.length() > 0)) {
        break label62;
      }
      this.d = null;
      paramContext.remove("pwd");
    }
    for (;;)
    {
      paramContext.commit();
      return true;
      bool = false;
      break;
      label62:
      this.d = c(paramString);
      paramContext.putString("pwd", this.d);
      paramContext.putInt("pwd_type", 1);
      this.a = 1;
    }
  }
  
  public boolean a(String paramString)
  {
    if ((paramString == null) || (this.d == null)) {}
    while (1 > this.a) {
      return false;
    }
    return this.d.equals(c(paramString));
  }
  
  public int b(Context paramContext)
  {
    paramContext = c(paramContext);
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      h.a(bool);
      return paramContext.getInt("lock_time", 0);
    }
  }
  
  public void b(String paramString)
  {
    SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("startpwd_gesture_new_tip", 0).edit();
    localEditor.putBoolean(paramString, false);
    localEditor.commit();
  }
  
  public boolean b(Context paramContext, String paramString)
  {
    Object localObject = c(paramContext);
    boolean bool;
    if (localObject != null)
    {
      bool = true;
      h.a(bool);
      localObject = ((SharedPreferences)localObject).edit();
      if ((paramString != null) && (paramString.length() > 0)) {
        break label68;
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
      label68:
      if (this.a == 1) {
        a(paramContext, null);
      }
      this.d = c(paramString);
      this.a = 2;
      ((SharedPreferences.Editor)localObject).putString("pwd3g", this.d);
      ((SharedPreferences.Editor)localObject).putInt("pwd_type", 2);
    }
  }
  
  public SharedPreferences c(Context paramContext)
  {
    switch ()
    {
    default: 
      return RqdApplication.l().getSharedPreferences("token_pwd_file", 0);
    case 0: 
      return RqdApplication.l().getSharedPreferences("token_pwd_file_test", 0);
    case 1: 
      return RqdApplication.l().getSharedPreferences("token_pwd_file", 0);
    case 2: 
      return RqdApplication.l().getSharedPreferences("token_pwd_file_exp", 0);
    }
    return RqdApplication.l().getSharedPreferences("token_pwd_file_gray", 0);
  }
  
  public boolean c()
  {
    return (this.d != null) && (this.d.length() > 0);
  }
  
  public boolean d()
  {
    return (this.d != null) && (this.d.length() > 0) && (this.a == 2);
  }
  
  public int e()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cy
 * JD-Core Version:    0.7.0.1
 */