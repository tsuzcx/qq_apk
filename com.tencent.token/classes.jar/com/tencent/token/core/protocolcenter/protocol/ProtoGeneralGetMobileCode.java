package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoGeneralGetMobileCode
  extends e
{
  public static String d;
  public static String e;
  public static String f;
  private long g;
  private long h;
  private int i;
  private int j;
  private final String k = "/cn/mbtoken3/mbtoken3_general_get_mobile_code";
  
  public static void a(ev paramev, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramev.c.put("param.realuin", Long.valueOf(paramLong2));
    paramev.c.put("param.general.mobilecode.sceneid", Integer.valueOf(paramInt1));
    paramev.j = paramInt2;
  }
  
  protected String a()
  {
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    String str2 = w.a(new Object[] { "real_uin", Long.valueOf(this.h), "scene_id", Integer.valueOf(this.j), "seq_id", Integer.valueOf(this.i), "op_time", Long.valueOf(cx.c().s() / 1000L) });
    str1 = "?uin=" + this.g + "&aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_general_get_mobile_code" + str1;
  }
  
  protected void a(ev paramev)
  {
    this.g = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.h = ((Long)paramev.c.get("param.realuin")).longValue();
    this.j = ((Integer)paramev.c.get("param.general.mobilecode.sceneid")).intValue();
    this.i = paramev.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int m = paramJSONObject.getInt("err");
    if (m != 0)
    {
      String str = paramJSONObject.getString("info");
      if (m == 124)
      {
        paramJSONObject = w.c(paramJSONObject.getString("data"));
        if (paramJSONObject != null)
        {
          paramJSONObject = new JSONObject(new String(paramJSONObject));
          d = paramJSONObject.getString("sms_port");
          e = paramJSONObject.getString("sms_up_code");
        }
      }
      try
      {
        f = paramJSONObject.getString("mobile_sms_prefix");
        h.b("realname port=" + d + ", content=" + e);
        a(m, str);
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
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      h.a("json" + paramJSONObject.toString());
      m = paramJSONObject.getInt("seq_id");
      if (m != this.i)
      {
        h.c("parseJSON error seq is wrong seq=" + m + ",right = " + this.i);
        this.a.b(10030);
        return;
      }
      d = paramJSONObject.getString("sms_port");
      e = paramJSONObject.getString("sms_up_code");
      try
      {
        f = paramJSONObject.getString("mobile_sms_prefix");
        h.b("realname port=" + d + ", content=" + e);
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
    h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGeneralGetMobileCode
 * JD-Core Version:    0.7.0.1
 */