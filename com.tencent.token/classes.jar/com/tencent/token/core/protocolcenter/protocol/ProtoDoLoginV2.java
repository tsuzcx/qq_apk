package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.ev;
import com.tencent.token.fy;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDoLoginV2
  extends e
{
  cx d = cx.c();
  fy e = do.a().l;
  private long f;
  private int g;
  private int h;
  
  public static void a(ev paramev, long paramLong, int paramInt1, int paramInt2)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong));
    paramev.c.put("param.loginv2.clearkick", Integer.valueOf(paramInt1));
    paramev.j = paramInt2;
  }
  
  protected String a()
  {
    this.d.m();
    String str2 = this.d.o();
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    str2 = w.a(new Object[] { "uin", Long.valueOf(this.f), "tkn_code", str2, "ksid", this.d.h(), "channel_id", w.m(), "clear_kick", Integer.valueOf(this.g), "seq_id", Integer.valueOf(this.h), "op_time", Long.valueOf(cx.c().s() / 1000L) });
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_login_encrypt" + str1;
  }
  
  protected void a(ev paramev)
  {
    this.f = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.g = ((Integer)paramev.c.get("param.loginv2.clearkick")).intValue();
    this.h = paramev.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      if (i == 270)
      {
        Object localObject1 = w.c(paramJSONObject.getString("data"));
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
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      h.a("login_v2 ret: " + paramJSONObject);
      i = paramJSONObject.getInt("seq_id");
      if (i != this.h)
      {
        this.a.b(10030);
        h.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.h);
        return;
      }
      long l1 = paramJSONObject.getLong("uin");
      do.a().a(paramJSONObject);
      if (l1 != this.f)
      {
        this.a.a(10000, "uin not match=" + l1 + ":" + this.f);
        return;
      }
      do.a().m();
      if (!this.e.a(l1)) {
        this.a.a(10000, "mUserStorage.setCurrentUserByUin failed");
      }
      l1 = System.currentTimeMillis() / 1000L;
      long l2 = paramJSONObject.getInt("valid_time");
      do.a().a(this.f, l1, l2);
      if (this.d.h().length() == 0) {
        this.d.c(paramJSONObject.optString("ksid"));
      }
      this.a.c();
      return;
    }
    h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoLoginV2
 * JD-Core Version:    0.7.0.1
 */