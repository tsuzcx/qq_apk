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
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoAutoIDCardDetect
  extends d
{
  public static int d = -1;
  public static int e = -1;
  private long f;
  private int g;
  
  public static void a(do paramdo, long paramLong)
  {
    paramdo.c.put("param.realuin", Long.valueOf(paramLong));
  }
  
  protected String a()
  {
    String str = ca.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject = RqdApplication.l().getResources().getDisplayMetrics();
    localObject = l.a(new Object[] { "real_uin", Long.valueOf(this.f), "scene_id", Integer.valueOf(1), "mobile_brand", URLEncoder.encode(Build.BRAND), "mobile_model", URLEncoder.encode(Build.MODEL), "mobile_sdk_int", Integer.valueOf(Integer.parseInt(Build.VERSION.SDK)), "mobile_sdk_str", URLEncoder.encode(Build.VERSION.RELEASE), "screen_witdh", Integer.valueOf(((DisplayMetrics)localObject).widthPixels), "screen_height", Integer.valueOf(((DisplayMetrics)localObject).heightPixels), "screen_dpi", Integer.valueOf(((DisplayMetrics)localObject).densityDpi), "cpu_count", Integer.valueOf(m.y()), "cpu_freq", Integer.valueOf(m.z()) });
    str = "?aq_base_sid=" + str + "&data=" + (String)localObject;
    return c.e() + "/cn/mbtoken3/mbtoken3_idcard_auto_detect" + str;
  }
  
  protected void a(do paramdo)
  {
    this.f = ((Long)paramdo.c.get("param.realuin")).longValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      this.g = paramJSONObject.getInt("need_idcard_detect");
      if (this.g == 1) {}
      try
      {
        d = paramJSONObject.getInt("displayangle");
        e = paramJSONObject.getInt("imageangle");
        g.a("plain angle=" + d + ",angel2=" + e);
        this.a.c();
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
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.arg2 = this.g;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoAutoIDCardDetect
 * JD-Core Version:    0.7.0.1
 */