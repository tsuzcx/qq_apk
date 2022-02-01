package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class wa
  extends tr
{
  public static int d;
  public static int e;
  public static int f;
  private long g;
  private int h;
  private int i;
  private int[] j;
  
  public final String a()
  {
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc)
  {
    this.g = ((Long)paramabc.c.get("param.realuin")).longValue();
    this.h = ((Integer)paramabc.c.get("param.scene.id")).intValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int k = paramJSONObject.getInt("err");
    if (k != 0)
    {
      a(k, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aao.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      this.i = paramJSONObject.getInt("need_live_detect");
      Object localObject;
      if ((this.i == 1) && (paramJSONObject.getJSONArray("actions") != null) && (paramJSONObject.getJSONArray("actions").length() > 0))
      {
        int m = paramJSONObject.getJSONArray("actions").length();
        this.j = new int[m];
        k = 0;
        while (k < m)
        {
          this.j[k] = paramJSONObject.getJSONArray("actions").getInt(k);
          localObject = new StringBuilder("mLiveDetectActions");
          ((StringBuilder)localObject).append(this.j[k]);
          xj.a(((StringBuilder)localObject).toString());
          k += 1;
        }
        k = this.h;
        if ((k != 2) && (k != 1))
        {
          localObject = this.j;
          if (localObject.length > 0)
          {
            f = localObject[0];
            localObject = new StringBuilder("sVryAction");
            ((StringBuilder)localObject).append(f);
            xj.a(((StringBuilder)localObject).toString());
          }
        }
        else
        {
          localObject = this.j;
          if (localObject.length >= 2)
          {
            d = localObject[0];
            e = localObject[1];
          }
        }
      }
      try
      {
        yj.n = paramJSONObject.getInt("displayangle");
        yj.o = paramJSONObject.getInt("imageangle");
        localObject = new StringBuilder("display angle=");
        ((StringBuilder)localObject).append(yj.n);
        ((StringBuilder)localObject).append(",angel2=");
        ((StringBuilder)localObject).append(yj.o);
        xj.a(((StringBuilder)localObject).toString());
        aap.a(paramJSONObject);
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      this.a.a = 0;
      return;
    }
    xj.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.p().getString(2131493068));
  }
  
  public final void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.arg2 = this.i;
      localMessage.obj = this.j;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wa
 * JD-Core Version:    0.7.0.1
 */