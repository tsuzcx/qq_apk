package com.tencent.token;

import a.e.a;
import android.content.Context;
import android.text.TextUtils;
import tmsdk.common.c.a.h;

public class b
{
  private Context a;
  private h b;
  
  public b(Context paramContext)
  {
    this.a = paramContext;
    this.b = new h("sk");
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString2 = ek.a(this.a, paramString2);
    if (paramString2 == null) {
      return;
    }
    this.b.a(paramString1, paramString2, true);
  }
  
  private String b(String paramString1, String paramString2)
  {
    paramString1 = this.b.a(paramString1, paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    return ek.b(this.a, paramString1);
  }
  
  private long h(String paramString)
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
  
  private int i(String paramString)
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
  
  private boolean j(String paramString)
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
  
  public String a()
  {
    return b("key_ek", "");
  }
  
  public void a(int paramInt)
  {
    String str = Integer.toString(paramInt);
    if (str == null) {
      return;
    }
    a("key_ha", str);
  }
  
  public void a(long paramLong)
  {
    a("key_gd_ck_tm", Long.toString(paramLong));
  }
  
  public void a(a parama)
  {
    a("key_gd_1", parama.a);
    a("key_gd_2", parama.b);
    a("key_gd_3", parama.c);
    a("key_gd_4", parama.d);
    a("key_gd_5", parama.e);
    a("key_gd_6", Integer.toString(parama.f));
    a("key_gd_7", parama.g);
    a("key_gd_8", Integer.toString(parama.h));
    a("key_gd_9", parama.i);
    a("key_gd_10", Integer.toString(parama.j));
    a("key_gd_11", Integer.toString(parama.k));
    a("key_gd_12", Boolean.toString(parama.l));
    a("key_gd_13", parama.m);
    a("key_gd_14", parama.n);
    a("key_gd_15", Integer.toString(parama.o));
    a("key_gd_16", parama.p);
    a("key_gd_17", Integer.toString(parama.q));
    a("key_gd_18", Integer.toString(parama.r));
    a("key_gd_19", parama.s);
    a("key_gd_20", parama.t);
    a("key_gd_21", Integer.toString(parama.u));
    a("key_gd_22", parama.v);
    a("key_gd_23", Long.toString(parama.w));
    a("key_gd_24", Long.toString(parama.x));
    a("key_gd_25", Long.toString(parama.y));
    a("key_gd_26", parama.z);
    a("key_gd_27", parama.A);
    a("key_gd_28", parama.B);
    a("key_gd_29", parama.P);
    a("key_gd_30", Integer.toString(parama.Q));
  }
  
  public void a(String paramString)
  {
    a("key_ek", paramString);
  }
  
  public String b()
  {
    return b("key_sid", "");
  }
  
  public void b(int paramInt)
  {
    String str = Integer.toString(paramInt);
    if (str == null) {
      return;
    }
    a("key_ha_sq", str);
  }
  
  public void b(long paramLong)
  {
    String str = Long.toString(paramLong);
    if (str == null) {
      return;
    }
    a("key_gd_tm", str);
  }
  
  public void b(String paramString)
  {
    a("key_sid", paramString);
  }
  
  public String c()
  {
    return b("key_gd", "");
  }
  
  public void c(int paramInt)
  {
    String str = Integer.toString(paramInt);
    if (str == null) {
      return;
    }
    a("key_itsc", str);
  }
  
  public void c(long paramLong)
  {
    String str = Long.toString(paramLong);
    if (str == null) {
      return;
    }
    a("key_lt_tm", str);
  }
  
  public void c(String paramString)
  {
    a("key_gd", paramString);
  }
  
  public String d()
  {
    return null;
  }
  
  public void d(String paramString)
  {
    a("key_pl", paramString);
  }
  
  public long e()
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
  
  public void e(String paramString)
  {
    a("key_mc", paramString);
  }
  
  public long f()
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
  
  public void f(String paramString)
  {
    a("key_nu", paramString);
  }
  
  public int g()
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
  
  public void g(String paramString)
  {
    a("key_tc", paramString);
  }
  
  public int h()
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
  
  public long i()
  {
    String str = b("key_lt_tm", "");
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    return 0L;
  }
  
  public a j()
  {
    a locala = new a();
    locala.a = b("key_gd_1", "");
    locala.b = b("key_gd_2", "");
    locala.c = b("key_gd_3", "");
    locala.d = b("key_gd_4", "");
    locala.e = b("key_gd_5", "");
    locala.f = i(b("key_gd_6", ""));
    locala.g = b("key_gd_7", "");
    locala.h = i(b("key_gd_8", ""));
    locala.i = b("key_gd_9", "");
    locala.j = i(b("key_gd_10", ""));
    locala.k = i(b("key_gd_11", ""));
    locala.l = j(b("key_gd_12", ""));
    locala.m = b("key_gd_13", "");
    locala.n = b("key_gd_14", "");
    locala.o = i(b("key_gd_15", ""));
    locala.p = b("key_gd_16", "");
    locala.q = ((short)i(b("key_gd_17", "")));
    locala.r = i(b("key_gd_18", ""));
    locala.s = b("key_gd_19", "");
    locala.t = b("key_gd_20", "");
    locala.u = i(b("key_gd_21", ""));
    locala.v = b("key_gd_22", "");
    locala.w = h(b("key_gd_23", ""));
    locala.x = h(b("key_gd_24", ""));
    locala.y = h(b("key_gd_25", ""));
    locala.z = b("key_gd_26", "");
    locala.A = b("key_gd_27", "");
    locala.B = b("key_gd_28", "");
    locala.P = b("key_gd_29", "");
    locala.Q = i(b("key_gd_30", ""));
    return locala;
  }
  
  public int k()
  {
    String str = b("key_itsc", "");
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    return 0;
  }
  
  public String l()
  {
    return b("key_pl", "");
  }
  
  public String m()
  {
    return b("key_mc", "");
  }
  
  public String n()
  {
    return b("key_nu", "");
  }
  
  public String o()
  {
    return b("key_tc", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.b
 * JD-Core Version:    0.7.0.1
 */