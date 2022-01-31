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

public class ProtoGetSMSChannel
  extends e
{
  public static String d;
  public static String e;
  private long f;
  private String g;
  private int h;
  private int i;
  private String j;
  private int k;
  
  public static void a(ev paramev, long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    paramev.c.put("param.realuin", Long.valueOf(paramLong));
    paramev.c.put("param.mbmobile.mobile", paramString1);
    paramev.c.put("param.mbmoible.ismobile", Integer.valueOf(paramInt1));
    paramev.c.put("param.scene.id", Integer.valueOf(paramInt2));
    paramev.c.put("param.mbmoible.areacode", paramString2);
    paramev.j = paramInt3;
  }
  
  protected String a()
  {
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    String str2 = w.a(new Object[] { "seq_id", Integer.valueOf(this.k), "op_time", Long.valueOf(cx.c().s() / 1000L), "uin", Long.valueOf(this.f), "mobile", this.g, "area_code", this.j, "scene", Integer.valueOf(this.i), "is_mb_mobile", Integer.valueOf(this.h) });
    if (str2 == null)
    {
      this.a.a(10000, "encrypt data failed");
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_get_sms_port_v2" + str1;
  }
  
  protected void a(ev paramev)
  {
    this.f = ((Long)paramev.c.get("param.realuin")).longValue();
    this.g = ((String)paramev.c.get("param.mbmobile.mobile"));
    this.h = ((Integer)paramev.c.get("param.mbmoible.ismobile")).intValue();
    this.i = ((Integer)paramev.c.get("param.scene.id")).intValue();
    this.j = ((String)paramev.c.get("param.mbmoible.areacode"));
    this.k = paramev.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int m = paramJSONObject.getInt("err");
    if (m != 0)
    {
      a(m, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      h.a("ProtoGetSMSChannel result =" + paramJSONObject);
      m = paramJSONObject.getInt("seq_id");
      if (m != this.k)
      {
        this.a.b(10030);
        h.c("parseJSON error seq is wrong seq=" + m + ",right = " + this.k);
        return;
      }
      d = paramJSONObject.getString("sms_port");
    }
    try
    {
      e = paramJSONObject.getString("sms_up_code");
      label153:
      this.a.c();
      return;
      h.c("parseJSON error decodeData=" + paramJSONObject);
      a(10022, RqdApplication.l().getString(2131230925));
      return;
    }
    catch (Exception paramJSONObject)
    {
      break label153;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetSMSChannel
 * JD-Core Version:    0.7.0.1
 */