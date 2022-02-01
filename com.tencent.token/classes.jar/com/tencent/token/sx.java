package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public class sx
{
  private final String a = "/cn/mbtoken3/mbtoken3_update_dual_msg_status_encrypt";
  protected List<sf> b = new ArrayList();
  protected long c;
  private int d;
  
  protected sx(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final sf a(int paramInt)
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
      return (sf)this.b.get(paramInt);
    }
    return null;
  }
  
  public final wz a(sf paramsf, int paramInt)
  {
    wz localwz = new wz();
    new ahr();
    ta.a();
    if (paramsf == null)
    {
      localwz.a(10023, null, null);
      return localwz;
    }
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Object localObject = new AtomicReference(null);
    qz.a().a(paramsf.c, paramsf.b, paramsf.a, paramsf.d, paramInt, paramsf.c, this.d, new qz.a()
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
    catch (InterruptedException paramsf)
    {
      paramsf.printStackTrace();
    }
    paramsf = (rb)((AtomicReference)localObject).get();
    if (paramsf == null)
    {
      localwz.a(-789, null, null);
      return localwz;
    }
    try
    {
      paramInt = paramsf.b;
      if (paramInt != 0)
      {
        paramsf = paramsf.d;
        localwz.a(paramInt, paramsf, paramsf);
        return localwz;
      }
      paramsf = paramsf.c;
      if (paramsf != null)
      {
        new JSONObject(paramsf);
        ta.a().g();
        localwz.a = 0;
        return localwz;
      }
      xb.c("parseJSON error decodeData");
      localwz.a(10022, RqdApplication.n().getString(2131493068), null);
      return localwz;
    }
    catch (Exception paramsf)
    {
      localObject = new StringBuilder("unknown err: ");
      ((StringBuilder)localObject).append(paramsf.toString());
      xb.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder("JSONException:");
      ((StringBuilder)localObject).append(paramsf.toString());
      localwz.a(10021, ((StringBuilder)localObject).toString(), null);
      return localwz;
    }
    catch (JSONException paramsf)
    {
      localObject = new StringBuilder("parse json failed: ");
      ((StringBuilder)localObject).append(paramsf.toString());
      xb.c(((StringBuilder)localObject).toString());
      localObject = new StringBuilder("JSONException:");
      ((StringBuilder)localObject).append(paramsf.toString());
      localwz.a(10020, ((StringBuilder)localObject).toString(), null);
    }
    return localwz;
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
 * Qualified Name:     com.tencent.token.sx
 * JD-Core Version:    0.7.0.1
 */