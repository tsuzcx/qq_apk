package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.g;

public class ce
{
  private static ce b;
  public int a = 0;
  private Context c = null;
  private String d = null;
  
  public static ce a()
  {
    if (b == null) {
      b = new ce();
    }
    b.d(RqdApplication.n());
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
    if (this.c == paramContext) {
      return;
    }
    this.c = paramContext;
    boolean bool;
    if (paramContext != null) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    paramContext = c(paramContext);
    if (paramContext != null) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    this.a = paramContext.getInt("pwd_type", 0);
    if (this.a == 2) {
      this.d = paramContext.getString("pwd3g", null);
    } else {
      this.d = paramContext.getString("pwd", null);
    }
    if (this.a == 0)
    {
      a(this.c, this.d);
      this.a = 1;
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
    boolean bool;
    if (paramContext != null) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    paramContext = paramContext.edit();
    paramContext.putInt("lock_time", paramInt);
    paramContext.commit();
  }
  
  public void a(Context paramContext, long paramLong)
  {
    paramContext = c(paramContext);
    boolean bool;
    if (paramContext != null) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    paramContext = paramContext.edit();
    paramContext.putLong("last_lock", paramLong);
    paramContext.commit();
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    paramContext = c(paramContext);
    boolean bool;
    if (paramContext != null) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    paramContext = paramContext.edit();
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.d = c(paramString);
      paramContext.putString("pwd", this.d);
      paramContext.putInt("pwd_type", 1);
      this.a = 1;
    }
    else
    {
      this.d = null;
      paramContext.remove("pwd");
    }
    paramContext.commit();
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (paramString != null)
    {
      String str = this.d;
      if (str == null) {
        return false;
      }
      if (1 <= this.a) {
        return str.equals(c(paramString));
      }
      return false;
    }
    return false;
  }
  
  public int b(Context paramContext)
  {
    paramContext = c(paramContext);
    boolean bool;
    if (paramContext != null) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    return paramContext.getInt("lock_time", 0);
  }
  
  public void b(String paramString)
  {
    SharedPreferences.Editor localEditor = RqdApplication.n().getSharedPreferences("startpwd_gesture_new_tip", 0).edit();
    localEditor.putBoolean(paramString, false);
    localEditor.commit();
  }
  
  public boolean b(Context paramContext, String paramString)
  {
    Object localObject = c(paramContext);
    boolean bool;
    if (localObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    localObject = ((SharedPreferences)localObject).edit();
    if ((paramString != null) && (paramString.length() > 0))
    {
      if (this.a == 1) {
        a(paramContext, null);
      }
      this.d = c(paramString);
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
  
  public SharedPreferences c(Context paramContext)
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
  
  public boolean c()
  {
    String str = this.d;
    return (str != null) && (str.length() > 0);
  }
  
  public boolean d()
  {
    String str = this.d;
    return (str != null) && (str.length() > 0) && (this.a == 2);
  }
  
  public int e()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ce
 * JD-Core Version:    0.7.0.1
 */