package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class tp
  extends tq
{
  static tp a;
  private final String d = "/cn/mbtoken3/mbtoken3_scan_qrcode_v2";
  private String e;
  private int f;
  
  private tp()
  {
    super(2);
  }
  
  public static tp a()
  {
    if (a == null) {
      a = new tp();
    }
    return a;
  }
  
  public final xt a(String paramString)
  {
    this.b.clear();
    this.e = "";
    this.f = 0;
    xt localxt = new xt();
    Object localObject = tt.a();
    if ((localObject != null) && (((tt)localObject).k.b() != null))
    {
      long l = ((tt)localObject).k.d();
      if (l == 0L)
      {
        localxt.a(10029, null, null);
        return localxt;
      }
      if (((tt)localObject).k.b().mIsBinded) {
        l = ((tt)localObject).k.b().mUin;
      }
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localObject = new AtomicReference(null);
      rt.a().e(l, paramString, new rt.a()
      {
        public final void a(rv paramAnonymousrv)
        {
          this.a.set(paramAnonymousrv);
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
      localObject = (rv)((AtomicReference)localObject).get();
      if (localObject == null)
      {
        localxt.a(-356, null, null);
        localObject = new StringBuilder("client request url: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" failed, reason: ");
        ((StringBuilder)localObject).append(localxt.a);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(localxt.b);
        xv.c(((StringBuilder)localObject).toString());
        return localxt;
      }
      try
      {
        int i = ((rv)localObject).b;
        if (i != 0)
        {
          paramString = ((rv)localObject).d;
          localxt.a(i, paramString, paramString);
          return localxt;
        }
        localObject = ((rv)localObject).c;
        if (localObject != null)
        {
          localObject = new JSONObject((String)localObject);
          this.f = ((JSONObject)localObject).getInt("type");
          if (1 == this.f)
          {
            paramString = ((JSONObject)localObject).getJSONObject("msg");
            localObject = new sy();
            if (!((sy)localObject).a(paramString)) {
              xv.c("object item parse failed ");
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
          tt.a().g();
          localxt.a = 0;
          return localxt;
        }
        xv.c("parseJSON error decodeData");
        localxt.a(10022, RqdApplication.n().getString(2131493069), null);
        return localxt;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        localObject = new StringBuilder("unknown err: ");
        ((StringBuilder)localObject).append(paramString.toString());
        xv.c(((StringBuilder)localObject).toString());
        localObject = new StringBuilder("JSONException:");
        ((StringBuilder)localObject).append(paramString.toString());
        localxt.a(10021, ((StringBuilder)localObject).toString(), null);
        return localxt;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        localObject = new StringBuilder("parse json failed: ");
        ((StringBuilder)localObject).append(paramString.toString());
        xv.c(((StringBuilder)localObject).toString());
        localObject = new StringBuilder("JSONException:");
        ((StringBuilder)localObject).append(paramString.toString());
        localxt.a(10020, ((StringBuilder)localObject).toString(), null);
        return localxt;
      }
    }
    localxt.a(110, null, null);
    return localxt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tp
 * JD-Core Version:    0.7.0.1
 */