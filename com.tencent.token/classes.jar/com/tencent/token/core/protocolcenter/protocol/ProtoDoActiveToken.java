package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.ex;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.encrypt.b;
import com.tencent.token.utils.w;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoDoActiveToken
  extends e
{
  private static final ex e = new ex("B8008767A628A4F53BCB84C13C961A55BF87607DAA5BE0BA3AC2E0CB778E494579BD444F699885F4968CD9028BB3FC6FA657D532F1718F581669BDC333F83DC3", 16);
  private final long d = 2L;
  private ex f = new ex("-1");
  private cx g = cx.c();
  
  protected String a()
  {
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    this.f = b.a();
    String str2 = b.a(this.f, 2L, e);
    if ((this.f == null) || (str2 == null) || (str2.length() == 0))
    {
      this.a.b(10025);
      return null;
    }
    int i = cw.a + 1;
    cw.a = i;
    this.c = i;
    h.a("client_pub_key=" + str2 + ", length=" + str2.length());
    str2 = w.a(new Object[] { "imei", cx.b(), "clt_pub_key", str2, "seq_id", Integer.valueOf(this.c), "op_time", Integer.valueOf((int)(cx.c().s() / 1000L)) });
    if (str2 == null)
    {
      this.a.a(10000, "encrypt imei failed");
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_activate_token_encrypt" + str1;
  }
  
  protected void a(ev paramev) {}
  
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
      i = paramJSONObject.getInt("seq_id");
      if (this.c != i)
      {
        this.a.b(10030);
        return;
      }
      Object localObject = paramJSONObject.getString("svc_pub_key");
      if (((String)localObject).length() <= 0) {
        throw new JSONException("");
      }
      this.g.e();
      localObject = new ex((String)localObject, 16);
      localObject = b.b(this.f, (ex)localObject, e);
      if (localObject == null)
      {
        this.a.b(10026);
        return;
      }
      this.g.a((ex)localObject);
      this.g.n();
      long l = paramJSONObject.getLong("server_time");
      this.g.b(l);
      this.a.c();
      return;
    }
    h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoActiveToken
 * JD-Core Version:    0.7.0.1
 */