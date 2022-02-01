package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public class te
{
  private final String a = "/cn/mbtoken3/mbtoken3_update_dual_msg_status_encrypt";
  protected List<sm> b = new ArrayList();
  protected long c;
  private int d;
  
  protected te(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final sm a(int paramInt)
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
      return (sm)this.b.get(paramInt);
    }
    return null;
  }
  
  public final xh a(sm paramsm, int paramInt)
  {
    xh localxh = new xh();
    new ajn();
    th.a();
    if (paramsm == null)
    {
      localxh.a(10023, null, null);
      return localxh;
    }
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Object localObject = new AtomicReference(null);
    rf.a().a(paramsm.c, paramsm.b, paramsm.a, paramsm.d, paramInt, paramsm.c, this.d, new rf.a()
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
    catch (InterruptedException paramsm)
    {
      paramsm.printStackTrace();
    }
    paramsm = (ri)((AtomicReference)localObject).get();
    if (paramsm == null)
    {
      localxh.a(-789, null, null);
      return localxh;
    }
    try
    {
      paramInt = paramsm.b;
      if (paramInt != 0)
      {
        paramsm = paramsm.d;
        localxh.a(paramInt, paramsm, paramsm);
        return localxh;
      }
      paramsm = paramsm.c;
      if (paramsm != null)
      {
        new JSONObject(paramsm);
        th.a().g();
        localxh.a = 0;
        return localxh;
      }
      xj.c("parseJSON error decodeData");
      localxh.a(10022, RqdApplication.p().getString(2131493068), null);
      return localxh;
    }
    catch (Exception paramsm)
    {
      localObject = new StringBuilder("unknown err: ");
      ((StringBuilder)localObject).append(paramsm.toString());
      xj.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder("JSONException:");
      ((StringBuilder)localObject).append(paramsm.toString());
      localxh.a(10021, ((StringBuilder)localObject).toString(), null);
      return localxh;
    }
    catch (JSONException paramsm)
    {
      localObject = new StringBuilder("parse json failed: ");
      ((StringBuilder)localObject).append(paramsm.toString());
      xj.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder("JSONException:");
      ((StringBuilder)localObject).append(paramsm.toString());
      localxh.a(10020, ((StringBuilder)localObject).toString(), null);
    }
    return localxh;
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
 * Qualified Name:     com.tencent.token.te
 * JD-Core Version:    0.7.0.1
 */