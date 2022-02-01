package com.tencent.token;

import android.text.TextUtils;
import btmsdkobf.bw;
import com.tencent.token.global.RqdApplication;

public final class xf
{
  public static boolean a;
  
  public static void a()
  {
    if (a) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject = bw.ah().aj();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    a = true;
    StringBuilder localStringBuilder = new StringBuilder("init : ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("  time=");
    localStringBuilder.append(System.currentTimeMillis() - l);
    localObject = aem.a(RqdApplication.n(), (String)localObject);
    ((aem.a)localObject).v = 105678;
    ((aem.a)localObject).w = true;
    ((aem.a)localObject).r = new acw()
    {
      public final boolean a()
      {
        return rp.a().b();
      }
      
      public final boolean b()
      {
        return rp.a().b();
      }
      
      public final boolean c()
      {
        return rp.a().b();
      }
    };
    afm.a(((aem.a)localObject).a());
  }
  
  public static String b()
  {
    
    if (!a) {
      return "";
    }
    long l = System.currentTimeMillis();
    Object localObject2 = aen.a(afm.a(RqdApplication.n()));
    Object localObject1 = "";
    if (((aen.a)localObject2).b() == 0)
    {
      localObject2 = ((aen.a)localObject2).a();
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
 * Qualified Name:     com.tencent.token.xf
 * JD-Core Version:    0.7.0.1
 */