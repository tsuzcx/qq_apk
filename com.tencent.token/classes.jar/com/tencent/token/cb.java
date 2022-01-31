package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class cb
  extends bm
{
  private long c;
  private String d;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str2 = ax.c; str2 == null; str2 = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    String str3 = "";
    String str1 = str3;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      str1 = str3;
      localJSONObject.put("real_uin", this.c);
      str1 = str3;
      int i = af.a + 1;
      str1 = str3;
      af.a = i;
      str1 = str3;
      localJSONObject.put("seq_id", i);
      str1 = str3;
      localJSONObject.put("op_time", ag.c().r() / 1000L);
      str1 = str3;
      localJSONObject.put("token_seq", ag.c().k());
      str1 = str3;
      localJSONObject.put("token_code", ag.c().o());
      str1 = str3;
      localJSONObject.put("imei", s.b(RqdApplication.i()));
      str1 = str3;
      localJSONObject.put("signature", this.d);
      str1 = str3;
      str3 = localJSONObject.toString();
      str1 = str3;
      e.a("plain:" + str3);
      str1 = str3;
      str3 = s.b(str3.getBytes());
      str1 = str3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        e.c("JSONException:" + localException.getMessage());
      }
    }
    str1 = "?aq_base_sid=" + str2 + "&data=" + str1;
    str1 = b.c() + "/cn/mbtoken3/mbtoken3_bind_token_h5" + str1;
    e.c("url:" + str1);
    return str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.d = ((String)paramfs.c.get("param.bind.sig"));
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, "server errcode=" + i + ":" + paramJSONObject, paramJSONObject);
      return;
    }
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      long l = paramJSONObject.getLong("server_time");
      ag.c();
      ag.b(l);
      if (paramJSONObject.getInt("seed_available") == 1)
      {
        paramJSONObject = s.e(paramJSONObject.getString("seed"));
        if (paramJSONObject != null)
        {
          ag.c().e();
          ag.c().a(paramJSONObject);
          ag.c().i();
        }
      }
      paramJSONObject = ax.a().d(this.c);
      if (paramJSONObject != null) {
        ax.a().b(paramJSONObject);
      }
      this.a.a = 0;
      return;
    }
    e.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cb
 * JD-Core Version:    0.7.0.1
 */