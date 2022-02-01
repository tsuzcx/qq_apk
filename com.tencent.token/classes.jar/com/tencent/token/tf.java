package com.tencent.token;

import android.os.Handler;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.utils.UserTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class tf
  extends rs
{
  static tf f;
  int a;
  public String b;
  public String c;
  public String d;
  public String e;
  private final String g = "/cn/mbtoken3/mbtoken3_query_for_2nd_verify_v2";
  private final String h = "/cn/mbtoken3/mbtoken3_perform_2nd_verify_encrypt";
  private int i;
  
  public static tf a()
  {
    if (f == null) {
      f = new tf();
    }
    return f;
  }
  
  public final wz a(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final wz a(String paramString, int paramInt)
  {
    wz localwz = new wz();
    ta localta = ta.a();
    if ((localta != null) && (localta.k.b() != null))
    {
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      Object localObject = new AtomicReference(null);
      qz.a().a(localta.k.b().mUin, this.i, paramInt, paramString, new qz.a()
      {
        public final void a(rb paramAnonymousrb)
        {
          this.a.set(paramAnonymousrb);
          localCountDownLatch.countDown();
        }
      });
      try
      {
        localCountDownLatch.await();
      }
      catch (InterruptedException paramString)
      {
        paramString.printStackTrace();
      }
      paramString = (rb)((AtomicReference)localObject).get();
      if (paramString == null)
      {
        localwz.a(-349, null, null);
        return localwz;
      }
      try
      {
        paramInt = paramString.b;
        if (paramInt != 0)
        {
          paramString = paramString.d;
          localwz.a(paramInt, paramString, paramString);
          return localwz;
        }
        new JSONObject(paramString.c);
        localwz.a = 0;
        return localwz;
      }
      catch (Exception paramString)
      {
        localObject = new StringBuilder("unknown err: ");
        ((StringBuilder)localObject).append(paramString.toString());
        xb.c(((StringBuilder)localObject).toString());
        localObject = new StringBuilder("JSONException:");
        ((StringBuilder)localObject).append(paramString.toString());
        localwz.a(10021, ((StringBuilder)localObject).toString(), null);
        return localwz;
      }
      catch (JSONException paramString)
      {
        localObject = new StringBuilder("parse json failed: ");
        ((StringBuilder)localObject).append(paramString.toString());
        xb.c(((StringBuilder)localObject).toString());
        localObject = new StringBuilder("JSONException:");
        ((StringBuilder)localObject).append(paramString.toString());
        localwz.a(10020, ((StringBuilder)localObject).toString(), null);
        return localwz;
      }
    }
    localwz.a(110, null, null);
    return localwz;
  }
  
  public final void a(final int paramInt, final Handler paramHandler)
  {
    if (paramHandler == null) {
      return;
    }
    new UserTask() {}.a(new String[] { "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tf
 * JD-Core Version:    0.7.0.1
 */