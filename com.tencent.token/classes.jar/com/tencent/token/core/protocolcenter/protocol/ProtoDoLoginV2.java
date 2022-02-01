package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.bz;
import com.tencent.token.cb;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cq;
import com.tencent.token.dn;
import com.tencent.token.ep;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDoLoginV2
  extends d
{
  cb d = cb.c();
  ep e = cq.a().l;
  private long f;
  private int g;
  private int h;
  
  public static void a(dn paramdn, long paramLong, int paramInt1, int paramInt2)
  {
    paramdn.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdn.c.put("param.loginv2.clearkick", Integer.valueOf(paramInt1));
    paramdn.j = paramInt2;
  }
  
  protected String a()
  {
    this.d.m();
    String str2 = this.d.o();
    String str1 = bz.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    str2 = l.a(new Object[] { "uin", Long.valueOf(this.f), "tkn_code", str2, "ksid", this.d.h(), "channel_id", l.m(), "clear_kick", Integer.valueOf(this.g), "seq_id", Integer.valueOf(this.h), "op_time", Long.valueOf(cb.c().s() / 1000L) });
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_login_encrypt" + str1;
  }
  
  protected void a(dn paramdn)
  {
    this.f = ((Long)paramdn.c.get("param.uinhash")).longValue();
    this.g = ((Integer)paramdn.c.get("param.loginv2.clearkick")).intValue();
    this.h = paramdn.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      if (i == 270)
      {
        Object localObject1 = l.c(paramJSONObject.getString("data"));
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
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      g.a("login_v2 ret: " + paramJSONObject);
      i = paramJSONObject.getInt("seq_id");
      if (i != this.h)
      {
        this.a.b(10030);
        g.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.h);
        return;
      }
      long l1 = paramJSONObject.getLong("uin");
      cq.a().a(paramJSONObject);
      if (l1 != this.f)
      {
        this.a.a(10000, "uin not match=" + l1 + ":" + this.f);
        return;
      }
      cq.a().m();
      if (!this.e.a(l1)) {
        this.a.a(10000, "mUserStorage.setCurrentUserByUin failed");
      }
      l1 = System.currentTimeMillis() / 1000L;
      long l2 = paramJSONObject.getInt("valid_time");
      cq.a().a(this.f, l1, l2);
      if (this.d.h().length() == 0) {
        this.d.c(paramJSONObject.optString("ksid"));
      }
      this.a.c();
      return;
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoLoginV2
 * JD-Core Version:    0.7.0.1
 */