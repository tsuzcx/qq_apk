package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class uw
  extends ud
{
  ajr d;
  private long e;
  private int f;
  private int g;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.e = ((Long)paramabm.c.get("param.uinhash")).longValue();
    this.f = ((Integer)paramabm.c.get("param.loginv2.clearkick")).intValue();
    this.g = paramabm.j;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    Object localObject1;
    if (i != 0)
    {
      if (i == 270)
      {
        localObject1 = aay.d(paramJSONObject.getString("data"));
        if (localObject1 != null)
        {
          Object localObject2 = new JSONObject(new String((byte[])localObject1));
          localObject1 = ((JSONObject)localObject2).optString("masked_mobile");
          String str = ((JSONObject)localObject2).optString("mSmsPrefix");
          localObject2 = new UpgradeDeterminResult();
          ((UpgradeDeterminResult)localObject2).mMobileMask = ((String)localObject1);
          ((UpgradeDeterminResult)localObject2).mSmsPrefix = str;
          this.a.d = localObject2;
        }
      }
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aay.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      xv.a("login_v2 ret: ".concat(String.valueOf(paramJSONObject)));
      i = paramJSONObject.getInt("seq_id");
      if (i != this.g)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.g);
        xv.c(paramJSONObject.toString());
        return;
      }
      long l = paramJSONObject.getLong("uin");
      tt.a();
      tt.a(paramJSONObject);
      if (l != this.e)
      {
        paramJSONObject = this.a;
        localObject1 = new StringBuilder("uin not match=");
        ((StringBuilder)localObject1).append(l);
        ((StringBuilder)localObject1).append(":");
        ((StringBuilder)localObject1).append(this.e);
        paramJSONObject.a(10000, ((StringBuilder)localObject1).toString(), null);
        return;
      }
      tt.a().g();
      if (!this.d.a(l)) {
        this.a.a(10000, "mUserStorage.setCurrentUserByUin failed", null);
      }
      System.currentTimeMillis();
      l = paramJSONObject.getInt("valid_time");
      tt.a().a(this.e, l);
      throw new NullPointerException();
    }
    xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493069));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.uw
 * JD-Core Version:    0.7.0.1
 */