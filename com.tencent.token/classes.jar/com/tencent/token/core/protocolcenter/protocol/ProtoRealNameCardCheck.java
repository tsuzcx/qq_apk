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

public class ProtoRealNameCardCheck
  extends e
{
  private long d;
  private int e;
  private String f;
  private long g;
  
  public static void a(ev paramev, long paramLong1, long paramLong2, int paramInt, String paramString)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramev.c.put("param.realuin", Long.valueOf(paramLong2));
    paramev.c.put("param.idnumber", paramString);
    paramev.j = paramInt;
  }
  
  protected String a()
  {
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    String str2 = w.a(new Object[] { "real_uin", Long.valueOf(this.d), "seq_id", Integer.valueOf(this.e), "op_time", Long.valueOf(cx.c().s() / 1000L), "id_number", this.f });
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_card_check" + str1;
  }
  
  protected void a(ev paramev)
  {
    this.g = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.d = ((Long)paramev.c.get("param.realuin")).longValue();
    this.e = paramev.j;
    this.f = ((String)paramev.c.get("param.idnumber"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      i = new JSONObject(new String(paramJSONObject)).getInt("seq_id");
      if (i != this.e)
      {
        this.a.b(10030);
        h.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.e);
        return;
      }
      this.a.c();
      return;
    }
    h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoRealNameCardCheck
 * JD-Core Version:    0.7.0.1
 */