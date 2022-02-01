package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.bz;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dn;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDelUnverifyUin
  extends d
{
  private String d;
  
  public static void a(dn paramdn, long paramLong)
  {
    paramdn.c.put("param.realuin", Long.valueOf(paramLong));
  }
  
  protected String a()
  {
    String str1 = bz.a().b();
    String str2 = l.a(new Object[] { "uin", this.d });
    if ((str1 == null) || (str2 == null))
    {
      this.a.b(104);
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_del_unvfy_uin" + str1;
  }
  
  protected void a(dn paramdn)
  {
    this.d = ("" + paramdn.c.get("param.realuin"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    g.a("ProtoDelUnverifyUin:errCode" + i);
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