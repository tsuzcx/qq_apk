package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class td
  extends te
{
  static td a;
  private final String d = "/cn/mbtoken3/mbtoken3_scan_qrcode_v2";
  private String e;
  private int f;
  
  private td()
  {
    super(2);
  }
  
  public static td a()
  {
    if (a == null) {
      a = new td();
    }
    return a;
  }
  
  public final xh a(String paramString)
  {
    this.b.clear();
    this.e = "";
    this.f = 0;
    xh localxh = new xh();
    Object localObject = th.a();
    if ((localObject != null) && (((th)localObject).k.b() != null))
    {
      long l = ((th)localObject).k.d();
      if (l == 0L)
      {
        localxh.a(10029, null, null);
        return localxh;
      }
      if (((th)localObject).k.b().mIsBinded) {
        l = ((th)localObject).k.b().mUin;
      }
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localObject = new AtomicReference(null);
      rf.a().e(l, paramString, new rf.a()
      {
        public final void a(ri paramAnonymousri)
        {
          this.a.set(paramAnonymousri);
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
      localObject = (ri)((AtomicReference)localObject).get();
      if (localObject == null)
      {
        localxh.a(-356, null, null);
        localObject = new StringBuilder("client request url: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" failed, reason: ");
        ((StringBuilder)localObject).append(localxh.a);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(localxh.b);
        xj.c(((StringBuilder)localObject).toString());
        return localxh;
      }
      try
      {
        int i = ((ri)localObject).b;
        if (i != 0)
        {
          paramString = ((ri)localObject).d;
          localxh.a(i, paramString, paramString);
          return localxh;
        }
        localObject = ((ri)localObject).c;
        if (localObject != null)
        {
          localObject = new JSONObject((String)localObject);
          this.f = ((JSONObject)localObject).getInt("type");
          if (1 == this.f)
          {
            paramString = ((JSONObject)localObject).getJSONObject("msg");
            localObject = new sm();
            if (!((sm)localObject).a(paramString)) {
              xj.c("object item parse failed ");
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
          th.a().g();
          localxh.a = 0;
          return localxh;
        }
        xj.c("parseJSON error decodeData");
        localxh.a(10022, RqdApplication.p().getString(2131493068), null);
        return localxh;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        localObject = new StringBuilder("unknown err: ");
        ((StringBuilder)localObject).append(paramString.toString());
        xj.c(((StringBuilder)localObject).toString());
        localObject = new StringBuilder("JSONException:");
        ((StringBuilder)localObject).append(paramString.toString());
        localxh.a(10021, ((StringBuilder)localObject).toString(), null);
        return localxh;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        localObject = new StringBuilder("parse json failed: ");
        ((StringBuilder)localObject).append(paramString.toString());
        xj.c(((StringBuilder)localObject).toString());
        localObject = new StringBuilder("JSONException:");
        ((StringBuilder)localObject).append(paramString.toString());
        localxh.a(10020, ((StringBuilder)localObject).toString(), null);
        return localxh;
      }
    }
    localxh.a(110, null, null);
    return localxh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.td
 * JD-Core Version:    0.7.0.1
 */