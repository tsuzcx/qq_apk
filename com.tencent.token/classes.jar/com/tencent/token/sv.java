package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class sv
  extends sw
{
  static sv a;
  private final String d = "/cn/mbtoken3/mbtoken3_scan_qrcode_v2";
  private String e;
  private int f;
  
  private sv()
  {
    super(2);
  }
  
  public static sv a()
  {
    if (a == null) {
      a = new sv();
    }
    return a;
  }
  
  public final wy a(String paramString)
  {
    this.b.clear();
    this.e = "";
    this.f = 0;
    wy localwy = new wy();
    Object localObject = sz.a();
    if ((localObject != null) && (((sz)localObject).k.b() != null))
    {
      long l = ((sz)localObject).k.d();
      if (l == 0L)
      {
        localwy.a(10029, null, null);
        return localwy;
      }
      if (((sz)localObject).k.b().mIsBinded) {
        l = ((sz)localObject).k.b().mUin;
      }
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localObject = new AtomicReference(null);
      qy.a().e(l, paramString, new qy.a()
      {
        public final void a(ra paramAnonymousra)
        {
          this.a.set(paramAnonymousra);
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
      localObject = (ra)((AtomicReference)localObject).get();
      if (localObject == null)
      {
        localwy.a(-356, null, null);
        localObject = new StringBuilder("client request url: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" failed, reason: ");
        ((StringBuilder)localObject).append(localwy.a);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(localwy.b);
        xa.c(((StringBuilder)localObject).toString());
        return localwy;
      }
      try
      {
        int i = ((ra)localObject).b;
        if (i != 0)
        {
          paramString = ((ra)localObject).d;
          localwy.a(i, paramString, paramString);
          return localwy;
        }
        localObject = ((ra)localObject).c;
        if (localObject != null)
        {
          localObject = new JSONObject((String)localObject);
          this.f = ((JSONObject)localObject).getInt("type");
          if (1 == this.f)
          {
            paramString = ((JSONObject)localObject).getJSONObject("msg");
            localObject = new se();
            if (!((se)localObject).a(paramString)) {
              xa.c("object item parse failed ");
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
          sz.a().g();
          localwy.a = 0;
          return localwy;
        }
        xa.c("parseJSON error decodeData");
        localwy.a(10022, RqdApplication.n().getString(2131493068), null);
        return localwy;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        localObject = new StringBuilder("unknown err: ");
        ((StringBuilder)localObject).append(paramString.toString());
        xa.c(((StringBuilder)localObject).toString());
        localObject = new StringBuilder("JSONException:");
        ((StringBuilder)localObject).append(paramString.toString());
        localwy.a(10021, ((StringBuilder)localObject).toString(), null);
        return localwy;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        localObject = new StringBuilder("parse json failed: ");
        ((StringBuilder)localObject).append(paramString.toString());
        xa.c(((StringBuilder)localObject).toString());
        localObject = new StringBuilder("JSONException:");
        ((StringBuilder)localObject).append(paramString.toString());
        localwy.a(10020, ((StringBuilder)localObject).toString(), null);
        return localwy;
      }
    }
    localwy.a(110, null, null);
    return localwy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sv
 * JD-Core Version:    0.7.0.1
 */