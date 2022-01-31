package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class dz
  extends bm
{
  private long c;
  private int d;
  
  protected final String a()
  {
    Object localObject1 = null;
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c; str == null; str = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", this.c);
      int i = af.a + 1;
      af.a = i;
      this.d = i;
      ((JSONObject)localObject2).put("seq_id", this.d);
      ((JSONObject)localObject2).put("op_time", ag.c().r() / 1000L);
      localObject2 = ((JSONObject)localObject2).toString();
      e.a("plain:" + (String)localObject2);
      localObject2 = s.b(((String)localObject2).getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        e.c("JSONException:" + localJSONException.getMessage());
      }
    }
    str = "?aq_base_sid=" + str + "&data=" + localObject1;
    return b.c() + "/cn/mbtoken3/mbtoken3_query_real_uin_v2" + str;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, paramJSONObject, paramJSONObject);
      return;
    }
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getInt("seq_id");
      if (i != this.d)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder().append("parseJSON error seq is wrong seq=").append(i).append(",right = ");
        af.a();
        e.c(af.b());
        return;
      }
      this.a.a = 0;
      QQUser localQQUser = ax.a().c(this.c);
      if (localQQUser == null)
      {
        this.a.a(10000, null, null);
        return;
      }
      localQQUser.mRealUin = paramJSONObject.getLong("real_uin");
      localQQUser.mMobileMask = paramJSONObject.getString("mobile");
      return;
    }
    e.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dz
 * JD-Core Version:    0.7.0.1
 */