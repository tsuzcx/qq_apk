package com.tencent.token.global;

import android.text.TextUtils;
import android.util.Log;
import btmsdkobf.bw;
import com.tencent.turingfd.sdk.base.dc;
import com.tencent.turingfd.sdk.base.dd;
import com.tencent.turingfd.sdk.base.de;
import com.tencent.turingfd.sdk.base.df;

public class n
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
      str = "";
    }
    for (;;)
    {
      Log.i("TuringHelper", "init : " + str + "  time=" + (System.currentTimeMillis() - l));
      de.a(dc.a(RqdApplication.l(), str).a());
      return;
      a = true;
    }
  }
  
  public static String b()
  {
    if (!a) {
      return "";
    }
    long l = System.currentTimeMillis();
    Object localObject2 = de.a(RqdApplication.l());
    Object localObject1 = "";
    if (((df)localObject2).b() == 0)
    {
      localObject2 = ((df)localObject2).c();
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
    Object localObject2 = de.a(RqdApplication.l());
    Object localObject1 = "";
    if (((df)localObject2).b() == 0)
    {
      localObject2 = ((df)localObject2).a();
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
 * Qualified Name:     com.tencent.token.global.n
 * JD-Core Version:    0.7.0.1
 */