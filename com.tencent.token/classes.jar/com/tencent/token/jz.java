package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

public final class jz
{
  private Context a;
  private apd b;
  
  public jz(Context paramContext)
  {
    this.a = paramContext;
    this.b = new apd("sk");
  }
  
  static long a(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception paramString)
    {
      label7:
      break label7;
    }
    return 0L;
  }
  
  static int b(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      label7:
      break label7;
    }
    return 0;
  }
  
  static boolean c(String paramString)
  {
    try
    {
      boolean bool = Boolean.parseBoolean(paramString);
      return bool;
    }
    catch (Exception paramString)
    {
      label7:
      break label7;
    }
    return false;
  }
  
  public final long a()
  {
    String str = b("key_gd_ck_tm", "");
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (Exception localException)
    {
      label16:
      break label16;
    }
    return 0L;
  }
  
  final void a(String paramString1, String paramString2)
  {
    paramString2 = aha.a(this.a, paramString2);
    if (paramString2 == null) {
      return;
    }
    apd localapd = this.b;
    localapd.a().putString(paramString1, paramString2);
    localapd.a().commit();
  }
  
  public final long b()
  {
    String str = b("key_gd_tm", "");
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (Exception localException)
    {
      label16:
      break label16;
    }
    return 0L;
  }
  
  final String b(String paramString1, String paramString2)
  {
    paramString1 = this.b.a.getString(paramString1, paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    return aha.b(this.a, paramString1);
  }
  
  public final int c()
  {
    String str = b("key_ha", "");
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (Exception localException)
    {
      label16:
      break label16;
    }
    return 0;
  }
  
  public final int d()
  {
    String str = b("key_ha_sq", "");
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (Exception localException)
    {
      label16:
      break label16;
    }
    return 0;
  }
  
  public final long e()
  {
    String str = b("key_lt_tm", "");
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (Exception localException)
    {
      label16:
      break label16;
    }
    return 0L;
  }
  
  public final int f()
  {
    String str = b("key_itsc", "");
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (Exception localException)
    {
      label16:
      break label16;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.jz
 * JD-Core Version:    0.7.0.1
 */