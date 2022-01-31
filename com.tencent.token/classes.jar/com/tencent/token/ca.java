package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class ca
  extends bm
{
  public static int c = -1;
  public static int d = -1;
  private long e;
  private int f;
  
  public static void a(fs paramfs, long paramLong)
  {
    paramfs.c.put("param.realuin", Long.valueOf(paramLong));
  }
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c; str == null; str = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    Object localObject = RqdApplication.i().getResources().getDisplayMetrics();
    localObject = s.a(new Object[] { "real_uin", Long.valueOf(this.e), "scene_id", Integer.valueOf(1), "mobile_brand", URLEncoder.encode(Build.BRAND), "mobile_model", URLEncoder.encode(Build.MODEL), "mobile_sdk_int", Integer.valueOf(Integer.parseInt(Build.VERSION.SDK)), "mobile_sdk_str", URLEncoder.encode(Build.VERSION.RELEASE), "screen_witdh", Integer.valueOf(((DisplayMetrics)localObject).widthPixels), "screen_height", Integer.valueOf(((DisplayMetrics)localObject).heightPixels), "screen_dpi", Integer.valueOf(((DisplayMetrics)localObject).densityDpi), "cpu_count", Integer.valueOf(t.r()), "cpu_freq", Integer.valueOf(t.s()) });
    str = "?aq_base_sid=" + str + "&data=" + (String)localObject;
    return b.c() + "/cn/mbtoken3/mbtoken3_idcard_auto_detect" + str;
  }
  
  protected final void a(fs paramfs)
  {
    this.e = ((Long)paramfs.c.get("param.realuin")).longValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      this.f = paramJSONObject.getInt("need_idcard_detect");
      if (this.f == 1) {}
      try
      {
        c = paramJSONObject.getInt("displayangle");
        d = paramJSONObject.getInt("imageangle");
        e.a("plain angle=" + c + ",angel2=" + d);
        this.a.a = 0;
        return;
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
    e.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.arg2 = this.f;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ca
 * JD-Core Version:    0.7.0.1
 */