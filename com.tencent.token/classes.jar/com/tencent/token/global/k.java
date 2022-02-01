package com.tencent.token.global;

import android.text.TextUtils;
import android.util.Log;
import btmsdkobf.bw;
import com.tencent.turingfd.sdk.base.bz;
import com.tencent.turingfd.sdk.base.bz.a;
import com.tencent.turingfd.sdk.base.ca;
import com.tencent.turingfd.sdk.base.ca.a;

public class k
{
  private static boolean a;
  
  public static void a()
  {
    if (a) {}
    long l;
    String str;
    do
    {
      return;
      l = System.currentTimeMillis();
      str = bw.ah().aj();
    } while (TextUtils.isEmpty(str));
    a = true;
    Log.i("TuringHelper", "init : " + str + "  time=" + (System.currentTimeMillis() - l));
    ca.a(bz.a(RqdApplication.l(), str).a(105678).a(true).a());
  }
  
  public static String b()
  {
    
    if (!a) {
      return "";
    }
    long l = System.currentTimeMillis();
    Object localObject2 = ca.a(RqdApplication.l());
    Object localObject1 = "";
    if (((ca.a)localObject2).b() == 0)
    {
      localObject2 = ((ca.a)localObject2).c();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "";
      }
    }
    Log.i("TuringHelper", "getOAID : " + (String)localObject1 + "  time=" + (System.currentTimeMillis() - l));
    return localObject1;
  }
  
  public static String c()
  {
    
    if (!a) {
      return "";
    }
    long l = System.currentTimeMillis();
    Object localObject2 = ca.a(RqdApplication.l());
    Object localObject1 = "";
    if (((ca.a)localObject2).b() == 0)
    {
      localObject2 = ((ca.a)localObject2).a();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "";
      }
    }
    Log.i("TuringHelper", "getOpenIdTicket : " + (String)localObject1 + "  time=" + (System.currentTimeMillis() - l));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.k
 * JD-Core Version:    0.7.0.1
 */