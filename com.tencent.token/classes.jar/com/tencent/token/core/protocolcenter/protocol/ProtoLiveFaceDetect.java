package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.token.cb;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
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
  
  public static void a(dp paramdp, long paramLong, int paramInt)
  {
    paramdp.c.put("param.realuin", Long.valueOf(paramLong));
    paramdp.c.put("param.scene.id", Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    String str = cb.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    d = 0;
    e = 0;
    f = 0;
    Object localObject = RqdApplication.n().getResources().getDisplayMetrics();
    localObject = l.a(new Object[] { "real_uin", Long.valueOf(this.g), "scene_id", Integer.valueOf(this.h), "mobile_brand", URLEncoder.encode(Build.BRAND), "mobile_model", URLEncoder.encode(Build.MODEL), "mobile_sdk_int", Integer.valueOf(Integer.parseInt(Build.VERSION.SDK)), "mobile_sdk_str", URLEncoder.encode(Build.VERSION.RELEASE), "screen_witdh", Integer.valueOf(((DisplayMetrics)localObject).widthPixels), "screen_height", Integer.valueOf(((DisplayMetrics)localObject).heightPixels), "screen_dpi", Integer.valueOf(((DisplayMetrics)localObject).densityDpi), "cpu_count", Integer.valueOf(m.y()), "cpu_freq", Integer.valueOf(m.z()) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?aq_base_sid=");
    localStringBuilder.append(str);
    localStringBuilder.append("&data=");
    localStringBuilder.append((String)localObject);
    str = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.e());
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_live_video_detect");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  protected void a(dp paramdp)
  {
    this.g = ((Long)paramdp.c.get("param.realuin")).longValue();
    this.h = ((Integer)paramdp.c.get("param.scene.id")).intValue();
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
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mLiveDetectActions");
          ((StringBuilder)localObject).append(this.j[k]);
          g.a(((StringBuilder)localObject).toString());
          k += 1;
        }
        k = this.h;
        if ((k != 2) && (k != 1))
        {
          localObject = this.j;
          if (localObject.length >= 1)
          {
            f = localObject[0];
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("sVryAction");
            ((StringBuilder)localObject).append(f);
            g.a(((StringBuilder)localObject).toString());
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
        h.k = paramJSONObject.getInt("displayangle");
        h.l = paramJSONObject.getInt("imageangle");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("display angle=");
        ((StringBuilder)localObject).append(h.k);
        ((StringBuilder)localObject).append(",angel2=");
        ((StringBuilder)localObject).append(h.l);
        g.a(((StringBuilder)localObject).toString());
        m.a(paramJSONObject);
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      this.a.c();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseJSON error decodeData=");
    ((StringBuilder)localObject).append(paramJSONObject);
    g.c(((StringBuilder)localObject).toString());
    a(10022, RqdApplication.n().getString(2131493068));
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