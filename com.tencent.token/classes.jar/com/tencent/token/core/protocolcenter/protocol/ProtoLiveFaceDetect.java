package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.token.ca;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.ui.h;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProtoLiveFaceDetect
  extends d
{
  public static int d;
  public static int e;
  public static int f;
  private long g;
  private int h;
  private int i;
  private int[] j;
  
  public static void a(do paramdo, long paramLong, int paramInt)
  {
    paramdo.c.put("param.realuin", Long.valueOf(paramLong));
    paramdo.c.put("param.scene.id", Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    String str = ca.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    d = 0;
    e = 0;
    f = 0;
    Object localObject = RqdApplication.l().getResources().getDisplayMetrics();
    localObject = l.a(new Object[] { "real_uin", Long.valueOf(this.g), "scene_id", Integer.valueOf(this.h), "mobile_brand", URLEncoder.encode(Build.BRAND), "mobile_model", URLEncoder.encode(Build.MODEL), "mobile_sdk_int", Integer.valueOf(Integer.parseInt(Build.VERSION.SDK)), "mobile_sdk_str", URLEncoder.encode(Build.VERSION.RELEASE), "screen_witdh", Integer.valueOf(((DisplayMetrics)localObject).widthPixels), "screen_height", Integer.valueOf(((DisplayMetrics)localObject).heightPixels), "screen_dpi", Integer.valueOf(((DisplayMetrics)localObject).densityDpi), "cpu_count", Integer.valueOf(m.y()), "cpu_freq", Integer.valueOf(m.z()) });
    str = "?aq_base_sid=" + str + "&data=" + (String)localObject;
    return c.e() + "/cn/mbtoken3/mbtoken3_live_video_detect" + str;
  }
  
  protected void a(do paramdo)
  {
    this.g = ((Long)paramdo.c.get("param.realuin")).longValue();
    this.h = ((Integer)paramdo.c.get("param.scene.id")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int k = paramJSONObject.getInt("err");
    if (k != 0)
    {
      a(k, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      this.i = paramJSONObject.getInt("need_live_detect");
      if ((this.i == 1) && (paramJSONObject.getJSONArray("actions") != null) && (paramJSONObject.getJSONArray("actions").length() > 0))
      {
        int m = paramJSONObject.getJSONArray("actions").length();
        this.j = new int[m];
        k = 0;
        while (k < m)
        {
          this.j[k] = paramJSONObject.getJSONArray("actions").getInt(k);
          g.a("mLiveDetectActions" + this.j[k]);
          k += 1;
        }
        if ((this.h != 2) && (this.h != 1)) {
          break label278;
        }
        if (this.j.length >= 2)
        {
          d = this.j[0];
          e = this.j[1];
        }
      }
      try
      {
        for (;;)
        {
          h.k = paramJSONObject.getInt("displayangle");
          h.l = paramJSONObject.getInt("imageangle");
          g.a("display angle=" + h.k + ",angel2=" + h.l);
          m.a(paramJSONObject);
          this.a.c();
          return;
          label278:
          if (this.j.length >= 1)
          {
            f = this.j[0];
            g.a("sVryAction" + f);
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
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoLiveFaceDetect
 * JD-Core Version:    0.7.0.1
 */