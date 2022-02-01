package com.tencent.token;

import android.text.TextUtils;
import btmsdkobf.bw;
import com.tencent.token.global.RqdApplication;

public final class xe
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
    localObject = ael.a(RqdApplication.n(), (String)localObject);
    ((ael.a)localObject).v = 105678;
    ((ael.a)localObject).w = true;
    ((ael.a)localObject).r = new acv()
    {
      public final boolean a()
      {
        return ro.a().b();
      }
      
      public final boolean b()
      {
        return ro.a().b();
      }
      
      public final boolean c()
      {
        return ro.a().b();
      }
    };
    afl.a(((ael.a)localObject).a());
  }
  
  public static String b()
  {
    
    if (!a) {
      return "";
    }
    long l = System.currentTimeMillis();
    Object localObject2 = aem.a(afl.a(RqdApplication.n()));
    Object localObject1 = "";
    if (((aem.a)localObject2).b() == 0)
    {
      localObject2 = ((aem.a)localObject2).a();
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
 * Qualified Name:     com.tencent.token.xe
 * JD-Core Version:    0.7.0.1
 */