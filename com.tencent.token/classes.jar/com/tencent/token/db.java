package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class db
  extends bm
{
  public static String c;
  public static String d;
  public static String e;
  private long f;
  private long g;
  private int h;
  private int i;
  private final String j = "/cn/mbtoken3/mbtoken3_general_get_mobile_code";
  
  public static void a(fs paramfs, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    paramfs.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramfs.c.put("param.realuin", Long.valueOf(paramLong2));
    paramfs.c.put("param.general.mobilecode.sceneid", Integer.valueOf(paramInt1));
    paramfs.j = paramInt2;
  }
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str1 = ax.c; str1 == null; str1 = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    String str2 = s.a(new Object[] { "real_uin", Long.valueOf(this.g), "scene_id", Integer.valueOf(this.i), "seq_id", Integer.valueOf(this.h), "op_time", Long.valueOf(ag.c().r() / 1000L) });
    str1 = "?uin=" + this.f + "&aq_base_sid=" + str1 + "&data=" + str2;
    return b.c() + "/cn/mbtoken3/mbtoken3_general_get_mobile_code" + str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.f = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.g = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.i = ((Integer)paramfs.c.get("param.general.mobilecode.sceneid")).intValue();
    this.h = paramfs.j;
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int k = paramJSONObject.getInt("err");
    if (k != 0)
    {
      String str = paramJSONObject.getString("info");
      if (k == 124)
      {
        paramJSONObject = s.d(paramJSONObject.getString("data"));
        if (paramJSONObject != null)
        {
          paramJSONObject = new JSONObject(new String(paramJSONObject));
          c = paramJSONObject.getString("sms_port");
          d = paramJSONObject.getString("sms_up_code");
        }
      }
      try
      {
        e = paramJSONObject.getString("mobile_sms_prefix");
        e.b("realname port=" + c + ", content=" + d);
        a(k, str);
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
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      k = paramJSONObject.getInt("seq_id");
      if (k != this.h)
      {
        e.c("parseJSON error seq is wrong seq=" + k + ",right = " + this.h);
        this.a.a(10030, null, null);
        return;
      }
      c = paramJSONObject.getString("sms_port");
      d = paramJSONObject.getString("sms_up_code");
      try
      {
        e = paramJSONObject.getString("mobile_sms_prefix");
        e.b("realname port=" + c + ", content=" + d);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.db
 * JD-Core Version:    0.7.0.1
 */