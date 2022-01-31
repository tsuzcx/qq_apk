package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoBindTokenH5
  extends e
{
  private long d;
  private String e;
  
  protected String a()
  {
    String str3 = cv.a().b();
    if (str3 == null)
    {
      this.a.b(104);
      return null;
    }
    String str2 = "";
    String str1 = str2;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      str1 = str2;
      localJSONObject.put("real_uin", this.d);
      str1 = str2;
      int i = cw.a + 1;
      str1 = str2;
      cw.a = i;
      str1 = str2;
      localJSONObject.put("seq_id", i);
      str1 = str2;
      localJSONObject.put("op_time", cx.c().s() / 1000L);
      str1 = str2;
      localJSONObject.put("token_seq", cx.c().k());
      str1 = str2;
      localJSONObject.put("token_code", cx.c().o());
      str1 = str2;
      localJSONObject.put("imei", w.b(RqdApplication.l()));
      str1 = str2;
      localJSONObject.put("signature", this.e);
      str1 = str2;
      str2 = localJSONObject.toString();
      str1 = str2;
      h.a("plain:" + str2);
      str1 = str2;
      str2 = w.b(str2.getBytes());
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        h.c("JSONException:" + localException.getMessage());
      }
    }
    str1 = "?aq_base_sid=" + str3 + "&data=" + str1;
    str1 = c.e() + "/cn/mbtoken3/mbtoken3_bind_token_h5" + str1;
    h.c("url:" + str1);
    return str1;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Long)paramev.c.get("param.realuin")).longValue();
    this.e = ((String)paramev.c.get("param.bind.sig"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, "server errcode=" + i + ":" + paramJSONObject, paramJSONObject);
      return;
    }
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      long l = paramJSONObject.getLong("server_time");
      cx.c().b(l);
      if (paramJSONObject.getInt("seed_available") == 1)
      {
        paramJSONObject = w.d(paramJSONObject.getString("seed"));
        if (paramJSONObject != null)
        {
          cx.c().e();
          cx.c().a(paramJSONObject);
          cx.c().i();
        }
      }
      paramJSONObject = do.a().d(this.d);
      if (paramJSONObject != null) {
        do.a().b(paramJSONObject);
      }
      this.a.c();
      return;
    }
    h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoBindTokenH5
 * JD-Core Version:    0.7.0.1
 */