package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.dr;
import com.tencent.token.en;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoGetGameLockStatus
  extends e
{
  private long d;
  private int e;
  private dr f = dr.a();
  
  public static void a(ev paramev, long paramLong)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong));
  }
  
  protected String a()
  {
    Object localObject1 = null;
    String str = cv.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", this.d);
      int i = cw.a + 1;
      cw.a = i;
      this.e = i;
      ((JSONObject)localObject2).put("seq_id", this.e);
      ((JSONObject)localObject2).put("op_time", cx.c().s() / 1000L);
      localObject2 = ((JSONObject)localObject2).toString();
      h.a("plain:" + (String)localObject2);
      localObject2 = w.b(((String)localObject2).getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        h.c("JSONException:" + localJSONException.getMessage());
      }
    }
    localObject1 = "?aq_base_sid=" + str + "&data=" + (String)localObject1;
    return c.e() + "/cn/mbtoken3/mbtoken3_get_game_lock_status_v2" + (String)localObject1;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Long)paramev.c.get("param.uinhash")).longValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, null);
      return;
    }
    Object localObject = w.c(paramJSONObject.getString("data"));
    if (localObject != null)
    {
      localObject = new JSONObject(new String((byte[])localObject));
      i = ((JSONObject)localObject).getInt("seq_id");
      if (i != this.e)
      {
        this.a.b(10030);
        h.c("parseJSON error seq is wrong seq=" + i + ",right = " + cw.a().b());
        return;
      }
      long l = ((JSONObject)localObject).getLong("uin");
      if (l != this.d)
      {
        this.a.a(10000, "uin not match=" + l + ":" + this.d);
        return;
      }
      localObject = ((JSONObject)localObject).getJSONArray("result");
      if (!this.f.b((JSONArray)localObject))
      {
        this.a.a(10000, "update conf list failed:" + ((JSONArray)localObject).toString());
        return;
      }
      this.f.c.a(new String(paramJSONObject.toString()));
      this.f.c.e = true;
      this.f.c.f = false;
      this.a.c();
      return;
    }
    h.c("parseJSON error decodeData=" + localObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetGameLockStatus
 * JD-Core Version:    0.7.0.1
 */