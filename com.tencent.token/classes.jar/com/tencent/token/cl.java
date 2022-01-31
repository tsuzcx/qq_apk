package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class cl
  extends bm
{
  ag c = ag.c();
  gj d = ax.a().l;
  private long e;
  private int f;
  private int g;
  
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
    str2 = s.a(new Object[] { "tkn_code", str2, "ksid", this.c.h(), "channel_id", s.k(), "clear_kick", Integer.valueOf(this.f), "seq_id", Integer.valueOf(this.g), "op_time", Long.valueOf(ag.c().r() / 1000L) });
    str1 = "?uin=" + this.e + "&aq_base_sid=" + str1 + "&data=" + str2;
    return b.c() + "/cn/mbtoken3/mbtoken3_login_v2" + str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.e = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.f = ((Integer)paramfs.c.get("param.loginv2.clearkick")).intValue();
    this.g = paramfs.j;
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      if (i == 270)
      {
        Object localObject1 = s.d(paramJSONObject.getString("data"));
        if (localObject1 != null)
        {
          Object localObject2 = new JSONObject(new String((byte[])localObject1));
          localObject1 = ((JSONObject)localObject2).optString("masked_mobile");
          localObject2 = ((JSONObject)localObject2).optString("mSmsPrefix");
          UpgradeDeterminResult localUpgradeDeterminResult = new UpgradeDeterminResult();
          localUpgradeDeterminResult.mMobileMask = ((String)localObject1);
          localUpgradeDeterminResult.mSmsPrefix = ((String)localObject2);
          this.a.d = localUpgradeDeterminResult;
        }
      }
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      e.a("login_v2 ret: " + paramJSONObject);
      i = paramJSONObject.getInt("seq_id");
      if (i != this.g)
      {
        this.a.a(10030, null, null);
        e.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.g);
        return;
      }
      long l = paramJSONObject.getLong("uin");
      ax.a();
      ax.a(paramJSONObject);
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
      return;
    }
    e.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cl
 * JD-Core Version:    0.7.0.1
 */