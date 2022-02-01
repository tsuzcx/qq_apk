package com.tencent.token;

import android.text.TextUtils;
import btmsdkobf.bw;
import com.tencent.token.global.RqdApplication;

public final class yc
{
  public static boolean a;
  
  public static void a()
  {
    if (a) {
      return;
    }
    long l = System.currentTimeMillis();
    String str = bw.ah().aj();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    a = true;
    Object localObject = new StringBuilder("init : ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("  time=");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    localObject = ago.a(RqdApplication.n(), new aen()
    {
      public final boolean a()
      {
        return sj.a().b();
      }
    });
    ((ago.a)localObject).u = new aem()
    {
      public final String a()
      {
        RqdApplication.n();
        return xw.b();
      }
      
      public final String b()
      {
        return xw.a(RqdApplication.n());
      }
      
      public final String c()
      {
        return xw.b(RqdApplication.n());
      }
      
      public final String d()
      {
        return xw.a();
      }
    };
    ((ago.a)localObject).i = 105678;
    ((ago.a)localObject).b = str;
    ((ago.a)localObject).f = "6.9.23";
    ((ago.a)localObject).h = "C1D4CD9B6187E99C";
    ((ago.a)localObject).g = xr.d();
    ((ago.a)localObject).j = false;
    ((ago.a)localObject).a().a();
  }
  
  public static String b()
  {
    
    if (!a) {
      return "";
    }
    long l = System.currentTimeMillis();
    Object localObject2 = agn.a(RqdApplication.n());
    Object localObject1 = "";
    if (((ael)localObject2).a() == 0)
    {
      localObject2 = ((ael)localObject2).b();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "";
      }
    }
    localObject2 = new StringBuilder("getOpenIdTicket : ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("  time=");
    ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.yc
 * JD-Core Version:    0.7.0.1
 */