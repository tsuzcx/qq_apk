package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.bz;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dn;
import com.tencent.token.dp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.global.k;
import com.tencent.token.utils.encrypt.b;
import com.tencent.token.utils.l;
import com.tmsdk.common.util.TmsLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoDoActiveToken
  extends d
{
  private static final dp e = new dp("B8008767A628A4F53BCB84C13C961A55BF87607DAA5BE0BA3AC2E0CB778E494579BD444F699885F4968CD9028BB3FC6FA657D532F1718F581669BDC333F83DC3", 16);
  private final long d = 2L;
  private dp f = new dp("-1");
  private cb g = cb.c();
  
  protected String a()
  {
    String str1 = bz.a().b();
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
    int i = ca.a + 1;
    ca.a = i;
    this.c = i;
    g.a("client_pub_key=" + str2 + ", length=" + str2.length());
    str2 = l.a(new Object[] { "imei", cb.b(), "clt_pub_key", str2, "seq_id", Integer.valueOf(this.c), "op_time", Integer.valueOf((int)(cb.c().s() / 1000L)), "turingd_ticket_id", k.c() });
    if (str2 == null)
    {
      this.a.a(10000, "encrypt imei failed");
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_activate_token_encrypt" + str1;
  }
  
  protected void a(dn paramdn) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    TmsLog.i("mod_seed", "active token parseJon, errcode: " + i);
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, "server errcode=" + i + ":" + paramJSONObject, paramJSONObject);
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
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
      try
      {
        l = paramJSONObject.getLong("seed_expire_time");
        this.g.c(l);
        this.g.e();
        localObject = new dp((String)localObject, 16);
        localObject = b.b(this.f, (dp)localObject, e);
        if (localObject == null)
        {
          this.a.b(10026);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        this.g.a((dp)localObject);
        this.g.n();
        this.g.v();
        long l = paramJSONObject.getLong("server_time");
        this.g.b(l);
        this.a.c();
        return;
      }
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoActiveToken
 * JD-Core Version:    0.7.0.1
 */