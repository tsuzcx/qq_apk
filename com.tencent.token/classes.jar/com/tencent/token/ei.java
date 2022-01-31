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
import org.json.JSONArray;
import org.json.JSONObject;

public final class ei
  extends bm
{
  public static int c;
  public static int d;
  public static int e;
  public static int f = -1;
  public static int g = -1;
  private long h;
  private int i;
  private int j;
  private int[] k;
  
  public static void a(fs paramfs, long paramLong, int paramInt)
  {
    paramfs.c.put("param.realuin", Long.valueOf(paramLong));
    paramfs.c.put("param.scene.id", Integer.valueOf(paramInt));
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
    c = 0;
    d = 0;
    e = 0;
    Object localObject = RqdApplication.i().getResources().getDisplayMetrics();
    localObject = s.a(new Object[] { "real_uin", Long.valueOf(this.h), "scene_id", Integer.valueOf(this.i), "mobile_brand", URLEncoder.encode(Build.BRAND), "mobile_model", URLEncoder.encode(Build.MODEL), "mobile_sdk_int", Integer.valueOf(Integer.parseInt(Build.VERSION.SDK)), "mobile_sdk_str", URLEncoder.encode(Build.VERSION.RELEASE), "screen_witdh", Integer.valueOf(((DisplayMetrics)localObject).widthPixels), "screen_height", Integer.valueOf(((DisplayMetrics)localObject).heightPixels), "screen_dpi", Integer.valueOf(((DisplayMetrics)localObject).densityDpi), "cpu_count", Integer.valueOf(t.r()), "cpu_freq", Integer.valueOf(t.s()) });
    str = "?aq_base_sid=" + str + "&data=" + (String)localObject;
    return b.c() + "/cn/mbtoken3/mbtoken3_live_video_detect" + str;
  }
  
  protected final void a(fs paramfs)
  {
    this.h = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.i = ((Integer)paramfs.c.get("param.scene.id")).intValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int m = paramJSONObject.getInt("err");
    if (m != 0)
    {
      a(m, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      this.j = paramJSONObject.getInt("need_live_detect");
      if ((this.j == 1) && (paramJSONObject.getJSONArray("actions") != null) && (paramJSONObject.getJSONArray("actions").length() > 0))
      {
        int n = paramJSONObject.getJSONArray("actions").length();
        this.k = new int[n];
        m = 0;
        while (m < n)
        {
          this.k[m] = paramJSONObject.getJSONArray("actions").getInt(m);
          m += 1;
        }
        if ((this.i != 2) && (this.i != 1)) {
          break label248;
        }
        if (this.k.length >= 2)
        {
          c = this.k[0];
          d = this.k[1];
        }
      }
      try
      {
        for (;;)
        {
          f = paramJSONObject.getInt("displayangle");
          g = paramJSONObject.getInt("imageangle");
          e.a("plain angle=" + f + ",angel2=" + g);
          this.a.a = 0;
          return;
          label248:
          if (this.k.length > 0) {
            e = this.k[0];
          }
        }
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
      localMessage.arg2 = this.j;
      localMessage.obj = this.k;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ei
 * JD-Core Version:    0.7.0.1
 */