package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class ud
  extends tk
{
  sc d;
  ahh e;
  private long f;
  private int g;
  private int h;
  
  public final String a()
  {
    this.d.d();
    this.d.f();
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.f = ((Long)paramaar.c.get("param.uinhash")).longValue();
    this.g = ((Integer)paramaar.c.get("param.loginv2.clearkick")).intValue();
    this.h = paramaar.j;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (i != 0)
    {
      if (i == 270)
      {
        localObject1 = aad.d(paramJSONObject.getString("data"));
        if (localObject1 != null)
        {
          localObject2 = new JSONObject(new String((byte[])localObject1));
          localObject1 = ((JSONObject)localObject2).optString("masked_mobile");
          localObject2 = ((JSONObject)localObject2).optString("mSmsPrefix");
          localObject3 = new UpgradeDeterminResult();
          ((UpgradeDeterminResult)localObject3).mMobileMask = ((String)localObject1);
          ((UpgradeDeterminResult)localObject3).mSmsPrefix = ((String)localObject2);
          this.a.d = localObject3;
        }
      }
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aad.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      xb.a("login_v2 ret: ".concat(String.valueOf(paramJSONObject)));
      i = paramJSONObject.getInt("seq_id");
      if (i != this.h)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.h);
        xb.c(paramJSONObject.toString());
        return;
      }
      long l = paramJSONObject.getLong("uin");
      ta.a();
      ta.a(paramJSONObject);
      if (l != this.f)
      {
        paramJSONObject = this.a;
        localObject1 = new StringBuilder("uin not match=");
        ((StringBuilder)localObject1).append(l);
        ((StringBuilder)localObject1).append(":");
        ((StringBuilder)localObject1).append(this.f);
        paramJSONObject.a(10000, ((StringBuilder)localObject1).toString(), null);
        return;
      }
      ta.a().g();
      if (!this.e.a(l)) {
        this.a.a(10000, "mUserStorage.setCurrentUserByUin failed", null);
      }
      System.currentTimeMillis();
      l = paramJSONObject.getInt("valid_time");
      ta.a().a(this.f, l);
      if (this.d.a.f.length() == 0)
      {
        localObject1 = this.d;
        paramJSONObject = paramJSONObject.optString("ksid");
        localObject1 = ((sc)localObject1).a;
        localObject2 = new ahe();
        localObject3 = new ContentValues();
        ((ContentValues)localObject3).put("ksid", paramJSONObject);
        ahi.a((ahk)localObject2, "ksid_data", (ContentValues)localObject3, "key=?", new String[] { String.valueOf(((ahe)localObject2).b) });
        ((rx)localObject1).f = paramJSONObject;
      }
      this.a.a = 0;
      return;
    }
    xb.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ud
 * JD-Core Version:    0.7.0.1
 */