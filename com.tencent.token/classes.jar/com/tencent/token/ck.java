package com.tencent.token;

import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class ck
  extends bm
{
  ag c = ag.c();
  gj d = ax.a().l;
  private long e;
  
  protected final String a()
  {
    this.c.m();
    String str2 = this.c.o();
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str1 = ax.c; str1 == null; str1 = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    str1 = "?uin=" + this.e + "&sess_id=" + str1 + "&tkn_code=" + str2 + "&ksid=" + this.c.h();
    str1 = str1 + "&channel_id=" + s.k();
    return b.c() + "/cn/mbtoken3/mbtoken3_login" + str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.e = ((Long)paramfs.c.get("param.uinhash")).longValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    long l = paramJSONObject.getLong("uin");
    ax.a();
    ax.a(paramJSONObject);
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    if (l != this.e)
    {
      this.a.a(10000, "uin not match=" + l + ":" + this.e, null);
      return;
    }
    ax.a().m();
    if (!this.d.a(l)) {
      this.a.a(10000, "mUserStorage.setCurrentUserByUin failed", null);
    }
    System.currentTimeMillis();
    l = paramJSONObject.getInt("valid_time");
    ax.a().a(this.e, l);
    if (this.c.h().length() == 0) {
      this.c.c(paramJSONObject.getString("ksid"));
    }
    this.a.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ck
 * JD-Core Version:    0.7.0.1
 */