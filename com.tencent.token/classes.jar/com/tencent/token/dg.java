package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dg
  extends bm
{
  private long c;
  private int d;
  private int e;
  private int f;
  private int g;
  private String h;
  private String i;
  private String j;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c;; str = null)
    {
      e.c("sessId=" + str);
      if (str != null) {
        break;
      }
      this.a.a(104, null, null);
      return null;
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("id", this.d);
      ((JSONObject)localObject2).put("guid", this.h);
      ((JSONObject)localObject2).put("appid", this.e);
      ((JSONObject)localObject2).put("subappid", this.f);
      ((JSONObject)localObject2).put("appname", this.i);
      ((JSONObject)localObject2).put("A2", this.j);
      ((JSONObject)localObject2).put("seq_id", this.g);
      ((JSONObject)localObject2).put("op_time", (int)(ag.c().r() / 1000L));
      localObject2 = s.b(((JSONObject)localObject2).toString().getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    str = "?uin=" + this.c + "&aq_base_sid=" + str + "&data=" + (String)localObject1;
    str = b.c() + "/cn/mbtoken3/mbtoken3_get_device_lock_status_v2" + str;
    e.c("get device lock status url =" + str);
    return str;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.d = ((Integer)paramfs.c.get("param.device.lock.id")).intValue();
    this.h = ((String)paramfs.c.get("param.device.lock.guid"));
    this.e = ((Integer)paramfs.c.get("param.device.lock.appid")).intValue();
    this.f = ((Integer)paramfs.c.get("param.device.lock.subappid")).intValue();
    this.i = ((String)paramfs.c.get("param.device.lock.appname"));
    this.j = ((String)paramfs.c.get("param.wtlogin.a2"));
    this.g = ((Integer)paramfs.c.get("param.common.seq")).intValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int k = 0;
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    int n;
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      int m = paramJSONObject.getInt("seq_id");
      if (m != this.g)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder().append("parseJSON error seq is wrong seq=").append(m).append(",right = ");
        af.a();
        e.c(af.b());
        return;
      }
      m = paramJSONObject.getInt("err");
      n = paramJSONObject.getInt("id");
      if (m != 0)
      {
        a(m, paramJSONObject.getString("info"));
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("result");
        if (n == 70)
        {
          ba.a().c(paramJSONObject);
          this.a.a = 0;
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        a(201, RqdApplication.i().getString(2131362290));
        paramJSONObject.printStackTrace();
        return;
      }
      if (n == 71) {
        ba.a().d(paramJSONObject);
      } else if ((n == 80) && (paramJSONObject != null) && (paramJSONObject.length() > 0)) {
        while (k < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(k);
          if (localJSONObject.getInt("id") == 71)
          {
            ba.a().a(localJSONObject);
          }
          else
          {
            localJSONObject.getInt("id");
            break label308;
            e.c("parseJSON error decodeData=" + paramJSONObject);
            a(10022, RqdApplication.i().getString(2131361799));
            return;
          }
          label308:
          k += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dg
 * JD-Core Version:    0.7.0.1
 */