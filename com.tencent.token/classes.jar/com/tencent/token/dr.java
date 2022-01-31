package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.LoginProtectResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class dr
  extends bm
{
  private long c;
  private LoginProtectResult d;
  private String e;
  private int f;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c; str == null; str = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("A2", this.e);
      ((JSONObject)localObject2).put("seq_id", this.f);
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
    return b.c() + "/cn/mbtoken3/mbtoken3_get_login_prot" + str;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.e = ((String)paramfs.c.get("param.wtlogin.a2"));
    this.f = ((Integer)paramfs.c.get("param.common.seq")).intValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      e.a("login protect: " + paramJSONObject);
      int i = paramJSONObject.getInt("err");
      if (i != 0)
      {
        a(i, paramJSONObject.getString("info"));
        return;
      }
      if (paramJSONObject.getInt("seq_id") != this.f)
      {
        this.a.a(10030, null, null);
        e.c("parseJSON error seq is wrong seq=" + paramJSONObject.getInt("seq_id") + ",right = " + this.f);
        return;
      }
      this.d = new LoginProtectResult(paramJSONObject);
      this.a.a = 0;
      return;
    }
    e.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.d;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dr
 * JD-Core Version:    0.7.0.1
 */