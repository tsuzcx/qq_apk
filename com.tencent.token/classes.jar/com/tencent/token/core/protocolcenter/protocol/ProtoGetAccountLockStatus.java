package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cs;
import com.tencent.token.dc;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoGetAccountLockStatus
  extends d
{
  private long d;
  private int e;
  private cs f = cs.a();
  
  public static void a(do paramdo, long paramLong)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong));
  }
  
  protected String a()
  {
    Object localObject1 = null;
    String str = ca.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", this.d);
      int i = cb.a + 1;
      cb.a = i;
      this.e = i;
      ((JSONObject)localObject2).put("seq_id", this.e);
      ((JSONObject)localObject2).put("op_time", cc.c().s() / 1000L);
      localObject2 = ((JSONObject)localObject2).toString();
      g.a("plain:" + (String)localObject2);
      localObject2 = l.b(((String)localObject2).getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        g.c("JSONException:" + localJSONException.getMessage());
      }
    }
    localObject1 = "?aq_base_sid=" + str + "&data=" + (String)localObject1;
    return c.e() + "/cn/mbtoken3/mbtoken3_get_ac_lock_status_v2" + (String)localObject1;
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.uinhash")).longValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, null);
      return;
    }
    Object localObject = l.c(paramJSONObject.getString("data"));
    if (localObject != null)
    {
      localObject = new JSONObject(new String((byte[])localObject));
      i = ((JSONObject)localObject).getInt("seq_id");
      if (i != this.e)
      {
        this.a.b(10030);
        g.c("parseJSON error seq is wrong seq=" + i + ",right = " + cb.a().b());
        return;
      }
      long l = ((JSONObject)localObject).getLong("uin");
      if (l != this.d)
      {
        this.a.a(10000, "uin not match=" + l + ":" + this.d);
        return;
      }
      localObject = ((JSONObject)localObject).getJSONArray("result");
      if (!this.f.a((JSONArray)localObject))
      {
        this.a.a(10000, "update conf list failed:" + ((JSONArray)localObject).toString());
        return;
      }
      this.f.b.a(new String(paramJSONObject.toString()));
      this.f.b.f = true;
      this.f.b.g = false;
      this.a.c();
      return;
    }
    g.c("parseJSON error decodeData=" + localObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetAccountLockStatus
 * JD-Core Version:    0.7.0.1
 */