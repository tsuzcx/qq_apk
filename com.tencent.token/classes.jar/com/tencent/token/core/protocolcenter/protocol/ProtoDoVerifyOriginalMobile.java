package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDoVerifyOriginalMobile
  extends e
{
  public String d;
  public long e;
  private int f;
  private int g = 0;
  
  public static void a(ev paramev, long paramLong, String paramString, int paramInt)
  {
    paramev.c.put("param.realuin", Long.valueOf(paramLong));
    paramev.c.put("param.mbmobile.mobile", paramString);
    paramev.c.put("param.type", Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    int i = cw.a + 1;
    cw.a = i;
    this.f = i;
    String str2 = w.a(new Object[] { "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(cx.c().s() / 1000L), "uin", Long.valueOf(this.e), "mobile", this.d, "verify_type_id", Integer.valueOf(this.g) });
    if (str2 == null)
    {
      this.a.a(10000, "encrypt qqtoken code failed");
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_verify_original_mobile" + str1;
  }
  
  protected void a(ev paramev)
  {
    this.e = ((Long)paramev.c.get("param.realuin")).longValue();
    this.d = ((String)paramev.c.get("param.mbmobile.mobile"));
    this.g = ((Integer)paramev.c.get("param.type")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, paramJSONObject, paramJSONObject);
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoVerifyOriginalMobile
 * JD-Core Version:    0.7.0.1
 */