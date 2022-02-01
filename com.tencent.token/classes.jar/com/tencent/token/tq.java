package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public class tq
{
  private final String a = "/cn/mbtoken3/mbtoken3_update_dual_msg_status_encrypt";
  protected List<sy> b = new ArrayList();
  protected long c;
  private int d;
  
  protected tq(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final sy a(int paramInt)
  {
    if (this.b == null) {
      return null;
    }
    int i = b();
    if (paramInt >= 0)
    {
      if (paramInt >= i) {
        return null;
      }
      return (sy)this.b.get(paramInt);
    }
    return null;
  }
  
  public final xt a(sy paramsy, int paramInt)
  {
    xt localxt = new xt();
    new akl();
    tt.a();
    if (paramsy == null)
    {
      localxt.a(10023, null, null);
      return localxt;
    }
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Object localObject = new AtomicReference(null);
    rt.a().a(paramsy.c, paramsy.b, paramsy.a, paramsy.d, paramInt, paramsy.c, this.d, new rt.a()
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
    catch (InterruptedException paramsy)
    {
      paramsy.printStackTrace();
    }
    paramsy = (rv)((AtomicReference)localObject).get();
    if (paramsy == null)
    {
      localxt.a(-789, null, null);
      return localxt;
    }
    try
    {
      paramInt = paramsy.b;
      if (paramInt != 0)
      {
        paramsy = paramsy.d;
        localxt.a(paramInt, paramsy, paramsy);
        return localxt;
      }
      paramsy = paramsy.c;
      if (paramsy != null)
      {
        new JSONObject(paramsy);
        tt.a().g();
        localxt.a = 0;
        return localxt;
      }
      xv.c("parseJSON error decodeData");
      localxt.a(10022, RqdApplication.n().getString(2131493069), null);
      return localxt;
    }
    catch (Exception paramsy)
    {
      localObject = new StringBuilder("unknown err: ");
      ((StringBuilder)localObject).append(paramsy.toString());
      xv.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder("JSONException:");
      ((StringBuilder)localObject).append(paramsy.toString());
      localxt.a(10021, ((StringBuilder)localObject).toString(), null);
      return localxt;
    }
    catch (JSONException paramsy)
    {
      localObject = new StringBuilder("parse json failed: ");
      ((StringBuilder)localObject).append(paramsy.toString());
      xv.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder("JSONException:");
      ((StringBuilder)localObject).append(paramsy.toString());
      localxt.a(10020, ((StringBuilder)localObject).toString(), null);
    }
    return localxt;
  }
  
  public final int b()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tq
 * JD-Core Version:    0.7.0.1
 */