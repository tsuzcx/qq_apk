package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public class sw
{
  private final String a = "/cn/mbtoken3/mbtoken3_update_dual_msg_status_encrypt";
  protected List<se> b = new ArrayList();
  protected long c;
  private int d;
  
  protected sw(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final se a(int paramInt)
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
      return (se)this.b.get(paramInt);
    }
    return null;
  }
  
  public final wy a(se paramse, int paramInt)
  {
    wy localwy = new wy();
    new ahq();
    sz.a();
    if (paramse == null)
    {
      localwy.a(10023, null, null);
      return localwy;
    }
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Object localObject = new AtomicReference(null);
    qy.a().a(paramse.c, paramse.b, paramse.a, paramse.d, paramInt, paramse.c, this.d, new qy.a()
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
    catch (InterruptedException paramse)
    {
      paramse.printStackTrace();
    }
    paramse = (ra)((AtomicReference)localObject).get();
    if (paramse == null)
    {
      localwy.a(-789, null, null);
      return localwy;
    }
    try
    {
      paramInt = paramse.b;
      if (paramInt != 0)
      {
        paramse = paramse.d;
        localwy.a(paramInt, paramse, paramse);
        return localwy;
      }
      paramse = paramse.c;
      if (paramse != null)
      {
        new JSONObject(paramse);
        sz.a().g();
        localwy.a = 0;
        return localwy;
      }
      xa.c("parseJSON error decodeData");
      localwy.a(10022, RqdApplication.n().getString(2131493068), null);
      return localwy;
    }
    catch (Exception paramse)
    {
      localObject = new StringBuilder("unknown err: ");
      ((StringBuilder)localObject).append(paramse.toString());
      xa.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder("JSONException:");
      ((StringBuilder)localObject).append(paramse.toString());
      localwy.a(10021, ((StringBuilder)localObject).toString(), null);
      return localwy;
    }
    catch (JSONException paramse)
    {
      localObject = new StringBuilder("parse json failed: ");
      ((StringBuilder)localObject).append(paramse.toString());
      xa.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder("JSONException:");
      ((StringBuilder)localObject).append(paramse.toString());
      localwy.a(10020, ((StringBuilder)localObject).toString(), null);
    }
    return localwy;
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
 * Qualified Name:     com.tencent.token.sw
 * JD-Core Version:    0.7.0.1
 */