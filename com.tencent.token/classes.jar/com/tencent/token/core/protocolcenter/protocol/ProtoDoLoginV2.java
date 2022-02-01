package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.ca;
import com.tencent.token.cc;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cr;
import com.tencent.token.do;
import com.tencent.token.eq;
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
  cc d = cc.c();
  eq e = cr.a().l;
  private long f;
  private int g;
  private int h;
  
  public static void a(do paramdo, long paramLong, int paramInt1, int paramInt2)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdo.c.put("param.loginv2.clearkick", Integer.valueOf(paramInt1));
    paramdo.j = paramInt2;
  }
  
  protected String a()
  {
    this.d.m();
    Object localObject1 = this.d.o();
    String str = ca.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject2 = cr.a().e();
    if (localObject2 != null)
    {
      if (!((QQUser)localObject2).mIsBinded) {
        return null;
      }
      localObject1 = l.a(new Object[] { "uin", Long.valueOf(this.f), "tkn_code", localObject1, "ksid", this.d.h(), "channel_id", l.m(), "clear_kick", Integer.valueOf(this.g), "seq_id", Integer.valueOf(this.h), "op_time", Long.valueOf(cc.c().s() / 1000L) });
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("?aq_base_sid=");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("&data=");
      ((StringBuilder)localObject2).append((String)localObject1);
      str = ((StringBuilder)localObject2).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(c.e());
      ((StringBuilder)localObject1).append("/cn/mbtoken3/mbtoken3_login_encrypt");
      ((StringBuilder)localObject1).append(str);
      return ((StringBuilder)localObject1).toString();
    }
    return null;
  }
  
  protected void a(do paramdo)
  {
    this.f = ((Long)paramdo.c.get("param.uinhash")).longValue();
    this.g = ((Integer)paramdo.c.get("param.loginv2.clearkick")).intValue();
    this.h = paramdo.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      if (i == 270)
      {
        localObject1 = l.c(paramJSONObject.getString("data"));
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("login_v2 ret: ");
      ((StringBuilder)localObject1).append(paramJSONObject);
      g.a(((StringBuilder)localObject1).toString());
      i = paramJSONObject.getInt("seq_id");
      if (i != this.h)
      {
        this.a.b(10030);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.h);
        g.c(paramJSONObject.toString());
        return;
      }
      long l1 = paramJSONObject.getLong("uin");
      cr.a().a(paramJSONObject);
      if (l1 != this.f)
      {
        paramJSONObject = this.a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("uin not match=");
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append(":");
        ((StringBuilder)localObject1).append(this.f);
        paramJSONObject.a(10000, ((StringBuilder)localObject1).toString());
        return;
      }
      cr.a().m();
      if (!this.e.a(l1)) {
        this.a.a(10000, "mUserStorage.setCurrentUserByUin failed");
      }
      l1 = System.currentTimeMillis() / 1000L;
      long l2 = paramJSONObject.getInt("valid_time");
      cr.a().a(this.f, l1, l2);
      if (this.d.h().length() == 0) {
        this.d.c(paramJSONObject.optString("ksid"));
      }
      this.a.c();
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("parseJSON error decodeData=");
    ((StringBuilder)localObject1).append(paramJSONObject);
    g.c(((StringBuilder)localObject1).toString());
    a(10022, RqdApplication.l().getString(2131493067));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoLoginV2
 * JD-Core Version:    0.7.0.1
 */