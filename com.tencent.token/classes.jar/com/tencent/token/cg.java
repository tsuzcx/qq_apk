package com.tencent.token;

import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import org.json.JSONException;
import org.json.JSONObject;

public final class cg
  extends bm
{
  private static final fu d = new fu("B8008767A628A4F53BCB84C13C961A55BF87607DAA5BE0BA3AC2E0CB778E494579BD444F699885F4968CD9028BB3FC6FA657D532F1718F581669BDC333F83DC3", 16);
  private final long c = 2L;
  private fu e = new fu("-1");
  private ag f = ag.c();
  
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
    String str2 = s.a(new Object[] { "imei", ag.b() });
    if (str2 == null)
    {
      this.a.a(10000, "encrypt imei failed", null);
      return null;
    }
    this.e = com.tencent.token.utils.encrypt.b.a();
    String str3 = com.tencent.token.utils.encrypt.b.a(this.e, d);
    if ((this.e == null) || (str3 == null) || (str3.length() == 0))
    {
      this.a.a(10025, null, null);
      return null;
    }
    e.a("client_pub_key=" + str3 + ", length=" + str3.length());
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2 + "&clt_pub_key=" + str3;
    return com.tencent.token.global.b.c() + "/cn/mbtoken3/mbtoken3_activate_token" + str1;
  }
  
  protected final void a(fs paramfs) {}
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, "server errcode=" + i + ":" + paramJSONObject, paramJSONObject);
      return;
    }
    Object localObject = paramJSONObject.getString("svc_pub_key");
    if (((String)localObject).length() <= 0) {
      throw new JSONException("");
    }
    this.f.e();
    localObject = new fu((String)localObject, 16);
    localObject = com.tencent.token.utils.encrypt.b.a(this.e, (fu)localObject, d);
    if (localObject == null)
    {
      this.a.a(10026, null, null);
      return;
    }
    this.f.a((fu)localObject);
    this.f.n();
    ag.b(paramJSONObject.getLong("server_time"));
    this.a.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cg
 * JD-Core Version:    0.7.0.1
 */