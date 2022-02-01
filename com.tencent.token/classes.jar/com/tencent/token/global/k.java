package com.tencent.token.global;

import android.text.TextUtils;
import android.util.Log;
import btmsdkobf.bw;
import com.tencent.service.update.e;
import com.tencent.turingfd.sdk.base.aj;
import com.tencent.turingfd.sdk.base.bz;
import com.tencent.turingfd.sdk.base.bz.a;
import com.tencent.turingfd.sdk.base.ca;
import com.tencent.turingfd.sdk.base.ca.a;

public class k
{
  private static boolean a;
  
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init : ");
    localStringBuilder.append(str);
    localStringBuilder.append("  time=");
    localStringBuilder.append(System.currentTimeMillis() - l);
    Log.i("TuringHelper", localStringBuilder.toString());
    ca.a(bz.a(RqdApplication.n(), str).a(105678).a(true).a(new aj()
    {
      public boolean a()
      {
        return e.a().b();
      }
      
      public boolean b()
      {
        return e.a().b();
      }
      
      public boolean c()
      {
        return e.a().b();
      }
    }).a());
  }
  
  public static String b()
  {
    
    if (!a) {
      return "";
    }
    long l = System.currentTimeMillis();
    Object localObject2 = ca.a(RqdApplication.n());
    Object localObject1 = "";
    if (((ca.a)localObject2).b() == 0)
    {
      localObject2 = ((ca.a)localObject2).c();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "";
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getOAID : ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("  time=");
    ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
    Log.i("TuringHelper", ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  public static boolean c()
  {
    return a;
  }
  
  public static String d()
  {
    
    if (!a) {
      return "";
    }
    long l = System.currentTimeMillis();
    Object localObject2 = ca.a(RqdApplication.n());
    Object localObject1 = "";
    if (((ca.a)localObject2).b() == 0)
    {
      localObject2 = ((ca.a)localObject2).a();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "";
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getOpenIdTicket : ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("  time=");
    ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
    Log.i("TuringHelper", ((StringBuilder)localObject2).toString());
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.k
 * JD-Core Version:    0.7.0.1
 */