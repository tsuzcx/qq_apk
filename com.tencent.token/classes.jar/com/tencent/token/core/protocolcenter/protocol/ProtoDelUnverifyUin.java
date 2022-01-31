package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.ev;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDelUnverifyUin
  extends e
{
  private String d;
  
  public static void a(ev paramev, long paramLong)
  {
    paramev.c.put("param.realuin", Long.valueOf(paramLong));
  }
  
  protected String a()
  {
    String str1 = cv.a().b();
    String str2 = w.a(new Object[] { "uin", this.d });
    if ((str1 == null) || (str2 == null))
    {
      this.a.b(104);
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_del_unvfy_uin" + str1;
  }
  
  protected void a(ev paramev)
  {
    this.d = ("" + paramev.c.get("param.realuin"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    h.a("ProtoDelUnverifyUin:errCode" + i);
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDelUnverifyUin
 * JD-Core Version:    0.7.0.1
 */