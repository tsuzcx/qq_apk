package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class ea
  extends bm
{
  public static String c;
  public static String d;
  private long e;
  private String f;
  private int g;
  private int h;
  private String i;
  private int j;
  
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
    String str2 = s.a(new Object[] { "seq_id", Integer.valueOf(this.j), "op_time", Long.valueOf(ag.c().r() / 1000L), "uin", Long.valueOf(this.e), "mobile", this.f, "area_code", this.i, "scene", Integer.valueOf(this.h), "is_mb_mobile", Integer.valueOf(this.g) });
    if (str2 == null)
    {
      this.a.a(10000, "encrypt data failed", null);
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return b.c() + "/cn/mbtoken3/mbtoken3_get_sms_port_v2" + str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.e = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.f = ((String)paramfs.c.get("param.mbmobile.mobile"));
    this.g = ((Integer)paramfs.c.get("param.mbmoible.ismobile")).intValue();
    this.h = ((Integer)paramfs.c.get("param.scene.id")).intValue();
    this.i = ((String)paramfs.c.get("param.mbmoible.areacode"));
    this.j = paramfs.j;
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int k = paramJSONObject.getInt("err");
    if (k != 0)
    {
      a(k, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      e.a("ProtoGetSMSChannel result =" + paramJSONObject);
      k = paramJSONObject.getInt("seq_id");
      if (k != this.j)
      {
        this.a.a(10030, null, null);
        e.c("parseJSON error seq is wrong seq=" + k + ",right = " + this.j);
        return;
      }
      c = paramJSONObject.getString("sms_port");
    }
    try
    {
      d = paramJSONObject.getString("sms_up_code");
      label155:
      this.a.a = 0;
      return;
      e.c("parseJSON error decodeData=" + paramJSONObject);
      a(10022, RqdApplication.i().getString(2131361799));
      return;
    }
    catch (Exception paramJSONObject)
    {
      break label155;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ea
 * JD-Core Version:    0.7.0.1
 */