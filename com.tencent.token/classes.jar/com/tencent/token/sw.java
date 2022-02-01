package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class sw
  extends sx
{
  static sw a;
  private final String d = "/cn/mbtoken3/mbtoken3_scan_qrcode_v2";
  private String e;
  private int f;
  
  private sw()
  {
    super(2);
  }
  
  public static sw a()
  {
    if (a == null) {
      a = new sw();
    }
    return a;
  }
  
  public final wz a(String paramString)
  {
    this.b.clear();
    this.e = "";
    this.f = 0;
    wz localwz = new wz();
    Object localObject = ta.a();
    if ((localObject != null) && (((ta)localObject).k.b() != null))
    {
      long l = ((ta)localObject).k.d();
      if (l == 0L)
      {
        localwz.a(10029, null, null);
        return localwz;
      }
      if (((ta)localObject).k.b().mIsBinded) {
        l = ((ta)localObject).k.b().mUin;
      }
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localObject = new AtomicReference(null);
      qz.a().e(l, paramString, new qz.a()
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
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      localObject = (rb)((AtomicReference)localObject).get();
      if (localObject == null)
      {
        localwz.a(-356, null, null);
        localObject = new StringBuilder("client request url: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" failed, reason: ");
        ((StringBuilder)localObject).append(localwz.a);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(localwz.b);
        xb.c(((StringBuilder)localObject).toString());
        return localwz;
      }
      try
      {
        int i = ((rb)localObject).b;
        if (i != 0)
        {
          paramString = ((rb)localObject).d;
          localwz.a(i, paramString, paramString);
          return localwz;
        }
        localObject = ((rb)localObject).c;
        if (localObject != null)
        {
          localObject = new JSONObject((String)localObject);
          this.f = ((JSONObject)localObject).getInt("type");
          if (1 == this.f)
          {
            paramString = ((JSONObject)localObject).getJSONObject("msg");
            localObject = new sf();
            if (!((sf)localObject).a(paramString)) {
              xb.c("object item parse failed ");
            } else {
              this.b.add(localObject);
            }
          }
          else if (2 == this.f)
          {
            this.e = ((JSONObject)localObject).getString("text");
          }
          else
          {
            this.e = paramString;
          }
          ta.a().g();
          localwz.a = 0;
          return localwz;
        }
        xb.c("parseJSON error decodeData");
        localwz.a(10022, RqdApplication.n().getString(2131493068), null);
        return localwz;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
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
        paramString.printStackTrace();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sw
 * JD-Core Version:    0.7.0.1
 */